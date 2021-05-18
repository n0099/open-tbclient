package d.a.i0.a.y0.j;

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
import d.a.i0.a.g1.h;
import d.a.i0.a.g1.i;
import d.a.i0.a.k;
import d.a.i0.a.p.e.d;
import d.a.i0.a.v2.q0;
/* loaded from: classes.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45687i = k.f43025a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f45688a;

    /* renamed from: b  reason: collision with root package name */
    public View f45689b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f45690c;

    /* renamed from: d  reason: collision with root package name */
    public int f45691d;

    /* renamed from: e  reason: collision with root package name */
    public int f45692e;

    /* renamed from: f  reason: collision with root package name */
    public String f45693f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0906b f45694g;

    /* renamed from: h  reason: collision with root package name */
    public c f45695h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45689b != null) {
                b.this.f45689b.requestFocus();
            }
        }
    }

    /* renamed from: d.a.i0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0906b {
        void onCustomViewHidden();
    }

    /* loaded from: classes.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f45697a;

        /* renamed from: b  reason: collision with root package name */
        public String f45698b;

        public c(Activity activity, String str) {
            this.f45697a = activity;
            this.f45698b = str;
        }

        @Override // d.a.i0.a.g1.h
        public void a(d dVar) {
            if (TextUtils.equals(dVar.b(), this.f45698b)) {
                b.f(this.f45697a, true);
                ((ViewGroup) this.f45697a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // d.a.i0.a.g1.h
        public void b(d dVar) {
        }

        @Override // d.a.i0.a.g1.h
        public void c(d dVar) {
        }

        @Override // d.a.i0.a.g1.h
        public void d(d dVar) {
        }
    }

    public b(Context context, String str) {
        this.f45688a = context;
        this.f45693f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (f45687i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.a.i0.a.c0.b.a b2 = d.a.i0.a.c0.d.a.b(this.f45693f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f40670e) || "coverImage".equals(b2.n().f40670e)) {
            if (this.f45690c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f45690c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f45689b == null) {
            return;
        }
        if (f45687i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f45688a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f45695h);
            this.f45695h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f45690c);
            this.f45690c = null;
            this.f45689b = null;
            InterfaceC0906b interfaceC0906b = this.f45694g;
            if (interfaceC0906b != null) {
                interfaceC0906b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f45691d);
            viewGroup.setSystemUiVisibility(this.f45692e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (f45687i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.a.i0.a.c0.b.a b2 = d.a.i0.a.c0.d.a.b(this.f45693f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f40670e) || "coverImage".equals(b2.n().f40670e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0906b interfaceC0906b) {
        if (f45687i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f45688a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f45689b != null) {
                if (interfaceC0906b != null) {
                    interfaceC0906b.onCustomViewHidden();
                    this.f45694g = interfaceC0906b;
                    return;
                }
                return;
            }
            this.f45691d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f45690c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f45690c, j);
            this.f45689b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.a.i0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f45692e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f45695h == null) {
                this.f45695h = new c(activity, this.f45693f);
            }
            i.e(this.f45695h);
            q0.X(new a());
        }
    }
}
