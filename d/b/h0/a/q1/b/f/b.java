package d.b.h0.a.q1.b.f;

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
import d.b.h0.a.f;
import d.b.h0.a.i;
import d.b.h0.a.k;
import d.b.h0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class b {
    public static final boolean m = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public Context f46372a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f46373b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f46374c;

    /* renamed from: d  reason: collision with root package name */
    public View f46375d;

    /* renamed from: e  reason: collision with root package name */
    public View f46376e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f46377f;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f46379h;
    public boolean j;
    public View k;
    public View l;

    /* renamed from: g  reason: collision with root package name */
    public Handler f46378g = new Handler(Looper.getMainLooper());
    public Runnable i = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46375d != null) {
                if (b.this.f46375d.getParent() != null) {
                    b.this.f46373b.removeView(b.this.f46375d);
                }
                b.this.f46375d = null;
            }
            if (b.this.k != null) {
                if (b.this.k.getParent() != null) {
                    b.this.f46373b.removeView(b.this.k);
                }
                b.this.k = null;
            }
        }
    }

    /* renamed from: d.b.h0.a.q1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0801b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a f46381e;

        public View$OnClickListenerC0801b(d.a aVar) {
            this.f46381e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a aVar = this.f46381e;
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
                    b.this.l = new FrameLayout(b.this.f46372a);
                    b.this.l.setClickable(true);
                    b.this.f46373b.addView(b.this.l, r);
                    b.this.k = b.this.l;
                }
                if (b.this.f46376e != null && (b.this.f46376e.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) b.this.f46376e.getParent()).removeView(b.this.f46376e);
                }
                b.this.f46373b.addView(b.this.f46376e, b.this.f46377f);
                b.this.f46375d = b.this.f46376e;
                b.this.f46378g.postDelayed(b.this.i, b.this.f46374c * 1000);
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
                if (b.this.f46375d != null) {
                    if (b.this.f46375d.getParent() != null) {
                        b.this.f46373b.removeViewImmediate(b.this.f46375d);
                    }
                    if (b.m) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    b.this.f46375d = null;
                }
                if (b.this.k != null) {
                    if (b.this.k.getParent() != null) {
                        b.this.f46373b.removeViewImmediate(b.this.k);
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
        this.f46372a = context;
        this.f46373b = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f46377f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f46377f;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f46374c = 2;
    }

    public void q() {
        Handler handler = this.f46378g;
        if (handler != null) {
            handler.post(new d());
            this.f46378g.removeCallbacks(this.i);
            if (m) {
                Log.d("ToastCustom", QueryResponse.Options.CANCEL);
            }
        }
    }

    public final WindowManager.LayoutParams r() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.b.h0.a.q1.b.f.d.c(this.f46372a);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }

    public void s(int i) {
        if (i <= 0) {
            i = 2;
        }
        this.f46374c = i;
    }

    public void t(int i, int i2, int i3) {
        WindowManager.LayoutParams layoutParams = this.f46377f;
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
        if (this.f46376e != null) {
            View$OnClickListenerC0801b view$OnClickListenerC0801b = new View$OnClickListenerC0801b(aVar);
            this.f46376e.setClickable(true);
            View findViewById = this.f46376e.findViewById(f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(view$OnClickListenerC0801b);
            } else {
                this.f46376e.setOnClickListener(view$OnClickListenerC0801b);
            }
        }
    }

    public void w(@NonNull View view) {
        this.f46376e = view;
        view.setClickable(true);
    }

    public void x(@StyleRes int i) {
        WindowManager.LayoutParams layoutParams = this.f46377f;
        if (layoutParams != null) {
            layoutParams.windowAnimations = i;
        }
    }

    public void y(int i) {
        WindowManager.LayoutParams layoutParams = this.f46377f;
        if (layoutParams != null) {
            layoutParams.type = i;
        }
    }

    public void z() {
        Runnable runnable = this.f46379h;
        if (runnable != null) {
            this.f46378g.removeCallbacks(runnable);
        }
        c cVar = new c();
        this.f46379h = cVar;
        this.f46378g.post(cVar);
    }
}
