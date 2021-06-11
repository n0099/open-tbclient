package d.a.n0.g1.b;

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
import d.a.c.k.e.w;
import d.a.c.k.e.x;
import d.a.m0.r.f0.f;
import d.a.m0.s.c.i0;
import d.a.n0.g1.b.p.e;
import d.a.n0.r0.f2.a.c;
import d.a.n0.z.b0;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class n extends d.a.c.a.d {
    public d.a.n0.r0.f2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f58765a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f58766b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f58767c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g1.b.p.d f58768d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f58769e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f58770f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f58771g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f58772h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.r.f0.g f58773i;
    public d.a.n0.g1.b.p.e j;
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
    public d.a.m0.w.w.h u;
    public d.a.n0.g1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            if (n.this.f58765a.getBaseFragmentActivity() == null) {
                return;
            }
            n.this.f58765a.getBaseFragmentActivity().hideProgressBar();
            n.this.u.a().o();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                n.this.l.setLikeUserData(n.this.m);
                n.this.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || i0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                n.this.f58765a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.m0.w.w.c {
        public b() {
        }

        @Override // d.a.m0.w.w.c
        public void a() {
            if (n.this.f58765a.getBaseFragmentActivity() != null) {
                n.this.f58765a.getBaseFragmentActivity().showProgressBar();
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
            d.a.c.e.p.l.K(n.this.getPageContext().getPageActivity(), n.this.u.s().i());
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
            nVar.U(nVar.w, j4);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c.d {
        public e() {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                if (n.this.u == null || n.this.u.v) {
                    n.this.J(false);
                }
                if (n.this.u == null || n.this.v == null) {
                    return;
                }
                if (!n.this.v.E() || n.this.v.t() == null) {
                    n.this.u.f0(null);
                } else {
                    n.this.u.f0(n.this.v.t().getName_show());
                }
            }
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 != 0 && n.this.u != null) {
                n.this.u.w();
            }
            super.onScrollStateChanged(recyclerView, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n.this.f58766b == null || n.this.f58765a == null) {
                return;
            }
            n.this.f58766b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            n.this.f58766b.z(null);
            n.this.f58766b.O();
            n.this.f58765a.W0();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements f.g {
        public h() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (d.a.c.e.p.j.z()) {
                if (n.this.f58765a != null) {
                    n.this.f58765a.Y0();
                }
            } else if (n.this.f58769e != null) {
                n.this.f58769e.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends RecyclerView.OnScrollListener {
        public i() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
                    n.this.f58771g.c();
                }
            } else if (recyclerView.canScrollVertically(-1)) {
                n.this.f58771g.c();
            } else {
                n.this.f58771g.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public j() {
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
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

        @Override // d.a.n0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long f2;
            if (view == null || !(baseCardInfo instanceof d.a.n0.g1.b.p.a)) {
                return;
            }
            d.a.n0.g1.b.p.a aVar = (d.a.n0.g1.b.p.a) baseCardInfo;
            if (aVar.D() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                aVar.H(false);
                n.this.M();
            }
            if (view.getId() == R.id.message_bottom_reply_container) {
                n.this.v = aVar;
                if (aVar.E()) {
                    f2 = d.a.c.e.m.b.f(aVar.q(), 0L);
                } else {
                    f2 = d.a.c.e.m.b.f(aVar.p(), 0L);
                }
                long j = f2;
                if (n.this.m == null) {
                    n.this.m = new AttentionHostData();
                }
                if (n.this.v != null) {
                    n.this.m.parserWithMetaData(n.this.v.y());
                }
                n.this.t.z(j, 2, aVar.g(), aVar.z(), n.this.v != null ? n.this.v.c() : null);
                if (aVar.w() != null) {
                    StatisticItem param = new StatisticItem(aVar.w()).param("obj_locate", 3);
                    if (aVar.getType() == d.a.n0.g1.b.p.a.B) {
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
            if (n.this.f58766b != null) {
                n.this.f58766b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                n.this.f58766b.z(null);
                n.this.f58766b.L();
                n.this.f58765a.W0();
            }
        }
    }

    /* renamed from: d.a.n0.g1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1405n implements e.b {
        public C1405n() {
        }

        @Override // d.a.n0.g1.b.p.e.b
        public void onClose() {
            if (n.this.j != null) {
                n.this.f58770f.removeHeaderView(n.this.j.e());
                n.this.o = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public o(d.a.c.a.f fVar) {
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
        public String w() {
            return null;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData x(String str) {
            WriteData writeData = new WriteData();
            writeData.setForumId(n.this.w);
            writeData.setForumName(n.this.x);
            writeData.setThreadId(n.this.v.z());
            writeData.setIsAd(false);
            writeData.setFloorNum(0);
            if (n.this.v.E()) {
                writeData.setFloor(n.this.y > 0 ? String.valueOf(n.this.y) : n.this.v.k().n);
            } else {
                writeData.setFloor(n.this.v.p());
            }
            if (n.this.z > 0) {
                writeData.setRepostId(String.valueOf(n.this.z));
            }
            if (n.this.v != null) {
                writeData.setBaijiahaoData(n.this.v.c());
            }
            writeData.setType(2);
            return writeData;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean y() {
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
        this.s = new C1405n();
        this.t = null;
        this.D = new c();
        this.E = new d();
        this.F = new f();
        this.f58765a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j());
    }

    public final void F() {
        if (this.f58770f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f58765a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            d.a.n0.g1.b.p.e eVar = this.j;
            if (eVar != null) {
                this.f58770f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = d.a.m0.r.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.j == null) {
                d.a.n0.g1.b.p.e eVar2 = new d.a.n0.g1.b.p.e(this.f58765a.getPageContext());
                this.j = eVar2;
                eVar2.g(this.s);
            }
            this.f58770f.t(this.j.e(), 0);
            this.o = true;
        }
    }

    public void G(int i2) {
        d.a.n0.g1.b.p.d dVar = this.f58768d;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public BdSwipeRefreshLayout H() {
        return this.f58769e;
    }

    public final void I(int i2, Intent intent) {
        d.a.m0.w.n nVar;
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
            d.a.m0.w.m n = this.u.a().n(6);
            if (n != null && (nVar = n.k) != null) {
                nVar.onAction(new d.a.m0.w.a(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.u.D();
            }
        }
    }

    public final void J(boolean z) {
        d.a.m0.w.w.h hVar = this.u;
        if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
            ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
        }
        d.a.m0.w.w.h hVar2 = (d.a.m0.w.w.h) new d.a.m0.w.w.i(z).a(this.f58765a.getPageContext().getPageActivity());
        this.u = hVar2;
        hVar2.L(this.f58765a.getPageContext());
        this.u.W(this.B);
        this.u.M(3);
        this.u.x(this.f58765a.getPageContext());
        this.u.a().C(true);
        this.u.a().w(TbadkCoreApplication.getInst().getSkinType());
        if (this.u.a() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.f58772h.addView(this.u.a(), layoutParams);
            this.u.a().o();
        }
        this.u.Q(new b());
        this.u.N(this.C);
    }

    public final void K() {
        this.B = new o(d.a.c.a.j.a(this.f58765a.getPageContext().getContext()));
        this.C = new a();
    }

    public final void L() {
        F();
    }

    public void M() {
        d.a.n0.g1.b.p.d dVar = this.f58768d;
        if (dVar != null) {
            dVar.c();
        }
    }

    public boolean O(int i2, int i3, Intent intent) {
        d.a.m0.w.w.h hVar = this.u;
        if (hVar != null) {
            if (i2 == 12005) {
                hVar.e0();
                d.a.c.e.m.e.a().postDelayed(this.D, 300L);
            }
            this.u.A(i2, i3, intent);
        }
        if (i2 == 25035) {
            I(i3, intent);
            return false;
        }
        return false;
    }

    public boolean P() {
        d.a.m0.w.w.h hVar = this.u;
        if (hVar == null || hVar.a() == null || this.u.a().getVisibility() != 0) {
            return false;
        }
        this.u.w();
        return true;
    }

    public View Q(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.f58772h = viewGroup;
        this.f58771g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.f58773i == null) {
            d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f58765a.getPageContext());
            this.f58773i = gVar;
            gVar.a(this.q);
        }
        this.f58773i.Z(this.f58765a.getUniqueId());
        if (this.f58766b == null) {
            PbListView pbListView = new PbListView(this.f58765a.getContext());
            this.f58766b = pbListView;
            pbListView.b();
        }
        this.f58766b.o(R.color.CAM_X0205);
        this.f58766b.q();
        this.f58766b.r(d.a.c.e.p.l.g(this.f58765a.getContext(), R.dimen.tbds182));
        this.f58766b.v();
        this.f58766b.E(R.dimen.tbfontsize33);
        this.f58766b.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f58766b.y(R.color.CAM_X0110);
        this.f58766b.z(this.p);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f58772h.findViewById(R.id.reply_me_pull_refresh_layout);
        this.f58769e = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f58773i);
        this.f58770f = (BdTypeRecyclerView) this.f58772h.findViewById(R.id.replyme_lv);
        d.a.n0.g1.b.p.d dVar = new d.a.n0.g1.b.p.d(this.f58765a.getPageContext(), this.f58770f);
        this.f58768d = dVar;
        dVar.h(new k());
        ((DefaultItemAnimator) this.f58770f.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f58770f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.f58770f.setFadingEdgeLength(0);
        this.f58770f.setOverScrollMode(2);
        this.f58770f.addItemDecoration(new DeviderLineDecoration());
        this.f58770f.setRecyclerListener(new l(this));
        this.f58770f.setOnSrollToBottomListener(new m());
        this.f58770f.setOnScrollListener(this.F);
        this.f58770f.addOnScrollListener(this.r);
        L();
        ReplyMeModel replyMeModel = new ReplyMeModel(this.f58765a.getPageContext());
        this.t = replyMeModel;
        replyMeModel.A(this.E);
        K();
        J(false);
        return this.f58772h;
    }

    public void R(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    public void S() {
        F();
    }

    public void T(boolean z, ArrayList<d.a.c.k.e.n> arrayList) {
        if (this.f58770f == null) {
            return;
        }
        this.f58769e.setVisibility(0);
        Z(false);
        if (z) {
            this.f58766b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f58766b.f();
            this.f58766b.z(this.p);
        } else {
            this.f58766b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f58766b.f();
            this.f58766b.A(this.mContext.getResources().getString(R.string.list_no_more));
            this.f58766b.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f58767c == null) {
                this.f58767c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f58767c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f58767c, R.color.CAM_X0201);
            }
            if (this.f58767c.getParent() == null && !this.k) {
                this.k = true;
                this.f58770f.s(this.f58767c);
                this.f58767c.setVisibility(0);
                this.f58767c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f58770f.setNextPage(null);
            if (arrayList != null) {
                this.f58768d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f58770f.removeHeaderView(this.f58767c);
            this.k = false;
            d.a.n0.g1.b.p.d dVar = this.f58768d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f58768d.c();
            }
            this.f58770f.setNextPage(this.f58766b);
            this.n = R.color.CAM_X0204;
        }
        F();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void U(String str, long j2) {
        d.a.n0.g1.b.p.a aVar;
        d.a.n0.g1.b.p.a aVar2 = this.v;
        if (aVar2 != null && aVar2.c() != null && this.v.C()) {
            d.a.m0.w.w.h hVar = this.u;
            if (hVar == null || !hVar.v) {
                J(true);
            }
            if (this.u == null || (aVar = this.v) == null) {
                return;
            }
            if (aVar.E() && this.v.t() != null) {
                this.u.f0(this.v.t().getName_show());
                return;
            } else {
                this.u.f0(null);
                return;
            }
        }
        if (this.A == null) {
            d.a.n0.r0.f2.a.c cVar = new d.a.n0.r0.f2.a.c(this.f58765a.getPageContext());
            this.A = cVar;
            cVar.i(new e());
        }
        this.A.g(str, j2);
    }

    public void V(x xVar) {
        d.a.n0.g1.b.p.d dVar = this.f58768d;
        if (dVar != null) {
            dVar.g(xVar);
        }
    }

    public void Y(w wVar) {
        d.a.n0.g1.b.p.d dVar = this.f58768d;
        if (dVar != null) {
            dVar.e(wVar);
        }
    }

    public void Z(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        if (this.f58769e != null) {
            if (z && (bdTypeRecyclerView = this.f58770f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.f58770f.setSelection(0);
            }
            this.f58769e.setRefreshing(z);
        }
    }

    @Override // d.a.c.a.d
    public void destroy() {
        d.a.c.e.m.e.a().removeCallbacks(this.D);
        d.a.m0.w.w.h hVar = this.u;
        if (hVar != null) {
            hVar.B();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        ReplyMeModel replyMeModel = this.t;
        if (replyMeModel != null) {
            replyMeModel.A(null);
            this.t.onDestroy();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
        if (replyPrivacyCheckController2 != null) {
            replyPrivacyCheckController2.setAttentionCallback(null);
        }
    }

    public void onChangeSkinType(int i2) {
        d.a.m0.w.w.h hVar = this.u;
        if (hVar != null && hVar.a() != null) {
            this.u.a().w(i2);
        }
        PbListView pbListView = this.f58766b;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f58766b.d(i2);
        }
        d.a.m0.r.f0.g gVar = this.f58773i;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoDataView noDataView = this.f58767c;
        if (noDataView != null) {
            noDataView.f(this.mContext, i2);
            SkinManager.setBackgroundColor(this.f58767c, R.color.CAM_X0201);
        }
        M();
        SkinManager.setBackgroundColor(this.f58770f, this.n);
        SkinManager.setBackgroundColor(this.f58769e, R.color.CAM_X0205);
        d.a.n0.g1.b.p.e eVar = this.j;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void onServerError(ErrorData errorData) {
    }
}
