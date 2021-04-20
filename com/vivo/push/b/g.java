package com.vivo.push.b;

import com.baidu.wallet.core.DebugConfig;
/* loaded from: classes7.dex */
public final class g extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public int f39668a;

    public g() {
        super(2015);
        this.f39668a = -1;
    }

    public static boolean a(int i) {
        return i > 0 && i <= 4;
    }

    public final void b(int i) {
        this.f39668a = i;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        if (a(this.f39668a)) {
            aVar.a(DebugConfig.f23895e, this.f39668a);
        }
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f39668a = aVar.b(DebugConfig.f23895e, 1);
    }
}
