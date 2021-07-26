package d.a.o0.a.z1.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.i;
import d.a.o0.a.k;
import d.a.o0.a.z1.b.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View f49277a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49278b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f49279c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.o0.a.z1.b.e.b> f49280d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.z1.b.e.c f49281e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f49282f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f49283g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f49284h;

    /* renamed from: i  reason: collision with root package name */
    public int f49285i;
    public View j;
    public boolean k;
    public f l;
    public boolean m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public Runnable r;

    /* renamed from: d.a.o0.a.z1.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1013a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f49286a;

        public C1013a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49286a = aVar;
        }

        @Override // d.a.o0.a.z1.b.e.b.a
        public void a(d.a.o0.a.z1.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.f()) {
                    this.f49286a.k(bVar.a());
                }
                b.a aVar = this.f49286a.f49282f;
                if (aVar != null) {
                    aVar.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49287e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49287e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i2 == 4 || i2 == 82) {
                        this.f49287e.j();
                        View.OnKeyListener onKeyListener = this.f49287e.f49284h;
                        if (onKeyListener != null) {
                            onKeyListener.onKey(view, i2, keyEvent);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49288e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49288e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f49288e.m) {
                    this.f49288e.h();
                }
                d.a.o0.a.z1.b.e.c cVar = this.f49288e.f49281e;
                if (cVar != null) {
                    cVar.onDismissMenu();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49289e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49289e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f49289e.m) {
                        this.f49289e.i(this.f49289e.n);
                    }
                    this.f49289e.u(this.f49289e.f49283g);
                } catch (Exception e2) {
                    if (k.f46335a) {
                        Log.w("PopupWindow", "Exception", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49290e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49290e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49290e.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(List<d.a.o0.a.z1.b.e.b> list);
    }

    /* loaded from: classes7.dex */
    public interface g {
    }

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
        this.k = true;
        this.m = false;
        this.n = 0.5f;
        this.o = false;
        this.p = i.swan_app_pop_window_anim;
        this.r = new e(this);
        this.f49277a = view;
        this.f49278b = view.getContext();
        this.f49279c = this.f49277a.getResources();
        this.f49280d = new ArrayList();
        this.f49285i = -2;
        this.q = d.a.o0.a.c1.a.H().a();
        o(this.f49278b);
    }

    public d.a.o0.a.z1.b.e.b e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? f(i2, this.f49279c.getString(i3), null) : (d.a.o0.a.z1.b.e.b) invokeII.objValue;
    }

    public d.a.o0.a.z1.b.e.b f(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charSequence, drawable)) == null) {
            d.a.o0.a.z1.b.e.b bVar = new d.a.o0.a.z1.b.e.b(this.f49278b, i2, charSequence, drawable);
            g(bVar);
            return bVar;
        }
        return (d.a.o0.a.z1.b.e.b) invokeILL.objValue;
    }

    public d.a.o0.a.z1.b.e.b g(d.a.o0.a.z1.b.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            bVar.g(this);
            if (this.k) {
                bVar.h(new C1013a(this));
            } else {
                bVar.h(this.f49282f);
            }
            this.f49280d.add(bVar);
            return bVar;
        }
        return (d.a.o0.a.z1.b.e.b) invokeL.objValue;
    }

    public final void h() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view = this.f49277a) == null) {
            return;
        }
        ((ViewGroup) view.getRootView()).getOverlay().clear();
    }

    public final void i(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (view = this.f49277a) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (popupWindow = this.f49283g) == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception e2) {
            if (k.f46335a) {
                Log.w("PopupWindow", "Exception", e2);
            }
        }
    }

    public void k(long j) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j) == null) || (view = this.f49277a) == null) {
            return;
        }
        view.removeCallbacks(this.r);
        if (j > 0) {
            this.f49277a.postDelayed(this.r, j);
        } else {
            j();
        }
    }

    public abstract void l(View view, List<d.a.o0.a.z1.b.e.b> list);

    public abstract View m(Context context);

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopupWindow popupWindow = this.f49283g;
            return popupWindow != null && popupWindow.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            View m = m(context);
            this.j = m;
            m.setFocusable(true);
            this.j.setFocusableInTouchMode(true);
            if (!(this.j instanceof g) && k.f46335a) {
                throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
            }
            this.j.setOnKeyListener(new b(this));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public void r(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f49282f = aVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f49285i = i2;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d.a.o0.a.c1.a.H().a() != this.q) {
                o(this.f49278b);
                this.f49283g = null;
            }
            v(true);
            this.q = d.a.o0.a.c1.a.H().a();
        }
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            d.a.o0.a.z1.b.e.c cVar = this.f49281e;
            if (cVar != null) {
                cVar.onShowMenu();
            }
            w(this.f49280d);
            l(this.j, this.f49280d);
            j();
            if (this.f49283g == null) {
                PopupWindow popupWindow = new PopupWindow(this.j, this.f49285i, -2, true);
                this.f49283g = popupWindow;
                if (this.o) {
                    popupWindow.setAnimationStyle(this.p);
                }
                if (z) {
                    this.f49283g.setBackgroundDrawable(this.f49279c.getDrawable(d.a.o0.a.e.aiapps_pop_transparent_bg));
                    this.f49283g.setTouchable(true);
                } else {
                    this.f49283g.setTouchable(false);
                }
                this.f49283g.setOnDismissListener(new c(this));
            }
            View view = this.f49277a;
            if (view == null) {
                d.a.o0.a.z1.b.e.c cVar2 = this.f49281e;
                if (cVar2 != null) {
                    cVar2.onDismissMenu();
                    return;
                }
                return;
            }
            view.post(new d(this));
            this.j.postInvalidate();
        }
    }

    public void w(List<d.a.o0.a.z1.b.e.b> list) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (fVar = this.l) == null) {
            return;
        }
        fVar.a(list);
    }
}
