package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public class d extends c<SubAliasStatus> {

    /* renamed from: a  reason: collision with root package name */
    public String f68617a;

    /* renamed from: b  reason: collision with root package name */
    public int f68618b;

    /* renamed from: c  reason: collision with root package name */
    public String f68619c;
    public Map<String, Boolean> m;

    public d(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public d(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public d(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.m = new HashMap();
    }

    public d(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f68617a = str3;
    }

    private void b(boolean z) {
        Map<String, Boolean> map = this.m;
        map.put(this.f68614h + "_" + this.f68618b, Boolean.valueOf(z));
    }

    private void f(String str) {
        com.meizu.cloud.pushsdk.util.b.h(this.f68611e, !TextUtils.isEmpty(this.f68614h) ? this.f68614h : this.f68611e.getPackageName(), str);
    }

    private String p() {
        return com.meizu.cloud.pushsdk.util.b.g(this.f68611e, !TextUtils.isEmpty(this.f68614h) ? this.f68614h : this.f68611e.getPackageName());
    }

    private boolean q() {
        Map<String, Boolean> map = this.m;
        Boolean bool = map.get(this.f68614h + "_" + this.f68618b);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private boolean r() {
        return !this.k && "com.meizu.cloud".equals(this.f68614h);
    }

    public void a(int i2) {
        this.f68618b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.a(this.f68611e, !TextUtils.isEmpty(this.f68614h) ? this.f68614h : this.f68611e.getPackageName(), subAliasStatus);
    }

    public void a(String str) {
        this.f68619c = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f68612f) || TextUtils.isEmpty(this.f68613g) || TextUtils.isEmpty(this.f68617a)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        if (this.f68618b != 2) {
            Intent intent = new Intent();
            intent.putExtra("app_id", this.f68612f);
            intent.putExtra("app_key", this.f68613g);
            intent.putExtra("strategy_package_name", this.f68611e.getPackageName());
            intent.putExtra("push_id", this.f68617a);
            intent.putExtra("strategy_type", g());
            intent.putExtra("strategy_child_type", this.f68618b);
            intent.putExtra("strategy_params", this.f68619c);
            return intent;
        }
        return null;
    }

    public void e(String str) {
        this.f68617a = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public SubAliasStatus b() {
        String str;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode(LightappConstants.ERRCODE_NOT_ALLOWED_BACKGROUND);
        if (TextUtils.isEmpty(this.f68612f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f68613g)) {
            if (TextUtils.isEmpty(this.f68617a)) {
                str = "pushId not empty";
            }
            return subAliasStatus;
        } else {
            str = "appKey not empty";
        }
        subAliasStatus.setMessage(str);
        return subAliasStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SubAliasStatus e() {
        com.meizu.cloud.pushsdk.b.a.c c2;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setPushId(this.f68617a);
        String str = "";
        subAliasStatus.setMessage("");
        int i2 = this.f68618b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    subAliasStatus.setAlias(p());
                    subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
                }
            } else if (!TextUtils.isEmpty(p()) || q()) {
                b(true);
                if (r()) {
                    f("");
                }
                c2 = this.j.d(this.f68612f, this.f68613g, this.f68617a, this.f68619c);
                if (c2 != null) {
                    if (c2.b()) {
                        subAliasStatus = new SubAliasStatus((String) c2.a());
                        b.j.a.a.a.b("Strategy", "network subAliasStatus " + subAliasStatus);
                        if (BasicPushStatus.SUCCESS_CODE.equals(subAliasStatus.getCode())) {
                            b(false);
                        }
                    } else {
                        com.meizu.cloud.pushsdk.b.b.a c3 = c2.c();
                        if (c3.a() != null) {
                            b.j.a.a.a.b("Strategy", "status code=" + c3.b() + " data=" + c3.a());
                        }
                        subAliasStatus.setCode(String.valueOf(c3.b()));
                        subAliasStatus.setMessage(c3.c());
                        b.j.a.a.a.b("Strategy", "subAliasStatus " + subAliasStatus);
                    }
                }
                return subAliasStatus;
            } else {
                subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
                subAliasStatus.setAlias(str);
            }
        } else if (!this.f68619c.equals(p()) || q()) {
            b(true);
            if (r()) {
                f(this.f68619c);
            }
            c2 = this.j.c(this.f68612f, this.f68613g, this.f68617a, this.f68619c);
            if (c2 != null) {
            }
            return subAliasStatus;
        } else {
            subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            str = this.f68619c;
            subAliasStatus.setAlias(str);
        }
        c2 = null;
        if (c2 != null) {
        }
        return subAliasStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubAliasStatus f() {
        if (this.f68618b != 2) {
            return null;
        }
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
        subAliasStatus.setPushId(this.f68617a);
        subAliasStatus.setAlias(p());
        subAliasStatus.setMessage("check alias success");
        return subAliasStatus;
    }
}
