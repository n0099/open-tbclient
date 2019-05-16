package com.xiaomi.channel.commonutils.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes3.dex */
public class e {
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
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager.checkPermission("android.permission.GET_ACCOUNTS", packageName) != 0) {
                if (packageManager.checkPermission("android.permission.GET_ACCOUNTS_PRIVILEGED", packageName) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
