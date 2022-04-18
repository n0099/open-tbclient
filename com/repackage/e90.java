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
import com.repackage.k90;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class e90 implements ab0<f90> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public LiveSearchGuideView B;
    public String C;
    public n90 D;
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
    public k90.b R;
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
    public k90 p;
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

    /* loaded from: classes5.dex */
    public class a implements BannerView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public a(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.h
        public void a(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !ub0.a(bVar.a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    j90.e(this.a.c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.a.I ? "chenjinshi" : "zhibopindao", liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.f().g().invokeScheme(this.a.c, liveBannerEntity.cmdInfo.a);
                    return;
                }
                LiveFeedPageSdk.f().g().a(this.a.c, this.a.c.getResources().getString(R.string.obfuscated_res_0x7f0f0a00));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public b(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
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

    /* loaded from: classes5.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 this$0;

        public c(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = e90Var;
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

    /* loaded from: classes5.dex */
    public class d implements k90.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public d(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // com.repackage.k90.b
        public void a(o90 o90Var, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, o90Var, map) == null) {
                if (o90Var == null) {
                    b(-100, "数据解析失败", map);
                } else if ("follow".equals(o90Var.d)) {
                    this.a.C(o90Var.f);
                } else {
                    this.a.x(o90Var);
                }
            }
        }

        @Override // com.repackage.k90.b
        public void b(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, map) == null) || map == null || TextUtils.isEmpty(map.get("resource")) || !TextUtils.equals("banner,tab,feed,follow,config", map.get("resource"))) {
                return;
            }
            o90 o90Var = new o90();
            o90Var.a("banner,tab,feed,follow,config", i, str);
            this.a.x(o90Var);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public e(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                e90 e90Var = this.a;
                e90Var.E(view2, e90Var.w);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public f(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.c instanceof Activity) && !((Activity) this.a.c).isFinishing()) {
                ((Activity) this.a.c).finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public g(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H(true);
                j90.w(this.a.c);
                LiveFeedPageSdk.f().q(this.a.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public h(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                e90 e90Var = this.a;
                e90Var.E(view2, e90Var.w);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public i(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
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
                int a = da0.a();
                if (this.a.i.getItem(a) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.a.i.getItem(a)).F0(false);
                }
                e90 e90Var = this.a;
                e90Var.O = e90Var.i.c(i).type;
                da0.c(i);
                if (this.a.i.getItem(i) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.a.i.getItem(i)).F0(true);
                }
                this.a.F(i);
                this.a.j.B(Config.TRACE_VISIT_RECENT_DAY);
                this.a.j.setScrollLineVisibility(i);
                this.a.i.b(i, true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public j(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
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

    /* loaded from: classes5.dex */
    public class k implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public k(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                this.a.Z(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e90 a;

        public l(e90 e90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e90Var;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                e90 e90Var = this.a;
                e90Var.a0(e90Var.r);
                if (this.a.p != null) {
                    this.a.p.g();
                }
            }
        }
    }

    public e90(Context context, int i2, FragmentManager fragmentManager, String str, String str2, boolean z, String str3, String str4, boolean z2) {
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
        db0.a().d(this, g90.class, this);
        db0.a().d(this, i90.class, this);
        db0.a().d(this, h90.class, this);
        J();
        k90 k90Var = new k90(this.c, this.I, this.a);
        this.p = k90Var;
        k90Var.i(this.R);
    }

    public final void A(n90 n90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, n90Var) == null) {
            this.D = n90Var;
            if (n90Var != null) {
                this.J.b(n90Var.b * 1000);
                D(n90Var);
            }
        }
    }

    public final void B(o90 o90Var) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o90Var) == null) || o90Var == null) {
            return;
        }
        A(o90Var.i);
        W(o90Var.e);
        G(o90Var);
        F(da0.a());
        C(o90Var.f);
        if (this.Q && (appBarLayout = this.g) != null) {
            this.Q = false;
            appBarLayout.post(new b(this));
        }
        if ("haokan".equals(LiveFeedPageSdk.f().e())) {
            this.j.setCustomTextsSize(16);
        }
    }

    public final void C(q90 q90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q90Var) == null) {
            if (q90Var != null) {
                if (!ob0.c(q90Var.a)) {
                    this.n.o(q90Var.a);
                    this.l.setVisibility(0);
                } else {
                    this.n.o(new ArrayList());
                    this.l.setVisibility(8);
                }
            }
            X();
        }
    }

    public final void D(n90 n90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n90Var) == null) {
            if (!this.I && n90Var.c) {
                this.A.setVisibility(0);
                b0();
                j90.x(this.c);
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
            n90 n90Var = this.D;
            if (n90Var != null && !TextUtils.isEmpty(n90Var.a)) {
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
            if (!ob0.c(this.H)) {
                if (i2 >= 0 && i2 < this.H.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.H.get(i2).subTabList;
                    if (!ob0.c(list)) {
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
            this.t.setMinimumHeight(y90.a(this.c, this.k.getVisibility() == 0 ? i3 : 42));
        }
    }

    public final void G(o90 o90Var) {
        s90 s90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, o90Var) == null) || o90Var == null) {
            return;
        }
        da0.b();
        if (this.S || (s90Var = o90Var.g) == null || ob0.c(s90Var.c)) {
            return;
        }
        this.S = true;
        List<LiveTabEntity> list = o90Var.g.c;
        this.H = list;
        int y = y(list);
        this.i.m(this.H, o90Var.h, o90Var.i);
        this.j.setViewPager(this.h);
        if (!ob0.c(this.H)) {
            da0.c(y);
            this.h.setCurrentItem(y);
        }
        this.i.l(y);
        this.O = this.i.c(y).type;
        if (o90Var.g.d) {
            Context context = this.c;
            String str = this.a;
            String m2 = j90.m(this.I);
            s90 s90Var2 = o90Var.g;
            j90.p(context, str, m2, s90Var2.a, s90Var2.b, o90Var.c, o90Var.d, "", "", "", s90Var2.f, "tab", s90Var2.e, System.currentTimeMillis(), 1);
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
                aa0.d("sp_search_guide_show", true);
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
            this.q.setIndicatorMargin(0, 0, 0, (int) y90.b(this.c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) y90.b(this.c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) y90.b(this.c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) y90.b(this.c.getResources(), 6.0f));
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
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d051e, (ViewGroup) null);
            this.e = inflate;
            this.f = inflate.findViewById(R.id.obfuscated_res_0x7f0912c3);
            this.g = (AppBarLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0912bc);
            this.o = (FrameLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0912be);
            this.j = (SmartTabLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0912c9);
            this.k = (RecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f0912ca);
            this.l = (RecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f0912c4);
            this.t = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0912bd);
            this.u = this.e.findViewById(R.id.obfuscated_res_0x7f0912c5);
            this.v = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0912c6);
            this.w = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0912c7);
            this.y = this.e.findViewById(R.id.obfuscated_res_0x7f0912c8);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.e.findViewById(R.id.obfuscated_res_0x7f091292);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new e(this));
            ImageView imageView = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091293);
            this.z = imageView;
            imageView.setOnClickListener(new f(this));
            this.z.setVisibility(this.I ? 0 : 8);
            this.A = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f0912a0);
            this.B = (LiveSearchGuideView) this.e.findViewById(R.id.obfuscated_res_0x7f0912a1);
            this.A.setOnClickListener(new g(this));
            if (this.I && nb0.a()) {
                this.e.setPadding(0, nb0.d(this.c), 0, 0);
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
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.e.findViewById(R.id.obfuscated_res_0x7f0912cb);
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
                    recyclerView.setPadding(0, y90.a(this.c, 15.0f), 0, y90.a(this.c, 12.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, y90.a(this.c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.c, this.I, this.a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            I();
            LoadingView loadingView = (LoadingView) this.e.findViewById(R.id.obfuscated_res_0x7f0912c1);
            this.r = loadingView;
            loadingView.c(this.I);
            a0(this.r);
            ErrorView errorView = (ErrorView) this.e.findViewById(R.id.obfuscated_res_0x7f0912bf);
            this.s = errorView;
            errorView.setActionCallback(new l(this));
            O(Config.TRACE_VISIT_RECENT_DAY);
        }
    }

    public void K() {
        k90 k90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (k90Var = this.p) == null) {
            return;
        }
        k90Var.g();
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
                view2.setBackgroundColor(fc0.e().a(this.c, this.I, "color_white1"));
            }
            View view3 = this.u;
            if (view3 != null) {
                view3.setBackgroundColor(fc0.e().a(this.c, this.I, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(fc0.e().a(this.c, this.I, "color_1F1F1F"));
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
                imageView.setImageResource(fc0.e().n());
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
            db0.a().e(this);
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
            da0.b();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.i();
            }
            this.N = false;
            qa0.d(String.valueOf(this.b));
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
                k90 k90Var = this.p;
                if (k90Var != null && !this.F) {
                    k90Var.f();
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

    public final void W(m90 m90Var) {
        BannerView bannerView;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, m90Var) == null) || (bannerView = this.q) == null || (frameLayout = this.o) == null) {
            return;
        }
        if (this.I) {
            frameLayout.setVisibility(8);
            this.q.setVisibility(8);
            v();
            this.G = false;
            return;
        }
        if (m90Var != null) {
            if (!ob0.c(m90Var.a)) {
                List<LiveBannerEntity> list = m90Var.a;
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
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || aa0.a("sp_search_guide_show", false)) {
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

    public final void x(o90 o90Var) {
        s90 s90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, o90Var) == null) {
            if (o90Var != null && (s90Var = o90Var.g) != null && !ob0.c(s90Var.c)) {
                B(o90Var);
                a0(this.f);
                this.K = true;
                if (o90Var.g.d) {
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

    /* loaded from: classes5.dex */
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
    @Override // com.repackage.ab0
    public void call(f90 f90Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, f90Var) == null) && f90Var != null && f90Var.a() == this.b) {
            LiveFeedPageSdk.m("LiveEventBus event: " + f90Var.getClass() + GlideException.IndentedAppendable.INDENT + f90Var.a());
            if (f90Var instanceof g90) {
                m90 m90Var = ((g90) f90Var).b;
                if (m90Var != null) {
                    W(m90Var);
                }
            } else if (f90Var instanceof i90) {
                q90 q90Var = ((i90) f90Var).b;
                if (q90Var != null) {
                    C(q90Var);
                }
            } else if (f90Var instanceof h90) {
                this.J.c();
            }
        }
    }
}
