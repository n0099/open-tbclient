package d.b.g0.a.s0.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f45833b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.b.g0.a.s0.g.h.b> f45834a = new HashMap();

    public static e a() {
        if (f45833b == null) {
            synchronized (e.class) {
                if (f45833b == null) {
                    f45833b = new e();
                }
            }
        }
        return f45833b;
    }

    public static void d() {
        if (f45833b != null) {
            f45833b.b();
        }
        f45833b = null;
    }

    public final synchronized void b() {
        d.b.g0.a.c0.c.g("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.f45834a.values()).iterator();
        while (it.hasNext()) {
            ((d.b.g0.a.s0.g.h.b) it.next()).onRelease();
        }
        this.f45834a.clear();
    }

    public synchronized void c(String str) {
        d.b.g0.a.c0.c.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.f45834a.values()).iterator();
        while (it.hasNext()) {
            d.b.g0.a.s0.g.h.b bVar = (d.b.g0.a.s0.g.h.b) it.next();
            if (TextUtils.equals(bVar.b(), str)) {
                bVar.onRelease();
            }
        }
    }
}
