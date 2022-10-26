package com.google.android.exoplayer2.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public abstract class SimpleDecoder implements Decoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int availableInputBufferCount;
    public final DecoderInputBuffer[] availableInputBuffers;
    public int availableOutputBufferCount;
    public final OutputBuffer[] availableOutputBuffers;
    public final Thread decodeThread;
    public DecoderInputBuffer dequeuedInputBuffer;
    public Exception exception;
    public boolean flushed;
    public final Object lock;
    public final LinkedList queuedInputBuffers;
    public final LinkedList queuedOutputBuffers;
    public boolean released;
    public int skippedOutputBufferCount;

    public abstract DecoderInputBuffer createInputBuffer();

    public abstract OutputBuffer createOutputBuffer();

    public abstract Exception decode(DecoderInputBuffer decoderInputBuffer, OutputBuffer outputBuffer, boolean z);

    public SimpleDecoder(DecoderInputBuffer[] decoderInputBufferArr, OutputBuffer[] outputBufferArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {decoderInputBufferArr, outputBufferArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lock = new Object();
        this.queuedInputBuffers = new LinkedList();
        this.queuedOutputBuffers = new LinkedList();
        this.availableInputBuffers = decoderInputBufferArr;
        this.availableInputBufferCount = decoderInputBufferArr.length;
        for (int i3 = 0; i3 < this.availableInputBufferCount; i3++) {
            this.availableInputBuffers[i3] = createInputBuffer();
        }
        this.availableOutputBuffers = outputBufferArr;
        this.availableOutputBufferCount = outputBufferArr.length;
        for (int i4 = 0; i4 < this.availableOutputBufferCount; i4++) {
            this.availableOutputBuffers[i4] = createOutputBuffer();
        }
        Thread thread = new Thread(this) { // from class: com.google.android.exoplayer2.decoder.SimpleDecoder.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SimpleDecoder this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.run();
                }
            }
        };
        this.decodeThread = thread;
        thread.start();
    }

    private void releaseInputBufferInternal(DecoderInputBuffer decoderInputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, decoderInputBuffer) == null) {
            decoderInputBuffer.clear();
            DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
            int i = this.availableInputBufferCount;
            this.availableInputBufferCount = i + 1;
            decoderInputBufferArr[i] = decoderInputBuffer;
        }
    }

    private void releaseOutputBufferInternal(OutputBuffer outputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, outputBuffer) == null) {
            outputBuffer.clear();
            OutputBuffer[] outputBufferArr = this.availableOutputBuffers;
            int i = this.availableOutputBufferCount;
            this.availableOutputBufferCount = i + 1;
            outputBufferArr[i] = outputBuffer;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws Exception {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, decoderInputBuffer) == null) {
            synchronized (this.lock) {
                maybeThrowException();
                if (decoderInputBuffer == this.dequeuedInputBuffer) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z);
                this.queuedInputBuffers.addLast(decoderInputBuffer);
                maybeNotifyDecodeLoop();
                this.dequeuedInputBuffer = null;
            }
        }
    }

    public void releaseOutputBuffer(OutputBuffer outputBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, outputBuffer) == null) {
            synchronized (this.lock) {
                releaseOutputBufferInternal(outputBuffer);
                maybeNotifyDecodeLoop();
            }
        }
    }

    public final void setInitialInputBufferSize(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (this.availableInputBufferCount == this.availableInputBuffers.length) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            for (DecoderInputBuffer decoderInputBuffer : this.availableInputBuffers) {
                decoderInputBuffer.ensureSpaceForWrite(i);
            }
        }
    }

    private boolean canDecodeBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void maybeNotifyDecodeLoop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    private void maybeThrowException() throws Exception {
        Exception exc;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65541, this) != null) || (exc = this.exception) == null) {
            return;
        }
        throw exc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            do {
                try {
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            } while (decode());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final OutputBuffer dequeueOutputBuffer() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.lock) {
                maybeThrowException();
                if (this.queuedOutputBuffers.isEmpty()) {
                    return null;
                }
                return (OutputBuffer) this.queuedOutputBuffers.removeFirst();
            }
        }
        return (OutputBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.lock) {
                this.released = true;
                this.lock.notify();
            }
            try {
                this.decodeThread.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private boolean decode() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this.lock) {
                while (!this.released && !canDecodeBuffer()) {
                    this.lock.wait();
                }
                if (this.released) {
                    return false;
                }
                DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.queuedInputBuffers.removeFirst();
                OutputBuffer[] outputBufferArr = this.availableOutputBuffers;
                int i = this.availableOutputBufferCount - 1;
                this.availableOutputBufferCount = i;
                OutputBuffer outputBuffer = outputBufferArr[i];
                boolean z = this.flushed;
                this.flushed = false;
                if (decoderInputBuffer.isEndOfStream()) {
                    outputBuffer.addFlag(4);
                } else {
                    if (decoderInputBuffer.isDecodeOnly()) {
                        outputBuffer.addFlag(Integer.MIN_VALUE);
                    }
                    Exception decode = decode(decoderInputBuffer, outputBuffer, z);
                    this.exception = decode;
                    if (decode != null) {
                        synchronized (this.lock) {
                        }
                        return false;
                    }
                }
                synchronized (this.lock) {
                    if (this.flushed) {
                        releaseOutputBufferInternal(outputBuffer);
                    } else if (outputBuffer.isDecodeOnly()) {
                        this.skippedOutputBufferCount++;
                        releaseOutputBufferInternal(outputBuffer);
                    } else {
                        outputBuffer.skippedOutputBufferCount = this.skippedOutputBufferCount;
                        this.skippedOutputBufferCount = 0;
                        this.queuedOutputBuffers.addLast(outputBuffer);
                    }
                    releaseInputBufferInternal(decoderInputBuffer);
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final DecoderInputBuffer dequeueInputBuffer() throws Exception {
        InterceptResult invokeV;
        boolean z;
        DecoderInputBuffer decoderInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.lock) {
                maybeThrowException();
                if (this.dequeuedInputBuffer == null) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkState(z);
                if (this.availableInputBufferCount == 0) {
                    decoderInputBuffer = null;
                } else {
                    DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
                    int i = this.availableInputBufferCount - 1;
                    this.availableInputBufferCount = i;
                    decoderInputBuffer = decoderInputBufferArr[i];
                }
                this.dequeuedInputBuffer = decoderInputBuffer;
            }
            return decoderInputBuffer;
        }
        return (DecoderInputBuffer) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.lock) {
                this.flushed = true;
                this.skippedOutputBufferCount = 0;
                if (this.dequeuedInputBuffer != null) {
                    releaseInputBufferInternal(this.dequeuedInputBuffer);
                    this.dequeuedInputBuffer = null;
                }
                while (!this.queuedInputBuffers.isEmpty()) {
                    releaseInputBufferInternal((DecoderInputBuffer) this.queuedInputBuffers.removeFirst());
                }
                while (!this.queuedOutputBuffers.isEmpty()) {
                    releaseOutputBufferInternal((OutputBuffer) this.queuedOutputBuffers.removeFirst());
                }
            }
        }
    }
}
