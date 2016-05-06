package fr.canm.cyrilstern1.cnamtp9;

/**
 * Created by cyrilstern1 on 06/05/2016.
 */
public abstract class ChainHandler<T>{
    protected ChainHandler<T> successor = null;

    public ChainHandler(){ this.successor = null;}
    public ChainHandler(ChainHandler<T> successor){ this.successor = successor;}
    public void setSuccessor(ChainHandler<T> successor){this.successor = successor;}
    public ChainHandler<T> getSuccessor(){return this.successor;}
    public boolean handleRequest(T value){
        if ( successor == null )  return false;
        return successor.handleRequest(value);
    }
}
