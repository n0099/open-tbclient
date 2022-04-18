package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.repackage.ym9;
/* loaded from: classes5.dex */
public class d extends a<String> {
    public d(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 16;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(String str, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (b() != null) {
            b().a(c(), str);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        ym9.d("AbstractMessageHandler", "start RegisterMessageHandler match");
        return PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) || (PushConstants.REGISTRATION_CALLBACK_INTENT.equals(intent.getAction()) && !TextUtils.isEmpty(intent.getStringExtra("registration_id")));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public String c(Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        com.meizu.cloud.pushsdk.util.b.g(c(), stringExtra, c().getPackageName());
        com.meizu.cloud.pushsdk.util.b.a(c(), 0, c().getPackageName());
        return stringExtra;
    }
}
