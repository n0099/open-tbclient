package com.cmic.sso.sdk;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f30591a;

    public a(int i2) {
        this.f30591a = new ConcurrentHashMap<>(i2);
    }

    public void a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return;
        }
        this.f30591a.put(str, bArr);
    }

    public String b(String str) {
        return b(str, "");
    }

    public int c(String str) {
        return b(str, 0);
    }

    public byte[] a(String str) {
        if (str != null) {
            return (byte[]) this.f30591a.get(str);
        }
        return null;
    }

    public String b(String str, String str2) {
        return (str == null || !this.f30591a.containsKey(str)) ? str2 : (String) this.f30591a.get(str);
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f30591a.put(str, str2);
    }

    public void a(String str, boolean z) {
        if (str != null) {
            this.f30591a.put(str, Boolean.valueOf(z));
        }
    }

    public boolean b(String str, boolean z) {
        return (str == null || !this.f30591a.containsKey(str)) ? z : ((Boolean) this.f30591a.get(str)).booleanValue();
    }

    public void a(String str, int i2) {
        if (str != null) {
            this.f30591a.put(str, Integer.valueOf(i2));
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            this.f30591a.put(str, Long.valueOf(j));
        }
    }

    public int b(String str, int i2) {
        return (str == null || !this.f30591a.containsKey(str)) ? i2 : ((Integer) this.f30591a.get(str)).intValue();
    }

    public void a(com.cmic.sso.sdk.c.a aVar) {
        if (aVar != null) {
            this.f30591a.put("logBean", aVar);
        }
    }

    public com.cmic.sso.sdk.c.a a() {
        com.cmic.sso.sdk.c.a aVar = (com.cmic.sso.sdk.c.a) this.f30591a.get("logBean");
        return aVar != null ? aVar : new com.cmic.sso.sdk.c.a();
    }

    public long b(String str, long j) {
        return (str == null || !this.f30591a.containsKey(str)) ? j : ((Long) this.f30591a.get(str)).longValue();
    }
}
