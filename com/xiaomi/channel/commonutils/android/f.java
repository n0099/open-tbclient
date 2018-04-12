package com.xiaomi.channel.commonutils.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
/* loaded from: classes3.dex */
public class f {
    public static Account a(Context context) {
        Account[] accountsByType;
        try {
            if (b(context) && (accountsByType = AccountManager.get(context).getAccountsByType("com.xiaomi")) != null && accountsByType.length > 0) {
                return accountsByType[0];
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return null;
        }
    }

    public static boolean b(Context context) {
        return context.getPackageManager().checkPermission("android.permission.GET_ACCOUNTS", context.getPackageName()) == 0;
    }
}
