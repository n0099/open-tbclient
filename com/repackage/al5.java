package com.repackage;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes5.dex */
public class al5 implements ek1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755852921, "Lcom/repackage/al5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755852921, "Lcom/repackage/al5;");
                return;
            }
        }
        b = rf1.a;
    }

    public al5() {
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

    @Override // com.repackage.ek1
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppBackground");
            }
            long m = ys4.k().m("smart_app_tid", 0L);
            String q = ys4.k().q("smart_app_id", "");
            String q2 = ys4.k().q("smart_app_name", "");
            if (this.a == 0 || m == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            i75 i75Var = new i75();
            i75Var.y(currentTimeMillis);
            i75Var.s(g());
            i75Var.C(m);
            i75Var.i = q;
            i75Var.j = q2;
            i75Var.x(h());
            j75.b().j(true);
            j75.b().k(TbadkApplication.getInst().getApplicationContext(), i75Var, i());
            ys4.k().x("smart_app_tid", 0L);
        }
    }

    @Override // com.repackage.ek1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.repackage.ek1
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppForeground" + hz2.L().b);
            }
            File file = new File(am.b("libBaiduMapSDK_map_v5_4_4.so"));
            if (file.exists() && file.isFile() && BdBaseApplication.getInst().getResHashMap().get("libBaiduMapSDK_map_v5_4_4.so") == null && cm.a(BdBaseApplication.getInst().getContext(), am.a("libBaiduMapSDK_map_v5_4_4.so"))) {
                BdBaseApplication.getInst().getResHashMap().put("libBaiduMapSDK_map_v5_4_4.so", am.a("libBaiduMapSDK_map_v5_4_4.so"));
            }
            this.a = System.currentTimeMillis();
        }
    }

    @Override // com.repackage.ek1
    public void d(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable ek2 ek2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i, ek2Var) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppExit");
            }
            if (ys4.k().h("key_ai_app_guide_display", true)) {
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra(DealIntentService.KEY_CLASS, 38);
                swanAppActivity.startService(intent);
            }
        }
    }

    @Override // com.repackage.ek1
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.repackage.ek1
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a061" : (String) invokeV.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("a001");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public g75 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (g75) invokeV.objValue;
    }
}
