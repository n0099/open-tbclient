package com.google.android.gms.internal;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class af {
    private final LinkedHashMap a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    private int c(Object obj, Object obj2) {
        int b = b(obj, obj2);
        if (b < 0) {
            throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
        }
        return b;
    }

    public final Object a(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += c(obj, obj2);
            put = this.a.put(obj, obj2);
            if (put != null) {
                this.b -= c(obj, put);
            }
        }
        if (put != null) {
            a(false, obj, put, obj2);
        }
        a(this.c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                    break;
                } else if (this.b <= i || this.a.isEmpty()) {
                    break;
                } else {
                    Map.Entry entry = (Map.Entry) this.a.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.a.remove(key);
                    this.b -= c(key, value);
                    this.e++;
                }
            }
            a(true, key, value, null);
        }
    }

    protected void a(boolean z, Object obj, Object obj2, Object obj3) {
    }

    protected int b(Object obj, Object obj2) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        synchronized (this) {
            int i = this.f + this.g;
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i != 0 ? (this.f * 100) / i : 0));
        }
        return format;
    }
}
