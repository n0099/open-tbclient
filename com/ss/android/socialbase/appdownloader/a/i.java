package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes4.dex */
public class i extends a {
    public i(Context context, String str) {
        super(context, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.f13008b);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
