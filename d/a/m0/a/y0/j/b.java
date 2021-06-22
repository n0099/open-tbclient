package d.a.m0.a.y0.j;

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
import d.a.m0.a.g1.h;
import d.a.m0.a.g1.i;
import d.a.m0.a.k;
import d.a.m0.a.p.e.d;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49645i = k.f46983a;
    public static final ViewGroup.LayoutParams j = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public Context f49646a;

    /* renamed from: b  reason: collision with root package name */
    public View f49647b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f49648c;

    /* renamed from: d  reason: collision with root package name */
    public int f49649d;

    /* renamed from: e  reason: collision with root package name */
    public int f49650e;

    /* renamed from: f  reason: collision with root package name */
    public String f49651f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC0976b f49652g;

    /* renamed from: h  reason: collision with root package name */
    public c f49653h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f49647b != null) {
                b.this.f49647b.requestFocus();
            }
        }
    }

    /* renamed from: d.a.m0.a.y0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0976b {
        void onCustomViewHidden();
    }

    /* loaded from: classes3.dex */
    public static class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public Activity f49655a;

        /* renamed from: b  reason: collision with root package name */
        public String f49656b;

        public c(Activity activity, String str) {
            this.f49655a = activity;
            this.f49656b = str;
        }

        @Override // d.a.m0.a.g1.h
        public void a(d dVar) {
            if (TextUtils.equals(dVar.b(), this.f49656b)) {
                b.f(this.f49655a, true);
                ((ViewGroup) this.f49655a.getWindow().getDecorView()).setSystemUiVisibility(4098);
            }
        }

        @Override // d.a.m0.a.g1.h
        public void b(d dVar) {
        }

        @Override // d.a.m0.a.g1.h
        public void c(d dVar) {
        }

        @Override // d.a.m0.a.g1.h
        public void d(d dVar) {
        }
    }

    public b(Context context, String str) {
        this.f49646a = context;
        this.f49651f = str;
    }

    public static void f(Activity activity, boolean z) {
        activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
    }

    @UiThread
    public synchronized void c(String str) {
        if (f49645i) {
            Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
        }
        d.a.m0.a.c0.b.a b2 = d.a.m0.a.c0.d.a.b(this.f49651f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f44628e) || "coverImage".equals(b2.n().f44628e)) {
            if (this.f49648c == null) {
                return;
            }
            SwanAppComponentContainerView m = b2.m();
            if (m == null) {
                return;
            }
            ViewParent parent = m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(m);
                this.f49648c.addView(m);
            }
        }
    }

    public void d() {
        if (this.f49647b == null) {
            return;
        }
        if (f49645i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.f49646a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            i.f(this.f49653h);
            this.f49653h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.f49648c);
            this.f49648c = null;
            this.f49647b = null;
            InterfaceC0976b interfaceC0976b = this.f49652g;
            if (interfaceC0976b != null) {
                interfaceC0976b.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.f49649d);
            viewGroup.setSystemUiVisibility(this.f49650e);
        }
    }

    @UiThread
    public synchronized void e(String str) {
        if (f49645i) {
            Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
        }
        d.a.m0.a.c0.b.a b2 = d.a.m0.a.c0.d.a.b(this.f49651f, str);
        if (b2 == null) {
            return;
        }
        if ("coverView".equals(b2.n().f44628e) || "coverImage".equals(b2.n().f44628e)) {
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

    public void g(View view, int i2, @Nullable InterfaceC0976b interfaceC0976b) {
        if (f49645i) {
            Log.i("SwanCustomViewHelper", "showCustomView");
        }
        Context context = this.f49646a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (this.f49647b != null) {
                if (interfaceC0976b != null) {
                    interfaceC0976b.onCustomViewHidden();
                    this.f49652g = interfaceC0976b;
                    return;
                }
                return;
            }
            this.f49649d = activity.getRequestedOrientation();
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f49648c = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, j);
            viewGroup.addView(this.f49648c, j);
            this.f49647b = view;
            f(activity, true);
            activity.setRequestedOrientation(i2);
            if (d.a.m0.a.c1.a.H().a() && (activity instanceof SwanAppActivity)) {
                ((SwanAppActivity) activity).onNightModeCoverChanged(true, false);
            }
            this.f49650e = viewGroup.getSystemUiVisibility();
            viewGroup.setSystemUiVisibility(4098);
            if (this.f49653h == null) {
                this.f49653h = new c(activity, this.f49651f);
            }
            i.e(this.f49653h);
            q0.X(new a());
        }
    }
}
