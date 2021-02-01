package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes15.dex */
public class bh {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13514a = ab.a("turingfd_protect_").append(af.f13469a).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(47).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append("auMini").toString();

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences(f13514a, 0);
    }

    public static void a(Context context, String str, int i) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putInt(str, i);
            edit.commit();
        } catch (Throwable th) {
        }
    }

    public static void b(Context context) {
        try {
            int i = a(context).getInt("301", 0);
            SharedPreferences.Editor edit = a(context).edit();
            edit.putInt("301", i);
            edit.commit();
        } catch (Throwable th) {
        }
    }

    public static int c(Context context) {
        return a(context).getInt("301", 0);
    }
}
