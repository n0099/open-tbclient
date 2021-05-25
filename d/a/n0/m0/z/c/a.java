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
    public TbPageContext f57440a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57441b;

    /* renamed from: c  reason: collision with root package name */
    public g f57442c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f57443d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f57444e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f57445f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.m0.y.a f57446g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f57447h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.d0.g f57448i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f57440a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f57443d = relativeLayout;
        this.f57444e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f57443d.findViewById(R.id.forum_emotion_list);
        this.f57441b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f57441b.setDivider(null);
        g gVar = new g(this.f57440a);
        this.f57442c = gVar;
        gVar.Z(bdUniqueId);
        this.f57441b.setPullRefresh(this.f57442c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f57445f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f57441b.z();
    }

    public BdTypeListView b() {
        return this.f57441b;
    }

    public View c() {
        return this.f57444e;
    }

    public ViewGroup d() {
        return this.f57443d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f57447h;
    }

    public void f() {
        PbListView pbListView = this.f57445f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f57441b.setNextPage(null);
    }

    public void g() {
        d.a.m0.d0.g gVar = this.f57448i;
        if (gVar != null) {
            gVar.dettachView(this.f57443d);
            this.f57448i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f57446g.c().setVisibility(0);
        this.f57447h.setVisibility(0);
    }

    public final void i() {
        d.a.n0.m0.y.a aVar = new d.a.n0.m0.y.a(this.f57440a);
        this.f57446g = aVar;
        aVar.c().setVisibility(8);
        this.f57441b.addHeaderView(this.f57446g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f57440a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f57441b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f57440a.getPageActivity());
        this.f57447h = forumEmotionVoteEntryView;
        this.f57441b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i2) {
        this.f57445f.o(R.color.CAM_X0204);
        this.f57445f.d(i2);
        this.f57442c.I(i2);
        this.f57441b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f57443d, R.color.CAM_X0201);
        this.f57444e.c(this.f57440a, i2);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f57447h;
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
            this.f57446g.c().setVisibility(0);
            this.f57446g.f(this.f57440a.getUniqueId());
            this.f57446g.e(new c(forumEmotionData.banner));
            this.f57446g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f57447h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f57442c.a(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f57441b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f57445f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f57441b.setNextPage(this.f57445f);
            }
            this.f57445f.M();
            this.f57445f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f57440a;
        if (tbPageContext == null || this.f57443d == null) {
            return;
        }
        d.a.m0.d0.g gVar = new d.a.m0.d0.g(tbPageContext.getPageActivity());
        this.f57448i = gVar;
        gVar.attachView(this.f57443d, false);
        this.f57448i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f57440a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f57440a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f57440a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f57446g.c().setVisibility(4);
        this.f57447h.setVisibility(4);
        this.j.f(this.f57440a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f57445f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f57441b.setNextPage(this.f57445f);
            }
            this.f57445f.A(this.f57440a.getResources().getString(R.string.list_no_more));
            this.f57445f.f();
        }
    }
}
