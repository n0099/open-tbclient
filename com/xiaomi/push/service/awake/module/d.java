package com.xiaomi.push.service.awake.module;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, Context context, String str2, String str3) {
        this.e = cVar;
        this.a = str;
        this.b = context;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.a)) {
            com.xiaomi.push.service.awake.b.a(this.b, "null", 1008, "A receive a incorrect message with empty info");
            return;
        }
        try {
            com.xiaomi.push.service.awake.b.a(this.b, this.a, 1001, "get message");
            JSONObject jSONObject = new JSONObject(this.a);
            String optString = jSONObject.optString("action");
            String optString2 = jSONObject.optString("awakened_app_packagename");
            String optString3 = jSONObject.optString("awake_app_packagename");
            String optString4 = jSONObject.optString("awake_app");
            String optString5 = jSONObject.optString("awake_type");
            if (!this.c.equals(optString3) || !this.d.equals(optString4)) {
                com.xiaomi.push.service.awake.b.a(this.b, this.a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
            } else if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                com.xiaomi.push.service.awake.b.a(this.b, this.a, 1008, "A receive a incorrect message with empty type");
            } else {
                this.e.b(optString3);
                this.e.a(optString4);
                b bVar = new b();
                bVar.b(optString);
                bVar.a(optString2);
                bVar.d(this.a);
                if ("service".equals(optString5)) {
                    if (TextUtils.isEmpty(optString)) {
                        bVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                        this.e.a(e.SERVICE_COMPONENT, this.b, bVar);
                    } else {
                        this.e.a(e.SERVICE_ACTION, this.b, bVar);
                    }
                } else if (e.ACTIVITY.e.equals(optString5)) {
                    this.e.a(e.ACTIVITY, this.b, bVar);
                } else if (e.PROVIDER.e.equals(optString5)) {
                    this.e.a(e.PROVIDER, this.b, bVar);
                } else {
                    com.xiaomi.push.service.awake.b.a(this.b, this.a, 1008, "A receive a incorrect message with unknown type " + optString5);
                }
            }
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.push.service.awake.b.a(this.b, this.a, 1008, "A meet a exception when receive the message");
        }
    }
}
