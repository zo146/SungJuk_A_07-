```mermaid
classDiagram
    class Add_Sungjuk_UI {
        <<boundary>>
        +입력버튼클릭() void
    }

    class Search_Sungjuk_UI {
        <<boundary>>
        +조회버튼클릭() void
    }

    class 교수 {
        -교수id: String
        +교수체크(교수id: String) boolean
    }

    class 성적 {
        -학생id: String
        -자바: int
        -DB: int
        -보안: int
        -총점: int
        -평균: double
        -학점: String
        +성적입력(교수id: String, 학생id: String, 자바: int, DB: int, 보안: int) void
        +학점조회(교수id: String) String
    }

    %% 유스케이스의 관계를 클래스 수준에서 정의
    Add_Sungjuk_UI ..> 성적 : "성적입력 요청"
    Search_Sungjuk_UI ..> 성적 : "학점조회 요청"
    
    %% <<include>> 관계 반영: 성적 처리는 반드시 교수체크에 의존함
    성적 ..> 교수 : "<<use>> 교수체크"