package org.acra;

import android.content.Context;
import android.util.Log;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j {
    private final Context a;

    public j(Context context) {
        this.a = context;
    }

    public String[] a() {
        if (this.a == null) {
            Log.e(a.a, "Trying to get ACRA reports but ACRA is not initialized.");
            return new String[0];
        }
        File filesDir = this.a.getFilesDir();
        if (filesDir == null) {
            Log.w(a.a, "Application files directory does not exist! The application may not be installed correctly. Please try reinstalling.");
            return new String[0];
        }
        Log.d(a.a, "Looking for error files in " + filesDir.getAbsolutePath());
        String[] list = filesDir.list(new k(this));
        return list == null ? new String[0] : list;
    }
}
