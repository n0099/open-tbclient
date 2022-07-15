package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (view2.getParent() != null) {
                    view2.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollView a;
        public final /* synthetic */ pw1 b;

        public b(ScrollView scrollView, pw1 pw1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollView, pw1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollView;
            this.b = pw1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.smoothScrollTo(0, this.b.D);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755216863, "Lcom/repackage/vw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755216863, "Lcom/repackage/vw1;");
                return;
            }
        }
        a = rg1.a;
    }

    public static FrameLayout.LayoutParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public static boolean b(@NonNull ww1 ww1Var, @NonNull xv1 xv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, ww1Var, xv1Var, swanAppComponentContainerView)) == null) {
            hx1.c("Component-Container-Scroll", "insert component（scroll）");
            if (xv1Var.h == null) {
                ax1.a("Component-Container-Scroll", "insert component（scroll） with a null position");
                return false;
            } else if (TextUtils.isEmpty(xv1Var.d)) {
                ScrollView h = h(swanAppComponentContainerView, xv1Var);
                return h != null && ww1Var.a.c(h, xv1Var.h);
            } else {
                SwanAppComponentContainerView a2 = ww1Var.a(xv1Var.d);
                if (a2 == null) {
                    hx1.c("Component-Container-Scroll", "insert component（scroll） to parent with a null parent container view");
                    return false;
                }
                ScrollView h2 = h(swanAppComponentContainerView, xv1Var);
                if (h2 == null) {
                    hx1.c("Component-Container-Scroll", "insert component（scroll） to parent with a null scroll view");
                    return false;
                }
                a2.addView(h2, xv1Var.b());
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(@NonNull xv1 xv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xv1Var)) == null) ? (xv1Var instanceof pw1) && TextUtils.equals(((pw1) xv1Var).E, "scroll") : invokeL.booleanValue;
    }

    public static boolean d(@NonNull ww1 ww1Var, @NonNull wv1 wv1Var, @NonNull xv1 xv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull zw1 zw1Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ww1Var, wv1Var, xv1Var, swanAppComponentContainerView, zw1Var)) == null) {
            if (xv1Var instanceof pw1) {
                ScrollView scrollView = swanAppComponentContainerView.getScrollView();
                if (zw1Var.a(7)) {
                    if (a) {
                        Log.d("Component-Container-Scroll", "update component（scroll）overflow_y");
                    }
                    if (scrollView != null) {
                        if (scrollView.getParent() == null) {
                            return false;
                        }
                        ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                        ((ViewGroup) scrollView.getParent()).removeView(scrollView);
                        swanAppComponentContainerView.setScrollView(null);
                    } else {
                        ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                    }
                    if (ww1Var.b(wv1Var)) {
                        return true;
                    }
                    ax1.a("Component-Container-Scroll", "update component（scroll） overflow_y fail");
                }
                return false;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean e(@NonNull ww1 ww1Var, @NonNull xv1 xv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, ww1Var, xv1Var, swanAppComponentContainerView)) == null) {
            if (a) {
                Log.d("Component-Container-Scroll", "update component（scroll）position");
            }
            String str = xv1Var.d;
            if (TextUtils.isEmpty(str)) {
                ScrollView scrollView = swanAppComponentContainerView.getScrollView();
                ScrollView scrollView2 = swanAppComponentContainerView;
                if (scrollView != null) {
                    scrollView2 = swanAppComponentContainerView.getScrollView();
                }
                return ww1Var.a.a(scrollView2, xv1Var.h);
            }
            SwanAppComponentContainerView a2 = ww1Var.a(str);
            if (a2 == null) {
                hx1.c("Component-Container-Scroll", "update component（scroll）to parent with a null parent container view");
                return false;
            }
            ScrollView scrollView3 = swanAppComponentContainerView.getScrollView();
            if (scrollView3 != null && scrollView3.getParent() == a2) {
                a2.updateViewLayout(scrollView3, xv1Var.b());
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("update component（scroll）to parent with a illegal parent view (Scroll) ");
            sb.append(scrollView3 == null);
            ax1.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void f(@NonNull ww1 ww1Var, @NonNull wv1 wv1Var, @NonNull xv1 xv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull zw1 zw1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65542, null, ww1Var, wv1Var, xv1Var, swanAppComponentContainerView, zw1Var) == null) && (xv1Var instanceof pw1)) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (zw1Var.a(8)) {
                if (a) {
                    Log.d("Component-Container-Scroll", "update component（scroll） scroll_top");
                }
                if (scrollView != null) {
                    scrollView.smoothScrollTo(0, ((pw1) xv1Var).D);
                }
            }
        }
    }

    public static boolean g(@NonNull ww1 ww1Var, @NonNull xv1 xv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, ww1Var, xv1Var, swanAppComponentContainerView)) == null) {
            if (TextUtils.isEmpty(xv1Var.d)) {
                return ww1Var.a.removeView(swanAppComponentContainerView.getScrollView());
            }
            SwanAppComponentContainerView a2 = ww1Var.a(xv1Var.d);
            if (a2 == null) {
                hx1.c("Component-Container-Scroll", "remove component（scroll） to parent with a null parent container view");
                return false;
            }
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (scrollView != null && scrollView.getParent() == a2) {
                a2.removeView(scrollView);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("remove component（scroll）to parent with a illegal parent view");
            sb.append(scrollView == null);
            ax1.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Nullable
    public static ScrollView h(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull xv1 xv1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, swanAppComponentContainerView, xv1Var)) == null) {
            if (xv1Var instanceof pw1) {
                ScrollView scrollView = new ScrollView(swanAppComponentContainerView.getContext());
                scrollView.setFillViewport(true);
                scrollView.setOnTouchListener(new a());
                FrameLayout frameLayout = new FrameLayout(swanAppComponentContainerView.getContext());
                frameLayout.addView(swanAppComponentContainerView, a());
                scrollView.addView(frameLayout);
                swanAppComponentContainerView.postDelayed(new b(scrollView, (pw1) xv1Var), 100L);
                swanAppComponentContainerView.setScrollView(scrollView);
                return scrollView;
            }
            return null;
        }
        return (ScrollView) invokeLL.objValue;
    }
}
