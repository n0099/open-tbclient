package d.a.i0.z0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class h {
    public static Bitmap a(View view) {
        Bitmap bitmap = null;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        try {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                return createBitmap;
            } catch (OutOfMemoryError e2) {
                BdLog.e(e2);
                return bitmap;
            }
        } catch (OutOfMemoryError unused) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(bitmap));
            return bitmap;
        }
    }

    public static float[] b(Bitmap bitmap, Matrix matrix) {
        float[] fArr = new float[8];
        matrix.mapPoints(fArr, new float[]{0.0f, 0.0f, bitmap.getWidth(), 0.0f, 0.0f, bitmap.getHeight(), bitmap.getWidth(), bitmap.getHeight()});
        return fArr;
    }

    public static Bitmap c(Bitmap bitmap, Bitmap bitmap2, int i2, int i3) {
        Bitmap bitmap3;
        if (bitmap == null || bitmap2 == null || i2 <= 0 || i3 <= 0) {
            return null;
        }
        try {
            bitmap3 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            bitmap3 = null;
        }
        try {
            Canvas canvas = new Canvas(bitmap3);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            return bitmap3;
        } catch (OutOfMemoryError unused2) {
            try {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap3 = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                Canvas canvas2 = new Canvas(bitmap3);
                canvas2.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                canvas2.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return bitmap3;
            } catch (OutOfMemoryError e2) {
                BdLog.e(e2);
                return bitmap3;
            }
        }
    }
}
