package d.g.d.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.Matrix;
import android.view.Display;
import d.g.d.a.a.a.a;
import d.g.d.a.a.a.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class d implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final Display f70257a;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f70265i;
    public a l;
    public e m;
    public b n;
    public long o;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f70258b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    public final float[] f70259c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    public float f70260d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public final float[] f70261e = new float[16];

    /* renamed from: f  reason: collision with root package name */
    public final float[] f70262f = new float[16];

    /* renamed from: g  reason: collision with root package name */
    public final float[] f70263g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    public float f70264h = 1.0f;
    public final Object k = new Object();
    public volatile boolean p = true;
    public float[] q = new float[3];
    public final g r = new g();
    public final g s = new g();
    public final g t = new g();
    public final d.g.d.a.a.a.d j = new d.g.d.a.a.a.d();

    public d(e eVar, b bVar, Display display) {
        this.n = bVar;
        this.m = eVar;
        this.f70257a = display;
        b(true);
        Matrix.setIdentityM(this.f70261e, 0);
    }

    public void a() {
        if (this.f70265i) {
            return;
        }
        this.j.a();
        synchronized (this.k) {
            if (this.l != null) {
                this.l.a();
            }
        }
        this.p = true;
        this.m.b(this);
        this.m.a();
        this.f70265i = true;
    }

    public void b(boolean z) {
        synchronized (this.k) {
            if (!z) {
                this.l = null;
            } else if (this.l == null) {
                this.l = new a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(float[] fArr, int i2) {
        float f2;
        if (i2 + 16 > fArr.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        }
        int rotation = this.f70257a.getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                f2 = 90.0f;
            } else if (rotation == 2) {
                f2 = 180.0f;
            } else if (rotation == 3) {
                f2 = 270.0f;
            }
            if (f2 != this.f70260d) {
                this.f70260d = f2;
                Matrix.setRotateEulerM(this.f70259c, 0, 0.0f, 0.0f, -f2);
                Matrix.setRotateEulerM(this.f70258b, 0, -90.0f, 0.0f, f2);
            }
            synchronized (this.j) {
                if (this.j.i()) {
                    double[] e2 = this.j.e(TimeUnit.NANOSECONDS.toSeconds(this.n.a() - this.o) + 0.057999998331069946d);
                    for (int i3 = 0; i3 < fArr.length; i3++) {
                        this.f70262f[i3] = (float) e2[i3];
                    }
                    Matrix.multiplyMM(this.f70263g, 0, this.f70259c, 0, this.f70262f, 0);
                    Matrix.multiplyMM(fArr, i2, this.f70263g, 0, this.f70258b, 0);
                    Matrix.setIdentityM(this.f70261e, 0);
                    float[] fArr2 = this.f70261e;
                    float f3 = this.f70264h;
                    Matrix.translateM(fArr2, 0, 0.0f, (-f3) * 0.075f, f3 * 0.08f);
                    Matrix.multiplyMM(this.f70262f, 0, this.f70261e, 0, fArr, i2);
                    Matrix.translateM(fArr, i2, this.f70262f, 0, 0.0f, this.f70264h * 0.075f, 0.0f);
                    return;
                }
                return;
            }
        }
        f2 = 0.0f;
        if (f2 != this.f70260d) {
        }
        synchronized (this.j) {
        }
    }

    public void d() {
        if (this.f70265i) {
            this.m.a(this);
            this.m.b();
            this.f70265i = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            g gVar = this.t;
            float[] fArr = sensorEvent.values;
            gVar.d(fArr[0], fArr[1], fArr[2]);
            this.j.h(this.t, sensorEvent.timestamp);
            synchronized (this.k) {
                if (this.l != null) {
                    this.l.d(this.t, sensorEvent.timestamp);
                }
            }
        } else if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
            this.o = this.n.a();
            if (sensorEvent.sensor.getType() == 16) {
                if (this.p) {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2.length == 6) {
                        float[] fArr3 = this.q;
                        fArr3[0] = fArr2[3];
                        fArr3[1] = fArr2[4];
                        fArr3[2] = fArr2[5];
                    }
                }
                g gVar2 = this.s;
                float[] fArr4 = sensorEvent.values;
                float f2 = fArr4[0];
                float[] fArr5 = this.q;
                gVar2.d(f2 - fArr5[0], fArr4[1] - fArr5[1], fArr4[2] - fArr5[2]);
            } else {
                g gVar3 = this.s;
                float[] fArr6 = sensorEvent.values;
                gVar3.d(fArr6[0], fArr6[1], fArr6[2]);
            }
            this.p = false;
            synchronized (this.k) {
                if (this.l != null) {
                    this.l.c(this.s, sensorEvent.timestamp);
                    this.l.b(this.r);
                    g.k(this.s, this.r, this.s);
                }
            }
            this.j.d(this.s, sensorEvent.timestamp);
        }
    }
}
