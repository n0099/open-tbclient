package d.a.p0.u0.o2;

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
import d.a.p0.u0.q;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class h extends d.a.c.a.d<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f63436a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f63437b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.u0.r2.b f63438c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.u0.m1.e.a f63439d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63440e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f63441f;

    /* renamed from: g  reason: collision with root package name */
    public int f63442g;

    /* renamed from: h  reason: collision with root package name */
    public String f63443h;

    /* renamed from: i  reason: collision with root package name */
    public int f63444i;
    public boolean j;
    public int k;
    public d.a.p0.i0.a l;
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
        public final /* synthetic */ h f63445e;

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
            this.f63445e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q B0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63445e.f63436a != null && this.f63445e.f63444i == 0 && (B0 = this.f63445e.f63436a.B0()) != null && B0.Y() != null && !B0.Y().o() && !B0.a0() && this.f63445e.f63437b.isShown() && this.f63445e.f63436a.isPrimary() && !this.f63445e.j && this.f63445e.f63436a.h2() && this.f63445e.k == 1 && this.f63445e.z() && this.f63445e.f63438c != null && this.f63445e.f63438c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.f63445e.x0();
                this.f63445e.f63436a.f15294g = true;
                this.f63445e.j = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f63446e;

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
            this.f63446e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63446e.f63436a == null || this.f63446e.f63444i != 0 || this.f63446e.f63436a.B0().a0() || !this.f63446e.f63437b.isShown() || !this.f63446e.f63436a.isPrimary() || this.f63446e.f63436a.getActivity() == null || this.f63446e.f63436a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.f63446e.f63436a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.f63446e.s0();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f63447e;

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
            this.f63447e = hVar;
        }

        public final void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view instanceof d.a.c.f.a.i) {
                ((d.a.c.f.a.i) view).refresh();
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f63447e.f63437b == null) {
                return;
            }
            int childCount = this.f63447e.f63437b.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(this.f63447e.f63437b.getChildAt(i2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f63448e;

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
            this.f63448e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63448e.f63436a == null) {
                return;
            }
            FrsViewData i0 = this.f63448e.f63436a.i0();
            if (i0 != null && i0.getForum() != null && this.f63448e.f63438c != null && (view == this.f63448e.f63438c.e() || view == this.f63448e.f63438c.f() || view == this.f63448e.f63438c.i())) {
                if (this.f63448e.f63436a != null && i0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", i0.getForum().getId()).param("obj_locate", this.f63448e.f63436a.R2() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (i0.getEntelechyTabInfo() != null && i0.getEntelechyTabInfo().tab != null) {
                    for (int i2 = 0; i2 < i0.getEntelechyTabInfo().tab.size(); i2++) {
                        arrayList.add(i0.getEntelechyTabInfo().tab.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.f63448e.getPageContext().getPageActivity(), i0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == R.id.tv_love) {
                if (this.f63448e.f63436a.A2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    this.f63448e.f63436a.showToast(R.string.neterror);
                } else if (!ViewHelper.checkUpIsLogin(this.f63448e.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.f63448e.f63436a.h()));
                } else {
                    this.f63448e.z0(true);
                    if (d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.f63448e.f63436a.h());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.tv_sign) {
                if (this.f63448e.f63436a.A2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    this.f63448e.f63436a.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(this.f63448e.mContext.getPageActivity())) {
                    if (!this.f63448e.v()) {
                        this.f63448e.A0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.f63448e.f63436a.getPageContext().getPageActivity(), d.a.c.e.m.b.d(this.f63448e.f63436a.h(), 0), 24002)));
                    }
                }
            } else if (id == R.id.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(this.f63448e.mContext.getPageActivity()) || i0 == null || i0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.f63448e.getPageContext(), new String[]{i0.getGameUrl()}, true);
            } else if (id == R.id.frs_bawu_center) {
                if (i0 == null || i0.getUserData() == null || !i0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = i0.getBawuCenterUrl();
                if (d.a.c.e.p.k.isEmpty(bawuCenterUrl)) {
                    return;
                }
                d.a.o0.l.a.l(this.f63448e.getPageContext().getPageActivity(), bawuCenterUrl);
                if (i0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", i0.getForum().getId()).param("uid", i0.getUserData().getUserId()));
                }
            } else if (id == R.id.level_container) {
                if (this.f63448e.f63436a.A2() || this.f63448e.f63444i != 0 || !this.f63448e.z() || this.f63448e.f63438c == null) {
                    return;
                }
                this.f63448e.f63438c.M(view, false);
            } else if (id == R.id.frs_hot_rank_entry) {
                if (i0 == null || i0.getForum() == null || TextUtils.isEmpty(i0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.f63448e.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(i0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", i0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.frs_manager_info_layout) {
                if (i0 == null || i0.getForum() == null || TextUtils.isEmpty(i0.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.f63448e.getPageContext().getPageActivity(), String.valueOf(i0.getForum().getId()), i0.getForum().getName())));
            } else if (id == R.id.frs_manager_application_layout && ViewHelper.checkUpIsLogin(this.f63448e.mContext.getPageActivity()) && i0 != null && i0.getForum() != null && !TextUtils.isEmpty(i0.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> m = this.f63448e.f63436a.m();
                urlManager.dealOneLink(m, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + i0.getForum().getId()});
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment, d.a.p0.u0.m1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63440e = false;
        this.f63442g = 0;
        this.f63443h = "normal_page";
        this.f63444i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.f63436a = frsFragment;
        this.f63439d = aVar;
        this.f63437b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f63441f = gen;
        this.n = new g(this.f63436a, gen);
        this.o = new f(this.f63436a);
        this.l = new d.a.p0.i0.a();
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
        d.a.p0.u0.r2.b bVar = this.f63438c;
        if (bVar != null) {
            gVar.v(bVar.p(), this.f63438c.d());
        } else {
            gVar.v(false, "");
        }
        d.a.p0.u0.r2.b bVar2 = this.f63438c;
        if (bVar2 != null) {
            this.n.u(bVar2.j());
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!z() || (bVar = this.f63438c) == null) {
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
        fVar.s();
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
                fVar.m();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.p0.u0.r2.b bVar = this.f63438c;
            if (bVar != null) {
                bVar.r();
            }
            f fVar = this.o;
            if (fVar != null) {
                fVar.n();
            }
            if (this.p != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.q);
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.p0.u0.r2.b bVar = this.f63438c;
            if (bVar != null) {
                bVar.t();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.f63437b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.f63442g = i2;
            d.a.p0.u0.r2.b bVar = this.f63438c;
            if (bVar != null) {
                bVar.c(i2);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void L(boolean z) {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.s(z);
    }

    public void N(MotionEvent motionEvent) {
        d.a.p0.i0.a aVar;
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
            this.f63438c.w();
        }
    }

    public void Q(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float w = w(forumData);
        d.a.p0.u0.r2.b bVar = this.f63438c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f63438c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), w, false);
        this.f63438c.G(forumData.getSignData());
    }

    public void R(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) && frsViewData != null && z()) {
            Q(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.f63443h)) {
                this.f63438c.b();
            }
        }
    }

    public void S(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && z()) {
            f0(i2);
        }
    }

    public void T() {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.S();
    }

    public void U() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (frsHeaderViewContainer = this.f63437b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.f63437b.postDelayed(this.r, 100L);
    }

    public void X(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, frsViewData) == null) || frsViewData == null || this.f63438c == null || !z()) {
            return;
        }
        this.f63438c.u(w(frsViewData.getForum()));
    }

    public void Y() {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.x();
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || this.f63436a.d0() == null || this.f63436a.d0().T() == null) {
            return;
        }
        int B = this.f63436a.d0().T().B();
        int y = this.f63436a.d0().T().y();
        int x = this.f63436a.d0().T().x();
        d.a.p0.h3.e i2 = d.a.p0.h3.e.i();
        d.a.p0.h3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            d.a.p0.u0.r2.b bVar = this.f63438c;
            if (bVar != null) {
                this.f63437b.d(bVar.k());
                this.f63437b.d(this.f63438c.g());
                b0();
            }
            this.f63440e = false;
        }
    }

    public final void b0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.m == null || (frsFragment = this.f63436a) == null || frsFragment.B2() == null) {
            return;
        }
        this.f63436a.B2().removeHeaderView(this.m.F());
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                d.a.p0.u0.r2.b bVar = this.f63438c;
                if (bVar != null) {
                    this.f63437b.d(bVar.g());
                    this.f63440e = false;
                    return;
                }
                return;
            }
            d.a.p0.u0.r2.b bVar2 = this.f63438c;
            if (bVar2 == null || bVar2.g() == null || this.f63440e) {
                return;
            }
            this.f63437b.b(this.f63438c.g(), this.f63437b.getHeaderViewsCount());
            this.f63440e = true;
        }
    }

    public void d0(int i2) {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || (bVar = this.f63438c) == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f63438c.g().findViewById(R.id.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f63438c.m();
    }

    public void f0(int i2) {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.D(i2);
    }

    public void g0(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f63438c.E(i2, forumData.getLevelName(), forumData.getUser_level(), w(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f63438c.a(false);
    }

    public void h0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048603, this, frsViewData, z) == null) && frsViewData != null && z()) {
            g0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void i0(int i2) {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i2) == null) && z() && (bVar = this.f63438c) != null) {
            bVar.F(i2);
        }
    }

    public void j0(FrsViewData frsViewData) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, frsViewData) == null) && z() && (gVar = this.n) != null) {
            gVar.t(this.f63438c, frsViewData);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && z()) {
            f0(0);
        }
    }

    public void l0(int i2) {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.J(i2);
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 > 1) {
                d.a.p0.u0.r2.b bVar = this.f63438c;
                if (bVar != null) {
                    bVar.H(false);
                    return;
                }
                return;
            }
            d.a.p0.u0.r2.b bVar2 = this.f63438c;
            if (bVar2 != null) {
                bVar2.H(true);
            }
        }
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.f63444i = i2;
        }
    }

    public void q0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void r() {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.f63440e || (bVar = this.f63438c) == null) {
            return;
        }
        this.f63437b.a(bVar.g());
        this.f63440e = true;
    }

    public final void s(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048612, this, str, i2, i3) == null) {
            boolean z = !TextUtils.equals(this.f63443h, str);
            this.k = i3;
            this.f63443h = str;
            a0();
            if (this.f63438c == null || z) {
                d.a.p0.u0.r2.b e2 = this.f63439d.e(str, this.f63436a, i2);
                this.f63438c = e2;
                e2.c(this.f63442g);
                this.f63438c.A(this.s);
            }
            g gVar = this.n;
            if (gVar != null) {
                this.f63438c.K(gVar);
            }
            f fVar = this.o;
            if (fVar != null) {
                this.f63438c.I(fVar);
            }
            this.f63437b.a(this.f63438c.k());
            t(str);
            y0();
            t0();
        }
    }

    public void s0() {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.N();
    }

    public final void t(String str) {
        FrsFragment frsFragment;
        RelativeLayout F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, str) == null) || this.m == null || (frsFragment = this.f63436a) == null || frsFragment.B2() == null || (F = this.m.F()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.f63436a.B2().removeHeaderView(F);
            return;
        }
        this.f63436a.B2().removeHeaderView(F);
        this.f63436a.B2().t(F, 0);
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            d.a.c.e.m.e.a().postDelayed(this.q, 500L);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!z() || (bVar = this.f63438c) == null) {
                return false;
            }
            return bVar.l();
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!z() || (bVar = this.f63438c) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, forumData)) == null) {
            if (forumData == null || (gVar = this.n) == null) {
                return 0.0f;
            }
            return gVar.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void w0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        s(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public f x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.o : (f) invokeV.objValue;
    }

    public final void x0() {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && z() && (bVar = this.f63438c) != null) {
            bVar.O();
        }
    }

    public void y() {
        d.a.p0.u0.r2.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (bVar = this.f63438c) == null) {
            return;
        }
        bVar.m();
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            d.a.c.e.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? "frs_page".equals(this.f63443h) || "normal_page".equals(this.f63443h) || "book_page".equals(this.f63443h) || "brand_page".equals(this.f63443h) : invokeV.booleanValue;
    }

    public void z0(boolean z) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z) == null) || (fVar = this.o) == null) {
            return;
        }
        fVar.r(z);
    }
}
