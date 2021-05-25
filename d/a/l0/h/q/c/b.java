package d.a.l0.h.q.c;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.l0.a.k;
import d.a.l0.h.m0.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static d.a.l0.h.q.c.c.b[] f47652b;

    /* renamed from: g  reason: collision with root package name */
    public static int f47657g;

    /* renamed from: h  reason: collision with root package name */
    public static long f47658h;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47651a = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public static Point f47653c = new Point();

    /* renamed from: d  reason: collision with root package name */
    public static float f47654d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public static float f47655e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f47656f = false;

    public static long a() {
        return f47658h;
    }

    public static int b() {
        return f47657g;
    }

    public static boolean c() {
        return f47656f;
    }

    public static float d(MotionEvent motionEvent, int i2) {
        return g.b(motionEvent.getX(i2) * f47654d);
    }

    public static float e(MotionEvent motionEvent, int i2) {
        return g.b(motionEvent.getY(i2) * f47655e);
    }

    public static boolean f(EventTarget eventTarget) {
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
    }

    public static void g(boolean z) {
        f47656f = z;
    }

    public static void h(MotionEvent motionEvent, d.a.l0.h.q.c.c.a aVar, boolean z) {
        try {
            if (!z) {
                int actionIndex = motionEvent.getActionIndex();
                aVar.changedTouches = r1;
                d.a.l0.h.q.c.c.b[] bVarArr = {new d.a.l0.h.q.c.c.b()};
                aVar.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                aVar.changedTouches[0].clientX = d(motionEvent, actionIndex);
                aVar.changedTouches[0].clientY = e(motionEvent, actionIndex);
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            if (f47652b == null || f47652b.length != pointerCount) {
                f47652b = new d.a.l0.h.q.c.c.b[pointerCount];
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                d.a.l0.h.q.c.c.b bVar = new d.a.l0.h.q.c.c.b();
                bVar.identifier = motionEvent.getPointerId(i2);
                bVar.clientX = d(motionEvent, i2);
                bVar.clientY = e(motionEvent, i2);
                if (!bVar.equals(f47652b[i2])) {
                    arrayList.add(bVar);
                }
                f47652b[i2] = bVar;
            }
            if (arrayList.size() != 0) {
                d.a.l0.h.q.c.c.b[] bVarArr2 = new d.a.l0.h.q.c.c.b[arrayList.size()];
                aVar.changedTouches = bVarArr2;
                arrayList.toArray(bVarArr2);
            }
        } catch (Exception e2) {
            if (f47651a) {
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
    public static void i(MotionEvent motionEvent, d.a.l0.h.q.c.c.a aVar) {
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
                d.a.l0.h.q.c.c.b bVar = new d.a.l0.h.q.c.c.b();
                bVar.identifier = pointerId;
                bVar.clientX = d(motionEvent, i2);
                bVar.clientY = e(motionEvent, i2);
                arrayList.add(bVar);
                i2++;
            }
            aVar.touches = new d.a.l0.h.q.c.c.b[arrayList.size()];
            if (arrayList.isEmpty()) {
                return;
            }
            arrayList.toArray(aVar.touches);
        } catch (Exception e2) {
            if (f47651a) {
                e2.printStackTrace();
            }
        }
    }

    public static JSEvent j(MotionEvent motionEvent) {
        d.a.l0.h.q.c.c.a aVar = new d.a.l0.h.q.c.c.a();
        int actionMasked = motionEvent.getActionMasked();
        String str = "touchend";
        if (actionMasked == 0) {
            h(motionEvent, aVar, false);
            int i2 = f47657g + 1;
            f47657g = i2;
            f47657g = Math.min(i2, 1000);
            f47658h = System.currentTimeMillis();
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
        f47657g = 0;
    }

    public static void l(int i2, int i3) {
        Point point = f47653c;
        point.x = i2;
        point.y = i3;
    }

    public static void m(int i2, int i3) {
        int i4;
        int i5;
        float f2 = 1.0f;
        f47654d = (i2 == 0 || (i5 = f47653c.x) == 0) ? 1.0f : i5 / i2;
        if (i3 != 0 && (i4 = f47653c.y) != 0) {
            f2 = i4 / i3;
        }
        f47655e = f2;
        if (f47651a) {
            Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(f47654d), Float.valueOf(f47655e)));
        }
    }
}
