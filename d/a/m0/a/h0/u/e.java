package d.a.m0.a.h0.u;

import android.util.Log;
import d.a.m0.a.k;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46405b = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46406c;

    /* renamed from: a  reason: collision with root package name */
    public String f46407a;

    static {
        d.a.m0.a.c1.a.Z().getSwitch("swan_slave_ready", false);
        f46406c = false;
    }

    public static d.a.m0.a.o0.d.b a(e eVar) {
        if (f46405b) {
            Log.d("SlaveReadyEvent", "createSlaveReadyMessage:" + eVar);
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("slaveId", eVar.f46407a);
        return new d.a.m0.a.o0.d.b("SlaveReady", treeMap);
    }

    public static boolean b() {
        if (f46405b) {
            Log.d("SlaveReadyEvent", "isSlaveReadyABSwitchOn:" + f46406c);
        }
        return f46406c;
    }

    public String toString() {
        return "SlaveReadyEvent{slaveId='" + this.f46407a + "'}";
    }
}
