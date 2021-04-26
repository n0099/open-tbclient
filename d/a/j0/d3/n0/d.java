package d.a.j0.d3.n0;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public volatile int f53223b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f53224c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public volatile int f53222a = 0;

    public d(int i2) {
        this.f53223b = i2;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.f53224c.size() >= this.f53223b) {
                    c();
                }
                this.f53222a++;
                this.f53224c.put(valueOf, Integer.valueOf(this.f53222a));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean b(String str) {
        try {
            return this.f53224c.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void c() {
        synchronized (this) {
            Long l = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.f53224c.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    int intValue = entry.getValue().intValue();
                    i2 = intValue;
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.f53224c.remove(l);
            } else {
                this.f53224c.clear();
            }
        }
    }

    public boolean d(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                return this.f53224c.get(valueOf) != null;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
