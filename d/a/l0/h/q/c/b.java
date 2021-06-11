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
    public static d.a.l0.h.q.c.c.b[] f51326b;

    /* renamed from: g  reason: collision with root package name */
    public static int f51331g;

    /* renamed from: h  reason: collision with root package name */
    public static long f51332h;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51325a = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public static Point f51327c = new Point();

    /* renamed from: d  reason: collision with root package name */
    public static float f51328d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public static float f51329e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f51330f = false;

    public static long a() {
        return f51332h;
    }

    public static int b() {
        return f51331g;
    }

    public static boolean c() {
        return f51330f;
    }

    public static float d(MotionEvent motionEvent, int i2) {
        return g.b(motionEvent.getX(i2) * f51328d);
    }

    public static float e(MotionEvent motionEvent, int i2) {
        return g.b(motionEvent.getY(i2) * f51329e);
    }

    public static boolean f(EventTarget eventTarget) {
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
    }

    public static void g(boolean z) {
        f51330f = z;
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
            if (f51326b == null || f51326b.length != pointerCount) {
                f51326b = new d.a.l0.h.q.c.c.b[pointerCount];
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < pointerCount; i2++) {
                d.a.l0.h.q.c.c.b bVar = new d.a.l0.h.q.c.c.b();
                bVar.identifier = motionEvent.getPointerId(i2);
                bVar.clientX = d(motionEvent, i2);
                bVar.clientY = e(motionEvent, i2);
                if (!bVar.equals(f51326b[i2])) {
                    arrayList.add(bVar);
                }
                f51326b[i2] = bVar;
            }
            if (arrayList.size() != 0) {
                d.a.l0.h.q.c.c.b[] bVarArr2 = new d.a.l0.h.q.c.c.b[arrayList.size()];
                aVar.changedTouches = bVarArr2;
                arrayList.toArray(bVarArr2);
            }
        } catch (Exception e2) {
            if (f51325a) {
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
            if (f51325a) {
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
            int i2 = f51331g + 1;
            f51331g = i2;
            f51331g = Math.min(i2, 1000);
            f51332h = System.currentTimeMillis();
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
        f51331g = 0;
    }

    public static void l(int i2, int i3) {
        Point point = f51327c;
        point.x = i2;
        point.y = i3;
    }

    public static void m(int i2, int i3) {
        int i4;
        int i5;
        float f2 = 1.0f;
        f51328d = (i2 == 0 || (i5 = f51327c.x) == 0) ? 1.0f : i5 / i2;
        if (i3 != 0 && (i4 = f51327c.y) != 0) {
            f2 = i4 / i3;
        }
        f51329e = f2;
        if (f51325a) {
            Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(f51328d), Float.valueOf(f51329e)));
        }
    }
}
