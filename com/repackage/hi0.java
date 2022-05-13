package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci0 a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ boolean c;

        public a(ci0 ci0Var, Map map, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci0Var, map, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci0Var;
            this.b = map;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hi0.t(this.a, this.b, this.c);
            }
        }
    }

    public static Map<String, String> b(ci0 ci0Var, @Nullable yh0 yh0Var, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{ci0Var, yh0Var, Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? c(ci0Var, yh0Var, null, i, z) : (Map) invokeCommon.objValue;
    }

    public static Map<String, String> c(ci0 ci0Var, @Nullable yh0 yh0Var, @Nullable String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{ci0Var, yh0Var, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Map<String, String> v = v(str, i);
            if (yh0Var != null) {
                String str2 = (String) vy0.b(yh0Var.d(), WebChromeClient.KEY_ARG_CALLBACK);
                if (!TextUtils.isEmpty(str2)) {
                    vy0.e(v, WebChromeClient.KEY_ARG_CALLBACK, str2);
                }
            }
            s(ci0Var, v, i, z);
            return v;
        }
        return (Map) invokeCommon.objValue;
    }

    public static Map<String, String> d(ci0 ci0Var, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{ci0Var, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? e(ci0Var, str, null, i, z) : (Map) invokeCommon.objValue;
    }

    public static Map<String, String> e(ci0 ci0Var, String str, @Nullable String str2, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ci0Var, str, str2, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return c(ci0Var, !TextUtils.isEmpty(str) ? new yh0(str) : null, str2, i, z);
        }
        return (Map) invokeCommon.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? TextUtils.equals("vendor/ad", str) : invokeL.booleanValue;
    }

    @Nullable
    public static String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            return str + "('" + str2 + "');";
        }
        return (String) invokeLL.objValue;
    }

    public static String i(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (ty0.g(pathSegments)) {
                return null;
            }
            return (String) ty0.d(pathSegments, ty0.k(pathSegments) - 1);
        }
        return (String) invokeL.objValue;
    }

    public static String j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if (i != 0) {
                if (i != 101) {
                    if (i != 201) {
                        if (i != 202) {
                            if (i != 301) {
                                if (i != 302) {
                                    switch (i) {
                                        case 401:
                                            return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd2);
                                        case 402:
                                            return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bcf);
                                        case 403:
                                            return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd0);
                                        default:
                                            return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd7);
                                    }
                                }
                                return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd1);
                            }
                            return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd3);
                        }
                        return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd6);
                    }
                    return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd7);
                }
                return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd4);
            }
            return ki0.b().getString(R.string.obfuscated_res_0x7f0f0bd5);
        }
        return (String) invokeI.objValue;
    }

    public static String k(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(host)) {
                sb.append(host);
            }
            List<String> pathSegments = uri.getPathSegments();
            if (!ty0.g(pathSegments)) {
                for (int i = 0; i < ty0.k(pathSegments) - 1; i++) {
                    sb.append("/");
                    sb.append((String) ty0.d(pathSegments, i));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static HashMap<String, String> l(@Nullable Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uri)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (uri != null) {
                try {
                    Set<String> queryParameterNames = uri.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String str : queryParameterNames) {
                            hashMap.put(str, uri.getQueryParameter(str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String m(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            return uri.getScheme();
        }
        return (String) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return TextUtils.equals("dlink", i(Uri.parse(str)));
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (Uri.parse(str) == null) {
                r(str);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static String p(@Nullable Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, map)) == null) {
            if (map == null || vy0.b(map, WebChromeClient.KEY_ARG_CALLBACK) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            uy0.f(jSONObject, "status", vy0.b(map, "status"));
            uy0.f(jSONObject, "message", vy0.b(map, "message"));
            uy0.f(jSONObject, "data", vy0.b(map, "data"));
            return h((String) vy0.b(map, WebChromeClient.KEY_ARG_CALLBACK), uy0.a(jSONObject.toString()));
        }
        return (String) invokeL.objValue;
    }

    public static void q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            ClogBuilder k = new ClogBuilder().w(ClogBuilder.LogType.EXCEPTION).i("1").j(DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_IS_LIVE).k(str);
            if (!TextUtils.isEmpty(str2)) {
                k.n(str2);
            }
            ez0.c(k);
        }
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            ez0.c(new ClogBuilder().w(ClogBuilder.LogType.EXCEPTION).i("1").j("1002").k(str));
        }
    }

    public static void s(ci0 ci0Var, Map<String, String> map, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{ci0Var, map, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (vi0.a()) {
                t(ci0Var, map, z);
            } else {
                vi0.b(new a(ci0Var, map, z));
            }
        }
    }

    public static void t(ci0 ci0Var, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65555, null, ci0Var, map, z) == null) || ci0Var == null) {
            return;
        }
        ci0Var.a(z, map);
    }

    public static Map<String, String> u(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65556, null, i, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", String.valueOf(i));
            hashMap.put("message", str);
            return hashMap;
        }
        return (Map) invokeIL.objValue;
    }

    public static Map<String, String> v(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, str, i)) == null) ? w(str, i, j(i)) : (Map) invokeLI.objValue;
    }

    public static Map<String, String> w(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65558, null, str, i, str2)) == null) {
            Map<String, String> u = u(i, str2);
            if (str != null) {
                u.put("data", str);
            }
            return u;
        }
        return (Map) invokeLIL.objValue;
    }
}
