// https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
// 깊이/너비 우선 탐색(DFS/BFS)
// 타겟 넘버


// n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3
// 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
// 각 숫자는 1 이상 50 이하인 자연수입니다.
// 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
// 입출력 예
// numbers	target	return
// [1, 1, 1, 1, 1]	3	5
// 입출력 예 설명
// 문에 나온 예와 같습니다.


class Solution {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		// 이진법을 사용하여 부호를 정함
		// numbers 배열 크기가 5이면 이진법으로 00000 ~11111을 만든다
		int allCase = (int)Math.pow(2, numbers.length);
		int numLen = numbers.length;
		
		for(int i=0; i<allCase; i++) {
			int sum = 0;
			String tail = Integer.toBinaryString(i);
			String head = "00000000000000000000";   // numbers 배열 최대 20개까지
            String sign = head.substring(0, numLen - tail.length()) + tail;
            
			for(int j=0; j<numLen; j++) {
				if(sign.charAt(j)=='0') {
					sum -= numbers[j];
				} else {
					sum += numbers[j];
				}
			}
			if(sum == target) {
				answer++;
			}
		}
		return answer;
	}
}

