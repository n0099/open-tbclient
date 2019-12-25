package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class el implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ek f324a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f325a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ek ekVar, String str, Context context, String str2, String str3) {
        this.f324a = ekVar;
        this.f325a = str;
        this.a = context;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f325a)) {
            eg.a(this.a, "null", 1008, "A receive a incorrect message with empty info");
            return;
        }
        try {
            eg.a(this.a, this.f325a, 1001, "get message");
            JSONObject jSONObject = new JSONObject(this.f325a);
            String optString = jSONObject.optString("action");
            String optString2 = jSONObject.optString("awakened_app_packagename");
            String optString3 = jSONObject.optString("awake_app_packagename");
            String optString4 = jSONObject.optString("awake_app");
            String optString5 = jSONObject.optString("awake_type");
            if (!this.b.equals(optString3) || !this.c.equals(optString4)) {
                eg.a(this.a, this.f325a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
            } else if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                eg.a(this.a, this.f325a, 1008, "A receive a incorrect message with empty type");
            } else {
                this.f324a.b(optString3);
                this.f324a.a(optString4);
                ej ejVar = new ej();
                ejVar.b(optString);
                ejVar.a(optString2);
                ejVar.d(this.f325a);
                if ("service".equals(optString5)) {
                    if (TextUtils.isEmpty(optString)) {
                        ejVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                        this.f324a.a(em.SERVICE_COMPONENT, this.a, ejVar);
                    } else {
                        this.f324a.a(em.SERVICE_ACTION, this.a, ejVar);
                    }
                } else if (em.ACTIVITY.f327a.equals(optString5)) {
                    this.f324a.a(em.ACTIVITY, this.a, ejVar);
                } else if (em.PROVIDER.f327a.equals(optString5)) {
                    this.f324a.a(em.PROVIDER, this.a, ejVar);
                } else {
                    eg.a(this.a, this.f325a, 1008, "A receive a incorrect message with unknown type " + optString5);
                }
            }
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            eg.a(this.a, this.f325a, 1008, "A meet a exception when receive the message");
        }
    }
}
