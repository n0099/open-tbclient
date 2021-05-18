package com.cmic.sso.sdk;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f30477a;

    public a(int i2) {
        this.f30477a = new ConcurrentHashMap<>(i2);
    }

    public void a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return;
        }
        this.f30477a.put(str, bArr);
    }

    public String b(String str) {
        return b(str, "");
    }

    public int c(String str) {
        return b(str, 0);
    }

    public byte[] a(String str) {
        if (str != null) {
            return (byte[]) this.f30477a.get(str);
        }
        return null;
    }

    public String b(String str, String str2) {
        return (str == null || !this.f30477a.containsKey(str)) ? str2 : (String) this.f30477a.get(str);
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f30477a.put(str, str2);
    }

    public void a(String str, boolean z) {
        if (str != null) {
            this.f30477a.put(str, Boolean.valueOf(z));
        }
    }

    public boolean b(String str, boolean z) {
        return (str == null || !this.f30477a.containsKey(str)) ? z : ((Boolean) this.f30477a.get(str)).booleanValue();
    }

    public void a(String str, int i2) {
        if (str != null) {
            this.f30477a.put(str, Integer.valueOf(i2));
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            this.f30477a.put(str, Long.valueOf(j));
        }
    }

    public int b(String str, int i2) {
        return (str == null || !this.f30477a.containsKey(str)) ? i2 : ((Integer) this.f30477a.get(str)).intValue();
    }

    public long b(String str, long j) {
        return (str == null || !this.f30477a.containsKey(str)) ? j : ((Long) this.f30477a.get(str)).longValue();
    }
}
