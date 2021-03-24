package d.b.i0.c3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53604a;

    /* renamed from: b  reason: collision with root package name */
    public String f53605b;

    public String a() {
        return this.f53605b;
    }

    public boolean b() {
        return this.f53604a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f53604a = gconAccount.has_account.intValue() == 1;
        this.f53605b = gconAccount.menu_name;
    }
}
