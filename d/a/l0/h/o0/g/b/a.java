package d.a.l0.h.o0.g.b;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
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
import d.a.l0.f.f;
import d.a.l0.h.m0.g;
@UiThread
/* loaded from: classes3.dex */
public class a implements d.a.l0.h.o0.g.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f47588e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.h.o0.g.e.a f47589f;

    /* renamed from: g  reason: collision with root package name */
    public b f47590g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f47591h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f47592i;
    public int j;
    public boolean k;
    public ObjectAnimator l;
    public d m;

    /* renamed from: d.a.l0.h.o0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1042a extends Handler {
        public HandlerC1042a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            int f2 = a.this.f();
            if (f2 > 0 && a.this.k) {
                a.this.f47591h.sendEmptyMessageDelayed(1, f2);
            }
            a.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b();

        void p();

        void v(int i2);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.f47588e = context;
        this.m = dVar;
        j(i());
        h();
        b();
    }

    @NonNull
    public static a c(int i2, @NonNull Context context, @NonNull d dVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                return new d.a.l0.h.o0.g.c.a(context, dVar);
            }
            return new d.a.l0.h.o0.g.d.a(context, dVar);
        }
        return new d.a.l0.h.o0.g.c.a(context, dVar);
    }

    public final void b() {
        this.f47592i.setVisibility(8);
        d.a.l0.h.o0.b.a(this.f47592i, g());
    }

    @Override // d.a.l0.h.o0.g.b.b
    public void d(d.a.l0.h.o0.g.e.a aVar) {
        this.f47589f = aVar;
    }

    @Override // d.a.l0.h.o0.g.a
    public void destroy() {
        this.k = false;
        this.f47591h.removeCallbacksAndMessages(null);
        d.a.l0.h.o0.b.d(this.f47592i);
    }

    public final ObjectAnimator e() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f47592i, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    public int f() {
        return 5000;
    }

    public final d.a.l0.a.l1.e.a.a g() {
        d.a.l0.a.l1.e.a.a aVar = new d.a.l0.a.l1.e.a.a();
        aVar.m(g.a(this.m.left) - this.j);
        aVar.n(g.a(this.m.top) - this.j);
        aVar.o(-2);
        aVar.k(-2);
        return aVar;
    }

    public final void h() {
        this.l = e();
        this.f47591h = new HandlerC1042a(Looper.getMainLooper());
    }

    @Override // d.a.l0.h.o0.g.a
    public void hide() {
        this.k = false;
        this.f47591h.removeMessages(1);
        this.f47592i.setVisibility(8);
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        return LayoutInflater.from(this.f47588e).inflate(f.swangame_recommend_button, (ViewGroup) null);
    }

    public final void j(View view) {
        this.j = (int) this.f47588e.getResources().getDimension(d.a.l0.f.c.swangame_recommend_button_root_padding);
        this.f47592i = new FrameLayout(this.f47588e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g.a(this.m.width), g.a(this.m.height));
        int i2 = this.j;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.f47592i.setBackgroundColor(0);
        this.f47592i.addView(view, layoutParams);
    }

    public void k() {
        this.l.start();
    }

    @Override // d.a.l0.h.o0.g.b.b
    public void m(boolean z) {
        if (this.k) {
            this.f47591h.removeMessages(1);
            if (z) {
                this.f47591h.sendEmptyMessage(1);
            }
        }
    }

    @Override // d.a.l0.h.o0.g.a
    public void show() {
        this.k = true;
        this.f47592i.setVisibility(0);
        this.f47591h.removeMessages(1);
        this.f47591h.sendEmptyMessage(1);
    }

    @Override // d.a.l0.h.o0.g.b.b
    public void u(b bVar) {
        this.f47590g = bVar;
    }
}
