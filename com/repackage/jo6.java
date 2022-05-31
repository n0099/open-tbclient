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
/* loaded from: classes6.dex */
public class jo6 extends z8<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public to6 c;
    public eg6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public x16 l;
    public FrsTabViewController m;
    public io6 n;
    public ho6 o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo6 a;

        public a(jo6 jo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            lb6 y0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (y0 = this.a.a.y0()) != null && y0.Y() != null && !y0.Y().o() && !y0.a0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.j2() && this.a.k == 1 && this.a.C() && this.a.c != null && this.a.c.u()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.u0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo6 a;

        public b(jo6 jo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.y0().a0() || !this.a.b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.p0();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo6 a;

        public c(jo6 jo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof rk) {
                ((rk) view2).refresh();
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

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo6 a;

        public d(jo6 jo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09063c);
            FrsViewData h0 = this.a.a.h0();
            if (h0 != null && h0.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.k() || logicField == LogicField.INFO_AREA)) {
                if (this.a.a != null && h0.getForum() != null) {
                    StatisticItem param = new StatisticItem("c12046").param("fid", h0.getForum().getId()).param("fname", h0.getForum().getName()).param("obj_locate", this.a.a.a3() ? 1 : 2);
                    ll6.a(param);
                    TiebaStatic.log(param);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (h0.getEntelechyTabInfo() != null && h0.getEntelechyTabInfo().a != null) {
                    for (int i = 0; i < h0.getEntelechyTabInfo().a.size(); i++) {
                        arrayList.add(h0.getEntelechyTabInfo().a.get(i).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), h0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(h0.serviceAreaFlutterData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0921af || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.G2()) {
                    return;
                }
                if (!ji.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.b()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090f73);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        ll6.d(this.a.a.b(), this.a.a.a());
                    }
                    this.a.w0(true);
                    if (ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.a.a.b());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.obfuscated_res_0x7f0921e9 || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.G2()) {
                    return;
                }
                if (!ji.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.x()) {
                        this.a.x0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), jg.e(this.a.a.b(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090b0e) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || h0 == null || h0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{h0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090ab1) {
                if (h0 == null || h0.getUserData() == null || !h0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = h0.getBawuCenterUrl();
                if (ki.isEmpty(bawuCenterUrl)) {
                    return;
                }
                sk4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (h0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", h0.getForum().getId()).param("uid", h0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f0911f7 || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.G2() || this.a.i != 0 || !this.a.C() || this.a.c == null) {
                    return;
                }
                this.a.c.V(view2, false);
            } else if (id == R.id.obfuscated_res_0x7f090b19) {
                if (h0 == null || h0.getForum() == null || TextUtils.isEmpty(h0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(jg.g(h0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", h0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.obfuscated_res_0x7f090b67) {
                if (id != R.id.obfuscated_res_0x7f090b66 || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || h0 == null || h0.getForum() == null || TextUtils.isEmpty(h0.getForum().getId())) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> i2 = this.a.a.i();
                urlManager.dealOneLink(i2, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + h0.getForum().getId()});
            } else if (h0 != null && h0.getForum() != null && !TextUtils.isEmpty(h0.getForum().getId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(h0.getForum().getId()), h0.getForum().getName())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo6(FrsFragment frsFragment, eg6 eg6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, eg6Var, frsHeaderViewContainer};
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
        this.d = eg6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new io6(this.a, gen);
        this.o = new ho6(this.a);
        this.l = new x16();
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
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.o();
    }

    public void B() {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.q();
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
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!C() || (to6Var = this.c) == null) {
                return false;
            }
            return to6Var.s();
        }
        return invokeV.booleanValue;
    }

    public void H(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            io6 io6Var = this.n;
            if (io6Var != null) {
                io6Var.n();
            }
            ho6 ho6Var = this.o;
            if (ho6Var != null) {
                ho6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            to6 to6Var = this.c;
            if (to6Var != null) {
                to6Var.x();
            }
            ho6 ho6Var = this.o;
            if (ho6Var != null) {
                ho6Var.k();
            }
            if (this.p != null) {
                mg.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                mg.a().removeCallbacks(this.q);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            to6 to6Var = this.c;
            if (to6Var != null) {
                to6Var.C();
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
            to6 to6Var = this.c;
            if (to6Var != null) {
                to6Var.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void M() {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.z();
    }

    public void N(boolean z) {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.A(z);
    }

    public void O() {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.B();
    }

    public void P(MotionEvent motionEvent) {
        x16 x16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, motionEvent) == null) || (x16Var = this.l) == null) {
            return;
        }
        x16Var.c(motionEvent);
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

    public void R() {
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
        to6 to6Var = this.c;
        if (to6Var == null) {
            return;
        }
        to6Var.K(forumData, frsViewData);
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
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.c0();
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
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.G();
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || this.a.c0() == null || this.a.c0().V() == null) {
            return;
        }
        int E = this.a.c0().V().E();
        int B = this.a.c0().V().B();
        int z = this.a.c0().V().z();
        gf8 i = gf8.i();
        gf8.i().n(i.g("1~" + str, E, B, z), false);
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            to6 to6Var = this.c;
            if (to6Var != null) {
                this.b.d(to6Var.m());
                this.b.d(this.c.i());
                c0();
            }
            this.e = false;
        }
    }

    public final void c0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.I2() == null) {
            return;
        }
        this.a.I2().removeHeaderView(this.m.I());
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                to6 to6Var = this.c;
                if (to6Var != null) {
                    this.b.d(to6Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            to6 to6Var2 = this.c;
            if (to6Var2 == null || to6Var2.i() == null || this.e) {
                return;
            }
            this.b.b(this.c.i(), this.b.getHeaderViewsCount());
            this.e = true;
        }
    }

    public void e0(int i) {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || (to6Var = this.c) == null || to6Var.i() == null) {
            return;
        }
        View findViewById = this.c.i().findViewById(R.id.obfuscated_res_0x7f0907cf);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.c.o();
    }

    public void f0(int i) {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.M(i);
    }

    public void g0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.K(forumData, frsViewData);
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
        to6 to6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && C() && (to6Var = this.c) != null) {
            to6Var.O(i);
        }
    }

    public void j0(FrsViewData frsViewData) {
        io6 io6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, frsViewData) == null) && C() && (io6Var = this.n) != null) {
            io6Var.t(this.c, frsViewData);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && C()) {
            f0(0);
        }
    }

    public void l0(int i) {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.S(i);
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            if (i > 1) {
                to6 to6Var = this.c;
                if (to6Var != null) {
                    to6Var.Q(false);
                    return;
                }
                return;
            }
            to6 to6Var2 = this.c;
            if (to6Var2 != null) {
                to6Var2.Q(true);
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

    public void p0() {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.W();
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            mg.a().postDelayed(this.q, 500L);
        }
    }

    public void s() {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.e || (to6Var = this.c) == null) {
            return;
        }
        this.b.a(to6Var.i());
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
                to6 to6Var = this.c;
                if (to6Var != null) {
                    to6Var.x();
                    this.c = null;
                }
                to6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.d(this.g);
                this.c.J(this.s);
            }
            io6 io6Var = this.n;
            if (io6Var != null) {
                this.c.T(io6Var);
            }
            ho6 ho6Var = this.o;
            if (ho6Var != null) {
                this.c.R(ho6Var);
            }
            this.b.a(this.c.m());
            u(str);
            v0();
            q0();
        }
    }

    public void t0(List<of8> list) {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, list) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.X(list);
        this.c.a();
    }

    public final void u(String str) {
        FrsFragment frsFragment;
        RelativeLayout I;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.I2() == null || (I = this.m.I()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.I2().removeHeaderView(I);
            return;
        }
        this.a.I2().removeHeaderView(I);
        this.a.I2().t(I, 0);
    }

    public final void u0() {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && C() && (to6Var = this.c) != null) {
            to6Var.Y();
        }
    }

    public void v() {
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (to6Var = this.c) == null) {
            return;
        }
        to6Var.a();
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            mg.a().postDelayed(this.p, 4000L);
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (!C() || (to6Var = this.c) == null) {
                return false;
            }
            return to6Var.n();
        }
        return invokeV.booleanValue;
    }

    public void w0(boolean z) {
        ho6 ho6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || (ho6Var = this.o) == null) {
            return;
        }
        to6 to6Var = this.c;
        ho6Var.m(to6Var != null && to6Var.r());
        this.o.p(z);
    }

    public boolean x() {
        InterceptResult invokeV;
        to6 to6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!C() || (to6Var = this.c) == null) {
                return false;
            }
            return to6Var.j();
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        io6 io6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (io6Var = this.n) == null) {
            return;
        }
        to6 to6Var = this.c;
        if (to6Var != null) {
            io6Var.v(to6Var.t(), this.c.f());
        } else {
            io6Var.v(false, "");
        }
        to6 to6Var2 = this.c;
        if (to6Var2 != null) {
            this.n.u(to6Var2.l());
        }
    }

    public final float y(ForumData forumData) {
        InterceptResult invokeL;
        io6 io6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, forumData)) == null) {
            if (forumData == null || (io6Var = this.n) == null) {
                return 0.0f;
            }
            return io6Var.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void y0() {
        ho6 ho6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (ho6Var = this.o) == null) {
            return;
        }
        ho6Var.q();
    }

    public ho6 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.o : (ho6) invokeV.objValue;
    }

    public void z0(int i, int i2, int i3) {
        io6 io6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048630, this, i, i2, i3) == null) || (io6Var = this.n) == null) {
            return;
        }
        io6Var.w(i, i2, i3);
    }
}
