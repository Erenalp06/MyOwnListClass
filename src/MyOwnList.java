import java.util.Arrays;

public class MyOwnList<T> {

    private final Integer ARRAY_LENGHT = 10;
    private int i = 0;

    private Object[] objArray;

    public MyOwnList() {
        objArray = new Object[ARRAY_LENGHT];
    }

    public MyOwnList(Integer capacity) {
        objArray = new Object[capacity];
    }

    T getArray(int k){
        return (T) objArray[k];
    }

    void add(T value){
        if(i == objArray.length){
            objArray = Arrays.copyOf(objArray, objArray.length * 2);
        }
        objArray[i] = value;
        i++;
    }

    public Integer getCapacity(){
        return objArray.length;
    }

    // dizideki eleman sayısını verir.
    public Integer size(){
        int count = -1;
        for(int i = 0; i < objArray.length; i++){
            if(objArray[i] == null){
                break;
            }
            count++;

        }
        return count + 1;
    }

    public T get(int index){
        return (T) objArray[index];
    }

    public T remove(int index){
        if(!(index < objArray.length && index >= 0)){
            return null;
        }

        int temp2 = index;
        for(int i = 0; i < objArray.length; i++){
            if(i == index){
                for(int j = 0; j < (objArray.length - 1) - index; j++){
                    T temp = (T)objArray[index+1];
                    objArray[index] = objArray[index + 1];
                    index++;
                }


            }
        }
        i--;
        return (T)objArray[temp2];
    }

    public T set(int index, T data){
        boolean isExist = false;
        if(index < objArray.length && index >= 0){
            objArray[index] = data;
        }else{
            return null;
        }
        return (T) objArray[index];
    }

    public Integer indexOf(T data){
        for(int i = 0; i < objArray.length; i++){
            if(objArray[i] == data){
                return i;
            }
        }
        return -1;
    }

    public Integer lastIndexOf(T data){
        int index = 0;
        for(int i = 0; i < objArray.length; i++){
            if(objArray[i] == data){
                index = i;
            }
        }
        if(index == 0){
            return -1;
        }
        return index;
    }

    public boolean isEmpty(){
        return objArray[0] == null;
    }

    public T[] toArray(){
        return (T[]) objArray;
    }

    public void clear(){
        for(int i = 0; i < objArray.length; i++){
            objArray[i] = null;
        }
    }

    public MyOwnList<T> subList(int start, int finish){
        //Object[] arrayTemp = new Object[finish - start + 1];
        MyOwnList<T> list = new MyOwnList<>();
        for(int i = 0; i<finish - start + 1; i++){
            list.add((T)objArray[i]);
        }
        return list;
    }

    boolean contains(T data){
        for(int i = 0; i < objArray.length; i++){
            if(data == objArray[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyOwnList{" +
                "objArray=" + Arrays.toString(objArray) +
                '}';
    }
}
