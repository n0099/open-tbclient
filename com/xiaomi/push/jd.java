package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public class jd {

    /* renamed from: a  reason: collision with root package name */
    private ji f8460a;

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
        this.f8460a = jkVar.a(this.f769a);
    }

    public byte[] a(ix ixVar) {
        this.f770a.reset();
        ixVar.b(this.f8460a);
        return this.f770a.toByteArray();
    }
}
