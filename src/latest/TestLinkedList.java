package latest;

public class TestLinkedList{

    public static void main(String[] args) {

        LinkedList<String> friends = new LinkedList<>() ;

        friends.unshift("nico") ;
        friends.unshift("markits") ;
        friends.unshift("franz") ;
        friends.unshift("rodri") ;
        friends.unshift("fabri") ;

        System.out.println( friends.stringify()) ;

        System.out.println( friends.pop() );

        System.out.println( friends.stringify() );

        System.out.println( friends.shift() );

        System.out.println( friends.stringify() );

        friends.push("euge") ;
        friends.push("pepo") ;

        //expected: rodri , franz , markits , euge , pepo
        System.out.println( friends.stringify() );


        LinkedList<String> someFriends = friends.slice(1,4) ;

        System.out.println( someFriends.stringify() );

        LinkedList<String> friendsInvertidos = friends.reverse() ;

        System.out.println( friendsInvertidos.stringify() );


    }

}
