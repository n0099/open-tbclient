package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class R0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42453a;

    /* renamed from: b  reason: collision with root package name */
    public String f42454b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f42455c;

    public R0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42453a = 101;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            this.f42453a = jSONObject.optInt(Constants.KEYS.RET);
            this.f42454b = jSONObject.optString("msg");
            String optString = jSONObject.optString("data");
            try {
                optString = z.b(optString);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(optString)) {
                this.f42455c = new JSONObject();
            } else {
                this.f42455c = new JSONObject(optString);
            }
        }
    }
}
