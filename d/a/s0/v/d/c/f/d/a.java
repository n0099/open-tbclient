package d.a.s0.v.d.c.f.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67567a;

    /* renamed from: b  reason: collision with root package name */
    public View f67568b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f67569c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f67570d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f67571e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f67572f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.f0.g f67573g;

    /* renamed from: h  reason: collision with root package name */
    public View f67574h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.v.d.c.f.a.a f67575i;
    public f j;
    public AlphaAnimation k;
    public AlphaAnimation l;
    public RecyclerView.OnScrollListener m;

    /* renamed from: d.a.s0.v.d.c.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1797a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67576e;

        public C1797a(a aVar) {
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
            this.f67576e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f67576e.j == null) {
                return;
            }
            this.f67576e.j.onScrollToBottom();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67577e;

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
            this.f67577e = aVar;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f67577e.j == null) {
                return;
            }
            this.f67577e.j.onListPullRefresh(z);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67578e;

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
            this.f67578e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f67578e.f67567a == null || this.f67578e.f67567a.getPageActivity() == null) {
                return;
            }
            this.f67578e.f67567a.getPageActivity().finish();
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67579a;

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
            this.f67579a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f67579a.f67574h.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f67580a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f67581b;

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
            this.f67581b = aVar;
            this.f67580a = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) || this.f67580a == i2) {
                return;
            }
            this.f67580a = i2;
            if (i2 != 1) {
                if (this.f67581b.n(recyclerView)) {
                    this.f67581b.e();
                    return;
                } else {
                    this.f67581b.s();
                    return;
                }
            }
            this.f67581b.s();
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new e(this);
        this.f67567a = tbPageContext;
        this.f67568b = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k()) {
            if (this.l == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.l = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.l.setDuration(300L);
                this.l.setAnimationListener(new d(this));
            }
            this.f67574h.startAnimation(this.l);
        }
    }

    public RelativeLayout f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67570d : (RelativeLayout) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67570d : (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67568b : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f67568b.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
            this.f67569c = navigationBar;
            navigationBar.setCenterTextTitle(this.f67567a.getResources().getString(R.string.live_tab_my_concern));
            this.f67569c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i();
            this.f67570d = (RelativeLayout) this.f67568b.findViewById(R.id.ala_live_tab_my_concern_container);
            this.f67574h = this.f67568b.findViewById(R.id.divider_shadow);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f67568b.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
            this.f67571e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f67567a.getPageActivity()));
            this.f67571e.setFadingEdgeLength(0);
            this.f67571e.setOverScrollMode(2);
            this.f67571e.addOnScrollListener(this.m);
            this.f67571e.setOnSrollToBottomListener(new C1797a(this));
            d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(this.f67567a);
            this.f67573g = gVar;
            gVar.a(new b(this));
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f67568b.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
            this.f67572f = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f67573g);
            d.a.s0.v.d.c.f.a.a aVar = new d.a.s0.v.d.c.f.a.a(this.f67567a);
            this.f67575i = aVar;
            this.f67571e.a(aVar.a());
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67574h.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            NavigationBar navigationBar = this.f67569c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f67567a, i2);
            }
            SkinManager.setBackgroundColor(this.f67568b, R.color.CAM_X0201);
            d.a.r0.r.f0.g gVar = this.f67573g;
            if (gVar != null) {
                gVar.I(i2);
            }
            SkinManager.setBackgroundColor(this.f67572f, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f67571e, R.color.CAM_X0201);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f67571e.removeOnScrollListener(this.m);
            this.f67571e.setOnSrollToBottomListener(null);
            this.f67571e.setScrollable(null);
            d.a.r0.r.f0.g gVar = this.f67573g;
            if (gVar != null) {
                gVar.a(null);
                this.f67573g.Y();
            }
        }
    }

    public final boolean n(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void o(Class<? extends BaseCardInfo> cls) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, cls) == null) || (bdTypeRecyclerView = this.f67571e) == null) {
            return;
        }
        for (int count = bdTypeRecyclerView.getCount() - 1; count >= 0; count--) {
            n B = this.f67571e.B(count);
            if (B != null && B.getClass().equals(cls)) {
                this.f67571e.D(count);
            }
        }
    }

    public void p(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f67571e.setData(list);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || z) {
            return;
        }
        this.f67572f.setRefreshing(false);
    }

    public void r(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.j = fVar;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || k()) {
            return;
        }
        this.f67574h.setVisibility(0);
        if (this.k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.k.setDuration(300L);
        }
        this.f67574h.startAnimation(this.k);
    }
}
