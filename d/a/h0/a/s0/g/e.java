package d.a.h0.a.s0.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f43922b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.h0.a.s0.g.h.b> f43923a = new HashMap();

    public static e a() {
        if (f43922b == null) {
            synchronized (e.class) {
                if (f43922b == null) {
                    f43922b = new e();
                }
            }
        }
        return f43922b;
    }

    public static void d() {
        if (f43922b != null) {
            f43922b.b();
        }
        f43922b = null;
    }

    public final synchronized void b() {
        d.a.h0.a.c0.c.g("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.f43923a.values()).iterator();
        while (it.hasNext()) {
            ((d.a.h0.a.s0.g.h.b) it.next()).onRelease();
        }
        this.f43923a.clear();
    }

    public synchronized void c(String str) {
        d.a.h0.a.c0.c.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.f43923a.values()).iterator();
        while (it.hasNext()) {
            d.a.h0.a.s0.g.h.b bVar = (d.a.h0.a.s0.g.h.b) it.next();
            if (TextUtils.equals(bVar.a(), str)) {
                bVar.onRelease();
            }
        }
    }
}
