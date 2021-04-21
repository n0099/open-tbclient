package d.b.j0.d3.n0;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public volatile int f55382b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f55383c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public volatile int f55381a = 0;

    public d(int i) {
        this.f55382b = i;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.f55383c.size() >= this.f55382b) {
                    c();
                }
                this.f55381a++;
                this.f55383c.put(valueOf, Integer.valueOf(this.f55381a));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean b(String str) {
        try {
            return this.f55383c.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void c() {
        synchronized (this) {
            Long l = null;
            int i = 134217727;
            for (Map.Entry<Long, Integer> entry : this.f55383c.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    int intValue = entry.getValue().intValue();
                    i = intValue;
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.f55383c.remove(l);
            } else {
                this.f55383c.clear();
            }
        }
    }

    public boolean d(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                return this.f55383c.get(valueOf) != null;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
