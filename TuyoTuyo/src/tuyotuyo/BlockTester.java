/**
 * @(#)BlockTester.java
 *
 *
 * @author 
 * @version 1.00 2018/5/11
 */
package tuyotuyo;

public class BlockTester
{
    public static void main(String[] args)
    {
    	for(int i = 0; i < 20; i++)
    	{
    		Block a = new Block();
    		System.out.println(a.getColor());
    	}
    }
}
