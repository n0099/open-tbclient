package d.b.i0.d3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f55049a;

    /* renamed from: b  reason: collision with root package name */
    public String f55050b;

    public String a() {
        return this.f55050b;
    }

    public boolean b() {
        return this.f55049a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f55049a = gconAccount.has_account.intValue() == 1;
        this.f55050b = gconAccount.menu_name;
    }
}
