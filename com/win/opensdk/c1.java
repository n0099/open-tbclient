package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ d1 c;

    public c1(d1 d1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d1Var, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = d1Var;
        this.a = z;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a) {
                str = x1.b;
            } else {
                str = x1.c;
            }
            HashMap a = t1.a(this.c.a);
            try {
                str = str + t1.a(a);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.b;
            try {
                T0 t0 = new T0(str, "POST", M.a((Map) null));
                t0.b = M.h(str2);
                U0 a2 = t0.a();
                byte[] bArr = a2.b;
                if (a2.a == 200) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    jSONObject.optInt(Constants.KEYS.RET);
                    jSONObject.optString("msg");
                    try {
                        b = M.b(jSONObject.optString("data"));
                    } catch (Exception unused2) {
                    }
                    if (!TextUtils.isEmpty(b)) {
                        new JSONObject(b);
                    } else {
                        new JSONObject();
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
