package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes12.dex */
public class jd {

    /* renamed from: a  reason: collision with root package name */
    private ji f4995a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f767a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f768a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f768a = new ByteArrayOutputStream();
        this.f767a = new jp(this.f768a);
        this.f4995a = jkVar.a(this.f767a);
    }

    public byte[] a(ix ixVar) {
        this.f768a.reset();
        ixVar.b(this.f4995a);
        return this.f768a.toByteArray();
    }
}
