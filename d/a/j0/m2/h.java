package d.a.j0.m2;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Context f56817a;

    /* renamed from: b  reason: collision with root package name */
    public View f56818b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f56819c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.d0.h f56821e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f56822f;

    /* renamed from: g  reason: collision with root package name */
    public d f56823g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f56820d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56824h = new a();

    /* renamed from: i  reason: collision with root package name */
    public AbsListView.OnScrollListener f56825i = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.A()) {
                if (h.this.f56821e != null) {
                    h.this.f56821e.dettachView(h.this.f56818b);
                    h.this.f56821e = null;
                }
                if (h.this.f56823g != null) {
                    h.this.f56823g.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            if (i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.f56822f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                h.this.f56822f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f56817a = context;
        this.f56818b = view;
        this.f56819c = (BdTypeListView) view.findViewById(R.id.list);
        this.f56822f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f56819c.setOnScrollListener(this.f56825i);
    }

    public BdTypeListView f() {
        return this.f56819c;
    }

    public d g() {
        return this.f56823g;
    }

    public void h(d dVar) {
        this.f56823g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f56821e, this.f56824h, this.f56817a, this.f56818b, str, z);
        this.f56819c.setVisibility(8);
    }
}
