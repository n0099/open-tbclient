package d.a.l0.a.y0.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f45824b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d.a.l0.a.y0.g.h.b> f45825a = new HashMap();

    public static e a() {
        if (f45824b == null) {
            synchronized (e.class) {
                if (f45824b == null) {
                    f45824b = new e();
                }
            }
        }
        return f45824b;
    }

    public static void d() {
        if (f45824b != null) {
            f45824b.b();
        }
        f45824b = null;
    }

    public final synchronized void b() {
        d.a.l0.a.e0.d.g("RtcRoomWidgetManager", "release");
        Iterator it = new ArrayList(this.f45825a.values()).iterator();
        while (it.hasNext()) {
            ((d.a.l0.a.y0.g.h.b) it.next()).onRelease();
        }
        this.f45825a.clear();
    }

    public synchronized void c(String str) {
        d.a.l0.a.e0.d.g("RtcRoomWidgetManager", "onWebViewDetach slaveId=" + str);
        Iterator it = new ArrayList(this.f45825a.values()).iterator();
        while (it.hasNext()) {
            d.a.l0.a.y0.g.h.b bVar = (d.a.l0.a.y0.g.h.b) it.next();
            if (TextUtils.equals(bVar.b(), str)) {
                bVar.onRelease();
            }
        }
    }
}
