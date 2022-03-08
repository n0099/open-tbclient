package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
/* loaded from: classes7.dex */
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable, CloneableDrawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEGREES_IN_FULL_ROTATION = 360;
    public static final int FRAME_INTERVAL_MS = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mClockwise;
    public int mInterval;
    public boolean mIsScheduled;
    @VisibleForTesting
    public float mRotationAngle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoRotateDrawable(Drawable drawable, int i2) {
        this(drawable, i2, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int getIncrement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (int) ((20.0f / this.mInterval) * 360.0f) : invokeV.intValue;
    }

    private void scheduleNextFrame() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mIsScheduled) {
            return;
        }
        this.mIsScheduled = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int save = canvas.save();
            Rect bounds = getBounds();
            int i2 = bounds.right - bounds.left;
            int i3 = bounds.bottom - bounds.top;
            float f2 = this.mRotationAngle;
            if (!this.mClockwise) {
                f2 = 360.0f - f2;
            }
            canvas.rotate(f2, bounds.left + (i2 / 2), bounds.top + (i3 / 2));
            super.draw(canvas);
            canvas.restoreToCount(save);
            scheduleNextFrame();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mRotationAngle = 0.0f;
            this.mIsScheduled = false;
            unscheduleSelf(this);
            invalidateSelf();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mIsScheduled = false;
            this.mRotationAngle += getIncrement();
            invalidateSelf();
        }
    }

    public void setClockwise(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mClockwise = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoRotateDrawable(Drawable drawable, int i2, boolean z) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRotationAngle = 0.0f;
        this.mIsScheduled = false;
        this.mInterval = i2;
        this.mClockwise = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public AutoRotateDrawable cloneDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new AutoRotateDrawable(DrawableUtils.cloneDrawable(getDrawable()), this.mInterval, this.mClockwise) : (AutoRotateDrawable) invokeV.objValue;
    }
}
