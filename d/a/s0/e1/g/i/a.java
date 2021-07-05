package d.a.s0.e1.g.i;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.lowFlows.LowFlowsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.m.f;
import d.a.r0.r.q.a2;
import d.a.s0.e1.g.b;
import d.a.s0.e1.g.c;
import d.a.s0.e1.g.d.d;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements c, View.OnClickListener, f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AppBarLayout.OnOffsetChangedListener A;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f58699e;

    /* renamed from: f  reason: collision with root package name */
    public LowFlowsActivity f58700f;

    /* renamed from: g  reason: collision with root package name */
    public b f58701g;

    /* renamed from: h  reason: collision with root package name */
    public d f58702h;

    /* renamed from: i  reason: collision with root package name */
    public String f58703i;
    public String j;
    public String k;
    public int l;
    public View m;
    public ImageView n;
    public ImageView o;
    public NavigationBar p;
    public BdTypeRecyclerView q;
    public View r;
    public ImageView s;
    public TextView t;
    public CollapsingToolbarLayout u;
    public View v;
    public View w;
    public AppBarLayout x;
    public TextView y;
    public RelativeLayout z;

    /* renamed from: d.a.s0.e1.g.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1387a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58704a;

        public C1387a(a aVar) {
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
            this.f58704a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                int totalScrollRange = appBarLayout.getTotalScrollRange() - this.f58704a.i();
                if (totalScrollRange <= 0) {
                    return;
                }
                float abs = Math.abs(i2 * 1.0f) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (this.f58704a.p == null || abs != 1.0f) {
                    WebPManager.setPureDrawable(this.f58704a.s, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                    if (this.f58704a.t != null) {
                        this.f58704a.t.setAlpha(0.0f);
                    }
                    if (this.f58704a.p.getBarBgView() != null) {
                        this.f58704a.p.getBarBgView().setAlpha(0.0f);
                        return;
                    }
                    return;
                }
                if (this.f58704a.p.getBarBgView() != null) {
                    this.f58704a.p.getBarBgView().setAlpha(1.0f);
                }
                if (this.f58704a.t != null) {
                    this.f58704a.t.setAlpha(1.0f);
                }
                WebPManager.setPureDrawable(this.f58704a.s, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
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
        this.k = "";
        this.l = 3;
        this.A = new C1387a(this);
        this.f58699e = tbPageContext;
        this.f58700f = (LowFlowsActivity) tbPageContext.getPageActivity();
        this.f58701g = new d.a.s0.e1.g.g.a(this);
        m();
        k();
    }

    @Override // d.a.r0.m.f
    public void a(View view, Object obj, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            d.a.s0.e1.g.h.a.a("c14084", StringUtils.isNull(this.k) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), this.f58703i);
        }
    }

    @Override // d.a.s0.e1.g.c
    public void b(int i2) {
        View view;
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            View view2 = this.v;
            if (view2 != null && view2.getParent() != null && (lowFlowsActivity = this.f58700f) != null) {
                lowFlowsActivity.hideLoadingView(this.v);
                this.v.setVisibility(8);
            }
            if (this.f58700f == null || (view = this.w) == null) {
                return;
            }
            view.setVisibility(0);
            this.f58700f.showNetRefreshView(this.w, "");
        }
    }

    @Override // d.a.r0.m.f
    public void c(View view, Object obj, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
        }
    }

    public final BdUniqueId h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbPageContext tbPageContext = this.f58699e;
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            NavigationBar navigationBar = this.p;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public View j() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.m == null && (tbPageContext = this.f58699e) != null) {
                this.m = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.activity_low_flows, (ViewGroup) null);
            }
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tbPageContext = this.f58699e) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f58699e.getPageActivity().setContentView(j());
        this.n = (ImageView) j().findViewById(R.id.header_img);
        this.o = (ImageView) j().findViewById(R.id.header_shadow);
        this.p = (NavigationBar) j().findViewById(R.id.lf_navigation_bar);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) j().findViewById(R.id.more_treasure_trove_content);
        this.q = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f58699e.getPageActivity()));
        this.q.setFadingEdgeLength(0);
        n(this.f58703i);
        AppBarLayout appBarLayout = (AppBarLayout) j().findViewById(R.id.lf_app_bar_layout);
        this.x = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.A);
        this.u = (CollapsingToolbarLayout) j().findViewById(R.id.lf_collapse_layout);
        this.v = j().findViewById(R.id.net_loading_view);
        this.w = j().findViewById(R.id.net_refresh_view);
        l();
        d dVar = new d(this.f58699e, this.q);
        this.f58702h = dVar;
        dVar.e(h());
        this.f58702h.d(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void l() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbPageContext = this.f58699e) == null) {
            return;
        }
        int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.M_H_X008);
        this.z = new RelativeLayout(this.f58699e.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.z.setPadding(0, g2, 0, g2);
        this.z.setLayoutParams(layoutParams);
        this.y = new TextView(this.f58699e.getPageActivity());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.y.setLayoutParams(layoutParams2);
        this.y.setText(R.string.lf_footer_no_more);
        this.y.setBackgroundColor(0);
        this.z.addView(this.y);
    }

    @Override // d.a.s0.e1.g.c
    public void loadData() {
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view = this.w;
            if (view != null && view.getParent() != null && (lowFlowsActivity = this.f58700f) != null) {
                lowFlowsActivity.hideNetRefreshView(this.w);
                this.w.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.q;
            if (bdTypeRecyclerView != null && bdTypeRecyclerView.getParent() != null) {
                this.q.setVisibility(8);
            }
            View view2 = this.v;
            if (view2 != null && this.f58700f != null) {
                view2.setVisibility(0);
                this.f58700f.showLoadingView(this.v);
            }
            ImageView imageView = this.o;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.o.setVisibility(8);
            }
            b bVar = this.f58701g;
            if (bVar != null) {
                bVar.a(h(), this.f58703i, this.j, this.k);
            }
        }
    }

    public final void m() {
        TbPageContext tbPageContext;
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.f58699e) == null || tbPageContext.getPageActivity() == null || (intent = this.f58699e.getPageActivity().getIntent()) == null) {
            return;
        }
        this.f58703i = intent.getStringExtra(LowFlowsActivityConfig.TAB_CODE);
        this.j = intent.getStringExtra(LowFlowsActivityConfig.LF_USER);
        this.k = intent.getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Drawable[] a2 = d.a.s0.e1.g.h.b.a(str);
            if (a2 != null) {
                this.n.setImageDrawable(a2[0]);
                this.o.setImageDrawable(a2[1]);
            }
            o(d.a.s0.e1.g.h.b.b(str));
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            View addSystemImageButton = this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.r = addSystemImageButton;
            this.s = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            this.t = this.p.getCenterText();
            this.p.setCenterTextTitle(str);
        }
    }

    @Override // d.a.s0.e1.g.c
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.l != i2) {
                d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.t);
                d2.y(R.string.F_X02);
                d2.x(R.dimen.T_X05);
                d2.t(R.color.CAM_X0105);
                this.p.getBarBgView().setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                Drawable[] a2 = d.a.s0.e1.g.h.b.a(this.f58703i);
                if (a2 != null) {
                    this.n.setImageDrawable(a2[0]);
                    this.o.setImageDrawable(a2[1]);
                }
                this.z.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                d.a.r0.r.u.c d3 = d.a.r0.r.u.c.d(this.y);
                d3.x(R.dimen.T_X08);
                d3.t(R.color.CAM_X0109);
                d dVar = this.f58702h;
                if (dVar != null) {
                    dVar.b();
                }
            }
            this.l = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f58699e == null || view.getId() != R.id.navigationBarGoBack || this.f58699e.getPageActivity() == null) {
            return;
        }
        this.f58699e.getPageActivity().finish();
    }

    @Override // d.a.s0.e1.g.c
    public void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            View view = this.v;
            if (view != null && this.f58700f != null && view.getParent() != null) {
                this.f58700f.hideLoadingView(this.v);
                this.v.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.q;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(0);
            }
            ImageView imageView = this.o;
            if (imageView != null && imageView.getVisibility() == 8) {
                this.o.setVisibility(0);
            }
            for (n nVar : list) {
                if (nVar instanceof a2) {
                    ((a2) nVar).getThreadData().e2 = this.f58703i;
                }
            }
            d dVar = this.f58702h;
            if (dVar != null) {
                dVar.c(list);
            }
            this.q.setFooterView(this.z);
        }
    }
}
