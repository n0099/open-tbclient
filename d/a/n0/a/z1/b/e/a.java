package d.a.n0.a.z1.b.e;

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
import d.a.n0.a.i;
import d.a.n0.a.k;
import d.a.n0.a.z1.b.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View f48773a;

    /* renamed from: b  reason: collision with root package name */
    public Context f48774b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f48775c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.n0.a.z1.b.e.b> f48776d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.z1.b.e.c f48777e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f48778f;

    /* renamed from: g  reason: collision with root package name */
    public PopupWindow f48779g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnKeyListener f48780h;

    /* renamed from: i  reason: collision with root package name */
    public int f48781i;
    public View j;
    public boolean k;
    public f l;
    public boolean m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public Runnable r;

    /* renamed from: d.a.n0.a.z1.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1004a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48782a;

        public C1004a(a aVar) {
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
            this.f48782a = aVar;
        }

        @Override // d.a.n0.a.z1.b.e.b.a
        public void a(d.a.n0.a.z1.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar.f()) {
                    this.f48782a.k(bVar.a());
                }
                b.a aVar = this.f48782a.f48778f;
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
        public final /* synthetic */ a f48783e;

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
            this.f48783e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i2 == 4 || i2 == 82) {
                        this.f48783e.j();
                        View.OnKeyListener onKeyListener = this.f48783e.f48780h;
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
        public final /* synthetic */ a f48784e;

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
            this.f48784e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48784e.m) {
                    this.f48784e.h();
                }
                d.a.n0.a.z1.b.e.c cVar = this.f48784e.f48777e;
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
        public final /* synthetic */ a f48785e;

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
            this.f48785e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f48785e.m) {
                        this.f48785e.i(this.f48785e.n);
                    }
                    this.f48785e.u(this.f48785e.f48779g);
                } catch (Exception e2) {
                    if (k.f45831a) {
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
        public final /* synthetic */ a f48786e;

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
            this.f48786e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48786e.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(List<d.a.n0.a.z1.b.e.b> list);
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
        this.f48773a = view;
        this.f48774b = view.getContext();
        this.f48775c = this.f48773a.getResources();
        this.f48776d = new ArrayList();
        this.f48781i = -2;
        this.q = d.a.n0.a.c1.a.H().a();
        o(this.f48774b);
    }

    public d.a.n0.a.z1.b.e.b e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) ? f(i2, this.f48775c.getString(i3), null) : (d.a.n0.a.z1.b.e.b) invokeII.objValue;
    }

    public d.a.n0.a.z1.b.e.b f(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charSequence, drawable)) == null) {
            d.a.n0.a.z1.b.e.b bVar = new d.a.n0.a.z1.b.e.b(this.f48774b, i2, charSequence, drawable);
            g(bVar);
            return bVar;
        }
        return (d.a.n0.a.z1.b.e.b) invokeILL.objValue;
    }

    public d.a.n0.a.z1.b.e.b g(d.a.n0.a.z1.b.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            bVar.g(this);
            if (this.k) {
                bVar.h(new C1004a(this));
            } else {
                bVar.h(this.f48778f);
            }
            this.f48776d.add(bVar);
            return bVar;
        }
        return (d.a.n0.a.z1.b.e.b) invokeL.objValue;
    }

    public final void h() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view = this.f48773a) == null) {
            return;
        }
        ((ViewGroup) view.getRootView()).getOverlay().clear();
    }

    public final void i(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (view = this.f48773a) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (popupWindow = this.f48779g) == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception e2) {
            if (k.f45831a) {
                Log.w("PopupWindow", "Exception", e2);
            }
        }
    }

    public void k(long j) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j) == null) || (view = this.f48773a) == null) {
            return;
        }
        view.removeCallbacks(this.r);
        if (j > 0) {
            this.f48773a.postDelayed(this.r, j);
        } else {
            j();
        }
    }

    public abstract void l(View view, List<d.a.n0.a.z1.b.e.b> list);

    public abstract View m(Context context);

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopupWindow popupWindow = this.f48779g;
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
            if (!(this.j instanceof g) && k.f45831a) {
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
            this.f48778f = aVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f48781i = i2;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d.a.n0.a.c1.a.H().a() != this.q) {
                o(this.f48774b);
                this.f48779g = null;
            }
            v(true);
            this.q = d.a.n0.a.c1.a.H().a();
        }
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            d.a.n0.a.z1.b.e.c cVar = this.f48777e;
            if (cVar != null) {
                cVar.onShowMenu();
            }
            w(this.f48776d);
            l(this.j, this.f48776d);
            j();
            if (this.f48779g == null) {
                PopupWindow popupWindow = new PopupWindow(this.j, this.f48781i, -2, true);
                this.f48779g = popupWindow;
                if (this.o) {
                    popupWindow.setAnimationStyle(this.p);
                }
                if (z) {
                    this.f48779g.setBackgroundDrawable(this.f48775c.getDrawable(d.a.n0.a.e.aiapps_pop_transparent_bg));
                    this.f48779g.setTouchable(true);
                } else {
                    this.f48779g.setTouchable(false);
                }
                this.f48779g.setOnDismissListener(new c(this));
            }
            View view = this.f48773a;
            if (view == null) {
                d.a.n0.a.z1.b.e.c cVar2 = this.f48777e;
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

    public void w(List<d.a.n0.a.z1.b.e.b> list) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (fVar = this.l) == null) {
            return;
        }
        fVar.a(list);
    }
}
