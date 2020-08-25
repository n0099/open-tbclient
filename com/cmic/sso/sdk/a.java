package com.cmic.sso.sdk;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class a {
    private ConcurrentHashMap<String, Object> a;

    public a(int i) {
        this.a = new ConcurrentHashMap<>(i);
    }

    public void a(String str, byte[] bArr) {
        if (str != null && bArr != null) {
            this.a.put(str, bArr);
        }
    }

    public byte[] a(String str) {
        if (str != null) {
            return (byte[]) this.a.get(str);
        }
        return null;
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }

    public String b(String str) {
        return b(str, "");
    }

    public String b(String str, String str2) {
        return (str == null || !this.a.containsKey(str)) ? str2 : (String) this.a.get(str);
    }

    public void a(String str, boolean z) {
        if (str != null) {
            this.a.put(str, Boolean.valueOf(z));
        }
    }

    public boolean b(String str, boolean z) {
        if (str != null && this.a.containsKey(str)) {
            return ((Boolean) this.a.get(str)).booleanValue();
        }
        return z;
    }

    public void a(String str, int i) {
        if (str != null) {
            this.a.put(str, Integer.valueOf(i));
        }
    }

    public int c(String str) {
        return b(str, 0);
    }

    public int b(String str, int i) {
        if (str != null && this.a.containsKey(str)) {
            return ((Integer) this.a.get(str)).intValue();
        }
        return i;
    }

    public void a(String str, long j) {
        if (str != null) {
            this.a.put(str, Long.valueOf(j));
        }
    }

    public long b(String str, long j) {
        if (str != null && this.a.containsKey(str)) {
            return ((Long) this.a.get(str)).longValue();
        }
        return j;
    }
}
