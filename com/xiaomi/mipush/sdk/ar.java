package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ar extends Handler {
    final /* synthetic */ aq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(aq aqVar, Looper looper) {
        super(looper);
        this.a = aqVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        switch (message.what) {
            case 19:
                String str = (String) message.obj;
                int i = message.arg1;
                synchronized (ag.class) {
                    context = this.a.f49a;
                    if (ag.a(context).m72a(str)) {
                        context2 = this.a.f49a;
                        if (ag.a(context2).a(str) < 10) {
                            if (av.DISABLE_PUSH.ordinal() == i) {
                                context14 = this.a.f49a;
                                if ("syncing".equals(ag.a(context14).a(av.DISABLE_PUSH))) {
                                    this.a.a(str, av.DISABLE_PUSH, true, (HashMap<String, String>) null);
                                    context13 = this.a.f49a;
                                    ag.a(context13).b(str);
                                }
                            }
                            if (av.ENABLE_PUSH.ordinal() == i) {
                                context12 = this.a.f49a;
                                if ("syncing".equals(ag.a(context12).a(av.ENABLE_PUSH))) {
                                    this.a.a(str, av.ENABLE_PUSH, true, (HashMap<String, String>) null);
                                    context13 = this.a.f49a;
                                    ag.a(context13).b(str);
                                }
                            }
                            if (av.UPLOAD_HUAWEI_TOKEN.ordinal() == i) {
                                context10 = this.a.f49a;
                                if ("syncing".equals(ag.a(context10).a(av.UPLOAD_HUAWEI_TOKEN))) {
                                    aq aqVar = this.a;
                                    av avVar = av.UPLOAD_HUAWEI_TOKEN;
                                    context11 = this.a.f49a;
                                    aqVar.a(str, avVar, false, h.a(context11, d.ASSEMBLE_PUSH_HUAWEI));
                                    context13 = this.a.f49a;
                                    ag.a(context13).b(str);
                                }
                            }
                            if (av.UPLOAD_FCM_TOKEN.ordinal() == i) {
                                context8 = this.a.f49a;
                                if ("syncing".equals(ag.a(context8).a(av.UPLOAD_FCM_TOKEN))) {
                                    aq aqVar2 = this.a;
                                    av avVar2 = av.UPLOAD_FCM_TOKEN;
                                    context9 = this.a.f49a;
                                    aqVar2.a(str, avVar2, false, h.a(context9, d.ASSEMBLE_PUSH_FCM));
                                    context13 = this.a.f49a;
                                    ag.a(context13).b(str);
                                }
                            }
                            if (av.UPLOAD_COS_TOKEN.ordinal() == i) {
                                context6 = this.a.f49a;
                                if ("syncing".equals(ag.a(context6).a(av.UPLOAD_COS_TOKEN))) {
                                    aq aqVar3 = this.a;
                                    av avVar3 = av.UPLOAD_COS_TOKEN;
                                    context7 = this.a.f49a;
                                    aqVar3.a(str, avVar3, false, h.a(context7, d.ASSEMBLE_PUSH_COS));
                                    context13 = this.a.f49a;
                                    ag.a(context13).b(str);
                                }
                            }
                            if (av.UPLOAD_FTOS_TOKEN.ordinal() == i) {
                                context4 = this.a.f49a;
                                if ("syncing".equals(ag.a(context4).a(av.UPLOAD_FTOS_TOKEN))) {
                                    aq aqVar4 = this.a;
                                    av avVar4 = av.UPLOAD_FTOS_TOKEN;
                                    context5 = this.a.f49a;
                                    aqVar4.a(str, avVar4, false, h.a(context5, d.ASSEMBLE_PUSH_FTOS));
                                }
                            }
                            context13 = this.a.f49a;
                            ag.a(context13).b(str);
                        } else {
                            context3 = this.a.f49a;
                            ag.a(context3).c(str);
                        }
                    }
                }
                return;
            default:
                return;
        }
    }
}
