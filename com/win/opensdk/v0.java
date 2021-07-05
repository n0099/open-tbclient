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
/* loaded from: classes7.dex */
public class v0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f42657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f42658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ w0 f42659c;

    public v0(w0 w0Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w0Var, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42659c = w0Var;
        this.f42657a = z;
        this.f42658b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = this.f42657a ? Q0.f42443b : Q0.f42444c;
            HashMap a2 = M0.a(this.f42659c.f42682a);
            try {
                str = str + M0.a(a2);
            } catch (UnsupportedEncodingException unused) {
            }
            String str2 = this.f42658b;
            try {
                s0 s0Var = new s0(str, "POST", z.a((Map) null));
                s0Var.f42638b = z.h(str2);
                t0 a3 = s0Var.a();
                byte[] bArr = a3.f42648b;
                if (a3.f42647a == 200) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                    jSONObject.optInt(Constants.KEYS.RET);
                    jSONObject.optString("msg");
                    try {
                        b2 = z.b(jSONObject.optString("data"));
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
