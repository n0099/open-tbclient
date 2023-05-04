package com.xiaomi.push;

import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
/* loaded from: classes9.dex */
public class r {
    public static String a(String str, String str2) {
        try {
            return (String) s.a(null, CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m101a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
