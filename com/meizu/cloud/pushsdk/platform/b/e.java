package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class e extends c<SubTagsStatus> {

    /* renamed from: a  reason: collision with root package name */
    private String f4446a;
    private int b;
    private String c;

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public e(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public e(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.b = 3;
    }

    public e(Context context, String str, String str2, String str3, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.f4446a = str3;
    }

    public void a(int i) {
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), subTagsStatus);
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.f4446a)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f);
        intent.putExtra("app_key", this.g);
        intent.putExtra("strategy_package_name", this.e.getPackageName());
        intent.putExtra("push_id", this.f4446a);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.b);
        intent.putExtra("strategy_params", this.c);
        return intent;
    }

    public void e(String str) {
        this.f4446a = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public SubTagsStatus b() {
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        subTagsStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f)) {
            subTagsStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.g)) {
            subTagsStatus.setMessage("appKey not empty");
        } else if (TextUtils.isEmpty(this.f4446a)) {
            subTagsStatus.setMessage("pushId not empty");
        }
        return subTagsStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public SubTagsStatus e() {
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        com.meizu.cloud.pushsdk.b.a.c cVar = null;
        switch (this.b) {
            case 0:
                cVar = this.j.a(this.f, this.g, this.f4446a, this.c);
                break;
            case 1:
                cVar = this.j.b(this.f, this.g, this.f4446a, this.c);
                break;
            case 2:
                cVar = this.j.d(this.f, this.g, this.f4446a);
                break;
            case 3:
                cVar = this.j.e(this.f, this.g, this.f4446a);
                break;
        }
        if (cVar.b()) {
            SubTagsStatus subTagsStatus2 = new SubTagsStatus((String) cVar.a());
            com.meizu.cloud.a.a.e("Strategy", "network subTagsStatus " + subTagsStatus2);
            return subTagsStatus2;
        }
        com.meizu.cloud.pushsdk.b.b.a c = cVar.c();
        if (c.a() != null) {
            com.meizu.cloud.a.a.e("Strategy", "status code=" + c.b() + " data=" + c.a());
        }
        subTagsStatus.setCode(String.valueOf(c.b()));
        subTagsStatus.setMessage(c.c());
        com.meizu.cloud.a.a.e("Strategy", "subTagsStatus " + subTagsStatus);
        return subTagsStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubTagsStatus f() {
        return null;
    }
}
