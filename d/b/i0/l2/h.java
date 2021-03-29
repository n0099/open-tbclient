package d.b.i0.l2;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f56753a;

    /* renamed from: b  reason: collision with root package name */
    public View f56754b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f56755c;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.d0.h f56757e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f56758f;

    /* renamed from: g  reason: collision with root package name */
    public d f56759g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f56756d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56760h = new a();
    public AbsListView.OnScrollListener i = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.b.e.p.j.A()) {
                if (h.this.f56757e != null) {
                    h.this.f56757e.dettachView(h.this.f56754b);
                    h.this.f56757e = null;
                }
                if (h.this.f56759g != null) {
                    h.this.f56759g.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.f56758f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.f56758f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f56753a = context;
        this.f56754b = view;
        this.f56755c = (BdTypeListView) view.findViewById(R.id.list);
        this.f56758f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f56755c.setOnScrollListener(this.i);
    }

    public BdTypeListView f() {
        return this.f56755c;
    }

    public d g() {
        return this.f56759g;
    }

    public void h(d dVar) {
        this.f56759g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f56757e, this.f56760h, this.f56753a, this.f56754b, str, z);
        this.f56755c.setVisibility(8);
    }
}
