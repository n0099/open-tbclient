package d.b.i0.t.d.c.f.d;

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
import d.b.c.j.e.n;
import d.b.h0.r.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61936a;

    /* renamed from: b  reason: collision with root package name */
    public View f61937b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61938c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61939d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f61940e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f61941f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f61942g;

    /* renamed from: h  reason: collision with root package name */
    public View f61943h;
    public d.b.i0.t.d.c.f.a.a i;
    public f j;
    public AlphaAnimation k;
    public AlphaAnimation l;
    public RecyclerView.OnScrollListener m = new e();

    /* renamed from: d.b.i0.t.d.c.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1597a implements BdListView.p {
        public C1597a() {
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

        @Override // d.b.h0.r.f0.f.g
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
            if (a.this.f61936a == null || a.this.f61936a.getPageActivity() == null) {
                return;
            }
            a.this.f61936a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f61943h.setVisibility(8);
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
        public int f61948a = -1;

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.f61948a == i) {
                return;
            }
            this.f61948a = i;
            if (i != 1) {
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
        this.f61936a = tbPageContext;
        this.f61937b = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
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
            this.f61943h.startAnimation(this.l);
        }
    }

    public RelativeLayout f() {
        return this.f61939d;
    }

    public View g() {
        return this.f61939d;
    }

    public View h() {
        return this.f61937b;
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f61937b.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
        this.f61938c = navigationBar;
        navigationBar.setCenterTextTitle(this.f61936a.getResources().getString(R.string.live_tab_my_concern));
        this.f61938c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
    }

    public final void j() {
        i();
        this.f61939d = (RelativeLayout) this.f61937b.findViewById(R.id.ala_live_tab_my_concern_container);
        this.f61943h = this.f61937b.findViewById(R.id.divider_shadow);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f61937b.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.f61940e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f61936a.getPageActivity()));
        this.f61940e.setFadingEdgeLength(0);
        this.f61940e.setOverScrollMode(2);
        this.f61940e.addOnScrollListener(this.m);
        this.f61940e.setOnSrollToBottomListener(new C1597a());
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f61936a);
        this.f61942g = gVar;
        gVar.b(new b());
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f61937b.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.f61941f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f61942g);
        d.b.i0.t.d.c.f.a.a aVar = new d.b.i0.t.d.c.f.a.a(this.f61936a);
        this.i = aVar;
        this.f61940e.a(aVar.a());
    }

    public final boolean k() {
        return this.f61943h.getVisibility() == 0;
    }

    public void l(int i) {
        NavigationBar navigationBar = this.f61938c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f61936a, i);
        }
        SkinManager.setBackgroundColor(this.f61937b, R.color.CAM_X0201);
        d.b.h0.r.f0.g gVar = this.f61942g;
        if (gVar != null) {
            gVar.I(i);
        }
        SkinManager.setBackgroundColor(this.f61941f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f61940e, R.color.CAM_X0201);
    }

    public void m() {
        this.f61940e.removeOnScrollListener(this.m);
        this.f61940e.setOnSrollToBottomListener(null);
        this.f61940e.setScrollable(null);
        d.b.h0.r.f0.g gVar = this.f61942g;
        if (gVar != null) {
            gVar.b(null);
            this.f61942g.X();
        }
    }

    public final boolean n(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void o(Class<? extends BaseCardInfo> cls) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f61940e;
        if (bdTypeRecyclerView != null) {
            for (int count = bdTypeRecyclerView.getCount() - 1; count >= 0; count--) {
                n B = this.f61940e.B(count);
                if (B != null && B.getClass().equals(cls)) {
                    this.f61940e.D(count);
                }
            }
        }
    }

    public void p(List<n> list) {
        this.f61940e.setData(list);
    }

    public void q(boolean z) {
        if (z) {
            return;
        }
        this.f61941f.setRefreshing(false);
    }

    public void r(f fVar) {
        this.j = fVar;
    }

    public void s() {
        if (k()) {
            return;
        }
        this.f61943h.setVisibility(0);
        if (this.k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.k.setDuration(300L);
        }
        this.f61943h.startAnimation(this.k);
    }
}
