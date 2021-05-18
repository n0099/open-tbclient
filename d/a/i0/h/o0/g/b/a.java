package d.a.i0.h.o0.g.b;

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
import d.a.i0.f.f;
import d.a.i0.h.m0.g;
@UiThread
/* loaded from: classes3.dex */
public class a implements d.a.i0.h.o0.g.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f47412e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.h.o0.g.e.a f47413f;

    /* renamed from: g  reason: collision with root package name */
    public b f47414g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f47415h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f47416i;
    public int j;
    public boolean k;
    public ObjectAnimator l;
    public d m;

    /* renamed from: d.a.i0.h.o0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1031a extends Handler {
        public HandlerC1031a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            int f2 = a.this.f();
            if (f2 > 0 && a.this.k) {
                a.this.f47415h.sendEmptyMessageDelayed(1, f2);
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
        this.f47412e = context;
        this.m = dVar;
        j(i());
        h();
        b();
    }

    @NonNull
    public static a c(int i2, @NonNull Context context, @NonNull d dVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                return new d.a.i0.h.o0.g.c.a(context, dVar);
            }
            return new d.a.i0.h.o0.g.d.a(context, dVar);
        }
        return new d.a.i0.h.o0.g.c.a(context, dVar);
    }

    public final void b() {
        this.f47416i.setVisibility(8);
        d.a.i0.h.o0.b.a(this.f47416i, g());
    }

    @Override // d.a.i0.h.o0.g.b.b
    public void d(d.a.i0.h.o0.g.e.a aVar) {
        this.f47413f = aVar;
    }

    @Override // d.a.i0.h.o0.g.a
    public void destroy() {
        this.k = false;
        this.f47415h.removeCallbacksAndMessages(null);
        d.a.i0.h.o0.b.d(this.f47416i);
    }

    public final ObjectAnimator e() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f47416i, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    public int f() {
        return 5000;
    }

    public final d.a.i0.a.l1.e.a.a g() {
        d.a.i0.a.l1.e.a.a aVar = new d.a.i0.a.l1.e.a.a();
        aVar.m(g.a(this.m.left) - this.j);
        aVar.n(g.a(this.m.top) - this.j);
        aVar.o(-2);
        aVar.k(-2);
        return aVar;
    }

    public final void h() {
        this.l = e();
        this.f47415h = new HandlerC1031a(Looper.getMainLooper());
    }

    @Override // d.a.i0.h.o0.g.a
    public void hide() {
        this.k = false;
        this.f47415h.removeMessages(1);
        this.f47416i.setVisibility(8);
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        return LayoutInflater.from(this.f47412e).inflate(f.swangame_recommend_button, (ViewGroup) null);
    }

    public final void j(View view) {
        this.j = (int) this.f47412e.getResources().getDimension(d.a.i0.f.c.swangame_recommend_button_root_padding);
        this.f47416i = new FrameLayout(this.f47412e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g.a(this.m.width), g.a(this.m.height));
        int i2 = this.j;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.f47416i.setBackgroundColor(0);
        this.f47416i.addView(view, layoutParams);
    }

    public void k() {
        this.l.start();
    }

    @Override // d.a.i0.h.o0.g.b.b
    public void m(boolean z) {
        if (this.k) {
            this.f47415h.removeMessages(1);
            if (z) {
                this.f47415h.sendEmptyMessage(1);
            }
        }
    }

    @Override // d.a.i0.h.o0.g.a
    public void show() {
        this.k = true;
        this.f47416i.setVisibility(0);
        this.f47415h.removeMessages(1);
        this.f47415h.sendEmptyMessage(1);
    }

    @Override // d.a.i0.h.o0.g.b.b
    public void u(b bVar) {
        this.f47414g = bVar;
    }
}
