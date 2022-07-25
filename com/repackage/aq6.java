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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.frs.unreadbawu.BawuUnreadRequestMessage;
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
public class aq6 extends b9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public FrsHeaderViewContainer b;
    public iq6 c;
    public bi6 d;
    public boolean e;
    public BdUniqueId f;
    public int g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public v36 l;
    public FrsTabViewController m;
    public zp6 n;
    public yp6 o;
    public final View.OnClickListener p;
    public final Runnable q;
    public final Runnable r;
    public Runnable s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq6 a;

        public a(aq6 aq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            LogicField logicField = (LogicField) view2.getTag(R.id.obfuscated_res_0x7f09061e);
            FrsViewData Q0 = this.a.a.Q0();
            if (Q0 != null && Q0.getForum() != null && this.a.c != null && (view2 == this.a.c.f() || view2 == this.a.c.g() || view2 == this.a.c.j() || logicField == LogicField.INFO_AREA)) {
                StatisticItem statisticItem = new StatisticItem("c12046");
                if (this.a.a != null && Q0.getForum() != null) {
                    int i = this.a.a.R3() ? 1 : 2;
                    statisticItem.param("fid", Q0.getForum().getId());
                    statisticItem.param("fname", Q0.getForum().getName());
                    statisticItem.param("obj_locate", i);
                    kn6.a(statisticItem);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (Q0.getEntelechyTabInfo() != null && Q0.getEntelechyTabInfo().a != null) {
                    for (int i2 = 0; i2 < Q0.getEntelechyTabInfo().a.size(); i2++) {
                        arrayList.add(Q0.getEntelechyTabInfo().a.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), Q0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                forumDetailActivityConfig.setServiceAreaListData(Q0.serviceAreaFlutterData);
                int baWuNoticeNum = Q0.getBaWuNoticeNum();
                forumDetailActivityConfig.setRedPotNum(String.valueOf(baWuNoticeNum));
                if (Q0.getUserData() != null) {
                    if (Q0.getUserData().getIs_manager() == 1 && baWuNoticeNum > 0) {
                        MessageManager.getInstance().sendMessage(new BawuUnreadRequestMessage(this.a.a.l));
                    }
                    Q0.setBaWuNoticeNum(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921721));
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (Q0.getUserData().getIs_manager() == 1) {
                        if (baWuNoticeNum > 0) {
                            statisticItem.param("obj_type", 1);
                        } else {
                            statisticItem.param("obj_type", 2);
                        }
                    }
                    if (Q0.getUserData().isOtherBawu()) {
                        statisticItem.param("obj_type", 3);
                    } else if (Q0.getUserData().isNormal()) {
                        statisticItem.param("obj_type", 4);
                    }
                }
                TiebaStatic.log(statisticItem);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092250 || logicField == LogicField.LIKE_BTN) {
                if (this.a.a.x3()) {
                    return;
                }
                if (!ni.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                } else if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", this.a.a.d()));
                } else {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090f6c);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        kn6.d(this.a.a.d(), this.a.a.c());
                    }
                    this.a.x0(true);
                    if (oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c10048");
                    statisticItem2.param("fid", this.a.a.d());
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem2);
                }
            } else if (id == R.id.obfuscated_res_0x7f09228d || logicField == LogicField.SIGN_BTN) {
                if (this.a.a.x3()) {
                    return;
                }
                if (!ni.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                } else if (ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity())) {
                    if (!this.a.y()) {
                        this.a.z0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(this.a.a.getPageContext().getPageActivity(), ng.e(this.a.a.d(), 0), 24002)));
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090afe) {
                if (!ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || Q0 == null || Q0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) this.a.getPageContext(), new String[]{Q0.getGameUrl()}, true);
            } else if (id == R.id.obfuscated_res_0x7f090aa1) {
                if (Q0 == null || Q0.getUserData() == null || !Q0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = Q0.getBawuCenterUrl();
                if (oi.isEmpty(bawuCenterUrl)) {
                    return;
                }
                sl4.o(this.a.getPageContext().getPageActivity(), bawuCenterUrl);
                if (Q0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", Q0.getForum().getId()).param("uid", Q0.getUserData().getUserId()));
                }
            } else if (id == R.id.obfuscated_res_0x7f091269 || logicField == LogicField.LEVEL_AND_LEVEL_NAME) {
                if (this.a.a.x3() || this.a.i != 0 || !this.a.D() || this.a.c == null) {
                    return;
                }
                this.a.c.S(view2, false);
            } else if (id == R.id.obfuscated_res_0x7f090b09) {
                if (Q0 == null || Q0.getForum() == null || TextUtils.isEmpty(Q0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(ng.g(Q0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem3 = new StatisticItem("c13666");
                statisticItem3.param("fid", Q0.getForum().getId());
                TiebaStatic.log(statisticItem3);
            } else if (id != R.id.obfuscated_res_0x7f090b58) {
                if (id != R.id.obfuscated_res_0x7f090b57 || !ViewHelper.checkUpIsLogin(this.a.mContext.getPageActivity()) || Q0 == null || Q0.getForum() == null || TextUtils.isEmpty(Q0.getForum().getId())) {
                    return;
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> o = this.a.a.o();
                urlManager.dealOneLink(o, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + Q0.getForum().getId()});
            } else if (Q0 != null && Q0.getForum() != null && !TextUtils.isEmpty(Q0.getForum().getId())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(Q0.getForum().getId()), Q0.getForum().getName())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq6 a;

        public b(aq6 aq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            id6 l1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.i == 0 && (l1 = this.a.a.l1()) != null && l1.Z() != null && !l1.Z().o() && !l1.b0() && this.a.b.isShown() && this.a.a.isPrimary() && !this.a.j && this.a.a.Y2() && this.a.k == 1 && this.a.D() && this.a.c != null && this.a.c.t()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                this.a.v0();
                this.a.a.c = true;
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq6 a;

        public c(aq6 aq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.i != 0 || this.a.a.l1().b0() || !this.a.b.isShown() || !this.a.a.isPrimary() || this.a.a.getActivity() == null || this.a.a.getActivity().getIntent() == null || FrsActivityConfig.FRS_FROM_ITEM.equals(this.a.a.getActivity().getIntent().getStringExtra("from"))) {
                return;
            }
            this.a.r0();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq6 a;

        public d(aq6 aq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq6Var;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq6(FrsFragment frsFragment, bi6 bi6Var, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, bi6Var, frsHeaderViewContainer};
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
        this.d = bi6Var;
        this.b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f = gen;
        this.n = new zp6(this.a, gen);
        this.o = new yp6(this.a);
        this.l = new v36();
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

    public yp6 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (yp6) invokeV.objValue;
    }

    public void A0() {
        yp6 yp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (yp6Var = this.o) == null) {
            return;
        }
        yp6Var.q();
    }

    public void B() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.n();
    }

    public void C() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.p();
    }

    public void C0(int i, int i2, int i3) {
        zp6 zp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) || (zp6Var = this.n) == null) {
            return;
        }
        zp6Var.w(i, i2, i3);
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "frs_page".equals(this.h) || "normal_page".equals(this.h) || "book_page".equals(this.h) || "brand_page".equals(this.h) : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!D() || (iq6Var = this.c) == null) {
                return false;
            }
            return iq6Var.r();
        }
        return invokeV.booleanValue;
    }

    public void I(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            zp6 zp6Var = this.n;
            if (zp6Var != null) {
                zp6Var.n();
            }
            yp6 yp6Var = this.o;
            if (yp6Var != null) {
                yp6Var.j();
            }
            this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            iq6 iq6Var = this.c;
            if (iq6Var != null) {
                iq6Var.u();
            }
            yp6 yp6Var = this.o;
            if (yp6Var != null) {
                yp6Var.k();
            }
            if (this.q != null) {
                qg.a().removeCallbacks(this.q);
            }
            if (this.r != null) {
                qg.a().removeCallbacks(this.r);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            iq6 iq6Var = this.c;
            if (iq6Var != null) {
                iq6Var.z();
            }
            FrsHeaderViewContainer frsHeaderViewContainer = this.b;
            if (frsHeaderViewContainer != null) {
                frsHeaderViewContainer.removeCallbacks(this.s);
            }
        }
    }

    public boolean M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.g = i;
            iq6 iq6Var = this.c;
            if (iq6Var != null) {
                iq6Var.c(i);
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void N() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.w();
    }

    public void O(boolean z) {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.x(z);
    }

    public void P() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.y();
    }

    public void Q(MotionEvent motionEvent) {
        v36 v36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, motionEvent) == null) || (v36Var = this.l) == null) {
            return;
        }
        v36Var.c(motionEvent);
    }

    public void R(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            n0(num.intValue());
            if (D()) {
                W();
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c.C();
        }
    }

    public void T(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, forumData, frsViewData) == null) || forumData == null || frsViewData == null) {
            return;
        }
        float z = z(forumData);
        iq6 iq6Var = this.c;
        if (iq6Var == null) {
            return;
        }
        iq6Var.H(forumData, frsViewData);
        this.c.K(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), z, false);
        this.c.M(forumData.getSignData());
    }

    public void U(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, frsViewData) == null) && frsViewData != null && D()) {
            T(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.h)) {
                this.c.b();
            }
        }
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && D()) {
            g0(i);
        }
    }

    public void W() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.Z();
    }

    public void X() {
        FrsHeaderViewContainer frsHeaderViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (frsHeaderViewContainer = this.b) == null) {
            return;
        }
        frsHeaderViewContainer.removeCallbacks(this.s);
        this.b.postDelayed(this.s, 100L);
    }

    public void Y(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) || frsViewData == null || this.c == null || !D()) {
            return;
        }
        this.c.A(z(frsViewData.getForum()));
    }

    public void Z() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.D();
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.a.L0() == null || this.a.L0().X() == null) {
            return;
        }
        int G = this.a.L0().X().G();
        int D = this.a.L0().X().D();
        int B = this.a.L0().X().B();
        ug8 i = ug8.i();
        ug8.i().n(i.g("1~" + str, G, D, B), false);
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            iq6 iq6Var = this.c;
            if (iq6Var != null) {
                this.b.d(iq6Var.l());
                this.b.d(this.c.h());
                d0();
            }
            this.e = false;
        }
    }

    public final void d0() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.z3() == null) {
            return;
        }
        this.a.z3().removeHeaderView(this.m.I());
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (z) {
                iq6 iq6Var = this.c;
                if (iq6Var != null) {
                    this.b.d(iq6Var.h());
                    this.e = false;
                    return;
                }
                return;
            }
            iq6 iq6Var2 = this.c;
            if (iq6Var2 == null || iq6Var2.h() == null || this.e) {
                return;
            }
            this.b.b(this.c.h(), this.b.getHeaderViewsCount());
            this.e = true;
        }
    }

    public void f0(int i) {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i) == null) || (iq6Var = this.c) == null || iq6Var.h() == null) {
            return;
        }
        View findViewById = this.c.h().findViewById(R.id.obfuscated_res_0x7f0907bf);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.c.n();
    }

    public void g0(int i) {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048606, this, i) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.J(i);
    }

    public void h0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), forumData, frsViewData, Boolean.valueOf(z)}) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.H(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.c.K(i, forumData.getLevelName(), forumData.getUser_level(), z(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.c.a(false);
    }

    public void i0(FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048608, this, frsViewData, z) == null) && frsViewData != null && D()) {
            h0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void j0(int i) {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048609, this, i) == null) && D() && (iq6Var = this.c) != null) {
            iq6Var.L(i);
        }
    }

    public void k0(FrsViewData frsViewData) {
        zp6 zp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, frsViewData) == null) && D() && (zp6Var = this.n) != null) {
            zp6Var.t(this.c, frsViewData);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && D()) {
            g0(0);
        }
    }

    public void n0(int i) {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048612, this, i) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.P(i);
    }

    public void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            if (i > 1) {
                iq6 iq6Var = this.c;
                if (iq6Var != null) {
                    iq6Var.N(false);
                    return;
                }
                return;
            }
            iq6 iq6Var2 = this.c;
            if (iq6Var2 != null) {
                iq6Var2.N(true);
            }
        }
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.i = i;
        }
    }

    public void q0(FrsTabViewController frsTabViewController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, frsTabViewController) == null) {
            this.m = frsTabViewController;
        }
    }

    public void r0() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.T();
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            qg.a().postDelayed(this.r, 500L);
        }
    }

    public void t0(String str, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048618, this, str, frsViewData) == null) || frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        v(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public void u() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || this.e || (iq6Var = this.c) == null) {
            return;
        }
        this.b.a(iq6Var.h());
        this.e = true;
    }

    public void u0(List<ch8> list) {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, list) == null) || (iq6Var = this.c) == null) {
            return;
        }
        iq6Var.U(list);
    }

    public final void v(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, str, i, i2) == null) {
            boolean z = !TextUtils.equals(this.h, str);
            this.k = i2;
            this.h = str;
            b0();
            if (this.c == null || z) {
                iq6 iq6Var = this.c;
                if (iq6Var != null) {
                    iq6Var.u();
                    this.c = null;
                }
                iq6 e = this.d.e(str, this.a, i);
                this.c = e;
                e.c(this.g);
                this.c.G(this.p);
            }
            zp6 zp6Var = this.n;
            if (zp6Var != null) {
                this.c.Q(zp6Var);
            }
            yp6 yp6Var = this.o;
            if (yp6Var != null) {
                this.c.O(yp6Var);
            }
            this.b.a(this.c.l());
            w(str);
            w0();
            s0();
        }
    }

    public final void v0() {
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && D() && (iq6Var = this.c) != null) {
            iq6Var.V();
        }
    }

    public final void w(String str) {
        FrsFragment frsFragment;
        RelativeLayout I;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, str) == null) || this.m == null || (frsFragment = this.a) == null || frsFragment.z3() == null || (I = this.m.I()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.a.z3().removeHeaderView(I);
            return;
        }
        this.a.z3().removeHeaderView(I);
        this.a.z3().t(I, 0);
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            qg.a().postDelayed(this.q, 4000L);
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!D() || (iq6Var = this.c) == null) {
                return false;
            }
            return iq6Var.m();
        }
        return invokeV.booleanValue;
    }

    public void x0(boolean z) {
        yp6 yp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (yp6Var = this.o) == null) {
            return;
        }
        iq6 iq6Var = this.c;
        yp6Var.m(iq6Var != null && iq6Var.q());
        this.o.p(z);
    }

    public boolean y() {
        InterceptResult invokeV;
        iq6 iq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (!D() || (iq6Var = this.c) == null) {
                return false;
            }
            return iq6Var.i();
        }
        return invokeV.booleanValue;
    }

    public final float z(ForumData forumData) {
        InterceptResult invokeL;
        zp6 zp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, forumData)) == null) {
            if (forumData == null || (zp6Var = this.n) == null) {
                return 0.0f;
            }
            return zp6Var.k(forumData);
        }
        return invokeL.floatValue;
    }

    public void z0() {
        zp6 zp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (zp6Var = this.n) == null) {
            return;
        }
        iq6 iq6Var = this.c;
        if (iq6Var != null) {
            zp6Var.v(iq6Var.s(), this.c.e());
        } else {
            zp6Var.v(false, "");
        }
        iq6 iq6Var2 = this.c;
        if (iq6Var2 != null) {
            this.n.u(iq6Var2.k());
        }
    }
}
