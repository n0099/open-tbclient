package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public class bq extends bs {
    public bq(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static bq a(Context context, String str, int i) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String m170a = bw.a(context).m170a(str);
        if (TextUtils.isEmpty(m170a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m170a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new bq(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        if (this.f173a == null || this.f173a.length <= 0) {
            return;
        }
        this.f173a[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.bw.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = cc.a(a());
            long j = bo.f156a;
            if (a <= j) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j2 = (long) (longValue * (((a - j) * 1.2d) / j));
            a(j2);
            bk.a(context).a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
            super.a(context, obj);
        }
    }
}
