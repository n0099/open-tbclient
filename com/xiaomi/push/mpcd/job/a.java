package com.xiaomi.push.mpcd.job;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a extends g {
    public a(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 7;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        StringBuilder sb = new StringBuilder();
        try {
            Account[] accounts = AccountManager.get(this.d).getAccounts();
            for (int i = 0; i < Math.min(accounts.length, 10); i++) {
                Account account = accounts[i];
                if (i > 0) {
                    sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
                sb.append(account.name).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(account.type);
            }
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    protected boolean c() {
        return this.d.getPackageManager().checkPermission("android.permission.GET_ACCOUNTS", this.d.getPackageName()) == 0;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.Account;
    }
}
