package d.a.o0.a.c0.d;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e0.d;
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44043a;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view.getParent() != null) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: d.a.o0.a.c0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0653b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollView f44044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.c0.c.e.c.b f44045f;

        public RunnableC0653b(ScrollView scrollView, d.a.o0.a.c0.c.e.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44044e = scrollView;
            this.f44045f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44044e.smoothScrollTo(0, this.f44045f.G);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(304611311, "Ld/a/o0/a/c0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(304611311, "Ld/a/o0/a/c0/d/b;");
                return;
            }
        }
        f44043a = k.f46335a;
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

    public static boolean b(@NonNull c cVar, @NonNull d.a.o0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cVar, bVar, swanAppComponentContainerView)) == null) {
            d.b("Component-Container-Scroll", "insert component（scroll）");
            if (bVar.l == null) {
                d.a.o0.a.c0.g.a.a("Component-Container-Scroll", "insert component（scroll） with a null position");
                return false;
            } else if (TextUtils.isEmpty(bVar.f43983h)) {
                ScrollView h2 = h(swanAppComponentContainerView, bVar);
                return h2 != null && cVar.f44047a.c(h2, bVar.l);
            } else {
                SwanAppComponentContainerView a2 = cVar.a(bVar.f43983h);
                if (a2 == null) {
                    d.b("Component-Container-Scroll", "insert component（scroll） to parent with a null parent container view");
                    return false;
                }
                ScrollView h3 = h(swanAppComponentContainerView, bVar);
                if (h3 == null) {
                    d.b("Component-Container-Scroll", "insert component（scroll） to parent with a null scroll view");
                    return false;
                }
                a2.addView(h3, bVar.d());
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(@NonNull d.a.o0.a.c0.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? (bVar instanceof d.a.o0.a.c0.c.e.c.b) && TextUtils.equals(((d.a.o0.a.c0.c.e.c.b) bVar).H, "scroll") : invokeL.booleanValue;
    }

    public static boolean d(@NonNull c cVar, @NonNull d.a.o0.a.c0.b.a aVar, @NonNull d.a.o0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.o0.a.c0.f.b bVar2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, aVar, bVar, swanAppComponentContainerView, bVar2)) == null) {
            if (bVar instanceof d.a.o0.a.c0.c.e.c.b) {
                ScrollView scrollView = swanAppComponentContainerView.getScrollView();
                if (bVar2.a(7)) {
                    if (f44043a) {
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
                    if (cVar.b(aVar)) {
                        return true;
                    }
                    d.a.o0.a.c0.g.a.a("Component-Container-Scroll", "update component（scroll） overflow_y fail");
                }
                return false;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean e(@NonNull c cVar, @NonNull d.a.o0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, cVar, bVar, swanAppComponentContainerView)) == null) {
            if (f44043a) {
                Log.d("Component-Container-Scroll", "update component（scroll）position");
            }
            String str = bVar.f43983h;
            if (TextUtils.isEmpty(str)) {
                ScrollView scrollView = swanAppComponentContainerView.getScrollView();
                ScrollView scrollView2 = swanAppComponentContainerView;
                if (scrollView != null) {
                    scrollView2 = swanAppComponentContainerView.getScrollView();
                }
                return cVar.f44047a.a(scrollView2, bVar.l);
            }
            SwanAppComponentContainerView a2 = cVar.a(str);
            if (a2 == null) {
                d.b("Component-Container-Scroll", "update component（scroll）to parent with a null parent container view");
                return false;
            }
            ScrollView scrollView3 = swanAppComponentContainerView.getScrollView();
            if (scrollView3 != null && scrollView3.getParent() == a2) {
                a2.updateViewLayout(scrollView3, bVar.d());
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("update component（scroll）to parent with a illegal parent view (Scroll) ");
            sb.append(scrollView3 == null);
            d.a.o0.a.c0.g.a.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void f(@NonNull c cVar, @NonNull d.a.o0.a.c0.b.a aVar, @NonNull d.a.o0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.o0.a.c0.f.b bVar2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, cVar, aVar, bVar, swanAppComponentContainerView, bVar2) == null) && (bVar instanceof d.a.o0.a.c0.c.e.c.b)) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (bVar2.a(8)) {
                if (f44043a) {
                    Log.d("Component-Container-Scroll", "update component（scroll） scroll_top");
                }
                if (scrollView != null) {
                    scrollView.smoothScrollTo(0, ((d.a.o0.a.c0.c.e.c.b) bVar).G);
                }
            }
        }
    }

    public static boolean g(@NonNull c cVar, @NonNull d.a.o0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cVar, bVar, swanAppComponentContainerView)) == null) {
            if (TextUtils.isEmpty(bVar.f43983h)) {
                return cVar.f44047a.removeView(swanAppComponentContainerView.getScrollView());
            }
            SwanAppComponentContainerView a2 = cVar.a(bVar.f43983h);
            if (a2 == null) {
                d.b("Component-Container-Scroll", "remove component（scroll） to parent with a null parent container view");
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
            d.a.o0.a.c0.g.a.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Nullable
    public static ScrollView h(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.o0.a.c0.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, swanAppComponentContainerView, bVar)) == null) {
            if (bVar instanceof d.a.o0.a.c0.c.e.c.b) {
                ScrollView scrollView = new ScrollView(swanAppComponentContainerView.getContext());
                scrollView.setFillViewport(true);
                scrollView.setOnTouchListener(new a());
                FrameLayout frameLayout = new FrameLayout(swanAppComponentContainerView.getContext());
                frameLayout.addView(swanAppComponentContainerView, a());
                scrollView.addView(frameLayout);
                swanAppComponentContainerView.postDelayed(new RunnableC0653b(scrollView, (d.a.o0.a.c0.c.e.c.b) bVar), 100L);
                swanAppComponentContainerView.setScrollView(scrollView);
                return scrollView;
            }
            return null;
        }
        return (ScrollView) invokeLL.objValue;
    }
}
