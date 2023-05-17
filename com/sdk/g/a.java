package com.sdk.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.h;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.sdk.e.b<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b b;

    public a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bVar;
    }

    @Override // com.sdk.e.b
    public void a(h<String> hVar, String str) {
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hVar, str) == null) {
            if (hVar == null) {
                str2 = "";
            } else {
                str2 = hVar.b;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int optInt = jSONObject.optInt("code");
                try {
                    String optString = jSONObject.optString("msg");
                    int optInt2 = jSONObject.optInt("status");
                    String optString2 = jSONObject.optString("obj");
                    String optString3 = jSONObject.optString("seq");
                    if (com.sdk.o.a.a(optString).booleanValue() && com.sdk.o.a.a(optString3).booleanValue() && com.sdk.o.a.a(optString2).booleanValue()) {
                        this.b.a(1, "服务端数据格式出错", 302003, null, com.sdk.o.b.a().c);
                        com.sdk.o.a.a(b.a, "返回数据为空", Boolean.valueOf(b.b));
                        return;
                    }
                    this.b.a(optInt, optString, optInt2, optString2, optString3);
                } catch (Throwable th) {
                    th = th;
                    i = optInt;
                    com.sdk.o.b.d(th.toString());
                    this.b.a(i, "服务端数据格式出错", 302003, null, com.sdk.o.b.a().c);
                    String str3 = b.a;
                    com.sdk.o.a.a(str3, "返回数据解析异常：" + th.toString(), Boolean.valueOf(b.b));
                }
            } catch (Throwable th2) {
                th = th2;
                i = 1;
            }
        }
    }
}
