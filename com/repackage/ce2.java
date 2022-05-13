package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class ce2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public h93 a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final ce2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-474498750, "Lcom/repackage/ce2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-474498750, "Lcom/repackage/ce2$c;");
                    return;
                }
            }
            a = new ce2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755800159, "Lcom/repackage/ce2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755800159, "Lcom/repackage/ce2;");
                return;
            }
        }
        b = eh1.a;
    }

    public /* synthetic */ ce2(a aVar) {
        this();
    }

    public static ce2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a : (ce2) invokeV.objValue;
    }

    public boolean a(@NonNull WeakReference<Activity> weakReference) {
        InterceptResult invokeL;
        u03 L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, weakReference)) == null) {
            if (!oe3.G() || weakReference == null || weakReference.get() == null) {
                return false;
            }
            Activity activity = weakReference.get();
            if (TextUtils.equals("0", g()) || (L = u03.L()) == null || L.T().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue()) {
                return false;
            }
            return i(activity) && !TextUtils.isEmpty(f());
        }
        return invokeL.booleanValue;
    }

    public final int b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            PackageInfo t = oe3.t(context, context.getPackageName());
            if (t != null) {
                return t.versionCode;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final int d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) ? this.a.getInt("up_first_in", b(activity)) : invokeL.intValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getBoolean("new_first_in", true) : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getString("url", "") : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getString("switch", "1") : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u03 L = u03.L();
            if (L == null) {
                return false;
            }
            return L.T().c("boolean_var_key_fav_guide_show", Boolean.FALSE).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean i(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
            boolean e = e();
            if (b) {
                Log.e("SwanAppGuideDialogManager", "is first in " + e);
            }
            if (e) {
                return true;
            }
            int d = d(activity);
            int b2 = b(activity);
            if (b) {
                Log.e("SwanAppGuideDialogManager", "version =" + d + " curVerCode" + b2);
            }
            return b2 > d;
        }
        return invokeL.booleanValue;
    }

    public void j(@NonNull Activity activity, String str, String str2, be2 be2Var, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str, str2, be2Var, bVar) == null) {
            bk2.l0().h(activity, str, str2, be2Var, bVar);
        }
    }

    public ce2() {
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
        h93 h93Var = new h93("aiapps_guide_dialog_sp");
        this.a = h93Var;
        h93Var.edit();
    }
}
