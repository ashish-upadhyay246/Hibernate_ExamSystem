package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {
	
	@Id
	int questionId;
	@Column
	String questionText;
	@Column
	String correctAnswer;
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Question(int questionId, String questionText,  String optionA, String optionB,
			String optionC, String optionD,String correctAnswer) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}

	public String getQuestionText() {
		return questionText;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", correctAnswer="
				+ correctAnswer + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + "]";
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	@Column
	String optionA;
	@Column
	String optionB;
	
	@Column
	String optionC;
	
	@Column
	String optionD;
	

}