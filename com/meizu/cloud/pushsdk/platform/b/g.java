package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
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
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(UnRegisterStatus unRegisterStatus) {
        PlatformMessageSender.a(this.f67698e, !TextUtils.isEmpty(this.f67701h) ? this.f67701h : this.f67698e.getPackageName(), unRegisterStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f67699f) || TextUtils.isEmpty(this.f67700g)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f67699f);
        intent.putExtra("app_key", this.f67700g);
        intent.putExtra("strategy_package_name", this.f67698e.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 32;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public UnRegisterStatus b() {
        String str;
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        unRegisterStatus.setCode(LightappConstants.ERRCODE_NOT_ALLOWED_BACKGROUND);
        if (!TextUtils.isEmpty(this.f67699f)) {
            str = TextUtils.isEmpty(this.f67700g) ? "appKey not empty" : "appKey not empty";
            return unRegisterStatus;
        }
        str = "appId not empty";
        unRegisterStatus.setMessage(str);
        return unRegisterStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public UnRegisterStatus e() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        if (TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.a(this.f67698e, this.f67701h))) {
            unRegisterStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            unRegisterStatus.setMessage("already unRegister PushId,dont unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
        } else {
            this.f67702i = o();
            com.meizu.cloud.pushsdk.b.a.c b2 = this.j.b(this.f67699f, this.f67700g, this.f67702i);
            if (b2.b()) {
                unRegisterStatus = new UnRegisterStatus((String) b2.a());
                b.l.a.a.a.b("Strategy", "network unRegisterStatus " + unRegisterStatus);
                if (BasicPushStatus.SUCCESS_CODE.equals(unRegisterStatus.getCode())) {
                    com.meizu.cloud.pushsdk.util.b.g(this.f67698e, "", this.f67701h);
                }
            } else {
                com.meizu.cloud.pushsdk.b.b.a c2 = b2.c();
                if (c2.a() != null) {
                    b.l.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                }
                unRegisterStatus.setCode(String.valueOf(c2.b()));
                unRegisterStatus.setMessage(c2.c());
                b.l.a.a.a.b("Strategy", "unRegisterStatus " + unRegisterStatus);
            }
        }
        return unRegisterStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public UnRegisterStatus f() {
        return null;
    }
}
