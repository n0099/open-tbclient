package com.xiaomi.push;

import com.xiaomi.push.iz;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class iy {
    public jd a;

    /* renamed from: a  reason: collision with other field name */
    public final jk f803a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f804a;

    public iy() {
        this(new iz.a());
    }

    public iy(jf jfVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f804a = byteArrayOutputStream;
        jk jkVar = new jk(byteArrayOutputStream);
        this.f803a = jkVar;
        this.a = jfVar.a(jkVar);
    }

    public byte[] a(is isVar) {
        this.f804a.reset();
        isVar.b(this.a);
        return this.f804a.toByteArray();
    }
}
