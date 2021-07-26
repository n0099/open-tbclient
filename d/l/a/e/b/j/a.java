package d.l.a.e.b.j;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.g.e;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final h<Integer, a> f72328e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f72329f;

    /* renamed from: g  reason: collision with root package name */
    public static JSONObject f72330g;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f72331h;

    /* renamed from: i  reason: collision with root package name */
    public static Boolean f72332i;
    public static boolean j;
    public static a k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f72333a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f72334b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f72335c;

    /* renamed from: d  reason: collision with root package name */
    public int f72336d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1799688382, "Ld/l/a/e/b/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1799688382, "Ld/l/a/e/b/j/a;");
                return;
            }
        }
        f72328e = new h<>(16, 16);
        f72329f = new a(null);
        i();
    }

    public a(JSONObject jSONObject) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72333a = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || w("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !w("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.f72334b = jSONObject2;
        this.f72335c = bool;
    }

    @NonNull
    public static a d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? e(i2, null) : (a) invokeI.objValue;
    }

    public static a e(int i2, DownloadInfo downloadInfo) {
        InterceptResult invokeIL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, downloadInfo)) == null) {
            a aVar2 = k;
            if (aVar2 == null || aVar2.f72336d != i2) {
                synchronized (f72328e) {
                    aVar = f72328e.get(Integer.valueOf(i2));
                }
                if (aVar == null) {
                    aVar = downloadInfo == null ? s(i2) : n(downloadInfo);
                    synchronized (f72328e) {
                        f72328e.put(Integer.valueOf(i2), aVar);
                    }
                }
                aVar.f72336d = i2;
                k = aVar;
                return aVar;
            }
            return aVar2;
        }
        return (a) invokeIL.objValue;
    }

    @NonNull
    public static a f(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return f72329f;
            }
            return e(downloadInfo.getId(), downloadInfo);
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a g(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            if (jSONObject != null && jSONObject != o() && !j) {
                a aVar = k;
                if (aVar == null || aVar.f72333a != jSONObject) {
                    synchronized (f72328e) {
                        for (a aVar2 : f72328e.values()) {
                            if (aVar2.f72333a == jSONObject) {
                                k = aVar2;
                                return aVar2;
                            }
                        }
                        a aVar3 = new a(jSONObject);
                        k = aVar3;
                        return aVar3;
                    }
                }
                return aVar;
            }
            return f72329f;
        }
        return (a) invokeL.objValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            JSONObject e2 = e.e();
            j = e2.optInt("disable_task_setting", 0) == 1;
            f72330g = e2.optJSONObject("disabled_task_keys");
            JSONObject optJSONObject = e2.optJSONObject("bugfix");
            Boolean bool = null;
            if (optJSONObject != null && optJSONObject.has("default")) {
                bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            f72331h = optJSONObject;
            f72332i = bool;
        }
    }

    public static void j(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i2, jSONObject) == null) || jSONObject == null || jSONObject == o() || j) {
            return;
        }
        synchronized (f72328e) {
            a aVar = k;
            if (aVar != null && aVar.f72333a == jSONObject) {
                aVar.f72336d = i2;
            } else {
                aVar = null;
                Iterator<a> it = f72328e.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f72333a == jSONObject) {
                        next.f72336d = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f72336d = i2;
                }
                k = aVar;
            }
            f72328e.put(Integer.valueOf(i2), aVar);
        }
    }

    public static void k(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, str, z) == null) {
            try {
                if (f72331h == null) {
                    f72331h = new JSONObject();
                }
                f72331h.put(str, z ? 1 : 0);
            } catch (JSONException unused) {
            }
        }
    }

    public static a n(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, downloadInfo)) == null) {
            if (j) {
                return f72329f;
            }
            try {
                String downloadSettingString = downloadInfo.getDownloadSettingString();
                if (!TextUtils.isEmpty(downloadSettingString)) {
                    return new a(new JSONObject(downloadSettingString));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return f72329f;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static JSONObject o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? e.e() : (JSONObject) invokeV.objValue;
    }

    public static void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i2) == null) {
            a aVar = k;
            if (aVar != null && aVar.f72336d == i2) {
                k = null;
            }
            synchronized (f72328e) {
                f72328e.remove(Integer.valueOf(i2));
            }
        }
    }

    @NonNull
    public static a r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f72329f : (a) invokeV.objValue;
    }

    public static a s(int i2) {
        InterceptResult invokeI;
        DownloadInfo f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            if (j) {
                return f72329f;
            }
            Context n = e.n();
            if (n != null && (f2 = d.l.a.e.b.g.a.H(n).f(i2)) != null) {
                return n(f2);
            }
            return f72329f;
        }
        return (a) invokeI.objValue;
    }

    public static boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            JSONObject jSONObject = f72330g;
            return jSONObject != null && jSONObject.optInt(str, 0) == 1;
        }
        return invokeL.booleanValue;
    }

    public double a(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            JSONObject jSONObject = this.f72333a;
            if (jSONObject != null && jSONObject.has(str) && !w(str)) {
                return this.f72333a.optDouble(str, d2);
            }
            return o().optDouble(str, d2);
        }
        return invokeCommon.doubleValue;
    }

    public int b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            JSONObject jSONObject = this.f72333a;
            if (jSONObject != null && jSONObject.has(str) && !w(str)) {
                return this.f72333a.optInt(str, i2);
            }
            return o().optInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public long c(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2)) == null) {
            JSONObject jSONObject = this.f72333a;
            if (jSONObject != null && jSONObject.has(str) && !w(str)) {
                return this.f72333a.optLong(str, j2);
            }
            return o().optLong(str, j2);
        }
        return invokeLJ.longValue;
    }

    public String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            JSONObject jSONObject = this.f72333a;
            if (jSONObject != null && jSONObject.has(str) && !w(str)) {
                return this.f72333a.optString(str, str2);
            }
            return o().optString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? q(str, false) : invokeL.booleanValue;
    }

    public int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? b(str, 0) : invokeL.intValue;
    }

    public boolean q(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            if (this.f72334b != null && !w(str)) {
                if (this.f72334b.has(str)) {
                    return this.f72334b.optInt(str, z ? 1 : 0) == 1;
                }
                Boolean bool = this.f72335c;
                if (bool != null) {
                    return bool.booleanValue();
                }
            }
            JSONObject jSONObject = f72331h;
            if (jSONObject != null) {
                if (jSONObject.has(str)) {
                    return f72331h.optInt(str, z ? 1 : 0) == 1;
                }
                Boolean bool2 = f72332i;
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    public String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? h(str, "") : (String) invokeL.objValue;
    }

    public JSONObject u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            JSONObject jSONObject = this.f72333a;
            if (jSONObject != null && jSONObject.has(str) && !w(str)) {
                return this.f72333a.optJSONObject(str);
            }
            return o().optJSONObject(str);
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONArray v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            JSONObject jSONObject = this.f72333a;
            if (jSONObject != null && jSONObject.has(str) && !w(str)) {
                return this.f72333a.optJSONArray(str);
            }
            return o().optJSONArray(str);
        }
        return (JSONArray) invokeL.objValue;
    }
}
