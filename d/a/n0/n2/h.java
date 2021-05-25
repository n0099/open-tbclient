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
    public Context f57704a;

    /* renamed from: b  reason: collision with root package name */
    public View f57705b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f57706c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.d0.h f57708e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f57709f;

    /* renamed from: g  reason: collision with root package name */
    public d f57710g;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f57707d = null;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f57711h = new a();

    /* renamed from: i  reason: collision with root package name */
    public AbsListView.OnScrollListener f57712i = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.A()) {
                if (h.this.f57708e != null) {
                    h.this.f57708e.dettachView(h.this.f57705b);
                    h.this.f57708e = null;
                }
                if (h.this.f57710g != null) {
                    h.this.f57710g.onNoNetRefresh();
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
                h.this.f57709f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1) {
                h.this.f57709f.c();
            }
        }
    }

    public h(Context context, View view) {
        this.f57704a = context;
        this.f57705b = view;
        this.f57706c = (BdTypeListView) view.findViewById(R.id.list);
        this.f57709f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f57706c.setOnScrollListener(this.f57712i);
    }

    public BdTypeListView f() {
        return this.f57706c;
    }

    public d g() {
        return this.f57710g;
    }

    public void h(d dVar) {
        this.f57710g = dVar;
    }

    public void i(String str, boolean z) {
        f.b(this.f57708e, this.f57711h, this.f57704a, this.f57705b, str, z);
        this.f57706c.setVisibility(8);
    }
}
