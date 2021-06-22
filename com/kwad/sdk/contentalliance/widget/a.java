package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.h;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class a implements h<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f34092b;

    /* renamed from: c  reason: collision with root package name */
    public int f34093c;

    /* renamed from: d  reason: collision with root package name */
    public int f34094d;

    /* renamed from: e  reason: collision with root package name */
    public int f34095e;

    /* renamed from: f  reason: collision with root package name */
    public int f34096f;

    /* renamed from: g  reason: collision with root package name */
    public int f34097g;

    public a(Context context, int i2, int i3, int i4, int i5, int i6) {
        this.f34092b = com.kwad.sdk.glide.c.a(context).a();
        this.f34093c = i2;
        this.f34094d = i3;
        this.f34096f = i5;
        this.f34095e = i4;
        this.f34097g = i6;
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3, Paint paint2) {
        int i2 = this.f34094d;
        float f4 = f2 - i2;
        float f5 = f3 - i2;
        float f6 = this.f34095e / 2;
        Path path = new Path();
        float[] fArr = new float[8];
        int i3 = this.f34097g;
        for (int i4 = 3; i4 >= 0; i4--) {
            int i5 = i4 * 2;
            int i6 = i3 & 1;
            float f7 = 0.0f;
            fArr[i5 + 1] = i6 > 0 ? this.f34093c : 0.0f;
            if (i6 > 0) {
                f7 = this.f34093c;
            }
            fArr[i5] = f7;
            i3 >>= 1;
        }
        int i7 = this.f34094d;
        path.addRoundRect(new RectF(i7 + f6, i7 + f6, f4 - f6, f5 - f6), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<Bitmap> a(@NonNull Context context, @NonNull s<Bitmap> sVar, int i2, int i3) {
        Bitmap e2 = sVar.e();
        int width = e2.getWidth();
        int height = e2.getHeight();
        Bitmap a2 = this.f34092b.a(width, height, Bitmap.Config.ARGB_8888);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(a2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(e2, tileMode, tileMode));
        Paint paint2 = new Paint(1);
        paint2.setColor(this.f34096f);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.f34095e);
        a(canvas, paint, width, height, paint2);
        return com.kwad.sdk.glide.load.resource.bitmap.d.a(a2, this.f34092b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
    }
}
