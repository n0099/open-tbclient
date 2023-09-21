package com.googlecode.mp4parser.util;
/* loaded from: classes9.dex */
public class IntHashMap {
    public transient int count;
    public float loadFactor;
    public transient Entry[] table;
    public int threshold;

    /* loaded from: classes9.dex */
    public static class Entry {
        public int hash;
        public int key;
        public Entry next;
        public Object value;

        public Entry(int i, int i2, Object obj, Entry entry) {
            this.hash = i;
            this.key = i2;
            this.value = obj;
            this.next = entry;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public synchronized void clear() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.count = 0;
            } else {
                entryArr[length] = null;
            }
        }
    }

    public boolean isEmpty() {
        if (this.count == 0) {
            return true;
        }
        return false;
    }

    public void rehash() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        int i = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i];
        this.threshold = (int) (i * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            Entry entry = entryArr[i2];
            while (entry != null) {
                Entry entry2 = entry.next;
                int i3 = (entry.hash & Integer.MAX_VALUE) % i;
                entry.next = entryArr2[i3];
                entryArr2[i3] = entry;
                entry = entry2;
            }
            length = i2;
        }
    }

    public int size() {
        return this.count;
    }

    public IntHashMap(int i) {
        this(i, 0.75f);
    }

    public boolean contains(Object obj) {
        if (obj != null) {
            Entry[] entryArr = this.table;
            int length = entryArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                for (Entry entry = entryArr[i]; entry != null; entry = entry.next) {
                    if (entry.value.equals(obj)) {
                        return true;
                    }
                }
                length = i;
            }
        } else {
            throw null;
        }
    }

    public boolean containsKey(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public Object get(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i) {
                return entry.value;
            }
        }
        return null;
    }

    public Object remove(int i) {
        Entry[] entryArr = this.table;
        int length = (Integer.MAX_VALUE & i) % entryArr.length;
        Entry entry = null;
        for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.next) {
            if (entry2.hash == i) {
                if (entry != null) {
                    entry.next = entry2.next;
                } else {
                    entryArr[length] = entry2.next;
                }
                this.count--;
                Object obj = entry2.value;
                entry2.value = null;
                return obj;
            }
            entry = entry2;
        }
        return null;
    }

    public IntHashMap(int i, float f) {
        if (i >= 0) {
            if (f > 0.0f) {
                i = i == 0 ? 1 : i;
                this.loadFactor = f;
                this.table = new Entry[i];
                this.threshold = (int) (i * f);
                return;
            }
            throw new IllegalArgumentException("Illegal Load: " + f);
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i);
    }

    public Object put(int i, Object obj) {
        Entry[] entryArr = this.table;
        int i2 = Integer.MAX_VALUE & i;
        int length = i2 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
            if (entry.hash == i) {
                Object obj2 = entry.value;
                entry.value = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            entryArr = this.table;
            length = i2 % entryArr.length;
        }
        entryArr[length] = new Entry(i, i, obj, entryArr[length]);
        this.count++;
        return null;
    }
}
