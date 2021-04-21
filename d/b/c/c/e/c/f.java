package d.b.c.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f42241b;

    /* renamed from: a  reason: collision with root package name */
    public int f42242a = 0;

    public static f a() {
        if (f42241b == null) {
            synchronized (f.class) {
                if (f42241b == null) {
                    f42241b = new f();
                }
            }
        }
        return f42241b;
    }

    public synchronized int b() {
        int i;
        if (this.f42242a == 0) {
            this.f42242a++;
        }
        i = this.f42242a;
        this.f42242a = i + 1;
        return i;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f42242a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f42242a == 0) {
                    this.f42242a = new Random().nextInt();
                }
            }
        }
    }
}
