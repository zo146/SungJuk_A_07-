```mermaid
sequenceDiagram
    autonumber
    actor Prof as 교수
    participant UI as <<boundary>> : Add_Sungjuk_UI
    participant Sjuk as 성적
    participant Pcheck as 교수

    Prof->>+UI: 입력버튼클릭 (교수id, 학생id, 자바, DB, 보안)
    
    UI->>+Sjuk: 성적입력(교수id, 학생id, 자바, DB, 보안)
    
    Note over Sjuk, Pcheck: [include] 교수 권한 확인
    Sjuk->>+Pcheck: 교수체크(교수id)
    Pcheck-->>-Sjuk: 결과 반환 (true/false)

    alt 교수id가 "inha"인 경우
        Sjuk->>Sjuk: 총점 계산 (자바 + DB + 보안)
        Sjuk->>Sjuk: 평균 계산 (총점 / 3)
        Sjuk-->>UI: 성적 입력 완료
        UI-->>Prof: "성적이 정상적으로 입력되었습니다."
    else 교수id 불일치
        Sjuk-->>UI: 에러 메시지 (권한 없음)
        UI-->>-Prof: "교수 인증에 실패하였습니다."
    end
    deactivate Sjuk