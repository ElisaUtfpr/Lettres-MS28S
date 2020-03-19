package org.evertree.lettres.action;

import org.evertree.lettres.piece.Block;

public class VerticalWord extends Word {

    public VerticalWord(String word, Block[] blocks) {
	super(word, blocks);
    }

    @Override
    public boolean validate() {
	if (blocks == null || blocks.length == 0) {
	    return false;
	}
	if (blocks.length == 1) {
	    return true;
	}
	Block last = blocks[0];
	for (int i = 1; i < blocks.length; i++) {
	    if (!blocks[i].isInTheSameSpace(last)) {
		return false;
	    }
	    if (blocks[i].getY() != last.getY() + 1
		    || blocks[i].getX() != last.getX()) {
		return false;
	    }
	    last = blocks[i];
	}
	return true;
    }

}
