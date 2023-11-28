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
/* loaded from: classes10.dex */
public final class h {
    public boolean mClipBackground;
    @NonNull
    public a mCornerConf;
    public Paint mPaint;
    public Path mPath;
    public float mRadius;
    public RectF mRectF;
    public float[] radiusArray;

    /* loaded from: classes10.dex */
    public static class a {
        public boolean leftTop = true;
        public boolean topRight = true;
        public boolean rightBottom = true;
        public boolean bottomLeft = true;

        public final boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean isLeftTop() {
            return this.leftTop;
        }

        public final boolean isRightBottom() {
            return this.rightBottom;
        }

        public final boolean isTopRight() {
            return this.topRight;
        }

        public final a cc(boolean z) {
            this.leftTop = z;
            return this;
        }

        public final a cd(boolean z) {
            this.topRight = z;
            return this;
        }

        public final a ce(boolean z) {
            this.rightBottom = z;
            return this;
        }

        public final a cf(boolean z) {
            this.bottomLeft = z;
            return this;
        }

        public final void setAllCorner(boolean z) {
            this.leftTop = z;
            this.topRight = z;
            this.rightBottom = z;
            this.bottomLeft = z;
        }
    }

    public h() {
        this.radiusArray = new float[8];
        this.mCornerConf = new a();
    }

    private Path getPath() {
        float[] radius;
        try {
            this.mPath.reset();
        } catch (Exception unused) {
        }
        if (this.mRadius == 0.0f) {
            radius = this.radiusArray;
        } else {
            radius = getRadius();
        }
        this.mPath.addRoundRect(this.mRectF, radius, Path.Direction.CW);
        return this.mPath;
    }

    @NonNull
    public final a getCornerConf() {
        return this.mCornerConf;
    }

    public h(a aVar) {
        this.radiusArray = new float[8];
        this.mCornerConf = aVar;
    }

    public final void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public final void afterDraw(Canvas canvas) {
        if (!this.mClipBackground) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public final void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            canvas.save();
            canvas.clipPath(getPath());
            return;
        }
        canvas.saveLayer(this.mRectF, null, 31);
    }

    public final void beforeDraw(Canvas canvas) {
        if (!this.mClipBackground) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.mRectF, null, 31);
            return;
        }
        canvas.save();
        canvas.clipPath(getPath());
    }

    public final void setRadius(float f) {
        this.mRadius = f;
    }

    private float[] getRadius() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float[] fArr = this.radiusArray;
        float f8 = 0.0f;
        if (this.mCornerConf.isLeftTop()) {
            f = this.mRadius;
        } else {
            f = 0.0f;
        }
        fArr[0] = f;
        float[] fArr2 = this.radiusArray;
        if (this.mCornerConf.isLeftTop()) {
            f2 = this.mRadius;
        } else {
            f2 = 0.0f;
        }
        fArr2[1] = f2;
        float[] fArr3 = this.radiusArray;
        if (this.mCornerConf.isTopRight()) {
            f3 = this.mRadius;
        } else {
            f3 = 0.0f;
        }
        fArr3[2] = f3;
        float[] fArr4 = this.radiusArray;
        if (this.mCornerConf.isTopRight()) {
            f4 = this.mRadius;
        } else {
            f4 = 0.0f;
        }
        fArr4[3] = f4;
        float[] fArr5 = this.radiusArray;
        if (this.mCornerConf.isRightBottom()) {
            f5 = this.mRadius;
        } else {
            f5 = 0.0f;
        }
        fArr5[4] = f5;
        float[] fArr6 = this.radiusArray;
        if (this.mCornerConf.isRightBottom()) {
            f6 = this.mRadius;
        } else {
            f6 = 0.0f;
        }
        fArr6[5] = f6;
        float[] fArr7 = this.radiusArray;
        if (this.mCornerConf.isBottomLeft()) {
            f7 = this.mRadius;
        } else {
            f7 = 0.0f;
        }
        fArr7[6] = f7;
        float[] fArr8 = this.radiusArray;
        if (this.mCornerConf.isBottomLeft()) {
            f8 = this.mRadius;
        }
        fArr8[7] = f8;
        return this.radiusArray;
    }

    public final void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f0403df, R.attr.obfuscated_res_0x7f0403bd};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f0403df), 0);
            this.mClipBackground = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f0403bd), true);
            obtainStyledAttributes.recycle();
        }
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void onSizeChanged(int i, int i2) {
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    public final void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }
}
