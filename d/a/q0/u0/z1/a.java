package d.a.q0.u0.z1;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.g0;
import d.a.p0.s.q.m0;
import d.a.q0.u0.s;
import d.a.q0.u0.t;
import d.a.q0.u0.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class a implements TabLayout.OnTabSelectedListener {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f64666a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f64667b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f64668c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f64669d;

    /* renamed from: e  reason: collision with root package name */
    public TabLayout f64670e;

    /* renamed from: f  reason: collision with root package name */
    public TabLayout f64671f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f64672g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.u0.z1.b f64673h;

    /* renamed from: i  reason: collision with root package name */
    public BannerView f64674i;
    public g0 j;
    public ThemeColorInfo k;
    public String l;
    public boolean m;
    public boolean n;
    public int o;
    public final int p;
    public int q;
    public View.OnClickListener r;
    public BannerView.b s;
    public CustomMessageListener t;

    /* renamed from: d.a.q0.u0.z1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1739a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64675e;

        public View$OnClickListenerC1739a(a aVar) {
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
            this.f64675e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64675e.f64666a == null) {
                return;
            }
            this.f64675e.f64666a.onScrollToBottom();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null) {
                return;
            }
            PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
            if (playVoiceBnt != null) {
                playVoiceBnt.h();
            }
            FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
            if (frsCommonImageLayout != null) {
                frsCommonImageLayout.p();
            }
            if (view instanceof UserPhotoLayout) {
                ((UserPhotoLayout) view).reset();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64676a;

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
            this.f64676a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f64676a.f64674i.i() && !this.f64676a.m && this.f64676a.f64668c != null) {
                this.f64676a.m = true;
                this.f64676a.f64668c.t(this.f64676a.f64674i, 1);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64677a;

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
            this.f64677a = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64677a.C();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f64677a.l();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TabLayout.OnTabSelectedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64678a;

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
            this.f64678a = aVar;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab) == null) || tab == null) {
                return;
            }
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                a aVar = this.f64678a;
                aVar.G(intValue, aVar.f64670e, true);
            }
            this.f64678a.P(tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tab) == null) {
                this.f64678a.a0();
                this.f64678a.Q(tab);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64679e;

        public f(a aVar) {
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
            this.f64679e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64679e.m().p();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64680a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64680a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.f64680a.E(str);
                this.f64680a.D(str);
                this.f64680a.f64673h.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64681a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-347865371, "Ld/a/q0/u0/z1/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-347865371, "Ld/a/q0/u0/z1/a$h;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f64681a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64681a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-849523031, "Ld/a/q0/u0/z1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-849523031, "Ld/a/q0/u0/z1/a;");
                return;
            }
        }
        u = Pattern.compile("(/p/){1}(\\d+)");
    }

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64666a = null;
        this.f64667b = null;
        this.f64668c = null;
        this.f64674i = null;
        this.m = false;
        this.n = false;
        this.o = 0;
        this.r = new View$OnClickListenerC1739a(this);
        this.s = new d(this);
        this.t = new g(this, 2016331);
        this.f64666a = frsGoodFragment;
        u(view, z);
        this.p = l.g(this.f64666a.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.q = l.g(this.f64666a.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    public void A() {
        d.a.q0.u0.z1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f64673h) == null) {
            return;
        }
        bVar.p();
    }

    public final void B(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tabLayout) == null) || tabLayout == null) {
            return;
        }
        tabLayout.removeAllTabs();
    }

    public void C() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bannerView = this.f64674i) == null) {
            return;
        }
        this.m = false;
        this.f64668c.removeHeaderView(bannerView);
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f64666a.q1() == null) {
            return;
        }
        this.f64666a.q1().I(str);
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(str) || ListUtils.isEmpty(this.f64673h.l())) {
            return;
        }
        Iterator<n> it = this.f64673h.m().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.q0.e.c) {
                d.a.q0.e.c cVar = (d.a.q0.e.c) next;
                if ((cVar.b() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.b()).R3)) {
                    it.remove();
                }
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            t tVar = new t();
            tVar.f64450a = 301;
            tVar.f64451b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public final void G(int i2, TabLayout tabLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), tabLayout, Boolean.valueOf(z)}) == null) || tabLayout == null) {
            return;
        }
        for (int i3 = 0; i3 < tabLayout.getTabCount(); i3++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
            if (tabAt != null && (tabAt.getTag() instanceof Integer)) {
                if (((Integer) tabAt.getTag()).intValue() == i2) {
                    if (z) {
                        tabAt.select();
                    } else {
                        tabLayout.setScrollPosition(i3, 0.0f, true);
                        P(tabAt);
                    }
                } else if (!z) {
                    Q(tabAt);
                }
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64673h.q();
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.f64450a = 301;
        tVar.f64451b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f64669d.setVisibility(z ? 0 : 8);
            V(z);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f64668c.setSelection(i2);
        }
    }

    public void L(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wVar) == null) {
            this.f64673h.B(wVar);
        }
    }

    public void M(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onScrollListener) == null) {
            this.f64668c.setOnScrollListener(onScrollListener);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            z zVar = new z();
            zVar.f64662a = 301;
            zVar.f64664c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
        }
    }

    public void O(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null || frsViewData.getForum().getGood_classify() == null) {
            return;
        }
        ArrayList<m0> good_classify = frsViewData.getForum().getGood_classify();
        TabData tabData = new TabData();
        d.a.q0.u0.k2.e eVar = new d.a.q0.u0.k2.e();
        eVar.f63656b = 0;
        eVar.f63655a = this.f64666a.getPageContext().getResources().getString(R.string.all);
        tabData.add(eVar);
        for (m0 m0Var : good_classify) {
            if (m0Var != null && m0Var.a() > 0 && !TextUtils.isEmpty(m0Var.b()) && !TextUtils.isEmpty(m0Var.b().trim())) {
                d.a.q0.u0.k2.e eVar2 = new d.a.q0.u0.k2.e();
                eVar2.f63656b = m0Var.a();
                eVar2.f63655a = m0Var.b();
                tabData.add(eVar2);
            }
        }
        if (ListUtils.getCount(tabData) <= 1) {
            return;
        }
        t();
        this.n = true;
        R(tabData, this.f64670e);
        R(tabData, this.f64671f);
    }

    public final void P(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, tab) == null) || tab.getCustomView() == null) {
            return;
        }
        d.a.p0.s.f0.n.c cVar = (d.a.p0.s.f0.n.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
        if (k.isEmpty(this.l)) {
            cVar.q(R.color.CAM_X0105);
        } else {
            cVar.p(d.a.q0.n1.o.k.b.b(this.l));
        }
    }

    public final void Q(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        ((d.a.p0.s.f0.n.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).q(R.color.CAM_X0108);
    }

    public final void R(TabData tabData, TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, tabData, tabLayout) == null) {
            int min = Math.min(tabData.size(), 9);
            if (tabLayout.getTabCount() > min) {
                int tabCount = tabLayout.getTabCount() - min;
                for (int i2 = 0; i2 < tabCount; i2++) {
                    tabLayout.removeTabAt(0);
                }
            }
            LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
            if (linearLayout == null) {
                return;
            }
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    if (linearLayout.getChildAt(i3) != null) {
                        linearLayout.getChildAt(i3).setPadding(0, 0, 0, 0);
                    }
                }
                if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.f64666a.getContext());
                    d.a.p0.s.f0.n.c cVar = new d.a.p0.s.f0.n.c();
                    cVar.q(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.p);
                    int i4 = this.q;
                    layoutParams.setMargins(i4 / 2, 0, i4 / 2, 0);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tabAt.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(tabData.get(i3).f63655a, 10, StringHelper.STRING_MORE));
                tabAt.setTag(Integer.valueOf(tabData.get(i3).f63656b));
                if (tabData.get(i3).f63656b == this.o) {
                    tabAt.select();
                }
            }
        }
    }

    public void S(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, themeColorInfo) == null) || themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        this.k = themeColorInfo;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = this.k.dark;
        } else if (skinType == 1) {
            themeElement = this.k.night;
        } else {
            themeElement = this.k.day;
        }
        if (k.isEmpty(themeElement.font_color)) {
            return;
        }
        this.l = themeElement.font_color;
    }

    public void T(ArrayList<n> arrayList, int i2, FrsViewData frsViewData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{arrayList, Integer.valueOf(i2), frsViewData, Integer.valueOf(i3)}) == null) {
            if (arrayList == null || arrayList.size() <= 0) {
                s sVar = new s();
                ArrayList<n> arrayList2 = new ArrayList<>();
                arrayList2.add(sVar);
                arrayList = arrayList2;
            }
            this.f64673h.w(arrayList, frsViewData);
            this.n = false;
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f64668c.setNextPage(this.f64672g);
            this.f64672g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f64672g.z(this.r);
            this.f64672g.f();
            this.f64672g.A(this.f64666a.getResources().getString(R.string.list_click_load_more));
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                this.f64671f.setVisibility(8);
            } else if (this.f64671f.getTabCount() > 1) {
                this.f64671f.setVisibility(0);
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f64668c.setVisibility(0);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f64668c.setNextPage(this.f64672g);
            this.f64672g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f64672g.z(null);
            this.f64672g.O();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f64668c.setNextPage(this.f64672g);
            this.f64672g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f64672g.z(null);
            this.f64672g.f();
            this.f64672g.A(this.f64666a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            t tVar = new t();
            tVar.f64450a = 301;
            tVar.f64451b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            t tVar = new t();
            tVar.f64450a = 301;
            tVar.f64451b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public final void l() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (g0Var = this.j) == null) {
            return;
        }
        String e2 = g0Var.e();
        if (this.j.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f64666a.getPageContext().getPageActivity(), e2, false, "frs_banner")));
        } else if (this.j.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = u.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f64666a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f64666a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.j.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = h.f64681a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f64666a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f64666a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f64666a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f64666a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f64666a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f64666a.getPageContext().getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.j.a() == 4) {
            this.f64666a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f64666a.getPageContext().getPageActivity()).createNormalCfg(e2, "frs_banner")));
        }
    }

    public d.a.q0.u0.z1.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f64673h : (d.a.q0.u0.z1.b) invokeV.objValue;
    }

    public BdTypeRecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f64668c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f64667b : (RelativeLayout) invokeV.objValue;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, tab) == null) || tab == null || tab.getCustomView() == null) {
            return;
        }
        if (!this.n && (tab.getTag() instanceof Integer)) {
            int intValue = ((Integer) tab.getTag()).intValue();
            this.o = intValue;
            this.f64666a.w1(intValue);
        }
        P(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, tab) == null) || tab == null) {
            return;
        }
        if (tab.getTag() instanceof Integer) {
            int intValue = ((Integer) tab.getTag()).intValue();
            d.a.q0.u0.j2.d.h0.f63603e = intValue;
            if (!this.n) {
                this.o = intValue;
                G(intValue, this.f64671f, false);
                this.f64666a.w1(this.o);
                d.a.q0.a0.t.b().e(false);
                d.a.q0.g3.c.g().h(this.f64666a.getUniqueId(), false);
            }
        }
        P(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, tab) == null) {
            a0();
            Q(tab);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f64668c.setNextPage(null);
        }
    }

    public final void q(g0 g0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, g0Var) == null) && this.f64674i == null) {
            this.f64674i = new BannerView(this.f64666a.getPageContext().getPageActivity());
            this.f64674i.setLayoutParams(new AbsListView.LayoutParams(-1, this.f64666a.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.f64674i.setVisibility(8);
            this.f64674i.setBannerViewClickListener(this.s);
            this.f64674i.setBannerData(g0Var);
            this.f64674i.setBannerViewEvent(new c(this));
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
            this.f64671f = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.f64671f.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e(this));
        }
    }

    public final void s(TabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, tabLayout) == null) || tabLayout == null) {
            return;
        }
        for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
            if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                d.a.p0.s.f0.n.c cVar = (d.a.p0.s.f0.n.c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                if (!tabAt.isSelected()) {
                    cVar.q(R.color.CAM_X0108);
                } else if (k.isEmpty(this.l)) {
                    cVar.q(R.color.CAM_X0105);
                } else {
                    cVar.p(d.a.q0.n1.o.k.b.b(this.l));
                }
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.f64670e == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.f64666a.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.f64670e = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.f64670e.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.f64666a.getContext(), R.dimen.tbds126)));
            this.f64670e.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            s(this.f64670e);
            this.f64668c.s(this.f64670e);
        }
    }

    public final void u(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048615, this, view, z) == null) {
            this.f64667b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
            r(view);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
            this.f64668c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f64668c.setFadingEdgeLength(0);
            this.f64668c.setOverScrollMode(2);
            this.f64668c.setRecyclerListener(new b(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f64668c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f64668c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.f64666a.getPageContext().getPageActivity());
            this.f64672g = pbListView;
            pbListView.a();
            this.f64672g.o(R.color.transparent);
            this.f64672g.r(l.g(this.f64666a.getActivity(), R.dimen.tbds182));
            this.f64672g.v();
            this.f64672g.E(R.dimen.tbfontsize33);
            this.f64672g.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f64672g.y(R.color.CAM_X0110);
            this.f64668c.setOnSrollToBottomListener(this.f64666a);
            this.f64669d = (FrameLayout) view.findViewById(R.id.frs_list_content);
            this.f64673h = new d.a.q0.u0.z1.b(this.f64666a, this.f64668c);
            I(false);
            this.f64666a.registerListener(this.t);
        }
    }

    public void v() {
        d.a.q0.u0.z1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (bVar = this.f64673h) == null) {
            return;
        }
        bVar.p();
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            d.a.q0.u0.z1.b bVar = this.f64673h;
            if (bVar != null) {
                bVar.D();
                this.f64673h.p();
                this.f64673h.r(i2);
            }
            FrsGoodFragment frsGoodFragment = this.f64666a;
            if (frsGoodFragment != null && frsGoodFragment.getBaseFragmentActivity() == null && this.f64666a.getBaseFragmentActivity().getLayoutMode() != null) {
                this.f64666a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
                this.f64666a.getBaseFragmentActivity().getLayoutMode().j(this.f64667b);
            }
            BannerView bannerView = this.f64674i;
            if (bannerView != null) {
                bannerView.j();
            }
            PbListView pbListView = this.f64672g;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f64672g.d(i2);
            }
            s(this.f64670e);
            s(this.f64671f);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f64673h.s();
            this.f64668c.setOnSrollToBottomListener(null);
            B(this.f64670e);
            B(this.f64671f);
        }
    }

    public void y() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || m() == null) {
            return;
        }
        List<n> l = m().l();
        if (ListUtils.isEmpty(l)) {
            return;
        }
        for (n nVar : l) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.x != 0 && (b2Var = a2Var.w) != null) {
                    int[] e0 = b2Var.e0();
                    a2Var.x = e0[0];
                    a2Var.y = e0[1];
                }
            }
        }
        d.a.d.e.m.e.a().postDelayed(new f(this), 500L);
    }

    public void z(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, forumData, userData) == null) || this.m || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().f()) {
            return;
        }
        g0 frsBannerData = forumData.getFrsBannerData();
        this.j = frsBannerData;
        q(frsBannerData);
        this.f64674i.k();
        this.f64668c.removeHeaderView(this.f64674i);
        if (this.j.d() != 1 || TextUtils.isEmpty(this.j.b())) {
            return;
        }
        this.f64674i.setData(this.f64666a.getPageContext(), this.j.b());
        if (this.j.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f64666a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }
}
