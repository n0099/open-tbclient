package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public class f extends c<PushSwitchStatus> {
    public boolean a;
    public String b;
    public int c;
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
        this.c = 0;
        this.m = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.b = str3;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.m;
        map.put(this.h + "_" + this.c, Boolean.valueOf(z));
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.m;
        Boolean bool = map.get(this.h + "_" + this.c);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        DebugLogger.e("Strategy", "isSyncPushStatus " + this.h + " switch type->" + this.c + " flag->" + booleanValue);
        return booleanValue;
    }

    /* JADX DEBUG: Possible override for method com.meizu.cloud.pushsdk.platform.b.c.a(I)Z */
    public void a(int i) {
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.b)) ? false : true;
    }

    public void b(boolean z) {
        this.a = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f);
        intent.putExtra("app_key", this.g);
        intent.putExtra("strategy_package_name", this.e.getPackageName());
        intent.putExtra("push_id", this.b);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.c);
        intent.putExtra("strategy_params", this.a ? "1" : "0");
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 16;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Possible override for method com.meizu.cloud.pushsdk.platform.b.c.h()Z */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public PushSwitchStatus b() {
        String str;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.g)) {
            if (TextUtils.isEmpty(this.b)) {
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
        com.meizu.cloud.pushsdk.b.a.c a;
        boolean r;
        int i;
        boolean p;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.b);
        pushSwitchStatus.setCode(BasicPushStatus.SUCCESS_CODE);
        int i2 = this.c;
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
                        a = this.j.c(this.f, this.g, this.b);
                    }
                } else if (i2 == 3) {
                    pushSwitchStatus.setMessage("SWITCH_ALL");
                    if (p() == this.a && r() == this.a && !t()) {
                        p = this.a;
                    } else {
                        f(true);
                        e(this.a);
                        a = this.j.a(this.f, this.g, this.b, this.a);
                    }
                }
                if (a != null) {
                    if (a.b()) {
                        PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus((String) a.a());
                        DebugLogger.e("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                        if (BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
                            f(false);
                            DebugLogger.e("Strategy", "update local switch preference");
                            pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                            pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                            c(pushSwitchStatus2.isSwitchNotificationMessage());
                            d(pushSwitchStatus2.isSwitchThroughMessage());
                        }
                    } else {
                        com.meizu.cloud.pushsdk.b.b.a c = a.c();
                        if (c.a() != null) {
                            DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                        }
                        pushSwitchStatus.setCode(String.valueOf(c.b()));
                        pushSwitchStatus.setMessage(c.c());
                        DebugLogger.e("Strategy", "pushSwitchStatus " + pushSwitchStatus);
                    }
                }
                DebugLogger.e("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l && !this.k) {
                    i = this.c;
                    if (i != 0 || i == 1) {
                        PlatformMessageSender.a(this.e, this.c, this.a, this.h);
                    } else if (i == 3) {
                        PlatformMessageSender.a(this.e, 0, this.a, this.h);
                        PlatformMessageSender.a(this.e, 1, this.a, this.h);
                    }
                }
                return pushSwitchStatus;
            }
            pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
            if (r() != this.a || t()) {
                f(true);
                d(this.a);
                a = this.j.a(this.f, this.g, this.b, this.c, this.a);
                if (a != null) {
                }
                DebugLogger.e("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l) {
                    i = this.c;
                    if (i != 0) {
                    }
                    PlatformMessageSender.a(this.e, this.c, this.a, this.h);
                }
                return pushSwitchStatus;
            }
            p = p();
            pushSwitchStatus.setSwitchNotificationMessage(p);
            r = this.a;
            pushSwitchStatus.setSwitchThroughMessage(r);
        } else {
            pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
            if (p() != this.a || t()) {
                f(true);
                c(this.a);
                a = this.j.a(this.f, this.g, this.b, this.c, this.a);
                if (a != null) {
                }
                DebugLogger.e("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l) {
                }
                return pushSwitchStatus;
            }
            z = this.a;
            pushSwitchStatus.setSwitchNotificationMessage(z);
            r = r();
            pushSwitchStatus.setSwitchThroughMessage(r);
        }
        a = null;
        if (a != null) {
        }
        DebugLogger.e("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
        if (this.l) {
        }
        return pushSwitchStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public PushSwitchStatus f() {
        int i = this.c;
        if (i == 0) {
            c(this.a);
            return null;
        } else if (i == 1) {
            d(this.a);
            return null;
        } else if (i != 3) {
            return null;
        } else {
            e(this.a);
            return null;
        }
    }
}
