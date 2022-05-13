package com.repackage;

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
import java.util.List;
/* loaded from: classes7.dex */
public class ww6 implements gw6, View.OnClickListener, vm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LowFlowsActivity b;
    public fw6 c;
    public kw6 d;
    public String e;
    public String f;
    public String g;
    public int h;
    public View i;
    public ImageView j;
    public ImageView k;
    public NavigationBar l;
    public BdTypeRecyclerView m;
    public View n;
    public ImageView o;
    public TextView p;
    public CollapsingToolbarLayout q;
    public View r;
    public View s;
    public AppBarLayout t;
    public TextView u;
    public RelativeLayout v;
    public AppBarLayout.OnOffsetChangedListener w;

    /* loaded from: classes7.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww6 a;

        public a(ww6 ww6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww6Var;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                int totalScrollRange = appBarLayout.getTotalScrollRange() - this.a.i();
                if (totalScrollRange <= 0) {
                    return;
                }
                float abs = Math.abs(i * 1.0f) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (this.a.l == null || abs != 1.0f) {
                    WebPManager.setPureDrawable(this.a.o, R.drawable.obfuscated_res_0x7f0809df, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                    if (this.a.p != null) {
                        this.a.p.setAlpha(0.0f);
                    }
                    if (this.a.l.getBarBgView() != null) {
                        this.a.l.getBarBgView().setAlpha(0.0f);
                        return;
                    }
                    return;
                }
                if (this.a.l.getBarBgView() != null) {
                    this.a.l.getBarBgView().setAlpha(1.0f);
                }
                if (this.a.p != null) {
                    this.a.p.setAlpha(1.0f);
                }
                WebPManager.setPureDrawable(this.a.o, R.drawable.obfuscated_res_0x7f0809df, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public ww6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = "";
        this.h = 3;
        this.w = new a(this);
        this.a = tbPageContext;
        this.b = (LowFlowsActivity) tbPageContext.getPageActivity();
        this.c = new sw6(this);
        m();
        k();
    }

    @Override // com.repackage.vm4
    public void a(View view2, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            tw6.a("c14084", StringUtils.isNull(this.g) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), this.e);
        }
    }

    @Override // com.repackage.gw6
    public void b(int i) {
        View view2;
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            View view3 = this.r;
            if (view3 != null && view3.getParent() != null && (lowFlowsActivity = this.b) != null) {
                lowFlowsActivity.hideLoadingView(this.r);
                this.r.setVisibility(8);
            }
            if (this.b == null || (view2 = this.s) == null) {
                return;
            }
            view2.setVisibility(0);
            this.b.showNetRefreshView(this.s, "");
        }
    }

    @Override // com.repackage.vm4
    public void c(View view2, Object obj, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    public final BdUniqueId h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbPageContext tbPageContext = this.a;
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
            NavigationBar navigationBar = this.l;
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
            if (this.i == null && (tbPageContext = this.a) != null) {
                this.i = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0044, (ViewGroup) null);
            }
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public final void k() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.a.getPageActivity().setContentView(j());
        this.j = (ImageView) j().findViewById(R.id.obfuscated_res_0x7f090d30);
        this.k = (ImageView) j().findViewById(R.id.obfuscated_res_0x7f090d36);
        this.l = (NavigationBar) j().findViewById(R.id.obfuscated_res_0x7f091249);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) j().findViewById(R.id.obfuscated_res_0x7f091460);
        this.m = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
        this.m.setFadingEdgeLength(0);
        n(this.e);
        AppBarLayout appBarLayout = (AppBarLayout) j().findViewById(R.id.obfuscated_res_0x7f091246);
        this.t = appBarLayout;
        appBarLayout.addOnOffsetChangedListener(this.w);
        this.q = (CollapsingToolbarLayout) j().findViewById(R.id.obfuscated_res_0x7f091247);
        this.r = j().findViewById(R.id.obfuscated_res_0x7f091552);
        this.s = j().findViewById(R.id.obfuscated_res_0x7f091558);
        l();
        kw6 kw6Var = new kw6(this.a, this.m);
        this.d = kw6Var;
        kw6Var.e(h());
        this.d.d(this);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void l() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        int f = mi.f(tbPageContext.getPageActivity(), R.dimen.M_H_X008);
        this.v = new RelativeLayout(this.a.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.v.setPadding(0, f, 0, f);
        this.v.setLayoutParams(layoutParams);
        this.u = new TextView(this.a.getPageActivity());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.u.setLayoutParams(layoutParams2);
        this.u.setText(R.string.obfuscated_res_0x7f0f09e2);
        this.u.setBackgroundColor(0);
        this.v.addView(this.u);
    }

    @Override // com.repackage.gw6
    public void loadData() {
        LowFlowsActivity lowFlowsActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View view2 = this.s;
            if (view2 != null && view2.getParent() != null && (lowFlowsActivity = this.b) != null) {
                lowFlowsActivity.hideNetRefreshView(this.s);
                this.s.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null && bdTypeRecyclerView.getParent() != null) {
                this.m.setVisibility(8);
            }
            View view3 = this.r;
            if (view3 != null && this.b != null) {
                view3.setVisibility(0);
                this.b.showLoadingView(this.r);
            }
            ImageView imageView = this.k;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.k.setVisibility(8);
            }
            fw6 fw6Var = this.c;
            if (fw6Var != null) {
                fw6Var.a(h(), this.e, this.f, this.g);
            }
        }
    }

    public final void m() {
        TbPageContext tbPageContext;
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null || (intent = this.a.getPageActivity().getIntent()) == null) {
            return;
        }
        this.e = intent.getStringExtra("tab_code");
        this.f = intent.getStringExtra(LowFlowsActivityConfig.LF_USER);
        this.g = intent.getStringExtra(LowFlowsActivityConfig.LF_USER_TASKID);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Drawable[] a2 = uw6.a(str);
            if (a2 != null) {
                this.j.setImageDrawable(a2[0]);
                this.k.setImageDrawable(a2[1]);
            }
            o(uw6.b(str));
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            View addSystemImageButton = this.l.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.n = addSystemImageButton;
            this.o = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09249c);
            this.p = this.l.getCenterText();
            this.l.setCenterTextTitle(str);
        }
    }

    @Override // com.repackage.gw6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (this.h != i) {
                gs4 d = gs4.d(this.p);
                d.A(R.string.F_X02);
                d.z(R.dimen.T_X05);
                d.v(R.color.CAM_X0105);
                this.l.getBarBgView().setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                Drawable[] a2 = uw6.a(this.e);
                if (a2 != null) {
                    this.j.setImageDrawable(a2[0]);
                    this.k.setImageDrawable(a2[1]);
                }
                this.v.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
                gs4 d2 = gs4.d(this.u);
                d2.z(R.dimen.T_X08);
                d2.v(R.color.CAM_X0109);
                kw6 kw6Var = this.d;
                if (kw6Var != null) {
                    kw6Var.b();
                }
            }
            this.h = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view2) == null) || this.a == null || view2.getId() != R.id.obfuscated_res_0x7f09152c || this.a.getPageActivity() == null) {
            return;
        }
        this.a.getPageActivity().finish();
    }

    @Override // com.repackage.gw6
    public void setData(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            View view2 = this.r;
            if (view2 != null && this.b != null && view2.getParent() != null) {
                this.b.hideLoadingView(this.r);
                this.r.setVisibility(8);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(0);
            }
            ImageView imageView = this.k;
            if (imageView != null && imageView.getVisibility() == 8) {
                this.k.setVisibility(0);
            }
            for (ro roVar : list) {
                if (roVar instanceof br4) {
                    ((br4) roVar).getThreadData().mTabCode = this.e;
                }
            }
            kw6 kw6Var = this.d;
            if (kw6Var != null) {
                kw6Var.c(list);
            }
            this.m.setFooterView(this.v);
        }
    }
}
