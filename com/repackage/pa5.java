package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ec5;
import com.repackage.nc5;
import com.repackage.pb5;
import com.repackage.qb5;
import java.util.List;
/* loaded from: classes6.dex */
public class pa5<Q extends pb5, P extends qb5> implements tb5<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public final View b;
    public final ic5 c;
    public final yb5 d;
    public final rb5<Q, P> e;
    public final wb5<Q, P> f;
    public ub5<P> g;
    public final View.OnClickListener h;
    public final km4 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa5 a;

        public a(pa5 pa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                fc5.b(" ----NetRefreshView----");
                this.a.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends km4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa5 a;

        public b(pa5 pa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa5Var;
        }

        @Override // com.repackage.km4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                fc5.b(" ----onActivityDestroyed---- ");
                this.a.i();
            }
        }

        @Override // com.repackage.km4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                fc5.b(" ----onActivityPaused---- ");
                this.a.j();
            }
        }

        @Override // com.repackage.km4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (tbPageContext = this.a.a) != null && tbPageContext.getPageActivity() == activity) {
                fc5.b(" ----onActivityResumed---- ");
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c<Q extends pb5, P extends qb5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup A;
        public TbPageContext a;
        public Q b;
        public P c;
        public int d;
        public int e;
        public String f;
        public ec5.d g;
        public ec5.b h;
        public ec5.a i;
        public ac5 j;
        public ac5 k;
        public ac5 l;
        public String m;
        public boolean n;
        public boolean o;
        public boolean p;
        public kc5 q;
        public jc5 r;
        public ec5.c s;
        public List<an> t;
        public List<an> u;
        public jm4<nn4> v;
        public gb5 w;
        public int x;
        public ic5 y;
        public View z;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.p = false;
        }

        public final void a() {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b == null || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
                return;
            }
            this.b.a(this.a.getPageActivity().getIntent());
        }

        public c b(List<an> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                this.p = true;
                this.t = list;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c c(kc5 kc5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kc5Var)) == null) {
                this.p = true;
                this.q = kc5Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c d(jm4<nn4> jm4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jm4Var)) == null) {
                this.p = true;
                this.v = jm4Var;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public pa5 e(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
                this.A = viewGroup;
                this.a = (TbPageContext) h9.a(viewGroup.getContext());
                a();
                g();
                f();
                return new pa5(this, null);
            }
            return (pa5) invokeL.objValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.p && this.q != null && this.r != null) {
                    nc5.f fVar = new nc5.f();
                    fVar.i(this.q);
                    fVar.f(this.r);
                    fVar.b(this.s);
                    fVar.a(this.t);
                    fVar.g(this.v);
                    fVar.e(this.x);
                    fVar.h(this.w);
                    nc5 c = fVar.c(this.a);
                    h(c);
                    this.y = c;
                } else if (this.p && this.q != null) {
                    nc5.f fVar2 = new nc5.f();
                    fVar2.i(this.q);
                    fVar2.b(this.s);
                    fVar2.a(this.t);
                    fVar2.g(this.v);
                    fVar2.e(this.x);
                    fVar2.h(this.w);
                    nc5 c2 = fVar2.c(this.a);
                    h(c2);
                    this.y = c2;
                } else if (this.p) {
                    nc5.f fVar3 = new nc5.f();
                    fVar3.b(this.s);
                    fVar3.a(this.t);
                    fVar3.g(this.v);
                    fVar3.e(this.x);
                    fVar3.h(this.w);
                    nc5 c3 = fVar3.c(this.a);
                    h(c3);
                    this.y = c3;
                }
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.o) {
                NavigationBar navigationBar = new NavigationBar(this.a.getPageActivity());
                if (this.n) {
                    navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                }
                navigationBar.setCenterTextTitle(this.m);
                this.z = navigationBar;
            }
        }

        public final void h(nc5 nc5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, nc5Var) == null) || ListUtils.isEmpty(this.u)) {
                return;
            }
            nc5Var.z(this.u);
        }

        public c i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c j(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.f = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c k(@NonNull Q q) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, q)) == null) {
                this.b = q;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c l(@NonNull P p) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, p)) == null) {
                this.c = p;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (c) invokeI.objValue;
        }
    }

    public /* synthetic */ pa5(c cVar, a aVar) {
        this(cVar);
    }

    public void b(oa5 oa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oa5Var) == null) {
            this.f.b(oa5Var);
        }
    }

    public Q c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f.f() : (Q) invokeV.objValue;
    }

    public P d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.g() : (P) invokeV.objValue;
    }

    public LoadType e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            jb5 c2 = c().c();
            return c2 != null ? c2.b : LoadType.REFRESH;
        }
        return (LoadType) invokeV.objValue;
    }

    public boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f.i(z) : invokeZ.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f.j() : invokeV.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            yb5 yb5Var = this.d;
            if (yb5Var != null) {
                yb5Var.onChangeSkinType(i);
            }
            ic5 ic5Var = this.c;
            if (ic5Var != null) {
                ic5Var.onChangeSkinType(i);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            yb5 yb5Var = this.d;
            if (yb5Var != null) {
                yb5Var.onDestroy();
            }
            wb5<Q, P> wb5Var = this.f;
            if (wb5Var != null) {
                wb5Var.k();
            }
            ic5 ic5Var = this.c;
            if (ic5Var != null) {
                ic5Var.e();
            }
            u();
        }
    }

    public void j() {
        ic5 ic5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ic5Var = this.c) == null) {
            return;
        }
        ic5Var.f();
    }

    public void k() {
        ic5 ic5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (ic5Var = this.c) == null) {
            return;
        }
        ic5Var.g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tb5
    /* renamed from: l */
    public void onSuccess(P p) {
        lb5 lb5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, p) == null) {
            fc5.b(" ----onSuccess---- ");
            ub5<P> ub5Var = this.g;
            if (ub5Var != null) {
                ub5Var.onSuccess(p);
            }
            ic5 ic5Var = this.c;
            if (ic5Var != null) {
                lb5Var = ic5Var.a(p);
            } else {
                s();
                lb5Var = new lb5();
            }
            ub5<P> ub5Var2 = this.g;
            if (ub5Var2 != null) {
                ub5Var2.a(lb5Var);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ic5 ic5Var = this.c;
            if (ic5Var != null) {
                ic5Var.h();
                return;
            }
            r();
            f(true);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            wb5<Q, P> wb5Var = this.f;
            if (wb5Var != null) {
                wb5Var.s(bdUniqueId);
            }
            ic5 ic5Var = this.c;
            if (ic5Var != null) {
                ic5Var.i(bdUniqueId);
            }
        }
    }

    @Override // com.repackage.tb5
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            fc5.b(" ----onError---- ");
            ub5<P> ub5Var = this.g;
            if (ub5Var != null) {
                ub5Var.onError(i, str);
            }
            ic5 ic5Var = this.c;
            if (ic5Var != null) {
                ic5Var.a(d());
            } else {
                q(str);
            }
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            fc5.b(" ----showEmpty---- ");
            this.d.a(ViewType.EMPTY, str);
            t(ViewType.EMPTY);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            fc5.b(" ----showError---- ");
            this.d.a(ViewType.ERROR, str);
            t(ViewType.ERROR);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            fc5.b(" ----showLoading---- ");
            t(ViewType.LOADING);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            fc5.b(" ----showContent---- ");
            t(ViewType.CONTENT);
        }
    }

    public final void t(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewType) == null) {
            this.d.b(viewType);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public pa5(c<Q, P> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
        this.i = new b(this);
        this.a = cVar.a;
        sb5 sb5Var = new sb5(cVar.d, cVar.e, cVar.f, cVar.b, cVar.c);
        this.e = sb5Var;
        this.f = new wb5<>(cVar.a, sb5Var, this);
        RelativeLayout relativeLayout = new RelativeLayout(this.a.getPageActivity());
        View view2 = cVar.z;
        this.b = view2;
        if (view2 != null) {
            view2.setId(2184);
            this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            relativeLayout.addView(this.b);
        }
        ic5 ic5Var = cVar.y;
        this.c = ic5Var;
        if (ic5Var != null) {
            ic5Var.j(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, 2184);
            this.c.getView().setLayoutParams(layoutParams);
            this.c.b(relativeLayout);
        }
        cVar.A.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        ec5.d dVar = cVar.g;
        dVar = dVar == null ? new ec5.d() : dVar;
        ec5.b bVar = cVar.h;
        bVar = bVar == null ? new ec5.b() : bVar;
        ec5.a aVar = cVar.i;
        aVar = aVar == null ? new ec5.a() : aVar;
        View.OnClickListener onClickListener = this.h;
        bVar.h = onClickListener;
        aVar.h = onClickListener;
        ec5 ec5Var = new ec5();
        ec5Var.b = aVar;
        ec5Var.c = bVar;
        ec5Var.a = dVar;
        this.d = new zb5(this.c, relativeLayout, ec5Var);
        ac5 ac5Var = cVar.j;
        ac5Var = ac5Var == null ? new dc5(this.a) : ac5Var;
        ac5 ac5Var2 = cVar.k;
        ac5Var2 = ac5Var2 == null ? new cc5(this.a) : ac5Var2;
        ac5 ac5Var3 = cVar.l;
        ac5Var3 = ac5Var3 == null ? new bc5(this.a) : ac5Var3;
        this.d.c(ViewType.LOADING, ac5Var);
        this.d.c(ViewType.ERROR, ac5Var2);
        this.d.c(ViewType.EMPTY, ac5Var3);
        m();
    }
}
