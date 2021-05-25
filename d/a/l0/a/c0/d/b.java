package d.a.l0.a.c0.d;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40907a = k.f43199a;

    /* loaded from: classes2.dex */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getParent() != null) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
            return false;
        }
    }

    /* renamed from: d.a.l0.a.c0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0576b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollView f40908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.c0.c.e.c.b f40909f;

        public RunnableC0576b(ScrollView scrollView, d.a.l0.a.c0.c.e.c.b bVar) {
            this.f40908e = scrollView;
            this.f40909f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40908e.smoothScrollTo(0, this.f40909f.G);
        }
    }

    public static FrameLayout.LayoutParams a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        return layoutParams;
    }

    public static boolean b(@NonNull c cVar, @NonNull d.a.l0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        d.b("Component-Container-Scroll", "insert component（scroll）");
        if (bVar.l == null) {
            d.a.l0.a.c0.g.a.a("Component-Container-Scroll", "insert component（scroll） with a null position");
            return false;
        } else if (TextUtils.isEmpty(bVar.f40847h)) {
            ScrollView h2 = h(swanAppComponentContainerView, bVar);
            return h2 != null && cVar.f40911a.c(h2, bVar.l);
        } else {
            SwanAppComponentContainerView a2 = cVar.a(bVar.f40847h);
            if (a2 == null) {
                d.b("Component-Container-Scroll", "insert component（scroll） to parent with a null parent container view");
                return false;
            }
            ScrollView h3 = h(swanAppComponentContainerView, bVar);
            if (h3 == null) {
                d.b("Component-Container-Scroll", "insert component（scroll） to parent with a null scroll view");
                return false;
            }
            a2.addView(h3, bVar.b());
            return true;
        }
    }

    public static boolean c(@NonNull d.a.l0.a.c0.b.b bVar) {
        return (bVar instanceof d.a.l0.a.c0.c.e.c.b) && TextUtils.equals(((d.a.l0.a.c0.c.e.c.b) bVar).H, "scroll");
    }

    public static boolean d(@NonNull c cVar, @NonNull d.a.l0.a.c0.b.a aVar, @NonNull d.a.l0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.l0.a.c0.f.b bVar2) {
        if (bVar instanceof d.a.l0.a.c0.c.e.c.b) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (bVar2.a(7)) {
                if (f40907a) {
                    Log.d("Component-Container-Scroll", "update component（scroll）overflow_y");
                }
                if (scrollView != null) {
                    if (scrollView.getParent() == null) {
                        return false;
                    }
                    ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                    ((ViewGroup) scrollView.getParent()).removeView(scrollView);
                    swanAppComponentContainerView.setScrollView(null);
                } else {
                    ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                }
                if (cVar.b(aVar)) {
                    return true;
                }
                d.a.l0.a.c0.g.a.a("Component-Container-Scroll", "update component（scroll） overflow_y fail");
            }
            return false;
        }
        return false;
    }

    public static boolean e(@NonNull c cVar, @NonNull d.a.l0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        if (f40907a) {
            Log.d("Component-Container-Scroll", "update component（scroll）position");
        }
        String str = bVar.f40847h;
        if (TextUtils.isEmpty(str)) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            ScrollView scrollView2 = swanAppComponentContainerView;
            if (scrollView != null) {
                scrollView2 = swanAppComponentContainerView.getScrollView();
            }
            return cVar.f40911a.a(scrollView2, bVar.l);
        }
        SwanAppComponentContainerView a2 = cVar.a(str);
        if (a2 == null) {
            d.b("Component-Container-Scroll", "update component（scroll）to parent with a null parent container view");
            return false;
        }
        ScrollView scrollView3 = swanAppComponentContainerView.getScrollView();
        if (scrollView3 != null && scrollView3.getParent() == a2) {
            a2.updateViewLayout(scrollView3, bVar.b());
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("update component（scroll）to parent with a illegal parent view (Scroll) ");
        sb.append(scrollView3 == null);
        d.a.l0.a.c0.g.a.a("Component-Container-Scroll", sb.toString());
        return false;
    }

    public static void f(@NonNull c cVar, @NonNull d.a.l0.a.c0.b.a aVar, @NonNull d.a.l0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.l0.a.c0.f.b bVar2) {
        if (bVar instanceof d.a.l0.a.c0.c.e.c.b) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (bVar2.a(8)) {
                if (f40907a) {
                    Log.d("Component-Container-Scroll", "update component（scroll） scroll_top");
                }
                if (scrollView != null) {
                    scrollView.smoothScrollTo(0, ((d.a.l0.a.c0.c.e.c.b) bVar).G);
                }
            }
        }
    }

    public static boolean g(@NonNull c cVar, @NonNull d.a.l0.a.c0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        if (TextUtils.isEmpty(bVar.f40847h)) {
            return cVar.f40911a.removeView(swanAppComponentContainerView.getScrollView());
        }
        SwanAppComponentContainerView a2 = cVar.a(bVar.f40847h);
        if (a2 == null) {
            d.b("Component-Container-Scroll", "remove component（scroll） to parent with a null parent container view");
            return false;
        }
        ScrollView scrollView = swanAppComponentContainerView.getScrollView();
        if (scrollView != null && scrollView.getParent() == a2) {
            a2.removeView(scrollView);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("remove component（scroll）to parent with a illegal parent view");
        sb.append(scrollView == null);
        d.a.l0.a.c0.g.a.a("Component-Container-Scroll", sb.toString());
        return false;
    }

    @Nullable
    public static ScrollView h(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.a.l0.a.c0.b.b bVar) {
        if (bVar instanceof d.a.l0.a.c0.c.e.c.b) {
            ScrollView scrollView = new ScrollView(swanAppComponentContainerView.getContext());
            scrollView.setFillViewport(true);
            scrollView.setOnTouchListener(new a());
            FrameLayout frameLayout = new FrameLayout(swanAppComponentContainerView.getContext());
            frameLayout.addView(swanAppComponentContainerView, a());
            scrollView.addView(frameLayout);
            swanAppComponentContainerView.postDelayed(new RunnableC0576b(scrollView, (d.a.l0.a.c0.c.e.c.b) bVar), 100L);
            swanAppComponentContainerView.setScrollView(scrollView);
            return scrollView;
        }
        return null;
    }
}
