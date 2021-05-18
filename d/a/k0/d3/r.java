package d.a.k0.d3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54022a;

    /* renamed from: b  reason: collision with root package name */
    public String f54023b;

    public String a() {
        return this.f54023b;
    }

    public boolean b() {
        return this.f54022a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f54022a = gconAccount.has_account.intValue() == 1;
        this.f54023b = gconAccount.menu_name;
    }
}
