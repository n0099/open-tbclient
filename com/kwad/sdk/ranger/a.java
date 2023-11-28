package com.kwad.sdk.ranger;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.ranger.d;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import java.util.List;
/* loaded from: classes10.dex */
public final class a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();

    public static void a(Activity activity, @NonNull List<d.a> list) {
        try {
            for (d.a aVar : list) {
                if (aVar != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.aLF)) {
                        str = aVar.aLF;
                    } else if (!TextUtils.isEmpty(aVar.aLG) && activity.getClass().getName().startsWith(aVar.aLF)) {
                        str = e(activity, aVar.aLG);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int b = y.b("ksadsdk_perf_ranger_v2", str, 0) + 1;
                        y.a("ksadsdk_perf_ranger_v2", str, b);
                        String str2 = TAG;
                        com.kwad.sdk.core.e.c.d(str2, "act:" + str + " num:" + b);
                    }
                }
            }
        } catch (Throwable th) {
            String str3 = TAG;
            com.kwad.sdk.core.e.c.e(str3, "record:" + Log.getStackTraceString(th));
        }
    }

    public static void a(@NonNull d dVar) {
        final List<d.a> list = dVar.aLD;
        if (list != null && !list.isEmpty()) {
            com.kwad.sdk.core.c.b.Ct();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.ranger.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityCreated */
                public final void a(Activity activity, Bundle bundle) {
                    super.a(activity, bundle);
                    try {
                        a.a(activity, list);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.e(a.TAG, Log.getStackTraceString(th));
                    }
                }
            });
        }
    }

    public static String e(Object obj, String str) {
        Object field;
        if (!TextUtils.isEmpty(str) && (field = s.getField(obj, str)) != null) {
            return field.getClass().getName();
        }
        return "";
    }
}
