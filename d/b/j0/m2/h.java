package d.b.j0.m2;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f58803a;

    /* renamed from: b  reason: collision with root package name */
    public View f58804b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f58805c;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.d0.h f58807e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f58808f;

    /* renamed from: g  reason: collision with root package name */
    public d f58809g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f58806d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f58810h = new a();
    public AbsListView.OnScrollListener i = new b();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.c.e.p.j.A()) {
                if (h.this.f58807e != null) {
                    h.this.f58807e.dettachView(h.this.f58804b);
                    h.this.f58807e = null;
                }
                if (h.this.f58809g != null) {
                    h.this.f58809g.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.f58808f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.f58808f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f58803a = context;
        this.f58804b = view;
        this.f58805c = (BdTypeListView) view.findViewById(R.id.list);
        this.f58808f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f58805c.setOnScrollListener(this.i);
    }

    public BdTypeListView f() {
        return this.f58805c;
    }

    public d g() {
        return this.f58809g;
    }

    public void h(d dVar) {
        this.f58809g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f58807e, this.f58810h, this.f58803a, this.f58804b, str, z);
        this.f58805c.setVisibility(8);
    }
}
