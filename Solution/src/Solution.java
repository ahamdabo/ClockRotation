
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] A, int P) {
        
        	        	
            int result = 0;
            
            Map<int[], Integer> elements = new HashMap<int[], Integer>();
           
            elements.put (A[0],0);

            boolean flgFind = false;
            for (int[] oneClock : A)
            {
                flgFind = false;
                for (int[] element : elements.keySet())
                {
                    if (mEqual(oneClock, element,P) == true)
                    { elements.put(element, elements.get(element)+1);
                      
                        flgFind = true;
                        break;
                    }
                }
                if(flgFind == false)
                	elements.put(oneClock, 1);

            }

            //calculate the total pairs
            for (int k : elements.values())  result += k * (k - 1) / 2;

            return result;
        
        
    }
    
    
    
        static boolean mEqual(int[] source, int[] target, int P)
        {
            boolean flgJ = false;
            int hands = source.length;
            for (int i = 0; i < hands; i++)
            {
                int subValue = target[0] - source[i];

                flgJ = false;
                for (int j = 0; j < hands; j++)
                {
                    int newS = source[(i + j) % hands] + subValue;
                    if (newS <= 0)
                        newS += P;
                    if (newS != target[j])
                    {
                        flgJ = true;
                        break;
                    }
                }
              
                if (flgJ == false)
                    return true;
            }
            return false;
        }
}
