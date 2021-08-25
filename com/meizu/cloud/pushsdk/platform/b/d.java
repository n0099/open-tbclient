package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes10.dex */
public class d extends c<SubAliasStatus> {

    /* renamed from: a  reason: collision with root package name */
    public String f74816a;

    /* renamed from: b  reason: collision with root package name */
    public int f74817b;

    /* renamed from: c  reason: collision with root package name */
    public String f74818c;
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
        this.f74816a = str3;
    }

    private void b(boolean z) {
        Map<String, Boolean> map = this.m;
        map.put(this.f74812h + "_" + this.f74817b, Boolean.valueOf(z));
    }

    private void f(String str) {
        com.meizu.cloud.pushsdk.util.b.h(this.f74809e, !TextUtils.isEmpty(this.f74812h) ? this.f74812h : this.f74809e.getPackageName(), str);
    }

    private String p() {
        return com.meizu.cloud.pushsdk.util.b.g(this.f74809e, !TextUtils.isEmpty(this.f74812h) ? this.f74812h : this.f74809e.getPackageName());
    }

    private boolean q() {
        Map<String, Boolean> map = this.m;
        Boolean bool = map.get(this.f74812h + "_" + this.f74817b);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private boolean r() {
        return !this.k && "com.meizu.cloud".equals(this.f74812h);
    }

    public void a(int i2) {
        this.f74817b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.a(this.f74809e, !TextUtils.isEmpty(this.f74812h) ? this.f74812h : this.f74809e.getPackageName(), subAliasStatus);
    }

    public void a(String str) {
        this.f74818c = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f74810f) || TextUtils.isEmpty(this.f74811g) || TextUtils.isEmpty(this.f74816a)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        if (this.f74817b != 2) {
            Intent intent = new Intent();
            intent.putExtra("app_id", this.f74810f);
            intent.putExtra("app_key", this.f74811g);
            intent.putExtra("strategy_package_name", this.f74809e.getPackageName());
            intent.putExtra("push_id", this.f74816a);
            intent.putExtra("strategy_type", g());
            intent.putExtra("strategy_child_type", this.f74817b);
            intent.putExtra("strategy_params", this.f74818c);
            return intent;
        }
        return null;
    }

    public void e(String str) {
        this.f74816a = str;
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
        if (TextUtils.isEmpty(this.f74810f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f74811g)) {
            if (TextUtils.isEmpty(this.f74816a)) {
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
        subAliasStatus.setPushId(this.f74816a);
        String str = "";
        subAliasStatus.setMessage("");
        int i2 = this.f74817b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    subAliasStatus.setAlias(p());
                    subAliasStatus.setCode("200");
                }
            } else if (!TextUtils.isEmpty(p()) || q()) {
                b(true);
                if (r()) {
                    f("");
                }
                c2 = this.f74814j.d(this.f74810f, this.f74811g, this.f74816a, this.f74818c);
                if (c2 != null) {
                    if (c2.b()) {
                        subAliasStatus = new SubAliasStatus((String) c2.a());
                        c.l.a.a.a.b("Strategy", "network subAliasStatus " + subAliasStatus);
                        if ("200".equals(subAliasStatus.getCode())) {
                            b(false);
                        }
                    } else {
                        com.meizu.cloud.pushsdk.b.b.a c3 = c2.c();
                        if (c3.a() != null) {
                            c.l.a.a.a.b("Strategy", "status code=" + c3.b() + " data=" + c3.a());
                        }
                        subAliasStatus.setCode(String.valueOf(c3.b()));
                        subAliasStatus.setMessage(c3.c());
                        c.l.a.a.a.b("Strategy", "subAliasStatus " + subAliasStatus);
                    }
                }
                return subAliasStatus;
            } else {
                subAliasStatus.setCode("200");
                subAliasStatus.setAlias(str);
            }
        } else if (!this.f74818c.equals(p()) || q()) {
            b(true);
            if (r()) {
                f(this.f74818c);
            }
            c2 = this.f74814j.c(this.f74810f, this.f74811g, this.f74816a, this.f74818c);
            if (c2 != null) {
            }
            return subAliasStatus;
        } else {
            subAliasStatus.setCode("200");
            str = this.f74818c;
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
        if (this.f74817b != 2) {
            return null;
        }
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode("200");
        subAliasStatus.setPushId(this.f74816a);
        subAliasStatus.setAlias(p());
        subAliasStatus.setMessage("check alias success");
        return subAliasStatus;
    }
}
