### GeoLife Project
* Data
    * https://www.microsoft.com/en-us/download/details.aspx?id=52367
    * Name: Geolife Trajectories 1.3.zip
* 설명
    * GPS Trajectory dataset
    * 마이크로소프트 아시아 연구소에서 수집
    * 182명의 사용자 2007년 4월부터 2012년 8월까지
    * 2012년에 공개
    * 타임스탬프가 있는 위치점들의 시퀀스
    * 위도 (Latitude), 경도 (Longitude), 고도 (Altitude)
    * 참고 위도 경도로 위치 보기
        * http://www.latlong.net/Show-Latitude-Longitude.html
    * 궤도 수 17,621, 전체 1,292,951 킬로미터, 전체 50,176 시간
    * 다른 GPS 로깅 기기와 폰으로 측정됨
    * 91.5%의 궤도가 Dense 표현으로 로깅됨. 예) 매 1 ~ 5초, 매 5 ~ 10 미터 단위로
    * Life Routines - 집으로 귀가, 스포츠 활동, 쇼핑, 식사, 하이킹, 사이클링, ...
    * 사용자 활동 인지, 위치 기반 소셜 네트워크, 위치 추천 등
    * 중국의 30개 도시. USA & Europe. 대부분의 데이터는 중국 베이징
* 데이터 포맷

    ```
    PLT format:
      Line 1...6 are useless in this dataset, and can be ignored. Points are described in following lines, one for each line.
      Field 1: 위도 Latitude in decimal degrees.
      Field 2: 경도 Longitude in decimal degrees.
      Field 3:     All set to 0 for this dataset.
      Field 4: 고도 Altitude in feet (-777 if not valid).
      Field 5: 날짜 Date - number of days (with fractional part) that have passed since 12/30/1899.
      Field 6: 날짜 Date as a string.
      Field 7: 시간 Time as a string.
      Note that field 5 and field 6&7 represent the same date/time in this dataset. You may use either of them.
      Example:
      39.906631,116.385564,0,492,40097.5864583333,2009-10-11,14:04:30
      39.906554,116.385625,0,492,40097.5865162037,2009-10-11,14:04:35
    ```
    이동 수단 레이블
    ```
    Example:
    Start Time          End Time            Transportation Mode
    2008/04/02 11:24:21 2008/04/03 01:07:03 bus
    2008/04/03 11:32:24 2008/04/03 11:47:14 train
    2008/04/02 11:50:45 2008/04/03 11:31:55 walk
    2008/04/03 11:46:14 2008/04/03 11:55:07 car
    ```
* 디렉터리
    * ${User ID}/Trajectory/${Trajectory Session}.plt
    * 예) 000/Trajectory/20090601082932.plt