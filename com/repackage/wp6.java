package com.repackage;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.xm6;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class wp6 implements ei6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public NoPressedRelativeLayout b;
    public eq6 c;
    public xo8 d;
    public xm6 e;
    public ow8 f;
    public OvalActionButton g;
    public pw8 h;
    public xm6.d i;
    public final View.OnClickListener j;
    public final ig<ym> k;

    /* loaded from: classes7.dex */
    public class a implements xm6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp6 a;

        public a(wp6 wp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp6Var;
        }

        @Override // com.repackage.xm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z && i == 502) {
                    this.a.B(1);
                } else if (z) {
                    this.a.B(0);
                } else if (i != 502) {
                    this.a.B(-1);
                } else {
                    this.a.n();
                }
            }
        }

        @Override // com.repackage.xm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // com.repackage.xm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp6 a;

        public b(wp6 wp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getPageContext().getPageActivity(), LoginDialogData.FRS_PUBLISH_RESULT_PAGE)) || this.a.d.c() || this.a.k() || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            if (this.a.c != null) {
                this.a.c.i();
            }
            if (this.a.a.D3().K(502) == null || this.a.a.D3().C() == null) {
                this.a.B(-1);
            } else {
                this.a.e.h(this.a.a.d(), this.a.a.D3().C().a);
            }
            this.a.j();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp6 a;

        public c(wp6 wp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) {
                super.onLoaded((c) ymVar, str, i);
                if (ymVar == null || !ymVar.w()) {
                    this.a.w();
                    return;
                }
                this.a.g.setImageDrawable(null);
                ymVar.h(this.a.g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(wp6 wp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) || cr4Var == null) {
                return;
            }
            cr4Var.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ wp6 b;

        public e(wp6 wp6Var, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp6Var, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wp6Var;
            this.a = blockPopInfoData;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a.ahead_url});
                if (cr4Var == null) {
                    return;
                }
                cr4Var.dismiss();
            }
        }
    }

    public wp6(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        if (frsFragment == null || noPressedRelativeLayout == null) {
            return;
        }
        this.a = frsFragment;
        this.b = noPressedRelativeLayout;
        this.d = new xo8(frsFragment.getPageContext());
        xm6 xm6Var = new xm6(frsFragment.getPageContext());
        this.e = xm6Var;
        xm6Var.i(this.i);
        this.f = new ow8(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
        u(TbadkCoreApplication.getInst().getSkinType());
    }

    public void A(boolean z) {
        FrsViewData Q0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.g == null) {
            return;
        }
        l();
        this.g.setVisibility(z ? 0 : 8);
        if (!z || !TbadkCoreApplication.isLogin() || (Q0 = this.a.Q0()) == null || Q0.postTopic == null || Q0.getForum() == null || StringUtils.isNull(Q0.getForum().getId()) || StringUtils.isNull(Q0.postTopic.recom_title) || StringUtils.isNull(Q0.postTopic.recom_topic) || !gd6.d().c(Q0.getForum().getId(), Q0.postTopic.uniq_topicid.longValue())) {
            return;
        }
        z(this.g, Q0);
    }

    public final void B(int i) {
        FrsViewData Q0;
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (UbsABTestHelper.isMainTabShowA() && (frsFragment = this.a) != null) {
                ForumWriteData o3 = frsFragment.o3();
                ItemInfo itemInfo = this.a.Q0() != null ? this.a.Q0().itemInfo : null;
                if (this.f == null) {
                    this.f = new ow8(this.a.getPageContext().getPageActivity(), "frs", 2, "2");
                }
                this.f.j(o3);
                this.f.l(m());
                this.f.k(itemInfo);
                this.f.m();
                return;
            }
            if (this.h == null) {
                FrsFragment frsFragment2 = this.a;
                pw8 pw8Var = new pw8(this.a.getPageContext(), this.b, "frs", (frsFragment2 == null || (Q0 = frsFragment2.Q0()) == null) ? null : Q0.getVoiceRoomConfig());
                this.h = pw8Var;
                pw8Var.E("2");
                ItemInfo itemInfo2 = this.a.Q0().itemInfo;
                this.h.D((itemInfo2 == null || itemInfo2.id.intValue() <= 0 || oi.isEmpty(itemInfo2.name)) ? false : true);
            }
            this.h.G(m());
            if (this.a.Q0().getAnti() != null) {
                this.h.A(this.a.Q0().getAnti().getCanGoods());
            }
            ForumWriteData o32 = this.a.o3();
            o32.setDefaultZone(i);
            this.h.B(o32);
            this.h.C(this.a.Q0().itemInfo);
            this.h.F(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
            FrsFragment frsFragment3 = this.a;
            if (frsFragment3 != null && frsFragment3.Q0() != null) {
                this.h.C(this.a.Q0().itemInfo);
            }
            this.h.I(false, null, this.g);
            this.a.H3().setAlpha(0);
            FrsFragment frsFragment4 = this.a;
            if (frsFragment4 == null || frsFragment4.Q0() == null || this.a.Q0().itemInfo == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13721").param("fid", this.a.d()).param("fname", this.a.c()).param("obj_param1", this.a.Q0().itemInfo.name));
        }
    }

    public void C() {
        OvalActionButton ovalActionButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ovalActionButton = this.g) == null) {
            return;
        }
        ovalActionButton.performClick();
    }

    @Override // com.repackage.ei6
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.d.c() || k()) ? false : true : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13604");
            FrsFragment frsFragment = this.a;
            if (frsFragment != null) {
                u85.b(frsFragment.getContext(), statisticItem);
                kn6.b(statisticItem, this.a.d(), this.a.c());
            }
            kn6.a(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        FrsViewData Q0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || (Q0 = frsFragment.Q0()) == null) {
                return false;
            }
            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                AntiData anti = Q0.getAnti();
                return anti != null && y(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        FrsViewData Q0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && (Q0 = frsFragment.Q0()) != null && (activityConfig = Q0.activityConfig) != null && activityConfig.type.intValue() == 2) {
                if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
                    q(activityConfig.night_addthread_icon);
                    return true;
                } else if (!TextUtils.isEmpty(activityConfig.addthread_icon)) {
                    q(activityConfig.addthread_icon);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String m() {
        InterceptResult invokeV;
        FrsViewData Q0;
        ActivityConfig activityConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrsFragment frsFragment = this.a;
            return (frsFragment == null || (Q0 = frsFragment.Q0()) == null || (activityConfig = Q0.activityConfig) == null) ? "" : activityConfig.addthread_text;
        }
        return (String) invokeV.objValue;
    }

    public final void n() {
        FrsFragment frsFragment;
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (frsFragment = this.a) == null || frsFragment.Q0() == null || (forum = this.a.Q0().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                str8 = skinType == 0 ? themeElement.pattern_image : null;
            } else {
                str8 = null;
                str9 = null;
                str10 = null;
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                str11 = themeElement2.light_color;
                str12 = themeElement2.dark_color;
                if (skinType == 1) {
                    str8 = themeElement2.pattern_image;
                }
            } else {
                str11 = null;
                str12 = null;
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                String str13 = themeElement3.light_color;
                String str14 = themeElement3.dark_color;
                if (skinType == 4) {
                    str = themeElement3.pattern_image;
                    str6 = str13;
                } else {
                    str6 = str13;
                    str = str8;
                }
                str2 = str9;
                str3 = str10;
                str7 = str14;
            } else {
                str6 = null;
                str7 = null;
                str = str8;
                str2 = str9;
                str3 = str10;
            }
            str4 = str11;
            str5 = str12;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.a.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            pw8 pw8Var = this.h;
            if (pw8Var == null) {
                return false;
            }
            return pw8Var.n();
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            pw8 pw8Var = this.h;
            if (pw8Var == null) {
                return false;
            }
            return pw8Var.n();
        }
        return invokeV.booleanValue;
    }

    public final void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            jg.h().m(str, 10, this.k, this.a.getUniqueId());
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            pw8 pw8Var = this.h;
            if (pw8Var != null) {
                pw8Var.u();
            }
            eq6 eq6Var = this.c;
            if (eq6Var != null) {
                eq6Var.i();
            }
        }
    }

    public void s() {
        eq6 eq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (eq6Var = this.c) == null) {
            return;
        }
        eq6Var.i();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            pw8 pw8Var = this.h;
            if (pw8Var != null) {
                pw8Var.s(i);
            }
            ow8 ow8Var = this.f;
            if (ow8Var != null) {
                ow8Var.i(i);
            }
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            pw8 pw8Var = this.h;
            if (pw8Var == null || !pw8Var.n()) {
                return false;
            }
            this.h.m(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.g.setImageResource(0);
        }
    }

    public void x(OvalActionButton ovalActionButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, ovalActionButton) == null) || ovalActionButton == null) {
            return;
        }
        this.g = ovalActionButton;
        ovalActionButton.setOnClickListener(this.j);
        if (l()) {
            return;
        }
        w();
    }

    public final boolean y(int i, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f06d0) : blockPopInfoData.block_info;
            if (i == 1 || i == 2) {
                cr4 cr4Var = new cr4(this.a.getPageContext().getPageActivity());
                cr4Var.setMessage(StringHelper.getFixedText(string, 50, true));
                cr4Var.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07ee) : blockPopInfoData.ok_info, 4, true), new d(this));
                if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                    cr4Var.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new e(this, blockPopInfoData));
                }
                cr4Var.create(this.a.getPageContext()).show();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void z(View view2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, view2, frsViewData) == null) || this.a == null || frsViewData == null || frsViewData.getForum() == null || frsViewData.postTopic == null) {
            return;
        }
        if (this.c == null) {
            this.c = new eq6(this.a.getActivity(), this);
        }
        this.c.i();
        this.c.j(view2, frsViewData);
    }
}
