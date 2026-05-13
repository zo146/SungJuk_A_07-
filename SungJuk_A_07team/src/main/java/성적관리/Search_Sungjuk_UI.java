package 성적관리;

public class Search_Sungjuk_UI {
    private 성적 성적객체;

    public Search_Sungjuk_UI(성적 성적객체) {
        this.성적객체 = 성적객체;
    }

    public String 조회버튼클릭(String 교수id) {
        return 성적객체.학점조회(교수id);
    }
}