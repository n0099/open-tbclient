package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.eq;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class p extends ak.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8239a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(int i, String str, Context context) {
        super(i, str);
        this.f8239a = context;
    }

    @Override // com.xiaomi.push.service.ak.a
    protected void onCallback() {
        eq.a(this.f8239a).a(com.xiaomi.push.service.ak.a(this.f8239a).a(hr.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
