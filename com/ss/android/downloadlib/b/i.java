package com.ss.android.downloadlib.b;

import android.os.Build;
import androidx.annotation.NonNull;
/* loaded from: classes10.dex */
public class i {
    public static boolean a(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        if (com.ss.android.socialbase.appdownloader.f.d.d() && Build.VERSION.SDK_INT < 29 && com.ss.android.downloadlib.addownload.j.k() != null && com.ss.android.downloadlib.addownload.j.k().a() && com.ss.android.downloadlib.g.e.a(aVar).b("invoke_app_form_background_switch") == 1 && aVar.q()) {
            return true;
        }
        return false;
    }
}
