package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class h {
    public Path ZA;
    public float[] arl;
    public boolean arm;
    @NonNull
    public a arn;
    public Paint mPaint;
    public float wm;
    public RectF zV;

    /* loaded from: classes7.dex */
    public static class a {
        public boolean aro = true;
        public boolean arp = true;
        public boolean arq = true;
        public boolean arr = true;

        public final boolean BA() {
            return this.aro;
        }

        public final boolean BB() {
            return this.arp;
        }

        public final boolean BC() {
            return this.arq;
        }

        public final boolean BD() {
            return this.arr;
        }

        public final a bt(boolean z) {
            this.aro = z;
            return this;
        }

        public final a bu(boolean z) {
            this.arp = z;
            return this;
        }

        public final a bv(boolean z) {
            this.arq = z;
            return this;
        }

        public final a bw(boolean z) {
            this.arr = z;
            return this;
        }

        public final void bx(boolean z) {
            this.aro = true;
            this.arp = true;
            this.arq = true;
            this.arr = true;
        }
    }

    public h() {
        this.arl = new float[8];
        this.arn = new a();
    }

    public h(a aVar) {
        this.arl = new float[8];
        this.arn = aVar;
    }

    private float[] Bz() {
        this.arl[0] = this.arn.BA() ? this.wm : 0.0f;
        this.arl[1] = this.arn.BA() ? this.wm : 0.0f;
        this.arl[2] = this.arn.BB() ? this.wm : 0.0f;
        this.arl[3] = this.arn.BB() ? this.wm : 0.0f;
        this.arl[4] = this.arn.BC() ? this.wm : 0.0f;
        this.arl[5] = this.arn.BC() ? this.wm : 0.0f;
        this.arl[6] = this.arn.BD() ? this.wm : 0.0f;
        this.arl[7] = this.arn.BD() ? this.wm : 0.0f;
        return this.arl;
    }

    private Path getPath() {
        try {
            this.ZA.reset();
        } catch (Exception unused) {
        }
        this.ZA.addRoundRect(this.zV, this.wm == 0.0f ? this.arl : Bz(), Path.Direction.CW);
        return this.ZA;
    }

    public final void d(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f0403b4, R.attr.obfuscated_res_0x7f040396};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.wm = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f0403b4), 0);
            this.arm = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f040396), true);
            obtainStyledAttributes.recycle();
        }
        this.ZA = new Path();
        this.mPaint = new Paint(1);
        this.zV = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void d(Canvas canvas) {
        if (this.arm) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.zV, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(getPath());
        }
    }

    public final void e(Canvas canvas) {
        if (this.arm) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public final void f(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.zV, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(getPath());
    }

    public final void g(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    @NonNull
    public final a getCornerConf() {
        return this.arn;
    }

    public final void setRadius(float f) {
        this.wm = f;
    }

    public final void setRadius(float[] fArr) {
        this.arl = fArr;
    }

    public final void w(int i, int i2) {
        this.zV.set(0.0f, 0.0f, i, i2);
    }
}
