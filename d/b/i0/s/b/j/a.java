package d.b.i0.s.b.j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import com.baidu.tieba.aiapps.apps.permission.PermissionActivity;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f61396a;

    @TargetApi(23)
    public static void a(Context context) {
        List<String> list = f61396a;
        if (list == null) {
            f61396a = new ArrayList();
        } else {
            list.clear();
        }
        if (context.checkSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) != 0) {
            f61396a.add(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            f61396a.add("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    @TargetApi(23)
    public static boolean b(Context context, int i, String[] strArr, int[] iArr) {
        if (strArr.length >= 1 || iArr.length >= 1) {
            if (!c(context)) {
                d(context);
                return true;
            } else if (context instanceof PermissionActivity) {
                ((Activity) context).finish();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @TargetApi(23)
    public static boolean c(Context context) {
        return context.checkSelfPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0;
    }

    @TargetApi(23)
    public static void d(Context context) {
        if (!c(context)) {
            a(context);
            List<String> list = f61396a;
            ((Activity) context).requestPermissions((String[]) list.toArray(new String[list.size()]), 102);
        } else if (context instanceof PermissionActivity) {
            ((Activity) context).finish();
        }
    }
}
