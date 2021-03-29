package d.b.b.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f41504b;

    /* renamed from: a  reason: collision with root package name */
    public int f41505a = 0;

    public static f a() {
        if (f41504b == null) {
            synchronized (f.class) {
                if (f41504b == null) {
                    f41504b = new f();
                }
            }
        }
        return f41504b;
    }

    public synchronized int b() {
        int i;
        if (this.f41505a == 0) {
            this.f41505a++;
        }
        i = this.f41505a;
        this.f41505a = i + 1;
        return i;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f41505a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f41505a == 0) {
                    this.f41505a = new Random().nextInt();
                }
            }
        }
    }
}
