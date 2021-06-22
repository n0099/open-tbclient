package d.a.m0.a.y0.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f49606b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.m0.a.y0.g.h.b> f49607a = new HashMap();

    public static e a() {
        if (f49606b == null) {
            synchronized (e.class) {
                if (f49606b == null) {
                    f49606b = new e();
                }
            }
        }
        return f49606b;
    }

    public static void d() {
        if (f49606b != null) {
            f49606b.b();
        }
        f49606b = null;
    }

    public final synchronized void b() {
        d.a.m0.a.e0.d.g("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.f49607a.values()).iterator();
        while (it.hasNext()) {
            ((d.a.m0.a.y0.g.h.b) it.next()).onRelease();
        }
        this.f49607a.clear();
    }

    public synchronized void c(String str) {
        d.a.m0.a.e0.d.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.f49607a.values()).iterator();
        while (it.hasNext()) {
            d.a.m0.a.y0.g.h.b bVar = (d.a.m0.a.y0.g.h.b) it.next();
            if (TextUtils.equals(bVar.b(), str)) {
                bVar.onRelease();
            }
        }
    }
}
