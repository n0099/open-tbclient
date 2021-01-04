package com.tencent.turingfd.sdk.ams.au;
/* loaded from: classes3.dex */
public final class az extends bf implements Cloneable {
    public int c = 0;
    public z d = null;
    public long e = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ boolean f13802b = !az.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static z f13801a = new z();

    @Override // com.tencent.turingfd.sdk.ams.au.bf
    public void a(ao aoVar) {
        this.c = aoVar.a(this.c, 0, true);
        this.d = (z) aoVar.a((bf) f13801a, 1, false);
        this.e = aoVar.a(this.e, 2, true);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.bf
    public void a(as asVar) {
        asVar.a(this.c, 0);
        z zVar = this.d;
        if (zVar != null) {
            asVar.a((bf) zVar, 1);
        }
        asVar.a(this.e, 2);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            if (f13802b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        az azVar = (az) obj;
        return w.a(this.c, azVar.c) && w.a(this.d, azVar.d) && w.a(this.e, azVar.e);
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
