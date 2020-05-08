package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes8.dex */
public class jb {
    private final ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f767a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f767a = new jr();
        this.a = jkVar.a(this.f767a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f767a.a(bArr);
            ixVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
