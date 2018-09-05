/**
 * @(#)PieceTester.java
 *
 *
 * @author 
 * @version 1.00 2018/5/11
 */
package tuyotuyo;

public class PieceTester
{
    public static void main(String[] args)
    {
    	for(int i = 0; i < 20; i++)
    	{
    		Piece a = new Piece();
    		System.out.println(a.toString());
    		a.rotate();
    		System.out.println(a.toString());
    		a.rotate();
    		System.out.println(a.toString());
    		a.rotate();
    		System.out.println(a.toString());
    		a.rotate();
    		System.out.println(a.toString());
    		System.out.println("--------------------------------------------");
    	}
    }
}
