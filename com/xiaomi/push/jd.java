package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class jd {

    /* renamed from: a  reason: collision with root package name */
    private ji f14466a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f849a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f850a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f850a = new ByteArrayOutputStream();
        this.f849a = new jp(this.f850a);
        this.f14466a = jkVar.a(this.f849a);
    }

    public byte[] a(ix ixVar) {
        this.f850a.reset();
        ixVar.b(this.f14466a);
        return this.f850a.toByteArray();
    }
}
