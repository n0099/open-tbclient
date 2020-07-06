package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class jd {
    private ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f775a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f776a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f776a = new ByteArrayOutputStream();
        this.f775a = new jp(this.f776a);
        this.a = jkVar.a(this.f775a);
    }

    public byte[] a(ix ixVar) {
        this.f776a.reset();
        ixVar.b(this.a);
        return this.f776a.toByteArray();
    }
}
