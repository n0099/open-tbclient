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
/* loaded from: classes3.dex */
public class a implements h<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.e f9020b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public a(Context context, int i, int i2, int i3, int i4, int i5) {
        this.f9020b = com.kwad.sdk.glide.c.a(context).a();
        this.c = i;
        this.d = i2;
        this.f = i4;
        this.e = i3;
        this.g = i5;
    }

    private void a(Canvas canvas, Paint paint, float f, float f2, Paint paint2) {
        float f3 = f - this.d;
        float f4 = f2 - this.d;
        float f5 = this.e / 2;
        Path path = new Path();
        float[] fArr = new float[8];
        int i = this.g;
        for (int i2 = 3; i2 >= 0; i2--) {
            fArr[(i2 * 2) + 1] = (i & 1) > 0 ? this.c : 0.0f;
            fArr[i2 * 2] = (i & 1) > 0 ? this.c : 0.0f;
            i >>= 1;
        }
        path.addRoundRect(new RectF(this.d + f5, this.d + f5, f3 - f5, f4 - f5), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<Bitmap> a(@NonNull Context context, @NonNull s<Bitmap> sVar, int i, int i2) {
        Bitmap e = sVar.e();
        int width = e.getWidth();
        int height = e.getHeight();
        Bitmap a2 = this.f9020b.a(width, height, Bitmap.Config.ARGB_8888);
        Bitmap createBitmap = a2 == null ? Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888) : a2;
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        Paint paint2 = new Paint(1);
        paint2.setColor(this.f);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(this.e);
        a(canvas, paint, width, height, paint2);
        return com.kwad.sdk.glide.load.resource.bitmap.d.a(createBitmap, this.f9020b);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
    }
}
