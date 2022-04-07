package com.kuaishou.weapon.un;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class u0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public u0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("result", 0) == 1) {
                    String a = new m1(this.a).a(jSONObject.getString("antispamSdkRsp"));
                    if (TextUtils.isEmpty(a)) {
                        return;
                    }
                    k a2 = i.a(a);
                    d dVar = new d(this.a);
                    if (a2 != null) {
                        dVar.a(str, a2);
                    } else {
                        dVar.d(System.currentTimeMillis());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                String str = r0.a + r0.b;
                String e = s0.e(this.a);
                if (!TextUtils.isEmpty(e)) {
                    str = str + "?" + e;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject c = s0.c(this.a);
                if (c != null) {
                    jSONObject.put("data", new m1(this.a).b(c.toString()));
                }
                a(new p1(this.a, null).a(str, jSONObject.toString().getBytes()));
            } catch (Exception unused) {
            }
        }
    }
}
