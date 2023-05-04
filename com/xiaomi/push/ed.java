package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ed implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ec f310a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f311a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public ed(ec ecVar, String str, Context context, String str2, String str3) {
        this.f310a = ecVar;
        this.f311a = str;
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
        if (TextUtils.isEmpty(this.f311a)) {
            context = this.a;
            str = StringUtil.NULL_STRING;
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                dy.a(this.a, this.f311a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f311a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.b.equals(optString3) && this.c.equals(optString4)) {
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                        this.f310a.b(optString3);
                        this.f310a.a(optString4);
                        eb ebVar = new eb();
                        ebVar.b(optString);
                        ebVar.a(optString2);
                        ebVar.a(optInt);
                        ebVar.d(this.f311a);
                        if ("service".equals(optString5)) {
                            if (TextUtils.isEmpty(optString)) {
                                ebVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                ecVar = this.f310a;
                                eeVar = ee.SERVICE_COMPONENT;
                                context3 = this.a;
                            } else {
                                ecVar = this.f310a;
                                eeVar = ee.SERVICE_ACTION;
                                context3 = this.a;
                            }
                        } else if (ee.ACTIVITY.f313a.equals(optString5)) {
                            ecVar = this.f310a;
                            eeVar = ee.ACTIVITY;
                            context3 = this.a;
                        } else if (ee.PROVIDER.f313a.equals(optString5)) {
                            ecVar = this.f310a;
                            eeVar = ee.PROVIDER;
                            context3 = this.a;
                        } else {
                            context2 = this.a;
                            str3 = this.f311a;
                            str4 = "A receive a incorrect message with unknown type " + optString5;
                        }
                        ecVar.a(eeVar, context3, ebVar);
                        return;
                    }
                    context2 = this.a;
                    str3 = this.f311a;
                    str4 = "A receive a incorrect message with empty type";
                    dy.a(context2, str3, 1008, str4);
                    return;
                }
                dy.a(this.a, this.f311a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                return;
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                context = this.a;
                str = this.f311a;
                str2 = "A meet a exception when receive the message";
            }
        }
        dy.a(context, str, 1008, str2);
    }
}
