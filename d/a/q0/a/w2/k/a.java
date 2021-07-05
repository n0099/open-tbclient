package d.a.q0.a.w2.k;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f;
import d.a.q0.a.k;
import d.a.q0.a.p.e.c;
/* loaded from: classes8.dex */
public class a<T extends d.a.q0.a.p.e.c> implements d.a.q0.a.h0.j.c, d.a.q0.a.w2.g.a, PullToRefreshBaseWebView.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f51656g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f51657a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f51658b;

    /* renamed from: c  reason: collision with root package name */
    public T f51659c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f51660d;

    /* renamed from: e  reason: collision with root package name */
    public Context f51661e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.p.e.b f51662f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1190447993, "Ld/a/q0/a/w2/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1190447993, "Ld/a/q0/a/w2/k/a;");
                return;
            }
        }
        f51656g = k.f49133a;
    }

    public a(Context context, @NonNull d.a.q0.a.p.e.b<T> bVar, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, frameLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51661e = context;
        this.f51657a = frameLayout;
        this.f51662f = bVar;
        e(bVar);
    }

    @Override // d.a.q0.a.w2.g.a
    public boolean a(View view, d.a.q0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, aVar)) == null) {
            if (view == null || this.f51658b == null || aVar == null) {
                return false;
            }
            if (f51656g) {
                Log.d("NAParentViewManager", "updateView pos: " + aVar);
            }
            if (d(view, this.f51658b)) {
                Object tag = view.getTag(f.aiapps_na_root_view_tag);
                if (tag instanceof b) {
                    b bVar = (b) tag;
                    c.a(bVar, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar);
                }
                this.f51658b.updateViewLayout(view, c.b(this.f51659c, aVar));
            } else if (!g(view)) {
                return false;
            } else {
                Object tag2 = view.getTag(f.aiapps_na_root_view_tag);
                if (tag2 instanceof b) {
                    b bVar2 = (b) tag2;
                    c.a(bVar2, aVar);
                    view.setTag(f.aiapps_na_root_view_tag, bVar2);
                }
                ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f51659c, aVar));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.f51658b.scrollTo(i2, i3);
        }
    }

    @Override // d.a.q0.a.w2.g.a
    public boolean c(View view, d.a.q0.a.l1.e.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, aVar)) == null) {
            if (this.f51661e != null && aVar != null) {
                b bVar = new b();
                c.a(bVar, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar);
                if (this.f51658b.indexOfChild(view) >= 0) {
                    d.a.q0.a.c0.g.a.a("NAParentViewManager", "repeat insert view!");
                    this.f51658b.removeView(view);
                }
                this.f51658b.addView(view, c.b(this.f51659c, aVar));
                return true;
            } else if (f51656g) {
                Log.d("NAParentViewManager", "insertView failed");
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, viewGroup)) == null) ? view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0 : invokeLL.booleanValue;
    }

    public final boolean e(d.a.q0.a.p.e.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (f51656g) {
                Log.d("NAParentViewManager", "createViewAndListener");
            }
            bVar.v(this);
            T u = bVar.u();
            this.f51659c = u;
            if (u == null) {
                return false;
            }
            SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f51661e);
            this.f51657a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
            this.f51658b = new FrameLayout(this.f51661e);
            swanAppNARootViewScrollView.addView(this.f51658b, new FrameLayout.LayoutParams(-1, -1));
            swanAppNARootViewScrollView.setFillViewport(true);
            PullToRefreshBaseWebView h0 = bVar.h0();
            this.f51660d = h0;
            if (h0 != null) {
                h0.setOnPullToRefreshScrollChangeListener(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f51662f.V(this);
        }
    }

    public final boolean g(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            if (view == null) {
                return false;
            }
            return view.getParent() instanceof SwanAppInlineFullScreenContainer;
        }
        return invokeL.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f51658b.setVisibility(i2);
        }
    }

    @Override // d.a.q0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f51658b.getLayoutParams();
            marginLayoutParams.leftMargin = -i2;
            marginLayoutParams.topMargin = -i3;
            this.f51658b.setLayoutParams(marginLayoutParams);
            for (int i6 = 0; i6 < this.f51658b.getChildCount(); i6++) {
                View childAt = this.f51658b.getChildAt(i6);
                if (childAt != null) {
                    Object tag = childAt.getTag(f.aiapps_na_root_view_tag);
                    b bVar = tag instanceof b ? (b) tag : null;
                    if (bVar != null && bVar.d()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bVar.b() + i2;
                        marginLayoutParams2.topMargin = bVar.c() + i3;
                        childAt.setLayoutParams(marginLayoutParams2);
                    }
                }
            }
        }
    }

    @Override // d.a.q0.a.w2.g.a
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (d(view, this.f51658b)) {
                try {
                    this.f51658b.removeView(view);
                } catch (Exception e2) {
                    if (f51656g) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } else if (g(view)) {
                try {
                    ((ViewGroup) view.getParent()).removeView(view);
                } catch (Exception e3) {
                    if (f51656g) {
                        e3.printStackTrace();
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
