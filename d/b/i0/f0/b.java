package d.b.i0.f0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends d.b.i0.f0.a {

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f55717h;
    public InterfaceC1288b i;

    /* renamed from: d.b.i0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1288b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f55718e;

        public c() {
            this.f55718e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.i != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.f55718e && scaleFactor > 1.0f) {
                    this.f55718e = true;
                    b.this.i.a(true);
                } else if (!this.f55718e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.f55718e = true;
                    b.this.i.a(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f55718e = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f55718e = true;
        }
    }

    public b(Context context) {
        this.f55717h = new ScaleGestureDetector(context, new c());
    }

    @Override // d.b.i0.f0.a
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f55717h.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void i(InterfaceC1288b interfaceC1288b) {
        this.i = interfaceC1288b;
    }
}
