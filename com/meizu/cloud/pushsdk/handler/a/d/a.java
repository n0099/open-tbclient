package com.meizu.cloud.pushsdk.handler.a.d;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
/* loaded from: classes3.dex */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<PushSwitchStatus> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 256;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(PushSwitchStatus pushSwitchStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (b() == null || pushSwitchStatus == null) {
            return;
        }
        b().a(c(), pushSwitchStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        c.k.a.a.a.d("AbstractMessageHandler", "start PushSwitchStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS.equals(i(intent));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public PushSwitchStatus c(Intent intent) {
        PushSwitchStatus pushSwitchStatus = (PushSwitchStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS);
        if (BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
            String g2 = g(intent);
            c.k.a.a.a.b("AbstractMessageHandler", "PushSwitchStatusHandler update local " + g2 + " switch status " + pushSwitchStatus);
            com.meizu.cloud.pushsdk.util.b.a(c(), g2, pushSwitchStatus.isSwitchNotificationMessage());
            com.meizu.cloud.pushsdk.util.b.b(c(), g2, pushSwitchStatus.isSwitchThroughMessage());
        }
        return pushSwitchStatus;
    }
}
