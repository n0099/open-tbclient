package d.a.d0.a.k;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.baidu.mobads.container.util.SdcardUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class i {
    public static String a(String str) {
        return str + SdcardUtils.DEFAULT_CACHE_PATH;
    }

    public static File b(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return context.getExternalFilesDir(null);
            }
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (f.a(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && f.b("permission_storage")) {
                    return c();
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    return context.getExternalFilesDir(null);
                }
                return context.getFilesDir();
            }
            return context.getFilesDir();
        } catch (Exception e2) {
            b.i().h("TAG", e2.getMessage());
            return null;
        }
    }

    public static File c() {
        return Environment.getExternalStorageDirectory();
    }

    public static String d(Context context) {
        return e(context, SdcardUtils.DEFAULT_SD_CARD_PATH);
    }

    public static String e(Context context, String str) {
        try {
            return a(b(context).getPath());
        } catch (Throwable unused) {
            return a(str);
        }
    }
}
