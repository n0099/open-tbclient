package com.repackage;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class et3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755726131, "Lcom/repackage/et3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755726131, "Lcom/repackage/et3;");
                return;
            }
        }
        a = rf1.a;
    }

    public et3(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        or1 F = or1.F(jsObject);
        if (F == null) {
            return;
        }
        hz2 L = hz2.L();
        if (L == null) {
            a(F, false, b("internal error"));
            return;
        }
        try {
            boolean m = F.m("mixWithOther", false);
            L.T().h("key_audio_is_mix_with_other", Boolean.valueOf(m));
            if (a) {
                Log.d("InnerAudioOptionApi", "Audio Mix Changed to " + m);
            }
            a(F, true, "setInnerAudioOption:ok");
        } catch (Exception unused) {
            hw1.c("InnerAudioOptionApi", "set swanApp global var error");
            a(F, false, b("internal error"));
        }
    }

    public final void a(or1 or1Var, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{or1Var, Boolean.valueOf(z), str}) == null) {
            pt3 pt3Var = new pt3();
            pt3Var.errMsg = str;
            s14.call(or1Var, z, pt3Var);
        }
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? String.format("setInnerAudioOption:fail %s", str) : (String) invokeL.objValue;
    }
}
