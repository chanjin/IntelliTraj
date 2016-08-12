

### Taxi Trip

* Utilization to understand economics of taxis
    - 택시가 손님을 태우고 있는 시간 비율
    - 이용률에 영향을 미치는 요인 중 하나는 손님의 목적지가 어딘가임
        - 점심시간 유니온스퀘어에 손님을 내려준 택시는 일 이분 후에 다른 손님을 태울 수 있다
        - 반면에 새벽 2시에 스태튼 아일랜드에 손님을 내려준 택시는 맨하튼까지 와야 다음 손님을 태울 수 있다
    - 목적지가 미치는 영향을 정량화하고 싶고 다음 손님을 태울 때까지의 평균 시간을 찾고 싶음
        - 함수: 손님을 내려준 곳의 구역 => 다음 손님을 태울 때까지의 시간
        - 구역의 예: Manhattan, Brooklyn, Queens, the Bronx, Staten Island, or none of the above
        - None: 뉴욕 외각 Newark International Airtport


* Data
    - trip_data_1.csv - 2.46GB
    ```
    $ mkdir taxidata
    $ cd taxidata
    $ wget https://nyctaxitrips.blob.core.windows.net/data/trip_data_1.csv.zip
    $ unzip trip_data_1.csv.zip
    $ head -n 10 trip_data_1.csv”
    ```

    -  Newyork Taxi Trip Data: http://www.andresmh.com/nyctaxitrips/

