package com.googlecode.mp4parser.util;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes3.dex */
public class IntHashMap {
    private transient int count;
    private float loadFactor;
    private transient a[] table;
    private int threshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        int hash;
        int key;
        a pNh;
        Object value;

        protected a(int i, int i2, Object obj, a aVar) {
            this.hash = i;
            this.key = i2;
            this.value = obj;
            this.pNh = aVar;
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
                for (a aVar = aVarArr[i]; aVar != null; aVar = aVar.pNh) {
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
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.pNh) {
            if (aVar.hash == i) {
                return true;
            }
        }
        return false;
    }

    public Object get(int i) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i) % aVarArr.length]; aVar != null; aVar = aVar.pNh) {
            if (aVar.hash == i) {
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
                    a aVar2 = aVar.pNh;
                    int i3 = (aVar.hash & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % i;
                    aVar.pNh = aVarArr2[i3];
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
        int length = (i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.pNh) {
            if (aVar.hash == i) {
                Object obj2 = aVar.value;
                aVar.value = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            aVarArr = this.table;
            length = (i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % aVarArr.length;
        }
        aVarArr[length] = new a(i, i, obj, aVarArr[length]);
        this.count++;
        return null;
    }

    public Object remove(int i) {
        a[] aVarArr = this.table;
        int length = (Integer.MAX_VALUE & i) % aVarArr.length;
        a aVar = null;
        for (a aVar2 = aVarArr[length]; aVar2 != null; aVar2 = aVar2.pNh) {
            if (aVar2.hash != i) {
                aVar = aVar2;
            } else {
                if (aVar != null) {
                    aVar.pNh = aVar2.pNh;
                } else {
                    aVarArr[length] = aVar2.pNh;
                }
                this.count--;
                Object obj = aVar2.value;
                aVar2.value = null;
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
