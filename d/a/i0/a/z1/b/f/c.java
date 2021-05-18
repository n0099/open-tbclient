package d.a.i0.a.z1.b.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.i0.a.i;
import d.a.i0.a.z1.b.f.e;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f46011a;

    /* renamed from: b  reason: collision with root package name */
    public Context f46012b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f46013c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f46014d;

    /* renamed from: e  reason: collision with root package name */
    public View f46015e;

    /* renamed from: f  reason: collision with root package name */
    public View f46016f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f46017g;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f46019i;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* renamed from: h  reason: collision with root package name */
    public Handler f46018h = new Handler(Looper.getMainLooper());
    public Runnable j = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f46015e != null) {
                if (c.this.f46015e.getParent() != null) {
                    c.this.f46013c.removeView(c.this.f46015e);
                    if (c.this.k != null) {
                        c.this.k.onDismiss();
                        c.this.k = null;
                    }
                }
                c.this.f46015e = null;
            }
            if (c.this.m != null) {
                if (c.this.m.getParent() != null) {
                    c.this.f46013c.removeView(c.this.m);
                }
                c.this.m = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                if (c.this.l) {
                    if (c.this.m != null && (c.this.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) c.this.m.getParent()).removeView(c.this.m);
                    }
                    WindowManager.LayoutParams t = c.this.t();
                    c.this.n = new FrameLayout(c.this.f46012b);
                    c.this.n.setClickable(true);
                    c.this.f46013c.addView(c.this.n, t);
                    c.this.m = c.this.n;
                }
                if (c.this.f46016f != null && (c.this.f46016f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.f46016f.getParent()).removeView(c.this.f46016f);
                }
                c.this.f46013c.addView(c.this.f46016f, c.this.f46017g);
                c.this.f46015e = c.this.f46016f;
                c.this.f46018h.postDelayed(c.this.j, c.this.f46014d * 1000);
                if (c.this.f46011a) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: d.a.i0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0927c implements Runnable {
        public RunnableC0927c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                if (c.this.f46015e != null) {
                    if (c.this.f46015e.getParent() != null) {
                        c.this.f46013c.removeViewImmediate(c.this.f46015e);
                    }
                    if (c.this.k != null) {
                        c.this.k.onDismiss();
                        c.this.k = null;
                    }
                    if (c.this.f46011a) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    c.this.f46015e = null;
                }
                if (c.this.m != null) {
                    if (c.this.m.getParent() != null) {
                        c.this.f46013c.removeViewImmediate(c.this.m);
                    }
                    if (c.this.f46011a) {
                        Log.d("ToastCustom", "remove mMaskView");
                    }
                    c.this.m = null;
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    public c(Context context) {
        this.f46012b = context;
        this.f46013c = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f46017g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f46017g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f46014d = 2;
        this.f46011a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams = this.f46017g;
        if (layoutParams != null) {
            layoutParams.windowAnimations = i2;
        }
    }

    public void B() {
        Runnable runnable = this.f46019i;
        if (runnable != null) {
            this.f46018h.removeCallbacks(runnable);
        }
        b bVar = new b();
        this.f46019i = bVar;
        this.f46018h.post(bVar);
    }

    public void s() {
        Handler handler = this.f46018h;
        if (handler != null) {
            handler.post(new RunnableC0927c());
            this.f46018h.removeCallbacks(this.j);
            if (this.f46011a) {
                Log.d("ToastCustom", QueryResponse.Options.CANCEL);
            }
        }
    }

    public final WindowManager.LayoutParams t() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = e.c(this.f46012b);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }

    public boolean u() {
        View view = this.f46015e;
        return (view == null || view.getParent() == null) ? false : true;
    }

    public void v(int i2) {
        if (i2 <= 0) {
            i2 = 2;
        }
        this.f46014d = i2;
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams = this.f46017g;
        if (layoutParams != null) {
            layoutParams.gravity = i2;
            layoutParams.x = i3;
            layoutParams.y = i4;
        }
    }

    public void x(boolean z) {
        this.l = z;
    }

    public void y(e.b bVar) {
        this.k = bVar;
    }

    public void z(@NonNull View view) {
        this.f46016f = view;
        view.setClickable(true);
    }
}
