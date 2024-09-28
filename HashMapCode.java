import java.util.*;
public class HashMapCode {
    static class HashMap<K,V> {
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.size=0;
            this.buckets=new LinkedList[4];
            for(int i=0; i<4;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc=key.hashCode();
            return Math.abs(hc)%size;
        }
        public void put(K key, V value){
            int bi=hashFunction(key;
            int di=SearchInLL(key));
        }
        
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[4];
            for (int i=0; i<4; i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi)% N;
        }
    }
}
   