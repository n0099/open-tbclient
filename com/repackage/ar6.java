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
public class ar6 extends z8<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public lr6 c;
    public gi6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public j36 l;
    public FrsTabViewController m;
    public zq6 n;
    public yq6 o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar6 a;

        public a(ar6 ar6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            od6 w0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (w0 = this.a.a.w0()) != null && w0.Y() != null && !w0.Y().o() && !w0.a0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.i2() && this.a.k == 1 && this.a.C() && this.a.c != null && this.a.c.u()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.u0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar6 a;

        public b(ar6 ar6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.w0().a0() || !this.a.b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.q0();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar6 a;

        public c(ar6 ar6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof wk) {
                ((wk) view2).refresh();
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
        public final /* synthetic */ ar6 a;

        public d(ar6 ar6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f090663);
            FrsViewData g0 = this.a.a.g0();
            if (g0 != null && g0.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.k() || logicField == LogicField.INFO_AREA)) {
                if (this.a.a != null && g0.getForum() != null) {
                    StatisticItem param = new StatisticItem("c12046").param("fid", g0.getForum().getId()).param("fname", g0.getForum().getName()).param("obj_locate", this.a.a.V2() ? 1 : 2);
                    co6.a(param);
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
            if (id == R.id.obfuscated_res_0x7f0921b2 || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.D2()) {
                    return;
                }
                if (!mi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.b()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fa1);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        co6.d(this.a.a.b(), this.a.a.a());
                    }
                    this.a.w0(true);
                    if (ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.a.a.b());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.obfuscated_res_0x7f0921ec || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.D2()) {
                    return;
                }
                if (!mi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.x()) {
                        this.a.x0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), mg.e(this.a.a.b(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090b36) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || g0 == null || g0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{g0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090ad5) {
                if (g0 == null || g0.getUserData() == null || !g0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = g0.getBawuCenterUrl();
                if (ni.isEmpty(bawuCenterUrl)) {
                    return;
                }
                vl4.m(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (g0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", g0.getForum().getId()).param("uid", g0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f091227 || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.D2() || this.a.i != 0 || !this.a.C() || this.a.c == null) {
                    return;
                }
                this.a.c.V(view2, false);
            } else if (id == R.id.obfuscated_res_0x7f090b41) {
                if (g0 == null || g0.getForum() == null || TextUtils.isEmpty(g0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(mg.g(g0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", g0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.obfuscated_res_0x7f090b8f) {
                if (id != R.id.obfuscated_res_0x7f090b8e || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || g0 == null || g0.getForum() == null || TextUtils.isEmpty(g0.getForum().getId())) {
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
    public ar6(FrsFragment frsFragment, gi6 gi6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, gi6Var, frsHeaderViewContainer};
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
        this.d = gi6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new zq6(this.a, gen);
        this.o = new yq6(this.a);
        this.l = new j36();
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
                return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().b())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void A() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.o();
    }

    public void B() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.q();
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "frs_page".equals(this.h) || "normal_page".equals(this.h) || "book_page".equals(this.h) || "brand_page".equals(this.h) : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!C() || (lr6Var = this.c) == null) {
                return false;
            }
            return lr6Var.s();
        }
        return invokeV.booleanValue;
    }

    public void H(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            zq6 zq6Var = this.n;
            if (zq6Var != null) {
                zq6Var.n();
            }
            yq6 yq6Var = this.o;
            if (yq6Var != null) {
                yq6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            lr6 lr6Var = this.c;
            if (lr6Var != null) {
                lr6Var.x();
            }
            yq6 yq6Var = this.o;
            if (yq6Var != null) {
                yq6Var.k();
            }
            if (this.p != null) {
                pg.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                pg.a().removeCallbacks(this.q);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            lr6 lr6Var = this.c;
            if (lr6Var != null) {
                lr6Var.C();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.g = i;
            lr6 lr6Var = this.c;
            if (lr6Var != null) {
                lr6Var.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void M() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.z();
    }

    public void N(boolean z) {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.A(z);
    }

    public void O() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.B();
    }

    public void P(MotionEvent motionEvent) {
        j36 j36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, motionEvent) == null) || (j36Var = this.l) == null) {
            return;
        }
        j36Var.c(motionEvent);
    }

    public void Q(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, num) == null) {
            l0(num.intValue());
            if (C()) {
                W();
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.F();
        }
    }

    public void T(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float y = y(forumData);
        lr6 lr6Var = this.c;
        if (lr6Var == null) {
            return;
        }
        lr6Var.K(forumData, frsViewData);
        this.c.N(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), y, false);
        this.c.P(forumData.getSignData());
    }

    public void U(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, frsViewData) == null) && frsViewData != null && C()) {
            T(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.c();
            }
        }
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && C()) {
            f0(i);
        }
    }

    public void W() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.c0();
    }

    public void X() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (frsHeaderViewContainer = this.b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.b.postDelayed(this.r, 100L);
    }

    public void Y(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, frsViewData) == null) || frsViewData == null || this.c == null || !C()) {
            return;
        }
        this.c.D(y(frsViewData.getForum()));
    }

    public void Z() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.G();
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || this.a.b0() == null || this.a.b0().V() == null) {
            return;
        }
        int E = this.a.b0().V().E();
        int B = this.a.b0().V().B();
        int z = this.a.b0().V().z();
        bj8 i = bj8.i();
        bj8.i().n(i.g("1~" + str, E, B, z), false);
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            lr6 lr6Var = this.c;
            if (lr6Var != null) {
                this.b.d(lr6Var.m());
                this.b.d(this.c.i());
                c0();
            }
            this.e = false;
        }
    }

    public final void c0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.E2() == null) {
            return;
        }
        this.a.E2().removeHeaderView(this.m.G());
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                lr6 lr6Var = this.c;
                if (lr6Var != null) {
                    this.b.d(lr6Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            lr6 lr6Var2 = this.c;
            if (lr6Var2 == null || lr6Var2.i() == null || this.e) {
                return;
            }
            this.b.b(this.c.i(), this.b.getHeaderViewsCount());
            this.e = true;
        }
    }

    public void e0(int i) {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || (lr6Var = this.c) == null || lr6Var.i() == null) {
            return;
        }
        View findViewById = this.c.i().findViewById(R.id.obfuscated_res_0x7f0907f4);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.c.o();
    }

    public void f0(int i) {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.M(i);
    }

    public void g0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.K(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.N(i, forumData.getLevelName(), forumData.getUser_level(), y(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.c.b(false);
    }

    public void h0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048605, this, frsViewData, z) == null) && frsViewData != null && C()) {
            g0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void i0(int i) {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && C() && (lr6Var = this.c) != null) {
            lr6Var.O(i);
        }
    }

    public void j0(FrsViewData frsViewData) {
        zq6 zq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, frsViewData) == null) && C() && (zq6Var = this.n) != null) {
            zq6Var.t(this.c, frsViewData);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && C()) {
            f0(0);
        }
    }

    public void l0(int i) {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.S(i);
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            if (i > 1) {
                lr6 lr6Var = this.c;
                if (lr6Var != null) {
                    lr6Var.Q(false);
                    return;
                }
                return;
            }
            lr6 lr6Var2 = this.c;
            if (lr6Var2 != null) {
                lr6Var2.Q(true);
            }
        }
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.i = i;
        }
    }

    public void o0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void q0() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.W();
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            pg.a().postDelayed(this.q, 500L);
        }
    }

    public void s() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.e || (lr6Var = this.c) == null) {
            return;
        }
        this.b.a(lr6Var.i());
        this.e = true;
    }

    public void s0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        t(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public final void t(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            b0();
            if (this.c == null || z) {
                lr6 lr6Var = this.c;
                if (lr6Var != null) {
                    lr6Var.x();
                    this.c = null;
                }
                lr6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.d(this.g);
                this.c.J(this.s);
            }
            zq6 zq6Var = this.n;
            if (zq6Var != null) {
                this.c.T(zq6Var);
            }
            yq6 yq6Var = this.o;
            if (yq6Var != null) {
                this.c.R(yq6Var);
            }
            this.b.a(this.c.m());
            u(str);
            v0();
            r0();
        }
    }

    public void t0(List<jj8> list) {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, list) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.X(list);
        this.c.a();
    }

    public final void u(String str) {
        FrsFragment frsFragment;
        RelativeLayout G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.E2() == null || (G = this.m.G()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.E2().removeHeaderView(G);
            return;
        }
        this.a.E2().removeHeaderView(G);
        this.a.E2().t(G, 0);
    }

    public final void u0() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && C() && (lr6Var = this.c) != null) {
            lr6Var.Y();
        }
    }

    public void v() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (lr6Var = this.c) == null) {
            return;
        }
        lr6Var.a();
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            pg.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (!C() || (lr6Var = this.c) == null) {
                return false;
            }
            return lr6Var.n();
        }
        return invokeV.booleanValue;
    }

    public void w0(boolean z) {
        yq6 yq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || (yq6Var = this.o) == null) {
            return;
        }
        lr6 lr6Var = this.c;
        yq6Var.m(lr6Var != null && lr6Var.r());
        this.o.p(z);
    }

    public boolean x() {
        InterceptResult invokeV;
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!C() || (lr6Var = this.c) == null) {
                return false;
            }
            return lr6Var.j();
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        zq6 zq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (zq6Var = this.n) == null) {
            return;
        }
        lr6 lr6Var = this.c;
        if (lr6Var != null) {
            zq6Var.v(lr6Var.t(), this.c.f());
        } else {
            zq6Var.v(false, "");
        }
        lr6 lr6Var2 = this.c;
        if (lr6Var2 != null) {
            this.n.u(lr6Var2.l());
        }
    }

    public final float y(ForumData forumData) {
        InterceptResult invokeL;
        zq6 zq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, forumData)) == null) {
            if (forumData == null || (zq6Var = this.n) == null) {
                return 0.0f;
            }
            return zq6Var.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void y0() {
        yq6 yq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (yq6Var = this.o) == null) {
            return;
        }
        yq6Var.q();
    }

    public yq6 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.o : (yq6) invokeV.objValue;
    }

    public void z0(int i, int i2, int i3) {
        zq6 zq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048630, this, i, i2, i3) == null) || (zq6Var = this.n) == null) {
            return;
        }
        zq6Var.w(i, i2, i3);
    }
}
