package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ep implements en {
    private void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str) || context == null) {
                eg.a(context, "provider", 1008, "B get a incorrect message");
            } else {
                String[] split = str.split("/");
                if (split.length <= 0 || TextUtils.isEmpty(split[split.length - 1])) {
                    eg.a(context, "provider", 1008, "B get a incorrect message");
                } else {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        eg.a(context, "provider", 1008, "B get a incorrect message");
                    } else {
                        String decode = Uri.decode(str2);
                        if (TextUtils.isEmpty(decode)) {
                            eg.a(context, "provider", 1008, "B get a incorrect message");
                        } else {
                            String b = ef.b(decode);
                            if (TextUtils.isEmpty(b)) {
                                eg.a(context, "provider", 1008, "B get a incorrect message");
                            } else {
                                eg.a(context, b, 1007, "play with provider successfully");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            eg.a(context, "provider", 1008, "B meet a exception" + e.getMessage());
        }
    }

    private void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str2)) {
                eg.a(context, "provider", 1008, "argument error");
            } else {
                eg.a(context, str2, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.f.b(context, str)) {
            eg.a(context, str2, 1003, "B is not ready");
        } else {
            eg.a(context, str2, 1002, "B is ready");
            eg.a(context, str2, 1004, "A is ready");
            String a = ef.a(str2);
            try {
                if (TextUtils.isEmpty(a)) {
                    eg.a(context, str2, 1008, "info is empty");
                } else {
                    String type = context.getContentResolver().getType(ef.a(str, a));
                    if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                        eg.a(context, str2, 1008, "A is fail to help B's provider");
                    } else {
                        eg.a(context, str2, 1005, "A is successful");
                        eg.a(context, str2, 1006, "The job is finished");
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                eg.a(context, str2, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.en
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.en
    public void a(Context context, ej ejVar) {
        if (ejVar != null) {
            a(context, ejVar.b(), ejVar.d());
        } else {
            eg.a(context, "provider", 1008, "A receive incorrect message");
        }
    }
}
