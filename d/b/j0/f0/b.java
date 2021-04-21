package d.b.j0.f0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends d.b.j0.f0.a {

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f56138h;
    public InterfaceC1311b i;

    /* renamed from: d.b.j0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1311b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f56139e;

        public c() {
            this.f56139e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.i != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.f56139e && scaleFactor > 1.0f) {
                    this.f56139e = true;
                    b.this.i.a(true);
                } else if (!this.f56139e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.f56139e = true;
                    b.this.i.a(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f56139e = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f56139e = true;
        }
    }

    public b(Context context) {
        this.f56138h = new ScaleGestureDetector(context, new c());
    }

    @Override // d.b.j0.f0.a
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f56138h.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void i(InterfaceC1311b interfaceC1311b) {
        this.i = interfaceC1311b;
    }
}
