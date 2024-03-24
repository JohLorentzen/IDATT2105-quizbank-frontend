package quizbank.service;

import quizbank.dto.QuizDTO;
import quizbank.model.Quiz;

import java.util.List;

public interface QuizService {
    QuizDTO toDto(Quiz quiz);

    Quiz toEntity(QuizDTO quizDTO);

    List<Quiz> getQuizzesCreatedByUserId(Long userId);

    List<QuizDTO> getAllQuizzes();

    QuizDTO createOrUpdateQuiz(QuizDTO quiz);

    void deleteQuiz(Long quizId);

    QuizDTO getQuizById(Long quizId);
}