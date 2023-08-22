package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ed implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ec f311a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f312a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public ed(ec ecVar, String str, Context context, String str2, String str3) {
        this.f311a = ecVar;
        this.f312a = str;
        this.a = context;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        String str;
        String str2;
        Context context2;
        String str3;
        String str4;
        ec ecVar;
        ee eeVar;
        Context context3;
        if (TextUtils.isEmpty(this.f312a)) {
            context = this.a;
            str = StringUtil.NULL_STRING;
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                dy.a(this.a, this.f312a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f312a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.b.equals(optString3) && this.c.equals(optString4)) {
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                        this.f311a.b(optString3);
                        this.f311a.a(optString4);
                        eb ebVar = new eb();
                        ebVar.b(optString);
                        ebVar.a(optString2);
                        ebVar.a(optInt);
                        ebVar.d(this.f312a);
                        if ("service".equals(optString5)) {
                            if (TextUtils.isEmpty(optString)) {
                                ebVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                ecVar = this.f311a;
                                eeVar = ee.SERVICE_COMPONENT;
                                context3 = this.a;
                            } else {
                                ecVar = this.f311a;
                                eeVar = ee.SERVICE_ACTION;
                                context3 = this.a;
                            }
                        } else if (ee.ACTIVITY.f314a.equals(optString5)) {
                            ecVar = this.f311a;
                            eeVar = ee.ACTIVITY;
                            context3 = this.a;
                        } else if (ee.PROVIDER.f314a.equals(optString5)) {
                            ecVar = this.f311a;
                            eeVar = ee.PROVIDER;
                            context3 = this.a;
                        } else {
                            context2 = this.a;
                            str3 = this.f312a;
                            str4 = "A receive a incorrect message with unknown type " + optString5;
                        }
                        ecVar.a(eeVar, context3, ebVar);
                        return;
                    }
                    context2 = this.a;
                    str3 = this.f312a;
                    str4 = "A receive a incorrect message with empty type";
                    dy.a(context2, str3, 1008, str4);
                    return;
                }
                dy.a(this.a, this.f312a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                return;
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                context = this.a;
                str = this.f312a;
                str2 = "A meet a exception when receive the message";
            }
        }
        dy.a(context, str, 1008, str2);
    }
}
