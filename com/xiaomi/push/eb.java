package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class eb implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ea f297a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f298a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public eb(ea eaVar, String str, Context context, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eaVar, str, context, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f297a = eaVar;
        this.f298a = str;
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
        ea eaVar;
        ec ecVar;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (TextUtils.isEmpty(this.f298a)) {
                context = this.a;
                str = StringUtil.NULL_STRING;
                str2 = "A receive a incorrect message with empty info";
            } else {
                try {
                    dw.a(this.a, this.f298a, 1001, "get message");
                    JSONObject jSONObject = new JSONObject(this.f298a);
                    String optString = jSONObject.optString("action");
                    String optString2 = jSONObject.optString("awakened_app_packagename");
                    String optString3 = jSONObject.optString("awake_app_packagename");
                    String optString4 = jSONObject.optString("awake_app");
                    String optString5 = jSONObject.optString("awake_type");
                    int optInt = jSONObject.optInt("awake_foreground", 0);
                    if (this.b.equals(optString3) && this.c.equals(optString4)) {
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                            this.f297a.b(optString3);
                            this.f297a.a(optString4);
                            dz dzVar = new dz();
                            dzVar.b(optString);
                            dzVar.a(optString2);
                            dzVar.a(optInt);
                            dzVar.d(this.f298a);
                            if ("service".equals(optString5)) {
                                if (TextUtils.isEmpty(optString)) {
                                    dzVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                    eaVar = this.f297a;
                                    ecVar = ec.c;
                                    context3 = this.a;
                                } else {
                                    eaVar = this.f297a;
                                    ecVar = ec.b;
                                    context3 = this.a;
                                }
                            } else if (ec.a.f300a.equals(optString5)) {
                                eaVar = this.f297a;
                                ecVar = ec.a;
                                context3 = this.a;
                            } else if (ec.d.f300a.equals(optString5)) {
                                eaVar = this.f297a;
                                ecVar = ec.d;
                                context3 = this.a;
                            } else {
                                context2 = this.a;
                                str3 = this.f298a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                            eaVar.a(ecVar, context3, dzVar);
                            return;
                        }
                        context2 = this.a;
                        str3 = this.f298a;
                        str4 = "A receive a incorrect message with empty type";
                        dw.a(context2, str3, 1008, str4);
                        return;
                    }
                    dw.a(this.a, this.f298a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                    return;
                } catch (JSONException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    context = this.a;
                    str = this.f298a;
                    str2 = "A meet a exception when receive the message";
                }
            }
            dw.a(context, str, 1008, str2);
        }
    }
}
