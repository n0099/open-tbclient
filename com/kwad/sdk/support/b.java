package com.kwad.sdk.support;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Paint f36665a = new Paint(6);

    /* renamed from: b  reason: collision with root package name */
    public static final Paint f36666b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    public static final Paint f36667c;

    /* renamed from: d  reason: collision with root package name */
    public static final Paint f36668d;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f36669e;

    /* renamed from: f  reason: collision with root package name */
    public static final Lock f36670f;

    /* loaded from: classes6.dex */
    public static final class a implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        Paint paint = new Paint(7);
        f36668d = paint;
        paint.setColor(Color.parseColor("#EAEAEA"));
        f36668d.setStyle(Paint.Style.STROKE);
        f36668d.setAntiAlias(true);
        f36668d.setStrokeWidth(1.0f);
        f36668d.setDither(true);
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f36669e = hashSet;
        f36670f = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint2 = new Paint(7);
        f36667c = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @NonNull
    public static Bitmap.Config a(@NonNull Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    public static Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap) {
        Bitmap.Config a2 = a(bitmap);
        if (a2.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap a3 = eVar.a(bitmap.getWidth(), bitmap.getHeight(), a2);
        new Canvas(a3).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return a3;
    }

    public static Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f2 = min;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f2 / width, f2 / height);
        float f4 = width * max;
        float f5 = max * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap a2 = a(eVar, bitmap);
        Bitmap a3 = eVar.a(min, min, a(bitmap));
        a3.setHasAlpha(true);
        f36670f.lock();
        try {
            Canvas canvas = new Canvas(a3);
            canvas.drawCircle(f3, f3, f3, f36666b);
            canvas.drawBitmap(a2, (Rect) null, rectF, f36667c);
            canvas.drawCircle(f3, f3, f3 - 0.0f, f36668d);
            a(canvas);
            f36670f.unlock();
            if (!a2.equals(bitmap)) {
                eVar.a(a2);
            }
            return a3;
        } catch (Throwable th) {
            f36670f.unlock();
            throw th;
        }
    }

    public static void a(Canvas canvas) {
        canvas.setBitmap(null);
    }
}
