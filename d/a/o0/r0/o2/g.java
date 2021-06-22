package d.a.o0.r0.o2;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import d.a.n0.a.s;
import d.a.o0.r0.r;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f63071a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f63072b;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f63074d;

    /* renamed from: e  reason: collision with root package name */
    public int f63075e;

    /* renamed from: f  reason: collision with root package name */
    public int f63076f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63077g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63078h;

    /* renamed from: i  reason: collision with root package name */
    public SignActivityInfo f63079i;
    public String j = "https://tieba.baidu.com/mo/q/signActivityPage";
    public CustomMessageListener k = new a(2001425);
    public AntiHelper.k l = new b(this);
    public CustomMessageListener m = new c(2001222);

    /* renamed from: c  reason: collision with root package name */
    public String f63073c = TbSingleton.getInstance().getWalletSignLink();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x02d7  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData j0;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            r B0;
            int i2;
            if (g.this.f63071a == null || !(customResponsedMessage instanceof SignMessage) || (j0 = g.this.f63071a.j0()) == null || j0.getForum() == null || (name = (forum = j0.getForum()).getName()) == null || !name.equals(FrsActivityStatic.f15156c) || customResponsedMessage.getOrginalMessage().getTag() != g.this.f63074d) {
                return;
            }
            TiebaStatic.eventStat(g.this.f63071a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                h R = g.this.f63071a.R();
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
                    j0.updateSignData(signData);
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
                        if (z2 || !g.this.f63078h) {
                            if (!g.this.l() && signData.contDays > 0) {
                                d.a.n0.s.d.f.c().j(signData.userInfoJson);
                                TbPageContext<?> p = g.this.f63071a.p();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.f63071a.getActivity(), "", g.this.f63073c, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                p.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                s.g().k().b();
                                return;
                            }
                            d.a.n0.s.d.f.c().j(null);
                            if (R != null || R.u()) {
                                g.this.f63071a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                g.this.f63071a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            B0 = g.this.f63071a.B0();
                            if (B0 == null) {
                                d.a.n0.s.d.f.c().a(g.this.f63071a.p(), B0.j0());
                                return;
                            }
                            return;
                        }
                        if (signData != null && g.this.f63079i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", g.this.f63079i.activity_id);
                                jSONObject.put("activity_suc_msg", g.this.f63079i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", g.this.f63079i.activity_fail_msg);
                                jSONObject.put("gift_type", g.this.f63079i.gift_type);
                                jSONObject.put("gift_url", g.this.f63079i.gift_url);
                                jSONObject.put("gift_name", g.this.f63079i.gift_name);
                                jSONObject.put("icon_name", g.this.f63079i.icon_name);
                                jSONObject.put("icon_lifecycle", g.this.f63079i.icon_lifecycle);
                                jSONObject.put("activity_name", g.this.f63079i.activity_name);
                                jSONObject.put("image_url", g.this.f63079i.image_url);
                                d.a.n0.s.d.f.c().j(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> p2 = g.this.f63071a.p();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(g.this.f63071a.getActivity(), "", g.this.j, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        p2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        s.g().k().b();
                        return;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (!g.this.l()) {
                    }
                    d.a.n0.s.d.f.c().j(null);
                    if (R != null) {
                    }
                    g.this.f63071a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    B0 = g.this.f63071a.B0();
                    if (B0 == null) {
                    }
                } else {
                    if (signMessage.mSignErrorCode == 160002 && R != null) {
                        R.i0(1);
                    }
                    g.this.f63071a.showToast(signMessage.mSignErrorString);
                }
            } else {
                if (signMessage.signData != null) {
                    AntiHelper.t(g.this.f63071a.getActivity(), signMessage.signData.blockPopInfoData, g.this.l);
                } else {
                    AntiHelper.u(g.this.f63071a.getActivity(), signMessage.mSignErrorString);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AntiHelper.k {
        public b(g gVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.n0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData j0;
            if (g.this.f63071a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (j0 = g.this.f63071a.j0()) == null || j0.getForum() == null) {
                return;
            }
            ForumData forum = j0.getForum();
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = forum.getUser_level();
            String str = signData.forumId;
            if (str == null || !str.equals(forum.getId())) {
                return;
            }
            j0.updateSignData(signData);
            h R = g.this.f63071a.R();
            boolean z = false;
            if (R != null) {
                R.j0(j0);
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
        this.f63071a = frsFragment;
        this.f63074d = bdUniqueId;
    }

    public void i(TBSpecificationBtn tBSpecificationBtn) {
        this.f63072b = tBSpecificationBtn;
    }

    public void j(boolean z) {
        if (!z || this.f63077g) {
            return;
        }
        StatisticItem.make("c13560").param("obj_type", 1).eventStat();
        this.f63077g = true;
    }

    public float k(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.f63075e = forumData.getLevelupScore();
        int curScore = forumData.getCurScore();
        this.f63076f = curScore;
        int i2 = this.f63075e;
        if (i2 > 0) {
            return curScore / i2;
        }
        return 0.0f;
    }

    public final boolean l() {
        return !TextUtils.isEmpty(this.f63073c);
    }

    public void m(d.a.o0.r0.r2.b bVar, SignData signData) {
        if (bVar == null || signData == null) {
            return;
        }
        int i2 = signData.sign_bonus_point;
        boolean z = false;
        if (i2 >= this.f63075e - this.f63076f) {
            z = true;
            this.f63075e = signData.levelup_score;
        }
        int i3 = this.f63076f + i2;
        this.f63076f = i3;
        int i4 = this.f63075e;
        if (i3 > i4) {
            this.f63076f = i4;
        }
        int i5 = this.f63075e;
        float f2 = i5 != 0 ? this.f63076f / i5 : 0.0f;
        if (f2 > 0.999f) {
            f2 = 1.0f;
        }
        bVar.v(z, f2);
    }

    public void n() {
        FrsFragment frsFragment = this.f63071a;
        if (frsFragment != null) {
            frsFragment.registerListener(this.k);
            this.f63071a.registerListener(this.m);
        }
    }

    public void o(int i2) {
        if (this.f63072b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f63072b.getLayoutParams().width = -2;
        this.f63072b.setPadding(0, 0, 0, 0);
        TBSpecificationButtonConfig styleConfig = this.f63072b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        if (i2 > 0) {
            this.f63072b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i2)));
            styleConfig.i(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        } else {
            this.f63072b.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
            styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        }
        this.f63072b.setTextSize(R.dimen.T_X08);
        this.f63072b.k();
        this.f63072b.setVisibility(0);
    }

    public final void p() {
        if (this.f63072b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f63072b.getLayoutParams().width = -2;
        this.f63072b.setPadding(0, 0, 0, 0);
        this.f63072b.setTextSize(R.dimen.T_X08);
        this.f63072b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f63072b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f63072b.k();
    }

    public void q(boolean z) {
        if (z) {
            p();
        } else if (l()) {
            s();
        } else {
            r();
        }
    }

    public final void r() {
        if (this.f63072b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f63072b.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
        this.f63072b.setPadding(0, 0, 0, 0);
        this.f63072b.setTextSize(R.dimen.T_X08);
        this.f63072b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f63072b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f63072b.k();
    }

    public final void s() {
        if (this.f63072b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f63072b.getLayoutParams().width = -2;
        this.f63072b.setPadding(0, 0, 0, 0);
        this.f63072b.setTextSize(R.dimen.T_X08);
        this.f63072b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f63072b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f63072b.k();
    }

    public void t(d.a.o0.r0.r2.b bVar, FrsViewData frsViewData) {
        ForumData forum;
        SignData signData;
        if (frsViewData == null || frsViewData.getForum() == null || bVar == null || (signData = (forum = frsViewData.getForum()).getSignData()) == null) {
            return;
        }
        bVar.B(forum, frsViewData);
        bVar.F(signData.is_signed);
        if (signData.sign_bonus_point <= 0 || !bVar.l()) {
            return;
        }
        m(bVar, signData);
        forum.setCurScore(this.f63076f);
        forum.setLevelupScore(this.f63075e);
        bVar.B(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        this.f63079i = signActivityInfo;
    }

    public void v(boolean z, String str) {
        this.f63078h = z;
        TbSingleton.getInstance().setActivityId(str);
        FrsFragment frsFragment = this.f63071a;
        if (frsFragment == null) {
            return;
        }
        FrsViewData j0 = frsFragment.j0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (j0 == null || j0.getForum() == null) {
                return;
            }
            ForumData forum = j0.getForum();
            forum.setFromPage("frs");
            FrsActivityStatic.f15156c = forum.getName() == null ? "" : forum.getName();
            CustomMessage customMessage = new CustomMessage(2001425, forum);
            customMessage.setTag(this.f63074d);
            MessageManager.getInstance().sendMessage(customMessage);
            return;
        }
        TbadkCoreApplication.getInst().login(this.f63071a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f63071a.getActivity(), true, 11014)));
    }

    public void w(int i2, int i3, int i4) {
        FrsViewData j0;
        FrsFragment frsFragment = this.f63071a;
        if (frsFragment == null || i2 <= 0 || i3 <= 0 || (j0 = frsFragment.j0()) == null || j0.getForum() == null || j0.getSignData() == null) {
            return;
        }
        ForumData forum = j0.getForum();
        SignData signData = j0.getSignData();
        signData.levelup_score = forum.getLevelupScore();
        signData.sign_bonus_point = i4;
        signData.miss_sign_num -= i3;
        signData.count_sign_num = i2;
        j0.updateSignData(signData);
        signData.forumId = forum.getId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
        h R = this.f63071a.R();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, R != null ? R.B() : false ? forum.getUser_level() + 1 : -1);
    }
}
