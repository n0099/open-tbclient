package d.a.j0.q0.o2;

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
import d.a.i0.a.q;
import d.a.j0.q0.r;
import org.json.JSONObject;
import tbclient.SignActivityInfo;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f58372a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f58373b;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f58375d;

    /* renamed from: e  reason: collision with root package name */
    public int f58376e;

    /* renamed from: f  reason: collision with root package name */
    public int f58377f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58378g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58379h;

    /* renamed from: i  reason: collision with root package name */
    public SignActivityInfo f58380i;
    public String j = "https://tieba.baidu.com/mo/q/signActivityPage";
    public CustomMessageListener k = new a(2001425);
    public AntiHelper.k l = new b(this);
    public CustomMessageListener m = new c(2001222);

    /* renamed from: c  reason: collision with root package name */
    public String f58374c = TbSingleton.getInstance().getWalletSignLink();

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
            FrsViewData g0;
            ForumData forum;
            String name;
            SignData signData;
            boolean z;
            boolean z2;
            r z0;
            int i2;
            if (g.this.f58372a == null || !(customResponsedMessage instanceof SignMessage) || (g0 = g.this.f58372a.g0()) == null || g0.getForum() == null || (name = (forum = g0.getForum()).getName()) == null || !name.equals(FrsActivityStatic.f15799c) || customResponsedMessage.getOrginalMessage().getTag() != g.this.f58375d) {
                return;
            }
            TiebaStatic.eventStat(g.this.f58372a.getActivity(), "sign_end_time", System.currentTimeMillis() + "");
            String name2 = forum.getName();
            SignMessage signMessage = (SignMessage) customResponsedMessage;
            if (!AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                h P = g.this.f58372a.P();
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    signData = null;
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(forum.getId())) {
                        return;
                    }
                    if (P != null) {
                        P.Z(name2);
                    }
                    g0.updateSignData(signData);
                    signData.forumId = forum.getId();
                    signData.forumName = forum.getName();
                    z = true;
                }
                if (z) {
                    int user_level = forum.getUser_level();
                    if (P != null ? P.B() : false) {
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
                        if (z2 || !g.this.f58379h) {
                            if (!g.this.l() && signData.contDays > 0) {
                                d.a.i0.s.d.f.c().j(signData.userInfoJson);
                                TbPageContext<?> o = g.this.f58372a.o();
                                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(g.this.f58372a.getActivity(), "", g.this.f58374c, false, true, true);
                                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                                o.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                                q.g().k().b();
                                return;
                            }
                            d.a.i0.s.d.f.c().j(null);
                            if (P != null || P.u()) {
                                g.this.f58372a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                            } else {
                                g.this.f58372a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_success, new Object[]{Integer.valueOf(signData.user_sign_rank)}));
                            }
                            z0 = g.this.f58372a.z0();
                            if (z0 == null) {
                                d.a.i0.s.d.f.c().a(g.this.f58372a.o(), z0.j0());
                                return;
                            }
                            return;
                        }
                        if (signData != null && g.this.f58380i != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(signData.userInfoJson);
                                jSONObject.put("activity_id", g.this.f58380i.activity_id);
                                jSONObject.put("activity_suc_msg", g.this.f58380i.activity_suc_msg);
                                jSONObject.put("activity_fail_msg", g.this.f58380i.activity_fail_msg);
                                jSONObject.put("gift_type", g.this.f58380i.gift_type);
                                jSONObject.put("gift_url", g.this.f58380i.gift_url);
                                jSONObject.put("gift_name", g.this.f58380i.gift_name);
                                jSONObject.put("icon_name", g.this.f58380i.icon_name);
                                jSONObject.put("icon_lifecycle", g.this.f58380i.icon_lifecycle);
                                jSONObject.put("activity_name", g.this.f58380i.activity_name);
                                jSONObject.put("image_url", g.this.f58380i.image_url);
                                d.a.i0.s.d.f.c().j(jSONObject.toString());
                            } catch (Exception unused) {
                            }
                        }
                        TbPageContext<?> o2 = g.this.f58372a.o();
                        TbWebViewActivityConfig tbWebViewActivityConfig2 = new TbWebViewActivityConfig(g.this.f58372a.getActivity(), "", g.this.j, false, true, true);
                        tbWebViewActivityConfig2.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        o2.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig2));
                        q.g().k().b();
                        return;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (!g.this.l()) {
                    }
                    d.a.i0.s.d.f.c().j(null);
                    if (P != null) {
                    }
                    g.this.f58372a.showToast(TbadkCoreApplication.getInst().getString(R.string.frs_sign_pointer, new Object[]{Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)}));
                    z0 = g.this.f58372a.z0();
                    if (z0 == null) {
                    }
                } else {
                    if (signMessage.mSignErrorCode == 160002 && P != null) {
                        P.i0(1);
                    }
                    g.this.f58372a.showToast(signMessage.mSignErrorString);
                }
            } else {
                if (signMessage.signData != null) {
                    AntiHelper.t(g.this.f58372a.getActivity(), signMessage.signData.blockPopInfoData, g.this.l);
                } else {
                    AntiHelper.u(g.this.f58372a.getActivity(), signMessage.mSignErrorString);
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
        public void onNavigationButtonClick(d.a.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_SIGN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.i0.r.s.a aVar) {
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
            FrsViewData g0;
            if (g.this.f58372a == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (g0 = g.this.f58372a.g0()) == null || g0.getForum() == null) {
                return;
            }
            ForumData forum = g0.getForum();
            SignData signData = (SignData) customResponsedMessage.getData();
            int user_level = forum.getUser_level();
            String str = signData.forumId;
            if (str == null || !str.equals(forum.getId())) {
                return;
            }
            g0.updateSignData(signData);
            h P = g.this.f58372a.P();
            boolean z = false;
            if (P != null) {
                P.j0(g0);
                z = P.B();
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
        this.f58372a = frsFragment;
        this.f58375d = bdUniqueId;
    }

    public void i(TBSpecificationBtn tBSpecificationBtn) {
        this.f58373b = tBSpecificationBtn;
    }

    public void j(boolean z) {
        if (!z || this.f58378g) {
            return;
        }
        StatisticItem.make("c13560").param("obj_type", 1).eventStat();
        this.f58378g = true;
    }

    public float k(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.f58376e = forumData.getLevelupScore();
        int curScore = forumData.getCurScore();
        this.f58377f = curScore;
        int i2 = this.f58376e;
        if (i2 > 0) {
            return curScore / i2;
        }
        return 0.0f;
    }

    public final boolean l() {
        return !TextUtils.isEmpty(this.f58374c);
    }

    public void m(d.a.j0.q0.r2.b bVar, SignData signData) {
        if (bVar == null || signData == null) {
            return;
        }
        int i2 = signData.sign_bonus_point;
        boolean z = false;
        if (i2 >= this.f58376e - this.f58377f) {
            z = true;
            this.f58376e = signData.levelup_score;
        }
        int i3 = this.f58377f + i2;
        this.f58377f = i3;
        int i4 = this.f58376e;
        if (i3 > i4) {
            this.f58377f = i4;
        }
        int i5 = this.f58376e;
        float f2 = i5 != 0 ? this.f58377f / i5 : 0.0f;
        if (f2 > 0.999f) {
            f2 = 1.0f;
        }
        bVar.v(z, f2);
    }

    public void n() {
        FrsFragment frsFragment = this.f58372a;
        if (frsFragment != null) {
            frsFragment.registerListener(this.k);
            this.f58372a.registerListener(this.m);
        }
    }

    public void o(int i2) {
        if (this.f58373b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f58373b.getLayoutParams().width = -2;
        this.f58373b.setPadding(0, 0, 0, 0);
        TBSpecificationButtonConfig styleConfig = this.f58373b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        if (i2 > 0) {
            this.f58373b.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.miss_sign_days), Integer.valueOf(i2)));
            styleConfig.i(R.drawable.icon_pure_frs_sign_add16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        } else {
            this.f58373b.setText(TbadkCoreApplication.getInst().getString(R.string.signed));
            styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        }
        this.f58373b.setTextSize(R.dimen.T_X08);
        this.f58373b.k();
        this.f58373b.setVisibility(0);
    }

    public final void p() {
        if (this.f58373b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f58373b.getLayoutParams().width = -2;
        this.f58373b.setPadding(0, 0, 0, 0);
        this.f58373b.setTextSize(R.dimen.T_X08);
        this.f58373b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f58373b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gift20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f58373b.k();
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
        if (this.f58373b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        this.f58373b.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
        this.f58373b.setPadding(0, 0, 0, 0);
        this.f58373b.setTextSize(R.dimen.T_X08);
        this.f58373b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f58373b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.i(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f58373b.k();
    }

    public final void s() {
        if (this.f58373b == null) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds52);
        this.f58373b.getLayoutParams().width = -2;
        this.f58373b.setPadding(0, 0, 0, 0);
        this.f58373b.setTextSize(R.dimen.T_X08);
        this.f58373b.setText(TbadkCoreApplication.getInst().getString(R.string.sign));
        TBSpecificationButtonConfig styleConfig = this.f58373b.getStyleConfig();
        styleConfig.g(dimenPixelSize);
        styleConfig.f(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
        styleConfig.n(TBSpecificationButtonConfig.WebpType.MASK);
        styleConfig.i(R.drawable.icon_mask_frs_gold20, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f58373b.k();
    }

    public void t(d.a.j0.q0.r2.b bVar, FrsViewData frsViewData) {
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
        forum.setCurScore(this.f58377f);
        forum.setLevelupScore(this.f58376e);
        bVar.B(forum, frsViewData);
    }

    public void u(SignActivityInfo signActivityInfo) {
        this.f58380i = signActivityInfo;
    }

    public void v(boolean z, String str) {
        this.f58379h = z;
        TbSingleton.getInstance().setActivityId(str);
        FrsFragment frsFragment = this.f58372a;
        if (frsFragment == null) {
            return;
        }
        FrsViewData g0 = frsFragment.g0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (g0 == null || g0.getForum() == null) {
                return;
            }
            ForumData forum = g0.getForum();
            forum.setFromPage("frs");
            FrsActivityStatic.f15799c = forum.getName() == null ? "" : forum.getName();
            CustomMessage customMessage = new CustomMessage(2001425, forum);
            customMessage.setTag(this.f58375d);
            MessageManager.getInstance().sendMessage(customMessage);
            return;
        }
        TbadkCoreApplication.getInst().login(this.f58372a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f58372a.getActivity(), true, 11014)));
    }

    public void w(int i2, int i3, int i4) {
        FrsViewData g0;
        FrsFragment frsFragment = this.f58372a;
        if (frsFragment == null || i2 <= 0 || i3 <= 0 || (g0 = frsFragment.g0()) == null || g0.getForum() == null || g0.getSignData() == null) {
            return;
        }
        ForumData forum = g0.getForum();
        SignData signData = g0.getSignData();
        signData.levelup_score = forum.getLevelupScore();
        signData.sign_bonus_point = i4;
        signData.miss_sign_num -= i3;
        signData.count_sign_num = i2;
        g0.updateSignData(signData);
        signData.forumId = forum.getId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
        h P = this.f58372a.P();
        TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, P != null ? P.B() : false ? forum.getUser_level() + 1 : -1);
    }
}
