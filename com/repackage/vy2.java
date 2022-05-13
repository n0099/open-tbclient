package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.utils.ViewUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.publisher.view.SPSwitchRootLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes7.dex */
public class vy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ po2 d;
        public final /* synthetic */ Context e;

        public a(int i, boolean z, Activity activity, po2 po2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), activity, po2Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = z;
            this.c = activity;
            this.d = po2Var;
            this.e = context;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("swanAppId", u03.f0());
                bundle.putInt("count", this.a);
                bundle.putBoolean("compressed", this.b);
                bundle.putString("launchType", "Image");
                bundle.putString("swanTmpPath", hm2.U().G().k());
                ko2.l(this.c, bundle, this.d);
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (vy2.a) {
                    Log.i(ViewUtil.TAG, str + "");
                }
                Toast.makeText(this.e, str, 1).show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755214910, "Lcom/repackage/vy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755214910, "Lcom/repackage/vy2;");
                return;
            }
        }
        a = eh1.a;
    }

    public static View b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            View view3 = null;
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof SPSwitchRootLinearLayout) {
                        view3 = childAt;
                    }
                    if (view3 != null) {
                        break;
                    }
                    view3 = b(childAt);
                }
            }
            return view3;
        }
        return (View) invokeL.objValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            View b = b(activity.getWindow().getDecorView());
            if (b == null) {
                if (a) {
                    Log.d(ViewUtil.TAG, "#isFitsSystemWindows#, getSPSRootLayout is NULL");
                    return false;
                }
                return false;
            }
            return b.getFitsSystemWindows();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) ? (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 : invokeL.booleanValue;
    }

    public static boolean g(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view2, i)) == null) {
            if (view2.getHeight() == i) {
                return false;
            }
            if (a) {
                Log.d(ViewUtil.TAG, "refreshHeight, originalHeight: " + view2.getHeight() + ", aimHeight: " + i);
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
            } else {
                layoutParams.height = i;
                view2.requestLayout();
            }
            if (a) {
                Log.d(ViewUtil.TAG, "refreshHeight, newHeight: " + view2.getHeight());
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void h(@NonNull Context context, @StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, context, i) == null) {
            m03.f(context, i).G();
        }
    }

    public static void i(int i, po2 po2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i, po2Var) == null) {
            j(i, false, po2Var);
        }
    }

    public static void j(int i, boolean z, po2 po2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), po2Var}) == null) {
            Context appContext = AppRuntime.getAppContext();
            u03 a0 = u03.a0();
            if (a0 == null) {
                return;
            }
            SwanAppActivity x = a0.x();
            wv2.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, x, new a(i, z, x, po2Var, appContext));
        }
    }
}
