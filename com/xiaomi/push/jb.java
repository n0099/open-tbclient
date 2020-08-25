package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes7.dex */
public class jb {
    private final ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f770a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f770a = new jr();
        this.a = jkVar.a(this.f770a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f770a.a(bArr);
            ixVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
