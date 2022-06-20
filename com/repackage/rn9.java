package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rn9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ un9 c;

    public rn9(un9 un9Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {un9Var, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = un9Var;
        this.a = z;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.a ? tq9.b : tq9.c;
            HashMap b = dq9.b(this.c.a);
            try {
                str = str + dq9.a(b);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.b;
            try {
                pm9 pm9Var = new pm9(str, "POST", sl9.k(null));
                pm9Var.b = sl9.L(str2);
                sm9 a = pm9Var.a();
                byte[] bArr = a.b;
                if (a.a == 200) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    jSONObject.optInt(Constants.KEYS.RET);
                    jSONObject.optString("msg");
                    try {
                        x = sl9.x(jSONObject.optString("data"));
                    } catch (Exception unused2) {
                    }
                    if (TextUtils.isEmpty(x)) {
                        new JSONObject();
                    } else {
                        new JSONObject(x);
                    }
                }
            } catch (JSONException e) {
                e.getMessage();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
    }
}
