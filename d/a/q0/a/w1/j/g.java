package d.a.q0.a.w1.j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51560a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements d.a.q0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f51561a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f51562b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f51563c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.i1.d.d.c f51564d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f51565e;

        public a(int i2, boolean z, Activity activity, d.a.q0.a.i1.d.d.c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), activity, cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51561a = i2;
            this.f51562b = z;
            this.f51563c = activity;
            this.f51564d = cVar;
            this.f51565e = context;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Bundle bundle = new Bundle();
                bundle.putString("swanAppId", d.a.q0.a.a2.e.V());
                bundle.putInt("count", this.f51561a);
                bundle.putBoolean("compressed", this.f51562b);
                bundle.putString("launchType", "Image");
                bundle.putString("swanTmpPath", d.a.q0.a.g1.f.V().I().k());
                d.a.q0.a.i1.d.c.d.l(this.f51563c, bundle, this.f51564d);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (g.f51560a) {
                    Log.i(ViewUtil.TAG, str + "");
                }
                Toast.makeText(this.f51565e, str, 1).show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161789237, "Ld/a/q0/a/w1/j/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1161789237, "Ld/a/q0/a/w1/j/g;");
                return;
            }
        }
        f51560a = k.f49133a;
    }

    public static View b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            View view2 = null;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof SPSwitchRootLinearLayout) {
                        view2 = childAt;
                    }
                    if (view2 != null) {
                        break;
                    }
                    view2 = b(childAt);
                }
            }
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            View b2 = b(activity.getWindow().getDecorView());
            if (b2 == null) {
                if (f51560a) {
                    Log.d(ViewUtil.TAG, "#isFitsSystemWindows#, getSPSRootLayout is NULL");
                    return false;
                }
                return false;
            }
            return b2.getFitsSystemWindows();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity)) == null) ? (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 : invokeL.booleanValue;
    }

    public static boolean g(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view, i2)) == null) {
            if (view.getHeight() == i2) {
                return false;
            }
            if (f51560a) {
                Log.d(ViewUtil.TAG, "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i2);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
            } else {
                layoutParams.height = i2;
                view.requestLayout();
            }
            if (f51560a) {
                Log.d(ViewUtil.TAG, "refreshHeight, newHeight: " + view.getHeight());
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void h(@NonNull Context context, @StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, context, i2) == null) {
            d.a.q0.a.z1.b.f.e.f(context, i2).F();
        }
    }

    public static void i(int i2, d.a.q0.a.i1.d.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i2, cVar) == null) {
            j(i2, false, cVar);
        }
    }

    public static void j(int i2, boolean z, d.a.q0.a.i1.d.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), cVar}) == null) {
            Context appContext = AppRuntime.getAppContext();
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null) {
                return;
            }
            SwanAppActivity x = Q.x();
            d.a.q0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, x, new a(i2, z, x, cVar, appContext));
        }
    }
}
