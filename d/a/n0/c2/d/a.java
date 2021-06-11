package d.a.n0.c2.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import d.a.c.e.p.j;
import d.a.m0.r.l.a;
/* loaded from: classes5.dex */
public class a extends d.a.m0.r.l.a {

    /* renamed from: c  reason: collision with root package name */
    public static a f56080c;

    /* renamed from: b  reason: collision with root package name */
    public final a.InterfaceC1197a f56081b = new C1288a(this);

    /* renamed from: d.a.n0.c2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1288a implements a.InterfaceC1197a {
        public C1288a(a aVar) {
        }

        @Override // d.a.m0.r.l.a.InterfaceC1197a
        public void a(String str, int i2, String str2) {
            if (i2 == 1) {
                ReloginManager.g().f(null);
            }
        }

        @Override // d.a.m0.r.l.a.InterfaceC1197a
        public void b(String str) {
        }

        @Override // d.a.m0.r.l.a.InterfaceC1197a
        public void c(AccountData accountData) {
        }
    }

    public static a f() {
        if (f56080c == null) {
            f56080c = new a();
        }
        return f56080c;
    }

    @Override // d.a.m0.r.l.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1197a interfaceC1197a) {
        return d.a.n0.t1.b.a(str, str2, str3, str4, interfaceC1197a);
    }

    @Override // d.a.m0.r.l.a
    public a.b d(String str) {
        a.b bVar = null;
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split("[|]");
            if (split == null || split.length < 1) {
                return null;
            }
            a.b bVar2 = new a.b();
            try {
                bVar2.f53539a = split[0];
                if (split.length >= 2) {
                    bVar2.f53540b = split[1];
                }
                return bVar2;
            } catch (Exception e2) {
                e = e2;
                bVar = bVar2;
                BdLog.e(e.getMessage());
                return bVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // d.a.m0.r.l.a
    public void e() {
        if (j.z()) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                a.b d2 = d(currentAccountObj.getBDUSS());
                if (d2 != null) {
                    d.a.n0.t1.b.a(currentAccountObj.getAccount(), d2.f53539a, d2.f53540b, currentAccountObj.getStoken(), this.f56081b);
                    return;
                }
                return;
            }
            d.a.m0.r.z.a.a("account", -1L, 0, "main_tab_has_no_cache_account", 0, "", new Object[0]);
        }
    }
}
