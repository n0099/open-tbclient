package com.tencent.turingfd.sdk.ams.au;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class z extends bf implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, Integer> f13557b;
    public long d = 0;
    public boolean e = true;
    public long f = 0;
    public Map<String, String> g = null;
    public Map<Integer, Integer> h = null;
    public long i = 0;
    public static final /* synthetic */ boolean c = !z.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f13556a = new HashMap();

    static {
        f13556a.put("", "");
        f13557b = new HashMap();
        f13557b.put(0, 0);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.bf
    public void a(ao aoVar) {
        this.d = aoVar.a(this.d, 0, true);
        this.e = aoVar.a(this.e, 1, true);
        this.f = aoVar.a(this.f, 2, true);
        this.g = (Map) aoVar.a((ao) f13556a, 3, true);
        this.h = (Map) aoVar.a((ao) f13557b, 4, true);
        this.i = aoVar.a(this.i, 5, true);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.bf
    public void a(as asVar) {
        asVar.a(this.d, 0);
        asVar.a(this.e, 1);
        asVar.a(this.f, 2);
        asVar.a((Map) this.g, 3);
        asVar.a((Map) this.h, 4);
        asVar.a(this.i, 5);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        z zVar = (z) obj;
        return w.a(this.d, zVar.d) && w.a(this.e, zVar.e) && w.a(this.f, zVar.f) && w.a(this.g, zVar.g) && w.a(this.h, zVar.h) && w.a(this.i, zVar.i);
    }

    public int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
