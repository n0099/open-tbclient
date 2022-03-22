package com.google.android.exoplayer2.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class DecoderCounters {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int decoderInitCount;
    public int decoderReleaseCount;
    public int droppedBufferCount;
    public int droppedToKeyframeCount;
    public int inputBufferCount;
    public int maxConsecutiveDroppedBufferCount;
    public int renderedOutputBufferCount;
    public int skippedInputBufferCount;
    public int skippedOutputBufferCount;

    public DecoderCounters() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public synchronized void ensureUpdated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
            }
        }
    }

    public void merge(DecoderCounters decoderCounters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, decoderCounters) == null) {
            this.decoderInitCount += decoderCounters.decoderInitCount;
            this.decoderReleaseCount += decoderCounters.decoderReleaseCount;
            this.inputBufferCount += decoderCounters.inputBufferCount;
            this.skippedInputBufferCount += decoderCounters.skippedInputBufferCount;
            this.renderedOutputBufferCount += decoderCounters.renderedOutputBufferCount;
            this.skippedOutputBufferCount += decoderCounters.skippedOutputBufferCount;
            this.droppedBufferCount += decoderCounters.droppedBufferCount;
            this.maxConsecutiveDroppedBufferCount = Math.max(this.maxConsecutiveDroppedBufferCount, decoderCounters.maxConsecutiveDroppedBufferCount);
            this.droppedToKeyframeCount += decoderCounters.droppedToKeyframeCount;
        }
    }
}
