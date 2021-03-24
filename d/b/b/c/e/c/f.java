package d.b.b.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f41503b;

    /* renamed from: a  reason: collision with root package name */
    public int f41504a = 0;

    public static f a() {
        if (f41503b == null) {
            synchronized (f.class) {
                if (f41503b == null) {
                    f41503b = new f();
                }
            }
        }
        return f41503b;
    }

    public synchronized int b() {
        int i;
        if (this.f41504a == 0) {
            this.f41504a++;
        }
        i = this.f41504a;
        this.f41504a = i + 1;
        return i;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f41504a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f41504a == 0) {
                    this.f41504a = new Random().nextInt();
                }
            }
        }
    }
}
