package d.b.g0.a.s0.j;

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
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.p.d.d;
import d.b.g0.a.z0.h;
import d.b.g0.a.z0.i;
/* loaded from: classes2.dex */
public class b {
    public static final boolean i = k.f45443a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f46264a;

    /* renamed from: b  reason: collision with root package name */
    public View f46265b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f46266c;

    /* renamed from: d  reason: collision with root package name */
    public int f46267d;

    /* renamed from: e  reason: collision with root package name */
    public int f46268e;

    /* renamed from: f  reason: collision with root package name */
    public String f46269f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0802b f46270g;

    /* renamed from: h  reason: collision with root package name */
    public c f46271h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46265b != null) {
                b.this.f46265b.requestFocus();
            }
        }
    }

    /* renamed from: d.b.g0.a.s0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0802b {
        void onCustomViewHidden();
    }

    /* loaded from: classes2.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f46273a;

        /* renamed from: b  reason: collision with root package name */
        public String f46274b;

        public c(Activity activity, String str) {
            this.f46273a = activity;
            this.f46274b = str;
        }

        @Override // d.b.g0.a.z0.h
        public void a(d dVar) {
        }

        @Override // d.b.g0.a.z0.h
        public void b(d dVar) {
        }

        @Override // d.b.g0.a.z0.h
        public void c(d dVar) {
        }

        @Override // d.b.g0.a.z0.h
        public void d(d dVar) {
            if (TextUtils.equals(dVar.c(), this.f46274b)) {
                b.f(this.f46273a, true);
                ((ViewGroup) this.f46273a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }
    }

    public b(Context context, String str) {
        this.f46264a = context;
        this.f46269f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.b.g0.a.a0.b.a b2 = d.b.g0.a.a0.d.a.b(this.f46269f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f43504e) || "coverImage".equals(b2.n().f43504e)) {
            if (this.f46266c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f46266c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f46265b == null) {
            return;
        }
        if (i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f46264a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f46271h);
            this.f46271h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f46266c);
            this.f46266c = null;
            this.f46265b = null;
            InterfaceC0802b interfaceC0802b = this.f46270g;
            if (interfaceC0802b != null) {
                interfaceC0802b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f46267d);
            viewGroup.setSystemUiVisibility(this.f46268e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.b.g0.a.a0.b.a b2 = d.b.g0.a.a0.d.a.b(this.f46269f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f43504e) || "coverImage".equals(b2.n().f43504e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0802b interfaceC0802b) {
        if (i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f46264a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f46265b != null) {
                if (interfaceC0802b != null) {
                    interfaceC0802b.onCustomViewHidden();
                    this.f46270g = interfaceC0802b;
                    return;
                }
                return;
            }
            this.f46267d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f46266c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f46266c, j);
            this.f46265b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.b.g0.a.w0.a.z().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f46268e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f46271h == null) {
                this.f46271h = new c(activity, this.f46269f);
            }
            i.e(this.f46271h);
            k0.T(new a());
        }
    }
}
