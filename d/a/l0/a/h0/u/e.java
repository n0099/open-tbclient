package d.a.l0.a.h0.u;

import android.util.Log;
import d.a.l0.a.k;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42621b = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42622c;

    /* renamed from: a  reason: collision with root package name */
    public String f42623a;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_slave_ready", false);
        f42622c = false;
    }

    public static d.a.l0.a.o0.d.b a(e eVar) {
        if (f42621b) {
            Log.d("SlaveReadyEvent", "createSlaveReadyMessage:" + eVar);
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("slaveId", eVar.f42623a);
        return new d.a.l0.a.o0.d.b("SlaveReady", treeMap);
    }

    public static boolean b() {
        if (f42621b) {
            Log.d("SlaveReadyEvent", "isSlaveReadyABSwitchOn:" + f42622c);
        }
        return f42622c;
    }

    public String toString() {
        return "SlaveReadyEvent{slaveId='" + this.f42623a + "'}";
    }
}
