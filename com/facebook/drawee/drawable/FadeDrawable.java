package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class FadeDrawable extends ArrayDrawable {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final int TRANSITION_NONE = 2;
    @VisibleForTesting
    public static final int TRANSITION_RUNNING = 1;
    @VisibleForTesting
    public static final int TRANSITION_STARTING = 0;
    public static boolean sGlobalFadingEnable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public final int ACTUAL_IMAGE_INDEX;
    @VisibleForTesting
    public int mAlpha;
    @VisibleForTesting
    public int[] mAlphas;
    public boolean mCallOnFadeFinishedListener;
    public final int mDefaultLayerAlpha;
    public final boolean mDefaultLayerIsOn;
    @VisibleForTesting
    public int mDurationMs;
    @VisibleForTesting
    public boolean[] mIsLayerOn;
    public final Drawable[] mLayers;
    @Nullable
    public OnFadeFinishedListener mOnFadeFinishedListener;
    @VisibleForTesting
    public int mPreventInvalidateCount;
    @VisibleForTesting
    public int[] mStartAlphas;
    @VisibleForTesting
    public long mStartTimeMs;
    @VisibleForTesting
    public int mTransitionState;

    /* loaded from: classes7.dex */
    public interface OnFadeFinishedListener {
        void onFadeFinished();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-779248116, "Lcom/facebook/drawee/drawable/FadeDrawable;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-779248116, "Lcom/facebook/drawee/drawable/FadeDrawable;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FadeDrawable(Drawable[] drawableArr) {
        this(drawableArr, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawableArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Drawable[]) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void drawDrawableWithAlpha(Canvas canvas, Drawable drawable, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, this, canvas, drawable, i) == null) || drawable == null || i <= 0) {
            return;
        }
        this.mPreventInvalidateCount++;
        drawable.mutate().setAlpha(i);
        this.mPreventInvalidateCount--;
        drawable.draw(canvas);
    }

    public static boolean getGlobalFadingEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sGlobalFadingEnable : invokeV.booleanValue;
    }

    private void maybeNotifyOnFadeFinished() {
        OnFadeFinishedListener onFadeFinishedListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (onFadeFinishedListener = this.mOnFadeFinishedListener) != null && this.mCallOnFadeFinishedListener) {
            onFadeFinishedListener.onFadeFinished();
            this.mCallOnFadeFinishedListener = false;
        }
    }

    private void resetInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mTransitionState = 2;
            Arrays.fill(this.mStartAlphas, this.mDefaultLayerAlpha);
            this.mStartAlphas[0] = 255;
            Arrays.fill(this.mAlphas, this.mDefaultLayerAlpha);
            this.mAlphas[0] = 255;
            Arrays.fill(this.mIsLayerOn, this.mDefaultLayerIsOn);
            this.mIsLayerOn[0] = true;
        }
    }

    public static void setGlobalFadingEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            sGlobalFadingEnable = z;
        }
    }

    private boolean updateAlphas(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65544, this, f)) == null) {
            boolean z = true;
            for (int i = 0; i < this.mLayers.length; i++) {
                int i2 = this.mIsLayerOn[i] ? 1 : -1;
                int[] iArr = this.mAlphas;
                iArr[i] = (int) (this.mStartAlphas[i] + (i2 * 255 * f));
                if (iArr[i] < 0) {
                    iArr[i] = 0;
                }
                int[] iArr2 = this.mAlphas;
                if (iArr2[i] > 255) {
                    iArr2[i] = 255;
                }
                if (this.mIsLayerOn[i] && this.mAlphas[i] < 255) {
                    z = false;
                }
                if (!this.mIsLayerOn[i] && this.mAlphas[i] > 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeF.booleanValue;
    }

    public void beginBatchMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mPreventInvalidateCount++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0071 A[LOOP:0: B:38:0x006c->B:40:0x0071, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083 A[EDGE_INSN: B:47:0x0083->B:41:0x0083 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        boolean updateAlphas;
        Drawable[] drawableArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) != null) {
            return;
        }
        int i = this.mTransitionState;
        int i2 = 0;
        boolean z = true;
        if (i == 0) {
            System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
            this.mStartTimeMs = getCurrentTimeMs();
            if (sGlobalFadingEnable && this.mDurationMs != 0) {
                r1 = 0.0f;
            }
            updateAlphas = updateAlphas(r1);
            this.mTransitionState = updateAlphas ? 2 : 1;
            if (updateAlphas) {
                maybeNotifyOnFadeFinished();
            }
        } else if (i != 1) {
            if (i == 2) {
                maybeNotifyOnFadeFinished();
            }
            while (true) {
                drawableArr = this.mLayers;
                if (i2 < drawableArr.length) {
                    break;
                }
                drawDrawableWithAlpha(canvas, drawableArr[i2], (this.mAlphas[i2] * this.mAlpha) / 255);
                i2++;
            }
            if (z) {
                invalidateSelf();
                return;
            }
            return;
        } else {
            Preconditions.checkState(this.mDurationMs > 0);
            updateAlphas = updateAlphas(sGlobalFadingEnable ? ((float) (getCurrentTimeMs() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
            this.mTransitionState = updateAlphas ? 2 : 1;
            if (updateAlphas) {
                maybeNotifyOnFadeFinished();
            }
        }
        z = updateAlphas;
        while (true) {
            drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
            }
            drawDrawableWithAlpha(canvas, drawableArr[i2], (this.mAlphas[i2] * this.mAlpha) / 255);
            i2++;
        }
        if (z) {
        }
    }

    public void endBatchMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mPreventInvalidateCount--;
            invalidateSelf();
        }
    }

    public void fadeInAllLayers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mTransitionState = 0;
            Arrays.fill(this.mIsLayerOn, true);
            invalidateSelf();
        }
    }

    public void fadeInLayer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mCallOnFadeFinishedListener = i == 2;
            this.mTransitionState = 0;
            this.mIsLayerOn[i] = true;
            invalidateSelf();
        }
    }

    public void fadeOutAllLayers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mTransitionState = 0;
            Arrays.fill(this.mIsLayerOn, false);
            invalidateSelf();
        }
    }

    public void fadeOutLayer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mTransitionState = 0;
            this.mIsLayerOn[i] = false;
            invalidateSelf();
        }
    }

    public void fadeToLayer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mTransitionState = 0;
            Arrays.fill(this.mIsLayerOn, false);
            this.mIsLayerOn[i] = true;
            invalidateSelf();
        }
    }

    public void fadeUpToLayer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mTransitionState = 0;
            int i2 = i + 1;
            Arrays.fill(this.mIsLayerOn, 0, i2, true);
            Arrays.fill(this.mIsLayerOn, i2, this.mLayers.length, false);
            invalidateSelf();
        }
    }

    public void finishTransitionImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mTransitionState = 2;
            for (int i = 0; i < this.mLayers.length; i++) {
                this.mAlphas[i] = this.mIsLayerOn[i] ? 255 : 0;
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mAlpha : invokeV.intValue;
    }

    public long getCurrentTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? SystemClock.uptimeMillis() : invokeV.longValue;
    }

    public int getTransitionDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mDurationMs : invokeV.intValue;
    }

    @VisibleForTesting
    public int getTransitionState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mTransitionState : invokeV.intValue;
    }

    public void hideLayerImmediately(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mIsLayerOn[i] = false;
            this.mAlphas[i] = 0;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.mPreventInvalidateCount == 0) {
            super.invalidateSelf();
        }
    }

    public boolean isDefaultLayerIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mDefaultLayerIsOn : invokeV.booleanValue;
    }

    public boolean isLayerOn(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) ? this.mIsLayerOn[i] : invokeI.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            resetInternal();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || this.mAlpha == i) {
            return;
        }
        this.mAlpha = i;
        invalidateSelf();
    }

    public void setOnFadeFinishedListener(OnFadeFinishedListener onFadeFinishedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onFadeFinishedListener) == null) {
            this.mOnFadeFinishedListener = onFadeFinishedListener;
        }
    }

    public void setTransitionDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.mDurationMs = i;
            if (this.mTransitionState == 1) {
                this.mTransitionState = 0;
            }
        }
    }

    public void showLayerImmediately(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.mIsLayerOn[i] = true;
            this.mAlphas[i] = 255;
            invalidateSelf();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FadeDrawable(Drawable[] drawableArr, boolean z) {
        super(drawableArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawableArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Drawable[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.ACTUAL_IMAGE_INDEX = 2;
        Preconditions.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.mLayers = drawableArr;
        this.mStartAlphas = new int[drawableArr.length];
        this.mAlphas = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mIsLayerOn = new boolean[drawableArr.length];
        this.mPreventInvalidateCount = 0;
        this.mDefaultLayerIsOn = z;
        this.mDefaultLayerAlpha = z ? 255 : 0;
        resetInternal();
    }
}
