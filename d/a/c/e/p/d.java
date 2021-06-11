package d.a.c.e.p;

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
    public static d f42507c;

    /* renamed from: a  reason: collision with root package name */
    public volatile SparseArray<Bitmap> f42508a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public Context f42509b;

    public d() {
        Bitmap.Config config = Bitmap.Config.RGB_565;
    }

    public static synchronized d d() {
        d dVar;
        synchronized (d.class) {
            if (f42507c == null) {
                f42507c = new d();
            }
            dVar = f42507c;
        }
        return dVar;
    }

    public byte[] a(Bitmap bitmap, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public synchronized void b() {
        this.f42508a.clear();
    }

    public Bitmap c(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public Bitmap e(Context context, int i2) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i2, new BitmapFactory.Options());
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public void f(Context context) {
        this.f42509b = context;
    }

    public Bitmap g(Bitmap bitmap, int i2, int i3) {
        if (i2 <= 0 || i3 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f2 = i3 / height;
            float f3 = i2 / width;
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
