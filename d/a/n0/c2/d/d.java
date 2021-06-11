package d.a.n0.c2.d;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.List;
/* loaded from: classes5.dex */
public class d implements d.a.m0.s.a.b {

    /* renamed from: a  reason: collision with root package name */
    public static d f56099a;

    public static synchronized d d() {
        d dVar;
        synchronized (d.class) {
            if (f56099a == null) {
                f56099a = new d();
            }
            dVar = f56099a;
        }
        return dVar;
    }

    @Override // d.a.m0.s.a.b
    public void a() {
        try {
            SapiAccountManager.getInstance().logout();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.a.m0.s.a.b
    public void b(AccountData accountData) {
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (TextUtils.isEmpty(accountData.getID()) || loginAccounts == null || loginAccounts.size() <= 0) {
            return;
        }
        for (SapiAccount sapiAccount : loginAccounts) {
            if (accountData.getID().equals(sapiAccount.uid)) {
                SapiAccountManager.getInstance().validate(sapiAccount);
                return;
            }
        }
    }

    @Override // d.a.m0.s.a.b
    public void c(AccountData accountData) {
        if (accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) {
            SapiAccountManager.getInstance().logout();
            return;
        }
        List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
        if (loginAccounts == null || loginAccounts.size() <= 0) {
            return;
        }
        for (SapiAccount sapiAccount : loginAccounts) {
            if (accountData.getID().equals(sapiAccount.uid)) {
                SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                return;
            }
        }
    }
}
