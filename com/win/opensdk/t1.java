package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class t1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39946a;

    /* renamed from: b  reason: collision with root package name */
    public String f39947b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f39948c;

    public t1() {
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
        this.f39946a = 101;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            this.f39946a = jSONObject.optInt(Constants.KEYS.RET);
            this.f39947b = jSONObject.optString("msg");
            String optString = jSONObject.optString("data");
            try {
                optString = N.b(optString);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(optString)) {
                this.f39948c = new JSONObject();
            } else {
                this.f39948c = new JSONObject(optString);
            }
        }
    }
}
