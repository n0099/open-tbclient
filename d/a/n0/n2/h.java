package d.a.n0.n2;

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
    public Context f61393a;

    /* renamed from: b  reason: collision with root package name */
    public View f61394b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f61395c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.d0.h f61397e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f61398f;

    /* renamed from: g  reason: collision with root package name */
    public d f61399g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f61396d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f61400h = new a();

    /* renamed from: i  reason: collision with root package name */
    public AbsListView.OnScrollListener f61401i = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.A()) {
                if (h.this.f61397e != null) {
                    h.this.f61397e.dettachView(h.this.f61394b);
                    h.this.f61397e = null;
                }
                if (h.this.f61399g != null) {
                    h.this.f61399g.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            if (i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.f61398f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                h.this.f61398f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f61393a = context;
        this.f61394b = view;
        this.f61395c = (BdTypeListView) view.findViewById(R.id.list);
        this.f61398f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f61395c.setOnScrollListener(this.f61401i);
    }

    public BdTypeListView f() {
        return this.f61395c;
    }

    public d g() {
        return this.f61399g;
    }

    public void h(d dVar) {
        this.f61399g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f61397e, this.f61400h, this.f61393a, this.f61394b, str, z);
        this.f61395c.setVisibility(8);
    }
}
