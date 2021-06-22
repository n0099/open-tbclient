package d.a.o0.g0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends d.a.o0.g0.a {

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f58721h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1400b f58722i;

    /* renamed from: d.a.o0.g0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1400b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f58723e;

        public c() {
            this.f58723e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.f58722i != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.f58723e && scaleFactor > 1.0f) {
                    this.f58723e = true;
                    b.this.f58722i.a(true);
                } else if (!this.f58723e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.f58723e = true;
                    b.this.f58722i.a(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f58723e = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f58723e = true;
        }
    }

    public b(Context context) {
        this.f58721h = new ScaleGestureDetector(context, new c());
    }

    @Override // d.a.o0.g0.a
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f58721h.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void i(InterfaceC1400b interfaceC1400b) {
        this.f58722i = interfaceC1400b;
    }
}
