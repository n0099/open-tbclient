package d.b.j0.q3.m;

import android.hardware.Camera;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f61212a = 0;

    /* renamed from: b  reason: collision with root package name */
    public float f61213b;

    /* renamed from: c  reason: collision with root package name */
    public int f61214c;

    /* renamed from: d  reason: collision with root package name */
    public Camera f61215d;

    /* renamed from: e  reason: collision with root package name */
    public i f61216e;

    public b(Camera camera) {
        this.f61215d = camera;
    }

    public final int a() {
        Camera camera = this.f61215d;
        if (camera == null) {
            return -1;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            if (parameters.getMaxZoom() > 40) {
                return 40;
            }
            return parameters.getMaxZoom();
        }
        return -1;
    }

    public boolean b(MotionEvent motionEvent) {
        i iVar = this.f61216e;
        if (iVar == null || !iVar.j()) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f61212a = 0;
            } else if (action != 2) {
                if (action == 5) {
                    this.f61212a = 1;
                    this.f61213b = e(motionEvent);
                }
            } else if (this.f61212a != 1 || motionEvent.getPointerCount() < 2) {
                return true;
            } else {
                float e2 = e(motionEvent);
                int i = (int) ((e2 - this.f61213b) / 10.0f);
                if (i >= 1 || i <= -1) {
                    int i2 = this.f61214c + i;
                    if (i2 > a()) {
                        i2 = a();
                    }
                    d(i2 >= 0 ? i2 : 0);
                    this.f61213b = e2;
                }
            }
            return true;
        }
        return true;
    }

    public void c(i iVar) {
        this.f61216e = iVar;
    }

    public final void d(int i) {
        Camera camera = this.f61215d;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            parameters.setZoom(i);
            this.f61215d.setParameters(parameters);
            this.f61214c = i;
        }
    }

    public final float e(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return 0.0f;
        }
        double x = motionEvent.getX(0) - motionEvent.getX(1);
        double y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }
}
