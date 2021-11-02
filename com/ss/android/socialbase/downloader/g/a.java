package com.ss.android.socialbase.downloader.g;

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
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final h<Integer, a> f69383a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f69384b;

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f69385c;

    /* renamed from: d  reason: collision with root package name */
    public static JSONObject f69386d;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f69387e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f69388f;

    /* renamed from: g  reason: collision with root package name */
    public static a f69389g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f69390h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f69391i;
    public final Boolean j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479370688, "Lcom/ss/android/socialbase/downloader/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479370688, "Lcom/ss/android/socialbase/downloader/g/a;");
                return;
            }
        }
        f69383a = new h<>(16, 16);
        f69384b = new a(null);
        a();
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
        this.f69390h = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || f("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !f("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.f69391i = jSONObject2;
        this.j = bool;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            JSONObject E = c.E();
            f69388f = E.optInt("disable_task_setting", 0) == 1;
            f69385c = E.optJSONObject("disabled_task_keys");
            JSONObject optJSONObject = E.optJSONObject("bugfix");
            Boolean bool = null;
            if (optJSONObject != null && optJSONObject.has("default")) {
                bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            f69386d = optJSONObject;
            f69387e = bool;
        }
    }

    @NonNull
    public static JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.E() : (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f69384b : (a) invokeV.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            JSONObject jSONObject = f69385c;
            return jSONObject != null && jSONObject.optInt(str, 0) == 1;
        }
        return invokeL.booleanValue;
    }

    public JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            JSONObject jSONObject = this.f69390h;
            if (jSONObject != null && jSONObject.has(str) && !f(str)) {
                return this.f69390h.optJSONObject(str);
            }
            return b().optJSONObject(str);
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONArray e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            JSONObject jSONObject = this.f69390h;
            if (jSONObject != null && jSONObject.has(str) && !f(str)) {
                return this.f69390h.optJSONArray(str);
            }
            return b().optJSONArray(str);
        }
        return (JSONArray) invokeL.objValue;
    }

    public boolean b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            if (this.f69391i != null && !f(str)) {
                if (this.f69391i.has(str)) {
                    return this.f69391i.optInt(str, z ? 1 : 0) == 1;
                }
                Boolean bool = this.j;
                if (bool != null) {
                    return bool.booleanValue();
                }
            }
            JSONObject jSONObject = f69386d;
            if (jSONObject != null) {
                if (jSONObject.has(str)) {
                    return f69386d.optInt(str, z ? 1 : 0) == 1;
                }
                Boolean bool2 = f69387e;
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
            }
            return z;
        }
        return invokeLZ.booleanValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? a(str, "") : (String) invokeL.objValue;
    }

    public static a c(int i2) {
        InterceptResult invokeI;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            if (f69388f) {
                return f69384b;
            }
            Context N = c.N();
            if (N != null && (downloadInfo = Downloader.getInstance(N).getDownloadInfo(i2)) != null) {
                return b(downloadInfo);
            }
            return f69384b;
        }
        return (a) invokeI.objValue;
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, str, z) == null) {
            try {
                if (f69386d == null) {
                    f69386d = new JSONObject();
                }
                f69386d.put(str, z ? 1 : 0);
            } catch (JSONException unused) {
            }
        }
    }

    @NonNull
    public static a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? a(i2, (DownloadInfo) null) : (a) invokeI.objValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? a(str, 0) : invokeL.intValue;
    }

    @NonNull
    public static a a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return f69384b;
            }
            return a(downloadInfo.getId(), downloadInfo);
        }
        return (a) invokeL.objValue;
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i2) == null) {
            a aVar = f69389g;
            if (aVar != null && aVar.k == i2) {
                f69389g = null;
            }
            synchronized (f69383a) {
                f69383a.remove(Integer.valueOf(i2));
            }
        }
    }

    public static a a(int i2, DownloadInfo downloadInfo) {
        InterceptResult invokeIL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, downloadInfo)) == null) {
            a aVar2 = f69389g;
            if (aVar2 == null || aVar2.k != i2) {
                synchronized (f69383a) {
                    aVar = f69383a.get(Integer.valueOf(i2));
                }
                if (aVar == null) {
                    aVar = downloadInfo == null ? c(i2) : b(downloadInfo);
                    synchronized (f69383a) {
                        f69383a.put(Integer.valueOf(i2), aVar);
                    }
                }
                aVar.k = i2;
                f69389g = aVar;
                return aVar;
            }
            return aVar2;
        }
        return (a) invokeIL.objValue;
    }

    public static a b(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, downloadInfo)) == null) {
            if (f69388f) {
                return f69384b;
            }
            try {
                String downloadSettingString = downloadInfo.getDownloadSettingString();
                if (!TextUtils.isEmpty(downloadSettingString)) {
                    return new a(new JSONObject(downloadSettingString));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return f69384b;
        }
        return (a) invokeL.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? b(str, false) : invokeL.booleanValue;
    }

    public int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            JSONObject jSONObject = this.f69390h;
            if (jSONObject != null && jSONObject.has(str) && !f(str)) {
                return this.f69390h.optInt(str, i2);
            }
            return b().optInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public long a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            JSONObject jSONObject = this.f69390h;
            if (jSONObject != null && jSONObject.has(str) && !f(str)) {
                return this.f69390h.optLong(str, j);
            }
            return b().optLong(str, j);
        }
        return invokeLJ.longValue;
    }

    public double a(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            JSONObject jSONObject = this.f69390h;
            if (jSONObject != null && jSONObject.has(str) && !f(str)) {
                return this.f69390h.optDouble(str, d2);
            }
            return b().optDouble(str, d2);
        }
        return invokeCommon.doubleValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            JSONObject jSONObject = this.f69390h;
            if (jSONObject != null && jSONObject.has(str) && !f(str)) {
                return this.f69390h.optString(str, str2);
            }
            return b().optString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            if (jSONObject != null && jSONObject != b() && !f69388f) {
                a aVar = f69389g;
                if (aVar == null || aVar.f69390h != jSONObject) {
                    synchronized (f69383a) {
                        for (a aVar2 : f69383a.values()) {
                            if (aVar2.f69390h == jSONObject) {
                                f69389g = aVar2;
                                return aVar2;
                            }
                        }
                        a aVar3 = new a(jSONObject);
                        f69389g = aVar3;
                        return aVar3;
                    }
                }
                return aVar;
            }
            return f69384b;
        }
        return (a) invokeL.objValue;
    }

    public static void a(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, null, i2, jSONObject) == null) || jSONObject == null || jSONObject == b() || f69388f) {
            return;
        }
        synchronized (f69383a) {
            a aVar = f69389g;
            if (aVar != null && aVar.f69390h == jSONObject) {
                aVar.k = i2;
            } else {
                aVar = null;
                Iterator<a> it = f69383a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f69390h == jSONObject) {
                        next.k = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.k = i2;
                }
                f69389g = aVar;
            }
            f69383a.put(Integer.valueOf(i2), aVar);
        }
    }
}
