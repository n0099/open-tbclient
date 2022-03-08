package com.google.android.exoplayer2.source.chunk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
/* loaded from: classes7.dex */
public final class BaseMediaChunkOutput implements ChunkExtractorWrapper.TrackOutputProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BaseMediaChunkOutput";
    public transient /* synthetic */ FieldHolder $fh;
    public final SampleQueue[] sampleQueues;
    public final int[] trackTypes;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, sampleQueueArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.trackTypes = iArr;
        this.sampleQueues = sampleQueueArr;
    }

    public int[] getWriteIndices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (int[]) invokeV.objValue;
        }
        int[] iArr = new int[this.sampleQueues.length];
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (i2 >= sampleQueueArr.length) {
                return iArr;
            }
            if (sampleQueueArr[i2] != null) {
                iArr[i2] = sampleQueueArr[i2].getWriteIndex();
            }
            i2++;
        }
    }

    public void setSampleOffsetUs(long j2) {
        SampleQueue[] sampleQueueArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                if (sampleQueue != null) {
                    sampleQueue.setSampleOffsetUs(j2);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider
    public TrackOutput track(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) != null) {
            return (TrackOutput) invokeII.objValue;
        }
        int i4 = 0;
        while (true) {
            int[] iArr = this.trackTypes;
            if (i4 < iArr.length) {
                if (i3 == iArr[i4]) {
                    return this.sampleQueues[i4];
                }
                i4++;
            } else {
                String str = "Unmatched track of type: " + i3;
                return new DummyTrackOutput();
            }
        }
    }
}
