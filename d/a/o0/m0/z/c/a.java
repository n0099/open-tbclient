package d.a.o0.m0.z.c;

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
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import d.a.o0.m0.y.c.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61254a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61255b;

    /* renamed from: c  reason: collision with root package name */
    public g f61256c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61257d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61258e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f61259f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.m0.y.a f61260g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f61261h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.d0.g f61262i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f61254a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f61257d = relativeLayout;
        this.f61258e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f61257d.findViewById(R.id.forum_emotion_list);
        this.f61255b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f61255b.setDivider(null);
        g gVar = new g(this.f61254a);
        this.f61256c = gVar;
        gVar.Z(bdUniqueId);
        this.f61255b.setPullRefresh(this.f61256c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f61259f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f61255b.z();
    }

    public BdTypeListView b() {
        return this.f61255b;
    }

    public View c() {
        return this.f61258e;
    }

    public ViewGroup d() {
        return this.f61257d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f61261h;
    }

    public void f() {
        PbListView pbListView = this.f61259f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f61255b.setNextPage(null);
    }

    public void g() {
        d.a.n0.d0.g gVar = this.f61262i;
        if (gVar != null) {
            gVar.dettachView(this.f61257d);
            this.f61262i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f61260g.c().setVisibility(0);
        this.f61261h.setVisibility(0);
    }

    public final void i() {
        d.a.o0.m0.y.a aVar = new d.a.o0.m0.y.a(this.f61254a);
        this.f61260g = aVar;
        aVar.c().setVisibility(8);
        this.f61255b.addHeaderView(this.f61260g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f61254a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f61255b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f61254a.getPageActivity());
        this.f61261h = forumEmotionVoteEntryView;
        this.f61255b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i2) {
        this.f61259f.o(R.color.CAM_X0204);
        this.f61259f.d(i2);
        this.f61256c.I(i2);
        this.f61255b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f61257d, R.color.CAM_X0201);
        this.f61258e.c(this.f61254a, i2);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f61261h;
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
            this.f61260g.c().setVisibility(0);
            this.f61260g.f(this.f61254a.getUniqueId());
            this.f61260g.e(new c(forumEmotionData.banner));
            this.f61260g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f61261h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f61256c.a(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f61255b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f61259f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61255b.setNextPage(this.f61259f);
            }
            this.f61259f.M();
            this.f61259f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f61254a;
        if (tbPageContext == null || this.f61257d == null) {
            return;
        }
        d.a.n0.d0.g gVar = new d.a.n0.d0.g(tbPageContext.getPageActivity());
        this.f61262i = gVar;
        gVar.attachView(this.f61257d, false);
        this.f61262i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f61254a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f61254a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f61254a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f61260g.c().setVisibility(4);
        this.f61261h.setVisibility(4);
        this.j.f(this.f61254a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f61259f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f61255b.setNextPage(this.f61259f);
            }
            this.f61259f.A(this.f61254a.getResources().getString(R.string.list_no_more));
            this.f61259f.f();
        }
    }
}
