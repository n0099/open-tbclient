package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ea;
import com.xiaomi.push.hk;
import com.xiaomi.push.service.aq;
/* loaded from: classes7.dex */
public final class q extends aq.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40204a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, String str, Context context) {
        super(i, str);
        this.f40204a = context;
    }

    @Override // com.xiaomi.push.service.aq.a
    public void onCallback() {
        ea.a(this.f40204a).a(com.xiaomi.push.service.aq.a(this.f40204a).a(hk.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
