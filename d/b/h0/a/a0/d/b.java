package d.b.h0.a.a0.d;

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
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43888a = k.f45772a;

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

    /* renamed from: d.b.h0.a.a0.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0628b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollView f43889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a0.c.e.c.b f43890f;

        public RunnableC0628b(ScrollView scrollView, d.b.h0.a.a0.c.e.c.b bVar) {
            this.f43889e = scrollView;
            this.f43890f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43889e.smoothScrollTo(0, this.f43890f.G);
        }
    }

    public static FrameLayout.LayoutParams a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = 0;
        return layoutParams;
    }

    public static boolean b(@NonNull c cVar, @NonNull d.b.h0.a.a0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        d.b.h0.a.c0.c.b("Component-Container-Scroll", "insert component（scroll）");
        if (bVar.l == null) {
            d.b.h0.a.a0.g.a.a("Component-Container-Scroll", "insert component（scroll） with a null position");
            return false;
        } else if (TextUtils.isEmpty(bVar.f43836h)) {
            ScrollView h2 = h(swanAppComponentContainerView, bVar);
            return h2 != null && cVar.f43892a.c(h2, bVar.l);
        } else {
            SwanAppComponentContainerView a2 = cVar.a(bVar.f43836h);
            if (a2 == null) {
                d.b.h0.a.c0.c.b("Component-Container-Scroll", "insert component（scroll） to parent with a null parent container view");
                return false;
            }
            ScrollView h3 = h(swanAppComponentContainerView, bVar);
            if (h3 == null) {
                d.b.h0.a.c0.c.b("Component-Container-Scroll", "insert component（scroll） to parent with a null scroll view");
                return false;
            }
            a2.addView(h3, bVar.b());
            return true;
        }
    }

    public static boolean c(@NonNull d.b.h0.a.a0.b.b bVar) {
        return (bVar instanceof d.b.h0.a.a0.c.e.c.b) && TextUtils.equals(((d.b.h0.a.a0.c.e.c.b) bVar).H, "scroll");
    }

    public static boolean d(@NonNull c cVar, @NonNull d.b.h0.a.a0.b.a aVar, @NonNull d.b.h0.a.a0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.b.h0.a.a0.f.b bVar2) {
        if (bVar instanceof d.b.h0.a.a0.c.e.c.b) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (bVar2.a(7)) {
                if (f43888a) {
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
                d.b.h0.a.a0.g.a.a("Component-Container-Scroll", "update component（scroll） overflow_y fail");
            }
            return false;
        }
        return false;
    }

    public static boolean e(@NonNull c cVar, @NonNull d.b.h0.a.a0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        if (f43888a) {
            Log.d("Component-Container-Scroll", "update component（scroll）position");
        }
        String str = bVar.f43836h;
        if (TextUtils.isEmpty(str)) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            ScrollView scrollView2 = swanAppComponentContainerView;
            if (scrollView != null) {
                scrollView2 = swanAppComponentContainerView.getScrollView();
            }
            return cVar.f43892a.b(scrollView2, bVar.l);
        }
        SwanAppComponentContainerView a2 = cVar.a(str);
        if (a2 == null) {
            d.b.h0.a.c0.c.b("Component-Container-Scroll", "update component（scroll）to parent with a null parent container view");
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
        d.b.h0.a.a0.g.a.a("Component-Container-Scroll", sb.toString());
        return false;
    }

    public static void f(@NonNull c cVar, @NonNull d.b.h0.a.a0.b.a aVar, @NonNull d.b.h0.a.a0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.b.h0.a.a0.f.b bVar2) {
        if (bVar instanceof d.b.h0.a.a0.c.e.c.b) {
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (bVar2.a(8)) {
                if (f43888a) {
                    Log.d("Component-Container-Scroll", "update component（scroll） scroll_top");
                }
                if (scrollView != null) {
                    scrollView.smoothScrollTo(0, ((d.b.h0.a.a0.c.e.c.b) bVar).G);
                }
            }
        }
    }

    public static boolean g(@NonNull c cVar, @NonNull d.b.h0.a.a0.b.b bVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        if (TextUtils.isEmpty(bVar.f43836h)) {
            return cVar.f43892a.removeView(swanAppComponentContainerView.getScrollView());
        }
        SwanAppComponentContainerView a2 = cVar.a(bVar.f43836h);
        if (a2 == null) {
            d.b.h0.a.c0.c.b("Component-Container-Scroll", "remove component（scroll） to parent with a null parent container view");
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
        d.b.h0.a.a0.g.a.a("Component-Container-Scroll", sb.toString());
        return false;
    }

    @Nullable
    public static ScrollView h(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull d.b.h0.a.a0.b.b bVar) {
        if (bVar instanceof d.b.h0.a.a0.c.e.c.b) {
            ScrollView scrollView = new ScrollView(swanAppComponentContainerView.getContext());
            scrollView.setFillViewport(true);
            scrollView.setOnTouchListener(new a());
            FrameLayout frameLayout = new FrameLayout(swanAppComponentContainerView.getContext());
            frameLayout.addView(swanAppComponentContainerView, a());
            scrollView.addView(frameLayout);
            swanAppComponentContainerView.postDelayed(new RunnableC0628b(scrollView, (d.b.h0.a.a0.c.e.c.b) bVar), 100L);
            swanAppComponentContainerView.setScrollView(scrollView);
            return scrollView;
        }
        return null;
    }
}
