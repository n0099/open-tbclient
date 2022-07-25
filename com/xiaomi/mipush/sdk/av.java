package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.bp;
import com.xiaomi.push.ho;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.ba;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class av {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            long j = sharedPreferences.getLong("last_sync_info", -1L);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long a = ba.a(context).a(ho.B.a(), 1209600);
            if (j != -1) {
                if (Math.abs(currentTimeMillis - j) <= a) {
                    return;
                }
                a(context, true);
            }
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void a(Context context, ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, iiVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.m89a("need to update local info with: " + iiVar.m481a());
            String str = iiVar.m481a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
            if (str != null) {
                MiPushClient.removeAcceptTime(context);
                String[] split = str.split("-");
                if (split.length == 2) {
                    MiPushClient.addAcceptTime(context, split[0], split[1]);
                    if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(split[0]) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(split[1])) {
                        b.m131a(context).a(true);
                    } else {
                        b.m131a(context).a(false);
                    }
                }
            }
            String str2 = iiVar.m481a().get(Constants.EXTRA_KEY_ALIASES);
            if (str2 != null) {
                MiPushClient.removeAllAliases(context);
                if (!"".equals(str2)) {
                    for (String str3 : str2.split(",")) {
                        MiPushClient.addAlias(context, str3);
                    }
                }
            }
            String str4 = iiVar.m481a().get(Constants.EXTRA_KEY_TOPICS);
            if (str4 != null) {
                MiPushClient.removeAllTopics(context);
                if (!"".equals(str4)) {
                    for (String str5 : str4.split(",")) {
                        MiPushClient.addTopic(context, str5);
                    }
                }
            }
            String str6 = iiVar.m481a().get(Constants.EXTRA_KEY_ACCOUNTS);
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
            com.xiaomi.push.al.a(context).a(new aw(context, z));
        }
    }

    public static String c(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            String a = bp.a(d(list));
            return (TextUtils.isEmpty(a) || a.length() <= 4) ? "" : a.substring(0, 4).toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static String d(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            String str = "";
            if (com.xiaomi.push.ag.a(list)) {
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
