package d.b.i0.l0.z.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionVoteEntryView;
import d.b.b.e.p.l;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.l0.y.c.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56707a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56708b;

    /* renamed from: c  reason: collision with root package name */
    public g f56709c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f56710d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f56711e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f56712f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.l0.y.a f56713g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f56714h;
    public d.b.h0.d0.g i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56707a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f56710d = relativeLayout;
        this.f56711e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f56710d.findViewById(R.id.forum_emotion_list);
        this.f56708b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f56708b.setDivider(null);
        g gVar = new g(this.f56707a);
        this.f56709c = gVar;
        gVar.Z(bdUniqueId);
        this.f56708b.setPullRefresh(this.f56709c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f56712f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f56708b.z();
    }

    public BdTypeListView b() {
        return this.f56708b;
    }

    public View c() {
        return this.f56711e;
    }

    public ViewGroup d() {
        return this.f56710d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f56714h;
    }

    public void f() {
        PbListView pbListView = this.f56712f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f56708b.setNextPage(null);
    }

    public void g() {
        d.b.h0.d0.g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this.f56710d);
            this.i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f56713g.c().setVisibility(0);
        this.f56714h.setVisibility(0);
    }

    public final void i() {
        d.b.i0.l0.y.a aVar = new d.b.i0.l0.y.a(this.f56707a);
        this.f56713g = aVar;
        aVar.c().setVisibility(8);
        this.f56708b.addHeaderView(this.f56713g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f56707a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f56708b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f56707a.getPageActivity());
        this.f56714h = forumEmotionVoteEntryView;
        this.f56708b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i) {
        this.f56712f.o(R.color.CAM_X0204);
        this.f56712f.d(i);
        this.f56709c.I(i);
        this.f56708b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f56710d, R.color.CAM_X0201);
        this.f56711e.c(this.f56707a, i);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f56714h;
        if (forumEmotionVoteEntryView != null) {
            forumEmotionVoteEntryView.b(i);
        }
    }

    public void m(ForumEmotionData forumEmotionData) {
        if (forumEmotionData == null) {
            return;
        }
        g();
        if (forumEmotionData.banner != null) {
            this.f56713g.c().setVisibility(0);
            this.f56713g.f(this.f56707a.getUniqueId());
            this.f56713g.e(new c(forumEmotionData.banner));
            this.f56713g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f56714h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f56709c.b(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f56708b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f56712f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56708b.setNextPage(this.f56712f);
            }
            this.f56712f.M();
            this.f56712f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f56707a;
        if (tbPageContext == null || this.f56710d == null) {
            return;
        }
        d.b.h0.d0.g gVar = new d.b.h0.d0.g(tbPageContext.getPageActivity());
        this.i = gVar;
        gVar.attachView(this.f56710d, false);
        this.i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f56707a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f56707a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f56707a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f56713g.c().setVisibility(4);
        this.f56714h.setVisibility(4);
        this.j.f(this.f56707a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f56712f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56708b.setNextPage(this.f56712f);
            }
            this.f56712f.A(this.f56707a.getResources().getString(R.string.list_no_more));
            this.f56712f.f();
        }
    }
}
