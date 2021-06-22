package d.a.o0.e3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f58049a;

    /* renamed from: b  reason: collision with root package name */
    public String f58050b;

    public String a() {
        return this.f58050b;
    }

    public boolean b() {
        return this.f58049a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f58049a = gconAccount.has_account.intValue() == 1;
        this.f58050b = gconAccount.menu_name;
    }
}
