package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes6.dex */
public class jb {

    /* renamed from: a  reason: collision with root package name */
    private final ji f14464a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f847a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f847a = new jr();
        this.f14464a = jkVar.a(this.f847a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f847a.a(bArr);
            ixVar.a(this.f14464a);
        } finally {
            this.f14464a.k();
        }
    }
}
