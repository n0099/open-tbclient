package d.a.k0.q3.m;

import android.hardware.Camera;
import android.view.MotionEvent;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f60096a = 0;

    /* renamed from: b  reason: collision with root package name */
    public float f60097b;

    /* renamed from: c  reason: collision with root package name */
    public int f60098c;

    /* renamed from: d  reason: collision with root package name */
    public Camera f60099d;

    /* renamed from: e  reason: collision with root package name */
    public i f60100e;

    public b(Camera camera) {
        this.f60099d = camera;
    }

    public final int a() {
        Camera camera = this.f60099d;
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
        i iVar = this.f60100e;
        if (iVar == null || !iVar.j()) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f60096a = 0;
            } else if (action != 2) {
                if (action == 5) {
                    this.f60096a = 1;
                    this.f60097b = e(motionEvent);
                }
            } else if (this.f60096a != 1 || motionEvent.getPointerCount() < 2) {
                return true;
            } else {
                float e2 = e(motionEvent);
                int i2 = (int) ((e2 - this.f60097b) / 10.0f);
                if (i2 >= 1 || i2 <= -1) {
                    int i3 = this.f60098c + i2;
                    if (i3 > a()) {
                        i3 = a();
                    }
                    d(i3 >= 0 ? i3 : 0);
                    this.f60097b = e2;
                }
            }
            return true;
        }
        return true;
    }

    public void c(i iVar) {
        this.f60100e = iVar;
    }

    public final void d(int i2) {
        Camera camera = this.f60099d;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.isZoomSupported()) {
            parameters.setZoom(i2);
            this.f60099d.setParameters(parameters);
            this.f60098c = i2;
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
