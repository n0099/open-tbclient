package d.a.s0.u0.o2;

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
import d.a.r0.a.s;
import d.a.s0.u0.q;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f66644a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f66645b;

    /* renamed from: c  reason: collision with root package name */
    public String f66646c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f66647d;

    /* renamed from: e  reason: collision with root package name */
    public int f66648e;

    /* renamed from: f  reason: collision with root package name */
    public int f66649f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66650g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66651h;

    /* renamed from: i  reason: collision with root package name */
    public SignActivityInfo f66652i;
    public String j;
    public CustomMessageListener k;
    public AntiHelper.k l;
    public CustomMessageListener m;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f66653a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, int i2) {
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
            this.f66653a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02db  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData i0;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            q B0;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f66653a.f66644a == null || !(customResponsedMessage instanceof SignMessage) || (i0 = this.f66653a.f66644a.i0()) == null || i0.getForum() == null || (name = (forum = i0.getForum()).getName()) == null || !name.equals(FrsActivityStatic.f15247c) || customResponsedMessage.getOrginalMessage().getTag() != this.f66653a.f66647d) {
                return;
            }
            TiebaStatic.eventStat(this.f66653a.f66644a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                h Q = this.f66653a.f66644a.Q();
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    signData = null;
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(forum.getId())) {
                        return;
                    }
                    if (Q != null) {
                        Q.Z(name2);
                    }
                    i0.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                }
                if (z) {
                    int user_level = forum.getUser_level();
                    if (Q != null ? Q.B() : false) {
                        int user_level2 = forum.getUser_level();
                        if (user_level >= user_level2) {
                            user_level2++;
                        }
                        user_level = user_level2;
                    }
                    TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, user_level);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                    try {
                        i2 = new JSONObject(signData.userInfoJson).getInt("activity_status");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (i2 == 1 || i2 == 2) {
                        z2 = true;
                        if (z2 || !this.f66653a.f66651h) {
                            if (!this.f66653a.l() && signData.contDays > 0) {
                                d.a.r0.s.d.f.c().j(signData.userInfoJson);
                                TbPageContext<?> n = this.f66653a.f66644a.n();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f66653a.f66644a.getActivity(), "", this.f66653a.f66646c, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                n.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                s.g().k().b();
                                return;
                            }
                            d.a.r0.s.d.f.c().j(null);
                            if (Q != null || Q.u()) {
                                this.f66653a.f66644a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                this.f66653a.f66644a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            B0 = this.f66653a.f66644a.B0();
                            if (B0 == null) {
                                d.a.r0.s.d.f.c().a(this.f66653a.f66644a.n(), B0.k0());
                                return;
                            }
                            return;
                        }
                        if (signData != null && this.f66653a.f66652i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", this.f66653a.f66652i.activity_id);
                                jSONObject.put("activity_suc_msg", this.f66653a.f66652i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", this.f66653a.f66652i.activity_fail_msg);
                                jSONObject.put("gift_type", this.f66653a.f66652i.gift_type);
                                jSONObject.put("gift_url", this.f66653a.f66652i.gift_url);
                                jSONObject.put("gift_name", this.f66653a.f66652i.gift_name);
                                jSONObject.put("icon_name", this.f66653a.f66652i.icon_name);
                                jSONObject.put("icon_lifecycle", this.f66653a.f66652i.icon_lifecycle);
                                jSONObject.put("activity_name", this.f66653a.f66652i.activity_name);
                                jSONObject.put("image_url", this.f66653a.f66652i.image_url);
                                d.a.r0.s.d.f.c().j(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> n2 = this.f66653a.f66644a.n();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(this.f66653a.f66644a.getActivity(), "", this.f66653a.j, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        n2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        s.g().k().b();
                        return;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (!this.f66653a.l()) {
                    }
                    d.a.r0.s.d.f.c().j(null);
                    if (Q != null) {
                    }
                    this.f66653a.f66644a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    B0 = this.f66653a.f66644a.B0();
                    if (B0 == null) {
                    }
                } else {
                    if (signMessage.mSignErrorCode == 160002 && Q != null) {
                        Q.i0(1);
                    }
                    this.f66653a.f66644a.showToast(signMessage.mSignErrorString);
                }
            } else {
                if (signMessage.signData != null) {
                    AntiHelper.t(this.f66653a.f66644a.getActivity(), signMessage.signData.blockPopInfoData, this.f66653a.l);
                } else {
                    AntiHelper.u(this.f66653a.f66644a.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f66654a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, int i2) {
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
            this.f66654a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData i0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f66654a.f66644a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (i0 = this.f66654a.f66644a.i0()) == null || i0.getForum() == null) {
                return;
            }
            ForumData forum = i0.getForum();
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = forum.getUser_level();
            String str = signData.forumId;
            if (str == null || !str.equals(forum.getId())) {
                return;
            }
            i0.updateSignData(signData);
            h Q = this.f66654a.f66644a.Q();
            boolean z = false;
            if (Q != null) {
                Q.j0(i0);
                z = Q.B();
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

    public g(FrsFragment frsFragment, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = "https://tieba.baidu.com/mo/q/signActivityPage";
        this.k = new a(this, 2001425);
        this.l = new b(this);
        this.m = new c(this, 2001222);
        this.f66644a = frsFragment;
        this.f66647d = bdUniqueId;
        this.f66646c = TbSingleton.getInstance().getWalletSignLink();
    }

    public void i(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tBSpecificationBtn) == null) {
            this.f66645b = tBSpecificationBtn;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z && !this.f66650g) {
            StatisticItem.make("c13560").param("obj_type", 1).eventStat();
            this.f66650g = true;
        }
    }

    public float k(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData == null) {
                return 0.0f;
            }
            this.f66648e = forumData.getLevelupScore();
            int curScore = forumData.getCurScore();
            this.f66649f = curScore;
            int i2 = this.f66648e;
            if (i2 > 0) {
                return curScore / i2;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.f66646c) : invokeV.booleanValue;
    }

    public void m(d.a.s0.u0.r2.b bVar, SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, bVar, signData) == null) || bVar == null || signData == null) {
            return;
        }
        int i2 = signData.sign_bonus_point;
        boolean z = false;
        if (i2 >= this.f66648e - this.f66649f) {
            z = true;
            this.f66648e = signData.levelup_score;
        }
        int i3 = this.f66649f + i2;
        this.f66649f = i3;
        int i4 = this.f66648e;
        if (i3 > i4) {
            this.f66649f = i4;
        }
        int i5 = this.f66648e;
        float f2 = i5 != 0 ? this.f66649f / i5 : 0.0f;
        if (f2 > 0.999f) {
            f2 = 1.0f;
        }
        bVar.v(z, f2);
    }

    public void n() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsFragment = this.f66644a) == null) {
            return;
        }
        frsFragment.registerListener(this.k);
        this.f66644a.registerListener(this.m);
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f66645b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f66645b.getLayoutParams().width = -2;
        this.f66645b.setPadding(0, 0, 0, 0);
        TBSpecificationButtonConfig styleConfig = this.f66645b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        if (i2 > 0) {
            this.f66645b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i2)));
            styleConfig.i(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        } else {
            this.f66645b.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
            styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        }
        this.f66645b.setTextSize(R.dimen.T_X08);
        this.f66645b.k();
        this.f66645b.setVisibility(0);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f66645b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f66645b.getLayoutParams().width = -2;
        this.f66645b.setPadding(0, 0, 0, 0);
        this.f66645b.setTextSize(R.dimen.T_X08);
        this.f66645b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f66645b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f66645b.k();
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f66645b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f66645b.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
        this.f66645b.setPadding(0, 0, 0, 0);
        this.f66645b.setTextSize(R.dimen.T_X08);
        this.f66645b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f66645b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f66645b.k();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f66645b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f66645b.getLayoutParams().width = -2;
        this.f66645b.setPadding(0, 0, 0, 0);
        this.f66645b.setTextSize(R.dimen.T_X08);
        this.f66645b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f66645b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f66645b.k();
    }

    public void t(d.a.s0.u0.r2.b bVar, FrsViewData frsViewData) {
        ForumData forum;
        SignData signData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, bVar, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null || bVar == null || (signData = (forum = frsViewData.getForum()).getSignData()) == null) {
            return;
        }
        bVar.B(forum, frsViewData);
        bVar.F(signData.is_signed);
        if (signData.sign_bonus_point <= 0 || !bVar.l()) {
            return;
        }
        m(bVar, signData);
        forum.setCurScore(this.f66649f);
        forum.setLevelupScore(this.f66648e);
        bVar.B(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, signActivityInfo) == null) {
            this.f66652i = signActivityInfo;
        }
    }

    public void v(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            this.f66651h = z;
            TbSingleton.getInstance().setActivityId(str);
            FrsFragment frsFragment = this.f66644a;
            if (frsFragment == null) {
                return;
            }
            FrsViewData i0 = frsFragment.i0();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (i0 == null || i0.getForum() == null) {
                    return;
                }
                ForumData forum = i0.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.f15247c = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage(2001425, forum);
                customMessage.setTag(this.f66647d);
                MessageManager.getInstance().sendMessage(customMessage);
                return;
            }
            TbadkCoreApplication.getInst().login(this.f66644a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f66644a.getActivity(), true, 11014)));
        }
    }

    public void w(int i2, int i3, int i4) {
        FrsFragment frsFragment;
        FrsViewData i0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) || (frsFragment = this.f66644a) == null || i2 <= 0 || i3 <= 0 || (i0 = frsFragment.i0()) == null || i0.getForum() == null || i0.getSignData() == null) {
            return;
        }
        ForumData forum = i0.getForum();
        SignData signData = i0.getSignData();
        signData.levelup_score = forum.getLevelupScore();
        signData.sign_bonus_point = i4;
        signData.miss_sign_num -= i3;
        signData.count_sign_num = i2;
        i0.updateSignData(signData);
        signData.forumId = forum.getId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
        h Q = this.f66644a.Q();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, Q != null ? Q.B() : false ? forum.getUser_level() + 1 : -1);
    }
}
