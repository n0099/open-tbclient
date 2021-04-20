package d.b.c.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f42001b;

    /* renamed from: a  reason: collision with root package name */
    public int f42002a = 0;

    public static f a() {
        if (f42001b == null) {
            synchronized (f.class) {
                if (f42001b == null) {
                    f42001b = new f();
                }
            }
        }
        return f42001b;
    }

    public synchronized int b() {
        int i;
        if (this.f42002a == 0) {
            this.f42002a++;
        }
        i = this.f42002a;
        this.f42002a = i + 1;
        return i;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f42002a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f42002a == 0) {
                    this.f42002a = new Random().nextInt();
                }
            }
        }
    }
}
