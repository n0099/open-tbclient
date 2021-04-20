package d.b.c.e.p;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.SparseArray;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f42496c;

    /* renamed from: a  reason: collision with root package name */
    public volatile SparseArray<Bitmap> f42497a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f42498b;

    public d() {
        Bitmap.Config config = Bitmap.Config.RGB_565;
    }

    public static synchronized d d() {
        d dVar;
        synchronized (d.class) {
            if (f42496c == null) {
                f42496c = new d();
            }
            dVar = f42496c;
        }
        return dVar;
    }

    public byte[] a(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public synchronized void b() {
        this.f42497a.clear();
    }

    public Bitmap c(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public Bitmap e(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public void f(Context context) {
        this.f42498b = context;
    }

    public Bitmap g(Bitmap bitmap, int i, int i2) {
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f2 = i2 / height;
            float f3 = i / width;
            if (f2 > f3) {
                f2 = f3;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f2, f2);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }
}
