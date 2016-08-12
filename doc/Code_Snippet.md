
### 부적절한 레코드 처리

* safe 함수
    - 이름 없는 함수를 리턴함
    - S와 T라는 타입을 타입 인자로 받음
    - 함수 f: S => T를 인자로 받아서, S => Either[T, (S, Exception)]를 리턴함
    - 예외가 발생하면, f는 Exeption을 발생시키지만 새로운 safe 함수는 Exception을 처리해서 (S, Exception)을 리턴해줌

    ```scala
    def safe[S, T](f: S => T): S => Either[T, (S, Exception)] = {
      new Function[S, Either[T, (S, Exception)]] with Serializable {
        def apply(s: S): Either[T, (S, Exception)] = {
          try {
            Left(f(s))
          } catch {
            case e: Exception => Right((s, e))
          }
        }
      }
    }
    ```

    - safe 함수의 사용

        - parse를 수행한 다음, 예외 발생하면 Right에 채우고, 성공적이면 Left에 채움
        - isLeft는 Either 타입의 메소드

    ```scala
    val safeParse = safe(parse)
    val taxiParsed = taxiRaw.map(safeParse)
    taxiParsed.cache()

    taxiParsed.map(_.isLeft).countByValue().foreach(println)

    (false,87)
    (true,14776529)
    ```

    -


