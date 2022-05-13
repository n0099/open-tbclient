package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class py2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755393656, "Lcom/repackage/py2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755393656, "Lcom/repackage/py2;");
                return;
            }
        }
        a = eh1.a;
    }

    public static JSONObject a(List<String> list, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, list, f)) == null) {
            if (a) {
                Log.d("PublisherCompress", "start compress");
            }
            ArrayList arrayList = new ArrayList();
            u03 L = u03.L();
            if (L == null) {
                return null;
            }
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    File k = sd3.k(file.getName());
                    if (sd3.b(file, k, (int) (100.0f * f))) {
                        arrayList.add(k);
                    }
                }
            }
            return b(arrayList, L);
        }
        return (JSONObject) invokeLF.objValue;
    }

    public static JSONObject b(ArrayList<File> arrayList, u03 u03Var) {
        InterceptResult invokeLL;
        String J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, u03Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            boolean v0 = u03Var.v0();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        if (v0) {
                            J = ed2.Z(next.getAbsolutePath());
                        } else {
                            J = c83.J(next.getAbsolutePath(), u03Var.b);
                        }
                        if (a) {
                            Log.d("PublisherCompress", "isSwanGame: " + v0 + "; path: " + J);
                        }
                        jSONArray.put(J);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("path", J);
                        jSONObject2.put("size", next.length());
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("tempFilePaths", jSONArray);
                jSONObject.put("tempFiles", jSONArray2);
            } catch (JSONException e) {
                if (a) {
                    Log.e("PublisherCompress", "wrapParams failed");
                    e.printStackTrace();
                }
            }
            if (a) {
                Log.e("PublisherCompress", jSONObject.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
