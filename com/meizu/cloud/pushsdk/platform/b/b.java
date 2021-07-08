package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b extends c<RegisterStatus> {

    /* renamed from: a  reason: collision with root package name */
    public Handler f37563a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f37564b;

    /* renamed from: c  reason: collision with root package name */
    public int f37565c;

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.f37564b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        this.f37563a = new Handler(context.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.b.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 0) {
                    return;
                }
                b.this.m();
            }
        };
    }

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.l = z;
    }

    public b(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f37565c = 0;
    }

    public void a(long j) {
        this.f37564b.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.o();
                b.this.f37563a.sendEmptyMessage(0);
            }
        }, j, TimeUnit.SECONDS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.f37570e, !TextUtils.isEmpty(this.f37573h) ? this.f37573h : this.f37570e.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        d.h.a.a.a.b("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.f37570e));
        return (TextUtils.isEmpty(this.f37571f) || TextUtils.isEmpty(this.f37572g)) ? false : true;
    }

    public boolean a(String str, int i2) {
        String o = o();
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(o) || (!str.startsWith(o) && (TextUtils.isEmpty(com.meizu.cloud.pushsdk.platform.a.a(str)) || !com.meizu.cloud.pushsdk.platform.a.a(str).startsWith(o))) || System.currentTimeMillis() / 1000 >= ((long) i2);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f37571f);
        intent.putExtra("app_key", this.f37572g);
        intent.putExtra("strategy_package_name", this.f37570e.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    /* renamed from: h */
    public RegisterStatus b() {
        String str;
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setCode(LightappConstants.ERRCODE_NOT_ALLOWED_BACKGROUND);
        if (!TextUtils.isEmpty(this.f37571f)) {
            str = TextUtils.isEmpty(this.f37572g) ? "appKey not empty" : "appKey not empty";
            return registerStatus;
        }
        str = "appId not empty";
        registerStatus.setMessage(str);
        return registerStatus;
    }

    /* JADX DEBUG: Method merged with bridge method */
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
        String a2 = com.meizu.cloud.pushsdk.util.b.a(this.f37570e, this.f37573h);
        int b2 = com.meizu.cloud.pushsdk.util.b.b(this.f37570e, this.f37573h);
        if (a(a2, b2)) {
            com.meizu.cloud.pushsdk.util.b.g(this.f37570e, "", this.f37573h);
            this.f37574i = o();
            if (!TextUtils.isEmpty(this.f37574i) || this.f37565c >= 3) {
                this.f37565c = 0;
                com.meizu.cloud.pushsdk.b.a.c a3 = this.j.a(this.f37571f, this.f37572g, this.f37574i);
                if (a3.b()) {
                    registerStatus = new RegisterStatus((String) a3.a());
                    d.h.a.a.a.b("Strategy", "registerStatus " + registerStatus);
                    if (!TextUtils.isEmpty(registerStatus.getPushId())) {
                        com.meizu.cloud.pushsdk.util.b.g(this.f37570e, registerStatus.getPushId(), this.f37573h);
                        com.meizu.cloud.pushsdk.util.b.a(this.f37570e, (int) ((System.currentTimeMillis() / 1000) + registerStatus.getExpireTime()), this.f37573h);
                    }
                } else {
                    com.meizu.cloud.pushsdk.b.b.a c2 = a3.c();
                    if (c2.a() != null) {
                        d.h.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                    }
                    registerStatus.setCode(String.valueOf(c2.b()));
                    registerStatus.setMessage(c2.c());
                    d.h.a.a.a.b("Strategy", "registerStatus " + registerStatus);
                }
            } else {
                d.h.a.a.a.d("Strategy", "after " + (this.f37565c * 10) + " seconds start register");
                a((long) (this.f37565c * 10));
                this.f37565c = this.f37565c + 1;
                registerStatus.setCode("20000");
                registerStatus.setMessage("deviceId is empty");
            }
        } else {
            registerStatus.setCode("200");
            registerStatus.setMessage("already register PushId,dont register frequently");
            registerStatus.setPushId(a2);
            registerStatus.setExpireTime((int) (b2 - (System.currentTimeMillis() / 1000)));
        }
        return registerStatus;
    }
}
