package d.a.h0.a.q1.b.f;

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
import d.a.h0.a.f;
import d.a.h0.a.i;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class b {
    public static final boolean m = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Context f43729a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f43730b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f43731c;

    /* renamed from: d  reason: collision with root package name */
    public View f43732d;

    /* renamed from: e  reason: collision with root package name */
    public View f43733e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f43734f;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f43736h;
    public boolean j;
    public View k;
    public View l;

    /* renamed from: g  reason: collision with root package name */
    public Handler f43735g = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    public Runnable f43737i = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f43732d != null) {
                if (b.this.f43732d.getParent() != null) {
                    b.this.f43730b.removeView(b.this.f43732d);
                }
                b.this.f43732d = null;
            }
            if (b.this.k != null) {
                if (b.this.k.getParent() != null) {
                    b.this.f43730b.removeView(b.this.k);
                }
                b.this.k = null;
            }
        }
    }

    /* renamed from: d.a.h0.a.q1.b.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0740b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a f43739e;

        public View$OnClickListenerC0740b(d.a aVar) {
            this.f43739e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a aVar = this.f43739e;
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
                    b.this.l = new FrameLayout(b.this.f43729a);
                    b.this.l.setClickable(true);
                    b.this.f43730b.addView(b.this.l, r);
                    b.this.k = b.this.l;
                }
                if (b.this.f43733e != null && (b.this.f43733e.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) b.this.f43733e.getParent()).removeView(b.this.f43733e);
                }
                b.this.f43730b.addView(b.this.f43733e, b.this.f43734f);
                b.this.f43732d = b.this.f43733e;
                b.this.f43735g.postDelayed(b.this.f43737i, b.this.f43731c * 1000);
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
                if (b.this.f43732d != null) {
                    if (b.this.f43732d.getParent() != null) {
                        b.this.f43730b.removeViewImmediate(b.this.f43732d);
                    }
                    if (b.m) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    b.this.f43732d = null;
                }
                if (b.this.k != null) {
                    if (b.this.k.getParent() != null) {
                        b.this.f43730b.removeViewImmediate(b.this.k);
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
        this.f43729a = context;
        this.f43730b = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f43734f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f43734f;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f43731c = 2;
    }

    public void q() {
        Handler handler = this.f43735g;
        if (handler != null) {
            handler.post(new d());
            this.f43735g.removeCallbacks(this.f43737i);
            if (m) {
                Log.d("ToastCustom", QueryResponse.Options.CANCEL);
            }
        }
    }

    public final WindowManager.LayoutParams r() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.verticalMargin = d.a.h0.a.q1.b.f.d.c(this.f43729a);
        layoutParams.flags = 2176;
        layoutParams.type = 2005;
        return layoutParams;
    }

    public void s(int i2) {
        if (i2 <= 0) {
            i2 = 2;
        }
        this.f43731c = i2;
    }

    public void t(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams = this.f43734f;
        if (layoutParams != null) {
            layoutParams.gravity = i2;
            layoutParams.x = i3;
            layoutParams.y = i4;
        }
    }

    public void u(boolean z) {
        this.j = z;
    }

    public void v(@Nullable d.a aVar) {
        if (this.f43733e != null) {
            View$OnClickListenerC0740b view$OnClickListenerC0740b = new View$OnClickListenerC0740b(aVar);
            this.f43733e.setClickable(true);
            View findViewById = this.f43733e.findViewById(f.clickable_toast_click_area);
            if (findViewById != null) {
                findViewById.setOnClickListener(view$OnClickListenerC0740b);
            } else {
                this.f43733e.setOnClickListener(view$OnClickListenerC0740b);
            }
        }
    }

    public void w(@NonNull View view) {
        this.f43733e = view;
        view.setClickable(true);
    }

    public void x(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams = this.f43734f;
        if (layoutParams != null) {
            layoutParams.windowAnimations = i2;
        }
    }

    public void y(int i2) {
        WindowManager.LayoutParams layoutParams = this.f43734f;
        if (layoutParams != null) {
            layoutParams.type = i2;
        }
    }

    public void z() {
        Runnable runnable = this.f43736h;
        if (runnable != null) {
            this.f43735g.removeCallbacks(runnable);
        }
        c cVar = new c();
        this.f43736h = cVar;
        this.f43735g.post(cVar);
    }
}
