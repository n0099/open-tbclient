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
public class ee implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ed f1027a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f1028a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public ee(ed edVar, String str, Context context, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {edVar, str, context, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1027a = edVar;
        this.f1028a = str;
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
        ed edVar;
        ef efVar;
        Context context3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (TextUtils.isEmpty(this.f1028a)) {
                context = this.a;
                str = StringUtil.NULL_STRING;
                str2 = "A receive a incorrect message with empty info";
            } else {
                try {
                    dz.a(this.a, this.f1028a, 1001, "get message");
                    JSONObject jSONObject = new JSONObject(this.f1028a);
                    String optString = jSONObject.optString("action");
                    String optString2 = jSONObject.optString("awakened_app_packagename");
                    String optString3 = jSONObject.optString("awake_app_packagename");
                    String optString4 = jSONObject.optString("awake_app");
                    String optString5 = jSONObject.optString("awake_type");
                    int optInt = jSONObject.optInt("awake_foreground", 0);
                    if (this.b.equals(optString3) && this.c.equals(optString4)) {
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                            this.f1027a.b(optString3);
                            this.f1027a.a(optString4);
                            ec ecVar = new ec();
                            ecVar.b(optString);
                            ecVar.a(optString2);
                            ecVar.a(optInt);
                            ecVar.d(this.f1028a);
                            if ("service".equals(optString5)) {
                                if (TextUtils.isEmpty(optString)) {
                                    ecVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                    edVar = this.f1027a;
                                    efVar = ef.c;
                                    context3 = this.a;
                                } else {
                                    edVar = this.f1027a;
                                    efVar = ef.b;
                                    context3 = this.a;
                                }
                            } else if (ef.a.f1030a.equals(optString5)) {
                                edVar = this.f1027a;
                                efVar = ef.a;
                                context3 = this.a;
                            } else if (ef.d.f1030a.equals(optString5)) {
                                edVar = this.f1027a;
                                efVar = ef.d;
                                context3 = this.a;
                            } else {
                                context2 = this.a;
                                str3 = this.f1028a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                            edVar.a(efVar, context3, ecVar);
                            return;
                        }
                        context2 = this.a;
                        str3 = this.f1028a;
                        str4 = "A receive a incorrect message with empty type";
                        dz.a(context2, str3, 1008, str4);
                        return;
                    }
                    dz.a(this.a, this.f1028a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                    return;
                } catch (JSONException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    context = this.a;
                    str = this.f1028a;
                    str2 = "A meet a exception when receive the message";
                }
            }
            dz.a(context, str, 1008, str2);
        }
    }
}
