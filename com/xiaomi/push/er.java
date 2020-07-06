package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class er implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ eq f312a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f313a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(eq eqVar, String str, Context context, String str2, String str3) {
        this.f312a = eqVar;
        this.f313a = str;
        this.a = context;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f313a)) {
            em.a(this.a, "null", 1008, "A receive a incorrect message with empty info");
            return;
        }
        try {
            em.a(this.a, this.f313a, 1001, "get message");
            JSONObject jSONObject = new JSONObject(this.f313a);
            String optString = jSONObject.optString("action");
            String optString2 = jSONObject.optString("awakened_app_packagename");
            String optString3 = jSONObject.optString("awake_app_packagename");
            String optString4 = jSONObject.optString("awake_app");
            String optString5 = jSONObject.optString("awake_type");
            int optInt = jSONObject.optInt("awake_foreground", 0);
            if (!this.b.equals(optString3) || !this.c.equals(optString4)) {
                em.a(this.a, this.f313a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
            } else if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                em.a(this.a, this.f313a, 1008, "A receive a incorrect message with empty type");
            } else {
                this.f312a.b(optString3);
                this.f312a.a(optString4);
                ep epVar = new ep();
                epVar.b(optString);
                epVar.a(optString2);
                epVar.a(optInt);
                epVar.d(this.f313a);
                if ("service".equals(optString5)) {
                    if (TextUtils.isEmpty(optString)) {
                        epVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                        this.f312a.a(es.SERVICE_COMPONENT, this.a, epVar);
                    } else {
                        this.f312a.a(es.SERVICE_ACTION, this.a, epVar);
                    }
                } else if (es.ACTIVITY.f315a.equals(optString5)) {
                    this.f312a.a(es.ACTIVITY, this.a, epVar);
                } else if (es.PROVIDER.f315a.equals(optString5)) {
                    this.f312a.a(es.PROVIDER, this.a, epVar);
                } else {
                    em.a(this.a, this.f313a, 1008, "A receive a incorrect message with unknown type " + optString5);
                }
            }
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            em.a(this.a, this.f313a, 1008, "A meet a exception when receive the message");
        }
    }
}
