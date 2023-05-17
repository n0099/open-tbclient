package com.meizu.cloud.pushsdk.b;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
/* loaded from: classes9.dex */
public class i {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.b.b.d a = com.meizu.cloud.pushsdk.b.b.a.a(CountryCodeBean.ANDRIOD_SYSTEMPROP).a(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).a(str);
        if (a.a) {
            return (String) a.b;
        }
        return null;
    }
}
