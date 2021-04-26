package d.a.i0.s.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.a.f.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f49521c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49522a;

    /* renamed from: b  reason: collision with root package name */
    public int f49523b;

    public a() {
        this.f49522a = false;
        this.f49523b = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String a2 = dVar.a();
                if (a2 != null) {
                    this.f49523b = Integer.parseInt(a2);
                }
                if (this.f49523b == 1 || this.f49523b == 2) {
                    this.f49522a = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a b() {
        if (f49521c == null) {
            synchronized (a.class) {
                if (f49521c == null) {
                    f49521c = new a();
                }
            }
        }
        return f49521c;
    }

    public String a() {
        return this.f49522a ? "pub_env=" + this.f49523b + ";" : "";
    }

    public int c() {
        return this.f49523b;
    }

    public boolean d() {
        return this.f49522a;
    }
}
