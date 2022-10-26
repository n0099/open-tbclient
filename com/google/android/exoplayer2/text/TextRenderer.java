package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_UPDATE_OUTPUT = 0;
    public static final int REPLACEMENT_STATE_NONE = 0;
    public static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    public static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public SubtitleDecoder decoder;
    public final SubtitleDecoderFactory decoderFactory;
    public int decoderReplacementState;
    public final FormatHolder formatHolder;
    public boolean inputStreamEnded;
    public SubtitleInputBuffer nextInputBuffer;
    public SubtitleOutputBuffer nextSubtitle;
    public int nextSubtitleEventIndex;
    public final TextOutput output;
    public final Handler outputHandler;
    public boolean outputStreamEnded;
    public Format streamFormat;
    public SubtitleOutputBuffer subtitle;

    @Deprecated
    /* loaded from: classes7.dex */
    public interface Output extends TextOutput {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textOutput, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TextOutput) objArr2[0], (Looper) objArr2[1], (SubtitleDecoderFactory) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textOutput, looper, subtitleDecoderFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.output = (TextOutput) Assertions.checkNotNull(textOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = new Handler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = new FormatHolder();
    }

    private void clearOutput() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            updateOutput(Collections.emptyList());
        }
    }

    private long getNextEventTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i = this.nextSubtitleEventIndex;
            if (i != -1 && i < this.subtitle.getEventTimeCount()) {
                return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
            }
            return Long.MAX_VALUE;
        }
        return invokeV.longValue;
    }

    private void releaseBuffers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.nextInputBuffer = null;
            this.nextSubtitleEventIndex = -1;
            SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
            if (subtitleOutputBuffer != null) {
                subtitleOutputBuffer.release();
                this.subtitle = null;
            }
            SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
            if (subtitleOutputBuffer2 != null) {
                subtitleOutputBuffer2.release();
                this.nextSubtitle = null;
            }
        }
    }

    private void releaseDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            releaseBuffers();
            this.decoder.release();
            this.decoder = null;
            this.decoderReplacementState = 0;
        }
    }

    private void replaceDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            releaseDecoder();
            this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.outputStreamEnded;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.streamFormat = null;
            clearOutput();
            releaseDecoder();
        }
    }

    private void invokeUpdateOutputInternal(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) {
            this.output.onCues(list);
        }
    }

    private void updateOutput(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, list) == null) {
            Handler handler = this.outputHandler;
            if (handler != null) {
                handler.obtainMessage(0, list).sendToTarget();
            } else {
                invokeUpdateOutputInternal(list);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message.what == 0) {
                invokeUpdateOutputInternal((List) message.obj);
                return true;
            }
            throw new IllegalStateException();
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, format)) == null) {
            if (this.decoderFactory.supportsFormat(format)) {
                if (BaseRenderer.supportsFormatDrm(null, format.drmInitData)) {
                    return 4;
                }
                return 2;
            } else if (MimeTypes.isText(format.sampleMimeType)) {
                return 1;
            } else {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            clearOutput();
            this.inputStreamEnded = false;
            this.outputStreamEnded = false;
            if (this.decoderReplacementState != 0) {
                replaceDecoder();
                return;
            }
            releaseBuffers();
            this.decoder.flush();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, formatArr, j) == null) {
            Format format = formatArr[0];
            this.streamFormat = format;
            if (this.decoder != null) {
                this.decoderReplacementState = 1;
            } else {
                this.decoder = this.decoderFactory.createDecoder(format);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) || this.outputStreamEnded) {
            return;
        }
        if (this.nextSubtitle == null) {
            this.decoder.setPositionUs(j);
            try {
                this.nextSubtitle = (SubtitleOutputBuffer) this.decoder.dequeueOutputBuffer();
            } catch (SubtitleDecoderException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.subtitle != null) {
            long nextEventTime = getNextEventTime();
            z = false;
            while (nextEventTime <= j) {
                this.nextSubtitleEventIndex++;
                nextEventTime = getNextEventTime();
                z = true;
            }
        } else {
            z = false;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.nextSubtitle;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.isEndOfStream()) {
                if (!z && getNextEventTime() == Long.MAX_VALUE) {
                    if (this.decoderReplacementState == 2) {
                        replaceDecoder();
                    } else {
                        releaseBuffers();
                        this.outputStreamEnded = true;
                    }
                }
            } else if (this.nextSubtitle.timeUs <= j) {
                SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.release();
                }
                SubtitleOutputBuffer subtitleOutputBuffer3 = this.nextSubtitle;
                this.subtitle = subtitleOutputBuffer3;
                this.nextSubtitle = null;
                this.nextSubtitleEventIndex = subtitleOutputBuffer3.getNextEventTimeIndex(j);
                z = true;
            }
        }
        if (z) {
            updateOutput(this.subtitle.getCues(j));
        }
        if (this.decoderReplacementState == 2) {
            return;
        }
        while (!this.inputStreamEnded) {
            try {
                if (this.nextInputBuffer == null) {
                    SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) this.decoder.dequeueInputBuffer();
                    this.nextInputBuffer = subtitleInputBuffer;
                    if (subtitleInputBuffer == null) {
                        return;
                    }
                }
                if (this.decoderReplacementState == 1) {
                    this.nextInputBuffer.setFlags(4);
                    this.decoder.queueInputBuffer(this.nextInputBuffer);
                    this.nextInputBuffer = null;
                    this.decoderReplacementState = 2;
                    return;
                }
                int readSource = readSource(this.formatHolder, this.nextInputBuffer, false);
                if (readSource == -4) {
                    if (this.nextInputBuffer.isEndOfStream()) {
                        this.inputStreamEnded = true;
                    } else {
                        this.nextInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                        this.nextInputBuffer.flip();
                    }
                    this.decoder.queueInputBuffer(this.nextInputBuffer);
                    this.nextInputBuffer = null;
                } else if (readSource == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                throw ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }
}
