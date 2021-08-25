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
/* loaded from: classes10.dex */
public class b extends c<RegisterStatus> {

    /* renamed from: a  reason: collision with root package name */
    public Handler f74802a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f74803b;

    /* renamed from: c  reason: collision with root package name */
    public int f74804c;

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.f74803b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        this.f74802a = new Handler(context.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.b.b.1
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
        this.f74804c = 0;
    }

    public void a(long j2) {
        this.f74803b.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.o();
                b.this.f74802a.sendEmptyMessage(0);
            }
        }, j2, TimeUnit.SECONDS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.f74809e, !TextUtils.isEmpty(this.f74812h) ? this.f74812h : this.f74809e.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        c.l.a.a.a.b("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.f74809e));
        return (TextUtils.isEmpty(this.f74810f) || TextUtils.isEmpty(this.f74811g)) ? false : true;
    }

    public boolean a(String str, int i2) {
        String o = o();
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(o) || (!str.startsWith(o) && (TextUtils.isEmpty(com.meizu.cloud.pushsdk.platform.a.a(str)) || !com.meizu.cloud.pushsdk.platform.a.a(str).startsWith(o))) || System.currentTimeMillis() / 1000 >= ((long) i2);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f74810f);
        intent.putExtra("app_key", this.f74811g);
        intent.putExtra("strategy_package_name", this.f74809e.getPackageName());
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
        if (!TextUtils.isEmpty(this.f74810f)) {
            str = TextUtils.isEmpty(this.f74811g) ? "appKey not empty" : "appKey not empty";
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
        String a2 = com.meizu.cloud.pushsdk.util.b.a(this.f74809e, this.f74812h);
        int b2 = com.meizu.cloud.pushsdk.util.b.b(this.f74809e, this.f74812h);
        if (a(a2, b2)) {
            com.meizu.cloud.pushsdk.util.b.g(this.f74809e, "", this.f74812h);
            this.f74813i = o();
            if (!TextUtils.isEmpty(this.f74813i) || this.f74804c >= 3) {
                this.f74804c = 0;
                com.meizu.cloud.pushsdk.b.a.c a3 = this.f74814j.a(this.f74810f, this.f74811g, this.f74813i);
                if (a3.b()) {
                    registerStatus = new RegisterStatus((String) a3.a());
                    c.l.a.a.a.b("Strategy", "registerStatus " + registerStatus);
                    if (!TextUtils.isEmpty(registerStatus.getPushId())) {
                        com.meizu.cloud.pushsdk.util.b.g(this.f74809e, registerStatus.getPushId(), this.f74812h);
                        com.meizu.cloud.pushsdk.util.b.a(this.f74809e, (int) ((System.currentTimeMillis() / 1000) + registerStatus.getExpireTime()), this.f74812h);
                    }
                } else {
                    com.meizu.cloud.pushsdk.b.b.a c2 = a3.c();
                    if (c2.a() != null) {
                        c.l.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                    }
                    registerStatus.setCode(String.valueOf(c2.b()));
                    registerStatus.setMessage(c2.c());
                    c.l.a.a.a.b("Strategy", "registerStatus " + registerStatus);
                }
            } else {
                c.l.a.a.a.d("Strategy", "after " + (this.f74804c * 10) + " seconds start register");
                a((long) (this.f74804c * 10));
                this.f74804c = this.f74804c + 1;
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
