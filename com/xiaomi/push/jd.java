package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class jd {

    /* renamed from: a  reason: collision with root package name */
    private ji f14168a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f848a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f849a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f849a = new ByteArrayOutputStream();
        this.f848a = new jp(this.f849a);
        this.f14168a = jkVar.a(this.f848a);
    }

    public byte[] a(ix ixVar) {
        this.f849a.reset();
        ixVar.b(this.f14168a);
        return this.f849a.toByteArray();
    }
}
