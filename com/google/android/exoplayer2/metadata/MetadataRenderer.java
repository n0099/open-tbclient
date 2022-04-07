package com.google.android.exoplayer2.metadata;

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
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_PENDING_METADATA_COUNT = 5;
    public static final int MSG_INVOKE_RENDERER = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final MetadataInputBuffer buffer;
    public MetadataDecoder decoder;
    public final MetadataDecoderFactory decoderFactory;
    public final FormatHolder formatHolder;
    public boolean inputStreamEnded;
    public final MetadataOutput output;
    public final Handler outputHandler;
    public final Metadata[] pendingMetadata;
    public int pendingMetadataCount;
    public int pendingMetadataIndex;
    public final long[] pendingMetadataTimestamps;

    @Deprecated
    /* loaded from: classes4.dex */
    public interface Output extends MetadataOutput {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {metadataOutput, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MetadataOutput) objArr2[0], (Looper) objArr2[1], (MetadataDecoderFactory) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void flushPendingMetadata() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Arrays.fill(this.pendingMetadata, (Object) null);
            this.pendingMetadataIndex = 0;
            this.pendingMetadataCount = 0;
        }
    }

    private void invokeRenderer(Metadata metadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, metadata) == null) {
            Handler handler = this.outputHandler;
            if (handler != null) {
                handler.obtainMessage(0, metadata).sendToTarget();
            } else {
                invokeRendererInternal(metadata);
            }
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, metadata) == null) {
            this.output.onMetadata(metadata);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message.what == 0) {
                invokeRendererInternal((Metadata) message.obj);
                return true;
            }
            throw new IllegalStateException();
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.inputStreamEnded : invokeV.booleanValue;
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

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            flushPendingMetadata();
            this.decoder = null;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            flushPendingMetadata();
            this.inputStreamEnded = false;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, formatArr, j) == null) {
            this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (!this.inputStreamEnded && this.pendingMetadataCount < 5) {
                this.buffer.clear();
                if (readSource(this.formatHolder, this.buffer, false) == -4) {
                    if (this.buffer.isEndOfStream()) {
                        this.inputStreamEnded = true;
                    } else if (!this.buffer.isDecodeOnly()) {
                        MetadataInputBuffer metadataInputBuffer = this.buffer;
                        metadataInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                        metadataInputBuffer.flip();
                        try {
                            int i = (this.pendingMetadataIndex + this.pendingMetadataCount) % 5;
                            this.pendingMetadata[i] = this.decoder.decode(this.buffer);
                            this.pendingMetadataTimestamps[i] = this.buffer.timeUs;
                            this.pendingMetadataCount++;
                        } catch (MetadataDecoderException e) {
                            throw ExoPlaybackException.createForRenderer(e, getIndex());
                        }
                    }
                }
            }
            if (this.pendingMetadataCount > 0) {
                long[] jArr = this.pendingMetadataTimestamps;
                int i2 = this.pendingMetadataIndex;
                if (jArr[i2] <= j) {
                    invokeRenderer(this.pendingMetadata[i2]);
                    Metadata[] metadataArr = this.pendingMetadata;
                    int i3 = this.pendingMetadataIndex;
                    metadataArr[i3] = null;
                    this.pendingMetadataIndex = (i3 + 1) % 5;
                    this.pendingMetadataCount--;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, format)) == null) {
            if (this.decoderFactory.supportsFormat(format)) {
                return BaseRenderer.supportsFormatDrm(null, format.drmInitData) ? 4 : 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {metadataOutput, looper, metadataDecoderFactory};
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
        this.output = (MetadataOutput) Assertions.checkNotNull(metadataOutput);
        this.outputHandler = looper == null ? null : new Handler(looper, this);
        this.decoderFactory = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.formatHolder = new FormatHolder();
        this.buffer = new MetadataInputBuffer();
        this.pendingMetadata = new Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }
}
