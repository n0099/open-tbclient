package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes4.dex */
public class j extends a {
    public j(Context context) {
        super(context, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
