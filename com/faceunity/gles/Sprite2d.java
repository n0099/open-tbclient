package com.faceunity.gles;

import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Sprite2d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Grafika";
    public transient /* synthetic */ FieldHolder $fh;
    public float mAngle;
    public float[] mColor;
    public Drawable2d mDrawable;
    public boolean mMatrixReady;
    public float[] mModelViewMatrix;
    public float mPosX;
    public float mPosY;
    public float mScaleX;
    public float mScaleY;
    public float[] mScratchMatrix;
    public int mTextureId;

    public Sprite2d(Drawable2d drawable2d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable2d};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mScratchMatrix = new float[16];
        this.mDrawable = drawable2d;
        float[] fArr = new float[4];
        this.mColor = fArr;
        fArr[3] = 1.0f;
        this.mTextureId = -1;
        this.mModelViewMatrix = new float[16];
        this.mMatrixReady = false;
    }

    private void recomputeMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            float[] fArr = this.mModelViewMatrix;
            Matrix.setIdentityM(fArr, 0);
            Matrix.translateM(fArr, 0, this.mPosX, this.mPosY, 0.0f);
            float f2 = this.mAngle;
            if (f2 != 0.0f) {
                Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
            }
            Matrix.scaleM(fArr, 0, this.mScaleX, this.mScaleY, 1.0f);
            this.mMatrixReady = true;
        }
    }

    public void draw(FlatShadedProgram flatShadedProgram, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, flatShadedProgram, fArr) == null) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr, 0, getModelViewMatrix(), 0);
            flatShadedProgram.draw(this.mScratchMatrix, this.mColor, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride());
        }
    }

    public float[] getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mColor : (float[]) invokeV.objValue;
    }

    public float[] getModelViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.mMatrixReady) {
                recomputeMatrix();
            }
            return this.mModelViewMatrix;
        }
        return (float[]) invokeV.objValue;
    }

    public float getPositionX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPosX : invokeV.floatValue;
    }

    public float getPositionY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPosY : invokeV.floatValue;
    }

    public float getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAngle : invokeV.floatValue;
    }

    public float getScaleX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mScaleX : invokeV.floatValue;
    }

    public float getScaleY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mScaleY : invokeV.floatValue;
    }

    public void setColor(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float[] fArr = this.mColor;
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
        }
    }

    public void setPosition(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mPosX = f2;
            this.mPosY = f3;
            this.mMatrixReady = false;
        }
    }

    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            while (f2 >= 360.0f) {
                f2 -= 360.0f;
            }
            while (f2 <= -360.0f) {
                f2 += 360.0f;
            }
            this.mAngle = f2;
            this.mMatrixReady = false;
        }
    }

    public void setScale(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mScaleX = f2;
            this.mScaleY = f3;
            this.mMatrixReady = false;
        }
    }

    public void setTexture(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mTextureId = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "[Sprite2d pos=" + this.mPosX + "," + this.mPosY + " scale=" + this.mScaleX + "," + this.mScaleY + " angle=" + this.mAngle + " color={" + this.mColor[0] + "," + this.mColor[1] + "," + this.mColor[2] + "} drawable=" + this.mDrawable + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public void draw(Texture2dProgram texture2dProgram, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, texture2dProgram, fArr) == null) {
            Matrix.multiplyMM(this.mScratchMatrix, 0, fArr, 0, getModelViewMatrix(), 0);
            texture2dProgram.draw(this.mScratchMatrix, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride(), GlUtil.IDENTITY_MATRIX, this.mDrawable.getTexCoordArray(), this.mTextureId, this.mDrawable.getTexCoordStride());
        }
    }
}
