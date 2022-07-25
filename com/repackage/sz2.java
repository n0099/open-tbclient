package com.repackage;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tz2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class sz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public Context b;
    public Resources c;
    public List<tz2> d;
    public uz2 e;
    public tz2.a f;
    public PopupWindow g;
    public View.OnKeyListener h;
    public int i;
    public View j;
    public boolean k;
    public f l;
    public boolean m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public Runnable r;

    /* loaded from: classes7.dex */
    public class a implements tz2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz2 a;

        public a(sz2 sz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz2Var;
        }

        @Override // com.repackage.tz2.a
        public void a(tz2 tz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tz2Var) == null) {
                if (tz2Var.f()) {
                    this.a.k(tz2Var.a());
                }
                tz2.a aVar = this.a.f;
                if (aVar != null) {
                    aVar.a(tz2Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz2 a;

        public b(sz2 sz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz2Var;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i == 4 || i == 82) {
                        this.a.j();
                        View.OnKeyListener onKeyListener = this.a.h;
                        if (onKeyListener != null) {
                            onKeyListener.onKey(view2, i, keyEvent);
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
        public final /* synthetic */ sz2 a;

        public c(sz2 sz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz2Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.m) {
                    this.a.h();
                }
                uz2 uz2Var = this.a.e;
                if (uz2Var != null) {
                    uz2Var.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz2 a;

        public d(sz2 sz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.m) {
                        this.a.i(this.a.n);
                    }
                    this.a.u(this.a.g);
                } catch (Exception e) {
                    if (sg1.a) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz2 a;

        public e(sz2 sz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(List<tz2> list);
    }

    /* loaded from: classes7.dex */
    public interface g {
    }

    public sz2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.m = false;
        this.n = 0.5f;
        this.o = false;
        this.p = R.style.obfuscated_res_0x7f100401;
        this.r = new e(this);
        this.a = view2;
        this.b = view2.getContext();
        this.c = this.a.getResources();
        this.d = new ArrayList();
        this.i = -2;
        this.q = pj2.M().a();
        o(this.b);
    }

    public tz2 e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) ? f(i, this.c.getString(i2), null) : (tz2) invokeII.objValue;
    }

    public tz2 f(int i, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, charSequence, drawable)) == null) {
            tz2 tz2Var = new tz2(this.b, i, charSequence, drawable);
            g(tz2Var);
            return tz2Var;
        }
        return (tz2) invokeILL.objValue;
    }

    public tz2 g(tz2 tz2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tz2Var)) == null) {
            tz2Var.g(this);
            if (this.k) {
                tz2Var.h(new a(this));
            } else {
                tz2Var.h(this.f);
            }
            this.d.add(tz2Var);
            return tz2Var;
        }
        return (tz2) invokeL.objValue;
    }

    public final void h() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view2 = this.a) == null) {
            return;
        }
        ((ViewGroup) view2.getRootView()).getOverlay().clear();
    }

    public final void i(float f2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || (view2 = this.a) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getRootView();
        ColorDrawable colorDrawable = new ColorDrawable(-16777216);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (f2 * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (popupWindow = this.g) == null) {
            return;
        }
        try {
            popupWindow.dismiss();
        } catch (Exception e2) {
            if (sg1.a) {
                Log.w("PopupWindow", "Exception", e2);
            }
        }
    }

    public void k(long j) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048582, this, j) == null) || (view2 = this.a) == null) {
            return;
        }
        view2.removeCallbacks(this.r);
        if (j > 0) {
            this.a.postDelayed(this.r, j);
        } else {
            j();
        }
    }

    public abstract void l(View view2, List<tz2> list);

    public abstract View m(Context context);

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopupWindow popupWindow = this.g;
            return popupWindow != null && popupWindow.isShowing();
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            View m = m(context);
            this.j = m;
            m.setFocusable(true);
            this.j.setFocusableInTouchMode(true);
            if (!(this.j instanceof g) && sg1.a) {
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

    public void r(tz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i = i;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (pj2.M().a() != this.q) {
                o(this.b);
                this.g = null;
            }
            v(true);
            this.q = pj2.M().a();
        }
    }

    public abstract void u(PopupWindow popupWindow);

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            uz2 uz2Var = this.e;
            if (uz2Var != null) {
                uz2Var.b();
            }
            w(this.d);
            l(this.j, this.d);
            j();
            if (this.g == null) {
                PopupWindow popupWindow = new PopupWindow(this.j, this.i, -2, true);
                this.g = popupWindow;
                if (this.o) {
                    popupWindow.setAnimationStyle(this.p);
                }
                if (z) {
                    this.g.setBackgroundDrawable(this.c.getDrawable(R.drawable.obfuscated_res_0x7f0801b0));
                    this.g.setTouchable(true);
                } else {
                    this.g.setTouchable(false);
                }
                this.g.setOnDismissListener(new c(this));
            }
            View view2 = this.a;
            if (view2 == null) {
                uz2 uz2Var2 = this.e;
                if (uz2Var2 != null) {
                    uz2Var2.a();
                    return;
                }
                return;
            }
            view2.post(new d(this));
            this.j.postInvalidate();
        }
    }

    public void w(List<tz2> list) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (fVar = this.l) == null) {
            return;
        }
        fVar.a(list);
    }
}
