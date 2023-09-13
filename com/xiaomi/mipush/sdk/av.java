package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.xiaomi.push.bo;
import com.xiaomi.push.hm;
import com.xiaomi.push.ig;
import com.xiaomi.push.service.ba;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class av {
    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a = ba.a(context).a(hm.SyncInfoFrequency.a(), 1209600);
        if (j != -1) {
            if (Math.abs(currentTimeMillis - j) <= a) {
                return;
            }
            a(context, true);
        }
        sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
    }

    public static void a(Context context, ig igVar) {
        com.xiaomi.channel.commonutils.logger.b.m181a("need to update local info with: " + igVar.m641a());
        String str = igVar.m641a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(split[0]) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(split[1])) {
                    b.m225a(context).a(true);
                } else {
                    b.m225a(context).a(false);
                }
            }
        }
        String str2 = igVar.m641a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(",")) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = igVar.m641a().get(Constants.EXTRA_KEY_TOPICS);
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(",")) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = igVar.m641a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if ("".equals(str6)) {
                return;
            }
            for (String str7 : str6.split(",")) {
                MiPushClient.addAccount(context, str7);
            }
        }
    }

    public static void a(Context context, boolean z) {
        com.xiaomi.push.aj.a(context).a(new aw(context, z));
    }

    public static String c(List<String> list) {
        String a = bo.a(d(list));
        return (TextUtils.isEmpty(a) || a.length() <= 4) ? "" : a.substring(0, 4).toLowerCase();
    }

    public static String d(List<String> list) {
        String str = "";
        if (com.xiaomi.push.ad.a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }
}
