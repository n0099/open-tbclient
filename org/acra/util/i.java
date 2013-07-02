package org.acra.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
/* loaded from: classes.dex */
public final class i {
    public static void a(Context context, int i, int i2) {
        try {
            Toast.makeText(context, i, i2).show();
        } catch (RuntimeException e) {
            Log.e(org.acra.a.a, "Could not send crash Toast", e);
        }
    }
}
