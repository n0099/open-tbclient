package com.yanzhenjie.permission;

import android.content.Context;
import com.baidu.webkit.sdk.PermissionRequest;
import com.yanzhenjie.permission.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class e {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List<String> c(Context context, List<String> list) {
        char c;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            switch (str.hashCode()) {
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 463403621:
                    if (str.equals(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1365911975:
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    String string = context.getString(f.a.permission_name_camera);
                    if (arrayList.contains(string)) {
                        break;
                    } else {
                        arrayList.add(string);
                        break;
                    }
                case 1:
                case 2:
                    String string2 = context.getString(f.a.permission_name_storage);
                    if (arrayList.contains(string2)) {
                        break;
                    } else {
                        arrayList.add(string2);
                        break;
                    }
            }
        }
        return arrayList;
    }
}
