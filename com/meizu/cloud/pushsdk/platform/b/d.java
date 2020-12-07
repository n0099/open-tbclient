package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes16.dex */
public class d extends c<SubAliasStatus> {

    /* renamed from: a  reason: collision with root package name */
    private String f4215a;
    private int b;
    private String c;
    private Map<String, Boolean> m;

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
        this.f4215a = str3;
    }

    private void b(boolean z) {
        this.m.put(this.h + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.b, Boolean.valueOf(z));
    }

    private void f(String str) {
        com.meizu.cloud.pushsdk.util.b.h(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), str);
    }

    private String p() {
        return com.meizu.cloud.pushsdk.util.b.g(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName());
    }

    private boolean q() {
        Boolean bool = this.m.get(this.h + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.b);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private boolean r() {
        return !this.k && "com.meizu.cloud".equals(this.h);
    }

    public void a(int i) {
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), subAliasStatus);
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.f4215a)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        if (this.b != 2) {
            Intent intent = new Intent();
            intent.putExtra("app_id", this.f);
            intent.putExtra("app_key", this.g);
            intent.putExtra("strategy_package_name", this.e.getPackageName());
            intent.putExtra("push_id", this.f4215a);
            intent.putExtra("strategy_type", g());
            intent.putExtra("strategy_child_type", this.b);
            intent.putExtra("strategy_params", this.c);
            return intent;
        }
        return null;
    }

    public void e(String str) {
        this.f4215a = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public SubAliasStatus b() {
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f)) {
            subAliasStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.g)) {
            subAliasStatus.setMessage("appKey not empty");
        } else if (TextUtils.isEmpty(this.f4215a)) {
            subAliasStatus.setMessage("pushId not empty");
        }
        return subAliasStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public SubAliasStatus e() {
        com.meizu.cloud.pushsdk.b.a.c d;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setPushId(this.f4215a);
        subAliasStatus.setMessage("");
        switch (this.b) {
            case 0:
                if (this.c.equals(p()) && !q()) {
                    subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
                    subAliasStatus.setAlias(this.c);
                    d = null;
                    break;
                } else {
                    b(true);
                    if (r()) {
                        f(this.c);
                    }
                    d = this.j.c(this.f, this.g, this.f4215a, this.c);
                    break;
                }
                break;
            case 1:
                if (TextUtils.isEmpty(p()) && !q()) {
                    subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
                    subAliasStatus.setAlias("");
                    d = null;
                    break;
                } else {
                    b(true);
                    if (r()) {
                        f("");
                    }
                    d = this.j.d(this.f, this.g, this.f4215a, this.c);
                    break;
                }
            case 2:
                subAliasStatus.setAlias(p());
                subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            default:
                d = null;
                break;
        }
        if (d != null) {
            if (d.b()) {
                SubAliasStatus subAliasStatus2 = new SubAliasStatus((String) d.a());
                com.meizu.cloud.a.a.e("Strategy", "network subAliasStatus " + subAliasStatus2);
                if (BasicPushStatus.SUCCESS_CODE.equals(subAliasStatus2.getCode())) {
                    b(false);
                    return subAliasStatus2;
                }
                return subAliasStatus2;
            }
            com.meizu.cloud.pushsdk.b.b.a c = d.c();
            if (c.a() != null) {
                com.meizu.cloud.a.a.e("Strategy", "status code=" + c.b() + " data=" + c.a());
            }
            subAliasStatus.setCode(String.valueOf(c.b()));
            subAliasStatus.setMessage(c.c());
            com.meizu.cloud.a.a.e("Strategy", "subAliasStatus " + subAliasStatus);
            return subAliasStatus;
        }
        return subAliasStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubAliasStatus f() {
        switch (this.b) {
            case 2:
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(BasicPushStatus.SUCCESS_CODE);
                subAliasStatus.setPushId(this.f4215a);
                subAliasStatus.setAlias(p());
                subAliasStatus.setMessage("check alias success");
                return subAliasStatus;
            default:
                return null;
        }
    }
}
