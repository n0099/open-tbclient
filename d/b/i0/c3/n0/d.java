package d.b.i0.c3.n0;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public volatile int f53517b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f53518c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public volatile int f53516a = 0;

    public d(int i) {
        this.f53517b = i;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.f53518c.size() >= this.f53517b) {
                    c();
                }
                this.f53516a++;
                this.f53518c.put(valueOf, Integer.valueOf(this.f53516a));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean b(String str) {
        try {
            return this.f53518c.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void c() {
        synchronized (this) {
            Long l = null;
            int i = 134217727;
            for (Map.Entry<Long, Integer> entry : this.f53518c.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    int intValue = entry.getValue().intValue();
                    i = intValue;
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.f53518c.remove(l);
            } else {
                this.f53518c.clear();
            }
        }
    }

    public boolean d(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                return this.f53518c.get(valueOf) != null;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
