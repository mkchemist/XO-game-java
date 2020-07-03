/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo.app;

/**
 * BoardCell class
 * that hold all information about every board 
 * single cell
 * 
 * @author mk_ch
 */
public class BoardCell {
    /**
     * cell number
     * 
     * @var integer
     */
    int id;
    /**
     * cell string X|O
     * 
     * @var String
     */
    String val;
    /**
     * check if the cell is locked
     * 
     * @var boolean
     */
    boolean isLocked;
    /**
     * Cell owner name
     * 
     */
    String owner;
    
    /**
     * BoardCell constructor
     * 
     * 
     * @param id 
     */
    public BoardCell(int id) {
        this.id = id;
        this.val = null;
        this.isLocked = false;
        this.owner = null;
    }
    
    /**
     * get cell id
     * 
     * @return integer
     */
    public int getId() {
        return id;
    }
    
    /**
     * set cell id
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * get cell value 
     * 
     * @return String
     */
    public String getVal() {
        return val;
    }
    
    /**
     * set cell value
     * 
     * @param val 
     */
    public void setVal(String val) {
        this.val = val;
    }
    
    /**
     * check if the cell is locked
     * 
     * @return boolean
     */
    public boolean isLocked() {
        return isLocked == true;
    }

    public void lock() {
        this.isLocked = true;
    }
    
    /**
     * get cell owner
     * 
     * @return String
     */
    public String getOwner() {
        return owner;
    }
    
    /**
     * set cell owner name
     * 
     * @param owner 
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
}
