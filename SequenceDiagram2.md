```mermaid
sequenceDiagram
    autonumber
    actor Prof as 교수
    participant UI as <<boundary>> : Search_Sungjuk_UI
    participant Sjuk as 성적
    participant Pcheck as 교수

    Prof->>+UI: 조회버튼클릭 (교수id)
    
    UI->>+Sjuk: 학점조회(교수id)
    
    Note over Sjuk, Pcheck: [include] 교수 권한 확인
    Sjuk->>+Pcheck: 교수체크(교수id)
    Pcheck-->>-Sjuk: 결과 반환 (true/false)

    alt 교수id가 "inha"인 경우
        Note over Sjuk: 학점 부여 로직 실행
        critical 학점 판정
            option 평균 >= 90
                Sjuk->>Sjuk: 학점 = "A"
            option 평균 >= 80
                Sjuk->>Sjuk: 학점 = "B"
            option 평균 < 80
                Sjuk->>Sjuk: 학점 = "C"
        end
        Sjuk-->>UI: 학점 결과 반환
        UI-->>Prof: 해당 학생의 학점 표시
    else 교수id 불일치
        Sjuk-->>UI: 조회 실패 반환
        UI-->>-Prof: "조회 권한이 없습니다."
    end
    deactivate Sjuk