package d.a.n0.e3.n0;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public volatile int f57832b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f57833c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public volatile int f57831a = 0;

    public d(int i2) {
        this.f57832b = i2;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.f57833c.size() >= this.f57832b) {
                    c();
                }
                this.f57831a++;
                this.f57833c.put(valueOf, Integer.valueOf(this.f57831a));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean b(String str) {
        try {
            return this.f57833c.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void c() {
        synchronized (this) {
            Long l = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.f57833c.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    int intValue = entry.getValue().intValue();
                    i2 = intValue;
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.f57833c.remove(l);
            } else {
                this.f57833c.clear();
            }
        }
    }

    public boolean d(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                return this.f57833c.get(valueOf) != null;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
