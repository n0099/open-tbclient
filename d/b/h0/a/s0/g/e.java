package d.b.h0.a.s0.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f46555b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.b.h0.a.s0.g.h.b> f46556a = new HashMap();

    public static e a() {
        if (f46555b == null) {
            synchronized (e.class) {
                if (f46555b == null) {
                    f46555b = new e();
                }
            }
        }
        return f46555b;
    }

    public static void d() {
        if (f46555b != null) {
            f46555b.b();
        }
        f46555b = null;
    }

    public final synchronized void b() {
        d.b.h0.a.c0.c.g("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.f46556a.values()).iterator();
        while (it.hasNext()) {
            ((d.b.h0.a.s0.g.h.b) it.next()).onRelease();
        }
        this.f46556a.clear();
    }

    public synchronized void c(String str) {
        d.b.h0.a.c0.c.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.f46556a.values()).iterator();
        while (it.hasNext()) {
            d.b.h0.a.s0.g.h.b bVar = (d.b.h0.a.s0.g.h.b) it.next();
            if (TextUtils.equals(bVar.b(), str)) {
                bVar.onRelease();
            }
        }
    }
}
