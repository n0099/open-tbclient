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
/* loaded from: classes6.dex */
public class kn9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ nn9 c;

    public kn9(nn9 nn9Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nn9Var, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = nn9Var;
        this.a = z;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.a ? mq9.b : mq9.c;
            HashMap b = wp9.b(this.c.a);
            try {
                str = str + wp9.a(b);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.b;
            try {
                im9 im9Var = new im9(str, "POST", ll9.k(null));
                im9Var.b = ll9.L(str2);
                lm9 a = im9Var.a();
                byte[] bArr = a.b;
                if (a.a == 200) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    jSONObject.optInt(Constants.KEYS.RET);
                    jSONObject.optString("msg");
                    try {
                        x = ll9.x(jSONObject.optString("data"));
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
