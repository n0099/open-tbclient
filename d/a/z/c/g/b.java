package d.a.z.c.g;

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
/* loaded from: classes10.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final String f71572i = "b";
    public static long j = 0;
    public static int k = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f71573a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71574b;

    /* renamed from: c  reason: collision with root package name */
    public e f71575c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f71576d;

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec.BufferInfo f71577e;

    /* renamed from: f  reason: collision with root package name */
    public c f71578f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71579g;

    /* renamed from: h  reason: collision with root package name */
    public long f71580h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-772440345, "Ld/a/z/c/g/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-772440345, "Ld/a/z/c/g/b;");
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
        this.f71573a = -1;
        this.f71574b = false;
        this.f71580h = 0L;
        this.f71577e = new MediaCodec.BufferInfo();
    }

    public void a(boolean z, ByteBuffer byteBuffer, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), byteBuffer, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (this.f71574b && this.f71573a == -1) {
                return;
            }
            int dequeueInputBuffer = this.f71576d.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer < 0) {
                Log.d(f71572i, "drainBuffer encode input buffer not available");
            } else if (z) {
                Log.d(f71572i, "drainBuffer sending EOS to drainBufferEncoder");
                this.f71576d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            } else if (!g(dequeueInputBuffer, byteBuffer, i2, j2)) {
                return;
            } else {
                MediaCodec mediaCodec = this.f71576d;
                MediaCodec.BufferInfo bufferInfo = this.f71577e;
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
        ByteBuffer[] outputBuffers = this.f71576d.getOutputBuffers();
        while (true) {
            try {
                int dequeueOutputBuffer = this.f71576d.dequeueOutputBuffer(this.f71577e, i2);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                    Log.d(f71572i, "no output available, spinning to await EOS");
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f71576d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f71575c.c()) {
                        Log.e(f71572i, "format changed twice!!!!");
                        return;
                    }
                    MediaFormat outputFormat = this.f71576d.getOutputFormat();
                    String str = f71572i;
                    Log.d(str, "encoder output format changed: " + outputFormat);
                    this.f71573a = this.f71575c.a(outputFormat);
                    this.f71574b = true;
                    c cVar = this.f71578f;
                    if (cVar != null) {
                        cVar.c(true);
                    }
                    if (this.f71579g) {
                        this.f71575c.e();
                    }
                } else if (dequeueOutputBuffer < 0) {
                    String str2 = f71572i;
                    Log.w(str2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        if ((this.f71577e.flags & 2) != 0) {
                            Log.d(f71572i, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                            this.f71577e.size = 0;
                        }
                        if (this.f71577e.size != 0) {
                            if (this.f71575c.c()) {
                                byteBuffer.position(this.f71577e.offset);
                                MediaCodec.BufferInfo bufferInfo = this.f71577e;
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                j();
                                this.f71575c.g(this.f71573a, byteBuffer, this.f71577e);
                            } else {
                                Log.d(f71572i, "drainEncoder wait for mMuxer start !!!");
                            }
                        }
                        this.f71576d.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.f71577e.flags & 4) != 0) {
                            if (z) {
                                if (this.f71579g) {
                                    this.f71575c.f();
                                }
                                c cVar2 = this.f71578f;
                                if (cVar2 != null) {
                                    cVar2.a(true);
                                    return;
                                }
                                return;
                            }
                            Log.e(f71572i, "reached end of stream unexpectedly");
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            } catch (IllegalStateException unused) {
                System.getProperty("ro.board.platform");
                String str3 = f71572i;
                Log.i(str3, "mEncoder.dequeueOutputBuffer IllegalStateException error hard:" + System.getProperty("ro.board.platform"));
                return;
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                e eVar = this.f71575c;
                if (eVar != null && eVar.c()) {
                    this.f71576d.signalEndOfInputStream();
                } else {
                    c cVar = this.f71578f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71580h * 1000 : invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f71576d.release();
            this.f71576d = null;
            this.f71575c = null;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f71578f = cVar;
        }
    }

    public final boolean g(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), byteBuffer, Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            ByteBuffer byteBuffer2 = this.f71576d.getInputBuffers()[i2];
            if (byteBuffer2.capacity() >= byteBuffer.capacity()) {
                byteBuffer2.position(0);
                byteBuffer2.put(byteBuffer);
                byteBuffer2.flip();
                MediaCodec.BufferInfo bufferInfo = this.f71577e;
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
            this.f71576d.start();
            c cVar = this.f71578f;
            if (cVar != null) {
                cVar.d(true);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.f71576d.stop();
            } catch (Exception unused) {
                Log.e(f71572i, "MediaCodec IllegalStateException Exception ");
            }
        }
    }

    public abstract void j();
}
