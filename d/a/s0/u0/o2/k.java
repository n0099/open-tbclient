package d.a.s0.u0.o2;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.AdvancedAdSlideLoadingLayout;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import d.a.s0.u0.r0;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f66682a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedAdSlideLoadingLayout f66683b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f66684c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f66685d;

    /* renamed from: e  reason: collision with root package name */
    public r0 f66686e;

    /* renamed from: f  reason: collision with root package name */
    public int f66687f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.f0.p.c f66688g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.r.f0.p.b f66689h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.r.f0.p.a f66690i;
    public Runnable j;

    /* loaded from: classes9.dex */
    public class a implements d.a.r0.r.f0.p.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.f0.p.c
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.r0.r.f0.p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f66691a;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66691a = kVar;
        }

        @Override // d.a.r0.r.f0.p.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.r0.r.f0.p.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f66691a.f();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements d.a.r0.r.f0.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f66692a;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66692a = kVar;
        }

        @Override // d.a.r0.r.f0.p.a
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // d.a.r0.r.f0.p.a
        public void b(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // d.a.r0.r.f0.p.a
        public void c(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // d.a.r0.r.f0.p.a
        public void d(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f66692a.f66686e == null) {
                return;
            }
            this.f66692a.f66686e.H();
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f66693e;

        public d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66693e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66693e.f66683b.o();
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66688g = new a(this);
        this.f66689h = new b(this);
        this.f66690i = new c(this);
        this.j = new d(this);
        this.f66682a = frsFragment;
        View D2 = frsFragment.D2();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) D2.findViewById(R.id.frs_content_layout);
        this.f66683b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.f66688g);
        this.f66683b.j(this.f66689h);
        this.f66683b.i(this.f66690i);
        this.f66683b.n();
        this.f66684c = (AppBarLayout) D2.findViewById(R.id.frs_app_bar_layout);
        this.f66685d = (BdTypeRecyclerView) D2.findViewById(R.id.frs_lv_thread);
    }

    public void d(d.a.r0.r.q.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar != null && !d.a.c.e.p.k.isEmpty(dVar.f55901b) && !d.a.c.e.p.k.isEmpty(dVar.f55900a) && dVar.f55902c >= 0) {
                if (this.f66683b.v()) {
                    this.f66683b.o();
                }
                this.f66683b.W(dVar, (ViewGroup) this.f66682a.getActivity().getWindow().getDecorView());
                this.f66683b.setAdvancedAdStyle(true);
                this.f66683b.setNavigationBar((NavigationBar) this.f66682a.getActivity().findViewById(R.id.view_navigation_bar));
                return;
            }
            this.f66683b.setAdvancedAdStyle(false);
        }
    }

    public void e() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (advancedAdSlideLoadingLayout = this.f66683b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.Y();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.c.e.m.e.a().postDelayed(this.j, 5000L);
            r0 r0Var = this.f66686e;
            if (r0Var != null) {
                r0Var.l0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public r0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66686e : (r0) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66683b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66683b.v() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66683b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View findViewById = this.f66682a.D2().findViewById(R.id.head_top_bg_container);
            TbImageView tbImageView = (TbImageView) this.f66682a.getActivity().findViewById(R.id.head_top_advanced_ad_bg);
            if (findViewById == null) {
                return;
            }
            this.f66683b.setBgView(findViewById);
            if (this.f66683b.getAdvancedAdView() == null) {
                this.f66683b.setAdvancedAdView(tbImageView, findViewById.getLayoutParams().height, d.a.c.e.p.l.k(this.f66682a.getContext()));
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f66683b.m(this.f66682a.D2().findViewById(R.id.frs_header_empty_view), 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f66683b.o();
            d.a.c.e.m.e.a().removeCallbacks(this.j);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f66687f = i2;
        }
    }

    public void o(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, r0Var) == null) {
            this.f66686e = r0Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f66683b.setEnableSlideLoading(z);
        }
    }

    public void q(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 == this.f66687f) {
            if (z) {
                t();
                return;
            }
            this.f66685d.getAdapter().notifyDataSetChanged();
            u();
        }
    }

    public void r(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (advancedAdSlideLoadingLayout = this.f66683b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f66683b.getData() == null || !this.f66683b.a0() || d.a.r0.r.d0.b.j().g("key_frs_advanced_ad_guide", false)) {
            return;
        }
        d.a.r0.r.d0.b.j().t("key_frs_advanced_ad_guide", true);
        this.f66683b.d0();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f66683b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.u()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f66685d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.f66684c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.f66683b.H();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f66683b.v()) {
            this.f66683b.o();
            d.a.c.e.m.e.a().removeCallbacks(this.j);
        }
    }
}
