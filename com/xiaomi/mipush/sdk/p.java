package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.eq;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class p extends ak.a {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(int i, String str, Context context) {
        super(i, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.ak.a
    protected void onCallback() {
        eq.a(this.a).a(com.xiaomi.push.service.ak.a(this.a).a(hr.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
