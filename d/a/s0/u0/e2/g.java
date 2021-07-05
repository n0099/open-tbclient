package d.a.s0.u0.e2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
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
import d.a.c.k.e.w;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.g0;
import d.a.s0.u0.s;
import d.a.s0.u0.t;
import d.a.s0.u0.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f65904a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f65905b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f65906c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f65907d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f65908e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.u0.e2.f f65909f;

    /* renamed from: g  reason: collision with root package name */
    public BannerView f65910g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f65911h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65912i;
    public RelativeLayout j;
    public d.a.s0.u0.m1.f.a.a k;
    public boolean l;
    public BannerView.b m;
    public CustomMessageListener n;
    public CustomMessageListener o;

    /* loaded from: classes9.dex */
    public class a implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
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

    /* loaded from: classes9.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f65913a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65913a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f65913a.f65910g.i() && !this.f65913a.f65912i && this.f65913a.f65906c != null) {
                this.f65913a.f65912i = true;
                this.f65913a.f65906c.t(this.f65913a.f65910g, 1);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f65914a;

        public c(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65914a = gVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65914a.u();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f65914a.h();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f65915e;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65915e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65915e.f65906c.removeHeaderView(this.f65915e.j);
                this.f65915e.f65906c.t(this.f65915e.j, 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f65916a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f65917e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65917e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f65917e.f65916a.f65909f.l();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f65916a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b2 b2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<d.a.c.k.e.n> j = this.f65916a.f65909f.j();
                if (ListUtils.isEmpty(j)) {
                    return;
                }
                if (!ListUtils.isEmpty(j)) {
                    for (d.a.c.k.e.n nVar : j) {
                        if (nVar instanceof a2) {
                            a2 a2Var = (a2) nVar;
                            if (a2Var.x != 0 && (b2Var = a2Var.w) != null) {
                                int[] d0 = b2Var.d0();
                                a2Var.x = d0[0];
                                a2Var.y = d0[1];
                            }
                        }
                    }
                }
                d.a.c.e.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f65918a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f65918a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.f65918a.w(str);
                this.f65918a.v(str);
                this.f65918a.f65909f.p();
            }
        }
    }

    /* renamed from: d.a.s0.u0.e2.g$g  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1713g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65919a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1931395660, "Ld/a/s0/u0/e2/g$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1931395660, "Ld/a/s0/u0/e2/g$g;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f65919a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65919a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-167822417, "Ld/a/s0/u0/e2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-167822417, "Ld/a/s0/u0/e2/g;");
                return;
            }
        }
        p = Pattern.compile("(/p/){1}(\\d+)");
    }

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65904a = null;
        this.f65905b = null;
        this.f65906c = null;
        this.f65910g = null;
        this.f65912i = false;
        this.l = true;
        this.m = new c(this);
        this.n = new e(this, 2921414);
        this.o = new f(this, 2016331);
        this.f65904a = frsNewAreaFragment;
        o(view);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
            return;
        }
        t tVar = new t();
        tVar.f67022a = 503;
        tVar.f67023b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f65907d.setVisibility(z ? 0 : 8);
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f65906c.setSelection(i2);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
            if (z) {
                this.f65908e.A(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.f65906c;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.f65908e.b()) {
                    this.f65908e.O();
                    this.f65904a.loadMore();
                    return;
                }
                this.f65908e.f();
                return;
            }
            this.f65908e.A(this.f65904a.getResources().getString(R.string.load_more_must_after_delete));
            this.f65908e.f();
        }
    }

    public void E(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wVar) == null) {
            this.f65909f.u(wVar);
        }
    }

    public void F(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onScrollListener) == null) {
            this.f65906c.setOnScrollListener(onScrollListener);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            z zVar = new z();
            zVar.f67234a = 503;
            zVar.f67236c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
        }
    }

    public void H(ArrayList<d.a.c.k.e.n> arrayList, int i2, FrsViewData frsViewData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{arrayList, Integer.valueOf(i2), frsViewData, Integer.valueOf(i3)}) == null) {
            ArrayList<d.a.c.k.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
                s sVar = new s();
                ArrayList<d.a.c.k.e.n> arrayList2 = new ArrayList<>();
                arrayList2.add(sVar);
                switchThreadDataToThreadCardInfo = arrayList2;
            }
            if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                List<FrsTabInfo> i4 = i(frsViewData);
                if (ListUtils.isEmpty(i4)) {
                    RelativeLayout relativeLayout = this.j;
                    if (relativeLayout != null) {
                        this.f65906c.removeHeaderView(relativeLayout);
                    }
                } else if (this.j != null) {
                    this.f65906c.post(new d(this));
                }
                if (frsViewData != null && frsViewData.getIsBrandForum()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(i4, 0);
                    if (frsViewData != null && this.f65904a.p1() != null && frsTabInfo != null) {
                        this.f65904a.p1().M(frsTabInfo.tab_id.intValue());
                    }
                } else if (this.k != null && frsViewData.getForum() != null) {
                    this.k.i(i4);
                    this.k.j(frsViewData.getForum().getId());
                    if (d.a.r0.b.d.n() && d.a.r0.b.g.a.f54805c != d.a.r0.b.g.a.d()) {
                        this.k.g(d.a.s0.u0.n2.k.d(d.a.r0.b.g.a.d()));
                    }
                }
            }
            this.f65909f.q(switchThreadDataToThreadCardInfo, frsViewData);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f65906c.setVisibility(0);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f65906c.setNextPage(this.f65908e);
            this.f65908e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f65908e.O();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f65906c.setNextPage(this.f65908e);
            this.f65908e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f65908e.f();
            this.f65908e.A(this.f65904a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t tVar = new t();
            tVar.f67022a = 503;
            tVar.f67023b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public final void h() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (g0Var = this.f65911h) == null) {
            return;
        }
        String e2 = g0Var.e();
        if (this.f65911h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f65904a.getPageContext().getPageActivity(), e2, false, "frs_banner")));
        } else if (this.f65911h.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = p.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f65904a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f65904a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f65911h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = C1713g.f65919a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f65904a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f65904a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f65904a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f65904a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f65904a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f65904a.getPageContext().getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.f65911h.a() == 4) {
            this.f65904a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f65904a.getPageContext().getPageActivity()).createNormalCfg(e2, "frs_banner")));
        }
    }

    public final List<FrsTabInfo> i(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                FrsTabInfo next = it.next();
                if (next.tab_id.intValue() == 503) {
                    i2 = next.tab_type.intValue();
                    break;
                }
            }
            if (i2 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public d.a.s0.u0.e2.f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f65909f : (d.a.s0.u0.e2.f) invokeV.objValue;
    }

    public BdTypeRecyclerView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f65906c : (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f65905b : (RelativeLayout) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f65906c.setNextPage(null);
        }
    }

    public final void n(g0 g0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, g0Var) == null) && this.f65910g == null) {
            this.f65910g = new BannerView(this.f65904a.getPageContext().getPageActivity());
            this.f65910g.setLayoutParams(new AbsListView.LayoutParams(-1, this.f65904a.getResources().getDimensionPixelSize(R.dimen.ds100)));
            this.f65910g.setVisibility(8);
            this.f65910g.setBannerViewClickListener(this.m);
            this.f65910g.setBannerData(g0Var);
            this.f65910g.setBannerViewEvent(new b(this));
        }
    }

    public final void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            this.f65905b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
            this.f65906c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.f65906c.setFadingEdgeLength(0);
            this.f65906c.setOverScrollMode(2);
            this.f65906c.setRecyclerListener(new a(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f65906c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f65906c.getPaddingBottom());
            PbListView pbListView = new PbListView(this.f65904a.getPageContext().getPageActivity());
            this.f65908e = pbListView;
            pbListView.a();
            this.f65908e.o(R.color.transparent);
            this.f65908e.r(d.a.c.e.p.l.g(this.f65904a.getActivity(), R.dimen.tbds182));
            this.f65908e.v();
            this.f65908e.E(R.dimen.tbfontsize33);
            this.f65908e.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f65908e.y(R.color.CAM_X0110);
            this.f65906c.setOnSrollToBottomListener(this.f65904a);
            this.f65907d = (FrameLayout) view.findViewById(R.id.frs_list_content);
            this.f65909f = new d.a.s0.u0.e2.f(this.f65904a, this.f65906c);
            A(false);
            this.j = new RelativeLayout(this.f65904a.getContext());
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.k = new d.a.s0.u0.m1.f.a.a(this.f65904a, this.j);
            this.f65904a.registerListener(this.n);
            this.f65904a.registerListener(this.o);
        }
    }

    public void p() {
        d.a.s0.u0.e2.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fVar = this.f65909f) == null) {
            return;
        }
        fVar.l();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            d.a.s0.u0.e2.f fVar = this.f65909f;
            if (fVar != null) {
                fVar.w();
                this.f65909f.l();
                this.f65909f.n(i2);
            }
            this.f65904a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f65904a.getBaseFragmentActivity().getLayoutMode().j(this.f65905b);
            BannerView bannerView = this.f65910g;
            if (bannerView != null) {
                bannerView.j();
            }
            PbListView pbListView = this.f65908e;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.f65908e.d(i2);
            }
            this.k.h();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f65909f.o();
            this.f65906c.setOnSrollToBottomListener(null);
        }
    }

    public void s(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, forumData, userData) == null) || this.f65912i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().f()) {
            return;
        }
        g0 frsBannerData = forumData.getFrsBannerData();
        this.f65911h = frsBannerData;
        n(frsBannerData);
        this.f65910g.k();
        this.f65906c.removeHeaderView(this.f65910g);
        if (this.f65911h.d() != 1 || TextUtils.isEmpty(this.f65911h.b())) {
            return;
        }
        this.f65910g.setData(this.f65904a.getPageContext(), this.f65911h.b());
        if (this.f65911h.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f65904a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f65909f.l();
        }
    }

    public void u() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (bannerView = this.f65910g) == null) {
            return;
        }
        this.f65912i = false;
        this.f65906c.removeHeaderView(bannerView);
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, str) == null) || this.f65904a.o1() == null) {
            return;
        }
        this.f65904a.o1().I(str);
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || StringUtils.isNull(str) || ListUtils.isEmpty(this.f65909f.j())) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = this.f65909f.j().iterator();
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if (next instanceof d.a.s0.e.c) {
                d.a.s0.e.c cVar = (d.a.s0.e.c) next;
                if ((cVar.b() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.b()).L3)) {
                    it.remove();
                }
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.l) {
                return false;
            }
            this.f65908e.A(this.f65904a.getResources().getString(R.string.load_more_must_after_delete));
            this.f65908e.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            t tVar = new t();
            tVar.f67022a = 503;
            tVar.f67023b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.f65909f.m();
        }
    }
}
