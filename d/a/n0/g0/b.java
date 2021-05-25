package d.a.n0.g0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends d.a.n0.g0.a {

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f54907h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1340b f54908i;

    /* renamed from: d.a.n0.g0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1340b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f54909e;

        public c() {
            this.f54909e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.f54908i != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.f54909e && scaleFactor > 1.0f) {
                    this.f54909e = true;
                    b.this.f54908i.a(true);
                } else if (!this.f54909e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.f54909e = true;
                    b.this.f54908i.a(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f54909e = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f54909e = true;
        }
    }

    public b(Context context) {
        this.f54907h = new ScaleGestureDetector(context, new c());
    }

    @Override // d.a.n0.g0.a
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f54907h.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void i(InterfaceC1340b interfaceC1340b) {
        this.f54908i = interfaceC1340b;
    }
}
