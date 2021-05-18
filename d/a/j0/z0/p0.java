package d.a.j0.z0;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SelectImageHelper;
/* loaded from: classes3.dex */
public class p0 {
    public static Bitmap a(Context context, Uri uri, int i2) {
        try {
            return BitmapHelper.subSampleBitmap(context, uri, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public static Bitmap b(Context context, String str, int i2) {
        try {
            return BitmapHelper.loadResizedBitmap(str, i2, i2);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public static Bitmap c(int i2, Context context, Uri uri, String str, int i3) {
        if (i2 == 12001) {
            return d(i3);
        }
        if (!TextUtils.isEmpty(str)) {
            return b(context, str, i3);
        }
        return a(context, uri, i3);
    }

    public static Bitmap d(int i2) {
        try {
            int e2 = e(FileHelper.getFileDireciory(SelectImageHelper.TMP_IMAGE_NAME));
            Bitmap subSampleBitmap = BitmapHelper.subSampleBitmap(SelectImageHelper.TMP_IMAGE_NAME, i2);
            return (e2 == 0 || subSampleBitmap == null) ? subSampleBitmap : BitmapHelper.rotateBitmapBydegree(subSampleBitmap, e2);
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
            return null;
        }
    }

    public static int e(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return 0;
        }
    }
}
