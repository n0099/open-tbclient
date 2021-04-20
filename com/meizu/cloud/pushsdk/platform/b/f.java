package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
public class f extends c<PushSwitchStatus> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f38197a;

    /* renamed from: b  reason: collision with root package name */
    public String f38198b;

    /* renamed from: c  reason: collision with root package name */
    public int f38199c;
    public Map<String, Boolean> m;

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public f(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public f(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f38199c = 0;
        this.m = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f38198b = str3;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.m;
        map.put(this.f38189h + "_" + this.f38199c, Boolean.valueOf(z));
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.m;
        Boolean bool = map.get(this.f38189h + "_" + this.f38199c);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        d.j.a.a.a.b("Strategy", "isSyncPushStatus " + this.f38189h + " switch type->" + this.f38199c + " flag->" + booleanValue);
        return booleanValue;
    }

    public void a(int i) {
        this.f38199c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.f38186e, !TextUtils.isEmpty(this.f38189h) ? this.f38189h : this.f38186e.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.f38198b = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f38187f) || TextUtils.isEmpty(this.f38188g) || TextUtils.isEmpty(this.f38198b)) ? false : true;
    }

    public void b(boolean z) {
        this.f38197a = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra(Constants.APP_ID, this.f38187f);
        intent.putExtra(com.alipay.sdk.cons.b.f1883h, this.f38188g);
        intent.putExtra("strategy_package_name", this.f38186e.getPackageName());
        intent.putExtra("push_id", this.f38198b);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f38199c);
        intent.putExtra("strategy_params", this.f38197a ? "1" : "0");
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 16;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public PushSwitchStatus b() {
        String str;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode(LightappConstants.ERRCODE_NOT_ALLOWED_BACKGROUND);
        if (TextUtils.isEmpty(this.f38187f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f38188g)) {
            if (TextUtils.isEmpty(this.f38198b)) {
                str = "pushId not empty";
            }
            return pushSwitchStatus;
        } else {
            str = "appKey not empty";
        }
        pushSwitchStatus.setMessage(str);
        return pushSwitchStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b0  */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PushSwitchStatus e() {
        boolean z;
        com.meizu.cloud.pushsdk.b.a.c a2;
        boolean r;
        int i;
        boolean p;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.f38198b);
        pushSwitchStatus.setCode(BasicPushStatus.SUCCESS_CODE);
        int i2 = this.f38199c;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    pushSwitchStatus.setMessage("CHECK_PUSH");
                    if (q() && s() && !t()) {
                        z = p();
                        pushSwitchStatus.setSwitchNotificationMessage(z);
                        r = r();
                        pushSwitchStatus.setSwitchThroughMessage(r);
                    } else {
                        f(true);
                        a2 = this.j.c(this.f38187f, this.f38188g, this.f38198b);
                    }
                } else if (i2 == 3) {
                    pushSwitchStatus.setMessage("SWITCH_ALL");
                    if (p() == this.f38197a && r() == this.f38197a && !t()) {
                        p = this.f38197a;
                    } else {
                        f(true);
                        e(this.f38197a);
                        a2 = this.j.a(this.f38187f, this.f38188g, this.f38198b, this.f38197a);
                    }
                }
                if (a2 != null) {
                    if (a2.b()) {
                        PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus((String) a2.a());
                        d.j.a.a.a.b("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                        if (BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
                            f(false);
                            d.j.a.a.a.b("Strategy", "update local switch preference");
                            pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                            pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                            c(pushSwitchStatus2.isSwitchNotificationMessage());
                            d(pushSwitchStatus2.isSwitchThroughMessage());
                        }
                    } else {
                        com.meizu.cloud.pushsdk.b.b.a c2 = a2.c();
                        if (c2.a() != null) {
                            d.j.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                        }
                        pushSwitchStatus.setCode(String.valueOf(c2.b()));
                        pushSwitchStatus.setMessage(c2.c());
                        d.j.a.a.a.b("Strategy", "pushSwitchStatus " + pushSwitchStatus);
                    }
                }
                d.j.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l && !this.k) {
                    i = this.f38199c;
                    if (i != 0 || i == 1) {
                        PlatformMessageSender.a(this.f38186e, this.f38199c, this.f38197a, this.f38189h);
                    } else if (i == 3) {
                        PlatformMessageSender.a(this.f38186e, 0, this.f38197a, this.f38189h);
                        PlatformMessageSender.a(this.f38186e, 1, this.f38197a, this.f38189h);
                    }
                }
                return pushSwitchStatus;
            }
            pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
            if (r() != this.f38197a || t()) {
                f(true);
                d(this.f38197a);
                a2 = this.j.a(this.f38187f, this.f38188g, this.f38198b, this.f38199c, this.f38197a);
                if (a2 != null) {
                }
                d.j.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l) {
                    i = this.f38199c;
                    if (i != 0) {
                    }
                    PlatformMessageSender.a(this.f38186e, this.f38199c, this.f38197a, this.f38189h);
                }
                return pushSwitchStatus;
            }
            p = p();
            pushSwitchStatus.setSwitchNotificationMessage(p);
            r = this.f38197a;
            pushSwitchStatus.setSwitchThroughMessage(r);
        } else {
            pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
            if (p() != this.f38197a || t()) {
                f(true);
                c(this.f38197a);
                a2 = this.j.a(this.f38187f, this.f38188g, this.f38198b, this.f38199c, this.f38197a);
                if (a2 != null) {
                }
                d.j.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l) {
                }
                return pushSwitchStatus;
            }
            z = this.f38197a;
            pushSwitchStatus.setSwitchNotificationMessage(z);
            r = r();
            pushSwitchStatus.setSwitchThroughMessage(r);
        }
        a2 = null;
        if (a2 != null) {
        }
        d.j.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
        if (this.l) {
        }
        return pushSwitchStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public PushSwitchStatus f() {
        int i = this.f38199c;
        if (i == 0) {
            c(this.f38197a);
            return null;
        } else if (i == 1) {
            d(this.f38197a);
            return null;
        } else if (i != 3) {
            return null;
        } else {
            e(this.f38197a);
            return null;
        }
    }
}
