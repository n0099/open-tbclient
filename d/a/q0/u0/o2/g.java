package d.a.q0.u0.o2;

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
import d.a.p0.a.s;
import d.a.q0.u0.q;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f64070a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f64071b;

    /* renamed from: c  reason: collision with root package name */
    public String f64072c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f64073d;

    /* renamed from: e  reason: collision with root package name */
    public int f64074e;

    /* renamed from: f  reason: collision with root package name */
    public int f64075f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64076g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64077h;

    /* renamed from: i  reason: collision with root package name */
    public SignActivityInfo f64078i;
    public String j;
    public CustomMessageListener k;
    public AntiHelper.k l;
    public CustomMessageListener m;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f64079a;

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
            this.f64079a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02db  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData l0;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            q G0;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f64079a.f64070a == null || !(customResponsedMessage instanceof SignMessage) || (l0 = this.f64079a.f64070a.l0()) == null || l0.getForum() == null || (name = (forum = l0.getForum()).getName()) == null || !name.equals(FrsActivityStatic.f15334c) || customResponsedMessage.getOrginalMessage().getTag() != this.f64079a.f64073d) {
                return;
            }
            TiebaStatic.eventStat(this.f64079a.f64070a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                h R = this.f64079a.f64070a.R();
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    signData = null;
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(forum.getId())) {
                        return;
                    }
                    if (R != null) {
                        R.Z(name2);
                    }
                    l0.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                }
                if (z) {
                    int user_level = forum.getUser_level();
                    if (R != null ? R.B() : false) {
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
                        if (z2 || !this.f64079a.f64077h) {
                            if (!this.f64079a.l() && signData.contDays > 0) {
                                d.a.p0.t.d.f.c().j(signData.userInfoJson);
                                TbPageContext<?> m = this.f64079a.f64070a.m();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f64079a.f64070a.getActivity(), "", this.f64079a.f64072c, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                m.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                s.g().k().b();
                                return;
                            }
                            d.a.p0.t.d.f.c().j(null);
                            if (R != null || R.u()) {
                                this.f64079a.f64070a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                this.f64079a.f64070a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            G0 = this.f64079a.f64070a.G0();
                            if (G0 == null) {
                                d.a.p0.t.d.f.c().a(this.f64079a.f64070a.m(), G0.l0());
                                return;
                            }
                            return;
                        }
                        if (signData != null && this.f64079a.f64078i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", this.f64079a.f64078i.activity_id);
                                jSONObject.put("activity_suc_msg", this.f64079a.f64078i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", this.f64079a.f64078i.activity_fail_msg);
                                jSONObject.put("gift_type", this.f64079a.f64078i.gift_type);
                                jSONObject.put("gift_url", this.f64079a.f64078i.gift_url);
                                jSONObject.put("gift_name", this.f64079a.f64078i.gift_name);
                                jSONObject.put("icon_name", this.f64079a.f64078i.icon_name);
                                jSONObject.put("icon_lifecycle", this.f64079a.f64078i.icon_lifecycle);
                                jSONObject.put("activity_name", this.f64079a.f64078i.activity_name);
                                jSONObject.put("image_url", this.f64079a.f64078i.image_url);
                                d.a.p0.t.d.f.c().j(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> m2 = this.f64079a.f64070a.m();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(this.f64079a.f64070a.getActivity(), "", this.f64079a.j, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        m2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        s.g().k().b();
                        return;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (!this.f64079a.l()) {
                    }
                    d.a.p0.t.d.f.c().j(null);
                    if (R != null) {
                    }
                    this.f64079a.f64070a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    G0 = this.f64079a.f64070a.G0();
                    if (G0 == null) {
                    }
                } else {
                    if (signMessage.mSignErrorCode == 160002 && R != null) {
                        R.i0(1);
                    }
                    this.f64079a.f64070a.showToast(signMessage.mSignErrorString);
                }
            } else {
                if (signMessage.signData != null) {
                    AntiHelper.t(this.f64079a.f64070a.getActivity(), signMessage.signData.blockPopInfoData, this.f64079a.l);
                } else {
                    AntiHelper.u(this.f64079a.f64070a.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onNavigationButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f64080a;

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
            this.f64080a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData l0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f64080a.f64070a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (l0 = this.f64080a.f64070a.l0()) == null || l0.getForum() == null) {
                return;
            }
            ForumData forum = l0.getForum();
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = forum.getUser_level();
            String str = signData.forumId;
            if (str == null || !str.equals(forum.getId())) {
                return;
            }
            l0.updateSignData(signData);
            h R = this.f64080a.f64070a.R();
            boolean z = false;
            if (R != null) {
                R.j0(l0);
                z = R.B();
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
        this.f64070a = frsFragment;
        this.f64073d = bdUniqueId;
        this.f64072c = TbSingleton.getInstance().getWalletSignLink();
    }

    public void i(TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tBSpecificationBtn) == null) {
            this.f64071b = tBSpecificationBtn;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z && !this.f64076g) {
            StatisticItem.make("c13560").param("obj_type", 1).eventStat();
            this.f64076g = true;
        }
    }

    public float k(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumData)) == null) {
            if (forumData == null) {
                return 0.0f;
            }
            this.f64074e = forumData.getLevelupScore();
            int curScore = forumData.getCurScore();
            this.f64075f = curScore;
            int i2 = this.f64074e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.f64072c) : invokeV.booleanValue;
    }

    public void m(d.a.q0.u0.r2.b bVar, SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, bVar, signData) == null) || bVar == null || signData == null) {
            return;
        }
        int i2 = signData.sign_bonus_point;
        boolean z = false;
        if (i2 >= this.f64074e - this.f64075f) {
            z = true;
            this.f64074e = signData.levelup_score;
        }
        int i3 = this.f64075f + i2;
        this.f64075f = i3;
        int i4 = this.f64074e;
        if (i3 > i4) {
            this.f64075f = i4;
        }
        int i5 = this.f64074e;
        float f2 = i5 != 0 ? this.f64075f / i5 : 0.0f;
        if (f2 > 0.999f) {
            f2 = 1.0f;
        }
        bVar.v(z, f2);
    }

    public void n() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (frsFragment = this.f64070a) == null) {
            return;
        }
        frsFragment.registerListener(this.k);
        this.f64070a.registerListener(this.m);
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f64071b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f64071b.getLayoutParams().width = -2;
        this.f64071b.setPadding(0, 0, 0, 0);
        TBSpecificationButtonConfig styleConfig = this.f64071b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        if (i2 > 0) {
            this.f64071b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i2)));
            styleConfig.i(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        } else {
            this.f64071b.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
            styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        }
        this.f64071b.setTextSize(R.dimen.T_X08);
        this.f64071b.k();
        this.f64071b.setVisibility(0);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f64071b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f64071b.getLayoutParams().width = -2;
        this.f64071b.setPadding(0, 0, 0, 0);
        this.f64071b.setTextSize(R.dimen.T_X08);
        this.f64071b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f64071b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f64071b.k();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f64071b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f64071b.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
        this.f64071b.setPadding(0, 0, 0, 0);
        this.f64071b.setTextSize(R.dimen.T_X08);
        this.f64071b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f64071b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f64071b.k();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f64071b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f64071b.getLayoutParams().width = -2;
        this.f64071b.setPadding(0, 0, 0, 0);
        this.f64071b.setTextSize(R.dimen.T_X08);
        this.f64071b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f64071b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f64071b.k();
    }

    public void t(d.a.q0.u0.r2.b bVar, FrsViewData frsViewData) {
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
        forum.setCurScore(this.f64075f);
        forum.setLevelupScore(this.f64074e);
        bVar.B(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, signActivityInfo) == null) {
            this.f64078i = signActivityInfo;
        }
    }

    public void v(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            this.f64077h = z;
            TbSingleton.getInstance().setActivityId(str);
            FrsFragment frsFragment = this.f64070a;
            if (frsFragment == null) {
                return;
            }
            FrsViewData l0 = frsFragment.l0();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (l0 == null || l0.getForum() == null) {
                    return;
                }
                ForumData forum = l0.getForum();
                forum.setFromPage("frs");
                FrsActivityStatic.f15334c = forum.getName() == null ? "" : forum.getName();
                CustomMessage customMessage = new CustomMessage(2001425, forum);
                customMessage.setTag(this.f64073d);
                MessageManager.getInstance().sendMessage(customMessage);
                return;
            }
            TbadkCoreApplication.getInst().login(this.f64070a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f64070a.getActivity(), true, 11014)));
        }
    }

    public void w(int i2, int i3, int i4) {
        FrsFragment frsFragment;
        FrsViewData l0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) || (frsFragment = this.f64070a) == null || i2 <= 0 || i3 <= 0 || (l0 = frsFragment.l0()) == null || l0.getForum() == null || l0.getSignData() == null) {
            return;
        }
        ForumData forum = l0.getForum();
        SignData signData = l0.getSignData();
        signData.levelup_score = forum.getLevelupScore();
        signData.sign_bonus_point = i4;
        signData.miss_sign_num -= i3;
        signData.count_sign_num = i2;
        l0.updateSignData(signData);
        signData.forumId = forum.getId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
        h R = this.f64070a.R();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, R != null ? R.B() : false ? forum.getUser_level() + 1 : -1);
    }
}
