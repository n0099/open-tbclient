package d.f.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.Matrix;
import android.view.Display;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.e.a.a.a.a;
import d.f.e.a.a.a.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class d implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Display f73903e;

    /* renamed from: f  reason: collision with root package name */
    public final float[] f73904f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f73905g;

    /* renamed from: h  reason: collision with root package name */
    public float f73906h;

    /* renamed from: i  reason: collision with root package name */
    public final float[] f73907i;
    public final float[] j;
    public final float[] k;
    public float l;
    public volatile boolean m;
    public final d.f.e.a.a.a.d n;
    public final Object o;
    public a p;
    public e q;
    public b r;
    public long s;
    public volatile boolean t;
    public float[] u;
    public final g v;
    public final g w;
    public final g x;

    public d(e eVar, b bVar, Display display) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, bVar, display};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73904f = new float[16];
        this.f73905g = new float[16];
        this.f73906h = -1.0f;
        this.f73907i = new float[16];
        this.j = new float[16];
        this.k = new float[16];
        this.l = 1.0f;
        this.o = new Object();
        this.t = true;
        this.u = new float[3];
        this.v = new g();
        this.w = new g();
        this.x = new g();
        this.r = bVar;
        this.q = eVar;
        this.n = new d.f.e.a.a.a.d();
        this.f73903e = display;
        b(true);
        Matrix.setIdentityM(this.f73907i, 0);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.m) {
            return;
        }
        this.n.a();
        synchronized (this.o) {
            if (this.p != null) {
                this.p.a();
            }
        }
        this.t = true;
        this.q.b(this);
        this.q.a();
        this.m = true;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (this.o) {
                if (!z) {
                    this.p = null;
                } else if (this.p == null) {
                    this.p = new a();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(float[] fArr, int i2) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, fArr, i2) != null) {
            return;
        }
        if (i2 + 16 > fArr.length) {
            throw new IllegalArgumentException("Not enough space to write the result");
        }
        int rotation = this.f73903e.getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                f2 = 90.0f;
            } else if (rotation == 2) {
                f2 = 180.0f;
            } else if (rotation == 3) {
                f2 = 270.0f;
            }
            if (f2 != this.f73906h) {
                this.f73906h = f2;
                Matrix.setRotateEulerM(this.f73905g, 0, 0.0f, 0.0f, -f2);
                Matrix.setRotateEulerM(this.f73904f, 0, -90.0f, 0.0f, f2);
            }
            synchronized (this.n) {
                if (this.n.i()) {
                    double[] e2 = this.n.e(TimeUnit.NANOSECONDS.toSeconds(this.r.a() - this.s) + 0.057999998331069946d);
                    for (int i3 = 0; i3 < fArr.length; i3++) {
                        this.j[i3] = (float) e2[i3];
                    }
                    Matrix.multiplyMM(this.k, 0, this.f73905g, 0, this.j, 0);
                    Matrix.multiplyMM(fArr, i2, this.k, 0, this.f73904f, 0);
                    Matrix.setIdentityM(this.f73907i, 0);
                    float[] fArr2 = this.f73907i;
                    float f3 = this.l;
                    Matrix.translateM(fArr2, 0, 0.0f, (-f3) * 0.075f, f3 * 0.08f);
                    Matrix.multiplyMM(this.j, 0, this.f73907i, 0, fArr, i2);
                    Matrix.translateM(fArr, i2, this.j, 0, 0.0f, this.l * 0.075f, 0.0f);
                    return;
                }
                return;
            }
        }
        f2 = 0.0f;
        if (f2 != this.f73906h) {
        }
        synchronized (this.n) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.m) {
            this.q.a(this);
            this.q.b();
            this.m = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sensorEvent) == null) {
            if (sensorEvent.sensor.getType() == 1) {
                g gVar = this.x;
                float[] fArr = sensorEvent.values;
                gVar.d(fArr[0], fArr[1], fArr[2]);
                this.n.h(this.x, sensorEvent.timestamp);
                synchronized (this.o) {
                    if (this.p != null) {
                        this.p.d(this.x, sensorEvent.timestamp);
                    }
                }
            } else if (sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 16) {
                this.s = this.r.a();
                if (sensorEvent.sensor.getType() == 16) {
                    if (this.t) {
                        float[] fArr2 = sensorEvent.values;
                        if (fArr2.length == 6) {
                            float[] fArr3 = this.u;
                            fArr3[0] = fArr2[3];
                            fArr3[1] = fArr2[4];
                            fArr3[2] = fArr2[5];
                        }
                    }
                    g gVar2 = this.w;
                    float[] fArr4 = sensorEvent.values;
                    float f2 = fArr4[0];
                    float[] fArr5 = this.u;
                    gVar2.d(f2 - fArr5[0], fArr4[1] - fArr5[1], fArr4[2] - fArr5[2]);
                } else {
                    g gVar3 = this.w;
                    float[] fArr6 = sensorEvent.values;
                    gVar3.d(fArr6[0], fArr6[1], fArr6[2]);
                }
                this.t = false;
                synchronized (this.o) {
                    if (this.p != null) {
                        this.p.c(this.w, sensorEvent.timestamp);
                        this.p.b(this.v);
                        g.k(this.w, this.v, this.w);
                    }
                }
                this.n.d(this.w, sensorEvent.timestamp);
            }
        }
    }
}
