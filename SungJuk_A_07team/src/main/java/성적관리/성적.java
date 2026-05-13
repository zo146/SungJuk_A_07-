package 성적관리;

public class 성적 {
    private String 학생id;
    private int 자바;
    private int DB;
    private int 보안;
    private int 총점;
    private double 평균;
    private String 학점;

    public String 성적입력(String 교수id, String 학생id, int 자바, int DB, int 보안) {
        교수 교수객체 = new 교수();
        
        // <<include>> 교수 권한 확인
        if (교수객체.교수체크(교수id)) {
            this.학생id = 학생id;
            this.자바 = 자바;
            this.DB = DB;
            this.보안 = 보안;
            
            // 총점과 평균 계산
            this.총점 = 자바 + DB + 보안;
            this.평균 = this.총점 / 3.0;
            
            return "성적이 정상적으로 입력되었습니다. (총점: " + this.총점 + ", 평균: " + String.format("%.2f", this.평균) + ")";
        } else {
            return "교수 인증에 실패하였습니다. (성적 입력 권한 없음)";
        }
    }

    public String 학점조회(String 교수id) {
        교수 교수객체 = new 교수();
        
        // <<include>> 교수 권한 확인
        if (교수객체.교수체크(교수id)) {
            // 학점 판정 로직
            if (this.평균 >= 90) {
                this.학점 = "A";
            } else if (this.평균 >= 80) {
                this.학점 = "B";
            } else {
                this.학점 = "C";
            }
            
            return "해당 학생(" + this.학생id + ")의 학점은 [" + this.학점 + "] 입니다.";
        } else {
            return "조회 권한이 없습니다. (교수 인증 실패)";
        }
    }
}