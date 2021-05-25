package d.a.c.c.e.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f38336b;

    /* renamed from: a  reason: collision with root package name */
    public int f38337a = 0;

    public static f a() {
        if (f38336b == null) {
            synchronized (f.class) {
                if (f38336b == null) {
                    f38336b = new f();
                }
            }
        }
        return f38336b;
    }

    public synchronized int b() {
        int i2;
        if (this.f38337a == 0) {
            this.f38337a++;
        }
        i2 = this.f38337a;
        this.f38337a = i2 + 1;
        return i2;
    }

    public synchronized void c(Map<String, String> map) {
        if (map != null) {
            try {
                this.f38337a = Integer.valueOf(map.get("Seq-Id")).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                i.a("SequenceManager", 0, 0, "setSequenceId", h.x, "parser Seq-Id error");
                if (this.f38337a == 0) {
                    this.f38337a = new Random().nextInt();
                }
            }
        }
    }
}
