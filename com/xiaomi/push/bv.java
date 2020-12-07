package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes18.dex */
public class bv extends bx {
    public bv(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static bv a(Context context, String str, int i) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String m190a = cb.a(context).m190a(str);
        if (TextUtils.isEmpty(m190a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m190a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new bv(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        if (this.f161a == null || this.f161a.length <= 0) {
            return;
        }
        this.f161a[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.cb.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a2 = ch.a(a());
            long j = bt.f142a;
            if (a2 <= j) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j2 = (long) (longValue * (((a2 - j) * 1.2d) / j));
            a(j2);
            bp.a(context).a("begin delete " + j2 + "noUpload messages , because db size is " + a2 + "B");
            super.a(context, obj);
        }
    }
}
