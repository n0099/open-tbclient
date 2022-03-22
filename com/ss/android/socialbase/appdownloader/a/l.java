package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.mapsdkplatform.comapi.map.ag;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
/* loaded from: classes7.dex */
public class l extends a {
    public l(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String c2 = this.f43006b.c("s");
        String a = com.ss.android.socialbase.appdownloader.f.c.a(this.f43006b.c(ag.f26685h), c2);
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f43006b.c("ah"), c2);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f43006b.c("ai"), c2);
        String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f43006b.c("aj"), c2);
        Intent intent = new Intent();
        intent.putExtra(a, this.f43007c);
        intent.putExtra(a2, "*/*");
        intent.putExtra(a3, true);
        intent.setAction(a4);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.addFlags(32768);
        return intent;
    }
}
