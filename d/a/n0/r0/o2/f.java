package d.a.n0.r0.o2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
    public FrsFragment f62935a;

    /* renamed from: b  reason: collision with root package name */
    public TBSpecificationBtn f62936b;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62939e;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f62937c = null;

    /* renamed from: d  reason: collision with root package name */
    public f0 f62938d = null;

    /* renamed from: f  reason: collision with root package name */
    public AntiHelper.k f62940f = new a(this);

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.a.e f62941g = new b();

    /* renamed from: h  reason: collision with root package name */
    public f0.a f62942h = new c();

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
            FrsViewData j0;
            if (f.this.f62935a == null || (j0 = f.this.f62935a.j0()) == null || j0.getForum() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(f.this.f62937c.getErrorCode(), f.this.f62937c.getErrorString())) {
                if (AntiHelper.t(f.this.f62935a.getActivity(), f.this.f62937c.J(), f.this.f62940f) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            String name = j0.getForum().getName();
            String id = j0.getForum().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = wVar != null && f.this.f62937c.getErrorCode() == 0;
            if (wVar.d() == 3250013) {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                z = false;
            }
            if (wVar == null || !z) {
                if (f.this.f62937c.getErrorCode() == 22) {
                    f.this.f62935a.showToast(f.this.f62935a.getString(R.string.had_liked_forum));
                } else {
                    f.this.f62935a.showToast(f.this.f62937c.getErrorString());
                }
            } else {
                h R = f.this.f62935a.R();
                if (R != null) {
                    R.Z(name);
                }
                wVar.v(1);
                j0.updateLikeData(wVar);
                j0.setLikeFeedForumDataList(wVar.f());
                if (R != null) {
                    R.h0(j0, f.this.f62939e);
                }
                f.this.f62939e = true;
                f.this.f62935a.showToast(f.this.f62935a.getResources().getString(R.string.attention_success));
                if (d.a.m0.s.h.a.e(f.this.f62935a.getContext(), 0)) {
                    d.a.m0.s.h.a.g(f.this.f62935a.getPageContext(), 4, 2000L);
                }
                f.this.o(true, id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                f.this.i();
            }
            f.this.f62935a.R2(Boolean.valueOf(z));
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
            FrsViewData j0;
            if (f.this.f62935a == null || (j0 = f.this.f62935a.j0()) == null || j0.getForum() == null) {
                return;
            }
            String name = j0.getForum().getName();
            String id = j0.getForum().getId();
            if (j == d.a.c.e.m.b.f(id, 0L) && TextUtils.equals(name, str)) {
                h R = f.this.f62935a.R();
                if (R != null) {
                    R.Z(str);
                }
                j0.getForum().setLike(0);
                if (R != null) {
                    R.S(0);
                }
                f.this.f62935a.R3(Boolean.TRUE);
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
            if (f.this.f62935a == null || f.this.f62938d == null) {
                return;
            }
            FrsViewData j0 = f.this.f62935a.j0();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (j0 == null || j0.getForum() == null) {
                    return;
                }
                f.this.f62938d.c(j0.getForum().getName(), d.a.c.e.m.b.f(j0.getForum().getId(), 0L));
                return;
            }
            TbadkCoreApplication.getInst().login(f.this.f62935a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.f62935a.getActivity(), true, 11036)));
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
        this.f62935a = frsFragment;
    }

    public final void i() {
        StatisticItem statisticItem = new StatisticItem("c13605");
        FrsFragment frsFragment = this.f62935a;
        if (frsFragment != null) {
            d.a.m0.j0.c.b(frsFragment.getContext(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public void j(TBSpecificationBtn tBSpecificationBtn) {
        this.f62936b = tBSpecificationBtn;
        p();
    }

    public final void k() {
        FrsFragment frsFragment = this.f62935a;
        if (frsFragment != null) {
            LikeModel likeModel = new LikeModel(frsFragment.getPageContext());
            this.f62937c = likeModel;
            likeModel.setLoadDataCallBack(this.f62941g);
        }
    }

    public final void l() {
        f0 f0Var = new f0();
        this.f62938d = f0Var;
        f0Var.a("from_frs");
        this.f62938d.b(this.f62942h);
    }

    public void m() {
        k();
        l();
    }

    public void n() {
        LikeModel likeModel = this.f62937c;
        if (likeModel != null) {
            likeModel.I();
        }
    }

    public final void o(boolean z, String str) {
        d.a.n0.f1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void p() {
        TBSpecificationBtn tBSpecificationBtn = this.f62936b;
        if (tBSpecificationBtn == null) {
            return;
        }
        tBSpecificationBtn.k();
    }

    public void q(String str, String str2) {
        LikeModel likeModel = this.f62937c;
        if (likeModel != null) {
            likeModel.M(str, str2, "FRS");
        }
    }

    public void r(boolean z) {
        FrsFragment frsFragment = this.f62935a;
        if (frsFragment == null || this.f62937c == null) {
            return;
        }
        FrsViewData j0 = frsFragment.j0();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (j0 == null || j0.getForum() == null) {
                return;
            }
            if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.f62935a.s2())) {
                TiebaStatic.log(new StatisticItem("c10356").param("fid", j0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.f62935a.s2())) {
                TiebaStatic.log(new StatisticItem("c10590").param("obj_type", 2).param("fid", j0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.f62935a.s2())) {
                TiebaStatic.log(new StatisticItem("c10587").param("obj_type", 2).param("fid", j0.getForum().getId()));
            } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.f62935a.s2())) {
                TiebaStatic.log(new StatisticItem("c10578").param("obj_type", 2).param("fid", j0.getForum().getId()));
            }
            this.f62937c.setFrom("recom_flist_like_frs");
            if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.f62935a.s2())) {
                TiebaStatic.eventStat(this.f62935a.getPageContext().getPageActivity(), "square_frs_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.f62935a.s2())) {
                TiebaStatic.log(new StatisticItem("c10359").param("fid", j0.getForum().getId()));
            }
            this.f62937c.M(j0.getForum().getName(), j0.getForum().getId(), "FRS");
            this.f62939e = z;
            return;
        }
        TbadkCoreApplication.getInst().login(this.f62935a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f62935a.getActivity(), true, CyberPlayerManager.MEDIA_INFO_KERNEL_NET_TRAFFIC)));
    }

    public void s() {
        FrsFragment frsFragment = this.f62935a;
        if (frsFragment == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(frsFragment.getActivity());
        FrsViewData j0 = this.f62935a.j0();
        String name = (j0 == null || j0.getForum() == null || j0.getForum().getName() == null) ? "" : j0.getForum().getName();
        if (!StringUtils.isNull(name)) {
            aVar.setMessage(String.format(this.f62935a.getString(R.string.attention_cancel_dialog_content), name));
        } else {
            aVar.setMessage(this.f62935a.getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.setPositiveButton(this.f62935a.getString(R.string.editor_dialog_yes), new d());
        aVar.setNegativeButton(this.f62935a.getString(R.string.editor_dialog_no), new e(this));
        aVar.create(this.f62935a.p()).show();
    }
}
