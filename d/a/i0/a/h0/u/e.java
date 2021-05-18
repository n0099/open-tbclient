package d.a.i0.a.h0.u;

import android.util.Log;
import d.a.i0.a.k;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42447b = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42448c;

    /* renamed from: a  reason: collision with root package name */
    public String f42449a;

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_slave_ready", false);
        f42448c = false;
    }

    public static d.a.i0.a.o0.d.b a(e eVar) {
        if (f42447b) {
            Log.d("SlaveReadyEvent", "createSlaveReadyMessage:" + eVar);
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("slaveId", eVar.f42449a);
        return new d.a.i0.a.o0.d.b("SlaveReady", treeMap);
    }

    public static boolean b() {
        if (f42447b) {
            Log.d("SlaveReadyEvent", "isSlaveReadyABSwitchOn:" + f42448c);
        }
        return f42448c;
    }

    public String toString() {
        return "SlaveReadyEvent{slaveId='" + this.f42449a + "'}";
    }
}
