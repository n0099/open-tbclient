package d.b.j0.q0.o2;

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
import d.b.i0.r.s.a;
import d.b.j0.d3.f0;
import d.b.j0.d3.w;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f60273a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f60274b;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60277e;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f60275c = null;

    /* renamed from: d  reason: collision with root package name */
    public f0 f60276d = null;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f60278f = new a(this);

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.a.e f60279g = new b();

    /* renamed from: h  reason: collision with root package name */
    public f0.a f60280h = new c();

    /* loaded from: classes4.dex */
    public class a implements AntiHelper.k {
        public a(f fVar) {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.c.a.e {
        public b() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            FrsViewData S;
            if (f.this.f60273a == null || (S = f.this.f60273a.S()) == null || S.getForum() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(f.this.f60275c.getErrorCode(), f.this.f60275c.getErrorString())) {
                if (AntiHelper.t(f.this.f60273a.getActivity(), f.this.f60275c.F(), f.this.f60278f) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String name = S.getForum().getName();
            String id = S.getForum().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = wVar != null && f.this.f60275c.getErrorCode() == 0;
            if (wVar.d() == 3250013) {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                z = false;
            }
            if (wVar == null || !z) {
                if (f.this.f60275c.getErrorCode() == 22) {
                    f.this.f60273a.showToast(f.this.f60273a.getString(R.string.had_liked_forum));
                } else {
                    f.this.f60273a.showToast(f.this.f60275c.getErrorString());
                }
            } else {
                h w0 = f.this.f60273a.w0();
                if (w0 != null) {
                    w0.b0(name);
                }
                wVar.v(1);
                S.updateLikeData(wVar);
                S.setLikeFeedForumDataList(wVar.f());
                if (w0 != null) {
                    w0.j0(S, f.this.f60277e);
                }
                f.this.f60277e = true;
                f.this.f60273a.showToast(f.this.f60273a.getResources().getString(R.string.attention_success));
                if (d.b.i0.s.h.a.e(f.this.f60273a.getContext(), 0)) {
                    d.b.i0.s.h.a.g(f.this.f60273a.getPageContext(), 4, 2000L);
                }
                f.this.o(true, id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                f.this.i();
            }
            f.this.f60273a.P2(Boolean.valueOf(z));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f0.a {
        public c() {
        }

        @Override // d.b.j0.d3.f0.a
        public void a(String str, long j) {
        }

        @Override // d.b.j0.d3.f0.a
        public void b(String str, long j) {
            FrsViewData S;
            if (f.this.f60273a == null || (S = f.this.f60273a.S()) == null || S.getForum() == null) {
                return;
            }
            String name = S.getForum().getName();
            String id = S.getForum().getId();
            if (j == d.b.c.e.m.b.f(id, 0L) && TextUtils.equals(name, str)) {
                h w0 = f.this.f60273a.w0();
                if (w0 != null) {
                    w0.b0(str);
                }
                S.getForum().setLike(0);
                if (w0 != null) {
                    w0.U(0);
                }
                f.this.f60273a.P3(Boolean.TRUE);
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

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            if (f.this.f60273a == null || f.this.f60276d == null) {
                return;
            }
            FrsViewData S = f.this.f60273a.S();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (S == null || S.getForum() == null) {
                    return;
                }
                f.this.f60276d.c(S.getForum().getName(), d.b.c.e.m.b.f(S.getForum().getId(), 0L));
                return;
            }
            TbadkCoreApplication.getInst().login(f.this.f60273a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.f60273a.getActivity(), true, 11036)));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public e(f fVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public f(FrsFragment frsFragment) {
        this.f60273a = frsFragment;
    }

    public final void i() {
        StatisticItem statisticItem = new StatisticItem("c13605");
        FrsFragment frsFragment = this.f60273a;
        if (frsFragment != null) {
            d.b.i0.j0.c.b(frsFragment.getContext(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public void j(TBSpecificationBtn tBSpecificationBtn) {
        this.f60274b = tBSpecificationBtn;
        p();
    }

    public final void k() {
        FrsFragment frsFragment = this.f60273a;
        if (frsFragment != null) {
            LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
            this.f60275c = likeModel;
            likeModel.setLoadDataCallBack(this.f60279g);
        }
    }

    public final void l() {
        f0 f0Var = new f0();
        this.f60276d = f0Var;
        f0Var.a("from_frs");
        this.f60276d.b(this.f60280h);
    }

    public void m() {
        k();
        l();
    }

    public void n() {
        LikeModel likeModel = this.f60275c;
        if (likeModel != null) {
            likeModel.E();
        }
    }

    public final void o(boolean z, String str) {
        d.b.j0.e1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void p() {
        TBSpecificationBtn tBSpecificationBtn = this.f60274b;
        if (tBSpecificationBtn == null) {
            return;
        }
        tBSpecificationBtn.k();
    }

    public void q(String str, String str2) {
        LikeModel likeModel = this.f60275c;
        if (likeModel != null) {
            likeModel.I(str, str2, "FRS");
        }
    }

    public void r(boolean z) {
        FrsFragment frsFragment = this.f60273a;
        if (frsFragment == null || this.f60275c == null) {
            return;
        }
        FrsViewData S = frsFragment.S();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (S == null || S.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f60273a.q2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", S.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f60273a.q2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", S.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f60273a.q2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", S.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f60273a.q2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", S.getForum().getId()));
            }
            this.f60275c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f60273a.q2())) {
                TiebaStatic.eventStat(this.f60273a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f60273a.q2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", S.getForum().getId()));
            }
            this.f60275c.I(S.getForum().getName(), S.getForum().getId(), "FRS");
            this.f60277e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f60273a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f60273a.getActivity(), true, 11002)));
    }

    public void s() {
        FrsFragment frsFragment = this.f60273a;
        if (frsFragment == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(frsFragment.getActivity());
        FrsViewData S = this.f60273a.S();
        String name = (S == null || S.getForum() == null || S.getForum().getName() == null) ? "" : S.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f60273a.getString(R.string.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f60273a.getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f60273a.getString(R.string.editor_dialog_yes), new d());
        aVar.setNegativeButton(this.f60273a.getString(R.string.editor_dialog_no), new e(this));
        aVar.create(this.f60273a.q()).show();
    }
}
