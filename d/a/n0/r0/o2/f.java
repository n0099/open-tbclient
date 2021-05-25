package d.a.n0.r0.o2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.m0.r.s.a;
import d.a.n0.e3.f0;
import d.a.n0.e3.w;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59244a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f59245b;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59248e;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f59246c = null;

    /* renamed from: d  reason: collision with root package name */
    public f0 f59247d = null;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f59249f = new a(this);

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.a.e f59250g = new b();

    /* renamed from: h  reason: collision with root package name */
    public f0.a f59251h = new c();

    /* loaded from: classes4.dex */
    public class a implements AntiHelper.k {
        public a(f fVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.a.e {
        public b() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            FrsViewData g0;
            if (f.this.f59244a == null || (g0 = f.this.f59244a.g0()) == null || g0.getForum() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(f.this.f59246c.getErrorCode(), f.this.f59246c.getErrorString())) {
                if (AntiHelper.t(f.this.f59244a.getActivity(), f.this.f59246c.F(), f.this.f59249f) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String name = g0.getForum().getName();
            String id = g0.getForum().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = wVar != null && f.this.f59246c.getErrorCode() == 0;
            if (wVar.d() == 3250013) {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                z = false;
            }
            if (wVar == null || !z) {
                if (f.this.f59246c.getErrorCode() == 22) {
                    f.this.f59244a.showToast(f.this.f59244a.getString(R.string.had_liked_forum));
                } else {
                    f.this.f59244a.showToast(f.this.f59246c.getErrorString());
                }
            } else {
                h P = f.this.f59244a.P();
                if (P != null) {
                    P.Z(name);
                }
                wVar.v(1);
                g0.updateLikeData(wVar);
                g0.setLikeFeedForumDataList(wVar.f());
                if (P != null) {
                    P.h0(g0, f.this.f59248e);
                }
                f.this.f59248e = true;
                f.this.f59244a.showToast(f.this.f59244a.getResources().getString(R.string.attention_success));
                if (d.a.m0.s.h.a.e(f.this.f59244a.getContext(), 0)) {
                    d.a.m0.s.h.a.g(f.this.f59244a.getPageContext(), 4, 2000L);
                }
                f.this.o(true, id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                f.this.i();
            }
            f.this.f59244a.O2(Boolean.valueOf(z));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f0.a {
        public c() {
        }

        @Override // d.a.n0.e3.f0.a
        public void a(String str, long j) {
        }

        @Override // d.a.n0.e3.f0.a
        public void b(String str, long j) {
            FrsViewData g0;
            if (f.this.f59244a == null || (g0 = f.this.f59244a.g0()) == null || g0.getForum() == null) {
                return;
            }
            String name = g0.getForum().getName();
            String id = g0.getForum().getId();
            if (j == d.a.c.e.m.b.f(id, 0L) && TextUtils.equals(name, str)) {
                h P = f.this.f59244a.P();
                if (P != null) {
                    P.Z(str);
                }
                g0.getForum().setLike(0);
                if (P != null) {
                    P.S(0);
                }
                f.this.f59244a.O3(Boolean.TRUE);
                f.this.o(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                w wVar = new w();
                wVar.v(0);
                wVar.s(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            if (f.this.f59244a == null || f.this.f59247d == null) {
                return;
            }
            FrsViewData g0 = f.this.f59244a.g0();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (g0 == null || g0.getForum() == null) {
                    return;
                }
                f.this.f59247d.c(g0.getForum().getName(), d.a.c.e.m.b.f(g0.getForum().getId(), 0L));
                return;
            }
            TbadkCoreApplication.getInst().login(f.this.f59244a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.f59244a.getActivity(), true, 11036)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public e(f fVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public f(FrsFragment frsFragment) {
        this.f59244a = frsFragment;
    }

    public final void i() {
        StatisticItem statisticItem = new StatisticItem("c13605");
        FrsFragment frsFragment = this.f59244a;
        if (frsFragment != null) {
            d.a.m0.j0.c.b(frsFragment.getContext(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public void j(TBSpecificationBtn tBSpecificationBtn) {
        this.f59245b = tBSpecificationBtn;
        p();
    }

    public final void k() {
        FrsFragment frsFragment = this.f59244a;
        if (frsFragment != null) {
            LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
            this.f59246c = likeModel;
            likeModel.setLoadDataCallBack(this.f59250g);
        }
    }

    public final void l() {
        f0 f0Var = new f0();
        this.f59247d = f0Var;
        f0Var.a("from_frs");
        this.f59247d.b(this.f59251h);
    }

    public void m() {
        k();
        l();
    }

    public void n() {
        LikeModel likeModel = this.f59246c;
        if (likeModel != null) {
            likeModel.E();
        }
    }

    public final void o(boolean z, String str) {
        d.a.n0.f1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void p() {
        TBSpecificationBtn tBSpecificationBtn = this.f59245b;
        if (tBSpecificationBtn == null) {
            return;
        }
        tBSpecificationBtn.k();
    }

    public void q(String str, String str2) {
        LikeModel likeModel = this.f59246c;
        if (likeModel != null) {
            likeModel.I(str, str2, "FRS");
        }
    }

    public void r(boolean z) {
        FrsFragment frsFragment = this.f59244a;
        if (frsFragment == null || this.f59246c == null) {
            return;
        }
        FrsViewData g0 = frsFragment.g0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (g0 == null || g0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f59244a.p2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", g0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f59244a.p2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", g0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f59244a.p2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", g0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f59244a.p2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", g0.getForum().getId()));
            }
            this.f59246c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f59244a.p2())) {
                TiebaStatic.eventStat(this.f59244a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f59244a.p2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", g0.getForum().getId()));
            }
            this.f59246c.I(g0.getForum().getName(), g0.getForum().getId(), "FRS");
            this.f59248e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f59244a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f59244a.getActivity(), true, 11002)));
    }

    public void s() {
        FrsFragment frsFragment = this.f59244a;
        if (frsFragment == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(frsFragment.getActivity());
        FrsViewData g0 = this.f59244a.g0();
        String name = (g0 == null || g0.getForum() == null || g0.getForum().getName() == null) ? "" : g0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f59244a.getString(R.string.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f59244a.getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f59244a.getString(R.string.editor_dialog_yes), new d());
        aVar.setNegativeButton(this.f59244a.getString(R.string.editor_dialog_no), new e(this));
        aVar.create(this.f59244a.o()).show();
    }
}
