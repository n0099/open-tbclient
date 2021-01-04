package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b extends c<RegisterStatus> {

    /* renamed from: a  reason: collision with root package name */
    protected Handler f11654a;

    /* renamed from: b  reason: collision with root package name */
    protected ScheduledExecutorService f11655b;
    protected int c;

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.f11655b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        this.f11654a = new Handler(context.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.b.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        b.this.m();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public b(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.c = 0;
    }

    protected void a(long j) {
        this.f11655b.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.o();
                b.this.f11654a.sendEmptyMessage(0);
            }
        }, j, TimeUnit.SECONDS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.e, !TextUtils.isEmpty(this.h) ? this.h : this.e.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        com.meizu.cloud.a.a.e("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.e));
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) ? false : true;
    }

    protected boolean a(String str, int i) {
        String o = o();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(o)) {
            return true;
        }
        return (!str.startsWith(o) && (TextUtils.isEmpty(com.meizu.cloud.pushsdk.platform.a.a(str)) || !com.meizu.cloud.pushsdk.platform.a.a(str).startsWith(o))) || System.currentTimeMillis() / 1000 >= ((long) i);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f);
        intent.putExtra("app_key", this.g);
        intent.putExtra("strategy_package_name", this.e.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    protected int g() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public RegisterStatus b() {
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f)) {
            registerStatus.setMessage("appId not empty");
        } else if (TextUtils.isEmpty(this.g)) {
            registerStatus.setMessage("appKey not empty");
        }
        return registerStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: i */
    public RegisterStatus f() {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: j */
    public RegisterStatus e() {
        RegisterStatus registerStatus = new RegisterStatus();
        String a2 = com.meizu.cloud.pushsdk.util.b.a(this.e, this.h);
        int b2 = com.meizu.cloud.pushsdk.util.b.b(this.e, this.h);
        if (!a(a2, b2)) {
            registerStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            registerStatus.setMessage("already register PushId,dont register frequently");
            registerStatus.setPushId(a2);
            registerStatus.setExpireTime((int) (b2 - (System.currentTimeMillis() / 1000)));
            return registerStatus;
        }
        com.meizu.cloud.pushsdk.util.b.g(this.e, "", this.h);
        this.i = o();
        if (TextUtils.isEmpty(this.i) && this.c < 3) {
            com.meizu.cloud.a.a.i("Strategy", "after " + (this.c * 10) + " seconds start register");
            a(this.c * 10);
            this.c++;
            registerStatus.setCode("20000");
            registerStatus.setMessage("deviceId is empty");
            return registerStatus;
        }
        this.c = 0;
        com.meizu.cloud.pushsdk.b.a.c a3 = this.j.a(this.f, this.g, this.i);
        if (a3.b()) {
            RegisterStatus registerStatus2 = new RegisterStatus((String) a3.a());
            com.meizu.cloud.a.a.e("Strategy", "registerStatus " + registerStatus2);
            if (TextUtils.isEmpty(registerStatus2.getPushId())) {
                return registerStatus2;
            }
            com.meizu.cloud.pushsdk.util.b.g(this.e, registerStatus2.getPushId(), this.h);
            com.meizu.cloud.pushsdk.util.b.a(this.e, (int) ((System.currentTimeMillis() / 1000) + registerStatus2.getExpireTime()), this.h);
            return registerStatus2;
        }
        com.meizu.cloud.pushsdk.b.b.a c = a3.c();
        if (c.a() != null) {
            com.meizu.cloud.a.a.e("Strategy", "status code=" + c.b() + " data=" + c.a());
        }
        registerStatus.setCode(String.valueOf(c.b()));
        registerStatus.setMessage(c.c());
        com.meizu.cloud.a.a.e("Strategy", "registerStatus " + registerStatus);
        return registerStatus;
    }
}
