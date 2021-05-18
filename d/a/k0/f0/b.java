package d.a.k0.f0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
/* loaded from: classes4.dex */
public class b extends d.a.k0.f0.a {

    /* renamed from: h  reason: collision with root package name */
    public ScaleGestureDetector f54719h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1322b f54720i;

    /* renamed from: d.a.k0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1322b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f54721e;

        public c() {
            this.f54721e = false;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && b.this.f54720i != null) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!this.f54721e && scaleFactor > 1.0f) {
                    this.f54721e = true;
                    b.this.f54720i.a(true);
                } else if (!this.f54721e && scaleFactor > 0.0f && scaleFactor < 1.0f) {
                    this.f54721e = true;
                    b.this.f54720i.a(false);
                }
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f54721e = false;
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f54721e = true;
        }
    }

    public b(Context context) {
        this.f54719h = new ScaleGestureDetector(context, new c());
    }

    @Override // d.a.k0.f0.a
    public boolean c(MotionEvent motionEvent) {
        try {
            this.f54719h.onTouchEvent(motionEvent);
            return super.c(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void i(InterfaceC1322b interfaceC1322b) {
        this.f54720i = interfaceC1322b;
    }
}
