package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes4.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private int[] f11355a;

    /* renamed from: b  reason: collision with root package name */
    private int f11356b;
    private String c;

    public a(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.k = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public a(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.l = z;
    }

    public void a(int i) {
        this.f11356b = i;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected void a(BasicPushStatus basicPushStatus) {
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(int... iArr) {
        this.f11355a = iArr;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected boolean a() {
        if (this.f11356b != 0) {
            if (this.f11355a == null || this.f11355a.length <= 0 || this.f11356b != 1) {
                return this.f11356b == 2 && !TextUtils.isEmpty(this.c);
            }
            return true;
        }
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected BasicPushStatus b() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent c() {
        Intent intent = new Intent();
        intent.putExtra("strategy_package_name", this.e.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.f11356b);
        if (this.f11356b == 2) {
            intent.putExtra("strategy_params", this.c);
            return intent;
        } else if (this.f11356b == 1) {
            return null;
        } else {
            return intent;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected Intent[] d() {
        if (this.f11355a != null) {
            Intent[] intentArr = new Intent[this.f11355a.length];
            for (int i = 0; i < this.f11355a.length; i++) {
                com.meizu.cloud.a.a.i("Strategy", "send notifyId " + this.f11355a[i] + " to PushManagerService");
                Intent intent = new Intent();
                intent.putExtra("strategy_package_name", this.e.getPackageName());
                intent.putExtra("strategy_type", g());
                intent.putExtra("strategy_child_type", this.f11356b);
                intent.putExtra("strategy_params", "" + this.f11355a[i]);
                intentArr[i] = intent;
            }
            return intentArr;
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected BasicPushStatus e() {
        int[] iArr;
        switch (this.f11356b) {
            case 0:
                if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                    com.meizu.cloud.a.a.e("Strategy", "android 6.0 blow so cancel all by context");
                    com.meizu.cloud.pushsdk.notification.c.b.a(this.e);
                }
                com.meizu.cloud.pushsdk.notification.c.b.a(this.e, this.h);
                return null;
            case 1:
                if (this.f11355a != null) {
                    for (int i : this.f11355a) {
                        com.meizu.cloud.a.a.e("Strategy", "clear notifyId " + i);
                        com.meizu.cloud.pushsdk.notification.c.b.a(this.e, this.h, i);
                    }
                    return null;
                }
                return null;
            case 2:
                com.meizu.cloud.pushsdk.notification.c.b.a(this.e, this.h, this.c);
                return null;
            default:
                return null;
        }
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected BasicPushStatus f() {
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 64;
    }
}
