package com.xiaomi.push.service;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class l implements OnAccountsUpdateListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // android.accounts.OnAccountsUpdateListener
    public void onAccountsUpdated(Account[] accountArr) {
        Account account;
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
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
        context = this.a.a;
        boolean c = m.a(context).c();
        if (z && !c) {
            context5 = this.a.a;
            m.a(context5).a(account.name);
            this.a.a(account.name);
        } else if (!z && c) {
            context4 = this.a.a;
            m.a(context4).a();
            this.a.a("0");
        } else if (z && c) {
            context2 = this.a.a;
            if (TextUtils.equals(m.a(context2).b(), account.name)) {
                return;
            }
            context3 = this.a.a;
            m.a(context3).a(account.name);
            this.a.a(account.name);
        }
    }
}
