package d.a.q0.a.w1.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f51547a;

    /* renamed from: b  reason: collision with root package name */
    public static int f51548b;

    /* renamed from: c  reason: collision with root package name */
    public static int f51549c;

    /* renamed from: d  reason: collision with root package name */
    public static int f51550d;

    /* renamed from: e  reason: collision with root package name */
    public static int f51551e;

    /* renamed from: f  reason: collision with root package name */
    public static int f51552f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f51553g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f51554e;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51554e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.m(this.f51554e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onSoftInputShowing(boolean z);
    }

    /* loaded from: classes8.dex */
    public static class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d.a.q0.a.w1.k.b f51555e;

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f51556f;

        /* renamed from: g  reason: collision with root package name */
        public final b f51557g;

        /* renamed from: h  reason: collision with root package name */
        public int f51558h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f51559i;
        public final Activity j;
        public int k;

        public c(Activity activity, ViewGroup viewGroup, d.a.q0.a.w1.k.b bVar, b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, viewGroup, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51558h = 0;
            this.j = activity;
            this.f51557g = bVar2;
            this.f51556f = viewGroup;
            this.f51555e = bVar;
        }

        public final void a(int i2) {
            int abs;
            int j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f51558h == 0) {
                    this.f51558h = i2;
                    this.f51555e.refreshHeight(e.j(c()));
                }
                if (d.a.q0.a.w1.j.b.e(this.f51556f.getContext())) {
                    abs = ((View) this.f51556f.getParent()).getHeight() - i2;
                } else {
                    abs = Math.abs(i2 - this.f51558h);
                }
                if (abs > e.g(c())) {
                    if (!e.l(c(), abs) || this.f51555e.getHeight() == (j = e.j(c()))) {
                        return;
                    }
                    this.f51555e.refreshHeight(j);
                } else if (Math.abs(abs) == e.i(this.f51556f.getContext())) {
                    this.f51558h -= abs;
                }
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                View view = (View) this.f51556f.getParent();
                int height = view.getHeight() - view.getPaddingTop();
                boolean z = true;
                if (!d.a.q0.a.w1.j.b.e(this.f51556f.getContext())) {
                    int i3 = this.k;
                    if (i3 == 0) {
                        z = this.f51559i;
                    } else if (i2 >= i3 - e.g(c())) {
                        z = false;
                    }
                    this.k = Math.max(this.k, height);
                } else if (height <= i2) {
                    z = false;
                }
                if (this.f51559i != z) {
                    this.f51555e.onSoftInputShowing(z);
                    b bVar = this.f51557g;
                    if (bVar != null) {
                        bVar.onSoftInputShowing(z);
                    }
                }
                this.f51559i = z;
            }
        }

        public final Context c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51556f.getContext() : (Context) invokeV.objValue;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                View childAt = this.f51556f.getChildAt(0);
                Rect rect = new Rect();
                if (childAt == null) {
                    i2 = -1;
                } else if (!d.a.q0.a.w1.j.b.e(this.f51556f.getContext()) && (!g.e(this.j) || !g.c(this.j))) {
                    i2 = childAt.getHeight();
                } else {
                    childAt.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                }
                if (i2 == -1) {
                    return;
                }
                a(i2);
                b(i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1161789175, "Ld/a/q0/a/w1/j/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1161789175, "Ld/a/q0/a/w1/j/e;");
        }
    }

    public static ViewTreeObserver.OnGlobalLayoutListener c(Activity activity, ViewGroup viewGroup, d.a.q0.a.w1.k.b bVar, b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, activity, viewGroup, bVar, bVar2)) == null) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) activity.findViewById(16908290);
            }
            c cVar = new c(activity, viewGroup, bVar, bVar2);
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
            return cVar;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeLLLL.objValue;
    }

    public static int d(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, resources)) == null) {
            if (f51550d == 0) {
                f51550d = resources.getDimensionPixelSize(d.a.q0.a.d.aiapps_max_panel_height);
            }
            return f51550d;
        }
        return invokeL.intValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f51548b == 0) {
                f51548b = context.getResources().getDimensionPixelSize(d.a.q0.a.d.aiapps_max_softinput_height);
            }
            return f51548b;
        }
        return invokeL.intValue;
    }

    public static int f(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, resources)) == null) {
            if (f51549c == 0) {
                f51549c = resources.getDimensionPixelSize(d.a.q0.a.d.aiapps_min_panel_height);
            }
            return f51549c;
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (f51547a == 0) {
                f51547a = context.getResources().getDimensionPixelSize(d.a.q0.a.d.aiapps_min_softinput_height);
            }
            return f51547a;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (f51551e == 0) {
                f51551e = d.a.q0.a.w1.h.e.a(context, f(context.getResources()));
            }
            return f51551e;
        }
        return invokeL.intValue;
    }

    public static synchronized int i(Context context) {
        InterceptResult invokeL;
        int i2;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (e.class) {
                if (!f51553g && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                    f51552f = context.getResources().getDimensionPixelSize(identifier);
                    f51553g = true;
                }
                i2 = f51552f;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? Math.min(d(context.getResources()), Math.max(f(context.getResources()), h(context))) : invokeL.intValue;
    }

    public static void k(@NonNull View view) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, view) == null) || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean l(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, context, i2)) == null) {
            if (f51551e != i2 && i2 >= 0) {
                f51551e = i2;
                return d.a.q0.a.w1.h.e.b(context, i2);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void m(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, view) == null) {
            view.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view, 0);
            }
        }
    }

    public static void n(View view, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65550, null, view, j) == null) {
            view.postDelayed(new a(view), j);
        }
    }
}
