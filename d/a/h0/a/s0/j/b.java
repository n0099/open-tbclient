package d.a.h0.a.s0.j;

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
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.p.d.d;
import d.a.h0.a.z0.h;
import d.a.h0.a.z0.i;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f43961i = k.f43101a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f43962a;

    /* renamed from: b  reason: collision with root package name */
    public View f43963b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f43964c;

    /* renamed from: d  reason: collision with root package name */
    public int f43965d;

    /* renamed from: e  reason: collision with root package name */
    public int f43966e;

    /* renamed from: f  reason: collision with root package name */
    public String f43967f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0761b f43968g;

    /* renamed from: h  reason: collision with root package name */
    public c f43969h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f43963b != null) {
                b.this.f43963b.requestFocus();
            }
        }
    }

    /* renamed from: d.a.h0.a.s0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0761b {
        void onCustomViewHidden();
    }

    /* loaded from: classes2.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f43971a;

        /* renamed from: b  reason: collision with root package name */
        public String f43972b;

        public c(Activity activity, String str) {
            this.f43971a = activity;
            this.f43972b = str;
        }

        @Override // d.a.h0.a.z0.h
        public void a(d dVar) {
            if (TextUtils.equals(dVar.c(), this.f43972b)) {
                b.f(this.f43971a, true);
                ((ViewGroup) this.f43971a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // d.a.h0.a.z0.h
        public void b(d dVar) {
        }

        @Override // d.a.h0.a.z0.h
        public void c(d dVar) {
        }

        @Override // d.a.h0.a.z0.h
        public void d(d dVar) {
        }
    }

    public b(Context context, String str) {
        this.f43962a = context;
        this.f43967f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (f43961i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.a.h0.a.a0.b.a b2 = d.a.h0.a.a0.d.a.b(this.f43967f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f41091e) || "coverImage".equals(b2.n().f41091e)) {
            if (this.f43964c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f43964c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f43963b == null) {
            return;
        }
        if (f43961i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f43962a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f43969h);
            this.f43969h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f43964c);
            this.f43964c = null;
            this.f43963b = null;
            InterfaceC0761b interfaceC0761b = this.f43968g;
            if (interfaceC0761b != null) {
                interfaceC0761b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f43965d);
            viewGroup.setSystemUiVisibility(this.f43966e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (f43961i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.a.h0.a.a0.b.a b2 = d.a.h0.a.a0.d.a.b(this.f43967f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f41091e) || "coverImage".equals(b2.n().f41091e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0761b interfaceC0761b) {
        if (f43961i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f43962a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f43963b != null) {
                if (interfaceC0761b != null) {
                    interfaceC0761b.onCustomViewHidden();
                    this.f43968g = interfaceC0761b;
                    return;
                }
                return;
            }
            this.f43965d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f43964c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f43964c, j);
            this.f43963b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.a.h0.a.w0.a.z().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f43966e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f43969h == null) {
                this.f43969h = new c(activity, this.f43967f);
            }
            i.e(this.f43969h);
            k0.T(new a());
        }
    }
}
