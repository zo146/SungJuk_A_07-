package 성적관리;

public class 교수 {
    private String 교수id;

    public boolean 교수체크(String 입력된교수id) {
        // 요구사항: 교수id는 반드시 "inha"여야 함
        return "inha".equals(입력된교수id);
    }
}