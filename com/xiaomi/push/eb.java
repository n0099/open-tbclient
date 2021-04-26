package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class eb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f38340a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ea f313a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f314a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f38341b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f38342c;

    public eb(ea eaVar, String str, Context context, String str2, String str3) {
        this.f313a = eaVar;
        this.f314a = str;
        this.f38340a = context;
        this.f38341b = str2;
        this.f38342c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        String str;
        String str2;
        Context context2;
        String str3;
        String str4;
        ea eaVar;
        ec ecVar;
        Context context3;
        if (TextUtils.isEmpty(this.f314a)) {
            context = this.f38340a;
            str = StringUtil.NULL_STRING;
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                dw.a(this.f38340a, this.f314a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f314a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.f38341b.equals(optString3) && this.f38342c.equals(optString4)) {
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                        this.f313a.b(optString3);
                        this.f313a.a(optString4);
                        dz dzVar = new dz();
                        dzVar.b(optString);
                        dzVar.a(optString2);
                        dzVar.a(optInt);
                        dzVar.d(this.f314a);
                        if ("service".equals(optString5)) {
                            if (TextUtils.isEmpty(optString)) {
                                dzVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                eaVar = this.f313a;
                                ecVar = ec.SERVICE_COMPONENT;
                                context3 = this.f38340a;
                            } else {
                                eaVar = this.f313a;
                                ecVar = ec.SERVICE_ACTION;
                                context3 = this.f38340a;
                            }
                        } else if (ec.ACTIVITY.f316a.equals(optString5)) {
                            eaVar = this.f313a;
                            ecVar = ec.ACTIVITY;
                            context3 = this.f38340a;
                        } else if (ec.PROVIDER.f316a.equals(optString5)) {
                            eaVar = this.f313a;
                            ecVar = ec.PROVIDER;
                            context3 = this.f38340a;
                        } else {
                            context2 = this.f38340a;
                            str3 = this.f314a;
                            str4 = "A receive a incorrect message with unknown type " + optString5;
                        }
                        eaVar.a(ecVar, context3, dzVar);
                        return;
                    }
                    context2 = this.f38340a;
                    str3 = this.f314a;
                    str4 = "A receive a incorrect message with empty type";
                    dw.a(context2, str3, 1008, str4);
                    return;
                }
                dw.a(this.f38340a, this.f314a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                return;
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                context = this.f38340a;
                str = this.f314a;
                str2 = "A meet a exception when receive the message";
            }
        }
        dw.a(context, str, 1008, str2);
    }
}
