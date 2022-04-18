package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.repackage.ym9;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes5.dex */
public class a extends c {
    public int[] a;
    public int b;
    public String c;

    public a(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.k = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public a(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.l = z;
    }

    public void a(int i) {
        this.b = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(BasicPushStatus basicPushStatus) {
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(int... iArr) {
        this.a = iArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        int i = this.b;
        if (i != 0) {
            int[] iArr = this.a;
            if (iArr == null || iArr.length <= 0 || i != 1) {
                return this.b == 2 && !TextUtils.isEmpty(this.c);
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
        intent.putExtra("strategy_package_name", this.e.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.b);
        int i = this.b;
        if (i == 2) {
            intent.putExtra("strategy_params", this.c);
            return intent;
        } else if (i == 1) {
            return null;
        } else {
            return intent;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent[] d() {
        int[] iArr = this.a;
        if (iArr != null) {
            Intent[] intentArr = new Intent[iArr.length];
            for (int i = 0; i < this.a.length; i++) {
                ym9.d("Strategy", "send notifyId " + this.a[i] + " to PushManagerService");
                Intent intent = new Intent();
                intent.putExtra("strategy_package_name", this.e.getPackageName());
                intent.putExtra("strategy_type", g());
                intent.putExtra("strategy_child_type", this.b);
                intent.putExtra("strategy_params", "" + this.a[i]);
                intentArr[i] = intent;
            }
            return intentArr;
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus e() {
        int i = this.b;
        if (i == 0) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                ym9.b("Strategy", "android 6.0 blow so cancel all by context");
                com.meizu.cloud.pushsdk.notification.c.b.a(this.e);
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.e, this.h);
            return null;
        } else if (i != 1) {
            if (i != 2) {
                return null;
            }
            com.meizu.cloud.pushsdk.notification.c.b.a(this.e, this.h, this.c);
            return null;
        } else {
            int[] iArr = this.a;
            if (iArr != null) {
                for (int i2 : iArr) {
                    ym9.b("Strategy", "clear notifyId " + i2);
                    com.meizu.cloud.pushsdk.notification.c.b.a(this.e, this.h, i2);
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
