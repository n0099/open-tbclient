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
/* loaded from: classes3.dex */
public class b {
    public static final boolean i = k.f45050a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f45871a;

    /* renamed from: b  reason: collision with root package name */
    public View f45872b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f45873c;

    /* renamed from: d  reason: collision with root package name */
    public int f45874d;

    /* renamed from: e  reason: collision with root package name */
    public int f45875e;

    /* renamed from: f  reason: collision with root package name */
    public String f45876f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0789b f45877g;

    /* renamed from: h  reason: collision with root package name */
    public c f45878h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45872b != null) {
                b.this.f45872b.requestFocus();
            }
        }
    }

    /* renamed from: d.b.g0.a.s0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0789b {
        void onCustomViewHidden();
    }

    /* loaded from: classes3.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f45880a;

        /* renamed from: b  reason: collision with root package name */
        public String f45881b;

        public c(Activity activity, String str) {
            this.f45880a = activity;
            this.f45881b = str;
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
            if (TextUtils.equals(dVar.c(), this.f45881b)) {
                b.f(this.f45880a, true);
                ((ViewGroup) this.f45880a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }
    }

    public b(Context context, String str) {
        this.f45871a = context;
        this.f45876f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.b.g0.a.a0.b.a b2 = d.b.g0.a.a0.d.a.b(this.f45876f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f43111e) || "coverImage".equals(b2.n().f43111e)) {
            if (this.f45873c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f45873c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f45872b == null) {
            return;
        }
        if (i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f45871a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f45878h);
            this.f45878h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f45873c);
            this.f45873c = null;
            this.f45872b = null;
            InterfaceC0789b interfaceC0789b = this.f45877g;
            if (interfaceC0789b != null) {
                interfaceC0789b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f45874d);
            viewGroup.setSystemUiVisibility(this.f45875e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.b.g0.a.a0.b.a b2 = d.b.g0.a.a0.d.a.b(this.f45876f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f43111e) || "coverImage".equals(b2.n().f43111e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0789b interfaceC0789b) {
        if (i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f45871a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f45872b != null) {
                if (interfaceC0789b != null) {
                    interfaceC0789b.onCustomViewHidden();
                    this.f45877g = interfaceC0789b;
                    return;
                }
                return;
            }
            this.f45874d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f45873c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f45873c, j);
            this.f45872b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.b.g0.a.w0.a.z().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f45875e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f45878h == null) {
                this.f45878h = new c(activity, this.f45876f);
            }
            i.e(this.f45878h);
            k0.T(new a());
        }
    }
}
