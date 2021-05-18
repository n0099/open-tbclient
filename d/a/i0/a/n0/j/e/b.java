package d.a.i0.a.n0.j.e;

import d.a.i0.a.e0.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Integer> f43450a = new ConcurrentHashMap();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f43451a = new b();
    }

    public static b b() {
        return a.f43451a;
    }

    public void a(int i2) {
        this.f43450a.put(Integer.valueOf(i2), Integer.valueOf(c(i2) + 1));
        d.h("SwanRecoveryCounter", "addRecoveryCount level=" + i2);
    }

    public int c(int i2) {
        Integer num = this.f43450a.get(Integer.valueOf(i2));
        int intValue = num != null ? num.intValue() : 0;
        d.h("SwanRecoveryCounter", "getRecoveryCount level=" + i2 + ";count=" + intValue);
        return intValue;
    }
}
