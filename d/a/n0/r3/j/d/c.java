package d.a.n0.r3.j.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class c {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f60084a;

        /* renamed from: b  reason: collision with root package name */
        public int f60085b;

        /* renamed from: c  reason: collision with root package name */
        public int f60086c;

        public a(int i2, int i3) {
            this.f60084a = i2;
            this.f60085b = i3;
        }
    }

    public static boolean a(Bitmap bitmap, ArrayList<a> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            int i2 = next.f60084a;
            int i3 = next.f60085b;
            if (i2 >= bitmap.getWidth() || i3 >= bitmap.getHeight()) {
                return false;
            }
            int pixel = bitmap.getPixel(i2, i3);
            if (sparseArray.get(pixel) != null) {
                return false;
            }
            next.f60086c = pixel;
            sparseArray.put(pixel, next);
        }
        return true;
    }

    public static Bitmap b(byte[] bArr, int i2, int i3) {
        Bitmap bitmap = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new YuvImage(bArr, 17, i2, i3, null).compressToJpeg(new Rect(0, 0, i2, i3), 100, byteArrayOutputStream);
            bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream.close();
            return bitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap;
        }
    }

    public static void c(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(UtilHelper.getUriFromFile(new File(str), intent, context));
            context.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    public static void d(byte[] bArr, int[] iArr, int i2, int i3) {
        int i4 = i2 * i3;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            while (i8 < i2) {
                int i9 = iArr[i6];
                int i10 = (iArr[i6] & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                int i11 = (iArr[i6] & 65280) >> 8;
                int i12 = 255;
                int i13 = (iArr[i6] & 255) >> 0;
                int i14 = (((((i10 * 66) + (i11 * 129)) + (i13 * 25)) + 128) >> 8) + 16;
                int i15 = (((((i10 * (-38)) - (i11 * 74)) + (i13 * 112)) + 128) >> 8) + 128;
                int i16 = (((((i10 * 112) - (i11 * 94)) - (i13 * 18)) + 128) >> 8) + 128;
                int i17 = i5 + 1;
                if (i14 < 0) {
                    i14 = 0;
                } else if (i14 > 255) {
                    i14 = 255;
                }
                bArr[i5] = (byte) i14;
                if (i7 % 2 == 0 && i6 % 2 == 0) {
                    int i18 = i4 + 1;
                    if (i16 < 0) {
                        i16 = 0;
                    } else if (i16 > 255) {
                        i16 = 255;
                    }
                    bArr[i4] = (byte) i16;
                    i4 = i18 + 1;
                    if (i15 < 0) {
                        i12 = 0;
                    } else if (i15 <= 255) {
                        i12 = i15;
                    }
                    bArr[i18] = (byte) i12;
                }
                i6++;
                i8++;
                i5 = i17;
            }
        }
    }

    public static byte[] e(Bitmap bitmap) {
        return g(bitmap.getWidth(), bitmap.getHeight(), bitmap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v2, resolved type: java.util.ArrayList<d.a.n0.r3.j.d.c$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<a> f(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            SparseArray sparseArray = new SparseArray();
            int i2 = 0;
            loop0: for (int i3 = 0; i3 < width; i3++) {
                for (int i4 = 0; i4 < height; i4++) {
                    int pixel = bitmap.getPixel(i3, i4);
                    a aVar = new a(i3, i4);
                    if (sparseArray.get(pixel) == null) {
                        sparseArray.put(pixel, aVar);
                        i2++;
                    }
                    if (i2 == 3) {
                        break loop0;
                    }
                }
            }
            ArrayList<a> arrayList = new ArrayList<>();
            for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                arrayList.add(sparseArray.valueAt(i5));
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    public static byte[] g(int i2, int i3, Bitmap bitmap) {
        int i4 = i2 * i3;
        try {
            int[] iArr = new int[i4];
            bitmap.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            byte[] bArr = new byte[(i4 * 3) / 2];
            d(bArr, iArr, i2, i3);
            return bArr;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap h(Bitmap bitmap, float f2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
