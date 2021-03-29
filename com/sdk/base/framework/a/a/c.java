package com.sdk.base.framework.a.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f38408a;

    /* renamed from: b  reason: collision with root package name */
    public int f38409b;

    /* renamed from: c  reason: collision with root package name */
    public int f38410c;

    /* renamed from: d  reason: collision with root package name */
    public b<K, Long> f38411d;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f38410c = i;
        this.f38408a = new LinkedHashMap<>(0, 0.75f, true);
        this.f38411d = new b<>(0, 0.75f);
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
        int i = 0;
        while (i < length) {
            int i2 = i + 100;
            j += new String(str.substring(i, i2 < length ? i2 : length)).getBytes(str2).length;
            i = i2;
        }
        return j;
    }

    public static Boolean a(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str)) ? Boolean.TRUE : Boolean.FALSE;
    }

    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.f38409b <= i || this.f38408a.isEmpty()) {
                    break;
                }
                Map.Entry<K, V> next = this.f38408a.entrySet().iterator().next();
                K key = next.getKey();
                V value = next.getValue();
                this.f38408a.remove(key);
                this.f38411d.remove(key);
                this.f38409b -= b(key, value);
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
            this.f38409b = 0;
            for (Map.Entry<K, V> entry : this.f38408a.entrySet()) {
                this.f38409b += a((c<K, V>) entry.getKey(), (K) entry.getValue());
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
        return (str == null || str.length() == 0 || str.trim().length() == 0 || StringUtil.NULL_STRING.equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE;
    }

    private V b(K k) {
        V remove;
        if (k != null) {
            synchronized (this) {
                remove = this.f38408a.remove(k);
                this.f38411d.remove(k);
                if (remove != null) {
                    this.f38409b -= b(k, remove);
                }
            }
            return remove;
        }
        throw new NullPointerException("key == null");
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

    public int a(K k, V v) {
        return 1;
    }

    public final V a(K k) {
        if (k != null) {
            synchronized (this) {
                if (!this.f38411d.containsKey(k)) {
                    b((c<K, V>) k);
                    return null;
                }
                V v = this.f38408a.get(k);
                if (v != null) {
                    return v;
                }
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V a(K k, V v, long j) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f38409b += b(k, v);
            put = this.f38408a.put(k, v);
            this.f38411d.put(k, Long.valueOf(j));
            if (put != null) {
                this.f38409b -= b(k, put);
            }
        }
        a(this.f38410c);
        return put;
    }
}
