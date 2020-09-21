package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes9.dex */
public class jd {
    private ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f769a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f770a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f770a = new ByteArrayOutputStream();
        this.f769a = new jp(this.f770a);
        this.a = jkVar.a(this.f769a);
    }

    public byte[] a(ix ixVar) {
        this.f770a.reset();
        ixVar.b(this.a);
        return this.f770a.toByteArray();
    }
}
