package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.bm;
import com.xiaomi.push.hk;
import com.xiaomi.push.ie;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class au {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            long j2 = sharedPreferences.getLong("last_sync_info", -1L);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long a = com.xiaomi.push.service.aq.a(context).a(hk.B.a(), 1209600);
            if (j2 != -1) {
                if (Math.abs(currentTimeMillis - j2) <= a) {
                    return;
                }
                a(context, true);
            }
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void a(Context context, ie ieVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, ieVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.m122a("need to update local info with: " + ieVar.m518a());
            String str = ieVar.m518a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
            if (str != null) {
                MiPushClient.removeAcceptTime(context);
                String[] split = str.split("-");
                if (split.length == 2) {
                    MiPushClient.addAcceptTime(context, split[0], split[1]);
                    if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                        b.m163a(context).a(true);
                    } else {
                        b.m163a(context).a(false);
                    }
                }
            }
            String str2 = ieVar.m518a().get(Constants.EXTRA_KEY_ALIASES);
            if (str2 != null) {
                MiPushClient.removeAllAliases(context);
                if (!"".equals(str2)) {
                    for (String str3 : str2.split(",")) {
                        MiPushClient.addAlias(context, str3);
                    }
                }
            }
            String str4 = ieVar.m518a().get(Constants.EXTRA_KEY_TOPICS);
            if (str4 != null) {
                MiPushClient.removeAllTopics(context);
                if (!"".equals(str4)) {
                    for (String str5 : str4.split(",")) {
                        MiPushClient.addTopic(context, str5);
                    }
                }
            }
            String str6 = ieVar.m518a().get(Constants.EXTRA_KEY_ACCOUNTS);
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
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, context, z) == null) {
            com.xiaomi.push.ai.a(context).a(new av(context, z));
        }
    }

    public static String c(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            String a = bm.a(d(list));
            return (TextUtils.isEmpty(a) || a.length() <= 4) ? "" : a.substring(0, 4).toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static String d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
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
        return (String) invokeL.objValue;
    }
}
