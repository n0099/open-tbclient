package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes18.dex */
public class jb {

    /* renamed from: a  reason: collision with root package name */
    private final ji f4996a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f771a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f771a = new jr();
        this.f4996a = jkVar.a(this.f771a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f771a.a(bArr);
            ixVar.a(this.f4996a);
        } finally {
            this.f4996a.k();
        }
    }
}
