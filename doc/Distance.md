### Distance between Trajectoies

궤도는 Seq of Points이고 두 궤도 간의 거리를 정의

* Edit Distance
    - 문자열 = Seq of Characters
    - In computer science, edit distance is a way of quantifying how dissimilar two strings (e.g., words) are to one another by counting the minimum number of operations required to transform one string into the other.
    - 두 문자열이 서로 얼마나 다른가를 정의 = 거리
    - 한 문자열에서 다른 문자열로 변환하기 위해 필요한 오퍼레이션의 최소 갯수
    - Replace, Delete, Insert
    - e.g. a와 b 사이는 거리 1, abc와 def 사이는 3


* Dynamic Programming
    - Let dp[i][j] stands for the edit distance between two strings with length i and j, i.e., word1[0,...,i-1] and word2[0,...,j-1].
      There is a relation between dp[i][j] and dp[i-1][j-1]. Let's say we transform from one string to another. The first string has length i and it's last character is "x"; the second string has length j and its last character is "y". The following diagram shows the relation.
    - dp[i][j]는 길이가 i, j인 두 문자열 간의 Edit 거리를 의미
    - word1 0 ~ i-1, word2 0 ~ j-1


* 문제


