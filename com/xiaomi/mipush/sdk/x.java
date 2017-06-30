package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.service.ah;
import com.xiaomi.xmpush.thrift.ae;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class x {
    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a = ah.a(context).a(com.xiaomi.xmpush.thrift.e.SyncInfoFrequency.a(), 1209600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) > a) {
            a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void a(Context context, ae aeVar) {
        com.xiaomi.channel.commonutils.logger.b.a("need to update local info with: " + aeVar.i());
        String str = aeVar.i().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    a.a(context).a(true);
                } else {
                    a.a(context).a(false);
                }
            }
        }
        String str2 = aeVar.i().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (String str3 : split2) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = aeVar.i().get(Constants.EXTRA_KEY_TOPICS);
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                String[] split3 = str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (String str5 : split3) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = aeVar.i().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if ("".equals(str6)) {
                return;
            }
            String[] split4 = str6.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String str7 : split4) {
                MiPushClient.addAccount(context, str7);
            }
        }
    }

    public static void a(Context context, boolean z) {
        com.xiaomi.channel.commonutils.misc.f.a(context).a(new y(context, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(List<String> list) {
        String a = com.xiaomi.channel.commonutils.string.d.a(d(list));
        return (TextUtils.isEmpty(a) || a.length() <= 4) ? "" : a.substring(0, 4).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(List<String> list) {
        if (com.xiaomi.channel.commonutils.misc.b.a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        String str = "";
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }
}
