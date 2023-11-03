package com.xiaomi.push;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
/* loaded from: classes10.dex */
public class r {
    public static String a(String str, String str2) {
        try {
            return (String) s.a(null, CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m186a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
