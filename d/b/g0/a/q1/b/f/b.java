package d.b.g0.a.q1.b.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.g0.a.f;
import d.b.g0.a.i;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class b {
    public static final boolean m = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45650a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f45651b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f45652c;

    /* renamed from: d  reason: collision with root package name */
    public View f45653d;

    /* renamed from: e  reason: collision with root package name */
    public View f45654e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f45655f;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f45657h;
    public boolean j;
    public View k;
    public View l;

    /* renamed from: g  reason: collision with root package name */
    public Handler f45656g = new Handler(Looper.getMainLooper());
    public Runnable i = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45653d != null) {
                if (b.this.f45653d.getParent() != null) {
                    b.this.f45651b.removeView(b.this.f45653d);
                }
                b.this.f45653d = null;
            }
            if (b.this.k != null) {
                if (b.this.k.getParent() != null) {
                    b.this.f45651b.removeView(b.this.k);
                }
                b.this.k = null;
            }
        }
    }

    /* renamed from: d.b.g0.a.q1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0768b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a f45659e;

        public View$OnClickListenerC0768b(d.a aVar) {
            this.f45659e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a aVar = this.f45659e;
            if (aVar != null) {
                aVar.a();
            }
            b.this.q();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                if (b.this.j) {
                    if (b.this.k != null && (b.this.k.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) b.this.k.getParent()).removeView(b.this.k);
                    }
                    WindowManager.LayoutParams r = b.this.r();
                    b.this.l = new FrameLayout(b.this.f45650a);
                    b.this.l.setClickable(true);
                    b.this.f45651b.addView(b.this.l, r);
                    b.this.k = b.this.l;
                }
                if (b.this.f45654e != null && (b.this.f45654e.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) b.this.f45654e.getParent()).removeView(b.this.f45654e);
                }
                b.this.f45651b.addView(b.this.f45654e, b.this.f45655f);
                b.this.f45653d = b.this.f45654e;
                b.this.f45656g.postDelayed(b.this.i, b.this.f45652c * 1000);
                if (b.m) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                if (b.this.f45653d != null) {
                    if (b.this.f45653d.getParent() != null) {
                        b.this.f45651b.removeViewImmediate(b.this.f45653d);
                    }
                    if (b.m) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    b.this.f45653d = null;
                }
                if (b.this.k != null) {
                    if (b.this.k.getParent() != null) {
                        b.this.f45651b.removeViewImmediate(b.this.k);
                    }
                    if (b.m) {
                        Log.d("ToastCustom", "remove mMaskView");
                    }
                    b.this.k = null;
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    public b(Context context) {
        this.f45650a = context;
        this.f45651b = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f45655f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f45655f;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f45652c = 2;
    }

    public void q() {
        Handler handler = this.f45656g;
        if (handler != null) {
            handler.post(new d());
            this.f45656g.removeCallbacks(this.i);
            if (m) {
                Log.d("ToastCustom", QueryResponse.Options.CANCEL);
            }
        }
    }

    public final WindowManager.LayoutParams r() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.b.g0.a.q1.b.f.d.c(this.f45650a);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }

    public void s(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.f45652c = i;
    }

    public void t(int i, int i2, int i3) {
        WindowManager.LayoutParams layoutParams = this.f45655f;
        if (layoutParams != null) {
            layoutParams.gravity = i;
            layoutParams.x = i2;
            layoutParams.y = i3;
        }
    }

    public void u(boolean z) {
        this.j = z;
    }

    public void v(@Nullable d.a aVar) {
        if (this.f45654e != null) {
            View$OnClickListenerC0768b view$OnClickListenerC0768b = new View$OnClickListenerC0768b(aVar);
            this.f45654e.setClickable(true);
            View findViewById = this.f45654e.findViewById(f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(view$OnClickListenerC0768b);
            } else {
                this.f45654e.setOnClickListener(view$OnClickListenerC0768b);
            }
        }
    }

    public void w(@NonNull View view) {
        this.f45654e = view;
        view.setClickable(true);
    }

    public void x(@StyleRes int i) {
        WindowManager.LayoutParams layoutParams = this.f45655f;
        if (layoutParams != null) {
            layoutParams.windowAnimations = i;
        }
    }

    public void y(int i) {
        WindowManager.LayoutParams layoutParams = this.f45655f;
        if (layoutParams != null) {
            layoutParams.type = i;
        }
    }

    public void z() {
        Runnable runnable = this.f45657h;
        if (runnable != null) {
            this.f45656g.removeCallbacks(runnable);
        }
        c cVar = new c();
        this.f45657h = cVar;
        this.f45656g.post(cVar);
    }
}
