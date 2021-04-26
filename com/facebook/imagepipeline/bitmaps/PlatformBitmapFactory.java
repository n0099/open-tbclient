package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class PlatformBitmapFactory {

    /* renamed from: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void checkFinalImageBounds(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        Preconditions.checkArgument(i2 + i4 <= bitmap.getWidth(), "x + width must be <= bitmap.width()");
        Preconditions.checkArgument(i3 + i5 <= bitmap.getHeight(), "y + height must be <= bitmap.height()");
    }

    public static void checkWidthHeight(int i2, int i3) {
        Preconditions.checkArgument(i2 > 0, "width must be > 0");
        Preconditions.checkArgument(i3 > 0, "height must be > 0");
    }

    public static void checkXYSign(int i2, int i3) {
        Preconditions.checkArgument(i2 >= 0, "x must be >= 0");
        Preconditions.checkArgument(i3 >= 0, "y must be >= 0");
    }

    public static Bitmap.Config getSuitableBitmapConfig(Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap.Config config2 = bitmap.getConfig();
        if (config2 != null) {
            int i2 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return Bitmap.Config.ARGB_8888;
                }
                return Bitmap.Config.ALPHA_8;
            }
            return Bitmap.Config.RGB_565;
        }
        return config;
    }

    public static void setPropertyFromSourceBitmap(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap2.setPremultiplied(bitmap.isPremultiplied());
        }
    }

    public CloseableReference<Bitmap> createBitmap(int i2, int i3, Bitmap.Config config) {
        return createBitmap(i2, i3, config, (Object) null);
    }

    public abstract CloseableReference<Bitmap> createBitmapInternal(int i2, int i3, Bitmap.Config config);

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i2, int i3, boolean z) {
        return createScaledBitmap(bitmap, i2, i3, z, null);
    }

    public CloseableReference<Bitmap> createBitmap(int i2, int i3) {
        return createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i2, int i3, boolean z, @Nullable Object obj) {
        checkWidthHeight(i2, i3);
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.setScale(i2 / width, i3 / height);
        return createBitmap(bitmap, 0, 0, width, height, matrix, z, obj);
    }

    public CloseableReference<Bitmap> createBitmap(int i2, int i3, Bitmap.Config config, @Nullable Object obj) {
        return createBitmapInternal(i2, i3, config);
    }

    public CloseableReference<Bitmap> createBitmap(int i2, int i3, @Nullable Object obj) {
        return createBitmap(i2, i3, Bitmap.Config.ARGB_8888, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap) {
        return createBitmap(bitmap, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, @Nullable Object obj) {
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        return createBitmap(bitmap, i2, i3, i4, i5, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5, @Nullable Object obj) {
        return createBitmap(bitmap, i2, i3, i4, i5, (Matrix) null, false, obj);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5, @Nullable Matrix matrix, boolean z) {
        return createBitmap(bitmap, i2, i3, i4, i5, matrix, z, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i2, int i3, int i4, int i5, @Nullable Matrix matrix, boolean z, @Nullable Object obj) {
        CloseableReference<Bitmap> createBitmap;
        Canvas canvas;
        Paint paint;
        Preconditions.checkNotNull(bitmap, "Source bitmap cannot be null");
        checkXYSign(i2, i3);
        checkWidthHeight(i4, i5);
        checkFinalImageBounds(bitmap, i2, i3, i4, i5);
        Rect rect = new Rect(i2, i3, i2 + i4, i3 + i5);
        RectF rectF = new RectF(0.0f, 0.0f, i4, i5);
        Bitmap.Config suitableBitmapConfig = getSuitableBitmapConfig(bitmap);
        if (matrix != null && !matrix.isIdentity()) {
            boolean z2 = !matrix.rectStaysRect();
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            int round = Math.round(rectF2.width());
            int round2 = Math.round(rectF2.height());
            if (z2) {
                suitableBitmapConfig = Bitmap.Config.ARGB_8888;
            }
            createBitmap = createBitmap(round, round2, suitableBitmapConfig, z2 || bitmap.hasAlpha(), obj);
            setPropertyFromSourceBitmap(bitmap, createBitmap.get());
            canvas = new Canvas(createBitmap.get());
            canvas.translate(-rectF2.left, -rectF2.top);
            canvas.concat(matrix);
            paint = new Paint();
            paint.setFilterBitmap(z);
            if (z2) {
                paint.setAntiAlias(true);
            }
        } else {
            createBitmap = createBitmap(i4, i5, suitableBitmapConfig, bitmap.hasAlpha(), obj);
            setPropertyFromSourceBitmap(bitmap, createBitmap.get());
            canvas = new Canvas(createBitmap.get());
            paint = null;
        }
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i2, int i3, Bitmap.Config config) {
        return createBitmap(displayMetrics, i2, i3, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i2, int i3, Bitmap.Config config, @Nullable Object obj) {
        return createBitmap(displayMetrics, i2, i3, config, true, obj);
    }

    private CloseableReference<Bitmap> createBitmap(int i2, int i3, Bitmap.Config config, boolean z) {
        return createBitmap(i2, i3, config, z, (Object) null);
    }

    private CloseableReference<Bitmap> createBitmap(int i2, int i3, Bitmap.Config config, boolean z, @Nullable Object obj) {
        return createBitmap((DisplayMetrics) null, i2, i3, config, z, obj);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i2, int i3, Bitmap.Config config, boolean z) {
        return createBitmap(displayMetrics, i2, i3, config, z, (Object) null);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i2, int i3, Bitmap.Config config, boolean z, @Nullable Object obj) {
        checkWidthHeight(i2, i3);
        CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i2, i3, config);
        Bitmap bitmap = createBitmapInternal.get();
        if (displayMetrics != null) {
            bitmap.setDensity(displayMetrics.densityDpi);
        }
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(z);
        }
        if (config == Bitmap.Config.ARGB_8888 && !z) {
            bitmap.eraseColor(-16777216);
        }
        return createBitmapInternal;
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i2, int i3, Bitmap.Config config) {
        return createBitmap(iArr, i2, i3, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i2, int i3, Bitmap.Config config, @Nullable Object obj) {
        CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i2, i3, config);
        createBitmapInternal.get().setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return createBitmapInternal;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i2, int i3, Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i2, i3, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i2, int i3, Bitmap.Config config, @Nullable Object obj) {
        return createBitmap(displayMetrics, iArr, 0, i2, i2, i3, config, obj);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i2, int i3, int i4, int i5, Bitmap.Config config) {
        return createBitmap(displayMetrics, iArr, i2, i3, i4, i5, config, (Object) null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i2, int i3, int i4, int i5, Bitmap.Config config, @Nullable Object obj) {
        CloseableReference<Bitmap> createBitmap = createBitmap(displayMetrics, i4, i5, config, obj);
        createBitmap.get().setPixels(iArr, i2, i3, 0, 0, i4, i5);
        return createBitmap;
    }
}
