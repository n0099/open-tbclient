package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.de4;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ce4 extends we4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String[] a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;

        public a(String[] strArr, Activity activity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, activity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = strArr;
            this.b = activity;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[this.a.length];
                PackageManager packageManager = this.b.getPackageManager();
                String packageName = this.b.getPackageName();
                int length = this.a.length;
                for (int i = 0; i < length; i++) {
                    iArr[i] = packageManager.checkPermission(this.a[i], packageName);
                }
                ((b) this.b).onRequestPermissionsResult(this.c, this.a, iArr);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes5.dex */
    public static class c extends de4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ve4 a;

        public c(ve4 ve4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve4Var;
        }

        @Override // com.repackage.de4.a
        public Parcelable a(View view2, Matrix matrix, RectF rectF) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, view2, matrix, rectF)) == null) ? this.a.a(view2, matrix, rectF) : (Parcelable) invokeLLL.objValue;
        }

        @Override // com.repackage.de4.a
        public View b(Context context, Parcelable parcelable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, parcelable)) == null) ? this.a.b(context, parcelable) : (View) invokeLL.objValue;
        }

        @Override // com.repackage.de4.a
        public void c(List<String> list, Map<String, View> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, map) == null) {
                this.a.c(list, map);
            }
        }

        @Override // com.repackage.de4.a
        public void d(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                this.a.d(list);
            }
        }

        @Override // com.repackage.de4.a
        public void e(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, list, list2, list3) == null) {
                this.a.e(list, list2, list3);
            }
        }

        @Override // com.repackage.de4.a
        public void f(List<String> list, List<View> list2, List<View> list3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, list, list2, list3) == null) {
                this.a.f(list, list2, list3);
            }
        }
    }

    public static de4.a e(ve4 ve4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ve4Var)) == null) {
            if (ve4Var != null) {
                return new c(ve4Var);
            }
            return null;
        }
        return (de4.a) invokeL.objValue;
    }

    public static void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                de4.b(activity);
            } else {
                activity.finish();
            }
        }
    }

    public static void g(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, activity) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        de4.c(activity);
    }

    public static void h(Activity activity, ve4 ve4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, activity, ve4Var) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        de4.d(activity, e(ve4Var));
    }

    public static void i(Activity activity, ve4 ve4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, ve4Var) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        de4.e(activity, e(ve4Var));
    }

    public static boolean j(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, activity, str)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ee4.a(activity, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void k(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, activity) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        de4.f(activity);
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, activity, strArr, i) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                ee4.requestPermissions(activity, strArr, i);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i));
            }
        }
    }

    public static void startActivity(Activity activity, Intent intent, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, activity, intent, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                ge4.startActivity(activity, intent, bundle);
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65545, null, activity, intent, i, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                ge4.startActivityForResult(activity, intent, i, bundle);
            } else {
                activity.startActivityForResult(intent, i);
            }
        }
    }
}
