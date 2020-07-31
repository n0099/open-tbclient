package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public class f extends c<PushSwitchStatus> {
    boolean a;
    private String b;
    private int c;
    private Map<String, Boolean> m;

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
        this.m.put(this.h + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.c, Boolean.valueOf(z));
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
        Boolean bool = this.m.get(this.h + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.c);
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        com.meizu.cloud.a.a.e("Strategy", "isSyncPushStatus " + this.h + " switch type->" + this.c + " flag->" + booleanValue);
        return booleanValue;
    }

    public void a(int i) {
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.b)) ? false : true;
    }

    public void b(boolean z) {
        this.a = z;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
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
    protected int g() {
        return 16;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public PushSwitchStatus b() {
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f)) {
            pushSwitchStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.g)) {
            pushSwitchStatus.setMessage("appKey not empty");
        } else if (TextUtils.isEmpty(this.b)) {
            pushSwitchStatus.setMessage("pushId not empty");
        }
        return pushSwitchStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public PushSwitchStatus e() {
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.b);
        pushSwitchStatus.setCode(BasicPushStatus.SUCCESS_CODE);
        com.meizu.cloud.pushsdk.b.a.c cVar = null;
        switch (this.c) {
            case 0:
                pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
                if (p() == this.a && !t()) {
                    pushSwitchStatus.setSwitchNotificationMessage(this.a);
                    pushSwitchStatus.setSwitchThroughMessage(r());
                    break;
                } else {
                    f(true);
                    c(this.a);
                    cVar = this.j.a(this.f, this.g, this.b, this.c, this.a);
                    break;
                }
                break;
            case 1:
                pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
                if (r() == this.a && !t()) {
                    pushSwitchStatus.setSwitchNotificationMessage(p());
                    pushSwitchStatus.setSwitchThroughMessage(this.a);
                    break;
                } else {
                    f(true);
                    d(this.a);
                    cVar = this.j.a(this.f, this.g, this.b, this.c, this.a);
                    break;
                }
                break;
            case 2:
                pushSwitchStatus.setMessage("CHECK_PUSH");
                if (!q() || !s() || t()) {
                    f(true);
                    cVar = this.j.c(this.f, this.g, this.b);
                    break;
                } else {
                    pushSwitchStatus.setSwitchNotificationMessage(p());
                    pushSwitchStatus.setSwitchThroughMessage(r());
                    break;
                }
            case 3:
                pushSwitchStatus.setMessage("SWITCH_ALL");
                if (p() != this.a || r() != this.a || t()) {
                    f(true);
                    e(this.a);
                    cVar = this.j.a(this.f, this.g, this.b, this.a);
                    break;
                } else {
                    pushSwitchStatus.setSwitchNotificationMessage(this.a);
                    pushSwitchStatus.setSwitchThroughMessage(this.a);
                    break;
                }
                break;
        }
        if (cVar != null) {
            if (cVar.b()) {
                PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus((String) cVar.a());
                com.meizu.cloud.a.a.e("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                if (BasicPushStatus.SUCCESS_CODE.equals(pushSwitchStatus.getCode())) {
                    f(false);
                    com.meizu.cloud.a.a.e("Strategy", "update local switch preference");
                    pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                    pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                    c(pushSwitchStatus2.isSwitchNotificationMessage());
                    d(pushSwitchStatus2.isSwitchThroughMessage());
                }
            } else {
                com.meizu.cloud.pushsdk.b.b.a c = cVar.c();
                if (c.a() != null) {
                    com.meizu.cloud.a.a.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                }
                pushSwitchStatus.setCode(String.valueOf(c.b()));
                pushSwitchStatus.setMessage(c.c());
                com.meizu.cloud.a.a.e("Strategy", "pushSwitchStatus " + pushSwitchStatus);
            }
        }
        com.meizu.cloud.a.a.e("Strategy", "enableRPC " + this.l + " isSupportRemoteInvoke " + this.k);
        if (this.l && !this.k) {
            switch (this.c) {
                case 0:
                case 1:
                    PlatformMessageSender.a(this.e, this.c, this.a, this.h);
                    break;
                case 3:
                    PlatformMessageSender.a(this.e, 0, this.a, this.h);
                    PlatformMessageSender.a(this.e, 1, this.a, this.h);
                    break;
            }
        }
        return pushSwitchStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public PushSwitchStatus f() {
        switch (this.c) {
            case 0:
                c(this.a);
                break;
            case 1:
                d(this.a);
                break;
            case 3:
                e(this.a);
                break;
        }
        return null;
    }
}
