package d.a.j0.t.d.c.f.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.i0.r.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60536a;

    /* renamed from: b  reason: collision with root package name */
    public View f60537b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60538c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f60539d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f60540e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f60541f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.f0.g f60542g;

    /* renamed from: h  reason: collision with root package name */
    public View f60543h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.t.d.c.f.a.a f60544i;
    public f j;
    public AlphaAnimation k;
    public AlphaAnimation l;
    public RecyclerView.OnScrollListener m = new e();

    /* renamed from: d.a.j0.t.d.c.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1560a implements BdListView.p {
        public C1560a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.j != null) {
                a.this.j.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (a.this.j != null) {
                a.this.j.onListPullRefresh(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f60536a == null || a.this.f60536a.getPageActivity() == null) {
                return;
            }
            a.this.f60536a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f60543h.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public int f60549a = -1;

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (this.f60549a == i2) {
                return;
            }
            this.f60549a = i2;
            if (i2 != 1) {
                if (a.this.n(recyclerView)) {
                    a.this.e();
                    return;
                } else {
                    a.this.s();
                    return;
                }
            }
            a.this.s();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.f60536a = tbPageContext;
        this.f60537b = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        j();
    }

    public void e() {
        if (k()) {
            if (this.l == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.l = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.l.setDuration(300L);
                this.l.setAnimationListener(new d());
            }
            this.f60543h.startAnimation(this.l);
        }
    }

    public RelativeLayout f() {
        return this.f60539d;
    }

    public View g() {
        return this.f60539d;
    }

    public View h() {
        return this.f60537b;
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f60537b.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
        this.f60538c = navigationBar;
        navigationBar.setCenterTextTitle(this.f60536a.getResources().getString(R.string.live_tab_my_concern));
        this.f60538c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
    }

    public final void j() {
        i();
        this.f60539d = (RelativeLayout) this.f60537b.findViewById(R.id.ala_live_tab_my_concern_container);
        this.f60543h = this.f60537b.findViewById(R.id.divider_shadow);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f60537b.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.f60540e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f60536a.getPageActivity()));
        this.f60540e.setFadingEdgeLength(0);
        this.f60540e.setOverScrollMode(2);
        this.f60540e.addOnScrollListener(this.m);
        this.f60540e.setOnSrollToBottomListener(new C1560a());
        d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(this.f60536a);
        this.f60542g = gVar;
        gVar.a(new b());
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f60537b.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.f60541f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f60542g);
        d.a.j0.t.d.c.f.a.a aVar = new d.a.j0.t.d.c.f.a.a(this.f60536a);
        this.f60544i = aVar;
        this.f60540e.a(aVar.a());
    }

    public final boolean k() {
        return this.f60543h.getVisibility() == 0;
    }

    public void l(int i2) {
        NavigationBar navigationBar = this.f60538c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60536a, i2);
        }
        SkinManager.setBackgroundColor(this.f60537b, R.color.CAM_X0201);
        d.a.i0.r.f0.g gVar = this.f60542g;
        if (gVar != null) {
            gVar.I(i2);
        }
        SkinManager.setBackgroundColor(this.f60541f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f60540e, R.color.CAM_X0201);
    }

    public void m() {
        this.f60540e.removeOnScrollListener(this.m);
        this.f60540e.setOnSrollToBottomListener(null);
        this.f60540e.setScrollable(null);
        d.a.i0.r.f0.g gVar = this.f60542g;
        if (gVar != null) {
            gVar.a(null);
            this.f60542g.X();
        }
    }

    public final boolean n(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void o(Class<? extends BaseCardInfo> cls) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f60540e;
        if (bdTypeRecyclerView != null) {
            for (int count = bdTypeRecyclerView.getCount() - 1; count >= 0; count--) {
                n B = this.f60540e.B(count);
                if (B != null && B.getClass().equals(cls)) {
                    this.f60540e.D(count);
                }
            }
        }
    }

    public void p(List<n> list) {
        this.f60540e.setData(list);
    }

    public void q(boolean z) {
        if (z) {
            return;
        }
        this.f60541f.setRefreshing(false);
    }

    public void r(f fVar) {
        this.j = fVar;
    }

    public void s() {
        if (k()) {
            return;
        }
        this.f60543h.setVisibility(0);
        if (this.k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.k.setDuration(300L);
        }
        this.f60543h.startAnimation(this.k);
    }
}
