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
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f33666b;

    /* renamed from: c  reason: collision with root package name */
    public int f33667c;

    /* renamed from: d  reason: collision with root package name */
    public int f33668d;

    /* renamed from: e  reason: collision with root package name */
    public int f33669e;

    /* renamed from: f  reason: collision with root package name */
    public int f33670f;

    /* renamed from: g  reason: collision with root package name */
    public int f33671g;

    public a(Context context, int i, int i2, int i3, int i4, int i5) {
        this.f33666b = com.kwad.sdk.glide.c.a(context).a();
        this.f33667c = i;
        this.f33668d = i2;
        this.f33670f = i4;
        this.f33669e = i3;
        this.f33671g = i5;
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3, Paint paint2) {
        int i = this.f33668d;
        float f4 = f2 - i;
        float f5 = f3 - i;
        float f6 = this.f33669e / 2;
        Path path = new Path();
        float[] fArr = new float[8];
        int i2 = this.f33671g;
        for (int i3 = 3; i3 >= 0; i3--) {
            int i4 = i3 * 2;
            int i5 = i2 & 1;
            float f7 = 0.0f;
            fArr[i4 + 1] = i5 > 0 ? this.f33667c : 0.0f;
            if (i5 > 0) {
                f7 = this.f33667c;
            }
            fArr[i4] = f7;
            i2 >>= 1;
        }
        int i6 = this.f33668d;
        path.addRoundRect(new RectF(i6 + f6, i6 + f6, f4 - f6, f5 - f6), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<Bitmap> a(@NonNull Context context, @NonNull s<Bitmap> sVar, int i, int i2) {
        Bitmap e2 = sVar.e();
        int width = e2.getWidth();
        int height = e2.getHeight();
        Bitmap a2 = this.f33666b.a(width, height, Bitmap.Config.ARGB_8888);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(a2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(e2, tileMode, tileMode));
        Paint paint2 = new Paint(1);
        paint2.setColor(this.f33670f);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.f33669e);
        a(canvas, paint, width, height, paint2);
        return com.kwad.sdk.glide.load.resource.bitmap.d.a(a2, this.f33666b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
    }
}
