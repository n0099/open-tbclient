package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class om5 extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om5 a;

        public a(om5 om5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om5Var;
        }

        @Override // com.repackage.nm5
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.a.mResult.putInt("status_code", bundle.getInt("result_code"));
                this.a.mResult.putString("params", bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
                this.a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755434886, "Lcom/repackage/om5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755434886, "Lcom/repackage/om5;");
                return;
            }
        }
        a = eh1.a;
    }

    public om5() {
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

    public static Bundle c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("order_info", str);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mParams.isEmpty()) {
                if (a) {
                    Log.d("BaiFuBaoPayDelegation", "onExec params is null.");
                }
                return false;
            }
            if (a) {
                Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
            }
            Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
            if (!v85.c().d()) {
                mi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0e94);
                return false;
            } else if (getAgent() instanceof Activity) {
                km5 km5Var = new km5();
                km5Var.mParams.putInt("type", 1);
                km5Var.mParams.putString("orderInfo", this.mParams.getString("order_info"));
                km5Var.c(getAgent());
                km5Var.d(new a(this));
                km5Var.onExec();
                return false;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
