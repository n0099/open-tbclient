package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class v09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(g19 g19Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, g19Var) == null) || g19Var == null || g19Var.y()) {
            return;
        }
        JSONArray n = g19Var.n();
        int length = n.length();
        boolean B = g19Var.B();
        for (int i = 0; i < length; i++) {
            try {
                if (B != b09.o().e(n.getJSONObject(i).getString("id"))) {
                    Log.w("UBCDebug", " data is " + B + "  content " + g19Var.u().toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }
}
