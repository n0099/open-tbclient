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
    public TbPageContext f56708a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56709b;

    /* renamed from: c  reason: collision with root package name */
    public g f56710c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f56711d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f56712e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f56713f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.l0.y.a f56714g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f56715h;
    public d.b.h0.d0.g i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56708a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f56711d = relativeLayout;
        this.f56712e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f56711d.findViewById(R.id.forum_emotion_list);
        this.f56709b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f56709b.setDivider(null);
        g gVar = new g(this.f56708a);
        this.f56710c = gVar;
        gVar.Z(bdUniqueId);
        this.f56709b.setPullRefresh(this.f56710c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f56713f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f56709b.z();
    }

    public BdTypeListView b() {
        return this.f56709b;
    }

    public View c() {
        return this.f56712e;
    }

    public ViewGroup d() {
        return this.f56711d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f56715h;
    }

    public void f() {
        PbListView pbListView = this.f56713f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f56709b.setNextPage(null);
    }

    public void g() {
        d.b.h0.d0.g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this.f56711d);
            this.i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f56714g.c().setVisibility(0);
        this.f56715h.setVisibility(0);
    }

    public final void i() {
        d.b.i0.l0.y.a aVar = new d.b.i0.l0.y.a(this.f56708a);
        this.f56714g = aVar;
        aVar.c().setVisibility(8);
        this.f56709b.addHeaderView(this.f56714g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f56708a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f56709b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f56708a.getPageActivity());
        this.f56715h = forumEmotionVoteEntryView;
        this.f56709b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i) {
        this.f56713f.o(R.color.CAM_X0204);
        this.f56713f.d(i);
        this.f56710c.I(i);
        this.f56709b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f56711d, R.color.CAM_X0201);
        this.f56712e.c(this.f56708a, i);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f56715h;
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
            this.f56714g.c().setVisibility(0);
            this.f56714g.f(this.f56708a.getUniqueId());
            this.f56714g.e(new c(forumEmotionData.banner));
            this.f56714g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f56715h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f56710c.b(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f56709b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f56713f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56709b.setNextPage(this.f56713f);
            }
            this.f56713f.M();
            this.f56713f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f56708a;
        if (tbPageContext == null || this.f56711d == null) {
            return;
        }
        d.b.h0.d0.g gVar = new d.b.h0.d0.g(tbPageContext.getPageActivity());
        this.i = gVar;
        gVar.attachView(this.f56711d, false);
        this.i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f56708a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f56708a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f56708a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f56714g.c().setVisibility(4);
        this.f56715h.setVisibility(4);
        this.j.f(this.f56708a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f56713f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56709b.setNextPage(this.f56713f);
            }
            this.f56713f.A(this.f56708a.getResources().getString(R.string.list_no_more));
            this.f56713f.f();
        }
    }
}
