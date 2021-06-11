package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class f extends c<PushSwitchStatus> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f38707a;

    /* renamed from: b  reason: collision with root package name */
    public String f38708b;

    /* renamed from: c  reason: collision with root package name */
    public int f38709c;
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
        this.f38709c = 0;
        this.m = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f38708b = str3;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.m;
        map.put(this.f38698h + "_" + this.f38709c, Boolean.valueOf(z));
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.m;
        Boolean bool = map.get(this.f38698h + "_" + this.f38709c);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        d.j.a.a.a.b("Strategy", "isSyncPushStatus " + this.f38698h + " switch type->" + this.f38709c + " flag->" + booleanValue);
        return booleanValue;
    }

    public void a(int i2) {
        this.f38709c = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.f38695e, !TextUtils.isEmpty(this.f38698h) ? this.f38698h : this.f38695e.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.f38708b = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f38696f) || TextUtils.isEmpty(this.f38697g) || TextUtils.isEmpty(this.f38708b)) ? false : true;
    }

    public void b(boolean z) {
        this.f38707a = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra(Constants.APP_ID, this.f38696f);
        intent.putExtra("app_key", this.f38697g);
        intent.putExtra("strategy_package_name", this.f38695e.getPackageName());
        intent.putExtra("push_id", this.f38708b);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f38709c);
        intent.putExtra("strategy_params", this.f38707a ? "1" : "0");
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
        if (TextUtils.isEmpty(this.f38696f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f38697g)) {
            if (TextUtils.isEmpty(this.f38708b)) {
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
        int i2;
        boolean p;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.f38708b);
        pushSwitchStatus.setCode("200");
        int i3 = this.f38709c;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    pushSwitchStatus.setMessage("CHECK_PUSH");
                    if (q() && s() && !t()) {
                        z = p();
                        pushSwitchStatus.setSwitchNotificationMessage(z);
                        r = r();
                        pushSwitchStatus.setSwitchThroughMessage(r);
                    } else {
                        f(true);
                        a2 = this.j.c(this.f38696f, this.f38697g, this.f38708b);
                    }
                } else if (i3 == 3) {
                    pushSwitchStatus.setMessage("SWITCH_ALL");
                    if (p() == this.f38707a && r() == this.f38707a && !t()) {
                        p = this.f38707a;
                    } else {
                        f(true);
                        e(this.f38707a);
                        a2 = this.j.a(this.f38696f, this.f38697g, this.f38708b, this.f38707a);
                    }
                }
                if (a2 != null) {
                    if (a2.b()) {
                        PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus((String) a2.a());
                        d.j.a.a.a.b("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                        if ("200".equals(pushSwitchStatus.getCode())) {
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
                    i2 = this.f38709c;
                    if (i2 != 0 || i2 == 1) {
                        PlatformMessageSender.a(this.f38695e, this.f38709c, this.f38707a, this.f38698h);
                    } else if (i2 == 3) {
                        PlatformMessageSender.a(this.f38695e, 0, this.f38707a, this.f38698h);
                        PlatformMessageSender.a(this.f38695e, 1, this.f38707a, this.f38698h);
                    }
                }
                return pushSwitchStatus;
            }
            pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
            if (r() != this.f38707a || t()) {
                f(true);
                d(this.f38707a);
                a2 = this.j.a(this.f38696f, this.f38697g, this.f38708b, this.f38709c, this.f38707a);
                if (a2 != null) {
                }
                d.j.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l) {
                    i2 = this.f38709c;
                    if (i2 != 0) {
                    }
                    PlatformMessageSender.a(this.f38695e, this.f38709c, this.f38707a, this.f38698h);
                }
                return pushSwitchStatus;
            }
            p = p();
            pushSwitchStatus.setSwitchNotificationMessage(p);
            r = this.f38707a;
            pushSwitchStatus.setSwitchThroughMessage(r);
        } else {
            pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
            if (p() != this.f38707a || t()) {
                f(true);
                c(this.f38707a);
                a2 = this.j.a(this.f38696f, this.f38697g, this.f38708b, this.f38709c, this.f38707a);
                if (a2 != null) {
                }
                d.j.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l) {
                }
                return pushSwitchStatus;
            }
            z = this.f38707a;
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
        int i2 = this.f38709c;
        if (i2 == 0) {
            c(this.f38707a);
            return null;
        } else if (i2 == 1) {
            d(this.f38707a);
            return null;
        } else if (i2 != 3) {
            return null;
        } else {
            e(this.f38707a);
            return null;
        }
    }
}
