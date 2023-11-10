package domain;

import java.util.Vector;

public class ExtendedIteratorEvents implements ExtendedIterator<Event> {
	
	private int pos;
	private Vector<Event> lista;

	
	public ExtendedIteratorEvents (Vector<Event> list) {
		
		this.lista=list;
		this.pos = 0;
	}
	

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (this.pos <= this.lista.size()-1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
		this.pos++;
		return this.lista.get(this.pos-1);
	}

	@Override
	public Event previous() {
		// TODO Auto-generated method stub
		Event unekoa = this.lista.get(pos);
		this.pos--;
		return unekoa;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		if (this.pos >= 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void goFirst() {
		// TODO Auto-generated method stub
		this.pos=0;
	}

	@Override
	public void goLast() {
		// TODO Auto-generated method stub
		this.pos = this.lista.size()-1;
	}

}
