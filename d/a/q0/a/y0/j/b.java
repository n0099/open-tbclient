package d.a.q0.a.y0.j;

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
import d.a.q0.a.g1.h;
import d.a.q0.a.g1.i;
import d.a.q0.a.k;
import d.a.q0.a.p.e.d;
import d.a.q0.a.v2.q0;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f51791i;
    public static final ViewGroup.LayoutParams j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f51792a;

    /* renamed from: b  reason: collision with root package name */
    public View f51793b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f51794c;

    /* renamed from: d  reason: collision with root package name */
    public int f51795d;

    /* renamed from: e  reason: collision with root package name */
    public int f51796e;

    /* renamed from: f  reason: collision with root package name */
    public String f51797f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1036b f51798g;

    /* renamed from: h  reason: collision with root package name */
    public c f51799h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51800e;

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
            this.f51800e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51800e.f51793b == null) {
                return;
            }
            this.f51800e.f51793b.requestFocus();
        }
    }

    /* renamed from: d.a.q0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1036b {
        void onCustomViewHidden();
    }

    /* loaded from: classes8.dex */
    public static class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Activity f51801a;

        /* renamed from: b  reason: collision with root package name */
        public String f51802b;

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
            this.f51801a = activity;
            this.f51802b = str;
        }

        @Override // d.a.q0.a.g1.h
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && TextUtils.equals(dVar.b(), this.f51802b)) {
                b.f(this.f51801a, true);
                ((ViewGroup) this.f51801a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // d.a.q0.a.g1.h
        public void b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            }
        }

        @Override // d.a.q0.a.g1.h
        public void c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            }
        }

        @Override // d.a.q0.a.g1.h
        public void d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386800003, "Ld/a/q0/a/y0/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1386800003, "Ld/a/q0/a/y0/j/b;");
                return;
            }
        }
        f51791i = k.f49133a;
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
        this.f51792a = context;
        this.f51797f = str;
    }

    public static void f(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65540, null, activity, z) == null) {
            activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
        }
    }

    @UiThread
    public synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                if (f51791i) {
                    Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
                }
                d.a.q0.a.c0.b.a b2 = d.a.q0.a.c0.d.a.b(this.f51797f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f46778e) || "coverImage".equals(b2.n().f46778e)) {
                    if (this.f51794c == null) {
                        return;
                    }
                    SwanAppComponentContainerView m = b2.m();
                    if (m == null) {
                        return;
                    }
                    ViewParent parent = m.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(m);
                        this.f51794c.addView(m);
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f51793b == null) {
            return;
        }
        if (f51791i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f51792a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f51799h);
            this.f51799h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f51794c);
            this.f51794c = null;
            this.f51793b = null;
            InterfaceC1036b interfaceC1036b = this.f51798g;
            if (interfaceC1036b != null) {
                interfaceC1036b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f51795d);
            viewGroup.setSystemUiVisibility(this.f51796e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (f51791i) {
                    Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
                }
                d.a.q0.a.c0.b.a b2 = d.a.q0.a.c0.d.a.b(this.f51797f, str);
                if (b2 == null) {
                    return;
                }
                if ("coverView".equals(b2.n().f46778e) || "coverImage".equals(b2.n().f46778e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC1036b interfaceC1036b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view, i2, interfaceC1036b) == null) {
            if (f51791i) {
                Log.i("SwanCustomViewHelper", "showCustomView");
            }
            Context context = this.f51792a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f51793b != null) {
                    if (interfaceC1036b != null) {
                        interfaceC1036b.onCustomViewHidden();
                        this.f51798g = interfaceC1036b;
                        return;
                    }
                    return;
                }
                this.f51795d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.f51794c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view, j);
                viewGroup.addView(this.f51794c, j);
                this.f51793b = view;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (d.a.q0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
                }
                this.f51796e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.f51799h == null) {
                    this.f51799h = new c(activity, this.f51797f);
                }
                i.e(this.f51799h);
                q0.X(new a(this));
            }
        }
    }
}
