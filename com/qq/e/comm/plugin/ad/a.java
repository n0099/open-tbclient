package com.qq.e.comm.plugin.ad;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.as;
import com.qq.e.comm.plugin.util.bd;
import com.qq.e.comm.plugin.y.u;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f11870a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Pair<Float, Float>> f11871b = new ConcurrentHashMap();
    private final Map<Integer, Pair<Integer, Integer>> c = new ConcurrentHashMap();
    private final Map<Integer, Pair<Integer, Integer>> d = new ConcurrentHashMap();
    private final Map<Integer, Pair<Float, Integer>> e = new ConcurrentHashMap();
    private volatile C1192a f = null;
    private Set<Integer> g = Collections.newSetFromMap(new ConcurrentHashMap());
    private View.OnAttachStateChangeListener h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.qq.e.comm.plugin.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1192a {

        /* renamed from: a  reason: collision with root package name */
        private SensorManager f11875a;

        /* renamed from: b  reason: collision with root package name */
        private Sensor f11876b;
        private Sensor c;
        private C1193a d;
        private float[] e = new float[3];
        private float[] f = new float[3];

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.qq.e.comm.plugin.ad.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public class C1193a implements SensorEventListener {
            private C1193a() {
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                switch (sensorEvent.sensor.getType()) {
                    case 1:
                        C1192a.this.e = sensorEvent.values;
                        return;
                    case 2:
                        C1192a.this.f = sensorEvent.values;
                        return;
                    default:
                        return;
                }
            }
        }

        C1192a(Context context) {
            this.f11875a = (SensorManager) context.getSystemService("sensor");
            this.f11876b = this.f11875a.getDefaultSensor(1);
            this.c = this.f11875a.getDefaultSensor(2);
        }

        private int[] e() {
            float[] fArr = new float[3];
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrix(fArr2, null, this.e, this.f);
            SensorManager.getOrientation(fArr2, fArr);
            int degrees = (int) Math.toDegrees(fArr[1]);
            int degrees2 = (int) Math.toDegrees(fArr[2]);
            int degrees3 = (int) Math.toDegrees(fArr[0]);
            ai.b("gdt_tag_p", "calculateOrientation x = %d , y = %d , z = %d", Integer.valueOf(degrees), Integer.valueOf(degrees2), Integer.valueOf(degrees3));
            return new int[]{degrees, degrees2, degrees3};
        }

        public void a() {
            if (this.d == null) {
                this.d = new C1193a();
                this.f11875a.registerListener(this.d, this.f11876b, 1);
                this.f11875a.registerListener(this.d, this.c, 2);
                ai.a("gdt_tag_p", "ADMonitor.SensorDetector start");
            }
        }

        public void b() {
            if (this.d != null) {
                this.f11875a.unregisterListener(this.d);
                this.d = null;
                ai.a("gdt_tag_p", "ADMonitor.SensorDetector stop");
            }
        }

        public boolean c() {
            return this.d != null;
        }

        public int[] d() {
            return e();
        }
    }

    private a() {
    }

    public static a a() {
        if (f11870a == null) {
            synchronized (a.class) {
                try {
                    if (f11870a == null) {
                        f11870a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11870a;
    }

    private void c() {
        if (this.c.size() > 100000) {
            this.c.clear();
            u.a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR, 4, null);
        }
        if (this.d.size() > 100000) {
            this.d.clear();
            u.a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR, 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        int b2 = b(view);
        ai.b("gdt_tag_p", "ADMonitor setViewInfo viewIdentifier: %d", Integer.valueOf(b2));
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int i = rect.top;
        int i2 = rect.left;
        int i3 = rect.right;
        int i4 = rect.bottom;
        float b3 = bd.b(view);
        int i5 = bd.a(view) ? 1 : 0;
        c();
        this.c.put(Integer.valueOf(b2), new Pair<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])));
        this.d.put(Integer.valueOf(b2), new Pair<>(Integer.valueOf(i3 - i2), Integer.valueOf(i4 - i)));
        this.e.put(Integer.valueOf(b2), new Pair<>(Float.valueOf(b3), Integer.valueOf(i5)));
    }

    public Pair<Float, Float> a(int i) {
        return this.f11871b.get(Integer.valueOf(i));
    }

    public void a(final View view) {
        if (view == null || !as.c()) {
            return;
        }
        if (this.f == null) {
            this.f = new C1192a(view.getContext().getApplicationContext());
        }
        int b2 = b(view);
        if (!this.g.contains(Integer.valueOf(b2))) {
            ai.b("gdt_tag_p", "ADMonitor.onExposured : %s", view);
            if (this.h == null) {
                this.h = new View.OnAttachStateChangeListener() { // from class: com.qq.e.comm.plugin.ad.a.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        ai.b("gdt_tag_p", "ADMonitor.onViewAttachedToWindow : %s", view2);
                        a.this.a(view2);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                        Integer valueOf = Integer.valueOf(a.this.b(view2));
                        ai.b("gdt_tag_p", "ADMonitor.onViewDetachedFromWindow : (%d) %s", valueOf, view2);
                        a.this.g.remove(valueOf);
                        a.this.f11871b.remove(valueOf);
                        if (a.this.f == null || a.this.g.size() > 0) {
                            return;
                        }
                        a.this.f.b();
                    }
                };
            }
            view.addOnAttachStateChangeListener(this.h);
            if (this.g.size() > 100000) {
                this.g.clear();
                u.a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR, 2, null);
            }
            this.g.add(Integer.valueOf(b2));
            if (this.f != null && !this.f.c()) {
                this.f.a();
            }
        }
        view.post(new Runnable() { // from class: com.qq.e.comm.plugin.ad.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.c(view);
            }
        });
    }

    public void a(View view, MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 12 || view == null || motionEvent == null || !as.c()) {
            return;
        }
        float pressure = motionEvent.getPressure();
        float size = motionEvent.getSize();
        int b2 = b(view);
        ai.b("gdt_tag_p", "ADMonitor.onTouchUp (%d) : %f , %f", Integer.valueOf(b2), Float.valueOf(pressure), Float.valueOf(size));
        if (this.f11871b.size() > 100000) {
            this.f11871b.clear();
            u.a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR, 1, null);
        }
        this.f11871b.put(Integer.valueOf(b2), new Pair<>(Float.valueOf(pressure), Float.valueOf(size)));
        c(view);
    }

    public int b(View view) {
        return System.identityHashCode(view);
    }

    public Pair<Integer, Integer> b(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public int[] b() {
        if (this.f != null) {
            return this.f.d();
        }
        return null;
    }

    public Pair<Integer, Integer> c(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    public Pair<Float, Integer> d(int i) {
        return this.e.get(Integer.valueOf(i));
    }
}
