package com.repackage;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class y25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;

    public y25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static y25 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                y25 y25Var = new y25();
                y25Var.a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                y25Var.b = jSONObject.optInt("width");
                y25Var.c = jSONObject.optInt("height");
                y25Var.d = jSONObject.optString("pic_url");
                y25Var.e = jSONObject.optString("thumbnail");
                y25Var.g = jSONObject.optString("origin_url");
                return y25Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (y25) invokeL.objValue;
    }
}
