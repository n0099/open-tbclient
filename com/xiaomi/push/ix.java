package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public class ix {
    private jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jj f784a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f785a;

    public ix() {
        this(new iy.a());
    }

    public ix(je jeVar) {
        this.f785a = new ByteArrayOutputStream();
        this.f784a = new jj(this.f785a);
        this.a = jeVar.a(this.f784a);
    }

    public byte[] a(ir irVar) {
        this.f785a.reset();
        irVar.b(this.a);
        return this.f785a.toByteArray();
    }
}
