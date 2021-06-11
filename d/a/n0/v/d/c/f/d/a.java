package d.a.n0.v.d.c.f.d;

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
import d.a.c.k.e.n;
import d.a.m0.r.f0.f;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65261a;

    /* renamed from: b  reason: collision with root package name */
    public View f65262b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f65263c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f65264d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f65265e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f65266f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.g f65267g;

    /* renamed from: h  reason: collision with root package name */
    public View f65268h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.v.d.c.f.a.a f65269i;
    public f j;
    public AlphaAnimation k;
    public AlphaAnimation l;
    public RecyclerView.OnScrollListener m = new e();

    /* renamed from: d.a.n0.v.d.c.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1702a implements BdListView.p {
        public C1702a() {
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

        @Override // d.a.m0.r.f0.f.g
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
            if (a.this.f65261a == null || a.this.f65261a.getPageActivity() == null) {
                return;
            }
            a.this.f65261a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f65268h.setVisibility(8);
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
        public int f65274a = -1;

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (this.f65274a == i2) {
                return;
            }
            this.f65274a = i2;
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
        this.f65261a = tbPageContext;
        this.f65262b = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
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
            this.f65268h.startAnimation(this.l);
        }
    }

    public RelativeLayout f() {
        return this.f65264d;
    }

    public View g() {
        return this.f65264d;
    }

    public View h() {
        return this.f65262b;
    }

    public final void i() {
        NavigationBar navigationBar = (NavigationBar) this.f65262b.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
        this.f65263c = navigationBar;
        navigationBar.setCenterTextTitle(this.f65261a.getResources().getString(R.string.live_tab_my_concern));
        this.f65263c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
    }

    public final void j() {
        i();
        this.f65264d = (RelativeLayout) this.f65262b.findViewById(R.id.ala_live_tab_my_concern_container);
        this.f65268h = this.f65262b.findViewById(R.id.divider_shadow);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f65262b.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.f65265e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f65261a.getPageActivity()));
        this.f65265e.setFadingEdgeLength(0);
        this.f65265e.setOverScrollMode(2);
        this.f65265e.addOnScrollListener(this.m);
        this.f65265e.setOnSrollToBottomListener(new C1702a());
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f65261a);
        this.f65267g = gVar;
        gVar.a(new b());
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f65262b.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.f65266f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f65267g);
        d.a.n0.v.d.c.f.a.a aVar = new d.a.n0.v.d.c.f.a.a(this.f65261a);
        this.f65269i = aVar;
        this.f65265e.a(aVar.a());
    }

    public final boolean k() {
        return this.f65268h.getVisibility() == 0;
    }

    public void l(int i2) {
        NavigationBar navigationBar = this.f65263c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f65261a, i2);
        }
        SkinManager.setBackgroundColor(this.f65262b, R.color.CAM_X0201);
        d.a.m0.r.f0.g gVar = this.f65267g;
        if (gVar != null) {
            gVar.I(i2);
        }
        SkinManager.setBackgroundColor(this.f65266f, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f65265e, R.color.CAM_X0201);
    }

    public void m() {
        this.f65265e.removeOnScrollListener(this.m);
        this.f65265e.setOnSrollToBottomListener(null);
        this.f65265e.setScrollable(null);
        d.a.m0.r.f0.g gVar = this.f65267g;
        if (gVar != null) {
            gVar.a(null);
            this.f65267g.X();
        }
    }

    public final boolean n(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void o(Class<? extends BaseCardInfo> cls) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f65265e;
        if (bdTypeRecyclerView != null) {
            for (int count = bdTypeRecyclerView.getCount() - 1; count >= 0; count--) {
                n B = this.f65265e.B(count);
                if (B != null && B.getClass().equals(cls)) {
                    this.f65265e.D(count);
                }
            }
        }
    }

    public void p(List<n> list) {
        this.f65265e.setData(list);
    }

    public void q(boolean z) {
        if (z) {
            return;
        }
        this.f65266f.setRefreshing(false);
    }

    public void r(f fVar) {
        this.j = fVar;
    }

    public void s() {
        if (k()) {
            return;
        }
        this.f65268h.setVisibility(0);
        if (this.k == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.k = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.k.setDuration(300L);
        }
        this.f65268h.startAnimation(this.k);
    }
}
