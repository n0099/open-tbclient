package d.a.m0.s.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.a.f.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f54080c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54081a;

    /* renamed from: b  reason: collision with root package name */
    public int f54082b;

    public a() {
        this.f54081a = false;
        this.f54082b = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String a2 = dVar.a();
                if (a2 != null) {
                    this.f54082b = Integer.parseInt(a2);
                }
                if (this.f54082b == 1 || this.f54082b == 2) {
                    this.f54081a = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a b() {
        if (f54080c == null) {
            synchronized (a.class) {
                if (f54080c == null) {
                    f54080c = new a();
                }
            }
        }
        return f54080c;
    }

    public String a() {
        return this.f54081a ? "pub_env=" + this.f54082b + ";" : "";
    }

    public int c() {
        return this.f54082b;
    }

    public boolean d() {
        return this.f54081a;
    }
}
