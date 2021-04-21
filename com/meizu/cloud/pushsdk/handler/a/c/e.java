package com.meizu.cloud.pushsdk.handler.a.c;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.b.h;
/* loaded from: classes6.dex */
public class e extends com.meizu.cloud.pushsdk.handler.a.a<h> {
    public e(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 262144;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(h hVar) {
        com.meizu.cloud.pushsdk.util.d.c(c(), hVar.c(), hVar.a().b().d(), hVar.a().b().a(), hVar.a().b().e(), hVar.a().b().b());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(h hVar, com.meizu.cloud.pushsdk.notification.c cVar) {
        NotificationManager notificationManager = (NotificationManager) c().getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            d.k.a.a.a.b("AbstractMessageHandler", "start cancel notification id " + hVar.b());
            notificationManager.cancel(hVar.b());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        int i;
        d.k.a.a.a.d("AbstractMessageHandler", "start WithDrawMessageHandler match");
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            com.meizu.cloud.pushsdk.handler.a.b.b a2 = com.meizu.cloud.pushsdk.handler.a.b.b.a(stringExtra);
            if (a2.a() != null) {
                i = a2.a().a();
                return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "4".equals(String.valueOf(i));
            }
        }
        i = 0;
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public h c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new h(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), g(intent), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
