package com.repackage;

import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;

    public p45() {
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

    public static p45 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                p45 p45Var = new p45();
                p45Var.a = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                p45Var.b = jSONObject.optInt("width");
                p45Var.c = jSONObject.optInt("height");
                p45Var.d = jSONObject.optString("pic_url");
                p45Var.e = jSONObject.optString("thumbnail");
                p45Var.g = jSONObject.optString("origin_url");
                return p45Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (p45) invokeL.objValue;
    }
}
