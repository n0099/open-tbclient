package d.b.j0.d3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f55470a;

    /* renamed from: b  reason: collision with root package name */
    public String f55471b;

    public String a() {
        return this.f55471b;
    }

    public boolean b() {
        return this.f55470a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f55470a = gconAccount.has_account.intValue() == 1;
        this.f55471b = gconAccount.menu_name;
    }
}
