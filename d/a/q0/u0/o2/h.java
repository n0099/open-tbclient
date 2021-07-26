package d.a.q0.u0.o2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.u0.q;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class h extends d.a.d.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f64081a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f64082b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.u0.r2.b f64083c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.u0.m1.e.a f64084d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64085e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f64086f;

    /* renamed from: g  reason: collision with root package name */
    public int f64087g;

    /* renamed from: h  reason: collision with root package name */
    public String f64088h;

    /* renamed from: i  reason: collision with root package name */
    public int f64089i;
    public boolean j;
    public int k;
    public d.a.q0.i0.a l;
    public FrsTabViewController m;
    public g n;
    public f o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f64090e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64090e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q G0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f64090e.f64081a != null && this.f64090e.f64089i == 0 && (G0 = this.f64090e.f64081a.G0()) != null && G0.Y() != null && !G0.Y().o() && !G0.a0() && this.f64090e.f64082b.isShown() && this.f64090e.f64081a.isPrimary() && !this.f64090e.j && this.f64090e.f64081a.m2() && this.f64090e.k == 1 && this.f64090e.z() && this.f64090e.f64083c != null && this.f64090e.f64083c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.f64090e.u0();
                this.f64090e.f64081a.f15342g = true;
                this.f64090e.j = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f64091e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64091e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64091e.f64081a == null || this.f64091e.f64089i != 0 || this.f64091e.f64081a.G0().a0() || !this.f64091e.f64082b.isShown() || !this.f64091e.f64081a.isPrimary() || this.f64091e.f64081a.getActivity() == null || this.f64091e.f64081a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.f64091e.f64081a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.f64091e.p0();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f64092e;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64092e = hVar;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof d.a.d.f.a.i) {
                ((d.a.d.f.a.i) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f64092e.f64082b == null) {
                return;
            }
            int childCount = this.f64092e.f64082b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(this.f64092e.f64082b.getChildAt(i2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f64093e;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64093e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64093e.f64081a == null) {
                return;
            }
            FrsViewData l0 = this.f64093e.f64081a.l0();
            if (l0 != null && l0.getForum() != null && this.f64093e.f64083c != null && (view == this.f64093e.f64083c.e() || view == this.f64093e.f64083c.f() || view == this.f64093e.f64083c.i())) {
                if (this.f64093e.f64081a != null && l0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", l0.getForum().getId()).param("obj_locate", this.f64093e.f64081a.W2() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (l0.getEntelechyTabInfo() != null && l0.getEntelechyTabInfo().tab != null) {
                    for (int i2 = 0; i2 < l0.getEntelechyTabInfo().tab.size(); i2++) {
                        arrayList.add(l0.getEntelechyTabInfo().tab.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.f64093e.getPageContext().getPageActivity(), l0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == R.id.tv_love) {
                if (this.f64093e.f64081a.F2()) {
                    return;
                }
                if (!d.a.d.e.p.j.z()) {
                    this.f64093e.f64081a.showToast(R.string.neterror);
                } else if (!ViewHelper.checkUpIsLogin(this.f64093e.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.f64093e.f64081a.h()));
                } else {
                    this.f64093e.x0(true);
                    if (d.a.d.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.f64093e.f64081a.h());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.tv_sign) {
                if (this.f64093e.f64081a.F2()) {
                    return;
                }
                if (!d.a.d.e.p.j.z()) {
                    this.f64093e.f64081a.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(this.f64093e.mContext.getPageActivity())) {
                    if (!this.f64093e.v()) {
                        this.f64093e.A0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.f64093e.f64081a.getPageContext().getPageActivity(), d.a.d.e.m.b.d(this.f64093e.f64081a.h(), 0), 24002)));
                    }
                }
            } else if (id == R.id.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(this.f64093e.mContext.getPageActivity()) || l0 == null || l0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.f64093e.getPageContext(), new String[]{l0.getGameUrl()}, true);
            } else if (id == R.id.frs_bawu_center) {
                if (l0 == null || l0.getUserData() == null || !l0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = l0.getBawuCenterUrl();
                if (d.a.d.e.p.k.isEmpty(bawuCenterUrl)) {
                    return;
                }
                d.a.p0.m.a.l(this.f64093e.getPageContext().getPageActivity(), bawuCenterUrl);
                if (l0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", l0.getForum().getId()).param("uid", l0.getUserData().getUserId()));
                }
            } else if (id == R.id.level_container) {
                if (this.f64093e.f64081a.F2() || this.f64093e.f64089i != 0 || !this.f64093e.z() || this.f64093e.f64083c == null) {
                    return;
                }
                this.f64093e.f64083c.M(view, false);
            } else if (id == R.id.frs_hot_rank_entry) {
                if (l0 == null || l0.getForum() == null || TextUtils.isEmpty(l0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f64093e.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.d.e.m.b.f(l0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", l0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.frs_manager_info_layout) {
                if (l0 == null || l0.getForum() == null || TextUtils.isEmpty(l0.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.f64093e.getPageContext().getPageActivity(), String.valueOf(l0.getForum().getId()), l0.getForum().getName())));
            } else if (id == R.id.frs_manager_application_layout && ViewHelper.checkUpIsLogin(this.f64093e.mContext.getPageActivity()) && l0 != null && l0.getForum() != null && !TextUtils.isEmpty(l0.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> m = this.f64093e.f64081a.m();
                urlManager.dealOneLink(m, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + l0.getForum().getId()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, d.a.q0.u0.m1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, aVar, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64085e = false;
        this.f64087g = 0;
        this.f64088h = "normal_page";
        this.f64089i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.f64081a = frsFragment;
        this.f64084d = aVar;
        this.f64082b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f64086f = gen;
        this.n = new g(this.f64081a, gen);
        this.o = new f(this.f64081a);
        this.l = new d.a.q0.i0.a();
    }

    public static boolean F(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) ? (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true : invokeL.booleanValue;
    }

    public static boolean G(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData != null) {
                return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().d() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void A0() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.n) == null) {
            return;
        }
        d.a.q0.u0.r2.b bVar = this.f64083c;
        if (bVar != null) {
            gVar.v(bVar.p(), this.f64083c.d());
        } else {
            gVar.v(false, "");
        }
        d.a.q0.u0.r2.b bVar2 = this.f64083c;
        if (bVar2 != null) {
            this.n.u(bVar2.j());
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!z() || (bVar = this.f64083c) == null) {
                return false;
            }
            return bVar.o();
        }
        return invokeV.booleanValue;
    }

    public void B0() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.p();
    }

    public void C0(int i2, int i3, int i4) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.w(i2, i3, i4);
    }

    public void H(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            g gVar = this.n;
            if (gVar != null) {
                gVar.n();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.u0.r2.b bVar = this.f64083c;
            if (bVar != null) {
                bVar.r();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.k();
            }
            if (this.p != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.q);
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.u0.r2.b bVar = this.f64083c;
            if (bVar != null) {
                bVar.t();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f64082b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.f64087g = i2;
            d.a.q0.u0.r2.b bVar = this.f64083c;
            if (bVar != null) {
                bVar.c(i2);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void L(boolean z) {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.s(z);
    }

    public void M(MotionEvent motionEvent) {
        d.a.q0.i0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, motionEvent) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.c(motionEvent);
    }

    public void O(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, num) == null) {
            l0(num.intValue());
            if (z()) {
                T();
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f64083c.w();
        }
    }

    public void Q(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float w = w(forumData);
        d.a.q0.u0.r2.b bVar = this.f64083c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f64083c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), w, false);
        this.f64083c.G(forumData.getSignData());
    }

    public void R(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) && frsViewData != null && z()) {
            Q(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.f64088h)) {
                this.f64083c.b();
            }
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && z()) {
            e0(i2);
        }
    }

    public void T() {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.S();
    }

    public void U() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (frsHeaderViewContainer = this.f64082b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f64082b.postDelayed(this.r, 100L);
    }

    public void V(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, frsViewData) == null) || frsViewData == null || this.f64083c == null || !z()) {
            return;
        }
        this.f64083c.u(w(frsViewData.getForum()));
    }

    public void Y() {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.x();
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || this.f64081a.g0() == null || this.f64081a.g0().T() == null) {
            return;
        }
        int B = this.f64081a.g0().T().B();
        int y = this.f64081a.g0().T().y();
        int x = this.f64081a.g0().T().x();
        d.a.q0.h3.e i2 = d.a.q0.h3.e.i();
        d.a.q0.h3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            d.a.q0.u0.r2.b bVar = this.f64083c;
            if (bVar != null) {
                this.f64082b.d(bVar.k());
                this.f64082b.d(this.f64083c.g());
                b0();
            }
            this.f64085e = false;
        }
    }

    public final void b0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.m == null || (frsFragment = this.f64081a) == null || frsFragment.G2() == null) {
            return;
        }
        this.f64081a.G2().removeHeaderView(this.m.F());
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                d.a.q0.u0.r2.b bVar = this.f64083c;
                if (bVar != null) {
                    this.f64082b.d(bVar.g());
                    this.f64085e = false;
                    return;
                }
                return;
            }
            d.a.q0.u0.r2.b bVar2 = this.f64083c;
            if (bVar2 == null || bVar2.g() == null || this.f64085e) {
                return;
            }
            this.f64082b.b(this.f64083c.g(), this.f64082b.getHeaderViewsCount());
            this.f64085e = true;
        }
    }

    public void d0(int i2) {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || (bVar = this.f64083c) == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f64083c.g().findViewById(R.id.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f64083c.m();
    }

    public void e0(int i2) {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.D(i2);
    }

    public void f0(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f64083c.E(i2, forumData.getLevelName(), forumData.getUser_level(), w(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f64083c.a(false);
    }

    public void g0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048603, this, frsViewData, z) == null) && frsViewData != null && z()) {
            f0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void i0(int i2) {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i2) == null) && z() && (bVar = this.f64083c) != null) {
            bVar.F(i2);
        }
    }

    public void j0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, frsViewData) == null) && z() && (gVar = this.n) != null) {
            gVar.t(this.f64083c, frsViewData);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && z()) {
            e0(0);
        }
    }

    public void l0(int i2) {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.J(i2);
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 > 1) {
                d.a.q0.u0.r2.b bVar = this.f64083c;
                if (bVar != null) {
                    bVar.H(false);
                    return;
                }
                return;
            }
            d.a.q0.u0.r2.b bVar2 = this.f64083c;
            if (bVar2 != null) {
                bVar2.H(true);
            }
        }
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f64089i = i2;
        }
    }

    public void o0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void p0() {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.N();
    }

    public void r() {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || this.f64085e || (bVar = this.f64083c) == null) {
            return;
        }
        this.f64082b.a(bVar.g());
        this.f64085e = true;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            d.a.d.e.m.e.a().postDelayed(this.q, 500L);
        }
    }

    public final void s(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048614, this, str, i2, i3) == null) {
            boolean z = !TextUtils.equals(this.f64088h, str);
            this.k = i3;
            this.f64088h = str;
            a0();
            if (this.f64083c == null || z) {
                d.a.q0.u0.r2.b e2 = this.f64084d.e(str, this.f64081a, i2);
                this.f64083c = e2;
                e2.c(this.f64087g);
                this.f64083c.A(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f64083c.K(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f64083c.I(fVar);
            }
            this.f64082b.a(this.f64083c.k());
            t(str);
            w0();
            r0();
        }
    }

    public final void t(String str) {
        FrsFragment frsFragment;
        RelativeLayout F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, str) == null) || this.m == null || (frsFragment = this.f64081a) == null || frsFragment.G2() == null || (F = this.m.F()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.f64081a.G2().removeHeaderView(F);
            return;
        }
        this.f64081a.G2().removeHeaderView(F);
        this.f64081a.G2().t(F, 0);
    }

    public void t0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        s(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public boolean u() {
        InterceptResult invokeV;
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!z() || (bVar = this.f64083c) == null) {
                return false;
            }
            return bVar.l();
        }
        return invokeV.booleanValue;
    }

    public final void u0() {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && z() && (bVar = this.f64083c) != null) {
            bVar.O();
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!z() || (bVar = this.f64083c) == null) {
                return false;
            }
            return bVar.h();
        }
        return invokeV.booleanValue;
    }

    public final float w(ForumData forumData) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, forumData)) == null) {
            if (forumData == null || (gVar = this.n) == null) {
                return 0.0f;
            }
            return gVar.k(forumData);
        }
        return invokeL.floatValue;
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            d.a.d.e.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public f x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.o : (f) invokeV.objValue;
    }

    public void x0(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.o(z);
    }

    public void y() {
        d.a.q0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (bVar = this.f64083c) == null) {
            return;
        }
        bVar.m();
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? "frs_page".equals(this.f64088h) || "normal_page".equals(this.f64088h) || "book_page".equals(this.f64088h) || "brand_page".equals(this.f64088h) : invokeV.booleanValue;
    }
}
