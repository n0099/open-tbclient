package com.mofamulu.tieba.sign;

import android.graphics.Bitmap;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends Thread {
    final /* synthetic */ SignServiceBinder a;
    private final /* synthetic */ al b;
    private final /* synthetic */ String c;
    private final /* synthetic */ AccountAddActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SignServiceBinder signServiceBinder, al alVar, String str, AccountAddActivity accountAddActivity) {
        this.a = signServiceBinder;
        this.b = alVar;
        this.c = str;
        this.d = accountAddActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x0071 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0103  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        ar arVar;
        String message;
        Message message2;
        ar a;
        ap apVar;
        ap apVar2;
        Bitmap bitmap = null;
        String d = this.b.d();
        String e = this.b.e();
        try {
            if (this.c != null && this.a.c.get(d) != null) {
                ar arVar2 = (ar) this.a.c.get(d);
                try {
                    arVar2.a(this.c);
                    a = arVar2;
                } catch (Throwable th2) {
                    th = th2;
                    arVar = arVar2;
                    message = th.getMessage();
                    message2 = new Message();
                    if (message == null && message.contains("验证码") && arVar != null && arVar.c() != null) {
                        this.a.c.put(d, arVar);
                        for (int i = 0; i < 3; i++) {
                            try {
                                bitmap = this.a.f(arVar.c());
                                break;
                            } catch (Throwable th3) {
                            }
                        }
                        if (bitmap != null) {
                            message2.what = 4;
                            message2.obj = bitmap;
                        } else {
                            message2.what = 3;
                            message2.obj = "登录需要验证码，但读取验证码时网络出错。请稍候重试。";
                        }
                    } else {
                        Log.e("tbhp_ns_binder", "failed to test account:" + this.b.a, th);
                        message2.what = 3;
                        if (th instanceof IOException) {
                            message = "您的网络不稳定，请稍候再试。";
                        }
                        message2.obj = message;
                    }
                    this.d.t.sendMessage(message2);
                    return;
                }
            } else {
                a = ar.a(this.a.a, this.b, d, e, null);
                try {
                    a.e();
                } catch (Throwable th4) {
                    arVar = a;
                    th = th4;
                    message = th.getMessage();
                    message2 = new Message();
                    if (message == null) {
                    }
                    Log.e("tbhp_ns_binder", "failed to test account:" + this.b.a, th);
                    message2.what = 3;
                    if (th instanceof IOException) {
                    }
                    message2.obj = message;
                    this.d.t.sendMessage(message2);
                    return;
                }
            }
            this.b.c(a.d());
            this.b.e(a.q());
            this.b.a(0);
            this.a.b.a(this.b);
            this.a.c.remove(d);
            Message message3 = new Message();
            message3.what = 2;
            this.d.t.sendMessage(message3);
            for (int i2 = 0; i2 < apVar.f.size(); i2++) {
                apVar2 = this.a.d;
                ((am) apVar2.f.get(i2)).a();
            }
        } catch (Throwable th5) {
            th = th5;
            arVar = null;
        }
    }
}
