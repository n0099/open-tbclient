package d.a.k0.a3;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.square.adapter.LeftAdapter;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.j0.d0.g;
import d.a.j0.d0.h;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f51914a;

    /* renamed from: b  reason: collision with root package name */
    public View f51915b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f51916c;

    /* renamed from: d  reason: collision with root package name */
    public ForumHeaderView f51917d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f51918e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51919f;

    /* renamed from: g  reason: collision with root package name */
    public View f51920g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.a3.k.b f51921h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f51922i;
    public g j;
    public h k;
    public NoDataView l;
    public View.OnClickListener m;
    public final TbPageContext n;
    public CustomMessageListener o = new a(2001304);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304) {
                return;
            }
            b.this.a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public b(Context context, TbPageContext tbPageContext) {
        this.f51914a = context;
        this.n = tbPageContext;
        this.f51915b = LayoutInflater.from(context).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        k();
        j();
    }

    public void A(String str) {
        ForumHeaderView forumHeaderView = this.f51917d;
        if (forumHeaderView != null) {
            forumHeaderView.setSearchHint(str);
        }
    }

    public void B(String str) {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.x(str);
        }
    }

    public void C(boolean z) {
        this.f51920g.setVisibility(z ? 0 : 8);
    }

    public void D() {
        g();
        h();
        i();
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.y(true);
            this.f51921h.w(8);
        }
    }

    public boolean E(boolean z) {
        if (z) {
            if (j.z()) {
                o();
                return true;
            }
            p();
            return true;
        }
        n();
        return false;
    }

    public void F() {
        h();
        i();
        G(true);
    }

    public void G(boolean z) {
        if (l()) {
            return;
        }
        if (this.j == null) {
            g gVar = new g(this.f51914a);
            this.j = gVar;
            gVar.q(l.g(this.f51914a, R.dimen.ds250));
        }
        this.j.onChangeSkinType();
        this.j.attachView(this.f51922i, z);
    }

    public void H(boolean z) {
        if (m()) {
            return;
        }
        if (this.k == null) {
            h hVar = new h(this.f51914a, this.m);
            this.k = hVar;
            hVar.j(l.g(this.f51914a, R.dimen.ds250));
        }
        this.k.attachView(this.f51922i, z);
        this.k.o();
    }

    public void I() {
        g();
        i();
        H(true);
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.s(8);
        }
    }

    public void J() {
        g();
        h();
        i();
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.f();
            this.f51921h.s(0);
        }
    }

    public void a(int i2) {
        ForumHeaderView forumHeaderView = this.f51917d;
        if (forumHeaderView != null) {
            forumHeaderView.b();
        }
        NavigationBar navigationBar = this.f51918e;
        if (navigationBar != null && this.f51914a != null) {
            navigationBar.onChangeSkinType(this.n, i2);
        }
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.m(i2);
        }
        g gVar = this.j;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.k;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        NoDataView noDataView = this.l;
        if (noDataView != null && this.f51914a != null) {
            noDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.l.f(this.n, i2);
        }
        SkinManager.setViewTextColor(this.f51919f, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f51915b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f51916c, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.f51918e, R.color.CAM_X0207, i2);
    }

    public void b() {
        this.f51918e.setVisibility(8);
        this.f51917d.setVisibility(8);
        this.f51916c.setVisibility(8);
        ((LinearLayout.LayoutParams) this.f51922i.getLayoutParams()).bottomMargin = l.g(this.n.getPageActivity(), R.dimen.tbds22);
    }

    public Pair<Integer, Integer> c() {
        d.a.k0.a3.k.b bVar = this.f51921h;
        return bVar != null ? bVar.c() : new Pair<>(0, 0);
    }

    public View d() {
        return this.f51915b;
    }

    public String e() {
        return this.f51921h.d();
    }

    public void f() {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.dettachView(this.f51922i);
            this.j = null;
        }
    }

    public void h() {
        h hVar = this.k;
        if (hVar != null) {
            hVar.dettachView(this.f51922i);
            this.k = null;
        }
    }

    public void i() {
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void j() {
        MessageManager.getInstance().registerListener(this.o);
    }

    public final void k() {
        NavigationBar navigationBar = (NavigationBar) this.f51915b.findViewById(R.id.navigation_bar);
        this.f51918e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f51918e.setCenterTextTitle(this.f51914a.getString(R.string.forum_square));
        View addCustomView = this.f51918e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.f51920g = addCustomView;
        TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.f51919f = textView;
        textView.setText(this.f51914a.getString(R.string.forum_square_create_bar));
        this.f51916c = (RelativeLayout) this.f51915b.findViewById(R.id.forum_header_serch_container);
        ForumHeaderView forumHeaderView = (ForumHeaderView) this.f51915b.findViewById(R.id.forum_header_serch_view);
        this.f51917d = forumHeaderView;
        forumHeaderView.setFrom(1);
        this.f51917d.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.f51921h = new d.a.k0.a3.k.b(this.n, this.f51915b);
        this.f51922i = (RelativeLayout) this.f51915b.findViewById(R.id.layout_container);
        a(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean l() {
        g gVar = this.j;
        if (gVar != null) {
            return gVar.isViewAttached();
        }
        return false;
    }

    public final boolean m() {
        h hVar = this.k;
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public void n() {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void o() {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.k();
        }
    }

    public void p() {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.l();
        }
    }

    public void q(int i2, int i3) {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.n(i2, i3);
        }
    }

    public void r(String str, List<String> list, boolean z) {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.o(str, list, z);
        }
    }

    public void s(List<n> list) {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.p(list);
        }
    }

    public void t(List<n> list, int i2) {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.q(list, i2);
        }
    }

    public void u() {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.r();
        }
    }

    public void v(View.OnClickListener onClickListener) {
        TextView textView = this.f51919f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void w(LeftAdapter.b bVar) {
        d.a.k0.a3.k.b bVar2 = this.f51921h;
        if (bVar2 != null) {
            bVar2.t(bVar);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.u(onScrollListener);
        }
    }

    public void z(BdListView.p pVar) {
        d.a.k0.a3.k.b bVar = this.f51921h;
        if (bVar != null) {
            bVar.v(pVar);
        }
    }
}
