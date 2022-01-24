package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes3.dex */
public class f extends c<PushSwitchStatus> {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f58892b;

    /* renamed from: c  reason: collision with root package name */
    public int f58893c;
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
        this.f58893c = 0;
        this.m = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f58892b = str3;
    }

    private void c(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName(), z);
    }

    private void d(boolean z) {
        com.meizu.cloud.pushsdk.util.b.b(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName(), z);
    }

    private void e(boolean z) {
        com.meizu.cloud.pushsdk.util.b.a(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName(), z);
        com.meizu.cloud.pushsdk.util.b.b(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.m;
        map.put(this.f58885h + "_" + this.f58893c, Boolean.valueOf(z));
    }

    private boolean p() {
        return com.meizu.cloud.pushsdk.util.b.e(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName());
    }

    private boolean q() {
        return com.meizu.cloud.pushsdk.util.b.f(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName());
    }

    private boolean r() {
        return com.meizu.cloud.pushsdk.util.b.h(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName());
    }

    private boolean s() {
        return com.meizu.cloud.pushsdk.util.b.i(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.m;
        Boolean bool = map.get(this.f58885h + "_" + this.f58893c);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        c.k.a.a.a.b("Strategy", "isSyncPushStatus " + this.f58885h + " switch type->" + this.f58893c + " flag->" + booleanValue);
        return booleanValue;
    }

    public void a(int i2) {
        this.f58893c = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.f58882e, !TextUtils.isEmpty(this.f58885h) ? this.f58885h : this.f58882e.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.f58892b = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f58883f) || TextUtils.isEmpty(this.f58884g) || TextUtils.isEmpty(this.f58892b)) ? false : true;
    }

    public void b(boolean z) {
        this.a = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f58883f);
        intent.putExtra("app_key", this.f58884g);
        intent.putExtra("strategy_package_name", this.f58882e.getPackageName());
        intent.putExtra("push_id", this.f58892b);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f58893c);
        intent.putExtra("strategy_params", this.a ? "1" : "0");
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
        if (TextUtils.isEmpty(this.f58883f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f58884g)) {
            if (TextUtils.isEmpty(this.f58892b)) {
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
        int i2;
        boolean p;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.f58892b);
        pushSwitchStatus.setCode(BasicPushStatus.SUCCESS_CODE);
        int i3 = this.f58893c;
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
                        a = this.f58887j.c(this.f58883f, this.f58884g, this.f58892b);
                    }
                } else if (i3 == 3) {
                    pushSwitchStatus.setMessage("SWITCH_ALL");
                    if (p() == this.a && r() == this.a && !t()) {
                        p = this.a;
                    } else {
                        f(true);
                        e(this.a);
                        a = this.f58887j.a(this.f58883f, this.f58884g, this.f58892b, this.a);
                    }
                }
                if (a != null) {
                    if (a.b()) {
                        PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus((String) a.a());
                        c.k.a.a.a.b("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                        if (BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
                            f(false);
                            c.k.a.a.a.b("Strategy", "update local switch preference");
                            pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                            pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                            c(pushSwitchStatus2.isSwitchNotificationMessage());
                            d(pushSwitchStatus2.isSwitchThroughMessage());
                        }
                    } else {
                        com.meizu.cloud.pushsdk.b.b.a c2 = a.c();
                        if (c2.a() != null) {
                            c.k.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                        }
                        pushSwitchStatus.setCode(String.valueOf(c2.b()));
                        pushSwitchStatus.setMessage(c2.c());
                        c.k.a.a.a.b("Strategy", "pushSwitchStatus " + pushSwitchStatus);
                    }
                }
                c.k.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l && !this.k) {
                    i2 = this.f58893c;
                    if (i2 != 0 || i2 == 1) {
                        PlatformMessageSender.a(this.f58882e, this.f58893c, this.a, this.f58885h);
                    } else if (i2 == 3) {
                        PlatformMessageSender.a(this.f58882e, 0, this.a, this.f58885h);
                        PlatformMessageSender.a(this.f58882e, 1, this.a, this.f58885h);
                    }
                }
                return pushSwitchStatus;
            }
            pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
            if (r() != this.a || t()) {
                f(true);
                d(this.a);
                a = this.f58887j.a(this.f58883f, this.f58884g, this.f58892b, this.f58893c, this.a);
                if (a != null) {
                }
                c.k.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
                if (this.l) {
                    i2 = this.f58893c;
                    if (i2 != 0) {
                    }
                    PlatformMessageSender.a(this.f58882e, this.f58893c, this.a, this.f58885h);
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
                a = this.f58887j.a(this.f58883f, this.f58884g, this.f58892b, this.f58893c, this.a);
                if (a != null) {
                }
                c.k.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
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
        c.k.a.a.a.b("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
        if (this.l) {
        }
        return pushSwitchStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public PushSwitchStatus f() {
        int i2 = this.f58893c;
        if (i2 == 0) {
            c(this.a);
            return null;
        } else if (i2 == 1) {
            d(this.a);
            return null;
        } else if (i2 != 3) {
            return null;
        } else {
            e(this.a);
            return null;
        }
    }
}
