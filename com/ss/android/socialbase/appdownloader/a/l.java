package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.mapsdkplatform.comapi.map.ag;
/* loaded from: classes4.dex */
public class l extends a {
    public l(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String c2 = this.f59749b.c("s");
        String a = com.ss.android.socialbase.appdownloader.f.c.a(this.f59749b.c(ag.f35870h), c2);
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f59749b.c("ah"), c2);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f59749b.c("ai"), c2);
        String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f59749b.c("aj"), c2);
        Intent intent = new Intent();
        intent.putExtra(a, this.f59750c);
        intent.putExtra(a2, "*/*");
        intent.putExtra(a3, true);
        intent.setAction(a4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
