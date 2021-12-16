package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {
    private Object[] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    public ImmutableArrayList() {
        this.elements = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newArr = new Object[this.elements.length + 1];
        for (int i = 0; i < this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }
        newArr[this.elements.length] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newArr = new Object[this.elements.length + 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = this.elements[i];
        }
        newArr[index] = e;
        for (int i = index + 1; i < newArr.length; i++) {
            newArr[i] = this.elements[i - 1];
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newArr = new Object[c.length + this.elements.length];
        for (int i = 0; i < this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }
        for (int i = 0; i < c.length; i++) {
            newArr[i + this.elements.length] = c[i];
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArr = new Object[c.length + this.elements.length];
        for (int i = 0; i < index; i++) {
            newArr[i] = this.elements[i];
        }
        for (int i = 0; i < c.length; i++) {
            newArr[i + index] = c[i];
        }
        for (int i = 0; i < newArr.length - index - c.length; i++) {
            newArr[i + index + c.length] = this.elements[i + index];
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArr = new Object[this.elements.length - 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = this.elements[i];
        }
        for (int i = 0; i < this.elements.length - index; i++) {
            newArr[i + index - 1] = this.elements[i + index];
        }
        return new ImmutableArrayList(newArr);
    }


    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArr = new Object[this.elements.length];
        for (int i = 0; i < this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        int index = -1;
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] == e) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return this.elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 1 && this.get(0) == null;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[this.elements.length];
        for (int i = 0; i < this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }
        return newArr;
    }
}
