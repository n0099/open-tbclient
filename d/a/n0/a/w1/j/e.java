package d.a.n0.a.w1.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f48245a;

    /* renamed from: b  reason: collision with root package name */
    public static int f48246b;

    /* renamed from: c  reason: collision with root package name */
    public static int f48247c;

    /* renamed from: d  reason: collision with root package name */
    public static int f48248d;

    /* renamed from: e  reason: collision with root package name */
    public static int f48249e;

    /* renamed from: f  reason: collision with root package name */
    public static int f48250f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f48251g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f48252e;

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
            this.f48252e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.m(this.f48252e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onSoftInputShowing(boolean z);
    }

    /* loaded from: classes7.dex */
    public static class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d.a.n0.a.w1.k.b f48253e;

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f48254f;

        /* renamed from: g  reason: collision with root package name */
        public final b f48255g;

        /* renamed from: h  reason: collision with root package name */
        public int f48256h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f48257i;
        public final Activity j;
        public int k;

        public c(Activity activity, ViewGroup viewGroup, d.a.n0.a.w1.k.b bVar, b bVar2) {
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
            this.f48256h = 0;
            this.j = activity;
            this.f48255g = bVar2;
            this.f48254f = viewGroup;
            this.f48253e = bVar;
        }

        public final void a(int i2) {
            int abs;
            int j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f48256h == 0) {
                    this.f48256h = i2;
                    this.f48253e.refreshHeight(e.j(c()));
                }
                if (d.a.n0.a.w1.j.b.e(this.f48254f.getContext())) {
                    abs = ((View) this.f48254f.getParent()).getHeight() - i2;
                } else {
                    abs = Math.abs(i2 - this.f48256h);
                }
                if (abs > e.g(c())) {
                    if (!e.l(c(), abs) || this.f48253e.getHeight() == (j = e.j(c()))) {
                        return;
                    }
                    this.f48253e.refreshHeight(j);
                } else if (Math.abs(abs) == e.i(this.f48254f.getContext())) {
                    this.f48256h -= abs;
                }
            }
        }

        public final void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                View view = (View) this.f48254f.getParent();
                int height = view.getHeight() - view.getPaddingTop();
                boolean z = true;
                if (!d.a.n0.a.w1.j.b.e(this.f48254f.getContext())) {
                    int i3 = this.k;
                    if (i3 == 0) {
                        z = this.f48257i;
                    } else if (i2 >= i3 - e.g(c())) {
                        z = false;
                    }
                    this.k = Math.max(this.k, height);
                } else if (height <= i2) {
                    z = false;
                }
                if (this.f48257i != z) {
                    this.f48253e.onSoftInputShowing(z);
                    b bVar = this.f48255g;
                    if (bVar != null) {
                        bVar.onSoftInputShowing(z);
                    }
                }
                this.f48257i = z;
            }
        }

        public final Context c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48254f.getContext() : (Context) invokeV.objValue;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                View childAt = this.f48254f.getChildAt(0);
                Rect rect = new Rect();
                if (childAt == null) {
                    i2 = -1;
                } else if (!d.a.n0.a.w1.j.b.e(this.f48254f.getContext()) && (!g.e(this.j) || !g.c(this.j))) {
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(774541018, "Ld/a/n0/a/w1/j/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(774541018, "Ld/a/n0/a/w1/j/e;");
        }
    }

    public static ViewTreeObserver.OnGlobalLayoutListener c(Activity activity, ViewGroup viewGroup, d.a.n0.a.w1.k.b bVar, b bVar2) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources)) == null) {
            if (f48248d == 0) {
                f48248d = resources.getDimensionPixelSize(d.a.n0.a.d.aiapps_max_panel_height);
            }
            return f48248d;
        }
        return invokeL.intValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f48246b == 0) {
                f48246b = context.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_max_softinput_height);
            }
            return f48246b;
        }
        return invokeL.intValue;
    }

    public static int f(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, resources)) == null) {
            if (f48247c == 0) {
                f48247c = resources.getDimensionPixelSize(d.a.n0.a.d.aiapps_min_panel_height);
            }
            return f48247c;
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (f48245a == 0) {
                f48245a = context.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_min_softinput_height);
            }
            return f48245a;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (f48249e == 0) {
                f48249e = d.a.n0.a.w1.h.e.a(context, f(context.getResources()));
            }
            return f48249e;
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
                if (!f48251g && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                    f48250f = context.getResources().getDimensionPixelSize(identifier);
                    f48251g = true;
                }
                i2 = f48250f;
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
            if (f48249e != i2 && i2 >= 0) {
                f48249e = i2;
                return d.a.n0.a.w1.h.e.b(context, i2);
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
