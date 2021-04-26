package com.kwad.sdk.collector;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class e {
    @Nullable
    public static JSONArray a(Context context) {
        return f.a(b(context));
    }

    @Nullable
    public static List<f> b(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    int a2 = x.a(context, str);
                    arrayList.add(new f(str, a2 == 0 ? f.f32719b : a2 == -1 ? f.f32720c : f.f32718a));
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
    }
}
