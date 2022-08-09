package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
/* loaded from: classes8.dex */
public class k extends a {
    public k(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.c);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
