package quiz_project.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer_text")
    private String answer_text;

    @Column(name = "is_correct")
    private boolean is_correct;

    @Column(name = "created_at")
    private String created_at;

    @ManyToOne
    Questions question_id;

    @OneToMany
    Score scores;


    //Constructor

    public Answer(Long id, String answer_text, boolean is_correct, String created_at, Questions question_id) {
        this.id = id;
        this.answer_text = answer_text;
        this.is_correct = is_correct;
        this.created_at = created_at;
        this.question_id = question_id;
    }


    // Getters e Setters

    public Long getId() {
        return id;
    }

    public Answer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public Answer setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
        return this;
    }

    public boolean getIs_correct() {
        return is_correct;
    }

    public Answer setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Answer setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }

    public Questions getQuestion_id() {
        return question_id;
    }

    public Answer setQuiz_id(Questions question_id) {
        this.question_id = question_id;
        return this;
    }
}