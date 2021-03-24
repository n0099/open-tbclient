package d.b.g0.g.k0.i.b;

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
import d.b.g0.a.g;
@UiThread
/* loaded from: classes3.dex */
public class a implements d.b.g0.g.k0.i.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f48284e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.k0.i.e.a f48285f;

    /* renamed from: g  reason: collision with root package name */
    public b f48286g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f48287h;
    public ViewGroup i;
    public int j;
    public boolean k;
    public ObjectAnimator l;
    public d m;

    /* renamed from: d.b.g0.g.k0.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0974a extends Handler {
        public HandlerC0974a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            int e2 = a.this.e();
            if (e2 > 0 && a.this.k) {
                a.this.f48287h.sendEmptyMessageDelayed(1, e2);
            }
            a.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void c();

        void d();

        void s(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        this.f48284e = context;
        this.m = dVar;
        j(i());
        g();
        b();
    }

    @NonNull
    public static a c(int i, @NonNull Context context, @NonNull d dVar) {
        if (i != 1) {
            if (i != 2) {
                return new d.b.g0.g.k0.i.c.a(context, dVar);
            }
            return new d.b.g0.g.k0.i.d.a(context, dVar);
        }
        return new d.b.g0.g.k0.i.c.a(context, dVar);
    }

    public final void b() {
        this.i.setVisibility(8);
        d.b.g0.g.k0.c.a(this.i, f());
    }

    public final ObjectAnimator d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.i, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    @Override // d.b.g0.g.k0.i.a
    public void destroy() {
        this.k = false;
        this.f48287h.removeCallbacksAndMessages(null);
        d.b.g0.g.k0.c.d(this.i);
    }

    public int e() {
        return 5000;
    }

    public final d.b.g0.a.e1.d.a.a f() {
        d.b.g0.a.e1.d.a.a aVar = new d.b.g0.a.e1.d.a.a();
        aVar.m(d.b.g0.g.i0.e.a(this.m.left) - this.j);
        aVar.n(d.b.g0.g.i0.e.a(this.m.top) - this.j);
        aVar.o(-2);
        aVar.k(-2);
        return aVar;
    }

    public final void g() {
        this.l = d();
        this.f48287h = new HandlerC0974a(Looper.getMainLooper());
    }

    @Override // d.b.g0.g.k0.i.b.b
    public void h(d.b.g0.g.k0.i.e.a aVar) {
        this.f48285f = aVar;
    }

    @Override // d.b.g0.g.k0.i.a
    public void hide() {
        this.k = false;
        this.f48287h.removeMessages(1);
        this.i.setVisibility(8);
    }

    public View i() {
        return LayoutInflater.from(this.f48284e).inflate(g.swangame_recommend_button, (ViewGroup) null);
    }

    public final void j(View view) {
        this.j = (int) this.f48284e.getResources().getDimension(d.b.g0.a.d.swangame_recommend_button_root_padding);
        this.i = new FrameLayout(this.f48284e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.b.g0.g.i0.e.a(this.m.width), d.b.g0.g.i0.e.a(this.m.height));
        int i = this.j;
        layoutParams.setMargins(i, i, i, i);
        this.i.setBackgroundColor(0);
        this.i.addView(view, layoutParams);
    }

    public void k() {
        this.l.start();
    }

    @Override // d.b.g0.g.k0.i.b.b
    public void o(b bVar) {
        this.f48286g = bVar;
    }

    @Override // d.b.g0.g.k0.i.a
    public void show() {
        this.k = true;
        this.i.setVisibility(0);
        this.f48287h.removeMessages(1);
        this.f48287h.sendEmptyMessage(1);
    }

    @Override // d.b.g0.g.k0.i.b.b
    public void z(boolean z) {
        if (this.k) {
            this.f48287h.removeMessages(1);
            if (z) {
                this.f48287h.sendEmptyMessage(1);
            }
        }
    }
}
