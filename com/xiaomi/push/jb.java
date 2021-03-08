package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes5.dex */
public class jb {

    /* renamed from: a  reason: collision with root package name */
    private final ji f8459a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f768a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f768a = new jr();
        this.f8459a = jkVar.a(this.f768a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f768a.a(bArr);
            ixVar.a(this.f8459a);
        } finally {
            this.f8459a.k();
        }
    }
}
