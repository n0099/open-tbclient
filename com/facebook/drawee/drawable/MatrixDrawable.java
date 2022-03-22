package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
/* loaded from: classes6.dex */
public class MatrixDrawable extends ForwardingDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Matrix mDrawMatrix;
    public Matrix mMatrix;
    public int mUnderlyingHeight;
    public int mUnderlyingWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatrixDrawable(Drawable drawable, Matrix matrix) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, matrix};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mMatrix = matrix;
    }

    private void configureBounds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Drawable current = getCurrent();
            Rect bounds = getBounds();
            int intrinsicWidth = current.getIntrinsicWidth();
            this.mUnderlyingWidth = intrinsicWidth;
            int intrinsicHeight = current.getIntrinsicHeight();
            this.mUnderlyingHeight = intrinsicHeight;
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.mDrawMatrix = this.mMatrix;
                return;
            }
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        }
    }

    private void configureBoundsIfUnderlyingChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth() && this.mUnderlyingHeight == getCurrent().getIntrinsicHeight()) {
                return;
            }
            configureBounds();
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            configureBoundsIfUnderlyingChanged();
            if (this.mDrawMatrix != null) {
                int save = canvas.save();
                canvas.clipRect(getBounds());
                canvas.concat(this.mDrawMatrix);
                super.draw(canvas);
                canvas.restoreToCount(save);
                return;
            }
            super.draw(canvas);
        }
    }

    public Matrix getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMatrix : (Matrix) invokeV.objValue;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, matrix) == null) {
            super.getTransform(matrix);
            Matrix matrix2 = this.mDrawMatrix;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rect) == null) {
            super.onBoundsChange(rect);
            configureBounds();
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, drawable)) == null) {
            Drawable current = super.setCurrent(drawable);
            configureBounds();
            return current;
        }
        return (Drawable) invokeL.objValue;
    }

    public void setMatrix(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, matrix) == null) {
            this.mMatrix = matrix;
            configureBounds();
            invalidateSelf();
        }
    }
}
