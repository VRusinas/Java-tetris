package tetrisblocks;

import tetris.TetrisBlock; // nes kitam package 

public class IShape extends TetrisBlock 
{
    public IShape() // runtime polymorthism?
    {
        super( new int[][]{{1,1,1,1}}); //naudojam super kaip metoda ir passinam per ji array of int arrays 
        //callina TetrisBlock klase 
        //taip prieinam priavte kintamuosius 
    }
}
