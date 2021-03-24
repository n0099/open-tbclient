package d.b.i0.e1.b;

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
import d.b.b.j.e.w;
import d.b.b.j.e.x;
import d.b.h0.r.f0.f;
import d.b.h0.s.c.f0;
import d.b.i0.e1.b.p.e;
import d.b.i0.p0.f2.a.c;
import d.b.i0.x.b0;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class n extends d.b.b.a.d {
    public d.b.i0.p0.f2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f54436a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f54437b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f54438c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e1.b.p.d f54439d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f54440e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f54441f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f54442g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f54443h;
    public d.b.h0.r.f0.g i;
    public d.b.i0.e1.b.p.e j;
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
    public d.b.h0.w.w.h u;
    public d.b.i0.e1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            if (n.this.f54436a.getBaseFragmentActivity() == null) {
                return;
            }
            n.this.f54436a.getBaseFragmentActivity().hideProgressBar();
            n.this.u.a().o();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                n.this.l.setLikeUserData(n.this.m);
                n.this.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || f0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                n.this.f54436a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.h0.w.w.c {
        public b() {
        }

        @Override // d.b.h0.w.w.c
        public void a() {
            if (n.this.f54436a.getBaseFragmentActivity() != null) {
                n.this.f54436a.getBaseFragmentActivity().showProgressBar();
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
            d.b.b.e.p.l.J(n.this.getPageContext().getPageActivity(), n.this.u.s().i());
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

        @Override // d.b.i0.p0.f2.a.c.d
        public void a(boolean z, int i) {
        }

        @Override // d.b.i0.p0.f2.a.c.d
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

        @Override // d.b.i0.p0.f2.a.c.d
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
            if (n.this.f54437b == null || n.this.f54436a == null) {
                return;
            }
            n.this.f54437b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            n.this.f54437b.z(null);
            n.this.f54437b.O();
            n.this.f54436a.U0();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements f.g {
        public h() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (d.b.b.e.p.j.z()) {
                if (n.this.f54436a != null) {
                    n.this.f54436a.W0();
                }
            } else if (n.this.f54440e != null) {
                n.this.f54440e.setRefreshing(false);
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
                    n.this.f54442g.c();
                }
            } else if (recyclerView.canScrollVertically(-1)) {
                n.this.f54442g.c();
            } else {
                n.this.f54442g.a();
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

        @Override // d.b.i0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long f2;
            if (view == null || !(baseCardInfo instanceof d.b.i0.e1.b.p.a)) {
                return;
            }
            d.b.i0.e1.b.p.a aVar = (d.b.i0.e1.b.p.a) baseCardInfo;
            if (aVar.D() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                aVar.H(false);
                n.this.P();
            }
            if (view.getId() == R.id.message_bottom_reply_container) {
                n.this.v = aVar;
                if (aVar.E()) {
                    f2 = d.b.b.e.m.b.f(aVar.u(), 0L);
                } else {
                    f2 = d.b.b.e.m.b.f(aVar.t(), 0L);
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
                    if (aVar.getType() == d.b.i0.e1.b.p.a.B) {
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
            if (n.this.f54437b != null) {
                n.this.f54437b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                n.this.f54437b.z(null);
                n.this.f54437b.L();
                n.this.f54436a.U0();
            }
        }
    }

    /* renamed from: d.b.i0.e1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1237n implements e.b {
        public C1237n() {
        }

        @Override // d.b.i0.e1.b.p.e.b
        public void onClose() {
            if (n.this.j != null) {
                n.this.f54441f.removeHeaderView(n.this.j.e());
                n.this.o = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public o(d.b.b.a.f fVar) {
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
        this.s = new C1237n();
        this.t = null;
        this.D = new c();
        this.E = new d();
        this.F = new f();
        this.f54436a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j());
    }

    public final void G() {
        if (this.f54441f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f54436a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            d.b.i0.e1.b.p.e eVar = this.j;
            if (eVar != null) {
                this.f54441f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long k2 = d.b.h0.r.d0.b.i().k("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (k2 == 0 || System.currentTimeMillis() - k2 > 604800000) {
            if (this.j == null) {
                d.b.i0.e1.b.p.e eVar2 = new d.b.i0.e1.b.p.e(this.f54436a.getPageContext());
                this.j = eVar2;
                eVar2.g(this.s);
            }
            this.f54441f.t(this.j.e(), 0);
            this.o = true;
        }
    }

    public void I(int i2) {
        d.b.i0.e1.b.p.d dVar = this.f54439d;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public BdSwipeRefreshLayout J() {
        return this.f54440e;
    }

    public final void K(int i2, Intent intent) {
        d.b.h0.w.n nVar;
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
            d.b.h0.w.m n = this.u.a().n(6);
            if (n != null && (nVar = n.k) != null) {
                nVar.onAction(new d.b.h0.w.a(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.u.D();
            }
        }
    }

    public final void L(boolean z) {
        d.b.h0.w.w.h hVar = this.u;
        if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
            ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
        }
        d.b.h0.w.w.h hVar2 = (d.b.h0.w.w.h) new d.b.h0.w.w.i(z).a(this.f54436a.getPageContext().getPageActivity());
        this.u = hVar2;
        hVar2.L(this.f54436a.getPageContext());
        this.u.W(this.B);
        this.u.M(3);
        this.u.x(this.f54436a.getPageContext());
        this.u.a().C(true);
        this.u.a().w(TbadkCoreApplication.getInst().getSkinType());
        if (this.u.a() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.f54443h.addView(this.u.a(), layoutParams);
            this.u.a().o();
        }
        this.u.Q(new b());
        this.u.N(this.C);
    }

    public final void M() {
        this.B = new o(d.b.b.a.j.a(this.f54436a.getPageContext().getContext()));
        this.C = new a();
    }

    public final void O() {
        G();
    }

    public void P() {
        d.b.i0.e1.b.p.d dVar = this.f54439d;
        if (dVar != null) {
            dVar.c();
        }
    }

    public boolean Q(int i2, int i3, Intent intent) {
        d.b.h0.w.w.h hVar = this.u;
        if (hVar != null) {
            if (i2 == 12005) {
                hVar.e0();
                d.b.b.e.m.e.a().postDelayed(this.D, 300L);
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
        d.b.h0.w.w.h hVar = this.u;
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
        this.f54443h = viewGroup;
        this.f54442g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.i == null) {
            d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f54436a.getPageContext());
            this.i = gVar;
            gVar.b(this.q);
        }
        this.i.Z(this.f54436a.getUniqueId());
        if (this.f54437b == null) {
            PbListView pbListView = new PbListView(this.f54436a.getContext());
            this.f54437b = pbListView;
            pbListView.b();
        }
        this.f54437b.o(R.color.CAM_X0205);
        this.f54437b.q();
        this.f54437b.r(d.b.b.e.p.l.g(this.f54436a.getContext(), R.dimen.tbds182));
        this.f54437b.v();
        this.f54437b.E(R.dimen.tbfontsize33);
        this.f54437b.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f54437b.y(R.color.CAM_X0110);
        this.f54437b.z(this.p);
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f54443h.findViewById(R.id.reply_me_pull_refresh_layout);
        this.f54440e = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.i);
        this.f54441f = (BdTypeRecyclerView) this.f54443h.findViewById(R.id.replyme_lv);
        d.b.i0.e1.b.p.d dVar = new d.b.i0.e1.b.p.d(this.f54436a.getPageContext(), this.f54441f);
        this.f54439d = dVar;
        dVar.h(new k());
        ((DefaultItemAnimator) this.f54441f.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f54441f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.f54441f.setFadingEdgeLength(0);
        this.f54441f.setOverScrollMode(2);
        this.f54441f.addItemDecoration(new DeviderLineDecoration());
        this.f54441f.setRecyclerListener(new l(this));
        this.f54441f.setOnSrollToBottomListener(new m());
        this.f54441f.setOnScrollListener(this.F);
        this.f54441f.addOnScrollListener(this.r);
        O();
        ReplyMeModel replyMeModel = new ReplyMeModel(this.f54436a.getPageContext());
        this.t = replyMeModel;
        replyMeModel.w(this.E);
        M();
        L(false);
        return this.f54443h;
    }

    public void T(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    public void U() {
        G();
    }

    public void V(boolean z, ArrayList<d.b.b.j.e.n> arrayList) {
        if (this.f54441f == null) {
            return;
        }
        this.f54440e.setVisibility(0);
        b0(false);
        if (z) {
            this.f54437b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f54437b.f();
            this.f54437b.z(this.p);
        } else {
            this.f54437b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f54437b.f();
            this.f54437b.A(this.mContext.getResources().getString(R.string.list_no_more));
            this.f54437b.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f54438c == null) {
                this.f54438c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f54438c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f54438c, R.color.CAM_X0201);
            }
            if (this.f54438c.getParent() == null && !this.k) {
                this.k = true;
                this.f54441f.s(this.f54438c);
                this.f54438c.setVisibility(0);
                this.f54438c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f54441f.setNextPage(null);
            if (arrayList != null) {
                this.f54439d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f54441f.removeHeaderView(this.f54438c);
            this.k = false;
            d.b.i0.e1.b.p.d dVar = this.f54439d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f54439d.c();
            }
            this.f54441f.setNextPage(this.f54437b);
            this.n = R.color.CAM_X0204;
        }
        G();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void W(String str, long j2) {
        d.b.i0.e1.b.p.a aVar;
        d.b.i0.e1.b.p.a aVar2 = this.v;
        if (aVar2 != null && aVar2.g() != null && this.v.C()) {
            d.b.h0.w.w.h hVar = this.u;
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
            d.b.i0.p0.f2.a.c cVar = new d.b.i0.p0.f2.a.c(this.f54436a.getPageContext());
            this.A = cVar;
            cVar.j(new e());
        }
        this.A.h(str, j2);
    }

    public void X(x xVar) {
        d.b.i0.e1.b.p.d dVar = this.f54439d;
        if (dVar != null) {
            dVar.g(xVar);
        }
    }

    public void Y(w wVar) {
        d.b.i0.e1.b.p.d dVar = this.f54439d;
        if (dVar != null) {
            dVar.e(wVar);
        }
    }

    public void b0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        if (this.f54440e != null) {
            if (z && (bdTypeRecyclerView = this.f54441f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.f54441f.setSelection(0);
            }
            this.f54440e.setRefreshing(z);
        }
    }

    @Override // d.b.b.a.d
    public void destroy() {
        d.b.b.e.m.e.a().removeCallbacks(this.D);
        d.b.h0.w.w.h hVar = this.u;
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
        d.b.h0.w.w.h hVar = this.u;
        if (hVar != null && hVar.a() != null) {
            this.u.a().w(i2);
        }
        PbListView pbListView = this.f54437b;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f54437b.d(i2);
        }
        d.b.h0.r.f0.g gVar = this.i;
        if (gVar != null) {
            gVar.I(i2);
        }
        NoDataView noDataView = this.f54438c;
        if (noDataView != null) {
            noDataView.f(this.mContext, i2);
            SkinManager.setBackgroundColor(this.f54438c, R.color.CAM_X0201);
        }
        P();
        SkinManager.setBackgroundColor(this.f54441f, this.n);
        SkinManager.setBackgroundColor(this.f54440e, R.color.CAM_X0205);
        d.b.i0.e1.b.p.e eVar = this.j;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void onServerError(ErrorData errorData) {
    }
}
