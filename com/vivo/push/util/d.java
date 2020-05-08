package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import com.vivo.push.b.aa;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class d {
    public static boolean a(Context context, long j, long j2) {
        p.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        aa aaVar = new aa(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Message.MESSAGE_ID, String.valueOf(j));
        String b = z.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        aaVar.a(hashMap);
        com.vivo.push.p.a().a(aaVar);
        return true;
    }
}
