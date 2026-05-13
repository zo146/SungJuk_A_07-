<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="성적관리.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>성적 처리 시스템 (SungJuk_B_01팀)</title>
</head>
<body>
    <h2>성적 처리 시스템 실행 결과</h2>
    <hr>
    <%
        // 1. 공통 성적 객체 생성 (데이터 유지를 위해 동일한 객체를 UI에 주입)
        성적 gradeData = new 성적();
        
        // 2. UI 객체 생성
        Add_Sungjuk_UI addUI = new Add_Sungjuk_UI(gradeData);
        Search_Sungjuk_UI searchUI = new Search_Sungjuk_UI(gradeData);

        // 테스트 케이스 1: 정상적인 교수(inha)가 성적을 입력하고 조회하는 경우
        out.println("<h3>[정상 케이스 테스트]</h3>");
        String addResult1 = addUI.입력버튼클릭("inha", "student101", 95, 85, 90); // 평균 90
        out.println("<p>입력 결과: " + addResult1 + "</p>");
        
        String searchResult1 = searchUI.조회버튼클릭("inha");
        out.println("<p>조회 결과: " + searchResult1 + "</p>");

        out.println("<hr>");

        // 테스트 케이스 2: 잘못된 교수 ID(other)로 시도하는 경우
        out.println("<h3>[권한 실패 케이스 테스트]</h3>");
        String addResult2 = addUI.입력버튼클릭("other", "student102", 100, 100, 100);
        out.println("<p>입력 결과: " + addResult2 + "</p>");
        
        String searchResult2 = searchUI.조회버튼클릭("wrongId");
        out.println("<p>조회 결과: " + searchResult2 + "</p>");
    %>
</body>
</html>