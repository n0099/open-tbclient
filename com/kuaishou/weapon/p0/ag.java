package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ag {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ag() {
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

    public static JSONObject a(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    file = new File(context.getDataDir(), "xreplace");
                } else {
                    file = new File("/data/data/" + context.getPackageName() + "/xreplace");
                }
                if (file.exists()) {
                    jSONObject.put("xreplace", 1);
                }
                if (new File("/storage/emulated/0/xxsq").exists()) {
                    jSONObject.put("xxsq", 1);
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
