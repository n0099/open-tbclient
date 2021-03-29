package d.b.i0.f0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends d.b.i0.f0.a {

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f54619h;
    public InterfaceC1245b i;

    /* renamed from: d.b.i0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1245b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f54620e;

        public c() {
            this.f54620e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.i != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.f54620e && scaleFactor > 1.0f) {
                    this.f54620e = true;
                    b.this.i.a(true);
                } else if (!this.f54620e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.f54620e = true;
                    b.this.i.a(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f54620e = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f54620e = true;
        }
    }

    public b(Context context) {
        this.f54619h = new ScaleGestureDetector(context, new c());
    }

    @Override // d.b.i0.f0.a
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f54619h.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void i(InterfaceC1245b interfaceC1245b) {
        this.i = interfaceC1245b;
    }
}
