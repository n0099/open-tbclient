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
/* loaded from: classes10.dex */
public class X0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f77283a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f77284b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Y0 f77285c;

    public X0(Y0 y0, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y0, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77285c = y0;
        this.f77283a = z;
        this.f77284b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.f77283a ? s1.f77517b : s1.f77518c;
            HashMap a2 = o1.a(this.f77285c.f77288a);
            try {
                str = str + o1.a(a2);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.f77284b;
            try {
                U0 u0 = new U0(str, "POST", N.a((Map) null));
                u0.f77261b = N.h(str2);
                V0 a3 = u0.a();
                byte[] bArr = a3.f77273b;
                if (a3.f77272a == 200) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    jSONObject.optInt(Constants.KEYS.RET);
                    jSONObject.optString("msg");
                    try {
                        b2 = N.b(jSONObject.optString("data"));
                    } catch (Exception unused2) {
                    }
                    if (TextUtils.isEmpty(b2)) {
                        new JSONObject();
                    } else {
                        new JSONObject(b2);
                    }
                }
            } catch (JSONException e2) {
                e2.getMessage();
            } catch (Exception e3) {
                e3.getMessage();
            }
        }
    }
}
