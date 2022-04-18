package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class x49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(i59 i59Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, i59Var) == null) || i59Var == null || i59Var.y()) {
            return;
        }
        JSONArray n = i59Var.n();
        int length = n.length();
        boolean B = i59Var.B();
        for (int i = 0; i < length; i++) {
            try {
                if (B != d49.o().e(n.getJSONObject(i).getString("id"))) {
                    Log.w("UBCDebug", " data is " + B + "  content " + i59Var.u().toString());
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
