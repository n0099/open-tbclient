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
        public int f31568a;

        /* renamed from: b  reason: collision with root package name */
        public Object f31569b;

        /* renamed from: c  reason: collision with root package name */
        public a f31570c;

        public a(int i2, int i3, Object obj, a aVar) {
            this.f31568a = i2;
            this.f31569b = obj;
            this.f31570c = aVar;
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
                int i2 = length - 1;
                if (length <= 0) {
                    return false;
                }
                for (a aVar = aVarArr[i2]; aVar != null; aVar = aVar.f31570c) {
                    if (aVar.f31569b.equals(obj)) {
                        return true;
                    }
                }
                length = i2;
            }
        } else {
            throw null;
        }
    }

    public boolean containsKey(int i2) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i2) % aVarArr.length]; aVar != null; aVar = aVar.f31570c) {
            if (aVar.f31568a == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public Object get(int i2) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i2) % aVarArr.length]; aVar != null; aVar = aVar.f31570c) {
            if (aVar.f31568a == i2) {
                return aVar.f31569b;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Object put(int i2, Object obj) {
        a[] aVarArr = this.table;
        int i3 = Integer.MAX_VALUE & i2;
        int length = i3 % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.f31570c) {
            if (aVar.f31568a == i2) {
                Object obj2 = aVar.f31569b;
                aVar.f31569b = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            aVarArr = this.table;
            length = i3 % aVarArr.length;
        }
        aVarArr[length] = new a(i2, i2, obj, aVarArr[length]);
        this.count++;
        return null;
    }

    public void rehash() {
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        int i2 = (length * 2) + 1;
        a[] aVarArr2 = new a[i2];
        this.threshold = (int) (i2 * this.loadFactor);
        this.table = aVarArr2;
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                return;
            }
            a aVar = aVarArr[i3];
            while (aVar != null) {
                a aVar2 = aVar.f31570c;
                int i4 = (aVar.f31568a & Integer.MAX_VALUE) % i2;
                aVar.f31570c = aVarArr2[i4];
                aVarArr2[i4] = aVar;
                aVar = aVar2;
            }
            length = i3;
        }
    }

    public Object remove(int i2) {
        a[] aVarArr = this.table;
        int length = (Integer.MAX_VALUE & i2) % aVarArr.length;
        a aVar = null;
        for (a aVar2 = aVarArr[length]; aVar2 != null; aVar2 = aVar2.f31570c) {
            if (aVar2.f31568a == i2) {
                if (aVar != null) {
                    aVar.f31570c = aVar2.f31570c;
                } else {
                    aVarArr[length] = aVar2.f31570c;
                }
                this.count--;
                Object obj = aVar2.f31569b;
                aVar2.f31569b = null;
                return obj;
            }
            aVar = aVar2;
        }
        return null;
    }

    public int size() {
        return this.count;
    }

    public IntHashMap(int i2) {
        this(i2, 0.75f);
    }

    public IntHashMap(int i2, float f2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i2);
        } else if (f2 > 0.0f) {
            i2 = i2 == 0 ? 1 : i2;
            this.loadFactor = f2;
            this.table = new a[i2];
            this.threshold = (int) (i2 * f2);
        } else {
            throw new IllegalArgumentException("Illegal Load: " + f2);
        }
    }
}
