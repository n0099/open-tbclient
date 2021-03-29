package d.b.i0.c3;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53605a;

    /* renamed from: b  reason: collision with root package name */
    public String f53606b;

    public String a() {
        return this.f53606b;
    }

    public boolean b() {
        return this.f53605a;
    }

    public void c(GconAccount gconAccount) {
        if (gconAccount == null) {
            return;
        }
        this.f53605a = gconAccount.has_account.intValue() == 1;
        this.f53606b = gconAccount.menu_name;
    }
}
