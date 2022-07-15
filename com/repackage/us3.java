package com.repackage;

import android.util.Log;
import com.baidu.appsearchlib.Info;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.repackage.u53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class us3 extends ms3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements u53.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ld2 a;

        public a(us3 us3Var, ld2 ld2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us3Var, ld2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ld2Var;
        }

        @Override // com.repackage.u53.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == -1) {
                    us3.c(this.a, "202");
                } else if (i != 1) {
                    this.a.onFail(101, "noPermission");
                } else {
                    us3.c(this.a, BasicPushStatus.SUCCESS_CODE);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755250436, "Lcom/repackage/us3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755250436, "Lcom/repackage/us3;");
                return;
            }
        }
        c = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public us3() {
        super("addShortcutToDesktop");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void c(ld2 ld2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ld2Var, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
            } catch (JSONException e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            ld2Var.a(jSONObject);
        }
    }

    @Override // com.repackage.ms3
    public hs1 a(JSONObject jSONObject, ld2 ld2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, ld2Var)) == null) {
            h03 b0 = h03.b0();
            if (b0 != null && b0.w() != null && b0.W() != null) {
                if (u53.s(b0.w(), b0.W().K(), b0.W().H()) == 1) {
                    c(ld2Var, Info.kBaiduPIDValue);
                    return null;
                }
                u53.j(b0.w(), b0.W(), 1, new a(this, ld2Var));
                return null;
            }
            ld2Var.onFail(100, "swan or activity is null");
            if (c) {
                Log.d("AddShortcutToDesktop", "swan or activity is null");
                return null;
            }
            return null;
        }
        return (hs1) invokeLL.objValue;
    }
}
