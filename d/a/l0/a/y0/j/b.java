package d.a.l0.a.y0.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import d.a.l0.a.g1.h;
import d.a.l0.a.g1.i;
import d.a.l0.a.k;
import d.a.l0.a.p.e.d;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49537i = k.f46875a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f49538a;

    /* renamed from: b  reason: collision with root package name */
    public View f49539b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f49540c;

    /* renamed from: d  reason: collision with root package name */
    public int f49541d;

    /* renamed from: e  reason: collision with root package name */
    public int f49542e;

    /* renamed from: f  reason: collision with root package name */
    public String f49543f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0973b f49544g;

    /* renamed from: h  reason: collision with root package name */
    public c f49545h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f49539b != null) {
                b.this.f49539b.requestFocus();
            }
        }
    }

    /* renamed from: d.a.l0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0973b {
        void onCustomViewHidden();
    }

    /* loaded from: classes3.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f49547a;

        /* renamed from: b  reason: collision with root package name */
        public String f49548b;

        public c(Activity activity, String str) {
            this.f49547a = activity;
            this.f49548b = str;
        }

        @Override // d.a.l0.a.g1.h
        public void a(d dVar) {
            if (TextUtils.equals(dVar.b(), this.f49548b)) {
                b.f(this.f49547a, true);
                ((ViewGroup) this.f49547a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // d.a.l0.a.g1.h
        public void b(d dVar) {
        }

        @Override // d.a.l0.a.g1.h
        public void c(d dVar) {
        }

        @Override // d.a.l0.a.g1.h
        public void d(d dVar) {
        }
    }

    public b(Context context, String str) {
        this.f49538a = context;
        this.f49543f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (f49537i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.a.l0.a.c0.b.a b2 = d.a.l0.a.c0.d.a.b(this.f49543f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f44520e) || "coverImage".equals(b2.n().f44520e)) {
            if (this.f49540c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f49540c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f49539b == null) {
            return;
        }
        if (f49537i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f49538a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f49545h);
            this.f49545h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f49540c);
            this.f49540c = null;
            this.f49539b = null;
            InterfaceC0973b interfaceC0973b = this.f49544g;
            if (interfaceC0973b != null) {
                interfaceC0973b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f49541d);
            viewGroup.setSystemUiVisibility(this.f49542e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (f49537i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.a.l0.a.c0.b.a b2 = d.a.l0.a.c0.d.a.b(this.f49543f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f44520e) || "coverImage".equals(b2.n().f44520e)) {
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                b2.w();
            }
        }
    }

    public void g(View view, int i2, @Nullable InterfaceC0973b interfaceC0973b) {
        if (f49537i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f49538a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f49539b != null) {
                if (interfaceC0973b != null) {
                    interfaceC0973b.onCustomViewHidden();
                    this.f49544g = interfaceC0973b;
                    return;
                }
                return;
            }
            this.f49541d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f49540c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f49540c, j);
            this.f49539b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.a.l0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f49542e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f49545h == null) {
                this.f49545h = new c(activity, this.f49543f);
            }
            i.e(this.f49545h);
            q0.X(new a());
        }
    }
}
