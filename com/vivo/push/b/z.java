package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
/* loaded from: classes7.dex */
public final class z extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public int f36637a;

    public z() {
        super(IMConstants.IM_MSG_TYPE_SHIELD);
        this.f36637a = 0;
    }

    public final void a(int i2) {
        this.f36637a = i2;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("com.bbk.push.ikey.MODE_TYPE", this.f36637a);
    }

    @Override // com.vivo.push.y
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.f36637a;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f36637a = aVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
