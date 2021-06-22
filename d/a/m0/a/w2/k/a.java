package d.a.m0.a.w2.k;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import d.a.m0.a.f;
import d.a.m0.a.k;
import d.a.m0.a.p.e.c;
/* loaded from: classes3.dex */
public class a<T extends d.a.m0.a.p.e.c> implements d.a.m0.a.h0.j.c, d.a.m0.a.w2.g.a, PullToRefreshBaseWebView.a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f49510g = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f49511a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f49512b;

    /* renamed from: c  reason: collision with root package name */
    public T f49513c;

    /* renamed from: d  reason: collision with root package name */
    public PullToRefreshBaseWebView f49514d;

    /* renamed from: e  reason: collision with root package name */
    public Context f49515e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.p.e.b f49516f;

    public a(Context context, @NonNull d.a.m0.a.p.e.b<T> bVar, @NonNull FrameLayout frameLayout) {
        this.f49515e = context;
        this.f49511a = frameLayout;
        this.f49516f = bVar;
        e(bVar);
    }

    @Override // d.a.m0.a.w2.g.a
    public boolean a(View view, d.a.m0.a.l1.e.a.a aVar) {
        if (view == null || this.f49512b == null || aVar == null) {
            return false;
        }
        if (f49510g) {
            Log.d("NAParentViewManager", "updateView pos: " + aVar);
        }
        if (d(view, this.f49512b)) {
            Object tag = view.getTag(f.aiapps_na_root_view_tag);
            if (tag instanceof b) {
                b bVar = (b) tag;
                c.a(bVar, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar);
            }
            this.f49512b.updateViewLayout(view, c.b(this.f49513c, aVar));
        } else if (!g(view)) {
            return false;
        } else {
            Object tag2 = view.getTag(f.aiapps_na_root_view_tag);
            if (tag2 instanceof b) {
                b bVar2 = (b) tag2;
                c.a(bVar2, aVar);
                view.setTag(f.aiapps_na_root_view_tag, bVar2);
            }
            ((ViewGroup) view.getParent()).updateViewLayout(view, c.b(this.f49513c, aVar));
        }
        return true;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i2, int i3, int i4, int i5) {
        this.f49512b.scrollTo(i2, i3);
    }

    @Override // d.a.m0.a.w2.g.a
    public boolean c(View view, d.a.m0.a.l1.e.a.a aVar) {
        if (this.f49515e != null && aVar != null) {
            b bVar = new b();
            c.a(bVar, aVar);
            view.setTag(f.aiapps_na_root_view_tag, bVar);
            if (this.f49512b.indexOfChild(view) >= 0) {
                d.a.m0.a.c0.g.a.a("NAParentViewManager", "repeat insert view!");
                this.f49512b.removeView(view);
            }
            this.f49512b.addView(view, c.b(this.f49513c, aVar));
            return true;
        } else if (f49510g) {
            Log.d("NAParentViewManager", "insertView failed");
            return false;
        } else {
            return false;
        }
    }

    public final boolean d(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    public final boolean e(d.a.m0.a.p.e.b<T> bVar) {
        if (f49510g) {
            Log.d("NAParentViewManager", "createViewAndListener");
        }
        bVar.v(this);
        T u = bVar.u();
        this.f49513c = u;
        if (u == null) {
            return false;
        }
        SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.f49515e);
        this.f49511a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
        this.f49512b = new FrameLayout(this.f49515e);
        swanAppNARootViewScrollView.addView(this.f49512b, new FrameLayout.LayoutParams(-1, -1));
        swanAppNARootViewScrollView.setFillViewport(true);
        PullToRefreshBaseWebView h0 = bVar.h0();
        this.f49514d = h0;
        if (h0 != null) {
            h0.setOnPullToRefreshScrollChangeListener(this);
        }
        return true;
    }

    public void f() {
        this.f49516f.V(this);
    }

    public final boolean g(View view) {
        if (view == null) {
            return false;
        }
        return view.getParent() instanceof SwanAppInlineFullScreenContainer;
    }

    public void h(int i2) {
        this.f49512b.setVisibility(i2);
    }

    @Override // d.a.m0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f49512b.getLayoutParams();
        marginLayoutParams.leftMargin = -i2;
        marginLayoutParams.topMargin = -i3;
        this.f49512b.setLayoutParams(marginLayoutParams);
        for (int i6 = 0; i6 < this.f49512b.getChildCount(); i6++) {
            View childAt = this.f49512b.getChildAt(i6);
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

    @Override // d.a.m0.a.w2.g.a
    public boolean removeView(View view) {
        if (d(view, this.f49512b)) {
            try {
                this.f49512b.removeView(view);
            } catch (Exception e2) {
                if (f49510g) {
                    e2.printStackTrace();
                }
            }
            return true;
        } else if (g(view)) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Exception e3) {
                if (f49510g) {
                    e3.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
