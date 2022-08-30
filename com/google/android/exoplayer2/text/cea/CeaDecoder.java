package com.google.android.exoplayer2.text.cea;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.PriorityQueue;
/* loaded from: classes7.dex */
public abstract class CeaDecoder implements SubtitleDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NUM_INPUT_BUFFERS = 10;
    public static final int NUM_OUTPUT_BUFFERS = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<SubtitleInputBuffer> availableInputBuffers;
    public final LinkedList<SubtitleOutputBuffer> availableOutputBuffers;
    public SubtitleInputBuffer dequeuedInputBuffer;
    public long playbackPositionUs;
    public final PriorityQueue<SubtitleInputBuffer> queuedInputBuffers;

    public CeaDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.availableInputBuffers = new LinkedList<>();
        for (int i3 = 0; i3 < 10; i3++) {
            this.availableInputBuffers.add(new SubtitleInputBuffer());
        }
        this.availableOutputBuffers = new LinkedList<>();
        for (int i4 = 0; i4 < 2; i4++) {
            this.availableOutputBuffers.add(new CeaOutputBuffer(this));
        }
        this.queuedInputBuffers = new PriorityQueue<>();
    }

    private void releaseInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, subtitleInputBuffer) == null) {
            subtitleInputBuffer.clear();
            this.availableInputBuffers.add(subtitleInputBuffer);
        }
    }

    public abstract Subtitle createSubtitle();

    public abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.playbackPositionUs = 0L;
            while (!this.queuedInputBuffers.isEmpty()) {
                releaseInputBuffer(this.queuedInputBuffers.poll());
            }
            SubtitleInputBuffer subtitleInputBuffer = this.dequeuedInputBuffer;
            if (subtitleInputBuffer != null) {
                releaseInputBuffer(subtitleInputBuffer);
                this.dequeuedInputBuffer = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract String getName();

    public abstract boolean isNewSubtitleDataAvailable();

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, subtitleOutputBuffer) == null) {
            subtitleOutputBuffer.clear();
            this.availableOutputBuffers.add(subtitleOutputBuffer);
        }
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.playbackPositionUs = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Assertions.checkState(this.dequeuedInputBuffer == null);
            if (this.availableInputBuffers.isEmpty()) {
                return null;
            }
            SubtitleInputBuffer pollFirst = this.availableInputBuffers.pollFirst();
            this.dequeuedInputBuffer = pollFirst;
            return pollFirst;
        }
        return (SubtitleInputBuffer) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.availableOutputBuffers.isEmpty()) {
                return null;
            }
            while (!this.queuedInputBuffers.isEmpty() && this.queuedInputBuffers.peek().timeUs <= this.playbackPositionUs) {
                SubtitleInputBuffer poll = this.queuedInputBuffers.poll();
                if (poll.isEndOfStream()) {
                    SubtitleOutputBuffer pollFirst = this.availableOutputBuffers.pollFirst();
                    pollFirst.addFlag(4);
                    releaseInputBuffer(poll);
                    return pollFirst;
                }
                decode(poll);
                if (isNewSubtitleDataAvailable()) {
                    Subtitle createSubtitle = createSubtitle();
                    if (!poll.isDecodeOnly()) {
                        SubtitleOutputBuffer pollFirst2 = this.availableOutputBuffers.pollFirst();
                        pollFirst2.setContent(poll.timeUs, createSubtitle, Long.MAX_VALUE);
                        releaseInputBuffer(poll);
                        return pollFirst2;
                    }
                }
                releaseInputBuffer(poll);
            }
            return null;
        }
        return (SubtitleOutputBuffer) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, subtitleInputBuffer) == null) {
            Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
            if (subtitleInputBuffer.isDecodeOnly()) {
                releaseInputBuffer(subtitleInputBuffer);
            } else {
                this.queuedInputBuffers.add(subtitleInputBuffer);
            }
            this.dequeuedInputBuffer = null;
        }
    }
}
