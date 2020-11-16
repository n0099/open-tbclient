package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes18.dex */
public class jd {

    /* renamed from: a  reason: collision with root package name */
    private ji f4997a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f772a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f773a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f773a = new ByteArrayOutputStream();
        this.f772a = new jp(this.f773a);
        this.f4997a = jkVar.a(this.f772a);
    }

    public byte[] a(ix ixVar) {
        this.f773a.reset();
        ixVar.b(this.f4997a);
        return this.f773a.toByteArray();
    }
}
