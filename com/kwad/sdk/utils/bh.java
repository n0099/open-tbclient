package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class bh {
    public static Class<?> aOD;

    public static <T> T a(String str, T t, com.kwad.sdk.g.b<String, T> bVar) {
        String gj = gj(str);
        if (gj == null) {
            return t;
        }
        try {
            return bVar.apply(gj);
        } catch (Throwable unused) {
            return t;
        }
    }

    public static String get(String str) {
        Object j = j(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, str);
        if (j instanceof String) {
            return (String) j;
        }
        return gj(str);
    }

    public static String gj(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            return com.kwad.sdk.crash.utils.h.c(runtime.exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return null;
        }
    }

    public static String get(String str, String str2) {
        Object j = j(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, str, str2);
        if (j instanceof String) {
            return (String) j;
        }
        return (String) a(str, str2, new com.kwad.sdk.g.b<String, String>() { // from class: com.kwad.sdk.utils.bh.1
            public static String gk(String str3) {
                return str3;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ String apply(String str3) {
                return gk(str3);
            }
        });
    }

    public static boolean getBoolean(String str, boolean z) {
        Object j = j("getBoolean", str, Boolean.valueOf(z));
        if (j instanceof Boolean) {
            return ((Boolean) j).booleanValue();
        }
        return ((Boolean) a(str, Boolean.valueOf(z), new com.kwad.sdk.g.b<String, Boolean>() { // from class: com.kwad.sdk.utils.bh.4
            public static Boolean gn(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(String str2) {
                return gn(str2);
            }
        })).booleanValue();
    }

    public static int getInt(String str, int i) {
        Object j = j("getInt", str, Integer.valueOf(i));
        if (j instanceof Integer) {
            return ((Integer) j).intValue();
        }
        return ((Integer) a(str, Integer.valueOf(i), new com.kwad.sdk.g.b<String, Integer>() { // from class: com.kwad.sdk.utils.bh.2
            public static Integer gl(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Integer apply(String str2) {
                return gl(str2);
            }
        })).intValue();
    }

    public static long getLong(String str, long j) {
        Object j2 = j("getLong", str, Long.valueOf(j));
        if (j2 instanceof Long) {
            return ((Long) j2).longValue();
        }
        return ((Long) a(str, Long.valueOf(j), new com.kwad.sdk.g.b<String, Long>() { // from class: com.kwad.sdk.utils.bh.3
            public static Long gm(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Long apply(String str2) {
                return gm(str2);
            }
        })).longValue();
    }

    @SuppressLint({"PrivateApi"})
    public static Object j(String str, Object... objArr) {
        try {
            if (aOD == null) {
                aOD = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            }
            return s.b(aOD, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return null;
        }
    }
}
