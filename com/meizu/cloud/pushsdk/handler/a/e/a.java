package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.a.c;
import com.meizu.cloud.pushsdk.util.d;
/* loaded from: classes2.dex */
public class a extends c {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 8192;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (cVar != null) {
            cVar.e(messageV3);
            c(messageV3);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        b.l.a.a.a.d("AbstractMessageHandler", "start ScheduleNotificationHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION.equals(i(intent));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public void b(MessageV3 messageV3) {
        b.l.a.a.a.b("AbstractMessageHandler", "ScheduleNotificationHandler dont repeat upload receiver push event");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e */
    public void c(MessageV3 messageV3) {
        d.a(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: i */
    public int d(MessageV3 messageV3) {
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        return (MessageV3) intent.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE);
    }
}
