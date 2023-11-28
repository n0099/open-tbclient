package com.xiaomi.push;

import com.xiaomi.push.iz;
import java.io.ByteArrayOutputStream;
/* loaded from: classes10.dex */
public class iy {
    public jd a;

    /* renamed from: a  reason: collision with other field name */
    public final jk f799a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f800a;

    public iy() {
        this(new iz.a());
    }

    public iy(jf jfVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f800a = byteArrayOutputStream;
        jk jkVar = new jk(byteArrayOutputStream);
        this.f799a = jkVar;
        this.a = jfVar.a(jkVar);
    }

    public byte[] a(is isVar) {
        this.f800a.reset();
        isVar.b(this.a);
        return this.f800a.toByteArray();
    }
}
