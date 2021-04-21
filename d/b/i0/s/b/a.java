package d.b.i0.s.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.a.f.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f51870c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51871a;

    /* renamed from: b  reason: collision with root package name */
    public int f51872b;

    public a() {
        this.f51871a = false;
        this.f51872b = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String a2 = dVar.a();
                if (a2 != null) {
                    this.f51872b = Integer.parseInt(a2);
                }
                if (this.f51872b == 1 || this.f51872b == 2) {
                    this.f51871a = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a b() {
        if (f51870c == null) {
            synchronized (a.class) {
                if (f51870c == null) {
                    f51870c = new a();
                }
            }
        }
        return f51870c;
    }

    public String a() {
        return this.f51871a ? "pub_env=" + this.f51872b + ";" : "";
    }

    public int c() {
        return this.f51872b;
    }

    public boolean d() {
        return this.f51871a;
    }
}
