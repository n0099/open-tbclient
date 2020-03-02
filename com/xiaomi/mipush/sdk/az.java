package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class az extends Handler {
    final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(ay ayVar, Looper looper) {
        super(looper);
        this.a = ayVar;
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
                synchronized (ao.class) {
                    context = this.a.f46a;
                    if (ao.a(context).m63a(str)) {
                        context2 = this.a.f46a;
                        if (ao.a(context2).a(str) < 10) {
                            if (bd.DISABLE_PUSH.ordinal() == i) {
                                context14 = this.a.f46a;
                                if ("syncing".equals(ao.a(context14).a(bd.DISABLE_PUSH))) {
                                    this.a.a(str, bd.DISABLE_PUSH, true, (HashMap<String, String>) null);
                                    context13 = this.a.f46a;
                                    ao.a(context13).b(str);
                                }
                            }
                            if (bd.ENABLE_PUSH.ordinal() == i) {
                                context12 = this.a.f46a;
                                if ("syncing".equals(ao.a(context12).a(bd.ENABLE_PUSH))) {
                                    this.a.a(str, bd.ENABLE_PUSH, true, (HashMap<String, String>) null);
                                    context13 = this.a.f46a;
                                    ao.a(context13).b(str);
                                }
                            }
                            if (bd.UPLOAD_HUAWEI_TOKEN.ordinal() == i) {
                                context10 = this.a.f46a;
                                if ("syncing".equals(ao.a(context10).a(bd.UPLOAD_HUAWEI_TOKEN))) {
                                    ay ayVar = this.a;
                                    bd bdVar = bd.UPLOAD_HUAWEI_TOKEN;
                                    context11 = this.a.f46a;
                                    ayVar.a(str, bdVar, false, j.a(context11, f.ASSEMBLE_PUSH_HUAWEI));
                                    context13 = this.a.f46a;
                                    ao.a(context13).b(str);
                                }
                            }
                            if (bd.UPLOAD_FCM_TOKEN.ordinal() == i) {
                                context8 = this.a.f46a;
                                if ("syncing".equals(ao.a(context8).a(bd.UPLOAD_FCM_TOKEN))) {
                                    ay ayVar2 = this.a;
                                    bd bdVar2 = bd.UPLOAD_FCM_TOKEN;
                                    context9 = this.a.f46a;
                                    ayVar2.a(str, bdVar2, false, j.a(context9, f.ASSEMBLE_PUSH_FCM));
                                    context13 = this.a.f46a;
                                    ao.a(context13).b(str);
                                }
                            }
                            if (bd.UPLOAD_COS_TOKEN.ordinal() == i) {
                                context6 = this.a.f46a;
                                if ("syncing".equals(ao.a(context6).a(bd.UPLOAD_COS_TOKEN))) {
                                    ay ayVar3 = this.a;
                                    bd bdVar3 = bd.UPLOAD_COS_TOKEN;
                                    context7 = this.a.f46a;
                                    ayVar3.a(str, bdVar3, false, j.a(context7, f.ASSEMBLE_PUSH_COS));
                                    context13 = this.a.f46a;
                                    ao.a(context13).b(str);
                                }
                            }
                            if (bd.UPLOAD_FTOS_TOKEN.ordinal() == i) {
                                context4 = this.a.f46a;
                                if ("syncing".equals(ao.a(context4).a(bd.UPLOAD_FTOS_TOKEN))) {
                                    ay ayVar4 = this.a;
                                    bd bdVar4 = bd.UPLOAD_FTOS_TOKEN;
                                    context5 = this.a.f46a;
                                    ayVar4.a(str, bdVar4, false, j.a(context5, f.ASSEMBLE_PUSH_FTOS));
                                }
                            }
                            context13 = this.a.f46a;
                            ao.a(context13).b(str);
                        } else {
                            context3 = this.a.f46a;
                            ao.a(context3).c(str);
                        }
                    }
                }
                return;
            default:
                return;
        }
    }
}
