package d.a.l0.a.h0.u;

import android.util.Log;
import d.a.l0.a.k;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46297b = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46298c;

    /* renamed from: a  reason: collision with root package name */
    public String f46299a;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_slave_ready", false);
        f46298c = false;
    }

    public static d.a.l0.a.o0.d.b a(e eVar) {
        if (f46297b) {
            Log.d("SlaveReadyEvent", "createSlaveReadyMessage:" + eVar);
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("slaveId", eVar.f46299a);
        return new d.a.l0.a.o0.d.b("SlaveReady", treeMap);
    }

    public static boolean b() {
        if (f46297b) {
            Log.d("SlaveReadyEvent", "isSlaveReadyABSwitchOn:" + f46298c);
        }
        return f46298c;
    }

    public String toString() {
        return "SlaveReadyEvent{slaveId='" + this.f46299a + "'}";
    }
}
