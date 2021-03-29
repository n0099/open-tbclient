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
/* loaded from: classes2.dex */
public class b {
    public static final boolean m = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45651a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f45652b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f45653c;

    /* renamed from: d  reason: collision with root package name */
    public View f45654d;

    /* renamed from: e  reason: collision with root package name */
    public View f45655e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f45656f;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f45658h;
    public boolean j;
    public View k;
    public View l;

    /* renamed from: g  reason: collision with root package name */
    public Handler f45657g = new Handler(Looper.getMainLooper());
    public Runnable i = new a();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f45654d != null) {
                if (b.this.f45654d.getParent() != null) {
                    b.this.f45652b.removeView(b.this.f45654d);
                }
                b.this.f45654d = null;
            }
            if (b.this.k != null) {
                if (b.this.k.getParent() != null) {
                    b.this.f45652b.removeView(b.this.k);
                }
                b.this.k = null;
            }
        }
    }

    /* renamed from: d.b.g0.a.q1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0769b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a f45660e;

        public View$OnClickListenerC0769b(d.a aVar) {
            this.f45660e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a aVar = this.f45660e;
            if (aVar != null) {
                aVar.a();
            }
            b.this.q();
        }
    }

    /* loaded from: classes2.dex */
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
                    b.this.l = new FrameLayout(b.this.f45651a);
                    b.this.l.setClickable(true);
                    b.this.f45652b.addView(b.this.l, r);
                    b.this.k = b.this.l;
                }
                if (b.this.f45655e != null && (b.this.f45655e.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) b.this.f45655e.getParent()).removeView(b.this.f45655e);
                }
                b.this.f45652b.addView(b.this.f45655e, b.this.f45656f);
                b.this.f45654d = b.this.f45655e;
                b.this.f45657g.postDelayed(b.this.i, b.this.f45653c * 1000);
                if (b.m) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                if (b.this.f45654d != null) {
                    if (b.this.f45654d.getParent() != null) {
                        b.this.f45652b.removeViewImmediate(b.this.f45654d);
                    }
                    if (b.m) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    b.this.f45654d = null;
                }
                if (b.this.k != null) {
                    if (b.this.k.getParent() != null) {
                        b.this.f45652b.removeViewImmediate(b.this.k);
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
        this.f45651a = context;
        this.f45652b = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f45656f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f45656f;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f45653c = 2;
    }

    public void q() {
        Handler handler = this.f45657g;
        if (handler != null) {
            handler.post(new d());
            this.f45657g.removeCallbacks(this.i);
            if (m) {
                Log.d("ToastCustom", QueryResponse.Options.CANCEL);
            }
        }
    }

    public final WindowManager.LayoutParams r() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.b.g0.a.q1.b.f.d.c(this.f45651a);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }

    public void s(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.f45653c = i;
    }

    public void t(int i, int i2, int i3) {
        WindowManager.LayoutParams layoutParams = this.f45656f;
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
        if (this.f45655e != null) {
            View$OnClickListenerC0769b view$OnClickListenerC0769b = new View$OnClickListenerC0769b(aVar);
            this.f45655e.setClickable(true);
            View findViewById = this.f45655e.findViewById(f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(view$OnClickListenerC0769b);
            } else {
                this.f45655e.setOnClickListener(view$OnClickListenerC0769b);
            }
        }
    }

    public void w(@NonNull View view) {
        this.f45655e = view;
        view.setClickable(true);
    }

    public void x(@StyleRes int i) {
        WindowManager.LayoutParams layoutParams = this.f45656f;
        if (layoutParams != null) {
            layoutParams.windowAnimations = i;
        }
    }

    public void y(int i) {
        WindowManager.LayoutParams layoutParams = this.f45656f;
        if (layoutParams != null) {
            layoutParams.type = i;
        }
    }

    public void z() {
        Runnable runnable = this.f45658h;
        if (runnable != null) {
            this.f45657g.removeCallbacks(runnable);
        }
        c cVar = new c();
        this.f45658h = cVar;
        this.f45657g.post(cVar);
    }
}
