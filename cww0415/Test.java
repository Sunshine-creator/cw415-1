package cww0415;

import java.util.Comparator;

public class Test {
    static class cardCompare implements Comparable<cardCompare>{            //对象比较.泛型参数，比较大小
        public  String rank;
        public String suits;
        public cardCompare(String rank, String suits) {
            this.rank = rank;
            this.suits = suits;
        }

        @Override
        public int compareTo(cardCompare o) {
            if(o==null){   //这里默认直接返回大于0的数
                return 1;
            }
            int rank1 =  this.getVaule();
            int rank2 =  o.getVaule();
            return rank1-rank2;   //在这里比较两个对象的大小,this比o小，返回小于0的数
        }

        private int getVaule() {   //String转化为int
            int vaule = 0;
            if("J".equals(rank)){
                vaule =11;
            }else if("Q".equals(rank)){
                vaule = 12;
            }else if("K".equals(rank)){
                vaule =  13;
            }else if("A".equals(rank)){
                vaule =  14;
            }else {
                vaule = Integer.parseInt(rank);
            }
            return vaule;
        }

        @Override
        public boolean equals(Object obj) {      //
            if(this==obj){   //1
                return true;
            }
            if(obj==null){  //2
                return  false;
            }
            if(!(obj instanceof cardCompare)){  //3
                return  false; //比较类型
            }
            cardCompare others = (cardCompare)(obj);   //4真正比较
            return this.equals(rank) && this.equals(suits);
        }
        static class Compare implements Comparator<cardCompare>{   //耦合度比较小
            @Override
            public int compare(cardCompare o1, cardCompare o2) {    //进行比较
                if(o1==o2){
                    return 0;
                }
                if(o1==null){
                    return -1;
                }
                if(o2==null){
                    return 1;
                }
                int vaule1 =  o1.getVaule();
                int vaule2 =  o2.getVaule();
                return vaule1- vaule2;
            }
        }
    }
    public static void main(String[] args) {
        cardCompare p =  new cardCompare("3","♥");
//        Card q = new Card("3","♠");
        cardCompare x = new cardCompare("3","♥");
        cardCompare o=p;
        System.out.println(p.compareTo(x));
        System.out.println(p.compareTo(o));
        System.out.println("******************");
        cardCompare compare = new cardCompare();
          compare.
        System.out.println();
//        System.out.println(p==o); //指向同一个对象
////        System.out.println(q==o);
//        System.out.println(p==x);//new了两个不同的对象
//        System.out.println("**********");
//        System.out.println(p.equals(x));
//        System.out.println(p.equals(o));
    }
}
