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

