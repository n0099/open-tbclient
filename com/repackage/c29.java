package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class c29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(n29 n29Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, n29Var) == null) || n29Var == null || n29Var.y()) {
            return;
        }
        JSONArray n = n29Var.n();
        int length = n.length();
        boolean B = n29Var.B();
        for (int i = 0; i < length; i++) {
            try {
                if (B != i19.o().e(n.getJSONObject(i).getString("id"))) {
                    Log.w("UBCDebug", " data is " + B + "  content " + n29Var.u().toString());
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
