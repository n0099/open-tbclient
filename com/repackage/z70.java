package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.BaiduLiveTabAdapter;
import com.baidu.live.business.adapter.LiveFeedPageConcernAdapter;
import com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.util.NetWorkUtils;
import com.baidu.live.business.view.FakeStartLiveButton;
import com.baidu.live.business.view.banner.BannerEntity;
import com.baidu.live.business.view.banner.BannerView;
import com.baidu.live.business.view.emotion.ErrorView;
import com.baidu.live.business.view.emotion.LoadingView;
import com.baidu.live.business.view.search.LiveSearchGuideView;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.live.business.view.viewpager.NestedNoScrollViewPager;
import com.baidu.live.framework.appbar.AppBarLayout;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.f80;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class z70 implements x90<a80> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public LiveSearchGuideView B;
    public String C;
    public i80 D;
    public boolean E;
    public boolean F;
    public boolean G;
    public List<LiveTabEntity> H;
    public boolean I;
    public m J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public f80.b S;
    public boolean T;
    public final BroadcastReceiver U;
    public final String a;
    public final int b;
    public Context c;
    public FragmentManager d;
    public View e;
    public View f;
    public AppBarLayout g;
    public NestedNoScrollViewPager h;
    public BaiduLiveTabAdapter i;
    public SmartTabLayout j;
    public RecyclerView k;
    public RecyclerView l;
    public LiveFeedPageSubTipAdapter m;
    public LiveFeedPageConcernAdapter n;
    public FrameLayout o;
    public f80 p;
    public BannerView q;
    public LoadingView r;
    public ErrorView s;
    public LinearLayout t;
    public View u;
    public LinearLayout v;
    public TextView w;
    public FakeStartLiveButton x;
    public View y;
    public ImageView z;

    /* loaded from: classes7.dex */
    public class a implements BannerView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public a(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.h
        public void a(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !ta0.a(bVar.a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    e80.f(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.a.I ? "chenjinshi" : "zhibopindao", liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.f().g().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.a);
                    return;
                }
                LiveFeedPageSdk.f().g().a(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f09ea));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public b(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g == null) {
                return;
            }
            this.a.g.setExpanded(false, false);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 this$0;

        public c(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = z70Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.R();
                boolean b = NetWorkUtils.b(context);
                if (!b || this.this$0.M) {
                    this.this$0.M = b;
                    return;
                }
                this.this$0.M = true;
                if (this.this$0.K) {
                    LiveFeedPageSdk.m("网络变化: Tab 可用，Feed 刷新");
                    this.this$0.W();
                    return;
                }
                LiveFeedPageSdk.m("网络变化: 全页面刷新");
                this.this$0.Q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f80.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public d(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // com.repackage.f80.b
        public void a(j80 j80Var, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, j80Var, map) == null) {
                if (j80Var == null) {
                    b(-100, "数据解析失败", map);
                } else if (PersonListActivityConfig.FOLLOW.equals(j80Var.d)) {
                    this.a.H(j80Var.f);
                } else {
                    this.a.y(j80Var);
                }
            }
        }

        @Override // com.repackage.f80.b
        public void b(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, map) == null) || map == null || TextUtils.isEmpty(map.get("resource")) || !TextUtils.equals("banner,tab,feed,follow,config", map.get("resource"))) {
                return;
            }
            j80 j80Var = new j80();
            j80Var.a("banner,tab,feed,follow,config", i, str);
            this.a.y(j80Var);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public e(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                z70 z70Var = this.a;
                z70Var.J(view2, z70Var.w);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public f(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.c instanceof Activity) && !((Activity) this.a.c).isFinishing()) {
                ((Activity) this.a.c).finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public g(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.M(true);
                e80.x(this.a.c);
                LiveFeedPageSdk.f().q(this.a.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public h(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                z70 z70Var = this.a;
                z70Var.J(view2, z70Var.w);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public i(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                LiveFeedPageSdk.m("二级 tab 滑动/点击切换：" + i);
                int a = y80.a();
                if (this.a.i.getItem(a) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.a.i.getItem(a)).w1(false);
                }
                z70 z70Var = this.a;
                z70Var.O = z70Var.i.c(i).type;
                y80.c(i);
                if (this.a.i.getItem(i) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.a.i.getItem(i)).w1(true);
                }
                this.a.K(i);
                this.a.j.B(Config.TRACE_VISIT_RECENT_DAY);
                this.a.j.setScrollLineVisibility(i);
                this.a.i.b(i, true, true);
                this.a.R = i == 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public j(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                LiveFeedPageSdk.m("二级 tab 点击：" + i + "   current：" + this.a.h.getCurrentItem());
                if (this.a.h.getCurrentItem() == i) {
                    this.a.i.b(i, true, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public k(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                this.a.f0(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z70 a;

        public l(z70 z70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z70Var;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                z70 z70Var = this.a;
                z70Var.g0(z70Var.r);
                if (this.a.p != null) {
                    this.a.p.f();
                }
            }
        }
    }

    public z70(Context context, int i2, FragmentManager fragmentManager, String str, String str2, boolean z, String str3, String str4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), fragmentManager, str, str2, Boolean.valueOf(z), str3, str4, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = true;
        this.G = false;
        this.H = new ArrayList();
        this.J = new m(null);
        this.N = false;
        this.R = true;
        this.S = new d(this);
        this.T = false;
        this.U = new c(this);
        this.c = context;
        this.a = str2;
        this.d = fragmentManager;
        this.C = str;
        this.O = str3;
        this.P = str4;
        this.Q = z2;
        this.N = z;
        this.J.b = System.currentTimeMillis();
        this.I = "immersion".equals(this.C);
        this.b = i2;
        aa0.a().d(this, b80.class, this);
        aa0.a().d(this, d80.class, this);
        aa0.a().d(this, c80.class, this);
        O();
        f80 f80Var = new f80(this.I, this.a);
        this.p = f80Var;
        f80Var.h(this.S);
    }

    public RecyclerView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (RecyclerView) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public RecyclerView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (RecyclerView) invokeV.objValue;
    }

    public SmartTabLayout D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (SmartTabLayout) invokeV.objValue;
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    public final void F(i80 i80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, i80Var) == null) {
            this.D = i80Var;
            if (i80Var != null) {
                this.J.b(i80Var.b * 1000);
                I(i80Var);
            }
        }
    }

    public final void G(j80 j80Var) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, j80Var) == null) || j80Var == null) {
            return;
        }
        F(j80Var.i);
        c0(j80Var.e);
        L(j80Var);
        K(y80.a());
        H(j80Var.f);
        if (this.Q && (appBarLayout = this.g) != null) {
            this.Q = false;
            appBarLayout.post(new b(this));
        }
        if ("haokan".equals(LiveFeedPageSdk.f().e())) {
            this.j.setCustomTextsSize(16);
        }
    }

    public final void H(l80 l80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, l80Var) == null) {
            if (l80Var != null) {
                if (!na0.c(l80Var.a)) {
                    this.n.o(l80Var.a);
                    this.l.setVisibility(0);
                } else {
                    this.n.o(new ArrayList());
                    this.l.setVisibility(8);
                }
            }
            d0();
        }
    }

    public final void I(i80 i80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i80Var) == null) {
            if (!this.I && i80Var.c) {
                this.A.setVisibility(0);
                h0();
                e80.y(this.c);
                return;
            }
            this.A.setVisibility(8);
            M(false);
        }
    }

    public final void J(View view2, TextView textView) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, textView) == null) {
            i80 i80Var = this.D;
            if (i80Var != null && !TextUtils.isEmpty(i80Var.a)) {
                c2 = this.D.a;
            } else {
                c2 = LiveFeedPageSdk.f().c();
            }
            if (LiveFeedPageSdk.f().d() != null) {
                LiveFeedPageSdk.f().d().a(view2, textView, c2);
            } else if (LiveFeedPageSdk.f().g() != null) {
                LiveFeedPageSdk.f().g().invokeScheme(this.c, c2);
            }
        }
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (!na0.c(this.H)) {
                if (i2 >= 0 && i2 < this.H.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.H.get(i2).subTabList;
                    if (!na0.c(list)) {
                        this.m.k(list, this.P);
                        j0();
                        this.k.setVisibility(0);
                    } else {
                        this.k.setVisibility(8);
                    }
                }
            } else {
                this.k.setVisibility(8);
            }
            int i3 = this.I ? 93 : 81;
            boolean z = this.I;
            this.t.setMinimumHeight(t80.a(this.c, this.k.getVisibility() == 0 ? i3 : 42));
        }
    }

    public final void L(j80 j80Var) {
        n80 n80Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, j80Var) == null) || j80Var == null) {
            return;
        }
        y80.b();
        if (this.T || (n80Var = j80Var.g) == null || na0.c(n80Var.c)) {
            return;
        }
        this.T = true;
        List<LiveTabEntity> list = j80Var.g.c;
        this.H = list;
        int z = z(list);
        this.i.m(this.H, j80Var.h, j80Var.i);
        this.j.setViewPager(this.h);
        if (!na0.c(this.H)) {
            y80.c(z);
            this.h.setCurrentItem(z);
        }
        this.i.l(z);
        this.O = this.i.c(z).type;
        if (j80Var.g.d) {
            Context context = this.c;
            String str = this.a;
            String n = e80.n(this.I);
            n80 n80Var2 = j80Var.g;
            e80.q(context, str, n, n80Var2.a, n80Var2.b, j80Var.c, j80Var.d, "", "", "", n80Var2.f, "tab", n80Var2.e, System.currentTimeMillis(), 1);
        }
    }

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            LiveSearchGuideView liveSearchGuideView = this.B;
            if (liveSearchGuideView != null) {
                liveSearchGuideView.setVisibility(8);
            }
            if (z) {
                v80.d("sp_search_guide_show", true);
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BannerView bannerView = new BannerView(this.c);
            this.q = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.q.setIndicatorGravity(81);
            this.q.setIndicatorMargin(0, 0, 0, (int) t80.b(this.c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) t80.b(this.c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) t80.b(this.c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) t80.b(this.c.getResources(), 6.0f));
            this.q.setAspectRatio(0.336f);
            this.q.setIsImmersion(this.I);
            this.q.setSource(this.a);
            this.q.setOnBannerClickListener(new a(this));
            this.o.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @SuppressLint({"InflateParams"})
    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0528, (ViewGroup) null);
            this.e = inflate;
            this.f = inflate.findViewById(R.id.obfuscated_res_0x7f091309);
            this.g = (AppBarLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091302);
            this.o = (FrameLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091304);
            this.j = (SmartTabLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09130f);
            this.k = (RecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f091310);
            this.l = (RecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f09130a);
            this.t = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091303);
            this.u = this.e.findViewById(R.id.obfuscated_res_0x7f09130b);
            this.v = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09130c);
            this.w = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09130d);
            this.y = this.e.findViewById(R.id.obfuscated_res_0x7f09130e);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.e.findViewById(R.id.obfuscated_res_0x7f0912d5);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new e(this));
            ImageView imageView = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f0912d6);
            this.z = imageView;
            imageView.setOnClickListener(new f(this));
            this.z.setVisibility(this.I ? 0 : 8);
            this.A = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f0912e3);
            this.B = (LiveSearchGuideView) this.e.findViewById(R.id.obfuscated_res_0x7f0912e4);
            this.A.setOnClickListener(new g(this));
            if (this.I && ma0.a()) {
                this.e.setPadding(0, ma0.d(this.c), 0, 0);
            }
            this.v.setVisibility((!"haokan".equals(LiveFeedPageSdk.f().e()) || this.I || this.N) ? 8 : 0);
            this.v.setOnClickListener(new h(this));
            this.y.setVisibility(this.I ? 0 : 8);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager.setOrientation(0);
            this.k.setLayoutManager(staggeredGridLayoutManager);
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager2.setOrientation(0);
            this.l.setLayoutManager(staggeredGridLayoutManager2);
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.e.findViewById(R.id.obfuscated_res_0x7f091311);
            this.h = nestedNoScrollViewPager;
            nestedNoScrollViewPager.setId(View.generateViewId());
            this.h.setOffscreenPageLimit(1);
            this.h.setSaveEnabled(false);
            if ("immersion".equals(this.C)) {
                this.h.setCanScrollHorizontally(true);
            }
            this.j.setOnPageChangeListener(new i(this));
            this.j.setOnTabClickListener(new j(this));
            BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.d, this.b, this.I, this.a, this.P);
            this.i = baiduLiveTabAdapter;
            this.h.setAdapter(baiduLiveTabAdapter);
            this.j.setAllTabIsBold(false);
            this.j.setTabSelectedColorEnable(true);
            this.j.setShowBottomLine(this.I);
            if (this.I) {
                this.j.setDarkModeCompatColor("color_white3", "color_1F1F1F");
            } else {
                this.j.setDarkModeCompatColor("color_FF33551", "color_1F1F1F");
            }
            if ("haokan".equals(LiveFeedPageSdk.f().e())) {
                this.j.setShowBottomLine(true);
                this.j.setSelectedIndicatorColors(Color.parseColor("#222222"));
                this.j.setDarkModeCompatColor("color_2222222", "color_888888");
            }
            this.j.setIsImmersion(this.I);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(this.c, this.I);
            this.m = liveFeedPageSubTipAdapter;
            liveFeedPageSubTipAdapter.i(new k(this));
            this.k.setAdapter(this.m);
            if (this.I) {
                RecyclerView recyclerView = this.k;
                if (recyclerView != null) {
                    recyclerView.setPadding(0, t80.a(this.c, 15.0f), 0, t80.a(this.c, 12.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, t80.a(this.c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.c, this.I, this.a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            N();
            LoadingView loadingView = (LoadingView) this.e.findViewById(R.id.obfuscated_res_0x7f091307);
            this.r = loadingView;
            loadingView.c(this.I);
            g0(this.r);
            ErrorView errorView = (ErrorView) this.e.findViewById(R.id.obfuscated_res_0x7f091305);
            this.s = errorView;
            errorView.setActionCallback(new l(this));
            U(Config.TRACE_VISIT_RECENT_DAY);
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.R : invokeV.booleanValue;
    }

    public void Q() {
        f80 f80Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (f80Var = this.p) == null) {
            return;
        }
        f80Var.f();
    }

    public final void R() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.e(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void S() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.f(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void T() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.g(nestedNoScrollViewPager.getCurrentItem());
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundColor(eb0.e().a(this.c, this.I, "color_white1"));
            }
            View view3 = this.u;
            if (view3 != null) {
                view3.setBackgroundColor(eb0.e().a(this.c, this.I, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(eb0.e().a(this.c, this.I, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.h(str);
            }
            ErrorView errorView = this.s;
            if (errorView != null) {
                errorView.c(this.I);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.c(this.I);
            }
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.r(str);
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.n;
            if (liveFeedPageConcernAdapter != null) {
                liveFeedPageConcernAdapter.notifyDataSetChanged();
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.m;
            if (liveFeedPageSubTipAdapter != null) {
                liveFeedPageSubTipAdapter.notifyDataSetChanged();
            }
            SmartTabLayout smartTabLayout = this.j;
            if (smartTabLayout != null) {
                smartTabLayout.B(str);
            }
            ImageView imageView = this.A;
            if (imageView != null) {
                imageView.setImageResource(eb0.e().n());
            }
            LiveSearchGuideView liveSearchGuideView = this.B;
            if (liveSearchGuideView != null) {
                liveSearchGuideView.b(str);
            }
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            aa0.a().e(this);
            i0();
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.s();
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.a();
            }
            this.F = true;
            y80.b();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.i();
            }
            f80 f80Var = this.p;
            if (f80Var != null) {
                f80Var.h(null);
            }
            this.N = false;
            n90.d(String.valueOf(this.b));
        }
    }

    public void W() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.b(nestedNoScrollViewPager.getCurrentItem(), true, true);
    }

    public final void X() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.j(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void Y() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        NestedNoScrollViewPager nestedNoScrollViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.i;
            if (baiduLiveTabAdapter != null && (nestedNoScrollViewPager2 = this.h) != null) {
                baiduLiveTabAdapter.k(nestedNoScrollViewPager2.getCurrentItem());
            }
            if (this.J.a()) {
                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.i;
                if (baiduLiveTabAdapter2 != null && (nestedNoScrollViewPager = this.h) != null) {
                    baiduLiveTabAdapter2.b(nestedNoScrollViewPager.getCurrentItem(), true, true);
                }
            } else {
                f80 f80Var = this.p;
                if (f80Var != null && !this.F) {
                    f80Var.e();
                }
            }
            this.F = false;
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.d();
            }
            w();
            S();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.e();
            }
            x();
            T();
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            LiveFeedPageSdk.m("onUserVisibleHint " + this.F + " " + z);
            if (this.E == z) {
                return;
            }
            this.E = z;
            if (z) {
                Y();
                e0();
                return;
            }
            X();
            i0();
        }
    }

    public final void c0(h80 h80Var) {
        BannerView bannerView;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, h80Var) == null) || (bannerView = this.q) == null || (frameLayout = this.o) == null) {
            return;
        }
        if (this.I) {
            frameLayout.setVisibility(8);
            this.q.setVisibility(8);
            w();
            this.G = false;
            return;
        }
        if (h80Var != null) {
            if (!na0.c(h80Var.a)) {
                List<LiveBannerEntity> list = h80Var.a;
                if (this.q.o(list)) {
                    BannerEntity bannerEntity = new BannerEntity();
                    bannerEntity.mBannerList = list;
                    bannerEntity.mBroadcastInterval = 5000;
                    this.q.setBannerEntity(bannerEntity);
                }
                this.q.setVisibility(0);
                this.G = true;
            } else {
                this.G = false;
                this.q.setVisibility(8);
            }
        } else {
            this.G = false;
            bannerView.setVisibility(8);
        }
        this.o.setVisibility(this.q.getVisibility() != 0 ? 8 : 0);
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.u == null) {
            return;
        }
        RecyclerView recyclerView = this.l;
        boolean z = true;
        if (recyclerView != null && recyclerView.getVisibility() != 0) {
            z = false;
        }
        if (z && !this.I) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public final void e0() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (context = this.c) == null || this.L) {
            return;
        }
        this.M = NetWorkUtils.b(context);
        LiveFeedPageSdk.m("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.c.registerReceiver(this.U, intentFilter);
        this.L = true;
    }

    public final void f0(int i2) {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            int e2 = this.m.e();
            LiveFeedPageSdk.m("三级 Tab 点击 pre: " + e2 + GlideException.IndentedAppendable.INDENT + i2);
            this.m.j(i2);
            this.m.notifyDataSetChanged();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.i;
            if (baiduLiveTabAdapter == null || (nestedNoScrollViewPager = this.h) == null) {
                return;
            }
            if (e2 != i2) {
                baiduLiveTabAdapter.j(nestedNoScrollViewPager.getCurrentItem());
            }
            j0();
            if (e2 != i2) {
                this.i.k(this.h.getCurrentItem());
            }
            this.i.b(this.h.getCurrentItem(), true, e2 == i2);
        }
    }

    public void g0(View view2) {
        ErrorView errorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
            ErrorView errorView2 = this.s;
            int i2 = 8;
            if (errorView2 != null) {
                errorView2.d(view2 == errorView2 ? 0 : 8, this.I);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.setVisibility(view2 == loadingView ? 0 : 8);
            }
            View view3 = this.f;
            if (view3 != null) {
                view3.setVisibility(view2 == view3 ? 0 : 4);
            }
            FakeStartLiveButton fakeStartLiveButton = this.x;
            if (fakeStartLiveButton == null || (errorView = this.s) == null) {
                return;
            }
            if (errorView.getVisibility() == 0 && "haokan".equals(LiveFeedPageSdk.f().e()) && !this.N) {
                i2 = 0;
            }
            fakeStartLiveButton.setVisibility(i2);
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || v80.a("sp_search_guide_show", false)) {
            return;
        }
        this.B.setVisibility(0);
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.c != null && this.L) {
            LiveFeedPageSdk.m("解注册网络变化广播");
            this.c.unregisterReceiver(this.U);
            this.L = false;
        }
    }

    public final void j0() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null || (c2 = baiduLiveTabAdapter.c(nestedNoScrollViewPager.getCurrentItem())) == null || TextUtils.isEmpty(c2.type)) {
            return;
        }
        LiveTabEntity.TabLabelInfo f2 = this.m.f();
        String str = f2.type;
        this.P = str;
        BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.i;
        String str2 = c2.type;
        if (f2 == null) {
            str = "";
        }
        baiduLiveTabAdapter2.n(str2, str, this.h.getCurrentItem());
    }

    public final void w() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (bannerView = this.q) == null) {
            return;
        }
        bannerView.t();
    }

    public final void x() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (bannerView = this.q) != null && this.G) {
            bannerView.u();
        }
    }

    public final void y(j80 j80Var) {
        n80 n80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, j80Var) == null) {
            if (j80Var != null && (n80Var = j80Var.g) != null && !na0.c(n80Var.c)) {
                G(j80Var);
                g0(this.f);
                this.K = true;
                if (j80Var.g.d) {
                    return;
                }
                this.J.c();
                return;
            }
            g0(this.s);
            this.K = false;
        }
    }

    public final int z(List<LiveTabEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, list)) == null) {
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                LiveTabEntity liveTabEntity = list.get(i4);
                if (liveTabEntity != null) {
                    if (!TextUtils.isEmpty(this.O) && i2 == 0 && this.O.equals(liveTabEntity.type)) {
                        LiveFeedPageSdk.m("scheme指定找到了二级Tab = " + liveTabEntity.name);
                        i2 = i4;
                    }
                    if (liveTabEntity.selected && i3 == 0) {
                        i3 = i4;
                    }
                }
            }
            return i2 != 0 ? i2 : i3;
        }
        return invokeL.intValue;
    }

    /* loaded from: classes7.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public long b;

        public m() {
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
            this.a = 180000L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LiveFeedPageSdk.m("onShow   " + (System.currentTimeMillis() - this.b));
                return System.currentTimeMillis() - this.b > this.a;
            }
            return invokeV.booleanValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j <= 0) {
                return;
            }
            this.a = j;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ m(d dVar) {
            this();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.x90
    public void call(a80 a80Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, a80Var) == null) && a80Var != null && a80Var.a() == this.b) {
            LiveFeedPageSdk.m("LiveEventBus event: " + a80Var.getClass() + GlideException.IndentedAppendable.INDENT + a80Var.a());
            if (a80Var instanceof b80) {
                h80 h80Var = ((b80) a80Var).b;
                if (h80Var != null) {
                    c0(h80Var);
                }
            } else if (a80Var instanceof d80) {
                l80 l80Var = ((d80) a80Var).b;
                if (l80Var != null) {
                    H(l80Var);
                }
            } else if (a80Var instanceof c80) {
                this.J.c();
            }
        }
    }
}
