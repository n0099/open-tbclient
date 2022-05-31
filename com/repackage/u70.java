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
import com.baidu.sofire.rp.service.Service;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.a80;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class u70 implements q90<v70> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public LiveSearchGuideView B;
    public String C;
    public d80 D;
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
    public a80.b R;
    public boolean S;
    public final BroadcastReceiver T;
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
    public a80 p;
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
        public final /* synthetic */ u70 a;

        public a(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.h
        public void a(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !ka0.a(bVar.a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    z70.e(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.a.I ? "chenjinshi" : "zhibopindao", liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.f().g().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.a);
                    return;
                }
                LiveFeedPageSdk.f().g().a(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0a0d));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public b(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
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
        public final /* synthetic */ u70 this$0;

        public c(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = u70Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.L();
                boolean b = NetWorkUtils.b(context);
                if (!b || this.this$0.M) {
                    this.this$0.M = b;
                    return;
                }
                this.this$0.M = true;
                if (this.this$0.K) {
                    LiveFeedPageSdk.m("网络变化: Tab 可用，Feed 刷新");
                    this.this$0.Q();
                    return;
                }
                LiveFeedPageSdk.m("网络变化: 全页面刷新");
                this.this$0.K();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a80.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public d(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
        }

        @Override // com.repackage.a80.b
        public void a(e80 e80Var, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, e80Var, map) == null) {
                if (e80Var == null) {
                    b(-100, "数据解析失败", map);
                } else if ("follow".equals(e80Var.d)) {
                    this.a.C(e80Var.f);
                } else {
                    this.a.x(e80Var);
                }
            }
        }

        @Override // com.repackage.a80.b
        public void b(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, map) == null) || map == null || TextUtils.isEmpty(map.get("resource")) || !TextUtils.equals("banner,tab,feed,follow,config", map.get("resource"))) {
                return;
            }
            e80 e80Var = new e80();
            e80Var.a("banner,tab,feed,follow,config", i, str);
            this.a.x(e80Var);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public e(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                u70 u70Var = this.a;
                u70Var.E(view2, u70Var.w);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public f(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
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
        public final /* synthetic */ u70 a;

        public g(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H(true);
                z70.w(this.a.c);
                LiveFeedPageSdk.f().q(this.a.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public h(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                u70 u70Var = this.a;
                u70Var.E(view2, u70Var.w);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public i(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
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
                int a = t80.a();
                if (this.a.i.getItem(a) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.a.i.getItem(a)).I0(false);
                }
                u70 u70Var = this.a;
                u70Var.O = u70Var.i.c(i).type;
                t80.c(i);
                if (this.a.i.getItem(i) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.a.i.getItem(i)).I0(true);
                }
                this.a.F(i);
                this.a.j.B(Config.TRACE_VISIT_RECENT_DAY);
                this.a.j.setScrollLineVisibility(i);
                this.a.i.b(i, true, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public j(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
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
        public final /* synthetic */ u70 a;

        public k(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                this.a.Z(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u70 a;

        public l(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u70Var;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                u70 u70Var = this.a;
                u70Var.a0(u70Var.r);
                if (this.a.p != null) {
                    this.a.p.g();
                }
            }
        }
    }

    public u70(Context context, int i2, FragmentManager fragmentManager, String str, String str2, boolean z, String str3, String str4, boolean z2) {
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
        this.R = new d(this);
        this.S = false;
        this.T = new c(this);
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
        t90.a().d(this, w70.class, this);
        t90.a().d(this, y70.class, this);
        t90.a().d(this, x70.class, this);
        J();
        a80 a80Var = new a80(this.c, this.I, this.a);
        this.p = a80Var;
        a80Var.i(this.R);
    }

    public final void A(d80 d80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d80Var) == null) {
            this.D = d80Var;
            if (d80Var != null) {
                this.J.b(d80Var.b * 1000);
                D(d80Var);
            }
        }
    }

    public final void B(e80 e80Var) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e80Var) == null) || e80Var == null) {
            return;
        }
        A(e80Var.i);
        W(e80Var.e);
        G(e80Var);
        F(t80.a());
        C(e80Var.f);
        if (this.Q && (appBarLayout = this.g) != null) {
            this.Q = false;
            appBarLayout.post(new b(this));
        }
        if ("haokan".equals(LiveFeedPageSdk.f().e())) {
            this.j.setCustomTextsSize(16);
        }
    }

    public final void C(g80 g80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g80Var) == null) {
            if (g80Var != null) {
                if (!ea0.c(g80Var.a)) {
                    this.n.o(g80Var.a);
                    this.l.setVisibility(0);
                } else {
                    this.n.o(new ArrayList());
                    this.l.setVisibility(8);
                }
            }
            X();
        }
    }

    public final void D(d80 d80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d80Var) == null) {
            if (!this.I && d80Var.c) {
                this.A.setVisibility(0);
                b0();
                z70.x(this.c);
                return;
            }
            this.A.setVisibility(8);
            H(false);
        }
    }

    public final void E(View view2, TextView textView) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, textView) == null) {
            d80 d80Var = this.D;
            if (d80Var != null && !TextUtils.isEmpty(d80Var.a)) {
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

    public final void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (!ea0.c(this.H)) {
                if (i2 >= 0 && i2 < this.H.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.H.get(i2).subTabList;
                    if (!ea0.c(list)) {
                        this.m.k(list, this.P);
                        d0();
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
            this.t.setMinimumHeight(o80.a(this.c, this.k.getVisibility() == 0 ? i3 : 42));
        }
    }

    public final void G(e80 e80Var) {
        i80 i80Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, e80Var) == null) || e80Var == null) {
            return;
        }
        t80.b();
        if (this.S || (i80Var = e80Var.g) == null || ea0.c(i80Var.c)) {
            return;
        }
        this.S = true;
        List<LiveTabEntity> list = e80Var.g.c;
        this.H = list;
        int y = y(list);
        this.i.m(this.H, e80Var.h, e80Var.i);
        this.j.setViewPager(this.h);
        if (!ea0.c(this.H)) {
            t80.c(y);
            this.h.setCurrentItem(y);
        }
        this.i.l(y);
        this.O = this.i.c(y).type;
        if (e80Var.g.d) {
            Context context = this.c;
            String str = this.a;
            String m2 = z70.m(this.I);
            i80 i80Var2 = e80Var.g;
            z70.p(context, str, m2, i80Var2.a, i80Var2.b, e80Var.c, e80Var.d, "", "", "", i80Var2.f, "tab", i80Var2.e, System.currentTimeMillis(), 1);
        }
    }

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            LiveSearchGuideView liveSearchGuideView = this.B;
            if (liveSearchGuideView != null) {
                liveSearchGuideView.setVisibility(8);
            }
            if (z) {
                q80.d("sp_search_guide_show", true);
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BannerView bannerView = new BannerView(this.c);
            this.q = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.q.setIndicatorGravity(81);
            this.q.setIndicatorMargin(0, 0, 0, (int) o80.b(this.c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) o80.b(this.c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) o80.b(this.c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) o80.b(this.c.getResources(), 6.0f));
            this.q.setAspectRatio(0.336f);
            this.q.setIsImmersion(this.I);
            this.q.setSource(this.a);
            this.q.setOnBannerClickListener(new a(this));
            this.o.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @SuppressLint({"InflateParams"})
    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0508, (ViewGroup) null);
            this.e = inflate;
            this.f = inflate.findViewById(R.id.obfuscated_res_0x7f091295);
            this.g = (AppBarLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09128e);
            this.o = (FrameLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091290);
            this.j = (SmartTabLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09129b);
            this.k = (RecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f09129c);
            this.l = (RecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f091296);
            this.t = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09128f);
            this.u = this.e.findViewById(R.id.obfuscated_res_0x7f091297);
            this.v = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091298);
            this.w = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091299);
            this.y = this.e.findViewById(R.id.obfuscated_res_0x7f09129a);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.e.findViewById(R.id.obfuscated_res_0x7f091263);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new e(this));
            ImageView imageView = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091264);
            this.z = imageView;
            imageView.setOnClickListener(new f(this));
            this.z.setVisibility(this.I ? 0 : 8);
            this.A = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091271);
            this.B = (LiveSearchGuideView) this.e.findViewById(R.id.obfuscated_res_0x7f091272);
            this.A.setOnClickListener(new g(this));
            if (this.I && da0.a()) {
                this.e.setPadding(0, da0.d(this.c), 0, 0);
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
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.e.findViewById(R.id.obfuscated_res_0x7f09129d);
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
                    recyclerView.setPadding(0, o80.a(this.c, 15.0f), 0, o80.a(this.c, 12.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, o80.a(this.c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.c, this.I, this.a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            I();
            LoadingView loadingView = (LoadingView) this.e.findViewById(R.id.obfuscated_res_0x7f091293);
            this.r = loadingView;
            loadingView.c(this.I);
            a0(this.r);
            ErrorView errorView = (ErrorView) this.e.findViewById(R.id.obfuscated_res_0x7f091291);
            this.s = errorView;
            errorView.setActionCallback(new l(this));
            O(Config.TRACE_VISIT_RECENT_DAY);
        }
    }

    public void K() {
        a80 a80Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (a80Var = this.p) == null) {
            return;
        }
        a80Var.g();
    }

    public final void L() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.e(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void M() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.f(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void N() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.g(nestedNoScrollViewPager.getCurrentItem());
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundColor(va0.e().a(this.c, this.I, "color_white1"));
            }
            View view3 = this.u;
            if (view3 != null) {
                view3.setBackgroundColor(va0.e().a(this.c, this.I, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(va0.e().a(this.c, this.I, "color_1F1F1F"));
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
                imageView.setImageResource(va0.e().n());
            }
            LiveSearchGuideView liveSearchGuideView = this.B;
            if (liveSearchGuideView != null) {
                liveSearchGuideView.b(str);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            t90.a().e(this);
            c0();
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.s();
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.a();
            }
            this.F = true;
            t80.b();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.i();
            }
            this.N = false;
            g90.d(String.valueOf(this.b));
        }
    }

    public void Q() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.b(nestedNoScrollViewPager.getCurrentItem(), true, true);
    }

    public final void R() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null) {
            return;
        }
        baiduLiveTabAdapter.j(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void S() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        NestedNoScrollViewPager nestedNoScrollViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
                a80 a80Var = this.p;
                if (a80Var != null && !this.F) {
                    a80Var.f();
                }
            }
            this.F = false;
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.d();
            }
            v();
            M();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.e();
            }
            w();
            N();
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            LiveFeedPageSdk.m("onUserVisibleHint " + this.F + " " + z);
            if (this.E == z) {
                return;
            }
            this.E = z;
            if (z) {
                S();
                Y();
                return;
            }
            R();
            c0();
        }
    }

    public final void W(c80 c80Var) {
        BannerView bannerView;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, c80Var) == null) || (bannerView = this.q) == null || (frameLayout = this.o) == null) {
            return;
        }
        if (this.I) {
            frameLayout.setVisibility(8);
            this.q.setVisibility(8);
            v();
            this.G = false;
            return;
        }
        if (c80Var != null) {
            if (!ea0.c(c80Var.a)) {
                List<LiveBannerEntity> list = c80Var.a;
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

    public final void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.u == null) {
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

    public final void Y() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (context = this.c) == null || this.L) {
            return;
        }
        this.M = NetWorkUtils.b(context);
        LiveFeedPageSdk.m("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.c.registerReceiver(this.T, intentFilter);
        this.L = true;
    }

    public final void Z(int i2) {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
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
            d0();
            if (e2 != i2) {
                this.i.k(this.h.getCurrentItem());
            }
            this.i.b(this.h.getCurrentItem(), true, e2 == i2);
        }
    }

    public void a0(View view2) {
        ErrorView errorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
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

    public final void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || q80.a("sp_search_guide_show", false)) {
            return;
        }
        this.B.setVisibility(0);
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.c != null && this.L) {
            LiveFeedPageSdk.m("解注册网络变化广播");
            this.c.unregisterReceiver(this.T);
            this.L = false;
        }
    }

    public final void d0() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (baiduLiveTabAdapter = this.i) == null || (nestedNoScrollViewPager = this.h) == null || (c2 = baiduLiveTabAdapter.c(nestedNoScrollViewPager.getCurrentItem())) == null || TextUtils.isEmpty(c2.type)) {
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

    public final void v() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (bannerView = this.q) == null) {
            return;
        }
        bannerView.t();
    }

    public final void w() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (bannerView = this.q) != null && this.G) {
            bannerView.u();
        }
    }

    public final void x(e80 e80Var) {
        i80 i80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, e80Var) == null) {
            if (e80Var != null && (i80Var = e80Var.g) != null && !ea0.c(i80Var.c)) {
                B(e80Var);
                a0(this.f);
                this.K = true;
                if (e80Var.g.d) {
                    return;
                }
                this.J.c();
                return;
            }
            a0(this.s);
            this.K = false;
        }
    }

    public final int y(List<LiveTabEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, list)) == null) {
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

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.e : (View) invokeV.objValue;
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
            this.a = Service.TRIGGER_INTERVAL;
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
    @Override // com.repackage.q90
    public void call(v70 v70Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, v70Var) == null) && v70Var != null && v70Var.a() == this.b) {
            LiveFeedPageSdk.m("LiveEventBus event: " + v70Var.getClass() + GlideException.IndentedAppendable.INDENT + v70Var.a());
            if (v70Var instanceof w70) {
                c80 c80Var = ((w70) v70Var).b;
                if (c80Var != null) {
                    W(c80Var);
                }
            } else if (v70Var instanceof y70) {
                g80 g80Var = ((y70) v70Var).b;
                if (g80Var != null) {
                    C(g80Var);
                }
            } else if (v70Var instanceof x70) {
                this.J.c();
            }
        }
    }
}
