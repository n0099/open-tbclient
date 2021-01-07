package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f13821a = new e();

    public Map<Integer, Integer> a(Context context) {
        Map<Integer, Integer> map;
        z f = f13821a.f(context);
        return (f == null || (map = f.h) == null) ? new HashMap() : map;
    }

    public void a(Context context, z zVar) {
        aj.a(e(context), zVar.a());
    }

    public String b(Context context) {
        StringBuilder sb = new StringBuilder();
        z f = f13821a.f(context);
        if (f != null) {
            sb.append(f.d);
            sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            sb.append(f.f);
        }
        return sb.toString();
    }

    public long c(Context context) {
        z f = f13821a.f(context);
        if (f != null) {
            long j = f.i;
            if (j > 0) {
                return j;
            }
        }
        return 57600L;
    }

    public void d(Context context) {
        try {
            new File(e(context)).delete();
        } catch (Throwable th) {
        }
    }

    public String e(Context context) {
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        File file = new File(dir.getAbsolutePath() + File.separator + Constants.VIA_REPORT_TYPE_SET_AVATAR);
        return (file.exists() || file.mkdirs()) ? file.getAbsolutePath() + File.separator + af.f13767a + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "auMini" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "1" : "";
    }

    public final z f(Context context) {
        try {
            z zVar = new z();
            zVar.a(new ao(aj.a(e(context))));
            return zVar;
        } catch (Throwable th) {
            return null;
        }
    }
}
