package com.xiaomi.push.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class k {
    private static volatile k c;
    private Context a;
    private AccountManager b;
    private ArrayList<a> d;
    private OnAccountsUpdateListener e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, Context context);
    }

    private k(Context context) {
        this.a = context;
        if (com.xiaomi.channel.commonutils.android.f.b(this.a)) {
            this.b = AccountManager.get(this.a);
            this.d = new ArrayList<>();
        }
    }

    public static k a(Context context) {
        if (c == null) {
            synchronized (k.class) {
                if (c == null) {
                    c = new k(context);
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.d == null || this.d.size() < 1) {
            return;
        }
        Iterator<a> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(str, this.a);
        }
    }

    private void d() {
        if (this.e != null) {
            return;
        }
        this.e = new l(this);
    }

    private String e() {
        Account a2 = com.xiaomi.channel.commonutils.android.f.a(this.a);
        return a2 == null ? "" : a2.name;
    }

    public void a(a aVar) {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        if (aVar != null) {
            int size = this.d.size();
            this.d.add(aVar);
            if (size != 0 || a()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.a("MIIDManager startMIIDUpdateListener failed cause lack of GET_ACCOUNTS permission");
        }
    }

    public boolean a() {
        try {
            if (com.xiaomi.channel.commonutils.android.f.b(this.a)) {
                if (this.e == null) {
                    d();
                }
                this.b.addOnAccountsUpdatedListener(this.e, null, true);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return false;
        }
    }

    public void b() {
        if (com.xiaomi.channel.commonutils.android.f.b(this.a) && this.e != null) {
            this.b.removeOnAccountsUpdatedListener(this.e);
        }
    }

    public void b(a aVar) {
        if (this.d == null || aVar == null) {
            return;
        }
        this.d.remove(aVar);
        if (this.d.size() == 0) {
            b();
        }
    }

    public String c() {
        String e = e();
        if (TextUtils.isEmpty(e)) {
            m.a(this.a).a("0");
            return "0";
        }
        m.a(this.a).a(e);
        return e;
    }
}
