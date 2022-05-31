package com.meizu.cloud.pushsdk.handler.a.d;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.repackage.ni9;
/* loaded from: classes5.dex */
public class d extends com.meizu.cloud.pushsdk.handler.a.a<SubAliasStatus> {
    public d(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private void c(String str) {
        com.meizu.cloud.pushsdk.util.b.h(c(), c().getPackageName(), str);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4096;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(SubAliasStatus subAliasStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (b() == null || subAliasStatus == null) {
            return;
        }
        b().a(c(), subAliasStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        ni9.d("AbstractMessageHandler", "start SubScribeAliasStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS.equals(i(intent));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j */
    public SubAliasStatus c(Intent intent) {
        SubAliasStatus subAliasStatus = (SubAliasStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS);
        if (BasicPushStatus.SUCCESS_CODE.equals(subAliasStatus.getCode())) {
            c(subAliasStatus.getAlias());
        }
        return subAliasStatus;
    }
}
