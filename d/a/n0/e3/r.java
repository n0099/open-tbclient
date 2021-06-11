package d.a.n0.e3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f57924a;

    /* renamed from: b  reason: collision with root package name */
    public String f57925b;

    public String a() {
        return this.f57925b;
    }

    public boolean b() {
        return this.f57924a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f57924a = gconAccount.has_account.intValue() == 1;
        this.f57925b = gconAccount.menu_name;
    }
}
