package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class dr1 implements fr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755757906, "Lcom/repackage/dr1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755757906, "Lcom/repackage/dr1;");
                return;
            }
        }
        a = j03.v;
    }

    public dr1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.fr1
    public js1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (j03.a0() == null) {
                if (a) {
                    Log.d("AbsMenuButtonHandle", "handleBoundsResult swanApp is null");
                }
                return d(1001);
            }
            sz1 V = wl2.U().V();
            if (V == null) {
                if (a) {
                    Log.d("AbsMenuButtonHandle", "handleBoundsResult fmManager is null");
                }
                return d(1001);
            }
            pz1 m = V.m();
            if (m == null) {
                if (a) {
                    Log.d("AbsMenuButtonHandle", "handleBoundsResult fragment is null");
                }
                return d(1001);
            }
            return c(m);
        }
        return (js1) invokeV.objValue;
    }

    public JSONObject b(int i, int i2, int i3, int i4) throws JSONException {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("width", Integer.valueOf(i3 - i));
            jSONObject.putOpt("height", Integer.valueOf(i4 - i2));
            jSONObject.putOpt("left", Integer.valueOf(i));
            jSONObject.putOpt("right", Integer.valueOf(i3));
            jSONObject.putOpt("top", Integer.valueOf(i2));
            jSONObject.putOpt("bottom", Integer.valueOf(i4));
            return jSONObject;
        }
        return (JSONObject) invokeIIII.objValue;
    }

    public abstract js1 c(@NonNull pz1 pz1Var);

    public abstract js1 d(int i);
}
