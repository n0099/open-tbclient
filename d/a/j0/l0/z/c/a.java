package d.a.j0.l0.z.c;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.j0.l0.y.c.c;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56543a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56544b;

    /* renamed from: c  reason: collision with root package name */
    public g f56545c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f56546d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f56547e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f56548f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.l0.y.a f56549g;

    /* renamed from: h  reason: collision with root package name */
    public ForumEmotionVoteEntryView f56550h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.d0.g f56551i;
    public NoDataView j;
    public LinearLayout k;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56543a = tbPageContext;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_forum_emotion_center, (ViewGroup) null);
        this.f56546d = relativeLayout;
        this.f56547e = (NoNetworkView) relativeLayout.findViewById(R.id.no_network_view);
        BdTypeListView bdTypeListView = (BdTypeListView) this.f56546d.findViewById(R.id.forum_emotion_list);
        this.f56544b = bdTypeListView;
        bdTypeListView.addHeaderView(this.k);
        this.f56544b.setDivider(null);
        g gVar = new g(this.f56543a);
        this.f56545c = gVar;
        gVar.Z(bdUniqueId);
        this.f56544b.setPullRefresh(this.f56545c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f56548f = pbListView;
        pbListView.a();
        j();
        i();
        k();
        q();
    }

    public void a() {
        this.f56544b.z();
    }

    public BdTypeListView b() {
        return this.f56544b;
    }

    public View c() {
        return this.f56547e;
    }

    public ViewGroup d() {
        return this.f56546d;
    }

    public ForumEmotionVoteEntryView e() {
        return this.f56550h;
    }

    public void f() {
        PbListView pbListView = this.f56548f;
        if (pbListView != null) {
            pbListView.f();
        }
        this.f56544b.setNextPage(null);
    }

    public void g() {
        d.a.i0.d0.g gVar = this.f56551i;
        if (gVar != null) {
            gVar.dettachView(this.f56546d);
            this.f56551i = null;
        }
    }

    public void h() {
        NoDataView noDataView = this.j;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
        this.f56549g.c().setVisibility(0);
        this.f56550h.setVisibility(0);
    }

    public final void i() {
        d.a.j0.l0.y.a aVar = new d.a.j0.l0.y.a(this.f56543a);
        this.f56549g = aVar;
        aVar.c().setVisibility(8);
        this.f56544b.addHeaderView(this.f56549g.c());
    }

    public final void j() {
        LinearLayout linearLayout = new LinearLayout(this.f56543a.getPageActivity());
        this.k = linearLayout;
        linearLayout.setGravity(17);
        this.f56544b.addHeaderView(this.k);
    }

    public final void k() {
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = new ForumEmotionVoteEntryView(this.f56543a.getPageActivity());
        this.f56550h = forumEmotionVoteEntryView;
        this.f56544b.addHeaderView(forumEmotionVoteEntryView);
    }

    public void l(int i2) {
        this.f56548f.o(R.color.CAM_X0204);
        this.f56548f.d(i2);
        this.f56545c.I(i2);
        this.f56544b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        SkinManager.setBackgroundColor(this.f56546d, R.color.CAM_X0201);
        this.f56547e.c(this.f56543a, i2);
        ForumEmotionVoteEntryView forumEmotionVoteEntryView = this.f56550h;
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
            this.f56549g.c().setVisibility(0);
            this.f56549g.f(this.f56543a.getUniqueId());
            this.f56549g.e(new c(forumEmotionData.banner));
            this.f56549g.g();
        }
        List<String> list = forumEmotionData.forum_avatar;
        if (list != null) {
            this.f56550h.setAvatarList(list);
        }
    }

    public void n(f.g gVar) {
        this.f56545c.a(gVar);
    }

    public void o(BdListView.p pVar) {
        this.f56544b.setOnSrollToBottomListener(pVar);
    }

    public void p() {
        PbListView pbListView = this.f56548f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56544b.setNextPage(this.f56548f);
            }
            this.f56548f.M();
            this.f56548f.O();
        }
    }

    public void q() {
        TbPageContext tbPageContext = this.f56543a;
        if (tbPageContext == null || this.f56546d == null) {
            return;
        }
        d.a.i0.d0.g gVar = new d.a.i0.d0.g(tbPageContext.getPageActivity());
        this.f56551i = gVar;
        gVar.attachView(this.f56546d, false);
        this.f56551i.onChangeSkinType();
    }

    public void r() {
        if (this.j == null) {
            this.j = NoDataViewFactory.b(this.f56543a.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f56543a.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f56543a.getString(R.string.emotion_error_net_tip)), null, true);
        }
        this.j.setVisibility(0);
        this.f56549g.c().setVisibility(4);
        this.f56550h.setVisibility(4);
        this.j.f(this.f56543a, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s() {
        PbListView pbListView = this.f56548f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f56544b.setNextPage(this.f56548f);
            }
            this.f56548f.A(this.f56543a.getResources().getString(R.string.list_no_more));
            this.f56548f.f();
        }
    }
}
