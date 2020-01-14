package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class ix {
    private jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jj f783a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f784a;

    public ix() {
        this(new iy.a());
    }

    public ix(je jeVar) {
        this.f784a = new ByteArrayOutputStream();
        this.f783a = new jj(this.f784a);
        this.a = jeVar.a(this.f783a);
    }

    public byte[] a(ir irVar) {
        this.f784a.reset();
        irVar.b(this.a);
        return this.f784a.toByteArray();
    }
}
