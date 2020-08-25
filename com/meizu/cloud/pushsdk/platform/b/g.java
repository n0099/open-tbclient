package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes20.dex */
public class g extends c<UnRegisterStatus> {
    public g(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
    }

    public g(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public g(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(UnRegisterStatus unRegisterStatus) {
        PlatformMessageSender.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), unRegisterStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f);
        intent.putExtra("app_key", this.g);
        intent.putExtra("strategy_package_name", this.e.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 32;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public UnRegisterStatus b() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        unRegisterStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f)) {
            unRegisterStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.g)) {
            unRegisterStatus.setMessage("appKey not empty");
        }
        return unRegisterStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public UnRegisterStatus e() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        if (TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.a(this.e, this.h))) {
            unRegisterStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            unRegisterStatus.setMessage("already unRegister PushId,dont unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
            return unRegisterStatus;
        }
        this.i = o();
        com.meizu.cloud.pushsdk.b.a.c b = this.j.b(this.f, this.g, this.i);
        if (b.b()) {
            UnRegisterStatus unRegisterStatus2 = new UnRegisterStatus((String) b.a());
            com.meizu.cloud.a.a.e("Strategy", "network unRegisterStatus " + unRegisterStatus2);
            if (BasicPushStatus.SUCCESS_CODE.equals(unRegisterStatus2.getCode())) {
                com.meizu.cloud.pushsdk.util.b.g(this.e, "", this.h);
                return unRegisterStatus2;
            }
            return unRegisterStatus2;
        }
        com.meizu.cloud.pushsdk.b.b.a c = b.c();
        if (c.a() != null) {
            com.meizu.cloud.a.a.e("Strategy", "status code=" + c.b() + " data=" + c.a());
        }
        unRegisterStatus.setCode(String.valueOf(c.b()));
        unRegisterStatus.setMessage(c.c());
        com.meizu.cloud.a.a.e("Strategy", "unRegisterStatus " + unRegisterStatus);
        return unRegisterStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public UnRegisterStatus f() {
        return null;
    }
}
