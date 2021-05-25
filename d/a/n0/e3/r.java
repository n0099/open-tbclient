package d.a.n0.e3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54235a;

    /* renamed from: b  reason: collision with root package name */
    public String f54236b;

    public String a() {
        return this.f54236b;
    }

    public boolean b() {
        return this.f54235a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f54235a = gconAccount.has_account.intValue() == 1;
        this.f54236b = gconAccount.menu_name;
    }
}
