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
import com.repackage.u43;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ur3 extends mr3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements u43.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2 a;

        public a(ur3 ur3Var, lc2 lc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur3Var, lc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lc2Var;
        }

        @Override // com.repackage.u43.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == -1) {
                    ur3.c(this.a, "202");
                } else if (i != 1) {
                    this.a.onFail(101, "noPermission");
                } else {
                    ur3.c(this.a, BasicPushStatus.SUCCESS_CODE);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755251397, "Lcom/repackage/ur3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755251397, "Lcom/repackage/ur3;");
                return;
            }
        }
        c = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur3() {
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

    public static void c(lc2 lc2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, lc2Var, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
            } catch (JSONException e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            lc2Var.a(jSONObject);
        }
    }

    @Override // com.repackage.mr3
    public hr1 a(JSONObject jSONObject, lc2 lc2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lc2Var)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 != null && a0.x() != null && a0.V() != null) {
                if (u43.s(a0.x(), a0.V().K(), a0.V().H()) == 1) {
                    c(lc2Var, Info.kBaiduPIDValue);
                    return null;
                }
                u43.j(a0.x(), a0.V(), 1, new a(this, lc2Var));
                return null;
            }
            lc2Var.onFail(100, "swan or activity is null");
            if (c) {
                Log.d("AddShortcutToDesktop", "swan or activity is null");
                return null;
            }
            return null;
        }
        return (hr1) invokeLL.objValue;
    }
}
