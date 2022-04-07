package com.google.android.exoplayer2.source.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
/* loaded from: classes4.dex */
public abstract class BaseMediaChunk extends MediaChunk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] firstSampleIndices;
    public BaseMediaChunkOutput output;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, int i2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {dataSource, dataSpec, format, Integer.valueOf(i), obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DataSource) objArr2[0], (DataSpec) objArr2[1], (Format) objArr2[2], ((Integer) objArr2[3]).intValue(), objArr2[4], ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int getFirstSampleIndex(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.firstSampleIndices[i] : invokeI.intValue;
    }

    public final BaseMediaChunkOutput getOutput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.output : (BaseMediaChunkOutput) invokeV.objValue;
    }

    public void init(BaseMediaChunkOutput baseMediaChunkOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseMediaChunkOutput) == null) {
            this.output = baseMediaChunkOutput;
            this.firstSampleIndices = baseMediaChunkOutput.getWriteIndices();
        }
    }
}
