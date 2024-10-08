package quiz_project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz_project.demo.model.Questions;
import quiz_project.demo.model.Quiz;
import quiz_project.demo.repository.QuizRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public void editQuizById(Long id, Quiz NewQuiz) {
        Quiz OldQuiz = quizRepository.findById(id).orElse(null);
        if(OldQuiz != null)
        {
            OldQuiz.setTitle(NewQuiz.getTitle());
            OldQuiz.setVisibility(NewQuiz.getVisibility());
            OldQuiz.setCreated_at(LocalDateTime.from(LocalDateTime.now()));
            quizRepository.save(OldQuiz);
        }
    }

    public Quiz saveQuiz (Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public void toggleVisibilityQuizById (Long id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        if(quiz.getVisibility()==true) {
            quiz.setVisibility(false);
            quizRepository.save(quiz);
        }
        else if (quiz.getVisibility()==false){
            quiz.setVisibility(true);
            quizRepository.save(quiz);
        }

    }

}

