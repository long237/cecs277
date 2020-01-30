/*Name: Long & Selina Do
 * Date: 01/28/20
 * Purpose: Play a War of Card games between players
 * Inputs: Required the user to provide how many players are playing
 * Output: Bunch of strings
 */
public class cardWarTester{
        public static void main(String[] args){
		
        /*ArrayList<String> array1 = new ArrayList<String>(5);
        array1.add("hi");
        array1.add("base");
        array1.add("nice");
        array1.add("change");
        array1.add("noice");
        array1.add("hello");

        List<String> sub1 = array1.subList(0,3);
        System.out.println(sub1);
        System.out.println(array1);
        sub1.add("test");
        System.out.println(sub1);
        System.out.println(array1);*/

        DeckofCard hand1 = new DeckofCard(5);
        Card card1 = new Card();
        Card card2 = new Card(2, "space");

        Card card3 = new Card(3, "space");
        Card card4 = new Card(4, "space");
        Card card5 = new Card(5, "space");
        Card card6 = new Card(6, "space");
        Card card7 = new Card(7, "space");
        Card card8 = new Card(8, "space");
        Card card9 = new Card(9, "space");
        hand1.add(card1);
        hand1.add(card2);
        hand1.add(card3);
        hand1.add(card4);
        hand1.add(card5);
        hand1.add(card6);
        hand1.add(card7);
        hand1.add(card8);
        hand1.add(card9);
        System.out.println(hand1.size());
        ArrayList<DeckofCard> arr1 = hand1.deal(2);
        System.out.println(hand1.deal(2).size());
        System.out.println(arr1);
        System.out.println(card4);
	}

}
