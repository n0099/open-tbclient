package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes9.dex */
public class jd {
    private ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f774a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f775a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f775a = new ByteArrayOutputStream();
        this.f774a = new jp(this.f775a);
        this.a = jkVar.a(this.f774a);
    }

    public byte[] a(ix ixVar) {
        this.f775a.reset();
        ixVar.b(this.a);
        return this.f775a.toByteArray();
    }
}
