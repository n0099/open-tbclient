package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes12.dex */
public class jb {

    /* renamed from: a  reason: collision with root package name */
    private final ji f4994a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f766a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f766a = new jr();
        this.f4994a = jkVar.a(this.f766a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f766a.a(bArr);
            ixVar.a(this.f4994a);
        } finally {
            this.f4994a.k();
        }
    }
}
