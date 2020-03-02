package com.xiaomi.push;

import com.xiaomi.push.iy;
/* loaded from: classes8.dex */
public class iv {
    private final jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jl f778a;

    public iv() {
        this(new iy.a());
    }

    public iv(je jeVar) {
        this.f778a = new jl();
        this.a = jeVar.a(this.f778a);
    }

    public void a(ir irVar, byte[] bArr) {
        try {
            this.f778a.a(bArr);
            irVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
