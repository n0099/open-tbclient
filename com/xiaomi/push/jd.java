package com.xiaomi.push;

import com.xiaomi.push.je;
import java.io.ByteArrayOutputStream;
/* loaded from: classes12.dex */
public class jd {

    /* renamed from: a  reason: collision with root package name */
    private ji f4997a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f770a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f771a;

    public jd() {
        this(new je.a());
    }

    public jd(jk jkVar) {
        this.f771a = new ByteArrayOutputStream();
        this.f770a = new jp(this.f771a);
        this.f4997a = jkVar.a(this.f770a);
    }

    public byte[] a(ix ixVar) {
        this.f771a.reset();
        ixVar.b(this.f4997a);
        return this.f771a.toByteArray();
    }
}
