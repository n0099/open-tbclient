package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.lang.reflect.Array;
import tv.cjump.jni.NativeBitmapFactory;
/* loaded from: classes5.dex */
public class f {
    public Bitmap bitmap;
    public Object extra;
    public int height;
    public Canvas lFv;
    public Bitmap[][] nIc;
    private int nId;
    public int width;

    public void f(int i, int i2, int i3, boolean z) {
        boolean z2 = true;
        if (z) {
            if (i != this.width || i2 != this.height) {
                z2 = false;
            }
        } else if (i > this.width || i2 > this.height) {
            z2 = false;
        }
        if (z2 && this.bitmap != null) {
            this.bitmap.eraseColor(0);
            this.lFv.setBitmap(this.bitmap);
            dMC();
            return;
        }
        if (this.bitmap != null) {
            recycle();
        }
        this.width = i;
        this.height = i2;
        this.bitmap = NativeBitmapFactory.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        if (i3 > 0) {
            this.nId = i3;
            this.bitmap.setDensity(i3);
        }
        if (this.lFv == null) {
            this.lFv = new Canvas(this.bitmap);
            this.lFv.setDensity(i3);
            return;
        }
        this.lFv.setBitmap(this.bitmap);
    }

    public synchronized void recycle() {
        Bitmap bitmap = this.bitmap;
        this.bitmap = null;
        this.height = 0;
        this.width = 0;
        if (bitmap != null) {
            bitmap.recycle();
        }
        dMC();
        this.extra = null;
    }

    @SuppressLint({"NewApi"})
    public void O(int i, int i2, int i3, int i4) {
        dMC();
        if (this.width > 0 && this.height > 0 && this.bitmap != null) {
            if (this.width > i3 || this.height > i4) {
                int min = Math.min(i3, i);
                int min2 = Math.min(i4, i2);
                int i5 = (this.width / min) + (this.width % min == 0 ? 0 : 1);
                int i6 = (this.height / min2) + (this.height % min2 == 0 ? 0 : 1);
                int i7 = this.width / i5;
                int i8 = this.height / i6;
                Bitmap[][] bitmapArr = (Bitmap[][]) Array.newInstance(Bitmap.class, i6, i5);
                if (this.lFv == null) {
                    this.lFv = new Canvas();
                    if (this.nId > 0) {
                        this.lFv.setDensity(this.nId);
                    }
                }
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                for (int i9 = 0; i9 < i6; i9++) {
                    for (int i10 = 0; i10 < i5; i10++) {
                        Bitmap[] bitmapArr2 = bitmapArr[i9];
                        Bitmap createBitmap = NativeBitmapFactory.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
                        bitmapArr2[i10] = createBitmap;
                        if (this.nId > 0) {
                            createBitmap.setDensity(this.nId);
                        }
                        this.lFv.setBitmap(createBitmap);
                        int i11 = i10 * i7;
                        int i12 = i9 * i8;
                        rect.set(i11, i12, i11 + i7, i12 + i8);
                        rect2.set(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                        this.lFv.drawBitmap(this.bitmap, rect, rect2, (Paint) null);
                    }
                }
                this.lFv.setBitmap(this.bitmap);
                this.nIc = bitmapArr;
            }
        }
    }

    private void dMC() {
        Bitmap[][] bitmapArr = this.nIc;
        this.nIc = null;
        if (bitmapArr != null) {
            for (int i = 0; i < bitmapArr.length; i++) {
                for (int i2 = 0; i2 < bitmapArr[i].length; i2++) {
                    if (bitmapArr[i][i2] != null) {
                        bitmapArr[i][i2].recycle();
                        bitmapArr[i][i2] = null;
                    }
                }
            }
        }
    }

    public final synchronized boolean a(Canvas canvas, float f, float f2, Paint paint) {
        boolean z = true;
        synchronized (this) {
            if (this.nIc != null) {
                for (int i = 0; i < this.nIc.length; i++) {
                    for (int i2 = 0; i2 < this.nIc[i].length; i2++) {
                        Bitmap bitmap = this.nIc[i][i2];
                        if (bitmap != null) {
                            float width = (bitmap.getWidth() * i2) + f;
                            if (width <= canvas.getWidth() && bitmap.getWidth() + width >= 0.0f) {
                                float height = (bitmap.getHeight() * i) + f2;
                                if (height <= canvas.getHeight() && bitmap.getHeight() + height >= 0.0f) {
                                    canvas.drawBitmap(bitmap, width, height, paint);
                                }
                            }
                        }
                    }
                }
            } else if (this.bitmap != null) {
                canvas.drawBitmap(this.bitmap, f, f2, paint);
            } else {
                z = false;
            }
        }
        return z;
    }
}
