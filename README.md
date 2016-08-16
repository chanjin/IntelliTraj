# IntelliTraj
Trajectory Data Analysis 

### Example from Book "Advanced Analytics with Spark"
##### Sandy Ryza, Uri Laserson, Sean Owen, and Josh Wills. ‘Advanced Analytics with Spark.’

[Taxi Trip Data] (./doc/NewYork_TaxiTrip.md)

#### GeoJson
- GeoJSON is a format for encoding a variety of geographic data structures.
    - http://geojson.org/
    - Point 표현
    ```
    {
      "type": "Feature",
      "geometry": {
        "type": "Point",
        "coordinates": [125.6, 10.1]
      },
      "properties": {
        "name": "Dinagat Islands"
      }
    }
    ```
    - GeoJSON supports the following geometry types: Point, LineString, Polygon, MultiPoint, MultiLineString, and MultiPolygon. Geometric objects with additional properties are Feature objects. Sets of features are contained by FeatureCollection objects.
    - Full Specification: http://geojson.org/geojson-spec.html
    - GeoJSON Format: https://datatracker.ietf.org/doc/rfc7946/

#### 관련 코드
[Code Snippet](./doc/Code_Snippet.md)

#### 코드 구조
* advspark_clouder
    * Advanced Analytics with Spark 책의 예
    * 뉴욕 택시 트립 데이터를 분석
    * 택시를 타는 장소에 따라서 택시 사용률이 영향 받음을 데이터로 보여줌
* basics.distance
    * 일반적인 거리 측정 코드
    * 궤도 간의 거리를 정의
    * Edit Distance
* trajectorymining
    * 궤도 분석 코드를 구현
    * Noise Filtering, Map Matching 등 궤도 분석을 위해 필요한 알고리즘을 구현
    * 먼저, Point를 Grid로 매핑하여 Grid 간의 유입률 등을 계산함
    * GeoLife의 데이터 셋으로 실험함
