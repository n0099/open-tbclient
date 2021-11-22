package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes2.dex */
public class f extends a<Boolean> {
    public f(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 32;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(Boolean bool, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (b() != null) {
            b().a(c(), bool.booleanValue());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        b.j.a.a.a.d("AbstractMessageHandler", "start UnRegisterMessageHandler match");
        return PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION.equals(intent.getAction()) || (PushConstants.REQUEST_UNREGISTRATION_INTENT.equals(intent.getAction()) && TextUtils.isEmpty(intent.getStringExtra(PushConstants.EXTRA_UNREGISTERED)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public Boolean c(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(PushConstants.EXTRA_APP_IS_UNREGISTER_SUCCESS, false);
        String stringExtra = intent.getStringExtra(PushConstants.EXTRA_REGISTRATION_ERROR);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_UNREGISTERED);
        b.j.a.a.a.d("AbstractMessageHandler", "processUnRegisterCallback 5.0:" + booleanExtra + " 4.0:" + stringExtra + " 3.0:" + stringExtra2);
        if (TextUtils.isEmpty(stringExtra) || booleanExtra || !TextUtils.isEmpty(stringExtra2)) {
            com.meizu.cloud.pushsdk.util.b.g(c(), "", c().getPackageName());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
