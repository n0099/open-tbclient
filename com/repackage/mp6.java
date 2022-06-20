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
public class mp6 extends b9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public wp6 c;
    public eh6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public x26 l;
    public FrsTabViewController m;
    public lp6 n;
    public kp6 o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp6 a;

        public a(mp6 mp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            lc6 k1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (k1 = this.a.a.k1()) != null && k1.Y() != null && !k1.Y().o() && !k1.a0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.X2() && this.a.k == 1 && this.a.E() && this.a.c != null && this.a.c.u()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.w0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp6 a;

        public b(mp6 mp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.k1().a0() || !this.a.b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.s0();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp6 a;

        public c(mp6 mp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp6Var;
        }

        public final void a(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2 instanceof vk) {
                ((vk) view2).refresh();
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
        public final /* synthetic */ mp6 a;

        public d(mp6 mp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09061c);
            FrsViewData P0 = this.a.a.P0();
            if (P0 != null && P0.getForum() != null && this.a.c != null && (view2 == this.a.c.g() || view2 == this.a.c.h() || view2 == this.a.c.k() || logicField == LogicField.INFO_AREA)) {
                if (this.a.a != null && P0.getForum() != null) {
                    StatisticItem param = new StatisticItem("c12046").param("fid", P0.getForum().getId()).param("fname", P0.getForum().getName()).param("obj_locate", this.a.a.O3() ? 1 : 2);
                    om6.a(param);
                    TiebaStatic.log(param);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (P0.getEntelechyTabInfo() != null && P0.getEntelechyTabInfo().a != null) {
                    for (int i = 0; i < P0.getEntelechyTabInfo().a.size(); i++) {
                        arrayList.add(P0.getEntelechyTabInfo().a.get(i).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), P0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(P0.serviceAreaFlutterData);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0921ab || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.u3()) {
                    return;
                }
                if (!ni.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.d()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090f62);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        om6.d(this.a.a.d(), this.a.a.c());
                    }
                    this.a.z0(true);
                    if (oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", this.a.a.d());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.obfuscated_res_0x7f0921e5 || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.u3()) {
                    return;
                }
                if (!ni.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.z()) {
                        this.a.A0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), ng.e(this.a.a.d(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090afd) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || P0 == null || P0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{P0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090aa0) {
                if (P0 == null || P0.getUserData() == null || !P0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = P0.getBawuCenterUrl();
                if (oi.isEmpty(bawuCenterUrl)) {
                    return;
                }
                cl4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (P0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", P0.getForum().getId()).param("uid", P0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f0911ec || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.u3() || this.a.i != 0 || !this.a.E() || this.a.c == null) {
                    return;
                }
                this.a.c.V(view2, false);
            } else if (id == R.id.obfuscated_res_0x7f090b08) {
                if (P0 == null || P0.getForum() == null || TextUtils.isEmpty(P0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(ng.g(P0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", P0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.obfuscated_res_0x7f090b56) {
                if (id != R.id.obfuscated_res_0x7f090b55 || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || P0 == null || P0.getForum() == null || TextUtils.isEmpty(P0.getForum().getId())) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> o = this.a.a.o();
                urlManager.dealOneLink(o, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + P0.getForum().getId()});
            } else if (P0 != null && P0.getForum() != null && !TextUtils.isEmpty(P0.getForum().getId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(P0.getForum().getId()), P0.getForum().getName())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mp6(FrsFragment frsFragment, eh6 eh6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, eh6Var, frsHeaderViewContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
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
        this.d = eh6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new lp6(this.a, gen);
        this.o = new kp6(this.a);
        this.l = new x26();
    }

    public static boolean H(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) ? (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true : invokeL.booleanValue;
    }

    public static boolean I(FrsViewData frsViewData) {
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

    public final float A(ForumData forumData) {
        InterceptResult invokeL;
        lp6 lp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, forumData)) == null) {
            if (forumData == null || (lp6Var = this.n) == null) {
                return 0.0f;
            }
            return lp6Var.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void A0() {
        lp6 lp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lp6Var = this.n) == null) {
            return;
        }
        wp6 wp6Var = this.c;
        if (wp6Var != null) {
            lp6Var.v(wp6Var.t(), this.c.f());
        } else {
            lp6Var.v(false, "");
        }
        wp6 wp6Var2 = this.c;
        if (wp6Var2 != null) {
            this.n.u(wp6Var2.l());
        }
    }

    public kp6 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (kp6) invokeV.objValue;
    }

    public void C() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.o();
    }

    public void C0() {
        kp6 kp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (kp6Var = this.o) == null) {
            return;
        }
        kp6Var.q();
    }

    public void D() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.q();
    }

    public void D0(int i, int i2, int i3) {
        lp6 lp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) || (lp6Var = this.n) == null) {
            return;
        }
        lp6Var.w(i, i2, i3);
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "frs_page".equals(this.h) || "normal_page".equals(this.h) || "book_page".equals(this.h) || "brand_page".equals(this.h) : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!E() || (wp6Var = this.c) == null) {
                return false;
            }
            return wp6Var.s();
        }
        return invokeV.booleanValue;
    }

    public void J(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            lp6 lp6Var = this.n;
            if (lp6Var != null) {
                lp6Var.n();
            }
            kp6 kp6Var = this.o;
            if (kp6Var != null) {
                kp6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            wp6 wp6Var = this.c;
            if (wp6Var != null) {
                wp6Var.x();
            }
            kp6 kp6Var = this.o;
            if (kp6Var != null) {
                kp6Var.k();
            }
            if (this.p != null) {
                qg.a().removeCallbacks(this.p);
            }
            if (this.q != null) {
                qg.a().removeCallbacks(this.q);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            wp6 wp6Var = this.c;
            if (wp6Var != null) {
                wp6Var.C();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.r);
            }
        }
    }

    public boolean N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.g = i;
            wp6 wp6Var = this.c;
            if (wp6Var != null) {
                wp6Var.d(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void O() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.z();
    }

    public void P(boolean z) {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.A(z);
    }

    public void Q() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.B();
    }

    public void R(MotionEvent motionEvent) {
        x26 x26Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, motionEvent) == null) || (x26Var = this.l) == null) {
            return;
        }
        x26Var.c(motionEvent);
    }

    public void S(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, num) == null) {
            o0(num.intValue());
            if (E()) {
                X();
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.c.F();
        }
    }

    public void U(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float A = A(forumData);
        wp6 wp6Var = this.c;
        if (wp6Var == null) {
            return;
        }
        wp6Var.K(forumData, frsViewData);
        this.c.N(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), A, false);
        this.c.P(forumData.getSignData());
    }

    public void V(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, frsViewData) == null) && frsViewData != null && E()) {
            U(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.c();
            }
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && E()) {
            h0(i);
        }
    }

    public void X() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.c0();
    }

    public void Y() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (frsHeaderViewContainer = this.b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.r);
        this.b.postDelayed(this.r, 100L);
    }

    public void Z(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || frsViewData == null || this.c == null || !E()) {
            return;
        }
        this.c.D(A(frsViewData.getForum()));
    }

    public void a0() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.G();
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || this.a.K0() == null || this.a.K0().W() == null) {
            return;
        }
        int F = this.a.K0().W().F();
        int C = this.a.K0().W().C();
        int A = this.a.K0().W().A();
        zf8 i = zf8.i();
        zf8.i().n(i.g("1~" + str, F, C, A), false);
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            wp6 wp6Var = this.c;
            if (wp6Var != null) {
                this.b.d(wp6Var.m());
                this.b.d(this.c.i());
                e0();
            }
            this.e = false;
        }
    }

    public final void e0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.w3() == null) {
            return;
        }
        this.a.w3().removeHeaderView(this.m.I());
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (z) {
                wp6 wp6Var = this.c;
                if (wp6Var != null) {
                    this.b.d(wp6Var.i());
                    this.e = false;
                    return;
                }
                return;
            }
            wp6 wp6Var2 = this.c;
            if (wp6Var2 == null || wp6Var2.i() == null || this.e) {
                return;
            }
            this.b.b(this.c.i(), this.b.getHeaderViewsCount());
            this.e = true;
        }
    }

    public void g0(int i) {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i) == null) || (wp6Var = this.c) == null || wp6Var.i() == null) {
            return;
        }
        View findViewById = this.c.i().findViewById(R.id.obfuscated_res_0x7f0907ba);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.c.o();
    }

    public void h0(int i) {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.M(i);
    }

    public void i0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.K(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.N(i, forumData.getLevelName(), forumData.getUser_level(), A(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.c.b(false);
    }

    public void j0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048610, this, frsViewData, z) == null) && frsViewData != null && E()) {
            i0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void k0(int i) {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && E() && (wp6Var = this.c) != null) {
            wp6Var.O(i);
        }
    }

    public void l0(FrsViewData frsViewData) {
        lp6 lp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, frsViewData) == null) && E() && (lp6Var = this.n) != null) {
            lp6Var.t(this.c, frsViewData);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && E()) {
            h0(0);
        }
    }

    public void o0(int i) {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048614, this, i) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.S(i);
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            if (i > 1) {
                wp6 wp6Var = this.c;
                if (wp6Var != null) {
                    wp6Var.Q(false);
                    return;
                }
                return;
            }
            wp6 wp6Var2 = this.c;
            if (wp6Var2 != null) {
                wp6Var2.Q(true);
            }
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.i = i;
        }
    }

    public void r0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void s0() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.W();
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            qg.a().postDelayed(this.q, 500L);
        }
    }

    public void u() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.e || (wp6Var = this.c) == null) {
            return;
        }
        this.b.a(wp6Var.i());
        this.e = true;
    }

    public void u0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public final void v(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048622, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            d0();
            if (this.c == null || z) {
                wp6 wp6Var = this.c;
                if (wp6Var != null) {
                    wp6Var.x();
                    this.c = null;
                }
                wp6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.d(this.g);
                this.c.J(this.s);
            }
            lp6 lp6Var = this.n;
            if (lp6Var != null) {
                this.c.T(lp6Var);
            }
            kp6 kp6Var = this.o;
            if (kp6Var != null) {
                this.c.R(kp6Var);
            }
            this.b.a(this.c.m());
            w(str);
            x0();
            t0();
        }
    }

    public void v0(List<hg8> list) {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, list) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.X(list);
        this.c.a();
    }

    public final void w(String str) {
        FrsFragment frsFragment;
        RelativeLayout I;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.w3() == null || (I = this.m.I()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.w3().removeHeaderView(I);
            return;
        }
        this.a.w3().removeHeaderView(I);
        this.a.w3().t(I, 0);
    }

    public final void w0() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && E() && (wp6Var = this.c) != null) {
            wp6Var.Y();
        }
    }

    public void x() {
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (wp6Var = this.c) == null) {
            return;
        }
        wp6Var.a();
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            qg.a().postDelayed(this.p, 4000L);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (!E() || (wp6Var = this.c) == null) {
                return false;
            }
            return wp6Var.n();
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        wp6 wp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (!E() || (wp6Var = this.c) == null) {
                return false;
            }
            return wp6Var.j();
        }
        return invokeV.booleanValue;
    }

    public void z0(boolean z) {
        kp6 kp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || (kp6Var = this.o) == null) {
            return;
        }
        wp6 wp6Var = this.c;
        kp6Var.m(wp6Var != null && wp6Var.r());
        this.o.p(z);
    }
}
