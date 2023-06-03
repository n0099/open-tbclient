package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class ay {
    public static Class<?> aou;

    public static String dV(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            return com.kwad.sdk.crash.utils.g.d(runtime.exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static Object f(String str, Object... objArr) {
        try {
            if (aou == null) {
                aou = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            }
            return q.c(aou, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str) {
        Object f = f(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, str);
        return f instanceof String ? (String) f : dV(str);
    }
}
