package com.vivo.push.b;

import com.baidu.wallet.core.DebugConfig;
/* loaded from: classes7.dex */
public final class g extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public int f40322a;

    public g() {
        super(2015);
        this.f40322a = -1;
    }

    public static boolean a(int i2) {
        return i2 > 0 && i2 <= 4;
    }

    public final void b(int i2) {
        this.f40322a = i2;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        if (a(this.f40322a)) {
            aVar.a(DebugConfig.f24006e, this.f40322a);
        }
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f40322a = aVar.b(DebugConfig.f24006e, 1);
    }
}
