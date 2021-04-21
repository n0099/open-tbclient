package d.b.h0.a.s0.j;

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
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.p.d.d;
import d.b.h0.a.z0.h;
import d.b.h0.a.z0.i;
/* loaded from: classes2.dex */
public class b {
    public static final boolean i = k.f45772a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f46593a;

    /* renamed from: b  reason: collision with root package name */
    public View f46594b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f46595c;

    /* renamed from: d  reason: collision with root package name */
    public int f46596d;

    /* renamed from: e  reason: collision with root package name */
    public int f46597e;

    /* renamed from: f  reason: collision with root package name */
    public String f46598f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0822b f46599g;

    /* renamed from: h  reason: collision with root package name */
    public c f46600h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46594b != null) {
                b.this.f46594b.requestFocus();
            }
        }
    }

    /* renamed from: d.b.h0.a.s0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0822b {
        void onCustomViewHidden();
    }

    /* loaded from: classes2.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f46602a;

        /* renamed from: b  reason: collision with root package name */
        public String f46603b;

        public c(Activity activity, String str) {
            this.f46602a = activity;
            this.f46603b = str;
        }

        @Override // d.b.h0.a.z0.h
        public void a(d dVar) {
        }

        @Override // d.b.h0.a.z0.h
        public void b(d dVar) {
        }

        @Override // d.b.h0.a.z0.h
        public void c(d dVar) {
        }

        @Override // d.b.h0.a.z0.h
        public void d(d dVar) {
            if (TextUtils.equals(dVar.c(), this.f46603b)) {
                b.f(this.f46602a, true);
                ((ViewGroup) this.f46602a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }
    }

    public b(Context context, String str) {
        this.f46593a = context;
        this.f46598f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.b.h0.a.a0.b.a b2 = d.b.h0.a.a0.d.a.b(this.f46598f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f43833e) || "coverImage".equals(b2.n().f43833e)) {
            if (this.f46595c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f46595c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f46594b == null) {
            return;
        }
        if (i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f46593a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f46600h);
            this.f46600h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f46595c);
            this.f46595c = null;
            this.f46594b = null;
            InterfaceC0822b interfaceC0822b = this.f46599g;
            if (interfaceC0822b != null) {
                interfaceC0822b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f46596d);
            viewGroup.setSystemUiVisibility(this.f46597e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.b.h0.a.a0.b.a b2 = d.b.h0.a.a0.d.a.b(this.f46598f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f43833e) || "coverImage".equals(b2.n().f43833e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0822b interfaceC0822b) {
        if (i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f46593a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f46594b != null) {
                if (interfaceC0822b != null) {
                    interfaceC0822b.onCustomViewHidden();
                    this.f46599g = interfaceC0822b;
                    return;
                }
                return;
            }
            this.f46596d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f46595c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f46595c, j);
            this.f46594b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.b.h0.a.w0.a.z().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f46597e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f46600h == null) {
                this.f46600h = new c(activity, this.f46598f);
            }
            i.e(this.f46600h);
            k0.T(new a());
        }
    }
}
