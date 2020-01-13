package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class d {
    public static boolean a(Context context, long j, long j2) {
        p.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        com.vivo.push.b.y yVar = new com.vivo.push.b.y(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        String b = z.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        yVar.a(hashMap);
        com.vivo.push.p.a().a(yVar);
        return true;
    }
}
