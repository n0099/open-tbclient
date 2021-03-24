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
    public Context f56752a;

    /* renamed from: b  reason: collision with root package name */
    public View f56753b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f56754c;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.d0.h f56756e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f56757f;

    /* renamed from: g  reason: collision with root package name */
    public d f56758g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f56755d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56759h = new a();
    public AbsListView.OnScrollListener i = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.b.e.p.j.A()) {
                if (h.this.f56756e != null) {
                    h.this.f56756e.dettachView(h.this.f56753b);
                    h.this.f56756e = null;
                }
                if (h.this.f56758g != null) {
                    h.this.f56758g.onNoNetRefresh();
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
                h.this.f56757f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.f56757f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f56752a = context;
        this.f56753b = view;
        this.f56754c = (BdTypeListView) view.findViewById(R.id.list);
        this.f56757f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f56754c.setOnScrollListener(this.i);
    }

    public BdTypeListView f() {
        return this.f56754c;
    }

    public d g() {
        return this.f56758g;
    }

    public void h(d dVar) {
        this.f56758g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f56756e, this.f56759h, this.f56752a, this.f56753b, str, z);
        this.f56754c.setVisibility(8);
    }
}
