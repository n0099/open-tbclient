package d.b.j0.f1.b;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.c.j.e.w;
import d.b.c.j.e.x;
import d.b.i0.r.f0.f;
import d.b.i0.s.c.h0;
import d.b.j0.f1.b.p.e;
import d.b.j0.q0.f2.a.c;
import d.b.j0.x.b0;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class n extends d.b.c.a.d {
    public d.b.j0.q0.f2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f56299a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f56300b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f56301c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.f1.b.p.d f56302d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f56303e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f56304f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f56305g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f56306h;
    public d.b.i0.r.f0.g i;
    public d.b.j0.f1.b.p.e j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final f.g q;
    public RecyclerView.OnScrollListener r;
    public e.b s;
    public ReplyMeModel t;
    public d.b.i0.w.w.h u;
    public d.b.j0.f1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            if (n.this.f56299a.getBaseFragmentActivity() == null) {
                return;
            }
            n.this.f56299a.getBaseFragmentActivity().hideProgressBar();
            n.this.u.a().o();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                n.this.l.setLikeUserData(n.this.m);
                n.this.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || h0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                n.this.f56299a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.w.w.c {
        public b() {
        }

        @Override // d.b.i0.w.w.c
        public void a() {
            if (n.this.f56299a.getBaseFragmentActivity() != null) {
                n.this.f56299a.getBaseFragmentActivity().showProgressBar();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.u == null || n.this.u.s() == null) {
                return;
            }
            d.b.c.e.p.l.J(n.this.getPageContext().getPageActivity(), n.this.u.s().i());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ReplyMeModel.b {
        public d() {
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            n.this.w = String.valueOf(j);
            n.this.x = str;
            n.this.y = j2;
            n.this.z = j3;
            n nVar = n.this;
            nVar.W(nVar.w, j4);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c.d {
        public e() {
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void a(boolean z, int i) {
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                if (n.this.u == null || n.this.u.v) {
                    n.this.L(false);
                }
                if (n.this.u == null || n.this.v == null) {
                    return;
                }
                if (!n.this.v.E() || n.this.v.v() == null) {
                    n.this.u.f0(null);
                } else {
                    n.this.u.f0(n.this.v.v().getName_show());
                }
            }
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 0 && n.this.u != null) {
                n.this.u.w();
            }
            super.onScrollStateChanged(recyclerView, i);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n.this.f56300b == null || n.this.f56299a == null) {
                return;
            }
            n.this.f56300b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            n.this.f56300b.z(null);
            n.this.f56300b.O();
            n.this.f56299a.U0();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements f.g {
        public h() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (d.b.c.e.p.j.z()) {
                if (n.this.f56299a != null) {
                    n.this.f56299a.W0();
                }
            } else if (n.this.f56303e != null) {
                n.this.f56303e.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends RecyclerView.OnScrollListener {
        public i() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0) {
                if (i == 1 || i == 2) {
                    n.this.f56305g.c();
                }
            } else if (recyclerView.canScrollVertically(-1)) {
                n.this.f56305g.c();
            } else {
                n.this.f56305g.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public j() {
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            if (!z || n.this.u == null) {
                return;
            }
            n.this.u.D();
        }
    }

    /* loaded from: classes4.dex */
    public class k extends b0 {
        public k() {
        }

        @Override // d.b.j0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long f2;
            if (view == null || !(baseCardInfo instanceof d.b.j0.f1.b.p.a)) {
                return;
            }
            d.b.j0.f1.b.p.a aVar = (d.b.j0.f1.b.p.a) baseCardInfo;
            if (aVar.D() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                aVar.H(false);
                n.this.P();
            }
            if (view.getId() == R.id.message_bottom_reply_container) {
                n.this.v = aVar;
                if (aVar.E()) {
                    f2 = d.b.c.e.m.b.f(aVar.u(), 0L);
                } else {
                    f2 = d.b.c.e.m.b.f(aVar.t(), 0L);
                }
                long j = f2;
                if (n.this.m == null) {
                    n.this.m = new AttentionHostData();
                }
                if (n.this.v != null) {
                    n.this.m.parserWithMetaData(n.this.v.y());
                }
                n.this.t.v(j, 2, aVar.j(), aVar.z(), n.this.v != null ? n.this.v.g() : null);
                if (aVar.w() != null) {
                    StatisticItem param = new StatisticItem(aVar.w()).param("obj_locate", 3);
                    if (aVar.getType() == d.b.j0.f1.b.p.a.B) {
                        param.param("obj_type", 1);
                    } else {
                        param.param("obj_type", 2);
                    }
                    TiebaStatic.log(param);
                }
                StatisticItem statisticItem = new StatisticItem("c13784");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements RecyclerView.RecyclerListener {
        public l(n nVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements BdListView.p {
        public m() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (n.this.f56300b != null) {
                n.this.f56300b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                n.this.f56300b.z(null);
                n.this.f56300b.L();
                n.this.f56299a.U0();
            }
        }
    }

    /* renamed from: d.b.j0.f1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1320n implements e.b {
        public C1320n() {
        }

        @Override // d.b.j0.f1.b.p.e.b
        public void onClose() {
            if (n.this.j != null) {
                n.this.f56304f.removeHeaderView(n.this.j.e());
                n.this.o = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public o(d.b.c.a.f fVar) {
            super(fVar);
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean LoadData() {
            return false;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            return false;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String s() {
            return null;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData t(String str) {
            WriteData writeData = new WriteData();
            writeData.setForumId(n.this.w);
            writeData.setForumName(n.this.x);
            writeData.setThreadId(n.this.v.z());
            writeData.setIsAd(false);
            writeData.setFloorNum(0);
            if (n.this.v.E()) {
                writeData.setFloor(n.this.y > 0 ? String.valueOf(n.this.y) : n.this.v.o().n);
            } else {
                writeData.setFloor(n.this.v.t());
            }
            if (n.this.z > 0) {
                writeData.setRepostId(String.valueOf(n.this.z));
            }
            if (n.this.v != null) {
                writeData.setBaijiahaoData(n.this.v.g());
            }
            writeData.setType(2);
            return writeData;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean u() {
            return false;
        }
    }

    public n(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.p = new g();
        this.q = new h();
        this.r = new i();
        this.s = new C1320n();
        this.t = null;
        this.D = new c();
        this.E = new d();
        this.F = new f();
        this.f56299a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j());
    }

    public final void G() {
        if (this.f56304f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f56299a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            d.b.j0.f1.b.p.e eVar = this.j;
            if (eVar != null) {
                this.f56304f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = d.b.i0.r.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.j == null) {
                d.b.j0.f1.b.p.e eVar2 = new d.b.j0.f1.b.p.e(this.f56299a.getPageContext());
                this.j = eVar2;
                eVar2.g(this.s);
            }
            this.f56304f.t(this.j.e(), 0);
            this.o = true;
        }
    }

    public void I(int i2) {
        d.b.j0.f1.b.p.d dVar = this.f56302d;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public BdSwipeRefreshLayout J() {
        return this.f56303e;
    }

    public final void K(int i2, Intent intent) {
        d.b.i0.w.n nVar;
        this.u.a().q();
        this.u.w();
        this.u.a().y();
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
        if (serializableExtra instanceof PbEditorData) {
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            this.u.z(writeData);
            this.u.Y(pbEditorData.getVoiceModel());
            d.b.i0.w.m n = this.u.a().n(6);
            if (n != null && (nVar = n.k) != null) {
                nVar.onAction(new d.b.i0.w.a(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.u.D();
            }
        }
    }

    public final void L(boolean z) {
        d.b.i0.w.w.h hVar = this.u;
        if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
            ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
        }
        d.b.i0.w.w.h hVar2 = (d.b.i0.w.w.h) new d.b.i0.w.w.i(z).a(this.f56299a.getPageContext().getPageActivity());
        this.u = hVar2;
        hVar2.L(this.f56299a.getPageContext());
        this.u.W(this.B);
        this.u.M(3);
        this.u.x(this.f56299a.getPageContext());
        this.u.a().C(true);
        this.u.a().w(TbadkCoreApplication.getInst().getSkinType());
        if (this.u.a() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.f56306h.addView(this.u.a(), layoutParams);
            this.u.a().o();
        }
        this.u.Q(new b());
        this.u.N(this.C);
    }

    public final void M() {
        this.B = new o(d.b.c.a.j.a(this.f56299a.getPageContext().getContext()));
        this.C = new a();
    }

    public final void O() {
        G();
    }

    public void P() {
        d.b.j0.f1.b.p.d dVar = this.f56302d;
        if (dVar != null) {
            dVar.c();
        }
    }

    public boolean Q(int i2, int i3, Intent intent) {
        d.b.i0.w.w.h hVar = this.u;
        if (hVar != null) {
            if (i2 == 12005) {
                hVar.e0();
                d.b.c.e.m.e.a().postDelayed(this.D, 300L);
            }
            this.u.A(i2, i3, intent);
        }
        if (i2 == 25035) {
            K(i3, intent);
            return false;
        }
        return false;
    }

    public boolean R() {
        d.b.i0.w.w.h hVar = this.u;
        if (hVar == null || hVar.a() == null || this.u.a().getVisibility() != 0) {
            return false;
        }
        this.u.w();
        return true;
    }

    public View S(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.f56306h = viewGroup;
        this.f56305g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.i == null) {
            d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(this.f56299a.getPageContext());
            this.i = gVar;
            gVar.b(this.q);
        }
        this.i.Z(this.f56299a.getUniqueId());
        if (this.f56300b == null) {
            PbListView pbListView = new PbListView(this.f56299a.getContext());
            this.f56300b = pbListView;
            pbListView.b();
        }
        this.f56300b.o(R.color.CAM_X0205);
        this.f56300b.q();
        this.f56300b.r(d.b.c.e.p.l.g(this.f56299a.getContext(), R.dimen.tbds182));
        this.f56300b.v();
        this.f56300b.E(R.dimen.tbfontsize33);
        this.f56300b.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f56300b.y(R.color.CAM_X0110);
        this.f56300b.z(this.p);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f56306h.findViewById(R.id.reply_me_pull_refresh_layout);
        this.f56303e = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.i);
        this.f56304f = (BdTypeRecyclerView) this.f56306h.findViewById(R.id.replyme_lv);
        d.b.j0.f1.b.p.d dVar = new d.b.j0.f1.b.p.d(this.f56299a.getPageContext(), this.f56304f);
        this.f56302d = dVar;
        dVar.h(new k());
        ((DefaultItemAnimator) this.f56304f.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f56304f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.f56304f.setFadingEdgeLength(0);
        this.f56304f.setOverScrollMode(2);
        this.f56304f.addItemDecoration(new DeviderLineDecoration());
        this.f56304f.setRecyclerListener(new l(this));
        this.f56304f.setOnSrollToBottomListener(new m());
        this.f56304f.setOnScrollListener(this.F);
        this.f56304f.addOnScrollListener(this.r);
        O();
        ReplyMeModel replyMeModel = new ReplyMeModel(this.f56299a.getPageContext());
        this.t = replyMeModel;
        replyMeModel.w(this.E);
        M();
        L(false);
        return this.f56306h;
    }

    public void T(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    public void U() {
        G();
    }

    public void V(boolean z, ArrayList<d.b.c.j.e.n> arrayList) {
        if (this.f56304f == null) {
            return;
        }
        this.f56303e.setVisibility(0);
        b0(false);
        if (z) {
            this.f56300b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f56300b.f();
            this.f56300b.z(this.p);
        } else {
            this.f56300b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f56300b.f();
            this.f56300b.A(this.mContext.getResources().getString(R.string.list_no_more));
            this.f56300b.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f56301c == null) {
                this.f56301c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f56301c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f56301c, R.color.CAM_X0201);
            }
            if (this.f56301c.getParent() == null && !this.k) {
                this.k = true;
                this.f56304f.s(this.f56301c);
                this.f56301c.setVisibility(0);
                this.f56301c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f56304f.setNextPage(null);
            if (arrayList != null) {
                this.f56302d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f56304f.removeHeaderView(this.f56301c);
            this.k = false;
            d.b.j0.f1.b.p.d dVar = this.f56302d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f56302d.c();
            }
            this.f56304f.setNextPage(this.f56300b);
            this.n = R.color.CAM_X0204;
        }
        G();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void W(String str, long j2) {
        d.b.j0.f1.b.p.a aVar;
        d.b.j0.f1.b.p.a aVar2 = this.v;
        if (aVar2 != null && aVar2.g() != null && this.v.C()) {
            d.b.i0.w.w.h hVar = this.u;
            if (hVar == null || !hVar.v) {
                L(true);
            }
            if (this.u == null || (aVar = this.v) == null) {
                return;
            }
            if (aVar.E() && this.v.v() != null) {
                this.u.f0(this.v.v().getName_show());
                return;
            } else {
                this.u.f0(null);
                return;
            }
        }
        if (this.A == null) {
            d.b.j0.q0.f2.a.c cVar = new d.b.j0.q0.f2.a.c(this.f56299a.getPageContext());
            this.A = cVar;
            cVar.j(new e());
        }
        this.A.h(str, j2);
    }

    public void X(x xVar) {
        d.b.j0.f1.b.p.d dVar = this.f56302d;
        if (dVar != null) {
            dVar.g(xVar);
        }
    }

    public void Y(w wVar) {
        d.b.j0.f1.b.p.d dVar = this.f56302d;
        if (dVar != null) {
            dVar.e(wVar);
        }
    }

    public void b0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        if (this.f56303e != null) {
            if (z && (bdTypeRecyclerView = this.f56304f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.f56304f.setSelection(0);
            }
            this.f56303e.setRefreshing(z);
        }
    }

    @Override // d.b.c.a.d
    public void destroy() {
        d.b.c.e.m.e.a().removeCallbacks(this.D);
        d.b.i0.w.w.h hVar = this.u;
        if (hVar != null) {
            hVar.B();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        ReplyMeModel replyMeModel = this.t;
        if (replyMeModel != null) {
            replyMeModel.w(null);
            this.t.onDestroy();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
        if (replyPrivacyCheckController2 != null) {
            replyPrivacyCheckController2.setAttentionCallback(null);
        }
    }

    public void onChangeSkinType(int i2) {
        d.b.i0.w.w.h hVar = this.u;
        if (hVar != null && hVar.a() != null) {
            this.u.a().w(i2);
        }
        PbListView pbListView = this.f56300b;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f56300b.d(i2);
        }
        d.b.i0.r.f0.g gVar = this.i;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoDataView noDataView = this.f56301c;
        if (noDataView != null) {
            noDataView.f(this.mContext, i2);
            SkinManager.setBackgroundColor(this.f56301c, R.color.CAM_X0201);
        }
        P();
        SkinManager.setBackgroundColor(this.f56304f, this.n);
        SkinManager.setBackgroundColor(this.f56303e, R.color.CAM_X0205);
        d.b.j0.f1.b.p.e eVar = this.j;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void onServerError(ErrorData errorData) {
    }
}
