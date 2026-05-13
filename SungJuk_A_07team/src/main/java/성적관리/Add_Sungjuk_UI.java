package 성적관리;

public class Add_Sungjuk_UI {
    private 성적 성적객체;

    // 성적 상태를 공유하기 위해 생성자로 성적 객체를 주입받습니다.
    public Add_Sungjuk_UI(성적 성적객체) {
        this.성적객체 = 성적객체;
    }

    // 시퀀스 다이어그램에 명시된 파라미터를 받아 전달합니다.
    public String 입력버튼클릭(String 교수id, String 학생id, int 자바, int DB, int 보안) {
        // 성적 클래스에 성적입력을 요청하고, 결과를 문자열로 반환받아 JSP 화면에 출력할 수 있게 합니다.
        return 성적객체.성적입력(교수id, 학생id, 자바, DB, 보안);
    }
}