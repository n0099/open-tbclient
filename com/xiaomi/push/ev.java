package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ev implements et {
    private void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str) || context == null) {
                em.a(context, "provider", 1008, "B get a incorrect message");
            } else {
                String[] split = str.split("/");
                if (split.length <= 0 || TextUtils.isEmpty(split[split.length - 1])) {
                    em.a(context, "provider", 1008, "B get a incorrect message");
                } else {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        em.a(context, "provider", 1008, "B get a incorrect message");
                    } else {
                        String decode = Uri.decode(str2);
                        if (TextUtils.isEmpty(decode)) {
                            em.a(context, "provider", 1008, "B get a incorrect message");
                        } else {
                            String b = el.b(decode);
                            if (TextUtils.isEmpty(b)) {
                                em.a(context, "provider", 1008, "B get a incorrect message");
                            } else {
                                em.a(context, b, 1007, "play with provider successfully");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            em.a(context, "provider", 1008, "B meet a exception" + e.getMessage());
        }
    }

    private void b(Context context, ep epVar) {
        String b = epVar.b();
        String d = epVar.d();
        int a = epVar.a();
        if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                em.a(context, "provider", 1008, "argument error");
            } else {
                em.a(context, d, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.f.b(context, b)) {
            em.a(context, d, 1003, "B is not ready");
        } else {
            em.a(context, d, 1002, "B is ready");
            em.a(context, d, 1004, "A is ready");
            String a2 = el.a(d);
            try {
                if (TextUtils.isEmpty(a2)) {
                    em.a(context, d, 1008, "info is empty");
                } else if (a != 1 || eq.m267a(context)) {
                    String type = context.getContentResolver().getType(el.a(b, a2));
                    if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                        em.a(context, d, 1008, "A is fail to help B's provider");
                    } else {
                        em.a(context, d, 1005, "A is successful");
                        em.a(context, d, 1006, "The job is finished");
                    }
                } else {
                    em.a(context, d, 1008, "A not in foreground");
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                em.a(context, d, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.et
    public void a(Context context, ep epVar) {
        if (epVar != null) {
            b(context, epVar);
        } else {
            em.a(context, "provider", 1008, "A receive incorrect message");
        }
    }
}
