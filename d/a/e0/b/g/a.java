package d.a.e0.b.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42258a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1078273070, "Ld/a/e0/b/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1078273070, "Ld/a/e0/b/g/a;");
                return;
            }
        }
        f42258a = d.a.e0.a.a.a.f42207a;
    }

    public static List<h> a(JSONArray jSONArray, String str, boolean z) throws ParseError {
        InterceptResult invokeLLZ;
        List<h> h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, jSONArray, str, z)) == null) {
            if (jSONArray == null || jSONArray.length() == 0 || (h2 = h.h(jSONArray)) == null || h2.size() == 0) {
                return null;
            }
            if (z) {
                for (h hVar : h2) {
                    hVar.x = true;
                }
            } else {
                HashMap<String, h> q = f.q();
                if (q != null && q.size() != 0) {
                    f.g(h2);
                    f.z(h2);
                } else {
                    f.z(h2);
                }
                f.w(h2);
            }
            return h2;
        }
        return (List) invokeLLZ.objValue;
    }

    public static List<h> b(String str, String str2) throws ParseError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return c(new JSONObject(str), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    throw new ParseError(1, "afd/entry retun invalid json");
                }
            }
            throw new ParseError(1, "afd/entry retun null");
        }
        return (List) invokeLL.objValue;
    }

    public static List<h> c(JSONObject jSONObject, String str) throws ParseError {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) {
            if (f42258a) {
                Log.d("AfdResponseParser", "AFD response : " + jSONObject.toString());
            }
            List<h> arrayList = new ArrayList<>();
            if (jSONObject != null) {
                if (jSONObject.optInt("errno", 0) <= 0 && (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("splash");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("cmd");
                        SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
                        g.l(optJSONObject2.optString("src_ext_info"));
                        if (TextUtils.equals("update", optString)) {
                            arrayList = a(optJSONArray, str, false);
                            String optString2 = optJSONObject2.optString("empty_ext_info");
                            if (!TextUtils.isEmpty(optString2)) {
                                d.a.e0.a.c.j.j("empty_ext_info", optString2);
                            } else if (f42258a) {
                                throw new IllegalStateException("splash empty接口没有empty_ext_info信息");
                            }
                        } else if (TextUtils.equals("query", optString)) {
                            int optInt = optJSONObject2.optInt("realTimeLoading");
                            if (optInt == 1) {
                                arrayList = a(optJSONArray, str, true);
                                if (arrayList == null || arrayList.size() == 0) {
                                    b.f(128);
                                }
                            } else {
                                String optString3 = optJSONObject2.optString("ukey");
                                if (TextUtils.isEmpty(optString3)) {
                                    b.f(32);
                                    return arrayList;
                                }
                                List<h> s = f.s();
                                if (s == null) {
                                    return arrayList;
                                }
                                Iterator<h> it = s.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    h next = it.next();
                                    if (TextUtils.equals(next.f42282c, optString3)) {
                                        arrayList.add(next);
                                        break;
                                    }
                                }
                                if (arrayList.size() == 0) {
                                    b.f(64);
                                }
                            }
                            if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                                arrayList.get(0).C = optInt == 1 ? 1 : 0;
                            }
                        }
                    }
                    return arrayList;
                }
                return null;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
