package com.vivo.push.b;

import com.baidu.wallet.core.DebugConfig;
/* loaded from: classes7.dex */
public final class g extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public int f36611a;

    public g() {
        super(2015);
        this.f36611a = -1;
    }

    public static boolean a(int i2) {
        return i2 > 0 && i2 <= 4;
    }

    public final void b(int i2) {
        this.f36611a = i2;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        if (a(this.f36611a)) {
            aVar.a(DebugConfig.f23892e, this.f36611a);
        }
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f36611a = aVar.b(DebugConfig.f23892e, 1);
    }
}
