package com.google.android.exoplayer2.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.Exception;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int availableInputBufferCount;
    public final I[] availableInputBuffers;
    public int availableOutputBufferCount;
    public final O[] availableOutputBuffers;
    public final Thread decodeThread;
    public I dequeuedInputBuffer;
    public E exception;
    public boolean flushed;
    public final Object lock;
    public final LinkedList<I> queuedInputBuffers;
    public final LinkedList<O> queuedOutputBuffers;
    public boolean released;
    public int skippedOutputBufferCount;

    public SimpleDecoder(I[] iArr, O[] oArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, oArr};
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
        this.queuedInputBuffers = new LinkedList<>();
        this.queuedOutputBuffers = new LinkedList<>();
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int i3 = 0; i3 < this.availableInputBufferCount; i3++) {
            this.availableInputBuffers[i3] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
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

    private boolean canDecodeBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? !this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0 : invokeV.booleanValue;
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
                I removeFirst = this.queuedInputBuffers.removeFirst();
                O[] oArr = this.availableOutputBuffers;
                int i = this.availableOutputBufferCount - 1;
                this.availableOutputBufferCount = i;
                O o = oArr[i];
                boolean z = this.flushed;
                this.flushed = false;
                if (removeFirst.isEndOfStream()) {
                    o.addFlag(4);
                } else {
                    if (removeFirst.isDecodeOnly()) {
                        o.addFlag(Integer.MIN_VALUE);
                    }
                    E decode = decode(removeFirst, o, z);
                    this.exception = decode;
                    if (decode != null) {
                        synchronized (this.lock) {
                        }
                        return false;
                    }
                }
                synchronized (this.lock) {
                    if (this.flushed) {
                        releaseOutputBufferInternal(o);
                    } else if (o.isDecodeOnly()) {
                        this.skippedOutputBufferCount++;
                        releaseOutputBufferInternal(o);
                    } else {
                        o.skippedOutputBufferCount = this.skippedOutputBufferCount;
                        this.skippedOutputBufferCount = 0;
                        this.queuedOutputBuffers.addLast(o);
                    }
                    releaseInputBufferInternal(removeFirst);
                }
                return true;
            }
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
        E e2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && (e2 = this.exception) != null) {
            throw e2;
        }
    }

    private void releaseInputBufferInternal(I i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, i) == null) {
            i.clear();
            I[] iArr = this.availableInputBuffers;
            int i2 = this.availableInputBufferCount;
            this.availableInputBufferCount = i2 + 1;
            iArr[i2] = i;
        }
    }

    private void releaseOutputBufferInternal(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, o) == null) {
            o.clear();
            O[] oArr = this.availableOutputBuffers;
            int i = this.availableOutputBufferCount;
            this.availableOutputBufferCount = i + 1;
            oArr[i] = o;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            do {
                try {
                } catch (InterruptedException e2) {
                    throw new IllegalStateException(e2);
                }
            } while (decode());
        }
    }

    public abstract I createInputBuffer();

    public abstract O createOutputBuffer();

    public abstract E decode(I i, O o, boolean z);

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
                    releaseInputBufferInternal(this.queuedInputBuffers.removeFirst());
                }
                while (!this.queuedOutputBuffers.isEmpty()) {
                    releaseOutputBufferInternal(this.queuedOutputBuffers.removeFirst());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.exoplayer2.decoder.SimpleDecoder<I extends com.google.android.exoplayer2.decoder.DecoderInputBuffer, O extends com.google.android.exoplayer2.decoder.OutputBuffer, E extends java.lang.Exception> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(Object obj) throws Exception {
        queueInputBuffer((SimpleDecoder<I, O, E>) ((DecoderInputBuffer) obj));
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

    public void releaseOutputBuffer(O o) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, o) == null) {
            synchronized (this.lock) {
                releaseOutputBufferInternal(o);
                maybeNotifyDecodeLoop();
            }
        }
    }

    public final void setInitialInputBufferSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length);
            for (I i2 : this.availableInputBuffers) {
                i2.ensureSpaceForWrite(i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final I dequeueInputBuffer() throws Exception {
        InterceptResult invokeV;
        I i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.lock) {
                maybeThrowException();
                Assertions.checkState(this.dequeuedInputBuffer == null);
                if (this.availableInputBufferCount == 0) {
                    i = null;
                } else {
                    I[] iArr = this.availableInputBuffers;
                    int i2 = this.availableInputBufferCount - 1;
                    this.availableInputBufferCount = i2;
                    i = iArr[i2];
                }
                this.dequeuedInputBuffer = i;
            }
            return i;
        }
        return (I) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final O dequeueOutputBuffer() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.lock) {
                maybeThrowException();
                if (this.queuedOutputBuffers.isEmpty()) {
                    return null;
                }
                return this.queuedOutputBuffers.removeFirst();
            }
        }
        return (O) invokeV.objValue;
    }

    public final void queueInputBuffer(I i) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            synchronized (this.lock) {
                maybeThrowException();
                Assertions.checkArgument(i == this.dequeuedInputBuffer);
                this.queuedInputBuffers.addLast(i);
                maybeNotifyDecodeLoop();
                this.dequeuedInputBuffer = null;
            }
        }
    }
}
