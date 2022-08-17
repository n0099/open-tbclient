package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5f;
    public static final float IMAGE_SIZE_THRESHOLD_OK = 0.1f;
    public static final int MAX_LINE_WIDTH_EM = 8;
    public static final int MAX_NUMBER_OF_LINES = 9;
    public static final int MAX_TEXT_SIZE_PX = 40;
    public static final int MIN_TEXT_SIZE_PX = 10;
    public static final String NO_CONTROLLER_ID = "none";
    public static final int OUTLINE_COLOR = -26624;
    public static final int OUTLINE_STROKE_WIDTH_PX = 2;
    public static final int TEXT_BACKGROUND_COLOR = 1711276032;
    public static final int TEXT_COLOR = -1;
    @VisibleForTesting
    public static final int TEXT_COLOR_IMAGE_ALMOST_OK = -256;
    @VisibleForTesting
    public static final int TEXT_COLOR_IMAGE_NOT_OK = -65536;
    @VisibleForTesting
    public static final int TEXT_COLOR_IMAGE_OK = -16711936;
    public static final int TEXT_LINE_SPACING_PX = 8;
    public static final int TEXT_PADDING_PX = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> mAdditionalData;
    public String mControllerId;
    public int mCurrentTextXPx;
    public int mCurrentTextYPx;
    public long mFinalImageTimeMs;
    public int mFrameCount;
    public int mHeightPx;
    public String mImageFormat;
    public String mImageId;
    public int mImageSizeBytes;
    public int mLineIncrementPx;
    public int mLoopCount;
    public final Matrix mMatrix;
    public int mOriginColor;
    public String mOriginText;
    public int mOverlayColor;
    public final Paint mPaint;
    public final Rect mRect;
    public final RectF mRectF;
    public ScalingUtils.ScaleType mScaleType;
    public int mStartTextXPx;
    public int mStartTextYPx;
    public int mTextGravity;
    public int mWidthPx;

    public DebugControllerOverlayDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdditionalData = new HashMap<>();
        this.mTextGravity = 80;
        this.mPaint = new Paint(1);
        this.mMatrix = new Matrix();
        this.mRect = new Rect();
        this.mRectF = new RectF();
        this.mOriginColor = -1;
        this.mOverlayColor = 0;
        reset();
    }

    private void addDebugText(Canvas canvas, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, canvas, str, obj) == null) {
            addDebugText(canvas, str, String.valueOf(obj), -1);
        }
    }

    public static String format(String str, @Nullable Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, objArr)) == null) ? objArr == null ? str : String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    private void prepareDebugTextParameters(Rect rect, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, this, rect, i, i2) == null) {
            int min = Math.min(40, Math.max(10, Math.min(rect.width() / i2, rect.height() / i)));
            this.mPaint.setTextSize(min);
            int i3 = min + 8;
            this.mLineIncrementPx = i3;
            if (this.mTextGravity == 80) {
                this.mLineIncrementPx = i3 * (-1);
            }
            this.mStartTextXPx = rect.left + 10;
            this.mStartTextYPx = this.mTextGravity == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
        }
    }

    public void addAdditionalData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.mAdditionalData.put(str, str2);
        }
    }

    @VisibleForTesting
    public int determineSizeHintColor(int i, int i2, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, scaleType)) == null) {
            int width = getBounds().width();
            int height = getBounds().height();
            if (width > 0 && height > 0 && i > 0 && i2 > 0) {
                if (scaleType != null) {
                    Rect rect = this.mRect;
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = width;
                    rect.bottom = height;
                    this.mMatrix.reset();
                    scaleType.getTransform(this.mMatrix, this.mRect, i, i2, 0.0f, 0.0f);
                    RectF rectF = this.mRectF;
                    rectF.top = 0.0f;
                    rectF.left = 0.0f;
                    rectF.right = i;
                    rectF.bottom = i2;
                    this.mMatrix.mapRect(rectF);
                    width = Math.min(width, (int) this.mRectF.width());
                    height = Math.min(height, (int) this.mRectF.height());
                }
                float f = width;
                float f2 = f * 0.1f;
                float f3 = f * 0.5f;
                float f4 = height;
                float f5 = 0.1f * f4;
                float f6 = f4 * 0.5f;
                int abs = Math.abs(i - width);
                int abs2 = Math.abs(i2 - height);
                float f7 = abs;
                if (f7 < f2 && abs2 < f5) {
                    return TEXT_COLOR_IMAGE_OK;
                }
                if (f7 < f3 && abs2 < f6) {
                    return -256;
                }
            }
            return -65536;
        }
        return invokeIIL.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Rect bounds = getBounds();
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(2.0f);
            this.mPaint.setColor(OUTLINE_COLOR);
            canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mOverlayColor);
            canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeWidth(0.0f);
            this.mPaint.setColor(-1);
            this.mCurrentTextXPx = this.mStartTextXPx;
            this.mCurrentTextYPx = this.mStartTextYPx;
            String str = this.mImageId;
            if (str != null) {
                addDebugText(canvas, "IDs", format("%s, %s", this.mControllerId, str));
            } else {
                addDebugText(canvas, UserSettingForceListListener.FORCE_LIST_ITEM_ID_KEY, this.mControllerId);
            }
            addDebugText(canvas, "D", format("%dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height())));
            addDebugText(canvas, "I", format("%dx%d", Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx)), determineSizeHintColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
            addDebugText(canvas, "I", format("%d KiB", Integer.valueOf(this.mImageSizeBytes / 1024)));
            String str2 = this.mImageFormat;
            if (str2 != null) {
                addDebugText(canvas, "i format", str2);
            }
            int i = this.mFrameCount;
            if (i > 0) {
                addDebugText(canvas, "anim", format("f %d, l %d", Integer.valueOf(i), Integer.valueOf(this.mLoopCount)));
            }
            ScalingUtils.ScaleType scaleType = this.mScaleType;
            if (scaleType != null) {
                addDebugText(canvas, "scale", scaleType);
            }
            long j = this.mFinalImageTimeMs;
            if (j >= 0) {
                addDebugText(canvas, "t", format("%d ms", Long.valueOf(j)));
            }
            String str3 = this.mOriginText;
            if (str3 != null) {
                addDebugText(canvas, "origin", str3, this.mOriginColor);
            }
            for (Map.Entry<String, String> entry : this.mAdditionalData.entrySet()) {
                addDebugText(canvas, entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rect) == null) {
            super.onBoundsChange(rect);
            prepareDebugTextParameters(rect, 9, 8);
        }
    }

    @Override // com.facebook.drawee.debug.listener.ImageLoadingTimeListener
    public void onFinalImageSet(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.mFinalImageTimeMs = j;
            invalidateSelf();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mWidthPx = -1;
            this.mHeightPx = -1;
            this.mImageSizeBytes = -1;
            this.mAdditionalData = new HashMap<>();
            this.mFrameCount = -1;
            this.mLoopCount = -1;
            this.mImageFormat = null;
            setControllerId(null);
            this.mFinalImageTimeMs = -1L;
            this.mOriginText = null;
            this.mOriginColor = -1;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    public void setAnimationInfo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.mFrameCount = i;
            this.mLoopCount = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, colorFilter) == null) {
        }
    }

    public void setControllerId(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (str == null) {
                str = "none";
            }
            this.mControllerId = str;
            invalidateSelf();
        }
    }

    public void setDimensions(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            this.mWidthPx = i;
            this.mHeightPx = i2;
            invalidateSelf();
        }
    }

    public void setFinalImageTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.mFinalImageTimeMs = j;
        }
    }

    public void setImageFormat(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mImageFormat = str;
        }
    }

    public void setImageId(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mImageId = str;
            invalidateSelf();
        }
    }

    public void setImageSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mImageSizeBytes = i;
        }
    }

    public void setOrigin(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) {
            this.mOriginText = str;
            this.mOriginColor = i;
            invalidateSelf();
        }
    }

    public void setOverlayColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mOverlayColor = i;
        }
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, scaleType) == null) {
            this.mScaleType = scaleType;
        }
    }

    public void setTextGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mTextGravity = i;
            invalidateSelf();
        }
    }

    private void addDebugText(Canvas canvas, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, canvas, str, str2) == null) {
            addDebugText(canvas, str, str2, -1);
        }
    }

    private void addDebugText(Canvas canvas, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65539, this, canvas, str, str2, i) == null) {
            String str3 = str + ": ";
            float measureText = this.mPaint.measureText(str3);
            float measureText2 = this.mPaint.measureText(str2);
            this.mPaint.setColor(TEXT_BACKGROUND_COLOR);
            int i2 = this.mCurrentTextXPx;
            int i3 = this.mCurrentTextYPx;
            canvas.drawRect(i2 - 4, i3 + 8, i2 + measureText + measureText2 + 4.0f, i3 + this.mLineIncrementPx + 8, this.mPaint);
            this.mPaint.setColor(-1);
            canvas.drawText(str3, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
            this.mPaint.setColor(i);
            canvas.drawText(str2, this.mCurrentTextXPx + measureText, this.mCurrentTextYPx, this.mPaint);
            this.mCurrentTextYPx += this.mLineIncrementPx;
        }
    }
}
