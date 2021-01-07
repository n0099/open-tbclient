package com.tencent.turingfd.sdk.ams.au;

import java.io.Serializable;
/* loaded from: classes4.dex */
public abstract class bf implements Serializable {
    public abstract void a(ao aoVar);

    public abstract void a(as asVar);

    public byte[] a() {
        as asVar = new as();
        a(asVar);
        byte[] bArr = new byte[asVar.f13789a.position()];
        System.arraycopy(asVar.f13789a.array(), 0, bArr, 0, asVar.f13789a.position());
        return bArr;
    }

    public String toString() {
        return new StringBuilder().toString();
    }
}
