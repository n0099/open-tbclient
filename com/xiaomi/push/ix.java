package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class ix {
    private jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jj f780a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f781a;

    public ix() {
        this(new iy.a());
    }

    public ix(je jeVar) {
        this.f781a = new ByteArrayOutputStream();
        this.f780a = new jj(this.f781a);
        this.a = jeVar.a(this.f780a);
    }

    public byte[] a(ir irVar) {
        this.f781a.reset();
        irVar.b(this.a);
        return this.f781a.toByteArray();
    }
}
