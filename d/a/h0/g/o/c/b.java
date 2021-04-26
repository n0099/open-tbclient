package d.a.h0.g.o.c;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.h0.a.k;
import d.a.h0.g.i0.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static d.a.h0.g.o.c.c.b[] f46738b;

    /* renamed from: g  reason: collision with root package name */
    public static int f46743g;

    /* renamed from: h  reason: collision with root package name */
    public static long f46744h;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46737a = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static Point f46739c = new Point();

    /* renamed from: d  reason: collision with root package name */
    public static float f46740d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public static float f46741e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f46742f = false;

    public static long a() {
        return f46744h;
    }

    public static int b() {
        return f46743g;
    }

    public static boolean c() {
        return f46742f;
    }

    public static float d(MotionEvent motionEvent, int i2) {
        return e.b(motionEvent.getX(i2) * f46740d);
    }

    public static float e(MotionEvent motionEvent, int i2) {
        return e.b(motionEvent.getY(i2) * f46741e);
    }

    public static boolean f(EventTarget eventTarget) {
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
    }

    public static void g(boolean z) {
        f46742f = z;
    }

    public static void h(MotionEvent motionEvent, d.a.h0.g.o.c.c.a aVar, boolean z) {
        try {
            if (!z) {
                int actionIndex = motionEvent.getActionIndex();
                aVar.changedTouches = r1;
                d.a.h0.g.o.c.c.b[] bVarArr = {new d.a.h0.g.o.c.c.b()};
                aVar.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                aVar.changedTouches[0].clientX = d(motionEvent, actionIndex);
                aVar.changedTouches[0].clientY = e(motionEvent, actionIndex);
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            if (f46738b == null || f46738b.length != pointerCount) {
                f46738b = new d.a.h0.g.o.c.c.b[pointerCount];
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                d.a.h0.g.o.c.c.b bVar = new d.a.h0.g.o.c.c.b();
                bVar.identifier = motionEvent.getPointerId(i2);
                bVar.clientX = d(motionEvent, i2);
                bVar.clientY = e(motionEvent, i2);
                if (!bVar.equals(f46738b[i2])) {
                    arrayList.add(bVar);
                }
                f46738b[i2] = bVar;
            }
            if (arrayList.size() != 0) {
                d.a.h0.g.o.c.c.b[] bVarArr2 = new d.a.h0.g.o.c.c.b[arrayList.size()];
                aVar.changedTouches = bVarArr2;
                arrayList.toArray(bVarArr2);
            }
        } catch (Exception e2) {
            if (f46737a) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r8.getActionIndex() != r3) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(MotionEvent motionEvent, d.a.h0.g.o.c.c.a aVar) {
        try {
            int pointerCount = motionEvent.getPointerCount();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < pointerCount) {
                int actionMasked = motionEvent.getActionMasked();
                boolean z = true;
                if (actionMasked != 6 && actionMasked != 1 && actionMasked != 3) {
                    z = false;
                }
                int pointerId = motionEvent.getPointerId(i2);
                d.a.h0.g.o.c.c.b bVar = new d.a.h0.g.o.c.c.b();
                bVar.identifier = pointerId;
                bVar.clientX = d(motionEvent, i2);
                bVar.clientY = e(motionEvent, i2);
                arrayList.add(bVar);
                i2++;
            }
            aVar.touches = new d.a.h0.g.o.c.c.b[arrayList.size()];
            if (arrayList.isEmpty()) {
                return;
            }
            arrayList.toArray(aVar.touches);
        } catch (Exception e2) {
            if (f46737a) {
                e2.printStackTrace();
            }
        }
    }

    public static JSEvent j(MotionEvent motionEvent) {
        d.a.h0.g.o.c.c.a aVar = new d.a.h0.g.o.c.c.a();
        int actionMasked = motionEvent.getActionMasked();
        String str = "touchend";
        if (actionMasked == 0) {
            h(motionEvent, aVar, false);
            int i2 = f46743g + 1;
            f46743g = i2;
            f46743g = Math.min(i2, 1000);
            f46744h = System.currentTimeMillis();
        } else {
            if (actionMasked == 1) {
                h(motionEvent, aVar, false);
            } else if (actionMasked == 2) {
                h(motionEvent, aVar, true);
                str = "touchmove";
            } else if (actionMasked == 3) {
                h(motionEvent, aVar, false);
                str = "touchcancel";
            } else if (actionMasked == 5) {
                h(motionEvent, aVar, false);
            } else if (actionMasked != 6) {
                str = "toucherror";
            } else {
                h(motionEvent, aVar, false);
            }
            aVar.timeStamp = motionEvent.getEventTime();
            i(motionEvent, aVar);
            JSEvent jSEvent = new JSEvent(str);
            jSEvent.data = aVar;
            if (!"touchmove".equals(str) && aVar.changedTouches == null) {
                return null;
            }
        }
        str = "touchstart";
        aVar.timeStamp = motionEvent.getEventTime();
        i(motionEvent, aVar);
        JSEvent jSEvent2 = new JSEvent(str);
        jSEvent2.data = aVar;
        return !"touchmove".equals(str) ? jSEvent2 : jSEvent2;
    }

    public static void k() {
        f46743g = 0;
    }

    public static void l(int i2, int i3) {
        Point point = f46739c;
        point.x = i2;
        point.y = i3;
    }

    public static void m(int i2, int i3) {
        int i4;
        int i5;
        float f2 = 1.0f;
        f46740d = (i2 == 0 || (i5 = f46739c.x) == 0) ? 1.0f : i5 / i2;
        if (i3 != 0 && (i4 = f46739c.y) != 0) {
            f2 = i4 / i3;
        }
        f46741e = f2;
        if (f46737a) {
            Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(f46740d), Float.valueOf(f46741e)));
        }
    }
}
