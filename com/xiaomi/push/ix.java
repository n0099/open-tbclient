package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class ix {
    private jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jj f782a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f783a;

    public ix() {
        this(new iy.a());
    }

    public ix(je jeVar) {
        this.f783a = new ByteArrayOutputStream();
        this.f782a = new jj(this.f783a);
        this.a = jeVar.a(this.f782a);
    }

    public byte[] a(ir irVar) {
        this.f783a.reset();
        irVar.b(this.a);
        return this.f783a.toByteArray();
    }
}
