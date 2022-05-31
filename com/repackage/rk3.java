package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.download.center.clearcache.controller.ClearCacheUbcController;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sy2;
@Service
/* loaded from: classes7.dex */
public class rk3 implements al1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ue3 a;

    /* loaded from: classes7.dex */
    public class a implements sy2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;

        public a(rk3 rk3Var, SwanAppActivity swanAppActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk3Var, swanAppActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppActivity;
            this.b = str;
        }

        @Override // com.repackage.sy2.a
        public void a(sy2 sy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sy2Var) == null) {
                gn2.d(sy2Var.c(), this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ec2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ rk3 b;

        public b(rk3 rk3Var, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk3Var, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rk3Var;
            this.a = swanAppActivity;
        }

        @Override // com.repackage.ec2, com.repackage.fc2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.j();
                this.a.unregisterCallback(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755347497, "Lcom/repackage/rk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755347497, "Lcom/repackage/rk3;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public rk3() {
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

    @Override // com.repackage.al1
    public void a(NgWebView ngWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ngWebView) == null) {
            ngWebView.doSelectionCancel();
        }
    }

    @Override // com.repackage.al1
    public void b(NgWebView ngWebView, String str) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ngWebView, str) == null) || (x = gz2.J().x()) == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a = new ue3(ngWebView.covertToView());
        int[] g = g(x);
        int[] h = h(x);
        for (int i = 0; i < g.length; i++) {
            this.a.e(g[i], h[i]);
        }
        this.a.r(new a(this, x, str));
        this.a.t();
        x.registerCallback(new b(this, x));
    }

    @Override // com.repackage.al1
    public void c(NgWebView ngWebView, int i, int i2, int i3, int i4, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ngWebView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Boolean.valueOf(z)}) == null) {
            ngWebView.updateAndShowPopupWindow(i3, i4, i, i2, str, true);
            if (z) {
                i("show", null, null);
            }
        }
    }

    @Override // com.repackage.al1
    public void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, context) == null) {
        }
    }

    @Override // com.repackage.al1
    public void e(String str, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, context) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        cd3.b(context).c(str);
        i("click", "copy", null);
    }

    public int[] g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            int[] iArr = {7, 6, 8};
            if (jc3.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[2];
            System.arraycopy(iArr, 0, iArr2, 0, 2);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public int[] h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            int[] iArr = {R.string.obfuscated_res_0x7f0f124a, R.string.obfuscated_res_0x7f0f124c, R.string.obfuscated_res_0x7f0f1250};
            if (jc3.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[2];
            System.arraycopy(iArr, 0, iArr2, 0, 2);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            j63 j63Var = new j63();
            j63Var.a = ClearCacheUbcController.FROM_VALUE;
            j63Var.f = gz2.J().getAppId();
            j63Var.c = "miniapp";
            j63Var.g = "text";
            j63Var.b = str;
            j63Var.e = str2;
            if (!TextUtils.isEmpty(str3)) {
                j63Var.a("query", str3);
            }
            a63.x("810", j63Var);
        }
    }
}
