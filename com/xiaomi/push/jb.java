package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes18.dex */
public class jb {

    /* renamed from: a  reason: collision with root package name */
    private final ji f4766a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f769a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f769a = new jr();
        this.f4766a = jkVar.a(this.f769a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f769a.a(bArr);
            ixVar.a(this.f4766a);
        } finally {
            this.f4766a.k();
        }
    }
}
