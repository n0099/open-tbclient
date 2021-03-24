package d.b.i0.a2.d;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import d.b.b.e.p.j;
import d.b.h0.r.l.a;
/* loaded from: classes4.dex */
public class a extends d.b.h0.r.l.a {

    /* renamed from: c  reason: collision with root package name */
    public static a f51939c;

    /* renamed from: b  reason: collision with root package name */
    public final a.InterfaceC1081a f51940b = new C1121a(this);

    /* renamed from: d.b.i0.a2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1121a implements a.InterfaceC1081a {
        public C1121a(a aVar) {
        }

        @Override // d.b.h0.r.l.a.InterfaceC1081a
        public void a(String str, int i, String str2) {
            if (i == 1) {
                ReloginManager.g().f(null);
            }
        }

        @Override // d.b.h0.r.l.a.InterfaceC1081a
        public void b(String str) {
        }

        @Override // d.b.h0.r.l.a.InterfaceC1081a
        public void c(AccountData accountData) {
        }
    }

    public static a f() {
        if (f51939c == null) {
            f51939c = new a();
        }
        return f51939c;
    }

    @Override // d.b.h0.r.l.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC1081a interfaceC1081a) {
        return d.b.i0.r1.b.a(str, str2, str3, str4, interfaceC1081a);
    }

    @Override // d.b.h0.r.l.a
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
                bVar2.f50628a = split[0];
                if (split.length >= 2) {
                    bVar2.f50629b = split[1];
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

    @Override // d.b.h0.r.l.a
    public void e() {
        if (j.z()) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                a.b d2 = d(currentAccountObj.getBDUSS());
                if (d2 != null) {
                    d.b.i0.r1.b.a(currentAccountObj.getAccount(), d2.f50628a, d2.f50629b, currentAccountObj.getStoken(), this.f51940b);
                    return;
                }
                return;
            }
            d.b.h0.r.z.a.a("account", -1L, 0, "main_tab_has_no_cache_account", 0, "", new Object[0]);
        }
    }
}
