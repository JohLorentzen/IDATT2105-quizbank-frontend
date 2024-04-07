package quizbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quizbank.dto.QuestionDTO;
import quizbank.model.Question;
import quizbank.model.Quiz;
import quizbank.repository.QuestionRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDTO> toDto(List<Question> questions) {
        return questions.stream().map(this::toDto).collect(Collectors.toList());
    }


    public List<Question> toEntity(List<QuestionDTO> questionDTOs, Quiz quiz) {
        return questionDTOs.stream().map(dto -> {
            Question question = new Question();
            question.setId(dto.getQuestionId());
            question.setProblem(dto.getProblem());
            question.setSolution(dto.getSolution());
            question.setQuiz(quiz);
            question.setType(dto.getType());
            question.setChoices(dto.getChoices());
            question.setTags(dto.getTags());
            question.setImage(dto.getImage());
            return question;
        }).collect(Collectors.toList());
    }


    @Override
    public QuestionDTO toDto(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestionId(question.getId());
        questionDTO.setProblem(question.getProblem());
        questionDTO.setSolution(question.getSolution());
        questionDTO.setType(question.getType());
        questionDTO.setChoices((question.getChoices()));
        questionDTO.setTags(question.getTags());
        questionDTO.setImage(question.getImage());
        return questionDTO;
    }

    @Override
    public Set<String> getAllTags() {
        return questionRepository.findAll().stream().map(Question::getTags).flatMap(Set::stream).collect(Collectors.toSet());
    }
}
