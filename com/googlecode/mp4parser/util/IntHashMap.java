package com.googlecode.mp4parser.util;
/* loaded from: classes6.dex */
public class IntHashMap {
    public transient int count;
    public float loadFactor;
    public transient a[] table;
    public int threshold;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f31454a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31455b;

        /* renamed from: c  reason: collision with root package name */
        public a f31456c;

        public a(int i, int i2, Object obj, a aVar) {
            this.f31454a = i;
            this.f31455b = obj;
            this.f31456c = aVar;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public synchronized void clear() {
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.count = 0;
            } else {
                aVarArr[length] = null;
            }
        }
    }

    public boolean contains(Object obj) {
        if (obj != null) {
            a[] aVarArr = this.table;
            int length = aVarArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                for (a aVar = aVarArr[i]; aVar != null; aVar = aVar.f31456c) {
                    if (aVar.f31455b.equals(obj)) {
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
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.f31456c) {
            if (aVar.f31454a == i) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public Object get(int i) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.f31456c) {
            if (aVar.f31454a == i) {
                return aVar.f31455b;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Object put(int i, Object obj) {
        a[] aVarArr = this.table;
        int i2 = Integer.MAX_VALUE & i;
        int length = i2 % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.f31456c) {
            if (aVar.f31454a == i) {
                Object obj2 = aVar.f31455b;
                aVar.f31455b = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            aVarArr = this.table;
            length = i2 % aVarArr.length;
        }
        aVarArr[length] = new a(i, i, obj, aVarArr[length]);
        this.count++;
        return null;
    }

    public void rehash() {
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        int i = (length * 2) + 1;
        a[] aVarArr2 = new a[i];
        this.threshold = (int) (i * this.loadFactor);
        this.table = aVarArr2;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            a aVar = aVarArr[i2];
            while (aVar != null) {
                a aVar2 = aVar.f31456c;
                int i3 = (aVar.f31454a & Integer.MAX_VALUE) % i;
                aVar.f31456c = aVarArr2[i3];
                aVarArr2[i3] = aVar;
                aVar = aVar2;
            }
            length = i2;
        }
    }

    public Object remove(int i) {
        a[] aVarArr = this.table;
        int length = (Integer.MAX_VALUE & i) % aVarArr.length;
        a aVar = null;
        for (a aVar2 = aVarArr[length]; aVar2 != null; aVar2 = aVar2.f31456c) {
            if (aVar2.f31454a == i) {
                if (aVar != null) {
                    aVar.f31456c = aVar2.f31456c;
                } else {
                    aVarArr[length] = aVar2.f31456c;
                }
                this.count--;
                Object obj = aVar2.f31455b;
                aVar2.f31455b = null;
                return obj;
            }
            aVar = aVar2;
        }
        return null;
    }

    public int size() {
        return this.count;
    }

    public IntHashMap(int i) {
        this(i, 0.75f);
    }

    public IntHashMap(int i, float f2) {
        if (i < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        } else if (f2 > 0.0f) {
            i = i == 0 ? 1 : i;
            this.loadFactor = f2;
            this.table = new a[i];
            this.threshold = (int) (i * f2);
        } else {
            throw new IllegalArgumentException("Illegal Load: " + f2);
        }
    }
}
