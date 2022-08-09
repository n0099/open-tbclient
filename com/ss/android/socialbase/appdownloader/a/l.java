package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.mapsdkplatform.comapi.map.ag;
import com.baidu.searchbox.common.security.CacheDeviceInfo;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
/* loaded from: classes8.dex */
public class l extends a {
    public l(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String c = this.b.c("s");
        String a = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c(ag.h), c);
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ah"), c);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c(CacheDeviceInfo.JSON_KEY_ANDROID_ID), c);
        String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("aj"), c);
        Intent intent = new Intent();
        intent.putExtra(a, this.c);
        intent.putExtra(a2, "*/*");
        intent.putExtra(a3, true);
        intent.setAction(a4);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.addFlags(32768);
        return intent;
    }
}
