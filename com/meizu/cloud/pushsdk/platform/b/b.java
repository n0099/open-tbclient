package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b extends c<RegisterStatus> {

    /* renamed from: a  reason: collision with root package name */
    public Handler f37889a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f37890b;

    /* renamed from: c  reason: collision with root package name */
    public int f37891c;

    public b(Context context, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.f37890b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        this.f37889a = new Handler(context.getMainLooper()) { // from class: com.meizu.cloud.pushsdk.platform.b.b.1
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
        this.f37891c = 0;
    }

    public void a(long j) {
        this.f37890b.schedule(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.o();
                b.this.f37889a.sendEmptyMessage(0);
            }
        }, j, TimeUnit.SECONDS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.f37896e, !TextUtils.isEmpty(this.f37899h) ? this.f37899h : this.f37896e.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        d.j.a.a.a.b("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.f37896e));
        return (TextUtils.isEmpty(this.f37897f) || TextUtils.isEmpty(this.f37898g)) ? false : true;
    }

    public boolean a(String str, int i) {
        String o = o();
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(o) || (!str.startsWith(o) && (TextUtils.isEmpty(com.meizu.cloud.pushsdk.platform.a.a(str)) || !com.meizu.cloud.pushsdk.platform.a.a(str).startsWith(o))) || System.currentTimeMillis() / 1000 >= ((long) i);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra(Constants.APP_ID, this.f37897f);
        intent.putExtra(com.alipay.sdk.cons.b.f1858h, this.f37898g);
        intent.putExtra("strategy_package_name", this.f37896e.getPackageName());
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
        if (!TextUtils.isEmpty(this.f37897f)) {
            str = TextUtils.isEmpty(this.f37898g) ? "appKey not empty" : "appKey not empty";
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
        String a2 = com.meizu.cloud.pushsdk.util.b.a(this.f37896e, this.f37899h);
        int b2 = com.meizu.cloud.pushsdk.util.b.b(this.f37896e, this.f37899h);
        if (a(a2, b2)) {
            com.meizu.cloud.pushsdk.util.b.g(this.f37896e, "", this.f37899h);
            this.i = o();
            if (!TextUtils.isEmpty(this.i) || this.f37891c >= 3) {
                this.f37891c = 0;
                com.meizu.cloud.pushsdk.b.a.c a3 = this.j.a(this.f37897f, this.f37898g, this.i);
                if (a3.b()) {
                    registerStatus = new RegisterStatus((String) a3.a());
                    d.j.a.a.a.b("Strategy", "registerStatus " + registerStatus);
                    if (!TextUtils.isEmpty(registerStatus.getPushId())) {
                        com.meizu.cloud.pushsdk.util.b.g(this.f37896e, registerStatus.getPushId(), this.f37899h);
                        com.meizu.cloud.pushsdk.util.b.a(this.f37896e, (int) ((System.currentTimeMillis() / 1000) + registerStatus.getExpireTime()), this.f37899h);
                    }
                } else {
                    com.meizu.cloud.pushsdk.b.b.a c2 = a3.c();
                    if (c2.a() != null) {
                        d.j.a.a.a.b("Strategy", "status code=" + c2.b() + " data=" + c2.a());
                    }
                    registerStatus.setCode(String.valueOf(c2.b()));
                    registerStatus.setMessage(c2.c());
                    d.j.a.a.a.b("Strategy", "registerStatus " + registerStatus);
                }
            } else {
                d.j.a.a.a.d("Strategy", "after " + (this.f37891c * 10) + " seconds start register");
                a((long) (this.f37891c * 10));
                this.f37891c = this.f37891c + 1;
                registerStatus.setCode("20000");
                registerStatus.setMessage("deviceId is empty");
            }
        } else {
            registerStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            registerStatus.setMessage("already register PushId,dont register frequently");
            registerStatus.setPushId(a2);
            registerStatus.setExpireTime((int) (b2 - (System.currentTimeMillis() / 1000)));
        }
        return registerStatus;
    }
}
