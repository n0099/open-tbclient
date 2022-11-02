package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public class e extends c<SubTagsStatus> {
    public String a;
    public int b;
    public String c;

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
        this.a = str3;
    }

    public void a(int i) {
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), subTagsStatus);
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.a)) ? false : true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f);
        intent.putExtra(GameGuideConfigInfo.KEY_APP_KEY, this.g);
        intent.putExtra("strategy_package_name", this.e.getPackageName());
        intent.putExtra("push_id", this.a);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.b);
        intent.putExtra("strategy_params", this.c);
        return intent;
    }

    public void e(String str) {
        this.a = str;
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
        subTagsStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f)) {
            str = "appId not empty";
        } else if (!TextUtils.isEmpty(this.g)) {
            if (TextUtils.isEmpty(this.a)) {
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
        int i = this.b;
        com.meizu.cloud.pushsdk.b.a.c e = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : this.j.e(this.f, this.g, this.a) : this.j.d(this.f, this.g, this.a) : this.j.b(this.f, this.g, this.a, this.c) : this.j.a(this.f, this.g, this.a, this.c);
        if (e.b()) {
            subTagsStatus = new SubTagsStatus((String) e.a());
            sb = new StringBuilder();
            str = "network subTagsStatus ";
        } else {
            com.meizu.cloud.pushsdk.b.b.a c = e.c();
            if (c.a() != null) {
                DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
            }
            subTagsStatus.setCode(String.valueOf(c.b()));
            subTagsStatus.setMessage(c.c());
            sb = new StringBuilder();
            str = "subTagsStatus ";
        }
        sb.append(str);
        sb.append(subTagsStatus);
        DebugLogger.e("Strategy", sb.toString());
        return subTagsStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public SubTagsStatus f() {
        return null;
    }
}
