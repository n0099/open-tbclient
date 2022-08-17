package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes7.dex */
public class rr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public List<TBSpecificationBtn> b;
    public String c;
    public BdUniqueId d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public SignActivityInfo i;
    public String j;
    public CustomMessageListener k;
    public AntiHelper.k l;
    public CustomMessageListener m;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rr6 rr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02dd  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData P0;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            af6 k1;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null || !(customResponsedMessage instanceof SignMessage) || (P0 = this.a.a.P0()) == null || P0.getForum() == null || (name = (forum = P0.getForum()).getName()) == null || !name.equals(FrsActivityStatic.c) || customResponsedMessage.getOrginalMessage().getTag() != this.a.d) {
                return;
            }
            TiebaStatic.eventStat(this.a.a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                sr6 o0 = this.a.a.o0();
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    signData = null;
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(forum.getId())) {
                        return;
                    }
                    if (o0 != null) {
                        o0.d0(name2);
                    }
                    P0.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                }
                if (z) {
                    int user_level = forum.getUser_level();
                    if (o0 != null ? o0.H() : false) {
                        int user_level2 = forum.getUser_level();
                        if (user_level >= user_level2) {
                            user_level2++;
                        }
                        user_level = user_level2;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, user_level);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                    try {
                        i = new JSONObject(signData.userInfoJson).getInt("activity_status");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (i == 1 || i == 2) {
                        z2 = true;
                        if (z2 || !this.a.h) {
                            if (!this.a.l() && signData.contDays > 0) {
                                oz4.c().i(signData.userInfoJson);
                                TbPageContext<?> o = this.a.a.o();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.a.getActivity(), "", this.a.c, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                o.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                rj4.f().j().b();
                                return;
                            }
                            oz4.c().i(null);
                            if (o0 != null || o0.z()) {
                                this.a.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f074b, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                this.a.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f074c, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            k1 = this.a.a.k1();
                            if (k1 == null) {
                                oz4.c().a(1, this.a.a.o(), k1.o0());
                                return;
                            }
                            return;
                        }
                        if (signData != null && this.a.i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", this.a.i.activity_id);
                                jSONObject.put("activity_suc_msg", this.a.i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", this.a.i.activity_fail_msg);
                                jSONObject.put("gift_type", this.a.i.gift_type);
                                jSONObject.put("gift_url", this.a.i.gift_url);
                                jSONObject.put("gift_name", this.a.i.gift_name);
                                jSONObject.put("icon_name", this.a.i.icon_name);
                                jSONObject.put("icon_lifecycle", this.a.i.icon_lifecycle);
                                jSONObject.put("activity_name", this.a.i.activity_name);
                                jSONObject.put("image_url", this.a.i.image_url);
                                oz4.c().i(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> o2 = this.a.a.o();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(this.a.a.getActivity(), "", this.a.j, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        o2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        rj4.f().j().b();
                        return;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (!this.a.l()) {
                    }
                    oz4.c().i(null);
                    if (o0 != null) {
                    }
                    this.a.a.showToast(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f074b, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    k1 = this.a.a.k1();
                    if (k1 == null) {
                    }
                } else {
                    if (signMessage.mSignErrorCode == 160002 && o0 != null) {
                        o0.m0(1);
                    }
                    this.a.a.showToast(signMessage.mSignErrorString);
                }
            } else {
                if (signMessage.signData != null) {
                    AntiHelper.t(this.a.a.getActivity(), signMessage.signData.blockPopInfoData, this.a.l);
                } else {
                    AntiHelper.u(this.a.a.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(rr6 rr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rr6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(rr6 rr6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData P0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (P0 = this.a.a.P0()) == null || P0.getForum() == null) {
                return;
            }
            ForumData forum = P0.getForum();
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = forum.getUser_level();
            String str = signData.forumId;
            if (str == null || !str.equals(forum.getId())) {
                return;
            }
            P0.updateSignData(signData);
            sr6 o0 = this.a.a.o0();
            boolean z = false;
            if (o0 != null) {
                o0.n0(P0);
                z = o0.H();
            }
            if (z) {
                int user_level2 = forum.getUser_level();
                if (user_level >= user_level2) {
                    user_level2++;
                }
                user_level = user_level2;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, user_level);
        }
    }

    public rr6(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.j = "https://tieba.baidu.com/mo/q/signActivityPage";
        this.k = new a(this, 2001425);
        this.l = new b(this);
        this.m = new c(this, 2001222);
        this.a = frsFragment;
        this.d = bdUniqueId;
        this.c = TbSingleton.getInstance().getWalletSignLink();
    }

    public void i(List<TBSpecificationBtn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.b = list;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z && !this.g) {
            StatisticItem.make("c13560").param("obj_type", 1).eventStat();
            this.g = true;
        }
    }

    public float k(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData == null) {
                return 0.0f;
            }
            this.e = forumData.getLevelupScore();
            int curScore = forumData.getCurScore();
            this.f = curScore;
            int i = this.e;
            if (i > 0) {
                return curScore / i;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.c) : invokeV.booleanValue;
    }

    public void m(as6 as6Var, SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, as6Var, signData) == null) || as6Var == null || signData == null) {
            return;
        }
        int i = signData.sign_bonus_point;
        boolean z = false;
        if (i >= this.e - this.f) {
            z = true;
            this.e = signData.levelup_score;
        }
        int i2 = this.f + i;
        this.f = i2;
        int i3 = this.e;
        if (i2 > i3) {
            this.f = i3;
        }
        int i4 = this.e;
        float f = i4 != 0 ? this.f / i4 : 0.0f;
        if (f > 0.999f) {
            f = 1.0f;
        }
        as6Var.B(z, f);
    }

    public void n() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsFragment = this.a) == null) {
            return;
        }
        frsFragment.registerListener(this.k);
        this.a.registerListener(this.m);
    }

    public void o(int i) {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                if (i > 0) {
                    next.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad7), Integer.valueOf(i)));
                    styleConfig.i(R.drawable.obfuscated_res_0x7f08093a, 0, TBSpecificationButtonConfig.IconType.WEBP);
                } else {
                    next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f119b));
                    styleConfig.i(R.drawable.obfuscated_res_0x7f080939, 0, TBSpecificationButtonConfig.IconType.WEBP);
                }
                styleConfig.o(TBSpecificationButtonConfig.WebpType.PURE);
                next.setTextSize(R.dimen.T_X08);
                next.k();
                next.setVisibility(0);
                next.setTag(R.id.obfuscated_res_0x7f090fbd, Boolean.TRUE);
            }
        }
    }

    public final void p() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(R.dimen.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f117c));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.f(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
                styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
                styleConfig.i(R.drawable.obfuscated_res_0x7f0807d1, 0, TBSpecificationButtonConfig.IconType.WEBP);
                next.k();
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                p();
            } else if (l()) {
                s();
            } else {
                r();
            }
        }
    }

    public final void r() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                next.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(R.dimen.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f117c));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.i(R.drawable.obfuscated_res_0x7f080939, 0, TBSpecificationButtonConfig.IconType.WEBP);
                styleConfig.o(TBSpecificationButtonConfig.WebpType.PURE);
                next.k();
            }
        }
    }

    public final void s() {
        TBSpecificationBtn next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Iterator<TBSpecificationBtn> it = this.b.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
                next.getLayoutParams().width = -2;
                next.setPadding(0, 0, 0, 0);
                next.setTextSize(R.dimen.T_X08);
                next.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f117c));
                TBSpecificationButtonConfig styleConfig = next.getStyleConfig();
                styleConfig.g(dimenPixelSize);
                styleConfig.f(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
                styleConfig.o(TBSpecificationButtonConfig.WebpType.MASK);
                styleConfig.i(R.drawable.obfuscated_res_0x7f0807d2, 0, TBSpecificationButtonConfig.IconType.WEBP);
                next.k();
            }
        }
    }

    public void t(as6 as6Var, FrsViewData frsViewData) {
        ForumData forum;
        SignData signData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, as6Var, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null || as6Var == null || (signData = (forum = frsViewData.getForum()).getSignData()) == null) {
            return;
        }
        as6Var.H(forum, frsViewData);
        as6Var.L(signData.is_signed);
        if (signData.sign_bonus_point <= 0 || !as6Var.m()) {
            return;
        }
        m(as6Var, signData);
        forum.setCurScore(this.f);
        forum.setLevelupScore(this.e);
        as6Var.H(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, signActivityInfo) == null) {
            this.i = signActivityInfo;
        }
    }

    public void v(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            this.h = z;
            TbSingleton.getInstance().setActivityId(str);
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return;
            }
            FrsViewData P0 = frsFragment.P0();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (P0 == null || P0.getForum() == null) {
                    return;
                }
                ForumData forum = P0.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.c = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage(2001425, forum);
                customMessage.setTag(this.d);
                MessageManager.getInstance().sendMessage(customMessage);
                return;
            }
            TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getActivity(), true, 11014)));
        }
    }

    public void w(int i, int i2, int i3) {
        FrsFragment frsFragment;
        FrsViewData P0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) || (frsFragment = this.a) == null || i <= 0 || i2 <= 0 || (P0 = frsFragment.P0()) == null || P0.getForum() == null || P0.getSignData() == null) {
            return;
        }
        ForumData forum = P0.getForum();
        SignData signData = P0.getSignData();
        signData.levelup_score = forum.getLevelupScore();
        signData.sign_bonus_point = i3;
        signData.miss_sign_num -= i2;
        signData.count_sign_num = i;
        P0.updateSignData(signData);
        signData.forumId = forum.getId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
        sr6 o0 = this.a.o0();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, o0 != null ? o0.H() : false ? forum.getUser_level() + 1 : -1);
    }
}
