package com.faceunity.gles;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.Drawable2d;
/* loaded from: classes6.dex */
public class FullFrameRect {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Texture2dProgram mProgram;
    public final Drawable2d mRectDrawable;

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture2dProgram};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.mProgram = texture2dProgram;
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, texture2dProgram) == null) {
            this.mProgram.release();
            this.mProgram = texture2dProgram;
        }
    }

    public int createTextureObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mProgram.createTextureObject() : invokeV.intValue;
    }

    public void drawFrame(int i2, float[] fArr) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, fArr) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        texture2dProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i2, this.mRectDrawable.getTexCoordStride());
    }

    public Texture2dProgram getProgram() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mProgram : (Texture2dProgram) invokeV.objValue;
    }

    public void release(boolean z) {
        Texture2dProgram texture2dProgram;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (texture2dProgram = this.mProgram) == null) {
            return;
        }
        if (z) {
            texture2dProgram.release();
        }
        this.mProgram = null;
    }
}
