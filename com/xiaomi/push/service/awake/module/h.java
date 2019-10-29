package com.xiaomi.push.service.awake.module;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements f {
    private void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str) || context == null) {
                com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "B get a incorrect message");
            } else {
                String[] split = str.split("/");
                if (split.length <= 0 || TextUtils.isEmpty(split[split.length - 1])) {
                    com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "B get a incorrect message");
                } else {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "B get a incorrect message");
                    } else {
                        String decode = Uri.decode(str2);
                        if (TextUtils.isEmpty(decode)) {
                            com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "B get a incorrect message");
                        } else {
                            String b = com.xiaomi.push.service.awake.a.b(decode);
                            if (TextUtils.isEmpty(b)) {
                                com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "B get a incorrect message");
                            } else {
                                com.xiaomi.push.service.awake.b.a(context, b, 1007, "play with provider successfully");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "B meet a exception" + e.getMessage());
        }
    }

    private void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "argument error");
            } else {
                com.xiaomi.push.service.awake.b.a(context, str2, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.awake.d.b(context, str)) {
            com.xiaomi.push.service.awake.b.a(context, str2, 1003, "B is not ready");
        } else {
            com.xiaomi.push.service.awake.b.a(context, str2, 1002, "B is ready");
            com.xiaomi.push.service.awake.b.a(context, str2, 1004, "A is ready");
            String a = com.xiaomi.push.service.awake.a.a(str2);
            try {
                if (TextUtils.isEmpty(a)) {
                    com.xiaomi.push.service.awake.b.a(context, str2, 1008, "info is empty");
                } else {
                    String type = context.getContentResolver().getType(com.xiaomi.push.service.awake.a.a(str, a));
                    if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                        com.xiaomi.push.service.awake.b.a(context, str2, 1008, "A is fail to help B's provider");
                    } else {
                        com.xiaomi.push.service.awake.b.a(context, str2, 1005, "A is successful");
                        com.xiaomi.push.service.awake.b.a(context, str2, 1006, "The job is finished");
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.service.awake.b.a(context, str2, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.service.awake.module.f
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.service.awake.module.f
    public void a(Context context, b bVar) {
        if (bVar != null) {
            a(context, bVar.b(), bVar.d());
        } else {
            com.xiaomi.push.service.awake.b.a(context, "provider", 1008, "A receive incorrect message");
        }
    }
}
