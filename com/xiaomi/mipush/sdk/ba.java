package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ba extends Handler {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(az azVar, Looper looper) {
        super(looper);
        this.a = azVar;
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
        switch (message.what) {
            case 19:
                String str = (String) message.obj;
                int i = message.arg1;
                synchronized (ap.class) {
                    context = this.a.c;
                    if (ap.a(context).e(str)) {
                        context2 = this.a.c;
                        if (ap.a(context2).c(str) < 10) {
                            if (be.DISABLE_PUSH.ordinal() == i) {
                                context12 = this.a.c;
                                if ("syncing".equals(ap.a(context12).a(be.DISABLE_PUSH))) {
                                    this.a.a(str, be.DISABLE_PUSH, true, (HashMap<String, String>) null);
                                    context11 = this.a.c;
                                    ap.a(context11).b(str);
                                }
                            }
                            if (be.ENABLE_PUSH.ordinal() == i) {
                                context10 = this.a.c;
                                if ("syncing".equals(ap.a(context10).a(be.ENABLE_PUSH))) {
                                    this.a.a(str, be.ENABLE_PUSH, true, (HashMap<String, String>) null);
                                    context11 = this.a.c;
                                    ap.a(context11).b(str);
                                }
                            }
                            if (be.UPLOAD_HUAWEI_TOKEN.ordinal() == i) {
                                context8 = this.a.c;
                                if ("syncing".equals(ap.a(context8).a(be.UPLOAD_HUAWEI_TOKEN))) {
                                    az azVar = this.a;
                                    be beVar = be.UPLOAD_HUAWEI_TOKEN;
                                    context9 = this.a.c;
                                    azVar.a(str, beVar, false, i.c(context9, f.ASSEMBLE_PUSH_HUAWEI));
                                    context11 = this.a.c;
                                    ap.a(context11).b(str);
                                }
                            }
                            if (be.UPLOAD_FCM_TOKEN.ordinal() == i) {
                                context6 = this.a.c;
                                if ("syncing".equals(ap.a(context6).a(be.UPLOAD_FCM_TOKEN))) {
                                    az azVar2 = this.a;
                                    be beVar2 = be.UPLOAD_FCM_TOKEN;
                                    context7 = this.a.c;
                                    azVar2.a(str, beVar2, false, i.c(context7, f.ASSEMBLE_PUSH_FCM));
                                    context11 = this.a.c;
                                    ap.a(context11).b(str);
                                }
                            }
                            if (be.UPLOAD_COS_TOKEN.ordinal() == i) {
                                context4 = this.a.c;
                                if ("syncing".equals(ap.a(context4).a(be.UPLOAD_COS_TOKEN))) {
                                    az azVar3 = this.a;
                                    be beVar3 = be.UPLOAD_COS_TOKEN;
                                    context5 = this.a.c;
                                    azVar3.a(str, beVar3, false, i.c(context5, f.ASSEMBLE_PUSH_COS));
                                }
                            }
                            context11 = this.a.c;
                            ap.a(context11).b(str);
                        } else {
                            context3 = this.a.c;
                            ap.a(context3).d(str);
                        }
                    }
                }
                return;
            default:
                return;
        }
    }
}
