package d.b.g0.g.o.c;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.b.g0.a.k;
import d.b.g0.g.i0.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static d.b.g0.g.o.c.c.b[] f48522b;

    /* renamed from: g  reason: collision with root package name */
    public static int f48527g;

    /* renamed from: h  reason: collision with root package name */
    public static long f48528h;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48521a = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public static Point f48523c = new Point();

    /* renamed from: d  reason: collision with root package name */
    public static float f48524d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public static float f48525e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f48526f = false;

    public static long a() {
        return f48528h;
    }

    public static int b() {
        return f48527g;
    }

    public static boolean c() {
        return f48526f;
    }

    public static float d(MotionEvent motionEvent, int i) {
        return e.b(motionEvent.getX(i) * f48524d);
    }

    public static float e(MotionEvent motionEvent, int i) {
        return e.b(motionEvent.getY(i) * f48525e);
    }

    public static boolean f(EventTarget eventTarget) {
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
    }

    public static void g(boolean z) {
        f48526f = z;
    }

    public static void h(MotionEvent motionEvent, d.b.g0.g.o.c.c.a aVar, boolean z) {
        try {
            if (!z) {
                int actionIndex = motionEvent.getActionIndex();
                aVar.changedTouches = r1;
                d.b.g0.g.o.c.c.b[] bVarArr = {new d.b.g0.g.o.c.c.b()};
                aVar.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                aVar.changedTouches[0].clientX = d(motionEvent, actionIndex);
                aVar.changedTouches[0].clientY = e(motionEvent, actionIndex);
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            if (f48522b == null || f48522b.length != pointerCount) {
                f48522b = new d.b.g0.g.o.c.c.b[pointerCount];
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < pointerCount; i++) {
                d.b.g0.g.o.c.c.b bVar = new d.b.g0.g.o.c.c.b();
                bVar.identifier = motionEvent.getPointerId(i);
                bVar.clientX = d(motionEvent, i);
                bVar.clientY = e(motionEvent, i);
                if (!bVar.equals(f48522b[i])) {
                    arrayList.add(bVar);
                }
                f48522b[i] = bVar;
            }
            if (arrayList.size() != 0) {
                d.b.g0.g.o.c.c.b[] bVarArr2 = new d.b.g0.g.o.c.c.b[arrayList.size()];
                aVar.changedTouches = bVarArr2;
                arrayList.toArray(bVarArr2);
            }
        } catch (Exception e2) {
            if (f48521a) {
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
    public static void i(MotionEvent motionEvent, d.b.g0.g.o.c.c.a aVar) {
        try {
            int pointerCount = motionEvent.getPointerCount();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < pointerCount) {
                int actionMasked = motionEvent.getActionMasked();
                boolean z = true;
                if (actionMasked != 6 && actionMasked != 1 && actionMasked != 3) {
                    z = false;
                }
                int pointerId = motionEvent.getPointerId(i);
                d.b.g0.g.o.c.c.b bVar = new d.b.g0.g.o.c.c.b();
                bVar.identifier = pointerId;
                bVar.clientX = d(motionEvent, i);
                bVar.clientY = e(motionEvent, i);
                arrayList.add(bVar);
                i++;
            }
            aVar.touches = new d.b.g0.g.o.c.c.b[arrayList.size()];
            if (arrayList.isEmpty()) {
                return;
            }
            arrayList.toArray(aVar.touches);
        } catch (Exception e2) {
            if (f48521a) {
                e2.printStackTrace();
            }
        }
    }

    public static JSEvent j(MotionEvent motionEvent) {
        d.b.g0.g.o.c.c.a aVar = new d.b.g0.g.o.c.c.a();
        int actionMasked = motionEvent.getActionMasked();
        String str = "touchend";
        if (actionMasked == 0) {
            h(motionEvent, aVar, false);
            int i = f48527g + 1;
            f48527g = i;
            f48527g = Math.min(i, 1000);
            f48528h = System.currentTimeMillis();
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
        f48527g = 0;
    }

    public static void l(int i, int i2) {
        Point point = f48523c;
        point.x = i;
        point.y = i2;
    }

    public static void m(int i, int i2) {
        int i3;
        int i4;
        float f2 = 1.0f;
        f48524d = (i == 0 || (i4 = f48523c.x) == 0) ? 1.0f : i4 / i;
        if (i2 != 0 && (i3 = f48523c.y) != 0) {
            f2 = i3 / i2;
        }
        f48525e = f2;
        if (f48521a) {
            Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(f48524d), Float.valueOf(f48525e)));
        }
    }
}
