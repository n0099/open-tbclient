package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ci;
/* loaded from: classes10.dex */
public class cc extends ce {
    public cc(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static cc a(Context context, String str, int i) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String m327a = ci.a(context).m327a(str);
        if (TextUtils.isEmpty(m327a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m327a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new cc(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        String[] strArr = ((ci.d) this).f178a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.ci.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = co.a(m329a());
            long j = ca.f161a;
            if (a <= j) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j2 = (long) ((((a - j) * 1.2d) / j) * longValue);
            a(j2);
            bw a2 = bw.a(context);
            a2.a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
            super.a(context, obj);
        }
    }
}
