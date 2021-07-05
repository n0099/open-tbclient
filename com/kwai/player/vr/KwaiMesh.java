package com.kwai.player.vr;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public class KwaiMesh {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int sPositionDataSize = 3;
    public static final int sTextureCoordinateDataSize = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public ShortBuffer mIndicesBuffer;
    public int mNumIndices;
    public SparseArray<FloatBuffer> mTexCoordinateBuffers;
    public SparseArray<FloatBuffer> mVerticesBuffers;

    public KwaiMesh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTexCoordinateBuffers = new SparseArray<>(2);
        this.mVerticesBuffers = new SparseArray<>(2);
    }

    public ShortBuffer getIndicesBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIndicesBuffer : (ShortBuffer) invokeV.objValue;
    }

    public int getNumIndices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mNumIndices : invokeV.intValue;
    }

    public FloatBuffer getTexCoordinateBuffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.mTexCoordinateBuffers.get(i2) : (FloatBuffer) invokeI.objValue;
    }

    public FloatBuffer getVerticesBuffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.mVerticesBuffers.get(i2) : (FloatBuffer) invokeI.objValue;
    }

    public void setIndicesBuffer(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, shortBuffer) == null) {
            this.mIndicesBuffer = shortBuffer;
        }
    }

    public void setNumIndices(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mNumIndices = i2;
        }
    }

    public void setTexCoordinateBuffer(int i2, FloatBuffer floatBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, floatBuffer) == null) {
            this.mTexCoordinateBuffers.put(i2, floatBuffer);
        }
    }

    public void setVerticesBuffer(int i2, FloatBuffer floatBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, floatBuffer) == null) {
            this.mVerticesBuffers.put(i2, floatBuffer);
        }
    }
}
