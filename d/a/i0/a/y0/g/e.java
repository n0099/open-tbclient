package d.a.i0.a.y0.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f45648b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.i0.a.y0.g.h.b> f45649a = new HashMap();

    public static e a() {
        if (f45648b == null) {
            synchronized (e.class) {
                if (f45648b == null) {
                    f45648b = new e();
                }
            }
        }
        return f45648b;
    }

    public static void d() {
        if (f45648b != null) {
            f45648b.b();
        }
        f45648b = null;
    }

    public final synchronized void b() {
        d.a.i0.a.e0.d.g("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.f45649a.values()).iterator();
        while (it.hasNext()) {
            ((d.a.i0.a.y0.g.h.b) it.next()).onRelease();
        }
        this.f45649a.clear();
    }

    public synchronized void c(String str) {
        d.a.i0.a.e0.d.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.f45649a.values()).iterator();
        while (it.hasNext()) {
            d.a.i0.a.y0.g.h.b bVar = (d.a.i0.a.y0.g.h.b) it.next();
            if (TextUtils.equals(bVar.b(), str)) {
                bVar.onRelease();
            }
        }
    }
}
