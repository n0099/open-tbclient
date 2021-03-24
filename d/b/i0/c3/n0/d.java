package d.b.i0.c3.n0;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public volatile int f53516b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f53517c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public volatile int f53515a = 0;

    public d(int i) {
        this.f53516b = i;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.f53517c.size() >= this.f53516b) {
                    c();
                }
                this.f53515a++;
                this.f53517c.put(valueOf, Integer.valueOf(this.f53515a));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public boolean b(String str) {
        try {
            return this.f53517c.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void c() {
        synchronized (this) {
            Long l = null;
            int i = 134217727;
            for (Map.Entry<Long, Integer> entry : this.f53517c.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    int intValue = entry.getValue().intValue();
                    i = intValue;
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.f53517c.remove(l);
            } else {
                this.f53517c.clear();
            }
        }
    }

    public boolean d(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                return this.f53517c.get(valueOf) != null;
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
