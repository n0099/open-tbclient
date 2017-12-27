package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
/* loaded from: classes2.dex */
public class e extends com.meizu.cloud.pushsdk.handler.a.a<SubTagsStatus> {
    public e(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public SubTagsStatus c(Intent intent) {
        return (SubTagsStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(SubTagsStatus subTagsStatus, com.meizu.cloud.pushsdk.notification.e eVar) {
        if (b() != null && subTagsStatus != null) {
            b().a(c(), subTagsStatus);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "start SubScribeTagsStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS.equals(i(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 2048;
    }
}
