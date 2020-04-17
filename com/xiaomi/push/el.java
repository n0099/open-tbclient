package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class el implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ek f320a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f321a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ek ekVar, String str, Context context, String str2, String str3) {
        this.f320a = ekVar;
        this.f321a = str;
        this.a = context;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f321a)) {
            eg.a(this.a, "null", 1008, "A receive a incorrect message with empty info");
            return;
        }
        try {
            eg.a(this.a, this.f321a, 1001, "get message");
            JSONObject jSONObject = new JSONObject(this.f321a);
            String optString = jSONObject.optString("action");
            String optString2 = jSONObject.optString("awakened_app_packagename");
            String optString3 = jSONObject.optString("awake_app_packagename");
            String optString4 = jSONObject.optString("awake_app");
            String optString5 = jSONObject.optString("awake_type");
            if (!this.b.equals(optString3) || !this.c.equals(optString4)) {
                eg.a(this.a, this.f321a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
            } else if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                eg.a(this.a, this.f321a, 1008, "A receive a incorrect message with empty type");
            } else {
                this.f320a.b(optString3);
                this.f320a.a(optString4);
                ej ejVar = new ej();
                ejVar.b(optString);
                ejVar.a(optString2);
                ejVar.d(this.f321a);
                if ("service".equals(optString5)) {
                    if (TextUtils.isEmpty(optString)) {
                        ejVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                        this.f320a.a(em.SERVICE_COMPONENT, this.a, ejVar);
                    } else {
                        this.f320a.a(em.SERVICE_ACTION, this.a, ejVar);
                    }
                } else if (em.ACTIVITY.f323a.equals(optString5)) {
                    this.f320a.a(em.ACTIVITY, this.a, ejVar);
                } else if (em.PROVIDER.f323a.equals(optString5)) {
                    this.f320a.a(em.PROVIDER, this.a, ejVar);
                } else {
                    eg.a(this.a, this.f321a, 1008, "A receive a incorrect message with unknown type " + optString5);
                }
            }
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            eg.a(this.a, this.f321a, 1008, "A meet a exception when receive the message");
        }
    }
}
