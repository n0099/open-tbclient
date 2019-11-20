package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.ByteArrayOutputStream;
/* loaded from: classes3.dex */
public class ix {
    private jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jj f779a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f780a;

    public ix() {
        this(new iy.a());
    }

    public ix(je jeVar) {
        this.f780a = new ByteArrayOutputStream();
        this.f779a = new jj(this.f780a);
        this.a = jeVar.a(this.f779a);
    }

    public byte[] a(ir irVar) {
        this.f780a.reset();
        irVar.b(this.a);
        return this.f780a.toByteArray();
    }
}
