package d.a.n0.a.y0.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.g1.h;
import d.a.n0.a.g1.i;
import d.a.n0.a.k;
import d.a.n0.a.p.e.d;
import d.a.n0.a.v2.q0;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f48489i;
    public static final ViewGroup.LayoutParams j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f48490a;

    /* renamed from: b  reason: collision with root package name */
    public View f48491b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f48492c;

    /* renamed from: d  reason: collision with root package name */
    public int f48493d;

    /* renamed from: e  reason: collision with root package name */
    public int f48494e;

    /* renamed from: f  reason: collision with root package name */
    public String f48495f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0985b f48496g;

    /* renamed from: h  reason: collision with root package name */
    public c f48497h;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48498e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48498e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48498e.f48491b == null) {
                return;
            }
            this.f48498e.f48491b.requestFocus();
        }
    }

    /* renamed from: d.a.n0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0985b {
        void onCustomViewHidden();
    }

    /* loaded from: classes7.dex */
    public static class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f48499a;

        /* renamed from: b  reason: collision with root package name */
        public String f48500b;

        public c(Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48499a = activity;
            this.f48500b = str;
        }

        @Override // d.a.n0.a.g1.h
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && TextUtils.equals(dVar.b(), this.f48500b)) {
                b.f(this.f48499a, true);
                ((ViewGroup) this.f48499a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // d.a.n0.a.g1.h
        public void b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            }
        }

        @Override // d.a.n0.a.g1.h
        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            }
        }

        @Override // d.a.n0.a.g1.h
        public void d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1774048160, "Ld/a/n0/a/y0/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1774048160, "Ld/a/n0/a/y0/j/b;");
                return;
            }
        }
        f48489i = k.f45831a;
        j = new FrameLayout.LayoutParams(-1, -1);
    }

    public b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48490a = context;
        this.f48495f = str;
    }

    public static void f(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, z) == null) {
            activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
        }
    }

    @UiThread
    public synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                if (f48489i) {
                    Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
                }
                d.a.n0.a.c0.b.a b2 = d.a.n0.a.c0.d.a.b(this.f48495f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f43476e) || "coverImage".equals(b2.n().f43476e)) {
                    if (this.f48492c == null) {
                        return;
                    }
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        this.f48492c.addView(m);
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f48491b == null) {
            return;
        }
        if (f48489i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f48490a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f48497h);
            this.f48497h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f48492c);
            this.f48492c = null;
            this.f48491b = null;
            InterfaceC0985b interfaceC0985b = this.f48496g;
            if (interfaceC0985b != null) {
                interfaceC0985b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f48493d);
            viewGroup.setSystemUiVisibility(this.f48494e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (f48489i) {
                    Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
                }
                d.a.n0.a.c0.b.a b2 = d.a.n0.a.c0.d.a.b(this.f48495f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f43476e) || "coverImage".equals(b2.n().f43476e)) {
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        b2.w();
                    }
                }
            }
        }
    }

    public void g(View view, int i2, @Nullable InterfaceC0985b interfaceC0985b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view, i2, interfaceC0985b) == null) {
            if (f48489i) {
                Log.i("SwanCustomViewHelper", "showCustomView");
            }
            Context context = this.f48490a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f48491b != null) {
                    if (interfaceC0985b != null) {
                        interfaceC0985b.onCustomViewHidden();
                        this.f48496g = interfaceC0985b;
                        return;
                    }
                    return;
                }
                this.f48493d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.f48492c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view, j);
                viewGroup.addView(this.f48492c, j);
                this.f48491b = view;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (d.a.n0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
                }
                this.f48494e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.f48497h == null) {
                    this.f48497h = new c(activity, this.f48495f);
                }
                i.e(this.f48497h);
                q0.X(new a(this));
            }
        }
    }
}
