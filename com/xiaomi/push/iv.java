package com.xiaomi.push;

import com.xiaomi.push.iy;
/* loaded from: classes6.dex */
public class iv {
    private final jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jl f781a;

    public iv() {
        this(new iy.a());
    }

    public iv(je jeVar) {
        this.f781a = new jl();
        this.a = jeVar.a(this.f781a);
    }

    public void a(ir irVar, byte[] bArr) {
        try {
            this.f781a.a(bArr);
            irVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
