package d.a.o0.n2;

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
    public Context f61518a;

    /* renamed from: b  reason: collision with root package name */
    public View f61519b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f61520c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.d0.h f61522e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f61523f;

    /* renamed from: g  reason: collision with root package name */
    public d f61524g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f61521d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f61525h = new a();

    /* renamed from: i  reason: collision with root package name */
    public AbsListView.OnScrollListener f61526i = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.A()) {
                if (h.this.f61522e != null) {
                    h.this.f61522e.dettachView(h.this.f61519b);
                    h.this.f61522e = null;
                }
                if (h.this.f61524g != null) {
                    h.this.f61524g.onNoNetRefresh();
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
                h.this.f61523f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                h.this.f61523f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f61518a = context;
        this.f61519b = view;
        this.f61520c = (BdTypeListView) view.findViewById(R.id.list);
        this.f61523f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f61520c.setOnScrollListener(this.f61526i);
    }

    public BdTypeListView f() {
        return this.f61520c;
    }

    public d g() {
        return this.f61524g;
    }

    public void h(d dVar) {
        this.f61524g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f61522e, this.f61525h, this.f61518a, this.f61519b, str, z);
        this.f61520c.setVisibility(8);
    }
}
