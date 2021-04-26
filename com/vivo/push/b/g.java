package com.vivo.push.b;

import com.baidu.wallet.core.DebugConfig;
/* loaded from: classes6.dex */
public final class g extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public int f37366a;

    public g() {
        super(2015);
        this.f37366a = -1;
    }

    public static boolean a(int i2) {
        return i2 > 0 && i2 <= 4;
    }

    public final void b(int i2) {
        this.f37366a = i2;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        if (a(this.f37366a)) {
            aVar.a(DebugConfig.f24647e, this.f37366a);
        }
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f37366a = aVar.b(DebugConfig.f24647e, 1);
    }
}
