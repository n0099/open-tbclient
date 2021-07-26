package d.a.q0.u0.o2;

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
import d.a.q0.u0.r0;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f64108a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedAdSlideLoadingLayout f64109b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f64110c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f64111d;

    /* renamed from: e  reason: collision with root package name */
    public r0 f64112e;

    /* renamed from: f  reason: collision with root package name */
    public int f64113f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.s.f0.q.c f64114g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.s.f0.q.b f64115h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.s.f0.q.a f64116i;
    public Runnable j;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.s.f0.q.c {
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

        @Override // d.a.p0.s.f0.q.c
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.p0.s.f0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f64117a;

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
            this.f64117a = kVar;
        }

        @Override // d.a.p0.s.f0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.p0.s.f0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f64117a.f();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.p0.s.f0.q.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f64118a;

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
            this.f64118a = kVar;
        }

        @Override // d.a.p0.s.f0.q.a
        public void a(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // d.a.p0.s.f0.q.a
        public void b(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // d.a.p0.s.f0.q.a
        public void c(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            }
        }

        @Override // d.a.p0.s.f0.q.a
        public void d(int i2, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.f64118a.f64112e == null) {
                return;
            }
            this.f64118a.f64112e.H();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f64119e;

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
            this.f64119e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64119e.f64109b.o();
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
        this.f64114g = new a(this);
        this.f64115h = new b(this);
        this.f64116i = new c(this);
        this.j = new d(this);
        this.f64108a = frsFragment;
        View J2 = frsFragment.J2();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) J2.findViewById(R.id.frs_content_layout);
        this.f64109b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.f64114g);
        this.f64109b.j(this.f64115h);
        this.f64109b.i(this.f64116i);
        this.f64109b.n();
        this.f64110c = (AppBarLayout) J2.findViewById(R.id.frs_app_bar_layout);
        this.f64111d = (BdTypeRecyclerView) J2.findViewById(R.id.frs_lv_thread);
    }

    public void d(d.a.p0.s.q.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            if (dVar != null && !d.a.d.e.p.k.isEmpty(dVar.f53280b) && !d.a.d.e.p.k.isEmpty(dVar.f53279a) && dVar.f53281c >= 0) {
                if (this.f64109b.v()) {
                    this.f64109b.o();
                }
                this.f64109b.W(dVar, (ViewGroup) this.f64108a.getActivity().getWindow().getDecorView());
                this.f64109b.setAdvancedAdStyle(true);
                this.f64109b.setNavigationBar((NavigationBar) this.f64108a.getActivity().findViewById(R.id.view_navigation_bar));
                return;
            }
            this.f64109b.setAdvancedAdStyle(false);
        }
    }

    public void e() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (advancedAdSlideLoadingLayout = this.f64109b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.Y();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.d.e.m.e.a().postDelayed(this.j, 5000L);
            r0 r0Var = this.f64112e;
            if (r0Var != null) {
                r0Var.o0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public r0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64112e : (r0) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64109b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64109b.v() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64109b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View findViewById = this.f64108a.J2().findViewById(R.id.head_top_bg_container);
            TbImageView tbImageView = (TbImageView) this.f64108a.getActivity().findViewById(R.id.head_top_advanced_ad_bg);
            if (findViewById == null) {
                return;
            }
            this.f64109b.setBgView(findViewById);
            if (this.f64109b.getAdvancedAdView() == null) {
                this.f64109b.setAdvancedAdView(tbImageView, findViewById.getLayoutParams().height, d.a.d.e.p.l.k(this.f64108a.getContext()));
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f64109b.m(this.f64108a.J2().findViewById(R.id.frs_header_empty_view), 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f64109b.o();
            d.a.d.e.m.e.a().removeCallbacks(this.j);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f64113f = i2;
        }
    }

    public void o(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, r0Var) == null) {
            this.f64112e = r0Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f64109b.setEnableSlideLoading(z);
        }
    }

    public void q(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && i2 == this.f64113f) {
            if (z) {
                t();
                return;
            }
            this.f64111d.getAdapter().notifyDataSetChanged();
            u();
        }
    }

    public void r(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (advancedAdSlideLoadingLayout = this.f64109b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f64109b.getData() == null || !this.f64109b.a0() || d.a.p0.s.d0.b.j().g("key_frs_advanced_ad_guide", false)) {
            return;
        }
        d.a.p0.s.d0.b.j().t("key_frs_advanced_ad_guide", true);
        this.f64109b.d0();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.f64109b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.u()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f64111d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.f64110c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.f64109b.H();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f64109b.v()) {
            this.f64109b.o();
            d.a.d.e.m.e.a().removeCallbacks(this.j);
        }
    }
}
