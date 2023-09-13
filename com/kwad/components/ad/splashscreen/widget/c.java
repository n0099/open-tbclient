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
    public Bitmap AE;
    public Bitmap AF;
    public Bitmap AG;
    public Bitmap AH;
    public Bitmap AI;
    public Bitmap AJ;
    public int AK;
    public RectF AL;
    public Paint AM;
    public Paint AN;
    public PorterDuffXfermode AO;
    public final int AP;
    public final int AQ;
    public float AR;
    public float AS;
    public RectF AT;
    public Paint AU;
    public int AV;
    public int AW;
    public ValueAnimator AX;
    public final float AY = 6.0f;
    public final float AZ = 11.0f;
    public float Ba;
    public float Bb;
    public int Bc;
    public Context mContext;

    public c(Context context, int i) {
        this.mContext = context;
        this.AP = com.kwad.sdk.b.kwai.a.a(context, 51.0f);
        this.AQ = com.kwad.sdk.b.kwai.a.a(context, 61.0f);
        this.Bc = i;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f) {
        if (f <= 6.0f) {
            float f2 = f / 6.0f;
            int i = this.Bc;
            if (i == 0) {
                RectF rectF = this.AT;
                float f3 = this.AW * (1.0f - f2);
                rectF.top = f3;
                this.AL.offsetTo(rectF.left + this.AS, f3 + this.AR);
                this.Bb = (f2 * 30.0f) + 290.0f;
            } else if (i == 1) {
                RectF rectF2 = this.AT;
                float f4 = 1.0f - f2;
                float f5 = this.AV * f4;
                rectF2.left = f5;
                this.AL.offsetTo(f5 + this.AS, rectF2.top + this.AR);
                this.Bb = f4 * 30.0f;
            } else if (i != 2) {
            } else {
                RectF rectF3 = this.AT;
                float f6 = this.AV * f2;
                rectF3.right = f6;
                this.AL.offsetTo(f6 + this.AS, rectF3.top + this.AR);
                this.Bb = (f2 * 30.0f) + 330.0f;
            }
        }
    }

    private void init() {
        float f;
        float f2;
        Matrix matrix;
        float f3;
        this.AE = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ec9);
        this.AF = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ecb);
        this.AG = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080eca);
        this.AH = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ecd);
        this.AI = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ecc);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.obfuscated_res_0x7f080ed2);
        int i = this.Bc;
        if (i != 0) {
            if (i == 1) {
                matrix = new Matrix();
                f3 = 270.0f;
            } else if (i == 2) {
                matrix = new Matrix();
                f3 = 90.0f;
            }
            matrix.postRotate(f3);
            this.AJ = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
        } else {
            this.AJ = decodeResource;
        }
        this.AK = com.kwad.sdk.b.kwai.a.a(this.mContext, 10.0f);
        this.AU = new Paint(1);
        int i2 = this.Bc;
        if (i2 == 0) {
            this.AW = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070557);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070558);
            this.AV = dimension;
            this.AR = (-this.AQ) * 0.22f;
            f = dimension;
            f2 = 0.08f;
        } else if (i2 != 1) {
            if (i2 == 2) {
                this.AW = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070558);
                this.AV = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070557);
                this.AR = this.AW * 0.09f;
                f = -this.AP;
                f2 = 0.5f;
            }
            this.AT = new RectF(0.0f, 0.0f, this.AV, this.AW);
            this.AM = new Paint(3);
            Paint paint = new Paint(3);
            this.AN = paint;
            paint.setDither(true);
            float f4 = this.AT.right;
            this.AL = new RectF(f4 - this.AP, 0.0f, f4, this.AQ);
            this.AO = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
            this.AX = ofFloat;
            ofFloat.setDuration(1100L);
            this.AX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.Ba = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c cVar = c.this;
                    cVar.c(cVar.Ba);
                    c.this.invalidateSelf();
                }
            });
            this.AX.setRepeatCount(-1);
        } else {
            this.AW = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070558);
            this.AV = (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070557);
            this.AR = this.AW * 0.09f;
            f = -this.AP;
            f2 = 0.2f;
        }
        this.AS = f * f2;
        this.AT = new RectF(0.0f, 0.0f, this.AV, this.AW);
        this.AM = new Paint(3);
        Paint paint2 = new Paint(3);
        this.AN = paint2;
        paint2.setDither(true);
        float f42 = this.AT.right;
        this.AL = new RectF(f42 - this.AP, 0.0f, f42, this.AQ);
        this.AO = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.AX = ofFloat2;
        ofFloat2.setDuration(1100L);
        this.AX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.Ba = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c cVar = c.this;
                cVar.c(cVar.Ba);
                c.this.invalidateSelf();
            }
        });
        this.AX.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        if (this.AT == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.AV) / 2, (getIntrinsicHeight() - this.AW) / 2);
        float f = this.Ba;
        if (f <= 6.0f) {
            this.AU.setAlpha((int) ((f * 255.0f) / 6.0f));
            this.AN.setAlpha(255);
        } else {
            int i = (int) ((1.0f - ((f - 6.0f) / 5.0f)) * 255.0f);
            this.AU.setAlpha(i);
            this.AN.setAlpha(i);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.AT, this.AU, 31);
        canvas.drawBitmap(this.AJ, (Rect) null, this.AT, this.AU);
        canvas.rotate(this.Bb, this.AL.centerX(), this.AL.centerY());
        this.AM.setXfermode(this.AO);
        int i2 = this.Bc;
        if (i2 != 0) {
            if (i2 == 1) {
                canvas.drawBitmap(this.AF, (Rect) null, this.AL, this.AM);
                bitmap = this.AG;
            }
            canvas.drawBitmap(this.AE, (Rect) null, this.AL, this.AM);
            canvas.restoreToCount(saveLayer);
            canvas.rotate(this.Bb, this.AL.centerX(), this.AL.centerY());
            canvas.drawBitmap(this.AE, (Rect) null, this.AL, this.AN);
            canvas.restoreToCount(save);
            canvas.restore();
        }
        canvas.drawBitmap(this.AH, (Rect) null, this.AL, this.AM);
        bitmap = this.AI;
        canvas.drawBitmap(bitmap, (Rect) null, this.AL, this.AM);
        canvas.drawBitmap(this.AE, (Rect) null, this.AL, this.AM);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.Bb, this.AL.centerX(), this.AL.centerY());
        canvas.drawBitmap(this.AE, (Rect) null, this.AL, this.AN);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.AW + this.AQ + this.AK;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.AV + this.AP;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.AX;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.AX;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.AX;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
