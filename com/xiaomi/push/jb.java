package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes9.dex */
public class jb {
    private final ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f773a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f773a = new jr();
        this.a = jkVar.a(this.f773a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f773a.a(bArr);
            ixVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
