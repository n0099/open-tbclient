package d.a.k0.l0.z.c;

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
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import d.a.k0.l0.y.c.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57250a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57251b;

    /* renamed from: c  reason: collision with root package name */
    public g f57252c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f57253d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f57254e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f57255f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.l0.y.a f57256g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f57257h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.d0.g f57258i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f57250a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f57253d = relativeLayout;
        this.f57254e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f57253d.findViewById(R.id.forum_emotion_list);
        this.f57251b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f57251b.setDivider(null);
        g gVar = new g(this.f57250a);
        this.f57252c = gVar;
        gVar.Z(bdUniqueId);
        this.f57251b.setPullRefresh(this.f57252c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f57255f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f57251b.z();
    }

    public BdTypeListView b() {
        return this.f57251b;
    }

    public View c() {
        return this.f57254e;
    }

    public ViewGroup d() {
        return this.f57253d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f57257h;
    }

    public void f() {
        PbListView pbListView = this.f57255f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f57251b.setNextPage(null);
    }

    public void g() {
        d.a.j0.d0.g gVar = this.f57258i;
        if (gVar != null) {
            gVar.dettachView(this.f57253d);
            this.f57258i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f57256g.c().setVisibility(0);
        this.f57257h.setVisibility(0);
    }

    public final void i() {
        d.a.k0.l0.y.a aVar = new d.a.k0.l0.y.a(this.f57250a);
        this.f57256g = aVar;
        aVar.c().setVisibility(8);
        this.f57251b.addHeaderView(this.f57256g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f57250a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f57251b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f57250a.getPageActivity());
        this.f57257h = forumEmotionVoteEntryView;
        this.f57251b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i2) {
        this.f57255f.o(R.color.CAM_X0204);
        this.f57255f.d(i2);
        this.f57252c.I(i2);
        this.f57251b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f57253d, R.color.CAM_X0201);
        this.f57254e.c(this.f57250a, i2);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f57257h;
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
            this.f57256g.c().setVisibility(0);
            this.f57256g.f(this.f57250a.getUniqueId());
            this.f57256g.e(new c(forumEmotionData.banner));
            this.f57256g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f57257h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f57252c.a(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f57251b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f57255f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f57251b.setNextPage(this.f57255f);
            }
            this.f57255f.M();
            this.f57255f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f57250a;
        if (tbPageContext == null || this.f57253d == null) {
            return;
        }
        d.a.j0.d0.g gVar = new d.a.j0.d0.g(tbPageContext.getPageActivity());
        this.f57258i = gVar;
        gVar.attachView(this.f57253d, false);
        this.f57258i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f57250a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f57250a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f57250a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f57256g.c().setVisibility(4);
        this.f57257h.setVisibility(4);
        this.j.f(this.f57250a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f57255f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f57251b.setNextPage(this.f57255f);
            }
            this.f57255f.A(this.f57250a.getResources().getString(R.string.list_no_more));
            this.f57255f.f();
        }
    }
}
