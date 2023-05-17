package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
/* loaded from: classes10.dex */
public class f extends a {
    public f(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
