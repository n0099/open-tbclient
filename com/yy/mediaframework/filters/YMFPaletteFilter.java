package com.yy.mediaframework.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.yy.mediaframework.model.YYMediaSample;
/* loaded from: classes6.dex */
public class YMFPaletteFilter extends AbstractYYMediaFilter {
    VideoLiveFilterContext mFilterContext;
    private boolean mColorPaletteInited = false;
    private Bitmap mColorPaletteBitmap = null;
    private Canvas mColorPaletteCanvas = null;
    private RectF mRect = null;
    private Paint mPaint = null;
    private Typeface mTypeface = null;
    private int[] mColors = {ViewCompat.MEASURED_STATE_MASK, -7829368, -1, SupportMenu.CATEGORY_MASK, -16711936, -16776961, InputDeviceCompat.SOURCE_ANY, -16711681, -65281};

    public YMFPaletteFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    private void initColorPaletteTools(int i, int i2) {
        if (this.mColorPaletteBitmap == null) {
            this.mColorPaletteBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        if (this.mColorPaletteCanvas == null) {
            this.mColorPaletteCanvas = new Canvas(this.mColorPaletteBitmap);
        }
        if (this.mTypeface == null) {
            this.mTypeface = Typeface.create("sans", 1);
        }
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTypeface(this.mTypeface);
            this.mPaint.setTextSize(20.0f);
        }
        if (this.mRect == null) {
            this.mRect = new RectF();
        }
    }

    private void drawColorPaletteToSample(YYMediaSample yYMediaSample) {
        if (yYMediaSample.mTextureTarget == 3553) {
            if (!this.mColorPaletteInited) {
                initColorPaletteTools(yYMediaSample.mWidth, yYMediaSample.mHeight);
            }
            int length = this.mColors.length;
            int i = yYMediaSample.mWidth;
            int i2 = yYMediaSample.mHeight / length;
            int i3 = 0 + (yYMediaSample.mWidth / 2);
            int i4 = (yYMediaSample.mHeight / length) / 2;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                this.mPaint.setColor(this.mColors[i6]);
                this.mRect.set(0, i5, i, i2);
                this.mColorPaletteCanvas.drawRect(this.mRect, this.mPaint);
                if (i6 + 1 < length) {
                    this.mPaint.setColor(this.mColors[i6 + 1]);
                }
                if (i6 + 1 == length) {
                    this.mPaint.setColor(this.mColors[0]);
                }
                this.mColorPaletteCanvas.drawText("0x" + Integer.toHexString(this.mColors[i6]).toUpperCase(), i3, i5 + i4, this.mPaint);
                i5 += yYMediaSample.mHeight / length;
                i2 += yYMediaSample.mHeight / length;
            }
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, yYMediaSample.mMasterTextureId);
            GLUtils.texImage2D(3553, 0, this.mColorPaletteBitmap, 0);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        if (this.mFilterContext.getColorChartLiveEnable()) {
            drawColorPaletteToSample(yYMediaSample);
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        super.deInit();
        if (this.mColorPaletteInited) {
            if (this.mColorPaletteBitmap != null) {
                this.mColorPaletteBitmap.recycle();
            }
            this.mColorPaletteBitmap = null;
            this.mColorPaletteCanvas = null;
            this.mRect = null;
            this.mPaint = null;
            this.mColorPaletteInited = false;
        }
    }
}
