package d.a.h0.g.k0.i.b;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import d.a.h0.a.g;
@UiThread
/* loaded from: classes3.dex */
public class a implements d.a.h0.g.k0.i.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f46482e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.k0.i.e.a f46483f;

    /* renamed from: g  reason: collision with root package name */
    public b f46484g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f46485h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f46486i;
    public int j;
    public boolean k;
    public ObjectAnimator l;
    public d m;

    /* renamed from: d.a.h0.g.k0.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0946a extends Handler {
        public HandlerC0946a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            int f2 = a.this.f();
            if (f2 > 0 && a.this.k) {
                a.this.f46485h.sendEmptyMessageDelayed(1, f2);
            }
            a.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b();

        void q();

        void w(int i2);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.f46482e = context;
        this.m = dVar;
        j(i());
        h();
        b();
    }

    @NonNull
    public static a c(int i2, @NonNull Context context, @NonNull d dVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                return new d.a.h0.g.k0.i.c.a(context, dVar);
            }
            return new d.a.h0.g.k0.i.d.a(context, dVar);
        }
        return new d.a.h0.g.k0.i.c.a(context, dVar);
    }

    public final void b() {
        this.f46486i.setVisibility(8);
        d.a.h0.g.k0.c.a(this.f46486i, g());
    }

    public final ObjectAnimator d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f46486i, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    @Override // d.a.h0.g.k0.i.a
    public void destroy() {
        this.k = false;
        this.f46485h.removeCallbacksAndMessages(null);
        d.a.h0.g.k0.c.d(this.f46486i);
    }

    @Override // d.a.h0.g.k0.i.b.b
    public void e(d.a.h0.g.k0.i.e.a aVar) {
        this.f46483f = aVar;
    }

    public int f() {
        return 5000;
    }

    public final d.a.h0.a.e1.d.a.a g() {
        d.a.h0.a.e1.d.a.a aVar = new d.a.h0.a.e1.d.a.a();
        aVar.m(d.a.h0.g.i0.e.a(this.m.left) - this.j);
        aVar.n(d.a.h0.g.i0.e.a(this.m.top) - this.j);
        aVar.o(-2);
        aVar.k(-2);
        return aVar;
    }

    public final void h() {
        this.l = d();
        this.f46485h = new HandlerC0946a(Looper.getMainLooper());
    }

    @Override // d.a.h0.g.k0.i.a
    public void hide() {
        this.k = false;
        this.f46485h.removeMessages(1);
        this.f46486i.setVisibility(8);
    }

    public View i() {
        return LayoutInflater.from(this.f46482e).inflate(g.swangame_recommend_button, (ViewGroup) null);
    }

    public final void j(View view) {
        this.j = (int) this.f46482e.getResources().getDimension(d.a.h0.a.d.swangame_recommend_button_root_padding);
        this.f46486i = new FrameLayout(this.f46482e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.a.h0.g.i0.e.a(this.m.width), d.a.h0.g.i0.e.a(this.m.height));
        int i2 = this.j;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.f46486i.setBackgroundColor(0);
        this.f46486i.addView(view, layoutParams);
    }

    public void k() {
        this.l.start();
    }

    @Override // d.a.h0.g.k0.i.b.b
    public void o(boolean z) {
        if (this.k) {
            this.f46485h.removeMessages(1);
            if (z) {
                this.f46485h.sendEmptyMessage(1);
            }
        }
    }

    @Override // d.a.h0.g.k0.i.a
    public void show() {
        this.k = true;
        this.f46486i.setVisibility(0);
        this.f46485h.removeMessages(1);
        this.f46485h.sendEmptyMessage(1);
    }

    @Override // d.a.h0.g.k0.i.b.b
    public void v(b bVar) {
        this.f46484g = bVar;
    }
}
