package d.b.j0.t.d.c.f.d;

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
import d.b.i0.r.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62357a;

    /* renamed from: b  reason: collision with root package name */
    public View f62358b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62359c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f62360d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f62361e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f62362f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.f0.g f62363g;

    /* renamed from: h  reason: collision with root package name */
    public View f62364h;
    public d.b.j0.t.d.c.f.a.a i;
    public f j;
    public AlphaAnimation k;
    public AlphaAnimation l;
    public RecyclerView.OnScrollListener m = new e();

    /* renamed from: d.b.j0.t.d.c.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1620a implements BdListView.p {
        public C1620a() {
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

        @Override // d.b.i0.r.f0.f.g
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
            if (a.this.f62357a == null || a.this.f62357a.getPageActivity() == null) {
                return;
            }
            a.this.f62357a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f62364h.setVisibility(8);
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
        public int f62369a = -1;

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.f62369a == i) {
                return;
            }
            this.f62369a = i;
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
        this.f62357a = tbPageContext;
        this.f62358b = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
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
            this.f62364h.startAnimation(this.l);
        }
    }

    public RelativeLayout f() {
        return this.f62360d;
    }

    public View g() {
        return this.f62360d;
    }

    public View h() {
        return this.f62358b;
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f62358b.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
        this.f62359c = navigationBar;
        navigationBar.setCenterTextTitle(this.f62357a.getResources().getString(R.string.live_tab_my_concern));
        this.f62359c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
    }

    public final void j() {
        i();
        this.f62360d = (RelativeLayout) this.f62358b.findViewById(R.id.ala_live_tab_my_concern_container);
        this.f62364h = this.f62358b.findViewById(R.id.divider_shadow);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f62358b.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.f62361e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f62357a.getPageActivity()));
        this.f62361e.setFadingEdgeLength(0);
        this.f62361e.setOverScrollMode(2);
        this.f62361e.addOnScrollListener(this.m);
        this.f62361e.setOnSrollToBottomListener(new C1620a());
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(this.f62357a);
        this.f62363g = gVar;
        gVar.b(new b());
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f62358b.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.f62362f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f62363g);
        d.b.j0.t.d.c.f.a.a aVar = new d.b.j0.t.d.c.f.a.a(this.f62357a);
        this.i = aVar;
        this.f62361e.a(aVar.a());
    }

    public final boolean k() {
        return this.f62364h.getVisibility() == 0;
    }

    public void l(int i) {
        NavigationBar navigationBar = this.f62359c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f62357a, i);
        }
        SkinManager.setBackgroundColor(this.f62358b, R.color.CAM_X0201);
        d.b.i0.r.f0.g gVar = this.f62363g;
        if (gVar != null) {
            gVar.I(i);
        }
        SkinManager.setBackgroundColor(this.f62362f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f62361e, R.color.CAM_X0201);
    }

    public void m() {
        this.f62361e.removeOnScrollListener(this.m);
        this.f62361e.setOnSrollToBottomListener(null);
        this.f62361e.setScrollable(null);
        d.b.i0.r.f0.g gVar = this.f62363g;
        if (gVar != null) {
            gVar.b(null);
            this.f62363g.X();
        }
    }

    public final boolean n(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void o(Class<? extends BaseCardInfo> cls) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f62361e;
        if (bdTypeRecyclerView != null) {
            for (int count = bdTypeRecyclerView.getCount() - 1; count >= 0; count--) {
                n B = this.f62361e.B(count);
                if (B != null && B.getClass().equals(cls)) {
                    this.f62361e.D(count);
                }
            }
        }
    }

    public void p(List<n> list) {
        this.f62361e.setData(list);
    }

    public void q(boolean z) {
        if (z) {
            return;
        }
        this.f62362f.setRefreshing(false);
    }

    public void r(f fVar) {
        this.j = fVar;
    }

    public void s() {
        if (k()) {
            return;
        }
        this.f62364h.setVisibility(0);
        if (this.k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.k.setDuration(300L);
        }
        this.f62364h.startAnimation(this.k);
    }
}
