package com.googlecode.mp4parser.util;
/* loaded from: classes2.dex */
public class IntHashMap {
    private transient int count;
    private float loadFactor;
    private transient a[] table;
    private int threshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        int hZI;
        a hZJ;
        int key;
        Object value;

        protected a(int i, int i2, Object obj, a aVar) {
            this.hZI = i;
            this.key = i2;
            this.value = obj;
            this.hZJ = aVar;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public IntHashMap(int i) {
        this(i, 0.75f);
    }

    public IntHashMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Illegal Load: " + f);
        }
        i = i == 0 ? 1 : i;
        this.loadFactor = f;
        this.table = new a[i];
        this.threshold = (int) (i * f);
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                for (a aVar = aVarArr[i]; aVar != null; aVar = aVar.hZJ) {
                    if (aVar.value.equals(obj)) {
                        return true;
                    }
                }
                length = i;
            } else {
                return false;
            }
        }
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public boolean containsKey(int i) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.hZJ) {
            if (aVar.hZI == i) {
                return true;
            }
        }
        return false;
    }

    public Object get(int i) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.hZJ) {
            if (aVar.hZI == i) {
                return aVar.value;
            }
        }
        return null;
    }

    protected void rehash() {
        int length = this.table.length;
        a[] aVarArr = this.table;
        int i = (length * 2) + 1;
        a[] aVarArr2 = new a[i];
        this.threshold = (int) (i * this.loadFactor);
        this.table = aVarArr2;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                a aVar = aVarArr[i2];
                while (aVar != null) {
                    a aVar2 = aVar.hZJ;
                    int i3 = (aVar.hZI & Integer.MAX_VALUE) % i;
                    aVar.hZJ = aVarArr2[i3];
                    aVarArr2[i3] = aVar;
                    aVar = aVar2;
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    public Object put(int i, Object obj) {
        a[] aVarArr = this.table;
        int length = (i & Integer.MAX_VALUE) % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.hZJ) {
            if (aVar.hZI == i) {
                Object obj2 = aVar.value;
                aVar.value = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            aVarArr = this.table;
            length = (i & Integer.MAX_VALUE) % aVarArr.length;
        }
        aVarArr[length] = new a(i, i, obj, aVarArr[length]);
        this.count++;
        return null;
    }

    public Object remove(int i) {
        a[] aVarArr = this.table;
        int length = (Integer.MAX_VALUE & i) % aVarArr.length;
        a aVar = aVarArr[length];
        a aVar2 = null;
        while (aVar != null) {
            if (aVar.hZI != i) {
                a aVar3 = aVar;
                aVar = aVar.hZJ;
                aVar2 = aVar3;
            } else {
                if (aVar2 != null) {
                    aVar2.hZJ = aVar.hZJ;
                } else {
                    aVarArr[length] = aVar.hZJ;
                }
                this.count--;
                Object obj = aVar.value;
                aVar.value = null;
                return obj;
            }
        }
        return null;
    }

    public synchronized void clear() {
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                aVarArr[length] = null;
            } else {
                this.count = 0;
            }
        }
    }
}
