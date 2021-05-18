package d.a.k0.m2;

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
    public Context f57524a;

    /* renamed from: b  reason: collision with root package name */
    public View f57525b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f57526c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.d0.h f57528e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f57529f;

    /* renamed from: g  reason: collision with root package name */
    public d f57530g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f57527d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f57531h = new a();

    /* renamed from: i  reason: collision with root package name */
    public AbsListView.OnScrollListener f57532i = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.A()) {
                if (h.this.f57528e != null) {
                    h.this.f57528e.dettachView(h.this.f57525b);
                    h.this.f57528e = null;
                }
                if (h.this.f57530g != null) {
                    h.this.f57530g.onNoNetRefresh();
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
                h.this.f57529f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                h.this.f57529f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f57524a = context;
        this.f57525b = view;
        this.f57526c = (BdTypeListView) view.findViewById(R.id.list);
        this.f57529f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f57526c.setOnScrollListener(this.f57532i);
    }

    public BdTypeListView f() {
        return this.f57526c;
    }

    public d g() {
        return this.f57530g;
    }

    public void h(d dVar) {
        this.f57530g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f57528e, this.f57531h, this.f57524a, this.f57525b, str, z);
        this.f57526c.setVisibility(8);
    }
}
