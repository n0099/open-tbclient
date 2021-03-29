package d.b.h0.s.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.a.f.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f51124c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51125a;

    /* renamed from: b  reason: collision with root package name */
    public int f51126b;

    public a() {
        this.f51125a = false;
        this.f51126b = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String a2 = dVar.a();
                if (a2 != null) {
                    this.f51126b = Integer.parseInt(a2);
                }
                if (this.f51126b == 1 || this.f51126b == 2) {
                    this.f51125a = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a b() {
        if (f51124c == null) {
            synchronized (a.class) {
                if (f51124c == null) {
                    f51124c = new a();
                }
            }
        }
        return f51124c;
    }

    public String a() {
        return this.f51125a ? "pub_env=" + this.f51126b + ";" : "";
    }

    public int c() {
        return this.f51126b;
    }

    public boolean d() {
        return this.f51125a;
    }
}
