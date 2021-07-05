package d.a.q0.a.z1.b.e;

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
import d.a.q0.a.i;
import d.a.q0.a.k;
import d.a.q0.a.z1.b.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View f52075a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52076b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f52077c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.q0.a.z1.b.e.b> f52078d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.a.z1.b.e.c f52079e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f52080f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f52081g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f52082h;

    /* renamed from: i  reason: collision with root package name */
    public int f52083i;
    public View j;
    public boolean k;
    public f l;
    public boolean m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public Runnable r;

    /* renamed from: d.a.q0.a.z1.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1055a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52084a;

        public C1055a(a aVar) {
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
            this.f52084a = aVar;
        }

        @Override // d.a.q0.a.z1.b.e.b.a
        public void a(d.a.q0.a.z1.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.f()) {
                    this.f52084a.k(bVar.a());
                }
                b.a aVar = this.f52084a.f52080f;
                if (aVar != null) {
                    aVar.a(bVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52085e;

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
            this.f52085e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i2 == 4 || i2 == 82) {
                        this.f52085e.j();
                        View.OnKeyListener onKeyListener = this.f52085e.f52082h;
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

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52086e;

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
            this.f52086e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f52086e.m) {
                    this.f52086e.h();
                }
                d.a.q0.a.z1.b.e.c cVar = this.f52086e.f52079e;
                if (cVar != null) {
                    cVar.onDismissMenu();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52087e;

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
            this.f52087e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f52087e.m) {
                        this.f52087e.i(this.f52087e.n);
                    }
                    this.f52087e.u(this.f52087e.f52081g);
                } catch (Exception e2) {
                    if (k.f49133a) {
                        Log.w("PopupWindow", "Exception", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f52088e;

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
            this.f52088e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52088e.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(List<d.a.q0.a.z1.b.e.b> list);
    }

    /* loaded from: classes8.dex */
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
        this.f52075a = view;
        this.f52076b = view.getContext();
        this.f52077c = this.f52075a.getResources();
        this.f52078d = new ArrayList();
        this.f52083i = -2;
        this.q = d.a.q0.a.c1.a.H().a();
        o(this.f52076b);
    }

    public d.a.q0.a.z1.b.e.b e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? f(i2, this.f52077c.getString(i3), null) : (d.a.q0.a.z1.b.e.b) invokeII.objValue;
    }

    public d.a.q0.a.z1.b.e.b f(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charSequence, drawable)) == null) {
            d.a.q0.a.z1.b.e.b bVar = new d.a.q0.a.z1.b.e.b(this.f52076b, i2, charSequence, drawable);
            g(bVar);
            return bVar;
        }
        return (d.a.q0.a.z1.b.e.b) invokeILL.objValue;
    }

    public d.a.q0.a.z1.b.e.b g(d.a.q0.a.z1.b.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            bVar.g(this);
            if (this.k) {
                bVar.h(new C1055a(this));
            } else {
                bVar.h(this.f52080f);
            }
            this.f52078d.add(bVar);
            return bVar;
        }
        return (d.a.q0.a.z1.b.e.b) invokeL.objValue;
    }

    public final void h() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view = this.f52075a) == null) {
            return;
        }
        ((ViewGroup) view.getRootView()).getOverlay().clear();
    }

    public final void i(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (view = this.f52075a) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (popupWindow = this.f52081g) == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception e2) {
            if (k.f49133a) {
                Log.w("PopupWindow", "Exception", e2);
            }
        }
    }

    public void k(long j) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j) == null) || (view = this.f52075a) == null) {
            return;
        }
        view.removeCallbacks(this.r);
        if (j > 0) {
            this.f52075a.postDelayed(this.r, j);
        } else {
            j();
        }
    }

    public abstract void l(View view, List<d.a.q0.a.z1.b.e.b> list);

    public abstract View m(Context context);

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopupWindow popupWindow = this.f52081g;
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
            if (!(this.j instanceof g) && k.f49133a) {
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
            this.f52080f = aVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f52083i = i2;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d.a.q0.a.c1.a.H().a() != this.q) {
                o(this.f52076b);
                this.f52081g = null;
            }
            v(true);
            this.q = d.a.q0.a.c1.a.H().a();
        }
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            d.a.q0.a.z1.b.e.c cVar = this.f52079e;
            if (cVar != null) {
                cVar.onShowMenu();
            }
            w(this.f52078d);
            l(this.j, this.f52078d);
            j();
            if (this.f52081g == null) {
                PopupWindow popupWindow = new PopupWindow(this.j, this.f52083i, -2, true);
                this.f52081g = popupWindow;
                if (this.o) {
                    popupWindow.setAnimationStyle(this.p);
                }
                if (z) {
                    this.f52081g.setBackgroundDrawable(this.f52077c.getDrawable(d.a.q0.a.e.aiapps_pop_transparent_bg));
                    this.f52081g.setTouchable(true);
                } else {
                    this.f52081g.setTouchable(false);
                }
                this.f52081g.setOnDismissListener(new c(this));
            }
            View view = this.f52075a;
            if (view == null) {
                d.a.q0.a.z1.b.e.c cVar2 = this.f52079e;
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

    public void w(List<d.a.q0.a.z1.b.e.b> list) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (fVar = this.l) == null) {
            return;
        }
        fVar.a(list);
    }
}
