package com.meizu.cloud.pushsdk.handler.a.b;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
/* loaded from: classes2.dex */
public class d extends com.meizu.cloud.pushsdk.handler.a.a<SubAliasStatus> {
    public d(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public SubAliasStatus c(Intent intent) {
        return (SubAliasStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(SubAliasStatus subAliasStatus, com.meizu.cloud.pushsdk.notification.e eVar) {
        if (b() != null && subAliasStatus != null) {
            b().a(c(), subAliasStatus);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        com.meizu.cloud.a.a.i("AbstractMessageHandler", "start SubScribeAliasStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS.equals(i(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4096;
    }
}
