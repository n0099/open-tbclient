package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public int[] f40546a;

    /* renamed from: b  reason: collision with root package name */
    public int f40547b;

    /* renamed from: c  reason: collision with root package name */
    public String f40548c;

    public a(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.k = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public a(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.l = z;
    }

    public void a(int i2) {
        this.f40547b = i2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(BasicPushStatus basicPushStatus) {
    }

    public void a(String str) {
        this.f40548c = str;
    }

    public void a(int... iArr) {
        this.f40546a = iArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        int i2 = this.f40547b;
        if (i2 != 0) {
            int[] iArr = this.f40546a;
            if (iArr == null || iArr.length <= 0 || i2 != 1) {
                return this.f40547b == 2 && !TextUtils.isEmpty(this.f40548c);
            }
            return true;
        }
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus b() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("strategy_package_name", this.f40556e.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f40547b);
        int i2 = this.f40547b;
        if (i2 == 2) {
            intent.putExtra("strategy_params", this.f40548c);
            return intent;
        } else if (i2 == 1) {
            return null;
        } else {
            return intent;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent[] d() {
        int[] iArr = this.f40546a;
        if (iArr != null) {
            Intent[] intentArr = new Intent[iArr.length];
            for (int i2 = 0; i2 < this.f40546a.length; i2++) {
                d.h.a.a.a.d("Strategy", "send notifyId " + this.f40546a[i2] + " to PushManagerService");
                Intent intent = new Intent();
                intent.putExtra("strategy_package_name", this.f40556e.getPackageName());
                intent.putExtra("strategy_type", g());
                intent.putExtra("strategy_child_type", this.f40547b);
                intent.putExtra("strategy_params", "" + this.f40546a[i2]);
                intentArr[i2] = intent;
            }
            return intentArr;
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus e() {
        int i2 = this.f40547b;
        if (i2 == 0) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                d.h.a.a.a.b("Strategy", "android 6.0 blow so cancel all by context");
                com.meizu.cloud.pushsdk.notification.c.b.a(this.f40556e);
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.f40556e, this.f40559h);
            return null;
        } else if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.f40556e, this.f40559h, this.f40548c);
            return null;
        } else {
            int[] iArr = this.f40546a;
            if (iArr != null) {
                for (int i3 : iArr) {
                    d.h.a.a.a.b("Strategy", "clear notifyId " + i3);
                    com.meizu.cloud.pushsdk.notification.c.b.a(this.f40556e, this.f40559h, i3);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 64;
    }
}
