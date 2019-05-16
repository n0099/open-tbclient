package com.xiaomi.push.service;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class o {
    private static volatile o d;
    private Context a;
    private Object b = new Object();
    private AccountManager c;
    private ArrayList<a> e;
    private OnAccountsUpdateListener f;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, Context context);
    }

    private o(Context context) {
        this.a = context;
        if (com.xiaomi.channel.commonutils.android.e.b(this.a)) {
            this.c = AccountManager.get(this.a);
            this.e = new ArrayList<>();
        }
    }

    public static o a(Context context) {
        if (d == null) {
            synchronized (o.class) {
                if (d == null) {
                    d = new o(context);
                }
            }
        }
        return d;
    }

    private void a(String str) {
        synchronized (this.b) {
            if (this.e == null || this.e.size() < 1) {
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(str, this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Account[] accountArr) {
        Account account;
        boolean z = false;
        if (accountArr == null || accountArr.length <= 0) {
            return;
        }
        int length = accountArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                account = accountArr[i];
                if (account != null && TextUtils.equals("com.xiaomi", account.type)) {
                    break;
                }
                i++;
            } else {
                account = null;
                break;
            }
        }
        if (account != null && !TextUtils.isEmpty(account.name)) {
            z = true;
        }
        boolean c = r.a(this.a).c();
        if (z && !c) {
            r.a(this.a).a(account.name);
            a(account.name);
        } else if (!z && c) {
            r.a(this.a).a();
            a("0");
        } else if (z && c && !TextUtils.equals(r.a(this.a).b(), account.name)) {
            r.a(this.a).a(account.name);
            a(account.name);
        }
    }

    private void d() {
        if (this.f != null) {
            return;
        }
        this.f = new p(this);
    }

    private String e() {
        Account a2 = com.xiaomi.channel.commonutils.android.e.a(this.a);
        return a2 == null ? "" : a2.name;
    }

    public void a(a aVar) {
        synchronized (this.b) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            if (aVar != null) {
                int size = this.e.size();
                this.e.add(aVar);
                if (size == 0 && !a()) {
                    com.xiaomi.channel.commonutils.logger.b.a("MIIDManager startMIIDUpdateListener failed cause lack of GET_ACCOUNTS permission");
                }
            }
        }
    }

    public boolean a() {
        try {
            if (com.xiaomi.channel.commonutils.android.e.b(this.a)) {
                if (this.f == null) {
                    d();
                }
                this.c.addOnAccountsUpdatedListener(this.f, null, true);
                return true;
            }
            return false;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return false;
        }
    }

    public void b() {
        if (com.xiaomi.channel.commonutils.android.e.b(this.a) && this.f != null) {
            this.c.removeOnAccountsUpdatedListener(this.f);
        }
    }

    public void b(a aVar) {
        synchronized (this.b) {
            if (this.e == null) {
                return;
            }
            if (aVar != null) {
                this.e.remove(aVar);
                if (this.e.size() == 0) {
                    b();
                }
            }
        }
    }

    public String c() {
        String e = e();
        if (TextUtils.isEmpty(e)) {
            r.a(this.a).a("0");
            return "0";
        }
        r.a(this.a).a(e);
        return e;
    }
}
