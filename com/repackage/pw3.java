package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes6.dex */
public interface pw3 {
    boolean a(@NonNull Context context, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull hn3 hn3Var);

    boolean b(Context context, String str, String str2, String str3);

    boolean c();

    String getPackageName();

    void init();
}
