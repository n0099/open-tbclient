package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes6.dex */
public class jb {

    /* renamed from: a  reason: collision with root package name */
    private final ji f14465a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f848a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f848a = new jr();
        this.f14465a = jkVar.a(this.f848a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f848a.a(bArr);
            ixVar.a(this.f14465a);
        } finally {
            this.f14465a.k();
        }
    }
}
