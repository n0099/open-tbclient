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
    public static final boolean f45863i = k.f43199a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f45864a;

    /* renamed from: b  reason: collision with root package name */
    public View f45865b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f45866c;

    /* renamed from: d  reason: collision with root package name */
    public int f45867d;

    /* renamed from: e  reason: collision with root package name */
    public int f45868e;

    /* renamed from: f  reason: collision with root package name */
    public String f45869f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0917b f45870g;

    /* renamed from: h  reason: collision with root package name */
    public c f45871h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45865b != null) {
                b.this.f45865b.requestFocus();
            }
        }
    }

    /* renamed from: d.a.l0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0917b {
        void onCustomViewHidden();
    }

    /* loaded from: classes3.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f45873a;

        /* renamed from: b  reason: collision with root package name */
        public String f45874b;

        public c(Activity activity, String str) {
            this.f45873a = activity;
            this.f45874b = str;
        }

        @Override // d.a.l0.a.g1.h
        public void a(d dVar) {
            if (TextUtils.equals(dVar.b(), this.f45874b)) {
                b.f(this.f45873a, true);
                ((ViewGroup) this.f45873a.getWindow().getDecorView()).setSystemUiVisibility(4098);
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
        this.f45864a = context;
        this.f45869f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (f45863i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.a.l0.a.c0.b.a b2 = d.a.l0.a.c0.d.a.b(this.f45869f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f40844e) || "coverImage".equals(b2.n().f40844e)) {
            if (this.f45866c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f45866c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f45865b == null) {
            return;
        }
        if (f45863i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f45864a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f45871h);
            this.f45871h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f45866c);
            this.f45866c = null;
            this.f45865b = null;
            InterfaceC0917b interfaceC0917b = this.f45870g;
            if (interfaceC0917b != null) {
                interfaceC0917b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f45867d);
            viewGroup.setSystemUiVisibility(this.f45868e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (f45863i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.a.l0.a.c0.b.a b2 = d.a.l0.a.c0.d.a.b(this.f45869f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f40844e) || "coverImage".equals(b2.n().f40844e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0917b interfaceC0917b) {
        if (f45863i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f45864a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f45865b != null) {
                if (interfaceC0917b != null) {
                    interfaceC0917b.onCustomViewHidden();
                    this.f45870g = interfaceC0917b;
                    return;
                }
                return;
            }
            this.f45867d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f45866c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f45866c, j);
            this.f45865b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.a.l0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f45868e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f45871h == null) {
                this.f45871h = new c(activity, this.f45869f);
            }
            i.e(this.f45871h);
            q0.X(new a());
        }
    }
}
