package com.repackage;

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
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dq6 extends z8<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public nq6 c;
    public nh6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public m36 l;
    public FrsTabViewController m;
    public cq6 n;
    public bq6 o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq6 a;

        public a(dq6 dq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vc6 w0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (w0 = this.a.a.w0()) != null && w0.Y() != null && !w0.Y().o() && !w0.a0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.i2() && this.a.k == 1 && this.a.D() && this.a.c != null && this.a.c.u()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.v0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq6 a;

        public b(dq6 dq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.w0().a0() || !this.a.b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.r0();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq6 a;

        public c(dq6 dq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof tk) {
                ((tk) view2).refresh();
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.b == null) {
                return;
            }
            int childCount = this.a.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(this.a.b.getChildAt(i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq6 a;

        public d(dq6 dq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09065b);
            FrsViewData g0 = this.a.a.g0();
            if (g0 != null && g0.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.k() || logicField == LogicField.INFO_AREA)) {
                if (this.a.a != null && g0.getForum() != null) {
                    StatisticItem param = new StatisticItem("c12046").param("fid", g0.getForum().getId()).param("fname", g0.getForum().getName()).param("obj_locate", this.a.a.Y2() ? 1 : 2);
                    fn6.a(param);
                    TiebaStatic.log(param);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (g0.getEntelechyTabInfo() != null && g0.getEntelechyTabInfo().a != null) {
                    for (int i = 0; i < g0.getEntelechyTabInfo().a.size(); i++) {
                        arrayList.add(g0.getEntelechyTabInfo().a.get(i).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), g0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(g0.serviceAreaFlutterData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09220a || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.F2()) {
                    return;
                }
                if (!ki.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.b()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fb0);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        fn6.d(this.a.a.b(), this.a.a.a());
                    }
                    this.a.x0(true);
                    if (li.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.a.a.b());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.obfuscated_res_0x7f092244 || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.F2()) {
                    return;
                }
                if (!ki.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.y()) {
                        this.a.y0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), kg.e(this.a.a.b(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090b25) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || g0 == null || g0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{g0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090ac4) {
                if (g0 == null || g0.getUserData() == null || !g0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = g0.getBawuCenterUrl();
                if (li.isEmpty(bawuCenterUrl)) {
                    return;
                }
                fm4.m(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (g0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", g0.getForum().getId()).param("uid", g0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f091235 || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.F2() || this.a.i != 0 || !this.a.D() || this.a.c == null) {
                    return;
                }
                this.a.c.V(view2, false);
            } else if (id == R.id.obfuscated_res_0x7f090b30) {
                if (g0 == null || g0.getForum() == null || TextUtils.isEmpty(g0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(kg.g(g0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", g0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.obfuscated_res_0x7f090b7e) {
                if (id != R.id.obfuscated_res_0x7f090b7d || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || g0 == null || g0.getForum() == null || TextUtils.isEmpty(g0.getForum().getId())) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> i2 = this.a.a.i();
                urlManager.dealOneLink(i2, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + g0.getForum().getId()});
            } else if (g0 != null && g0.getForum() != null && !TextUtils.isEmpty(g0.getForum().getId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(g0.getForum().getId()), g0.getForum().getName())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq6(FrsFragment frsFragment, nh6 nh6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, nh6Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.g = 0;
        this.h = "normal_page";
        this.i = 0;
        this.j = false;
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.a = frsFragment;
        this.d = nh6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new cq6(this.a, gen);
        this.o = new bq6(this.a);
        this.l = new m36();
    }

    public static boolean G(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) ? (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true : invokeL.booleanValue;
    }

    public static boolean H(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, frsViewData)) == null) {
            if (frsViewData != null) {
                return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public bq6 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (bq6) invokeV.objValue;
    }

    public void A0(int i, int i2, int i3) {
        cq6 cq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) || (cq6Var = this.n) == null) {
            return;
        }
        cq6Var.w(i, i2, i3);
    }

    public void B() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.o();
    }

    public void C() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.q();
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "frs_page".equals(this.h) || "normal_page".equals(this.h) || "book_page".equals(this.h) || "brand_page".equals(this.h) : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!D() || (nq6Var = this.c) == null) {
                return false;
            }
            return nq6Var.s();
        }
        return invokeV.booleanValue;
    }

    public void I(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            cq6 cq6Var = this.n;
            if (cq6Var != null) {
                cq6Var.n();
            }
            bq6 bq6Var = this.o;
            if (bq6Var != null) {
                bq6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            nq6 nq6Var = this.c;
            if (nq6Var != null) {
                nq6Var.x();
            }
            bq6 bq6Var = this.o;
            if (bq6Var != null) {
                bq6Var.k();
            }
            if (this.p != null) {
                ng.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                ng.a().removeCallbacks(this.q);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            nq6 nq6Var = this.c;
            if (nq6Var != null) {
                nq6Var.C();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.g = i;
            nq6 nq6Var = this.c;
            if (nq6Var != null) {
                nq6Var.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void N() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.z();
    }

    public void O(boolean z) {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.A(z);
    }

    public void P() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.B();
    }

    public void Q(MotionEvent motionEvent) {
        m36 m36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, motionEvent) == null) || (m36Var = this.l) == null) {
            return;
        }
        m36Var.c(motionEvent);
    }

    public void S(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, num) == null) {
            m0(num.intValue());
            if (D()) {
                X();
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c.F();
        }
    }

    public void U(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float z = z(forumData);
        nq6 nq6Var = this.c;
        if (nq6Var == null) {
            return;
        }
        nq6Var.K(forumData, frsViewData);
        this.c.N(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), z, false);
        this.c.P(forumData.getSignData());
    }

    public void V(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, frsViewData) == null) && frsViewData != null && D()) {
            U(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.c();
            }
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && D()) {
            g0(i);
        }
    }

    public void X() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.c0();
    }

    public void Y() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (frsHeaderViewContainer = this.b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.b.postDelayed(this.r, 100L);
    }

    public void Z(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || frsViewData == null || this.c == null || !D()) {
            return;
        }
        this.c.D(z(frsViewData.getForum()));
    }

    public void a0() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.G();
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || this.a.b0() == null || this.a.b0().V() == null) {
            return;
        }
        int E = this.a.b0().V().E();
        int B = this.a.b0().V().B();
        int z = this.a.b0().V().z();
        fi8 i = fi8.i();
        fi8.i().n(i.g("1~" + str, E, B, z), false);
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            nq6 nq6Var = this.c;
            if (nq6Var != null) {
                this.b.d(nq6Var.m());
                this.b.d(this.c.i());
                d0();
            }
            this.e = false;
        }
    }

    public final void d0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.H2() == null) {
            return;
        }
        this.a.H2().removeHeaderView(this.m.G());
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (z) {
                nq6 nq6Var = this.c;
                if (nq6Var != null) {
                    this.b.d(nq6Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            nq6 nq6Var2 = this.c;
            if (nq6Var2 == null || nq6Var2.i() == null || this.e) {
                return;
            }
            this.b.b(this.c.i(), this.b.getHeaderViewsCount());
            this.e = true;
        }
    }

    public void f0(int i) {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i) == null) || (nq6Var = this.c) == null || nq6Var.i() == null) {
            return;
        }
        View findViewById = this.c.i().findViewById(R.id.obfuscated_res_0x7f0907eb);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.c.o();
    }

    public void g0(int i) {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.M(i);
    }

    public void h0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.K(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.N(i, forumData.getLevelName(), forumData.getUser_level(), z(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.c.b(false);
    }

    public void i0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048607, this, frsViewData, z) == null) && frsViewData != null && D()) {
            h0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void j0(int i) {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i) == null) && D() && (nq6Var = this.c) != null) {
            nq6Var.O(i);
        }
    }

    public void k0(FrsViewData frsViewData) {
        cq6 cq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, frsViewData) == null) && D() && (cq6Var = this.n) != null) {
            cq6Var.t(this.c, frsViewData);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && D()) {
            g0(0);
        }
    }

    public void m0(int i) {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.S(i);
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            if (i > 1) {
                nq6 nq6Var = this.c;
                if (nq6Var != null) {
                    nq6Var.Q(false);
                    return;
                }
                return;
            }
            nq6 nq6Var2 = this.c;
            if (nq6Var2 != null) {
                nq6Var2.Q(true);
            }
        }
    }

    public void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.i = i;
        }
    }

    public void q0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void r0() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.W();
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            ng.a().postDelayed(this.q, 500L);
        }
    }

    public void t() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.e || (nq6Var = this.c) == null) {
            return;
        }
        this.b.a(nq6Var.i());
        this.e = true;
    }

    public void t0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048618, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public final void u(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048619, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            c0();
            if (this.c == null || z) {
                nq6 nq6Var = this.c;
                if (nq6Var != null) {
                    nq6Var.x();
                    this.c = null;
                }
                nq6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.d(this.g);
                this.c.J(this.s);
            }
            cq6 cq6Var = this.n;
            if (cq6Var != null) {
                this.c.T(cq6Var);
            }
            bq6 bq6Var = this.o;
            if (bq6Var != null) {
                this.c.R(bq6Var);
            }
            this.b.a(this.c.m());
            v(str);
            w0();
            s0();
        }
    }

    public void u0(List<ni8> list) {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, list) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.X(list);
        this.c.a();
    }

    public final void v(String str) {
        FrsFragment frsFragment;
        RelativeLayout G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.H2() == null || (G = this.m.G()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.H2().removeHeaderView(G);
            return;
        }
        this.a.H2().removeHeaderView(G);
        this.a.H2().t(G, 0);
    }

    public final void v0() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && D() && (nq6Var = this.c) != null) {
            nq6Var.Y();
        }
    }

    public void w() {
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (nq6Var = this.c) == null) {
            return;
        }
        nq6Var.a();
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            ng.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!D() || (nq6Var = this.c) == null) {
                return false;
            }
            return nq6Var.n();
        }
        return invokeV.booleanValue;
    }

    public void x0(boolean z) {
        bq6 bq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (bq6Var = this.o) == null) {
            return;
        }
        nq6 nq6Var = this.c;
        bq6Var.m(nq6Var != null && nq6Var.r());
        this.o.p(z);
    }

    public boolean y() {
        InterceptResult invokeV;
        nq6 nq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (!D() || (nq6Var = this.c) == null) {
                return false;
            }
            return nq6Var.j();
        }
        return invokeV.booleanValue;
    }

    public void y0() {
        cq6 cq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (cq6Var = this.n) == null) {
            return;
        }
        nq6 nq6Var = this.c;
        if (nq6Var != null) {
            cq6Var.v(nq6Var.t(), this.c.f());
        } else {
            cq6Var.v(false, "");
        }
        nq6 nq6Var2 = this.c;
        if (nq6Var2 != null) {
            this.n.u(nq6Var2.l());
        }
    }

    public final float z(ForumData forumData) {
        InterceptResult invokeL;
        cq6 cq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, forumData)) == null) {
            if (forumData == null || (cq6Var = this.n) == null) {
                return 0.0f;
            }
            return cq6Var.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void z0() {
        bq6 bq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (bq6Var = this.o) == null) {
            return;
        }
        bq6Var.q();
    }
}
