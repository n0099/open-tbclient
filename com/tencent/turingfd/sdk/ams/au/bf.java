package com.tencent.turingfd.sdk.ams.au;

import java.io.Serializable;
/* loaded from: classes3.dex */
public abstract class bf implements Serializable {
    public abstract void a(ao aoVar);

    public abstract void a(as asVar);

    public byte[] a() {
        as asVar = new as();
        a(asVar);
        byte[] bArr = new byte[asVar.f13788a.position()];
        System.arraycopy(asVar.f13788a.array(), 0, bArr, 0, asVar.f13788a.position());
        return bArr;
    }

    public String toString() {
        return new StringBuilder().toString();
    }
}
