package d.a.o0.a.h0.i;

import android.os.Looper;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f45303a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45305f;

        public a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45304e = i2;
            this.f45305f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.c(this.f45304e, this.f45305f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(447311468, "Ld/a/o0/a/h0/i/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(447311468, "Ld/a/o0/a/h0/i/e;");
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f45303a < 2 : invokeV.booleanValue;
    }

    public static void c(@StringRes int i2, int i3) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65539, null, i2, i3) == null) || (activity = d.a.o0.a.g1.f.V().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        if (i3 != 1) {
            d.a.o0.a.z1.b.f.e.f(activity, i2).F();
        } else {
            d.a.o0.a.z1.b.f.e.f(activity, i2).H();
        }
    }

    public static void d(@StringRes int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                c(i2, i3);
            } else {
                q0.X(new a(i2, i3));
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            f45303a = 0;
        }
    }

    public static void f(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2) == null) {
            if (d.a.o0.a.r1.l.b.d() != 2 || d.a.o0.a.w2.e.D == null) {
                g(i2, 0);
            }
        }
    }

    public static synchronized void g(@StringRes int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i2, i3) == null) {
            synchronized (e.class) {
                int i4 = f45303a;
                if (i4 == 0) {
                    f45303a = 1;
                    System.currentTimeMillis();
                    d(i2, i3);
                } else if (i4 == 1) {
                    f45303a = 2;
                    d(i2, i3);
                    i.i("toast提示个数已达2个");
                }
            }
        }
    }
}
