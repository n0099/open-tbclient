package d.a.x.c.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f69053i = "b";
    public static long j = 0;
    public static int k = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f69054a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69055b;

    /* renamed from: c  reason: collision with root package name */
    public e f69056c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f69057d;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f69058e;

    /* renamed from: f  reason: collision with root package name */
    public c f69059f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f69060g;

    /* renamed from: h  reason: collision with root package name */
    public long f69061h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(36906281, "Ld/a/x/c/g/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(36906281, "Ld/a/x/c/g/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69054a = -1;
        this.f69055b = false;
        this.f69061h = 0L;
        this.f69058e = new MediaCodec.BufferInfo();
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.f69055b && this.f69054a == -1) {
                return;
            }
            int dequeueInputBuffer = this.f69057d.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                Log.d(f69053i, "drainBuffer encode input buffer not available");
            } else if (z) {
                Log.d(f69053i, "drainBuffer sending EOS to drainBufferEncoder");
                this.f69057d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
                return;
            } else {
                MediaCodec mediaCodec = this.f69057d;
                MediaCodec.BufferInfo bufferInfo = this.f69058e;
                mediaCodec.queueInputBuffer(dequeueInputBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, 0);
            }
            b(z, k);
        }
    }

    public final void b(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) != null) {
            return;
        }
        ByteBuffer[] outputBuffers = this.f69057d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f69057d.dequeueOutputBuffer(this.f69058e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(f69053i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f69057d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f69056c.c()) {
                        Log.e(f69053i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f69057d.getOutputFormat();
                    String str = f69053i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f69054a = this.f69056c.a(outputFormat);
                    this.f69055b = true;
                    c cVar = this.f69059f;
                    if (cVar != null) {
                        cVar.c(true);
                    }
                    if (this.f69060g) {
                        this.f69056c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = f69053i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f69058e.flags & 2) != 0) {
                            Log.d(f69053i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f69058e.size = 0;
                        }
                        if (this.f69058e.size != 0) {
                            if (this.f69056c.c()) {
                                byteBuffer.position(this.f69058e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f69058e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f69056c.g(this.f69054a, byteBuffer, this.f69058e);
                            } else {
                                Log.d(f69053i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f69057d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f69058e.flags & 4) != 0) {
                            if (z) {
                                if (this.f69060g) {
                                    this.f69056c.f();
                                }
                                c cVar2 = this.f69059f;
                                if (cVar2 != null) {
                                    cVar2.a(true);
                                    return;
                                }
                                return;
                            }
                            Log.e(f69053i, "reached end of stream unexpectedly");
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            } catch (IllegalStateException unused) {
                System.getProperty("ro.board.platform");
                String str3 = f69053i;
                Log.i(str3, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                return;
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                e eVar = this.f69056c;
                if (eVar != null && eVar.c()) {
                    this.f69057d.signalEndOfInputStream();
                } else {
                    c cVar = this.f69059f;
                    if (cVar != null) {
                        cVar.a(true);
                        return;
                    }
                    return;
                }
            }
            b(z, 10000);
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69061h * 1000 : invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f69057d.release();
            this.f69057d = null;
            this.f69056c = null;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f69059f = cVar;
        }
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            ByteBuffer byteBuffer2 = this.f69057d.getInputBuffers()[i2];
            if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
                byteBuffer2.position(0);
                byteBuffer2.put(byteBuffer);
                byteBuffer2.flip();
                MediaCodec.BufferInfo bufferInfo = this.f69058e;
                bufferInfo.offset = 0;
                bufferInfo.size = i3;
                bufferInfo.presentationTimeUs = j2 / 1000;
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f69057d.start();
            c cVar = this.f69059f;
            if (cVar != null) {
                cVar.d(true);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f69057d.stop();
            } catch (Exception unused) {
                Log.e(f69053i, "MediaCodec IllegalStateException Exception ");
            }
        }
    }

    public abstract void j();
}
