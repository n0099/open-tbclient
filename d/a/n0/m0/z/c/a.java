package d.a.n0.m0.z.c;

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
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.n0.m0.y.c.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61129a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61130b;

    /* renamed from: c  reason: collision with root package name */
    public g f61131c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61132d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61133e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f61134f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.m0.y.a f61135g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f61136h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.d0.g f61137i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f61129a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f61132d = relativeLayout;
        this.f61133e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f61132d.findViewById(R.id.forum_emotion_list);
        this.f61130b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f61130b.setDivider(null);
        g gVar = new g(this.f61129a);
        this.f61131c = gVar;
        gVar.Z(bdUniqueId);
        this.f61130b.setPullRefresh(this.f61131c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f61134f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f61130b.z();
    }

    public BdTypeListView b() {
        return this.f61130b;
    }

    public View c() {
        return this.f61133e;
    }

    public ViewGroup d() {
        return this.f61132d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f61136h;
    }

    public void f() {
        PbListView pbListView = this.f61134f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f61130b.setNextPage(null);
    }

    public void g() {
        d.a.m0.d0.g gVar = this.f61137i;
        if (gVar != null) {
            gVar.dettachView(this.f61132d);
            this.f61137i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f61135g.c().setVisibility(0);
        this.f61136h.setVisibility(0);
    }

    public final void i() {
        d.a.n0.m0.y.a aVar = new d.a.n0.m0.y.a(this.f61129a);
        this.f61135g = aVar;
        aVar.c().setVisibility(8);
        this.f61130b.addHeaderView(this.f61135g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f61129a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f61130b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f61129a.getPageActivity());
        this.f61136h = forumEmotionVoteEntryView;
        this.f61130b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i2) {
        this.f61134f.o(R.color.CAM_X0204);
        this.f61134f.d(i2);
        this.f61131c.I(i2);
        this.f61130b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f61132d, R.color.CAM_X0201);
        this.f61133e.c(this.f61129a, i2);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f61136h;
        if (forumEmotionVoteEntryView != null) {
            forumEmotionVoteEntryView.b(i2);
        }
    }

    public void m(ForumEmotionData forumEmotionData) {
        if (forumEmotionData == null) {
            return;
        }
        g();
        if (forumEmotionData.banner != null) {
            this.f61135g.c().setVisibility(0);
            this.f61135g.f(this.f61129a.getUniqueId());
            this.f61135g.e(new c(forumEmotionData.banner));
            this.f61135g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f61136h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f61131c.a(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f61130b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f61134f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61130b.setNextPage(this.f61134f);
            }
            this.f61134f.M();
            this.f61134f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f61129a;
        if (tbPageContext == null || this.f61132d == null) {
            return;
        }
        d.a.m0.d0.g gVar = new d.a.m0.d0.g(tbPageContext.getPageActivity());
        this.f61137i = gVar;
        gVar.attachView(this.f61132d, false);
        this.f61137i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f61129a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f61129a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f61129a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f61135g.c().setVisibility(4);
        this.f61136h.setVisibility(4);
        this.j.f(this.f61129a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f61134f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61130b.setNextPage(this.f61134f);
            }
            this.f61134f.A(this.f61129a.getResources().getString(R.string.list_no_more));
            this.f61134f.f();
        }
    }
}
