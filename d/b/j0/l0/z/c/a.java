package d.b.j0.l0.z.c;

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
import d.b.c.e.p.l;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import d.b.j0.l0.y.c.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58535a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58536b;

    /* renamed from: c  reason: collision with root package name */
    public g f58537c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f58538d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f58539e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f58540f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.l0.y.a f58541g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f58542h;
    public d.b.i0.d0.g i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f58535a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f58538d = relativeLayout;
        this.f58539e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f58538d.findViewById(R.id.forum_emotion_list);
        this.f58536b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f58536b.setDivider(null);
        g gVar = new g(this.f58535a);
        this.f58537c = gVar;
        gVar.Z(bdUniqueId);
        this.f58536b.setPullRefresh(this.f58537c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f58540f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f58536b.z();
    }

    public BdTypeListView b() {
        return this.f58536b;
    }

    public View c() {
        return this.f58539e;
    }

    public ViewGroup d() {
        return this.f58538d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f58542h;
    }

    public void f() {
        PbListView pbListView = this.f58540f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f58536b.setNextPage(null);
    }

    public void g() {
        d.b.i0.d0.g gVar = this.i;
        if (gVar != null) {
            gVar.dettachView(this.f58538d);
            this.i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f58541g.c().setVisibility(0);
        this.f58542h.setVisibility(0);
    }

    public final void i() {
        d.b.j0.l0.y.a aVar = new d.b.j0.l0.y.a(this.f58535a);
        this.f58541g = aVar;
        aVar.c().setVisibility(8);
        this.f58536b.addHeaderView(this.f58541g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f58535a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f58536b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f58535a.getPageActivity());
        this.f58542h = forumEmotionVoteEntryView;
        this.f58536b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i) {
        this.f58540f.o(R.color.CAM_X0204);
        this.f58540f.d(i);
        this.f58537c.I(i);
        this.f58536b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f58538d, R.color.CAM_X0201);
        this.f58539e.c(this.f58535a, i);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f58542h;
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
            this.f58541g.c().setVisibility(0);
            this.f58541g.f(this.f58535a.getUniqueId());
            this.f58541g.e(new c(forumEmotionData.banner));
            this.f58541g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f58542h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f58537c.b(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f58536b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f58540f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58536b.setNextPage(this.f58540f);
            }
            this.f58540f.M();
            this.f58540f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f58535a;
        if (tbPageContext == null || this.f58538d == null) {
            return;
        }
        d.b.i0.d0.g gVar = new d.b.i0.d0.g(tbPageContext.getPageActivity());
        this.i = gVar;
        gVar.attachView(this.f58538d, false);
        this.i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f58535a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f58535a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f58535a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f58541g.c().setVisibility(4);
        this.f58542h.setVisibility(4);
        this.j.f(this.f58535a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f58540f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f58536b.setNextPage(this.f58540f);
            }
            this.f58540f.A(this.f58535a.getResources().getString(R.string.list_no_more));
            this.f58540f.f();
        }
    }
}
