package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.cg;
/* loaded from: classes7.dex */
public class ca extends cc {
    public ca(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static ca a(Context context, String str, int i2) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String m202a = cg.a(context).m202a(str);
        if (TextUtils.isEmpty(m202a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m202a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new ca(str, sb.toString(), new String[]{String.valueOf(i2)}, "a job build to delete history message");
    }

    private void a(long j) {
        String[] strArr = ((cg.d) this).f183a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.cg.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a2 = cm.a(m204a());
            long j = by.f164a;
            if (a2 <= j) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j2 = (long) ((((a2 - j) * 1.2d) / j) * longValue);
            a(j2);
            bu a3 = bu.a(context);
            a3.a("begin delete " + j2 + "noUpload messages , because db size is " + a2 + "B");
            super.a(context, obj);
        }
    }
}
