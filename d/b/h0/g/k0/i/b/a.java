package d.b.h0.g.k0.i.b;

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
import d.b.h0.a.g;
@UiThread
/* loaded from: classes3.dex */
public class a implements d.b.h0.g.k0.i.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f49006e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g.k0.i.e.a f49007f;

    /* renamed from: g  reason: collision with root package name */
    public b f49008g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f49009h;
    public ViewGroup i;
    public int j;
    public boolean k;
    public ObjectAnimator l;
    public d m;

    /* renamed from: d.b.h0.g.k0.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC1007a extends Handler {
        public HandlerC1007a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            int e2 = a.this.e();
            if (e2 > 0 && a.this.k) {
                a.this.f49009h.sendEmptyMessageDelayed(1, e2);
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
        this.f49006e = context;
        this.m = dVar;
        j(i());
        g();
        b();
    }

    @NonNull
    public static a c(int i, @NonNull Context context, @NonNull d dVar) {
        if (i != 1) {
            if (i != 2) {
                return new d.b.h0.g.k0.i.c.a(context, dVar);
            }
            return new d.b.h0.g.k0.i.d.a(context, dVar);
        }
        return new d.b.h0.g.k0.i.c.a(context, dVar);
    }

    public final void b() {
        this.i.setVisibility(8);
        d.b.h0.g.k0.c.a(this.i, f());
    }

    public final ObjectAnimator d() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.i, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(600L);
        return ofPropertyValuesHolder;
    }

    @Override // d.b.h0.g.k0.i.a
    public void destroy() {
        this.k = false;
        this.f49009h.removeCallbacksAndMessages(null);
        d.b.h0.g.k0.c.d(this.i);
    }

    public int e() {
        return 5000;
    }

    public final d.b.h0.a.e1.d.a.a f() {
        d.b.h0.a.e1.d.a.a aVar = new d.b.h0.a.e1.d.a.a();
        aVar.m(d.b.h0.g.i0.e.a(this.m.left) - this.j);
        aVar.n(d.b.h0.g.i0.e.a(this.m.top) - this.j);
        aVar.o(-2);
        aVar.k(-2);
        return aVar;
    }

    public final void g() {
        this.l = d();
        this.f49009h = new HandlerC1007a(Looper.getMainLooper());
    }

    @Override // d.b.h0.g.k0.i.b.b
    public void h(d.b.h0.g.k0.i.e.a aVar) {
        this.f49007f = aVar;
    }

    @Override // d.b.h0.g.k0.i.a
    public void hide() {
        this.k = false;
        this.f49009h.removeMessages(1);
        this.i.setVisibility(8);
    }

    public View i() {
        return LayoutInflater.from(this.f49006e).inflate(g.swangame_recommend_button, (ViewGroup) null);
    }

    public final void j(View view) {
        this.j = (int) this.f49006e.getResources().getDimension(d.b.h0.a.d.swangame_recommend_button_root_padding);
        this.i = new FrameLayout(this.f49006e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.b.h0.g.i0.e.a(this.m.width), d.b.h0.g.i0.e.a(this.m.height));
        int i = this.j;
        layoutParams.setMargins(i, i, i, i);
        this.i.setBackgroundColor(0);
        this.i.addView(view, layoutParams);
    }

    public void k() {
        this.l.start();
    }

    @Override // d.b.h0.g.k0.i.b.b
    public void o(b bVar) {
        this.f49008g = bVar;
    }

    @Override // d.b.h0.g.k0.i.a
    public void show() {
        this.k = true;
        this.i.setVisibility(0);
        this.f49009h.removeMessages(1);
        this.f49009h.sendEmptyMessage(1);
    }

    @Override // d.b.h0.g.k0.i.b.b
    public void z(boolean z) {
        if (this.k) {
            this.f49009h.removeMessages(1);
            if (z) {
                this.f49009h.sendEmptyMessage(1);
            }
        }
    }
}
