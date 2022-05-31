package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bs4 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicLong i;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final Map<String, Object> c;
    public final Map<String, Object> d;
    public final int e;
    public final String f;
    public final long g;
    public final long h;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b extends bs4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zr4 j;

        public /* synthetic */ b(int i, String str, String str2, Map map, Map map2, String str3, zr4 zr4Var, long j, a aVar) {
            this(i, str, str2, map, map2, str3, zr4Var, j);
        }

        @Override // com.repackage.bs4
        public void g(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, th) == null) {
                this.j.b(i, th);
            }
        }

        @Override // com.repackage.bs4
        public void h(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.j.a(this, jSONObject);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, zr4 zr4Var, long j) {
            super(i, str, str2, map, map2, str3, j, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, map, map2, str3, zr4Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2], (Map) objArr2[3], (Map) objArr2[4], (String) objArr2[5], ((Long) objArr2[6]).longValue(), (a) objArr2[7]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = zr4Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755816434, "Lcom/repackage/bs4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755816434, "Lcom/repackage/bs4;");
                return;
            }
        }
        i = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    }

    public /* synthetic */ bs4(int i2, String str, String str2, Map map, Map map2, String str3, long j, a aVar) {
        this(i2, str, str2, map, map2, str3, j);
    }

    public static bs4 a(int i2, String str, String str2, Map<String, Object> map, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, str2, map, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return new bs4(i2, str, str2, map, null, z ? d() : null, j);
        }
        return (bs4) invokeCommon.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            long andIncrement = i.getAndIncrement();
            return "TBCWebViewJsBridge_callback_ID_" + andIncrement;
        }
        return (String) invokeV.objValue;
    }

    public static bs4 i(Map<String, Object> map, long j, zr4 zr4Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{map, Long.valueOf(j), zr4Var})) == null) ? new b(1, null, null, map, null, d(), zr4Var, j, null) : (bs4) invokeCommon.objValue;
    }

    public static bs4 j(String str, String str2, Map<String, Object> map, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, map, Long.valueOf(j), Boolean.valueOf(z)})) == null) ? a(2, str, str2, map, j, z) : (bs4) invokeCommon.objValue;
    }

    public static bs4 k(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, map)) == null) ? new bs4(3, null, null, null, map, str, -1L) : (bs4) invokeLL.objValue;
    }

    public String b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("cmd", this.a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject.put("method", this.b);
            }
            Map<String, Object> map = this.c;
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject();
                e(this.c, jSONObject2);
                jSONObject.put("inputData", jSONObject2);
            }
            Map<String, Object> map2 = this.d;
            if (map2 != null && !map2.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                e(this.d, jSONObject3);
                jSONObject.put("outputData", jSONObject3);
            }
            jSONObject.put("messageType", f());
            if (!TextUtils.isEmpty(this.f)) {
                jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.f);
            }
            return c(jSONObject.toString());
        }
        return (String) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String replace = str.replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029");
            return "javascript:__tb_js_bridge.send('" + replace + "');";
        }
        return (String) invokeL.objValue;
    }

    public final void e(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, jSONObject) == null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.e;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return "response";
                    }
                    throw new IllegalArgumentException("Unsupported request type");
                }
                return "request";
            }
            return "ping";
        }
        return (String) invokeV.objValue;
    }

    public void g(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, th) == null) {
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
        }
    }

    public bs4(int i2, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, map, map2, str3, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = map2;
        this.e = i2;
        this.f = str3;
        this.g = j;
        this.h = System.currentTimeMillis();
    }
}
