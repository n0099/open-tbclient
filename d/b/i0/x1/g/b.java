package d.b.i0.x1.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import d.b.b.d.a;
import d.b.b.e.p.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes3.dex */
public class b {
    public static Bitmap a(String str) {
        Bitmap bitmap = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                if (c(file)) {
                    d.b.b.j.d.a aVar = a.C0533a.b().get(str);
                    if (aVar != null) {
                        bitmap = aVar.p();
                    }
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    bitmap = BitmapHelper.loadResizedBitmap(str, options.outWidth, options.outHeight);
                }
            }
        } catch (OutOfMemoryError unused) {
        }
        return bitmap;
    }

    public static Bitmap b(ImageFileInfo imageFileInfo) {
        Bitmap f2;
        d.b.h0.b0.b bVar = new d.b.h0.b0.b();
        d.b.b.j.d.a c2 = bVar.c(imageFileInfo, true);
        if (c2 != null) {
            f2 = c2.p();
        } else {
            f2 = bVar.f(imageFileInfo, true);
        }
        return f2 == null ? a(imageFileInfo.getFilePath()) : f2;
    }

    public static boolean c(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[7];
            r1 = fileInputStream.read(bArr, 0, 6) == 6 ? l.A(bArr) : false;
            fileInputStream.close();
        } catch (FileNotFoundException e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return r1;
        } catch (IOException e6) {
            e = e6;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return r1;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
        if (0 != 0) {
            fileInputStream2.close();
        }
        return r1;
    }
}
