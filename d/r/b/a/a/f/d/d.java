package d.r.b.a.a.f.d;

import android.util.Log;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static CopyOnWriteArrayList<IRLogDelegate> f67722a = new CopyOnWriteArrayList<>();

    public static void a(IRLogDelegate iRLogDelegate) {
        f67722a.add(iRLogDelegate);
    }

    public static void b(Object obj, String str) {
        if (!f67722a.isEmpty()) {
            Iterator<IRLogDelegate> it = f67722a.iterator();
            while (it.hasNext()) {
                it.next().debug(obj, str);
            }
        } else {
            Log.d(obj.toString(), str);
        }
        try {
            if (d.r.b.a.a.f.a.c().d()) {
                a.a(obj.toString(), str);
            }
        } catch (Exception unused) {
        }
    }

    public static void c(Object obj, String str, Object... objArr) {
        if (!f67722a.isEmpty()) {
            Iterator<IRLogDelegate> it = f67722a.iterator();
            while (it.hasNext()) {
                it.next().debug(obj, str, objArr);
            }
        } else {
            try {
                Log.d(obj.toString(), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            if (d.r.b.a.a.f.a.c().d()) {
                a.a(obj.toString(), String.format(str, objArr));
            }
        } catch (Exception unused2) {
        }
    }

    public static void d(Object obj, String str, Throwable th) {
        if (!f67722a.isEmpty()) {
            Iterator<IRLogDelegate> it = f67722a.iterator();
            while (it.hasNext()) {
                it.next().error(obj, str, th);
            }
        } else {
            Log.e(obj.toString(), str, th);
        }
        try {
            String obj2 = obj.toString();
            a.a(obj2, str + ":" + th.getLocalizedMessage());
        } catch (Exception unused) {
        }
    }

    public static void e(Object obj, String str, Object... objArr) {
        if (!f67722a.isEmpty()) {
            Iterator<IRLogDelegate> it = f67722a.iterator();
            while (it.hasNext()) {
                it.next().error(obj, str, objArr);
            }
        } else {
            try {
                Log.e(obj.toString(), String.format(str, objArr));
            } catch (Exception unused) {
            }
        }
        try {
            a.a(obj.toString(), String.format(str, objArr));
        } catch (Exception unused2) {
        }
    }

    public static void f(Object obj, String str) {
        if (!f67722a.isEmpty()) {
            Iterator<IRLogDelegate> it = f67722a.iterator();
            while (it.hasNext()) {
                it.next().info(obj, str);
            }
            return;
        }
        Log.i(obj.toString(), str);
    }

    public static void g(Object obj, String str, Object... objArr) {
        if (!f67722a.isEmpty()) {
            Iterator<IRLogDelegate> it = f67722a.iterator();
            while (it.hasNext()) {
                it.next().info(obj, str, objArr);
            }
            return;
        }
        try {
            Log.i(obj.toString(), String.format(str, objArr));
        } catch (Exception unused) {
        }
    }

    public static void h(Object obj, String str) {
        if (!f67722a.isEmpty()) {
            Iterator<IRLogDelegate> it = f67722a.iterator();
            while (it.hasNext()) {
                it.next().warn(obj, str);
            }
        } else {
            Log.w(obj.toString(), str);
        }
        try {
            a.a(obj.toString(), str);
        } catch (Exception unused) {
        }
    }
}
