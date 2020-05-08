package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class jd {
    private ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f768a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f769a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f769a = new ByteArrayOutputStream();
        this.f768a = new jp(this.f769a);
        this.a = jkVar.a(this.f768a);
    }

    public byte[] a(ix ixVar) {
        this.f769a.reset();
        ixVar.b(this.a);
        return this.f769a.toByteArray();
    }
}
