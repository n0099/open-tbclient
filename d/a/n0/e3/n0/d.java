package d.a.n0.e3.n0;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public volatile int f54143b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f54144c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public volatile int f54142a = 0;

    public d(int i2) {
        this.f54143b = i2;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.f54144c.size() >= this.f54143b) {
                    c();
                }
                this.f54142a++;
                this.f54144c.put(valueOf, Integer.valueOf(this.f54142a));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean b(String str) {
        try {
            return this.f54144c.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void c() {
        synchronized (this) {
            Long l = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.f54144c.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    int intValue = entry.getValue().intValue();
                    i2 = intValue;
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.f54144c.remove(l);
            } else {
                this.f54144c.clear();
            }
        }
    }

    public boolean d(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                return this.f54144c.get(valueOf) != null;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
