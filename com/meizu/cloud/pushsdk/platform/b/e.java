package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class e extends c<SubTagsStatus> {

    /* renamed from: a  reason: collision with root package name */
    public String f40565a;

    /* renamed from: b  reason: collision with root package name */
    public int f40566b;

    /* renamed from: c  reason: collision with root package name */
    public String f40567c;

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public e(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f40566b = 3;
    }

    public e(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f40565a = str3;
    }

    public void a(int i2) {
        this.f40566b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.a(this.f40556e, !TextUtils.isEmpty(this.f40559h) ? this.f40559h : this.f40556e.getPackageName(), subTagsStatus);
    }

    public void a(String str) {
        this.f40567c = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f40557f) || TextUtils.isEmpty(this.f40558g) || TextUtils.isEmpty(this.f40565a)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f40557f);
        intent.putExtra("app_key", this.f40558g);
        intent.putExtra("strategy_package_name", this.f40556e.getPackageName());
        intent.putExtra("push_id", this.f40565a);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f40566b);
        intent.putExtra("strategy_params", this.f40567c);
        return intent;
    }

    public void e(String str) {
        this.f40565a = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public SubTagsStatus b() {
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        subTagsStatus.setCode(LightappConstants.ERRCODE_NOT_ALLOWED_BACKGROUND);
        if (TextUtils.isEmpty(this.f40557f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f40558g)) {
            if (TextUtils.isEmpty(this.f40565a)) {
                str = "pushId not empty";
            }
            return subTagsStatus;
        } else {
            str = "appKey not empty";
        }
        subTagsStatus.setMessage(str);
        return subTagsStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public SubTagsStatus e() {
        StringBuilder sb;
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        int i2 = this.f40566b;
        com.meizu.cloud.pushsdk.b.a.c e2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : this.j.e(this.f40557f, this.f40558g, this.f40565a) : this.j.d(this.f40557f, this.f40558g, this.f40565a) : this.j.b(this.f40557f, this.f40558g, this.f40565a, this.f40567c) : this.j.a(this.f40557f, this.f40558g, this.f40565a, this.f40567c);
        if (e2.b()) {
            subTagsStatus = new SubTagsStatus((String) e2.a());
            sb = new StringBuilder();
            str = "network subTagsStatus ";
        } else {
            com.meizu.cloud.pushsdk.b.b.a c2 = e2.c();
            if (c2.a() != null) {
                d.h.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
            }
            subTagsStatus.setCode(String.valueOf(c2.b()));
            subTagsStatus.setMessage(c2.c());
            sb = new StringBuilder();
            str = "subTagsStatus ";
        }
        sb.append(str);
        sb.append(subTagsStatus);
        d.h.a.a.a.b("Strategy", sb.toString());
        return subTagsStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubTagsStatus f() {
        return null;
    }
}
