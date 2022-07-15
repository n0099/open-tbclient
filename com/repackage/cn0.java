package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cn0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public String a;
    @JvmField
    public String b;
    @JvmField
    public String c;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        public final cn0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("panel");
                    if (optJSONObject == null) {
                        optJSONObject = yx0.c(jSONObject.optString("panel"));
                    }
                    if (optJSONObject != null) {
                        cn0 cn0Var = new cn0();
                        cn0Var.a = optJSONObject.optString("title");
                        cn0Var.b = optJSONObject.optString("brand_name");
                        cn0Var.c = optJSONObject.optString("avatar");
                        optJSONObject.optJSONArray("tag_list");
                        return cn0Var;
                    }
                    return null;
                }
                return null;
            }
            return (cn0) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755791572, "Lcom/repackage/cn0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755791572, "Lcom/repackage/cn0;");
                return;
            }
        }
        d = new a(null);
    }

    public cn0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
