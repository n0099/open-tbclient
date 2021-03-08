package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes6.dex */
public class f extends a {
    public f(Context context, String str) {
        super(context, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.b.e.c + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.b);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
