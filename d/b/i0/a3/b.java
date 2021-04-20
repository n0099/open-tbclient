package d.b.i0.a3;

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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f53064a;

    /* renamed from: b  reason: collision with root package name */
    public View f53065b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f53066c;

    /* renamed from: d  reason: collision with root package name */
    public ForumHeaderView f53067d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f53068e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53069f;

    /* renamed from: g  reason: collision with root package name */
    public View f53070g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.a3.k.b f53071h;
    public RelativeLayout i;
    public g j;
    public h k;
    public NoDataView l;
    public View.OnClickListener m;
    public final TbPageContext n;
    public CustomMessageListener o = new a(2001304);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
        this.f53064a = context;
        this.n = tbPageContext;
        this.f53065b = LayoutInflater.from(context).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        k();
        j();
    }

    public void A(String str) {
        ForumHeaderView forumHeaderView = this.f53067d;
        if (forumHeaderView != null) {
            forumHeaderView.setSearchHint(str);
        }
    }

    public void B(String str) {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.x(str);
        }
    }

    public void C(boolean z) {
        this.f53070g.setVisibility(z ? 0 : 8);
    }

    public void D() {
        g();
        h();
        i();
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.y(true);
            this.f53071h.w(8);
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
            g gVar = new g(this.f53064a);
            this.j = gVar;
            gVar.q(l.g(this.f53064a, R.dimen.ds250));
        }
        this.j.onChangeSkinType();
        this.j.attachView(this.i, z);
    }

    public void H(boolean z) {
        if (m()) {
            return;
        }
        if (this.k == null) {
            h hVar = new h(this.f53064a, this.m);
            this.k = hVar;
            hVar.j(l.g(this.f53064a, R.dimen.ds250));
        }
        this.k.attachView(this.i, z);
        this.k.o();
    }

    public void I() {
        g();
        i();
        H(true);
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.s(8);
        }
    }

    public void J() {
        g();
        h();
        i();
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.f();
            this.f53071h.s(0);
        }
    }

    public void a(int i) {
        ForumHeaderView forumHeaderView = this.f53067d;
        if (forumHeaderView != null) {
            forumHeaderView.b();
        }
        NavigationBar navigationBar = this.f53068e;
        if (navigationBar != null && this.f53064a != null) {
            navigationBar.onChangeSkinType(this.n, i);
        }
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.m(i);
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
        if (noDataView != null && this.f53064a != null) {
            noDataView.setSubTitleTextColor(R.color.CAM_X0105);
            this.l.f(this.n, i);
        }
        SkinManager.setViewTextColor(this.f53069f, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f53065b, R.color.CAM_X0205);
        SkinManager.setBackgroundColor(this.f53066c, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.f53068e, R.color.CAM_X0207, i);
    }

    public void b() {
        this.f53068e.setVisibility(8);
        this.f53067d.setVisibility(8);
        this.f53066c.setVisibility(8);
        ((LinearLayout.LayoutParams) this.i.getLayoutParams()).bottomMargin = l.g(this.n.getPageActivity(), R.dimen.tbds22);
    }

    public Pair<Integer, Integer> c() {
        d.b.i0.a3.k.b bVar = this.f53071h;
        return bVar != null ? bVar.c() : new Pair<>(0, 0);
    }

    public View d() {
        return this.f53065b;
    }

    public String e() {
        return this.f53071h.d();
    }

    public void f() {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.dettachView(this.i);
            this.j = null;
        }
    }

    public void h() {
        h hVar = this.k;
        if (hVar != null) {
            hVar.dettachView(this.i);
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
        NavigationBar navigationBar = (NavigationBar) this.f53065b.findViewById(R.id.navigation_bar);
        this.f53068e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53068e.setCenterTextTitle(this.f53064a.getString(R.string.forum_square));
        View addCustomView = this.f53068e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.f53070g = addCustomView;
        TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
        this.f53069f = textView;
        textView.setText(this.f53064a.getString(R.string.forum_square_create_bar));
        this.f53066c = (RelativeLayout) this.f53065b.findViewById(R.id.forum_header_serch_container);
        ForumHeaderView forumHeaderView = (ForumHeaderView) this.f53065b.findViewById(R.id.forum_header_serch_view);
        this.f53067d = forumHeaderView;
        forumHeaderView.setFrom(1);
        this.f53067d.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.f53071h = new d.b.i0.a3.k.b(this.n, this.f53065b);
        this.i = (RelativeLayout) this.f53065b.findViewById(R.id.layout_container);
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
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void o() {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.k();
        }
    }

    public void p() {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.l();
        }
    }

    public void q(int i, int i2) {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.n(i, i2);
        }
    }

    public void r(String str, List<String> list, boolean z) {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.o(str, list, z);
        }
    }

    public void s(List<n> list) {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.p(list);
        }
    }

    public void t(List<n> list, int i) {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.q(list, i);
        }
    }

    public void u() {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.r();
        }
    }

    public void v(View.OnClickListener onClickListener) {
        TextView textView = this.f53069f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void w(LeftAdapter.b bVar) {
        d.b.i0.a3.k.b bVar2 = this.f53071h;
        if (bVar2 != null) {
            bVar2.t(bVar);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void y(RecyclerView.OnScrollListener onScrollListener) {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.u(onScrollListener);
        }
    }

    public void z(BdListView.p pVar) {
        d.b.i0.a3.k.b bVar = this.f53071h;
        if (bVar != null) {
            bVar.v(pVar);
        }
    }
}
