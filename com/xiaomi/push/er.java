package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class er implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14000a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ eq f385a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f386a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14001b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(eq eqVar, String str, Context context, String str2, String str3) {
        this.f385a = eqVar;
        this.f386a = str;
        this.f14000a = context;
        this.f14001b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f386a)) {
            em.a(this.f14000a, "null", 1008, "A receive a incorrect message with empty info");
            return;
        }
        try {
            em.a(this.f14000a, this.f386a, 1001, "get message");
            JSONObject jSONObject = new JSONObject(this.f386a);
            String optString = jSONObject.optString("action");
            String optString2 = jSONObject.optString("awakened_app_packagename");
            String optString3 = jSONObject.optString("awake_app_packagename");
            String optString4 = jSONObject.optString("awake_app");
            String optString5 = jSONObject.optString("awake_type");
            int optInt = jSONObject.optInt("awake_foreground", 0);
            if (!this.f14001b.equals(optString3) || !this.c.equals(optString4)) {
                em.a(this.f14000a, this.f386a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
            } else if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                em.a(this.f14000a, this.f386a, 1008, "A receive a incorrect message with empty type");
            } else {
                this.f385a.b(optString3);
                this.f385a.a(optString4);
                ep epVar = new ep();
                epVar.b(optString);
                epVar.a(optString2);
                epVar.a(optInt);
                epVar.d(this.f386a);
                if ("service".equals(optString5)) {
                    if (TextUtils.isEmpty(optString)) {
                        epVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                        this.f385a.a(es.SERVICE_COMPONENT, this.f14000a, epVar);
                    } else {
                        this.f385a.a(es.SERVICE_ACTION, this.f14000a, epVar);
                    }
                } else if (es.ACTIVITY.f388a.equals(optString5)) {
                    this.f385a.a(es.ACTIVITY, this.f14000a, epVar);
                } else if (es.PROVIDER.f388a.equals(optString5)) {
                    this.f385a.a(es.PROVIDER, this.f14000a, epVar);
                } else {
                    em.a(this.f14000a, this.f386a, 1008, "A receive a incorrect message with unknown type " + optString5);
                }
            }
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            em.a(this.f14000a, this.f386a, 1008, "A meet a exception when receive the message");
        }
    }
}
