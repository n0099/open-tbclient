package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
public class e extends c<SubTagsStatus> {

    /* renamed from: a  reason: collision with root package name */
    public String f37904a;

    /* renamed from: b  reason: collision with root package name */
    public int f37905b;

    /* renamed from: c  reason: collision with root package name */
    public String f37906c;

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public e(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f37905b = 3;
    }

    public e(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f37904a = str3;
    }

    public void a(int i) {
        this.f37905b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.a(this.f37896e, !TextUtils.isEmpty(this.f37899h) ? this.f37899h : this.f37896e.getPackageName(), subTagsStatus);
    }

    public void a(String str) {
        this.f37906c = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f37897f) || TextUtils.isEmpty(this.f37898g) || TextUtils.isEmpty(this.f37904a)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra(Constants.APP_ID, this.f37897f);
        intent.putExtra(com.alipay.sdk.cons.b.f1858h, this.f37898g);
        intent.putExtra("strategy_package_name", this.f37896e.getPackageName());
        intent.putExtra("push_id", this.f37904a);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f37905b);
        intent.putExtra("strategy_params", this.f37906c);
        return intent;
    }

    public void e(String str) {
        this.f37904a = str;
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
        if (TextUtils.isEmpty(this.f37897f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.f37898g)) {
            if (TextUtils.isEmpty(this.f37904a)) {
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
        int i = this.f37905b;
        com.meizu.cloud.pushsdk.b.a.c e2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : this.j.e(this.f37897f, this.f37898g, this.f37904a) : this.j.d(this.f37897f, this.f37898g, this.f37904a) : this.j.b(this.f37897f, this.f37898g, this.f37904a, this.f37906c) : this.j.a(this.f37897f, this.f37898g, this.f37904a, this.f37906c);
        if (e2.b()) {
            subTagsStatus = new SubTagsStatus((String) e2.a());
            sb = new StringBuilder();
            str = "network subTagsStatus ";
        } else {
            com.meizu.cloud.pushsdk.b.b.a c2 = e2.c();
            if (c2.a() != null) {
                d.j.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
            }
            subTagsStatus.setCode(String.valueOf(c2.b()));
            subTagsStatus.setMessage(c2.c());
            sb = new StringBuilder();
            str = "subTagsStatus ";
        }
        sb.append(str);
        sb.append(subTagsStatus);
        d.j.a.a.a.b("Strategy", sb.toString());
        return subTagsStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubTagsStatus f() {
        return null;
    }
}
