package d.a.c.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f42092b;

    /* renamed from: a  reason: collision with root package name */
    public int f42093a = 0;

    public static f a() {
        if (f42092b == null) {
            synchronized (f.class) {
                if (f42092b == null) {
                    f42092b = new f();
                }
            }
        }
        return f42092b;
    }

    public synchronized int b() {
        int i2;
        if (this.f42093a == 0) {
            this.f42093a++;
        }
        i2 = this.f42093a;
        this.f42093a = i2 + 1;
        return i2;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f42093a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f42093a == 0) {
                    this.f42093a = new Random().nextInt();
                }
            }
        }
    }
}
