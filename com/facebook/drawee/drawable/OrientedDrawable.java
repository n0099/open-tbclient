package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
/* loaded from: classes7.dex */
public class OrientedDrawable extends ForwardingDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mExifOrientation;
    public int mRotationAngle;
    @VisibleForTesting
    public final Matrix mRotationMatrix;
    public final Matrix mTempMatrix;
    public final RectF mTempRectF;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrientedDrawable(Drawable drawable, int i2) {
        this(drawable, i2, 0);
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
                this((Drawable) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.mRotationAngle <= 0 && ((i2 = this.mExifOrientation) == 0 || i2 == 1)) {
                super.draw(canvas);
                return;
            }
            int save = canvas.save();
            canvas.concat(this.mRotationMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.mExifOrientation;
            if (i2 != 5 && i2 != 7 && this.mRotationAngle % 180 == 0) {
                return super.getIntrinsicHeight();
            }
            return super.getIntrinsicWidth();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.mExifOrientation;
            if (i2 != 5 && i2 != 7 && this.mRotationAngle % 180 == 0) {
                return super.getIntrinsicWidth();
            }
            return super.getIntrinsicHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, matrix) == null) {
            getParentTransform(matrix);
            if (this.mRotationMatrix.isIdentity()) {
                return;
            }
            matrix.preConcat(this.mRotationMatrix);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rect) == null) {
            Drawable current = getCurrent();
            if (this.mRotationAngle <= 0 && ((i2 = this.mExifOrientation) == 0 || i2 == 1)) {
                current.setBounds(rect);
                return;
            }
            int i3 = this.mExifOrientation;
            if (i3 == 2) {
                this.mRotationMatrix.setScale(-1.0f, 1.0f);
            } else if (i3 == 7) {
                this.mRotationMatrix.setRotate(270.0f, rect.centerX(), rect.centerY());
                this.mRotationMatrix.postScale(-1.0f, 1.0f);
            } else if (i3 == 4) {
                this.mRotationMatrix.setScale(1.0f, -1.0f);
            } else if (i3 != 5) {
                this.mRotationMatrix.setRotate(this.mRotationAngle, rect.centerX(), rect.centerY());
            } else {
                this.mRotationMatrix.setRotate(270.0f, rect.centerX(), rect.centerY());
                this.mRotationMatrix.postScale(1.0f, -1.0f);
            }
            this.mTempMatrix.reset();
            this.mRotationMatrix.invert(this.mTempMatrix);
            this.mTempRectF.set(rect);
            this.mTempMatrix.mapRect(this.mTempRectF);
            RectF rectF = this.mTempRectF;
            current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrientedDrawable(Drawable drawable, int i2, int i3) {
        super(drawable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        boolean z = true;
        Preconditions.checkArgument(i2 % 90 == 0);
        Preconditions.checkArgument((i3 < 0 || i3 > 8) ? false : false);
        this.mRotationMatrix = new Matrix();
        this.mRotationAngle = i2;
        this.mExifOrientation = i3;
    }
}
