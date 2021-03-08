package com.sdk.base.framework.a.a;

import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f7603a;
    private int b;
    private int c;
    private b<K, Long> d;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.f7603a = new LinkedHashMap<>(0, 0.75f, true);
        this.d = new b<>(0, 0.75f);
    }

    public static int a(String str, String str2, Boolean bool) {
        if (str2 == null) {
            str2 = "";
        }
        if (bool.booleanValue()) {
            return Log.i(str, str2);
        }
        return -1;
    }

    public static long a(String str, String str2) {
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int length = str.length();
        if (length < 100) {
            return str.getBytes(str2).length;
        }
        for (int i = 0; i < length; i += 100) {
            int i2 = i + 100;
            if (i2 >= length) {
                i2 = length;
            }
            j += new String(str.substring(i, i2)).getBytes(str2).length;
        }
        return j;
    }

    public static Boolean a(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0 || "null".equals(str);
    }

    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.b <= i || this.f7603a.isEmpty()) {
                    break;
                }
                Map.Entry<K, V> next = this.f7603a.entrySet().iterator().next();
                K key = next.getKey();
                V value = next.getValue();
                this.f7603a.remove(key);
                this.d.remove(key);
                this.b -= b(key, value);
            }
        }
    }

    public static boolean a(String... strArr) {
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            if ((str == null || str.length() <= 0) && a(str).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private int b(K k, V v) {
        int a2 = a((c<K, V>) k, (K) v);
        if (a2 <= 0) {
            this.b = 0;
            for (Map.Entry<K, V> entry : this.f7603a.entrySet()) {
                this.b = a((c<K, V>) entry.getKey(), (K) entry.getValue()) + this.b;
            }
        }
        return a2;
    }

    public static int b(String str, String str2, Boolean bool) {
        if (str2 == null) {
            str2 = "";
        }
        if (bool.booleanValue()) {
            return Log.e(str, str2);
        }
        return -1;
    }

    public static Boolean b(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || "null".equals(str) || str.equals("")) ? false : true;
    }

    private V b(K k) {
        V remove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f7603a.remove(k);
            this.d.remove(k);
            if (remove != null) {
                this.b -= b(k, remove);
            }
        }
        return remove;
    }

    public static int c(String str, String str2, Boolean bool) {
        if (str2 == null) {
            str2 = "";
        }
        if (bool.booleanValue()) {
            return Log.w(str, str2);
        }
        return -1;
    }

    protected int a(K k, V v) {
        return 1;
    }

    public final V a(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            if (!this.d.containsKey(k)) {
                b((c<K, V>) k);
                return null;
            }
            V v = this.f7603a.get(k);
            if (v != null) {
                return v;
            }
            return null;
        }
    }

    public final V a(K k, V v, long j) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.b += b(k, v);
            put = this.f7603a.put(k, v);
            this.d.put(k, Long.valueOf(j));
            if (put != null) {
                this.b -= b(k, put);
            }
        }
        a(this.c);
        return put;
    }
}
