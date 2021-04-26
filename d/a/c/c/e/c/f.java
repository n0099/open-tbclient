package d.a.c.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f39427b;

    /* renamed from: a  reason: collision with root package name */
    public int f39428a = 0;

    public static f a() {
        if (f39427b == null) {
            synchronized (f.class) {
                if (f39427b == null) {
                    f39427b = new f();
                }
            }
        }
        return f39427b;
    }

    public synchronized int b() {
        int i2;
        if (this.f39428a == 0) {
            this.f39428a++;
        }
        i2 = this.f39428a;
        this.f39428a = i2 + 1;
        return i2;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f39428a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f39428a == 0) {
                    this.f39428a = new Random().nextInt();
                }
            }
        }
    }
}
