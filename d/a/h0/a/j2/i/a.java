package d.a.h0.a.j2.i;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import d.a.h0.a.f;
import d.a.h0.a.k;
import d.a.h0.a.p.d.c;
/* loaded from: classes3.dex */
public class a<T extends d.a.h0.a.p.d.c> implements d.a.h0.a.e0.n.c, d.a.h0.a.j2.f.a, PullToRefreshBaseWebView.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f43091g = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f43092a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f43093b;

    /* renamed from: c  reason: collision with root package name */
    public T f43094c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f43095d;

    /* renamed from: e  reason: collision with root package name */
    public Context f43096e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.a.p.d.b f43097f;

    public a(Context context, @NonNull d.a.h0.a.p.d.b<T> bVar, @NonNull FrameLayout frameLayout) {
        this.f43096e = context;
        this.f43092a = frameLayout;
        this.f43097f = bVar;
        e(bVar);
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void a(int i2, int i3, int i4, int i5) {
        this.f43093b.scrollTo(i2, i3);
    }

    @Override // d.a.h0.a.j2.f.a
    public boolean b(View view, d.a.h0.a.e1.d.a.a aVar) {
        if (view == null || this.f43093b == null || aVar == null) {
            return false;
        }
        if (f43091g) {
            Log.d("NAParentViewManager", "updateView pos: " + aVar);
        }
        if (d(view, this.f43093b)) {
            Object tag = view.getTag(f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar = (b) tag;
                c.a(bVar, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar);
            }
            this.f43093b.updateViewLayout(view, c.b(this.f43094c, aVar));
        } else if (!g(view)) {
            return false;
        } else {
            Object tag2 = view.getTag(f.aiapps_na_root_view_tag);
            if (tag2 instanceof b) {
                b bVar2 = (b) tag2;
                c.a(bVar2, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar2);
            }
            ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f43094c, aVar));
        }
        return true;
    }

    @Override // d.a.h0.a.j2.f.a
    public boolean c(View view, d.a.h0.a.e1.d.a.a aVar) {
        if (this.f43096e != null && aVar != null) {
            b bVar = new b();
            c.a(bVar, aVar);
            view.setTag(f.aiapps_na_root_view_tag, bVar);
            if (this.f43093b.indexOfChild(view) >= 0) {
                d.a.h0.a.a0.g.a.a("NAParentViewManager", "repeat insert view!");
                this.f43093b.removeView(view);
            }
            this.f43093b.addView(view, c.b(this.f43094c, aVar));
            return true;
        } else if (f43091g) {
            Log.d("NAParentViewManager", "insertView failed");
            return false;
        } else {
            return false;
        }
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    public final boolean e(d.a.h0.a.p.d.b<T> bVar) {
        if (f43091g) {
            Log.d("NAParentViewManager", "createViewAndListener");
        }
        bVar.t(this);
        T s = bVar.s();
        this.f43094c = s;
        if (s == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f43096e);
        this.f43092a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.f43093b = new FrameLayout(this.f43096e);
        swanAppNARootViewScrollView.addView(this.f43093b, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        PullToRefreshBaseWebView f0 = bVar.f0();
        this.f43095d = f0;
        if (f0 != null) {
            f0.setOnPullToRefreshScrollChangeListener(this);
        }
        return true;
    }

    public void f() {
        this.f43097f.S(this);
    }

    public final boolean g(View view) {
        if (view == null) {
            return false;
        }
        return view.getParent() instanceof SwanAppInlineFullScreenContainer;
    }

    public void h(int i2) {
        this.f43093b.setVisibility(i2);
    }

    @Override // d.a.h0.a.e0.n.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f43093b.getLayoutParams();
        marginLayoutParams.leftMargin = -i2;
        marginLayoutParams.topMargin = -i3;
        this.f43093b.setLayoutParams(marginLayoutParams);
        for (int i6 = 0; i6 < this.f43093b.getChildCount(); i6++) {
            View childAt = this.f43093b.getChildAt(i6);
            if (childAt != null) {
                Object tag = childAt.getTag(f.aiapps_na_root_view_tag);
                b bVar = tag instanceof b ? (b) tag : null;
                if (bVar != null && bVar.d()) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    marginLayoutParams2.leftMargin = bVar.b() + i2;
                    marginLayoutParams2.topMargin = bVar.c() + i3;
                    childAt.setLayoutParams(marginLayoutParams2);
                }
            }
        }
    }

    @Override // d.a.h0.a.j2.f.a
    public boolean removeView(View view) {
        if (d(view, this.f43093b)) {
            try {
                this.f43093b.removeView(view);
            } catch (Exception e2) {
                if (f43091g) {
                    e2.printStackTrace();
                }
            }
            return true;
        } else if (g(view)) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Exception e3) {
                if (f43091g) {
                    e3.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
