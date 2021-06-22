package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ao extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f41023a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(an anVar, Looper looper) {
        super(looper);
        this.f41023a = anVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        an anVar;
        at atVar;
        Context context5;
        HashMap<String, String> a2;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        an anVar2;
        at atVar2;
        Context context13;
        Context context14;
        if (message.what != 19) {
            return;
        }
        String str = (String) message.obj;
        int i2 = message.arg1;
        synchronized (ae.class) {
            context = this.f41023a.f64a;
            if (ae.a(context).m77a(str)) {
                context2 = this.f41023a.f64a;
                if (ae.a(context2).a(str) < 10) {
                    if (at.DISABLE_PUSH.ordinal() == i2) {
                        context14 = this.f41023a.f64a;
                        if ("syncing".equals(ae.a(context14).a(at.DISABLE_PUSH))) {
                            anVar2 = this.f41023a;
                            atVar2 = at.DISABLE_PUSH;
                            anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                            context13 = this.f41023a.f64a;
                            ae.a(context13).b(str);
                        }
                    }
                    if (at.ENABLE_PUSH.ordinal() == i2) {
                        context12 = this.f41023a.f64a;
                        if ("syncing".equals(ae.a(context12).a(at.ENABLE_PUSH))) {
                            anVar2 = this.f41023a;
                            atVar2 = at.ENABLE_PUSH;
                            anVar2.a(str, atVar2, true, (HashMap<String, String>) null);
                            context13 = this.f41023a.f64a;
                            ae.a(context13).b(str);
                        }
                    }
                    if (at.UPLOAD_HUAWEI_TOKEN.ordinal() == i2) {
                        context10 = this.f41023a.f64a;
                        if ("syncing".equals(ae.a(context10).a(at.UPLOAD_HUAWEI_TOKEN))) {
                            anVar = this.f41023a;
                            atVar = at.UPLOAD_HUAWEI_TOKEN;
                            context11 = this.f41023a.f64a;
                            a2 = i.a(context11, e.ASSEMBLE_PUSH_HUAWEI);
                            anVar.a(str, atVar, false, a2);
                            context13 = this.f41023a.f64a;
                            ae.a(context13).b(str);
                        }
                    }
                    if (at.UPLOAD_FCM_TOKEN.ordinal() == i2) {
                        context8 = this.f41023a.f64a;
                        if ("syncing".equals(ae.a(context8).a(at.UPLOAD_FCM_TOKEN))) {
                            anVar = this.f41023a;
                            atVar = at.UPLOAD_FCM_TOKEN;
                            context9 = this.f41023a.f64a;
                            a2 = i.a(context9, e.ASSEMBLE_PUSH_FCM);
                            anVar.a(str, atVar, false, a2);
                            context13 = this.f41023a.f64a;
                            ae.a(context13).b(str);
                        }
                    }
                    if (at.UPLOAD_COS_TOKEN.ordinal() == i2) {
                        context6 = this.f41023a.f64a;
                        if ("syncing".equals(ae.a(context6).a(at.UPLOAD_COS_TOKEN))) {
                            anVar = this.f41023a;
                            atVar = at.UPLOAD_COS_TOKEN;
                            context7 = this.f41023a.f64a;
                            a2 = i.a(context7, e.ASSEMBLE_PUSH_COS);
                            anVar.a(str, atVar, false, a2);
                            context13 = this.f41023a.f64a;
                            ae.a(context13).b(str);
                        }
                    }
                    if (at.UPLOAD_FTOS_TOKEN.ordinal() == i2) {
                        context4 = this.f41023a.f64a;
                        if ("syncing".equals(ae.a(context4).a(at.UPLOAD_FTOS_TOKEN))) {
                            anVar = this.f41023a;
                            atVar = at.UPLOAD_FTOS_TOKEN;
                            context5 = this.f41023a.f64a;
                            a2 = i.a(context5, e.ASSEMBLE_PUSH_FTOS);
                            anVar.a(str, atVar, false, a2);
                        }
                    }
                    context13 = this.f41023a.f64a;
                    ae.a(context13).b(str);
                } else {
                    context3 = this.f41023a.f64a;
                    ae.a(context3).c(str);
                }
            }
        }
    }
}
