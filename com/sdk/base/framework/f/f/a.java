package com.sdk.base.framework.f.f;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.b;
import com.sdk.base.framework.c.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f75400a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1065862924, "Lcom/sdk/base/framework/f/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1065862924, "Lcom/sdk/base/framework/f/f/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ab A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i2) {
        InterceptResult invokeI;
        JSONObject jSONObject;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65538, null, i2)) != null) {
            return (String) invokeI.objValue;
        }
        if (i2 != 101005) {
            switch (i2) {
                case 302001:
                    jSONObject = d();
                    break;
                case 302002:
                    jSONObject = c();
                    break;
                case 302003:
                    jSONObject = new JSONObject();
                    jSONObject.put("clientTimeOut", f75400a.b());
                    jSONObject.put("type", 2);
                    jSONArray = new JSONArray();
                    jSONArray.put(f75400a.c().a());
                    break;
                default:
                    jSONObject = null;
                    break;
            }
            return jSONObject == null ? jSONObject.toString() : "";
        }
        jSONObject = new JSONObject();
        jSONObject.put("clientTimeOut", f75400a.b());
        jSONObject.put("type", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("url", 2);
        jSONObject2.put("time", 3);
        jSONObject.put("fieldType", jSONObject2);
        jSONArray = new JSONArray();
        for (d dVar : f75400a.c().b()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", dVar.a());
            jSONObject3.put("time", dVar.b());
            jSONArray.put(jSONObject3);
        }
        jSONObject.put("content", jSONArray);
        if (jSONObject == null) {
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f75400a = new b();
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            try {
                List<String> c2 = f75400a.c().c();
                c2.add(str);
                f75400a.c().b(c2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, str, j2) == null) {
            try {
                if (c.b(str).booleanValue() && c.a(f75400a.a()).booleanValue()) {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("sequenceNumber");
                    String queryParameter2 = parse.getQueryParameter("ret_url");
                    if (c.b(queryParameter2).booleanValue()) {
                        queryParameter = Uri.parse(com.sdk.base.framework.f.i.d.a(queryParameter2)).getQueryParameter(IAdRequestParam.SEQ);
                    }
                    f75400a.a(queryParameter);
                }
                List<d> b2 = f75400a.c().b();
                d dVar = new d();
                dVar.a(str);
                dVar.a(j2);
                b2.add(dVar);
                f75400a.c().a(b2);
            } catch (Throwable unused) {
            }
        }
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f75400a == null) {
                a();
            }
            return f75400a;
        }
        return (b) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            try {
                List<String> d2 = f75400a.c().d();
                d2.add(str);
                f75400a.c().c(d2);
            } catch (Throwable unused) {
            }
        }
    }

    public static JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clientTimeOut", f75400a.b());
            jSONObject.put("type", 2);
            JSONArray jSONArray = new JSONArray();
            for (String str : f75400a.c().d()) {
                jSONArray.put(str);
            }
            jSONObject.put("content", jSONArray);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            try {
                f75400a.c().a(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clientTimeOut", f75400a.b());
            jSONObject.put("type", 2);
            JSONArray jSONArray = new JSONArray();
            for (String str : f75400a.c().c()) {
                jSONArray.put(str);
            }
            jSONObject.put("content", jSONArray);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
