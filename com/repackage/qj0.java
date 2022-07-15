package com.repackage;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.retain.RetainDialogActivity;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class qj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Boolean> a;
    public si0 b;
    public WeakReference<bj0> c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final qj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-69132644, "Lcom/repackage/qj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-69132644, "Lcom/repackage/qj0$b;");
                    return;
                }
            }
            a = new qj0(null);
        }
    }

    public /* synthetic */ qj0(a aVar) {
        this();
    }

    public static qj0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (qj0) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            si0 si0Var = this.b;
            return si0Var == null || si0Var.c == AdDownloadStatus.COMPLETED;
        }
        return invokeV.booleanValue;
    }

    public final boolean b(bj0 bj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bj0Var)) == null) {
            WeakReference<bj0> weakReference = new WeakReference<>(bj0Var);
            this.c = weakReference;
            bj0 bj0Var2 = weakReference.get();
            if (bj0Var2 == null || bj0Var2.getData() == null) {
                return false;
            }
            this.b = bj0Var2.getData();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.put(this.b.d(), Boolean.TRUE);
            Intent intent = new Intent();
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra("ext", this.b.p.a);
            intent.putExtra("alsPage", ClogBuilder.Page.AD_DIALOG);
            intent.putExtra("percent", (int) (this.b.i * 100.0f));
            intent.setClassName(hh0.b().getPackageName(), RetainDialogActivity.class.getName());
            k01.c(hh0.b(), intent);
        }
    }

    public boolean e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if ((obj instanceof bj0) && tk0.b().a().a("key_ad_interrupt_dialog_switch", 1) != 0) {
                boolean b2 = b((bj0) obj);
                int a2 = tk0.b().a().a("key_ad_interrupt_dialog_target_percnet", 50);
                if (b2) {
                    si0 si0Var = this.b;
                    return si0Var.i * 100.0f >= ((float) a2) && this.a.get(si0Var.d()) == null;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        WeakReference<bj0> weakReference;
        bj0 bj0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (weakReference = this.c) == null || (bj0Var = weakReference.get()) == null) {
            return;
        }
        bj0Var.i();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public qj0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }
}
