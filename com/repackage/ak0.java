package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ak0 implements kk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Object d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final zj0 b;
    public boolean c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ak0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-526275539, "Lcom/repackage/ak0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-526275539, "Lcom/repackage/ak0$b;");
                    return;
                }
            }
            a = new ak0(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755854037, "Lcom/repackage/ak0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755854037, "Lcom/repackage/ak0;");
                return;
            }
        }
        d = new Object();
    }

    public /* synthetic */ ak0(a aVar) {
        this();
    }

    public static ak0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (ak0) invokeV.objValue;
    }

    @Override // com.repackage.kk0
    public int a(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            f(NodeJS.GLOBAL);
            if (mx0.a(this.b.a(), str) && (str2 = (String) mx0.b(this.b.a(), str)) != null) {
                try {
                    return Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                }
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.d = true;
        }
    }

    public void d(@Nullable String str) throws ADConfigError {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str != null && !TextUtils.isEmpty(str)) {
                JSONObject c = lx0.c(str);
                if (c.has("error_code")) {
                    if (TextUtils.equals(c.optString("error_code"), "0")) {
                        if (c.has("error_message")) {
                            if (TextUtils.equals(c.optString("error_message"), "success")) {
                                String optString = c.optString("data");
                                if (!TextUtils.isEmpty(optString)) {
                                    JSONObject c2 = lx0.c(optString);
                                    String optString2 = c2.optString("sign");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        if (TextUtils.equals(optString2, sx0.a().b("nad_app_quick_config").getString("_ad_adc_conf_sign", ""))) {
                                            return;
                                        }
                                        sx0.a().b("nad_app_quick_config").i("_ad_adc_conf_sign", optString2);
                                        synchronized (d) {
                                            this.b.update(c2);
                                        }
                                        return;
                                    }
                                    throw ADConfigError.error("2", ADConfigError.REASON_NULL_SIGN);
                                }
                                throw ADConfigError.error("7", ADConfigError.REASON_NULL_DATA);
                            }
                            throw ADConfigError.error("5", ADConfigError.REASON_WRONG_MSG);
                        }
                        throw ADConfigError.error("6", ADConfigError.REASON_NULL_MSG);
                    }
                    throw ADConfigError.error("3", ADConfigError.REASON_WRONG_CODE);
                }
                throw ADConfigError.error("4", ADConfigError.REASON_NULL_CODE);
            }
            throw ADConfigError.error("1", ADConfigError.REASON_NULL_RESPONSE_BODY);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.d = false;
        }
    }

    public final void f(String str) {
        Map<String, ?> all;
        Map<String, ?> all2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            sx0 a2 = sx0.a();
            px0 b2 = a2.b("nad.launch.config." + str);
            if (NodeJS.GLOBAL.equals(str)) {
                if (this.c || (all2 = b2.getAll()) == null) {
                    return;
                }
                mx0.f(this.b.a(), all2);
                this.c = true;
            } else if (((Map) mx0.b(this.b.b(), str)) == null && (all = b2.getAll()) != null) {
                mx0.e(this.b.b(), str, all);
            }
        }
    }

    public ak0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new zj0();
        this.c = false;
    }
}
