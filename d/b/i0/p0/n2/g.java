package d.b.i0.p0.n2;

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
import d.b.h0.a.q;
import d.b.i0.p0.r;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f58167a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f58168b;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f58170d;

    /* renamed from: e  reason: collision with root package name */
    public int f58171e;

    /* renamed from: f  reason: collision with root package name */
    public int f58172f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58173g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58174h;
    public SignActivityInfo i;
    public String j = "https://tieba.baidu.com/mo/q/signActivityPage";
    public CustomMessageListener k = new a(2001425);
    public AntiHelper.k l = new b(this);
    public CustomMessageListener m = new c(2001222);

    /* renamed from: c  reason: collision with root package name */
    public String f58169c = TbSingleton.getInstance().getWalletSignLink();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x02d7  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData S;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            r x0;
            int i;
            if (g.this.f58167a == null || !(customResponsedMessage instanceof SignMessage) || (S = g.this.f58167a.S()) == null || S.getForum() == null || (name = (forum = S.getForum()).getName()) == null || !name.equals(FrsActivityStatic.f15965c) || customResponsedMessage.getOrginalMessage().getTag() != g.this.f58170d) {
                return;
            }
            TiebaStatic.eventStat(g.this.f58167a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                h w0 = g.this.f58167a.w0();
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    signData = null;
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(forum.getId())) {
                        return;
                    }
                    if (w0 != null) {
                        w0.b0(name2);
                    }
                    S.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                }
                if (z) {
                    int user_level = forum.getUser_level();
                    if (w0 != null ? w0.F() : false) {
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
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (i == 1 || i == 2) {
                        z2 = true;
                        if (z2 || !g.this.f58174h) {
                            if (!g.this.l() && signData.contDays > 0) {
                                d.b.h0.s.d.f.c().j(signData.userInfoJson);
                                TbPageContext<?> q = g.this.f58167a.q();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.f58167a.getActivity(), "", g.this.f58169c, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                q.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                q.g().k().b();
                                return;
                            }
                            d.b.h0.s.d.f.c().j(null);
                            if (w0 != null || w0.w()) {
                                g.this.f58167a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                g.this.f58167a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            x0 = g.this.f58167a.x0();
                            if (x0 == null) {
                                d.b.h0.s.d.f.c().a(g.this.f58167a.q(), x0.j0());
                                return;
                            }
                            return;
                        }
                        if (signData != null && g.this.i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", g.this.i.activity_id);
                                jSONObject.put("activity_suc_msg", g.this.i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", g.this.i.activity_fail_msg);
                                jSONObject.put("gift_type", g.this.i.gift_type);
                                jSONObject.put("gift_url", g.this.i.gift_url);
                                jSONObject.put("gift_name", g.this.i.gift_name);
                                jSONObject.put("icon_name", g.this.i.icon_name);
                                jSONObject.put("icon_lifecycle", g.this.i.icon_lifecycle);
                                jSONObject.put("activity_name", g.this.i.activity_name);
                                jSONObject.put("image_url", g.this.i.image_url);
                                d.b.h0.s.d.f.c().j(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> q2 = g.this.f58167a.q();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(g.this.f58167a.getActivity(), "", g.this.j, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        q2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        q.g().k().b();
                        return;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (!g.this.l()) {
                    }
                    d.b.h0.s.d.f.c().j(null);
                    if (w0 != null) {
                    }
                    g.this.f58167a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    x0 = g.this.f58167a.x0();
                    if (x0 == null) {
                    }
                } else {
                    if (signMessage.mSignErrorCode == 160002 && w0 != null) {
                        w0.m0(1);
                    }
                    g.this.f58167a.showToast(signMessage.mSignErrorString);
                }
            } else {
                if (signMessage.signData != null) {
                    AntiHelper.t(g.this.f58167a.getActivity(), signMessage.signData.blockPopInfoData, g.this.l);
                } else {
                    AntiHelper.u(g.this.f58167a.getActivity(), signMessage.mSignErrorString);
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
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsViewData S;
            if (g.this.f58167a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (S = g.this.f58167a.S()) == null || S.getForum() == null) {
                return;
            }
            ForumData forum = S.getForum();
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = forum.getUser_level();
            String str = signData.forumId;
            if (str == null || !str.equals(forum.getId())) {
                return;
            }
            S.updateSignData(signData);
            h w0 = g.this.f58167a.w0();
            boolean z = false;
            if (w0 != null) {
                w0.n0(S);
                z = w0.F();
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
        this.f58167a = frsFragment;
        this.f58170d = bdUniqueId;
    }

    public void i(TBSpecificationBtn tBSpecificationBtn) {
        this.f58168b = tBSpecificationBtn;
    }

    public void j(boolean z) {
        if (!z || this.f58173g) {
            return;
        }
        StatisticItem.make("c13560").param("obj_type", 1).eventStat();
        this.f58173g = true;
    }

    public float k(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.f58171e = forumData.getLevelupScore();
        int curScore = forumData.getCurScore();
        this.f58172f = curScore;
        int i = this.f58171e;
        if (i > 0) {
            return curScore / i;
        }
        return 0.0f;
    }

    public final boolean l() {
        return !TextUtils.isEmpty(this.f58169c);
    }

    public void m(d.b.i0.p0.q2.b bVar, SignData signData) {
        if (bVar == null || signData == null) {
            return;
        }
        int i = signData.sign_bonus_point;
        boolean z = false;
        if (i >= this.f58171e - this.f58172f) {
            z = true;
            this.f58171e = signData.levelup_score;
        }
        int i2 = this.f58172f + i;
        this.f58172f = i2;
        int i3 = this.f58171e;
        if (i2 > i3) {
            this.f58172f = i3;
        }
        int i4 = this.f58171e;
        float f2 = i4 != 0 ? this.f58172f / i4 : 0.0f;
        if (f2 > 0.999f) {
            f2 = 1.0f;
        }
        bVar.v(z, f2);
    }

    public void n() {
        FrsFragment frsFragment = this.f58167a;
        if (frsFragment != null) {
            frsFragment.registerListener(this.k);
            this.f58167a.registerListener(this.m);
        }
    }

    public void o(int i) {
        if (this.f58168b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f58168b.getLayoutParams().width = -2;
        this.f58168b.setPadding(0, 0, 0, 0);
        TBSpecificationButtonConfig styleConfig = this.f58168b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        if (i > 0) {
            this.f58168b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i)));
            styleConfig.i(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        } else {
            this.f58168b.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
            styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        }
        this.f58168b.setTextSize(R.dimen.T_X08);
        this.f58168b.k();
        this.f58168b.setVisibility(0);
    }

    public final void p() {
        if (this.f58168b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f58168b.getLayoutParams().width = -2;
        this.f58168b.setPadding(0, 0, 0, 0);
        this.f58168b.setTextSize(R.dimen.T_X08);
        this.f58168b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f58168b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f58168b.k();
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
        if (this.f58168b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f58168b.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
        this.f58168b.setPadding(0, 0, 0, 0);
        this.f58168b.setTextSize(R.dimen.T_X08);
        this.f58168b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f58168b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f58168b.k();
    }

    public final void s() {
        if (this.f58168b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f58168b.getLayoutParams().width = -2;
        this.f58168b.setPadding(0, 0, 0, 0);
        this.f58168b.setTextSize(R.dimen.T_X08);
        this.f58168b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f58168b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f58168b.k();
    }

    public void t(d.b.i0.p0.q2.b bVar, FrsViewData frsViewData) {
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
        forum.setCurScore(this.f58172f);
        forum.setLevelupScore(this.f58171e);
        bVar.B(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        this.i = signActivityInfo;
    }

    public void v(boolean z, String str) {
        this.f58174h = z;
        TbSingleton.getInstance().setActivityId(str);
        FrsFragment frsFragment = this.f58167a;
        if (frsFragment == null) {
            return;
        }
        FrsViewData S = frsFragment.S();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (S == null || S.getForum() == null) {
                return;
            }
            ForumData forum = S.getForum();
            forum.setFromPage("frs");
            FrsActivityStatic.f15965c = forum.getName() == null ? "" : forum.getName();
            CustomMessage customMessage = new CustomMessage(2001425, forum);
            customMessage.setTag(this.f58170d);
            MessageManager.getInstance().sendMessage(customMessage);
            return;
        }
        TbadkCoreApplication.getInst().login(this.f58167a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f58167a.getActivity(), true, 11014)));
    }

    public void w(int i, int i2, int i3) {
        FrsViewData S;
        FrsFragment frsFragment = this.f58167a;
        if (frsFragment == null || i <= 0 || i2 <= 0 || (S = frsFragment.S()) == null || S.getForum() == null || S.getSignData() == null) {
            return;
        }
        ForumData forum = S.getForum();
        SignData signData = S.getSignData();
        signData.levelup_score = forum.getLevelupScore();
        signData.sign_bonus_point = i3;
        signData.miss_sign_num -= i2;
        signData.count_sign_num = i;
        S.updateSignData(signData);
        signData.forumId = forum.getId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
        h w0 = this.f58167a.w0();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, w0 != null ? w0.F() : false ? forum.getUser_level() + 1 : -1);
    }
}
