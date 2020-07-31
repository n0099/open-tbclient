package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes9.dex */
public class jd {
    private ji a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f771a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f772a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f772a = new ByteArrayOutputStream();
        this.f771a = new jp(this.f772a);
        this.a = jkVar.a(this.f771a);
    }

    public byte[] a(ix ixVar) {
        this.f772a.reset();
        ixVar.b(this.a);
        return this.f772a.toByteArray();
    }
}
