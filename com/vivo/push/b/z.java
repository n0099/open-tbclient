package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
/* loaded from: classes14.dex */
public final class z extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private int f8029a;

    public z() {
        super(IMConstants.IM_MSG_TYPE_SHIELD);
        this.f8029a = 0;
    }

    public final int d() {
        return this.f8029a;
    }

    public final void a(int i) {
        this.f8029a = i;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("com.bbk.push.ikey.MODE_TYPE", this.f8029a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f8029a = aVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.y
    public final boolean c() {
        return true;
    }
}
