package d.a.j0.f0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends d.a.j0.f0.a {

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f54012h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1250b f54013i;

    /* renamed from: d.a.j0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1250b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f54014e;

        public c() {
            this.f54014e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.f54013i != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.f54014e && scaleFactor > 1.0f) {
                    this.f54014e = true;
                    b.this.f54013i.a(true);
                } else if (!this.f54014e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.f54014e = true;
                    b.this.f54013i.a(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f54014e = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f54014e = true;
        }
    }

    public b(Context context) {
        this.f54012h = new ScaleGestureDetector(context, new c());
    }

    @Override // d.a.j0.f0.a
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f54012h.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void i(InterfaceC1250b interfaceC1250b) {
        this.f54013i = interfaceC1250b;
    }
}
