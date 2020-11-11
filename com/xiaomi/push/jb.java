package com.xiaomi.push;

import com.xiaomi.push.je;
/* loaded from: classes12.dex */
public class jb {

    /* renamed from: a  reason: collision with root package name */
    private final ji f4996a;

    /* renamed from: a  reason: collision with other field name */
    private final jr f768a;

    public jb() {
        this(new je.a());
    }

    public jb(jk jkVar) {
        this.f768a = new jr();
        this.f4996a = jkVar.a(this.f768a);
    }

    public void a(ix ixVar, byte[] bArr) {
        try {
            this.f768a.a(bArr);
            ixVar.a(this.f4996a);
        } finally {
            this.f4996a.k();
        }
    }
}
