package com.repackage;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class rw3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static tw3[] b;
    public static Point c;
    public static float d;
    public static float e;
    public static boolean f;
    public static int g;
    public static long h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755335965, "Lcom/repackage/rw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755335965, "Lcom/repackage/rw3;");
                return;
            }
        }
        a = sg1.a;
        c = new Point();
        d = 1.0f;
        e = 1.0f;
        f = false;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? h : invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? g : invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f : invokeV.booleanValue;
    }

    public static float d(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, motionEvent, i)) == null) ? x24.b(motionEvent.getX(i) * d) : invokeLI.floatValue;
    }

    public static float e(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, motionEvent, i)) == null) ? x24.b(motionEvent.getY(i) * e) : invokeLI.floatValue;
    }

    public static boolean f(EventTarget eventTarget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eventTarget)) == null) {
            if (eventTarget == null) {
                return false;
            }
            return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
        }
        return invokeL.booleanValue;
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f = z;
        }
    }

    public static void h(MotionEvent motionEvent, sw3 sw3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, motionEvent, sw3Var, z) == null) {
            try {
                if (!z) {
                    int actionIndex = motionEvent.getActionIndex();
                    sw3Var.changedTouches = r1;
                    tw3[] tw3VarArr = {new tw3()};
                    sw3Var.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                    sw3Var.changedTouches[0].clientX = d(motionEvent, actionIndex);
                    sw3Var.changedTouches[0].clientY = e(motionEvent, actionIndex);
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                if (b == null || b.length != pointerCount) {
                    b = new tw3[pointerCount];
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < pointerCount; i++) {
                    tw3 tw3Var = new tw3();
                    tw3Var.identifier = motionEvent.getPointerId(i);
                    tw3Var.clientX = d(motionEvent, i);
                    tw3Var.clientY = e(motionEvent, i);
                    if (!tw3Var.equals(b[i])) {
                        arrayList.add(tw3Var);
                    }
                    b[i] = tw3Var;
                }
                if (arrayList.size() != 0) {
                    tw3[] tw3VarArr2 = new tw3[arrayList.size()];
                    sw3Var.changedTouches = tw3VarArr2;
                    arrayList.toArray(tw3VarArr2);
                }
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (r8.getActionIndex() != r3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(MotionEvent motionEvent, sw3 sw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, motionEvent, sw3Var) == null) {
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
                    tw3 tw3Var = new tw3();
                    tw3Var.identifier = pointerId;
                    tw3Var.clientX = d(motionEvent, i);
                    tw3Var.clientY = e(motionEvent, i);
                    arrayList.add(tw3Var);
                    i++;
                }
                sw3Var.touches = new tw3[arrayList.size()];
                if (arrayList.isEmpty()) {
                    return;
                }
                arrayList.toArray(sw3Var.touches);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static JSEvent j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, motionEvent)) == null) {
            sw3 sw3Var = new sw3();
            int actionMasked = motionEvent.getActionMasked();
            String str = "touchend";
            if (actionMasked == 0) {
                h(motionEvent, sw3Var, false);
                int i = g + 1;
                g = i;
                g = Math.min(i, 1000);
                h = System.currentTimeMillis();
            } else {
                if (actionMasked == 1) {
                    h(motionEvent, sw3Var, false);
                } else if (actionMasked == 2) {
                    h(motionEvent, sw3Var, true);
                    str = "touchmove";
                } else if (actionMasked == 3) {
                    h(motionEvent, sw3Var, false);
                    str = "touchcancel";
                } else if (actionMasked == 5) {
                    h(motionEvent, sw3Var, false);
                } else if (actionMasked != 6) {
                    str = "toucherror";
                } else {
                    h(motionEvent, sw3Var, false);
                }
                sw3Var.timeStamp = motionEvent.getEventTime();
                i(motionEvent, sw3Var);
                JSEvent jSEvent = new JSEvent(str);
                jSEvent.data = sw3Var;
                if (!"touchmove".equals(str) && sw3Var.changedTouches == null) {
                    return null;
                }
            }
            str = "touchstart";
            sw3Var.timeStamp = motionEvent.getEventTime();
            i(motionEvent, sw3Var);
            JSEvent jSEvent2 = new JSEvent(str);
            jSEvent2.data = sw3Var;
            return !"touchmove".equals(str) ? jSEvent2 : jSEvent2;
        }
        return (JSEvent) invokeL.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            g = 0;
        }
    }

    public static void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i, i2) == null) {
            Point point = c;
            point.x = i;
            point.y = i2;
        }
    }

    public static void m(int i, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i, i2) == null) {
            float f2 = 1.0f;
            d = (i == 0 || (i4 = c.x) == 0) ? 1.0f : i4 / i;
            if (i2 != 0 && (i3 = c.y) != 0) {
                f2 = i3 / i2;
            }
            e = f2;
            if (a) {
                Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(d), Float.valueOf(e)));
            }
        }
    }
}
