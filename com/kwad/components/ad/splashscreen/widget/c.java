package com.kwad.components.ad.splashscreen.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class c extends AnimationDrawable {
    public RectF GA;
    public Paint GB;
    public int GC;
    public int GD;
    public ValueAnimator GE;
    public final float GF = 6.0f;
    public final float GG = 11.0f;
    public float GH;
    public float GI;
    public int GJ;
    public Bitmap Gl;
    public Bitmap Gm;
    public Bitmap Gn;
    public Bitmap Go;
    public Bitmap Gp;
    public Bitmap Gq;
    public int Gr;
    public RectF Gs;
    public Paint Gt;
    public Paint Gu;
    public PorterDuffXfermode Gv;
    public final int Gw;
    public final int Gx;
    public float Gy;
    public float Gz;
    public Context mContext;

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    public c(Context context, int i) {
        this.mContext = context;
        this.Gw = com.kwad.sdk.d.a.a.a(context, 51.0f);
        this.Gx = com.kwad.sdk.d.a.a.a(context, 61.0f);
        this.GJ = i;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f) {
        if (f <= 6.0f) {
            float f2 = f / 6.0f;
            int i = this.GJ;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        RectF rectF = this.GA;
                        float f3 = this.GC * f2;
                        rectF.right = f3;
                        this.Gs.offsetTo(f3 + this.Gz, rectF.top + this.Gy);
                        this.GI = (f2 * 30.0f) + 330.0f;
                        return;
                    }
                    return;
                }
                RectF rectF2 = this.GA;
                float f4 = 1.0f - f2;
                float f5 = this.GC * f4;
                rectF2.left = f5;
                this.Gs.offsetTo(f5 + this.Gz, rectF2.top + this.Gy);
                this.GI = f4 * 30.0f;
                return;
            }
            RectF rectF3 = this.GA;
            float f6 = this.GD * (1.0f - f2);
            rectF3.top = f6;
            this.Gs.offsetTo(rectF3.left + this.Gz, f6 + this.Gy);
            this.GI = (f2 * 30.0f) + 290.0f;
        }
    }

    private void init() {
        this.Gl = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ef4);
        this.Gm = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ef6);
        this.Gn = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ef5);
        this.Go = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ef8);
        this.Gp = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ef7);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080efd);
        int i = this.GJ;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    this.Gq = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
                }
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.postRotate(270.0f);
                this.Gq = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix2, true);
            }
        } else {
            this.Gq = decodeResource;
        }
        this.Gr = com.kwad.sdk.d.a.a.a(this.mContext, 10.0f);
        this.GB = new Paint(1);
        int i2 = this.GJ;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.GD = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070567);
                    this.GC = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070566);
                    this.Gy = this.GD * 0.09f;
                    this.Gz = (-this.Gw) * 0.5f;
                }
            } else {
                this.GD = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070567);
                this.GC = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070566);
                this.Gy = this.GD * 0.09f;
                this.Gz = (-this.Gw) * 0.2f;
            }
        } else {
            this.GD = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070566);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070567);
            this.GC = dimension;
            this.Gy = (-this.Gx) * 0.22f;
            this.Gz = dimension * 0.08f;
        }
        this.GA = new RectF(0.0f, 0.0f, this.GC, this.GD);
        this.Gt = new Paint(3);
        Paint paint = new Paint(3);
        this.Gu = paint;
        paint.setDither(true);
        float f = this.GA.right;
        this.Gs = new RectF(f - this.Gw, 0.0f, f, this.Gx);
        this.Gv = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.GE = ofFloat;
        ofFloat.setDuration(1100L);
        this.GE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.GH = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c cVar = c.this;
                cVar.c(cVar.GH);
                c.this.invalidateSelf();
            }
        });
        this.GE.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        if (this.GA == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.GC) / 2, (getIntrinsicHeight() - this.GD) / 2);
        float f = this.GH;
        if (f <= 6.0f) {
            this.GB.setAlpha((int) ((f * 255.0f) / 6.0f));
            this.Gu.setAlpha(255);
        } else {
            int i = (int) ((1.0f - ((f - 6.0f) / 5.0f)) * 255.0f);
            this.GB.setAlpha(i);
            this.Gu.setAlpha(i);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.GA, this.GB, 31);
        try {
            canvas.drawBitmap(this.Gq, (Rect) null, this.GA, this.GB);
        } catch (Throwable unused) {
        }
        canvas.rotate(this.GI, this.Gs.centerX(), this.Gs.centerY());
        this.Gt.setXfermode(this.Gv);
        int i2 = this.GJ;
        if (i2 != 0) {
            if (i2 == 1) {
                canvas.drawBitmap(this.Gm, (Rect) null, this.Gs, this.Gt);
                canvas.drawBitmap(this.Gn, (Rect) null, this.Gs, this.Gt);
            }
        } else {
            canvas.drawBitmap(this.Go, (Rect) null, this.Gs, this.Gt);
            canvas.drawBitmap(this.Gp, (Rect) null, this.Gs, this.Gt);
        }
        canvas.drawBitmap(this.Gl, (Rect) null, this.Gs, this.Gt);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.GI, this.Gs.centerX(), this.Gs.centerY());
        canvas.drawBitmap(this.Gl, (Rect) null, this.Gs, this.Gu);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.GD + this.Gx + this.Gr;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.GC + this.Gw;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.GE;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.GE;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.GE;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
