package d.a.j0.d3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53315a;

    /* renamed from: b  reason: collision with root package name */
    public String f53316b;

    public String a() {
        return this.f53316b;
    }

    public boolean b() {
        return this.f53315a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f53315a = gconAccount.has_account.intValue() == 1;
        this.f53316b = gconAccount.menu_name;
    }
}
