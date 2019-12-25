package com.xiaomi.push;

import com.xiaomi.push.iy;
/* loaded from: classes5.dex */
public class iv {
    private final jc a;

    /* renamed from: a  reason: collision with other field name */
    private final jl f783a;

    public iv() {
        this(new iy.a());
    }

    public iv(je jeVar) {
        this.f783a = new jl();
        this.a = jeVar.a(this.f783a);
    }

    public void a(ir irVar, byte[] bArr) {
        try {
            this.f783a.a(bArr);
            irVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
