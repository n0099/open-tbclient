package com.bytedance.tea.crash.g;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class k {
    public static void a(com.bytedance.tea.crash.c.a aVar, com.bytedance.tea.crash.c.b bVar, com.bytedance.tea.crash.c cVar) {
        if (aVar != null && aVar.a() != null && cVar != null) {
            JSONObject a2 = aVar.a();
            long optLong = a2.optLong("crash_time");
            int b2 = b(a("aid"));
            String a3 = com.bytedance.tea.crash.h.esH().a();
            if (optLong > 0 && b2 > 0 && !TextUtils.isEmpty(a3) && !"0".equals(a3) && !TextUtils.isEmpty(cVar.a())) {
                try {
                    String str = "android_" + b2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + a3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optLong + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + cVar;
                    if (bVar != null) {
                        JSONObject a4 = bVar.a();
                        if (a4 != null) {
                            a4.put("unique_key", str);
                        }
                    } else {
                        a2.put("unique_key", str);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String a(String str) {
        Map<String, Object> a2;
        if (com.bytedance.tea.crash.h.esF() != null && (a2 = com.bytedance.tea.crash.h.esF().a()) != null) {
            Object obj = a2.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            j.b(e);
            return 0;
        }
    }
}
