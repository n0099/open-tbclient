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
/* loaded from: classes2.dex */
public class eb implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f70873a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ea f321a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f322a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70874b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f70875c;

    public eb(ea eaVar, String str, Context context, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eaVar, str, context, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f321a = eaVar;
        this.f322a = str;
        this.f70873a = context;
        this.f70874b = str2;
        this.f70875c = str3;
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
            if (TextUtils.isEmpty(this.f322a)) {
                context = this.f70873a;
                str = StringUtil.NULL_STRING;
                str2 = "A receive a incorrect message with empty info";
            } else {
                try {
                    dw.a(this.f70873a, this.f322a, 1001, "get message");
                    JSONObject jSONObject = new JSONObject(this.f322a);
                    String optString = jSONObject.optString("action");
                    String optString2 = jSONObject.optString("awakened_app_packagename");
                    String optString3 = jSONObject.optString("awake_app_packagename");
                    String optString4 = jSONObject.optString("awake_app");
                    String optString5 = jSONObject.optString("awake_type");
                    int optInt = jSONObject.optInt("awake_foreground", 0);
                    if (this.f70874b.equals(optString3) && this.f70875c.equals(optString4)) {
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                            this.f321a.b(optString3);
                            this.f321a.a(optString4);
                            dz dzVar = new dz();
                            dzVar.b(optString);
                            dzVar.a(optString2);
                            dzVar.a(optInt);
                            dzVar.d(this.f322a);
                            if ("service".equals(optString5)) {
                                if (TextUtils.isEmpty(optString)) {
                                    dzVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                    eaVar = this.f321a;
                                    ecVar = ec.f70878c;
                                    context3 = this.f70873a;
                                } else {
                                    eaVar = this.f321a;
                                    ecVar = ec.f70877b;
                                    context3 = this.f70873a;
                                }
                            } else if (ec.f70876a.f324a.equals(optString5)) {
                                eaVar = this.f321a;
                                ecVar = ec.f70876a;
                                context3 = this.f70873a;
                            } else if (ec.f70879d.f324a.equals(optString5)) {
                                eaVar = this.f321a;
                                ecVar = ec.f70879d;
                                context3 = this.f70873a;
                            } else {
                                context2 = this.f70873a;
                                str3 = this.f322a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                            eaVar.a(ecVar, context3, dzVar);
                            return;
                        }
                        context2 = this.f70873a;
                        str3 = this.f322a;
                        str4 = "A receive a incorrect message with empty type";
                        dw.a(context2, str3, 1008, str4);
                        return;
                    }
                    dw.a(this.f70873a, this.f322a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                    return;
                } catch (JSONException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    context = this.f70873a;
                    str = this.f322a;
                    str2 = "A meet a exception when receive the message";
                }
            }
            dw.a(context, str, 1008, str2);
        }
    }
}
