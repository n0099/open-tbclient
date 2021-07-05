package d.a.q0.a.w1.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import d.a.q0.a.r0.n;
import d.a.q0.a.v2.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51542a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161789051, "Ld/a/q0/a/w1/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1161789051, "Ld/a/q0/a/w1/j/a;");
                return;
            }
        }
        f51542a = k.f49133a;
    }

    public static JSONObject a(List<String> list, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, list, f2)) == null) {
            if (f51542a) {
                Log.d("PublisherCompress", "start compress");
            }
            ArrayList arrayList = new ArrayList();
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            if (i2 == null) {
                return null;
            }
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    File k = u.k(file.getName());
                    if (u.b(file, k, (int) (100.0f * f2))) {
                        arrayList.add(k);
                    }
                }
            }
            return b(arrayList, i2);
        }
        return (JSONObject) invokeLF.objValue;
    }

    public static JSONObject b(ArrayList<File> arrayList, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLL;
        String J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            boolean m0 = eVar.m0();
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        if (m0) {
                            J = n.V(next.getAbsolutePath());
                        } else {
                            J = d.a.q0.a.k2.b.J(next.getAbsolutePath(), eVar.f46683f);
                        }
                        if (f51542a) {
                            Log.d("PublisherCompress", "isSwanGame: " + m0 + "; path: " + J);
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
            } catch (JSONException e2) {
                if (f51542a) {
                    Log.e("PublisherCompress", "wrapParams failed");
                    e2.printStackTrace();
                }
            }
            if (f51542a) {
                Log.e("PublisherCompress", jSONObject.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
