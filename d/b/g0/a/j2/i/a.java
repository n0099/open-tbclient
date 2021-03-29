package d.b.g0.a.j2.i;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import d.b.g0.a.f;
import d.b.g0.a.k;
import d.b.g0.a.p.d.c;
/* loaded from: classes3.dex */
public class a<T extends d.b.g0.a.p.d.c> implements d.b.g0.a.e0.n.c, d.b.g0.a.j2.f.a, PullToRefreshBaseWebView.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45041g = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f45042a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f45043b;

    /* renamed from: c  reason: collision with root package name */
    public T f45044c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f45045d;

    /* renamed from: e  reason: collision with root package name */
    public Context f45046e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.p.d.b f45047f;

    public a(Context context, @NonNull d.b.g0.a.p.d.b<T> bVar, @NonNull FrameLayout frameLayout) {
        this.f45046e = context;
        this.f45042a = frameLayout;
        this.f45047f = bVar;
        e(bVar);
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void a(int i, int i2, int i3, int i4) {
        this.f45043b.scrollTo(i, i2);
    }

    @Override // d.b.g0.a.j2.f.a
    public boolean b(View view, d.b.g0.a.e1.d.a.a aVar) {
        if (view == null || this.f45043b == null || aVar == null) {
            return false;
        }
        if (f45041g) {
            Log.d("NAParentViewManager", "updateView pos: " + aVar);
        }
        if (d(view, this.f45043b)) {
            Object tag = view.getTag(f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar = (b) tag;
                c.a(bVar, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar);
            }
            this.f45043b.updateViewLayout(view, c.b(this.f45044c, aVar));
        } else if (!g(view)) {
            return false;
        } else {
            Object tag2 = view.getTag(f.aiapps_na_root_view_tag);
            if (tag2 instanceof b) {
                b bVar2 = (b) tag2;
                c.a(bVar2, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar2);
            }
            ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f45044c, aVar));
        }
        return true;
    }

    @Override // d.b.g0.a.j2.f.a
    public boolean c(View view, d.b.g0.a.e1.d.a.a aVar) {
        if (this.f45046e != null && aVar != null) {
            b bVar = new b();
            c.a(bVar, aVar);
            view.setTag(f.aiapps_na_root_view_tag, bVar);
            if (this.f45043b.indexOfChild(view) >= 0) {
                d.b.g0.a.a0.g.a.a("NAParentViewManager", "repeat insert view!");
                this.f45043b.removeView(view);
            }
            this.f45043b.addView(view, c.b(this.f45044c, aVar));
            return true;
        } else if (f45041g) {
            Log.d("NAParentViewManager", "insertView failed");
            return false;
        } else {
            return false;
        }
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    public final boolean e(d.b.g0.a.p.d.b<T> bVar) {
        if (f45041g) {
            Log.d("NAParentViewManager", "createViewAndListener");
        }
        bVar.F(this);
        T webView = bVar.getWebView();
        this.f45044c = webView;
        if (webView == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f45046e);
        this.f45042a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.f45043b = new FrameLayout(this.f45046e);
        swanAppNARootViewScrollView.addView(this.f45043b, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        PullToRefreshBaseWebView Y = bVar.Y();
        this.f45045d = Y;
        if (Y != null) {
            Y.setOnPullToRefreshScrollChangeListener(this);
        }
        return true;
    }

    public void f() {
        this.f45047f.H(this);
    }

    public final boolean g(View view) {
        if (view == null) {
            return false;
        }
        return view.getParent() instanceof SwanAppInlineFullScreenContainer;
    }

    public void h(int i) {
        this.f45043b.setVisibility(i);
    }

    @Override // d.b.g0.a.e0.n.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f45043b.getLayoutParams();
        marginLayoutParams.leftMargin = -i;
        marginLayoutParams.topMargin = -i2;
        this.f45043b.setLayoutParams(marginLayoutParams);
        for (int i5 = 0; i5 < this.f45043b.getChildCount(); i5++) {
            View childAt = this.f45043b.getChildAt(i5);
            if (childAt != null) {
                Object tag = childAt.getTag(f.aiapps_na_root_view_tag);
                b bVar = tag instanceof b ? (b) tag : null;
                if (bVar != null && bVar.d()) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    marginLayoutParams2.leftMargin = bVar.b() + i;
                    marginLayoutParams2.topMargin = bVar.c() + i2;
                    childAt.setLayoutParams(marginLayoutParams2);
                }
            }
        }
    }

    @Override // d.b.g0.a.j2.f.a
    public boolean removeView(View view) {
        if (d(view, this.f45043b)) {
            try {
                this.f45043b.removeView(view);
            } catch (Exception e2) {
                if (f45041g) {
                    e2.printStackTrace();
                }
            }
            return true;
        } else if (g(view)) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Exception e3) {
                if (f45041g) {
                    e3.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
