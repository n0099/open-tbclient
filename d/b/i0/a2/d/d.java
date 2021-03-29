package d.b.i0.a2.d;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements d.b.h0.s.a.b {

    /* renamed from: a  reason: collision with root package name */
    public static d f51959a;

    public static synchronized d d() {
        d dVar;
        synchronized (d.class) {
            if (f51959a == null) {
                f51959a = new d();
            }
            dVar = f51959a;
        }
        return dVar;
    }

    @Override // d.b.h0.s.a.b
    public void a() {
        try {
            SapiAccountManager.getInstance().logout();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.b.h0.s.a.b
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

    @Override // d.b.h0.s.a.b
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
