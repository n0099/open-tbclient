package d.a.c.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f38672b;

    /* renamed from: a  reason: collision with root package name */
    public int f38673a = 0;

    public static f a() {
        if (f38672b == null) {
            synchronized (f.class) {
                if (f38672b == null) {
                    f38672b = new f();
                }
            }
        }
        return f38672b;
    }

    public synchronized int b() {
        int i2;
        if (this.f38673a == 0) {
            this.f38673a++;
        }
        i2 = this.f38673a;
        this.f38673a = i2 + 1;
        return i2;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f38673a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f38673a == 0) {
                    this.f38673a = new Random().nextInt();
                }
            }
        }
    }
}
