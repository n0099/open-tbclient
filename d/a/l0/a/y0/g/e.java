package d.a.l0.a.y0.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f49498b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.l0.a.y0.g.h.b> f49499a = new HashMap();

    public static e a() {
        if (f49498b == null) {
            synchronized (e.class) {
                if (f49498b == null) {
                    f49498b = new e();
                }
            }
        }
        return f49498b;
    }

    public static void d() {
        if (f49498b != null) {
            f49498b.b();
        }
        f49498b = null;
    }

    public final synchronized void b() {
        d.a.l0.a.e0.d.g("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.f49499a.values()).iterator();
        while (it.hasNext()) {
            ((d.a.l0.a.y0.g.h.b) it.next()).onRelease();
        }
        this.f49499a.clear();
    }

    public synchronized void c(String str) {
        d.a.l0.a.e0.d.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.f49499a.values()).iterator();
        while (it.hasNext()) {
            d.a.l0.a.y0.g.h.b bVar = (d.a.l0.a.y0.g.h.b) it.next();
            if (TextUtils.equals(bVar.b(), str)) {
                bVar.onRelease();
            }
        }
    }
}
