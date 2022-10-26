package com.sdk.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.i;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.sdk.e.b {
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
    public void a(i iVar, String str) {
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, iVar, str) == null) {
            if (iVar == null) {
                str2 = "";
            } else {
                str2 = (String) iVar.b;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int optInt = jSONObject.optInt("code");
                try {
                    String optString = jSONObject.optString("msg");
                    int optInt2 = jSONObject.optInt("status");
                    String optString2 = jSONObject.optString("obj");
                    String optString3 = jSONObject.optString("seq");
                    if (com.sdk.n.a.a(optString).booleanValue() && com.sdk.n.a.a(optString3).booleanValue() && com.sdk.n.a.a(optString2).booleanValue()) {
                        this.b.a(1, "服务端数据格式出错", 302003, null, com.sdk.n.b.a().c);
                        com.sdk.n.a.a(b.a, "返回数据为空", Boolean.valueOf(b.b));
                        return;
                    }
                    this.b.a(optInt, optString, optInt2, optString2, optString3);
                } catch (Throwable th) {
                    th = th;
                    i = optInt;
                    com.sdk.n.b.d(th.toString());
                    this.b.a(i, "服务端数据格式出错", 302003, null, com.sdk.n.b.a().c);
                    String str3 = b.a;
                    com.sdk.n.a.a(str3, "返回数据解析异常：" + th.toString(), Boolean.valueOf(b.b));
                }
            } catch (Throwable th2) {
                th = th2;
                i = 1;
            }
        }
    }
}
