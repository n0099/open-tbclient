package d.a.j0.s.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.a.f.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f50340c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50341a;

    /* renamed from: b  reason: collision with root package name */
    public int f50342b;

    public a() {
        this.f50341a = false;
        this.f50342b = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String a2 = dVar.a();
                if (a2 != null) {
                    this.f50342b = Integer.parseInt(a2);
                }
                if (this.f50342b == 1 || this.f50342b == 2) {
                    this.f50341a = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a b() {
        if (f50340c == null) {
            synchronized (a.class) {
                if (f50340c == null) {
                    f50340c = new a();
                }
            }
        }
        return f50340c;
    }

    public String a() {
        return this.f50341a ? "pub_env=" + this.f50342b + ";" : "";
    }

    public int c() {
        return this.f50342b;
    }

    public boolean d() {
        return this.f50341a;
    }
}
