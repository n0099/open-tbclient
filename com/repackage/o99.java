package com.repackage;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.webrtc.HardwareVideoEncoder;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class o99 implements i99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaCodec a;
    public MediaFormat b;
    public ByteBuffer[] c;
    public ByteBuffer[] d;
    public BufferedOutputStream e;
    public boolean f;
    public ByteBuffer g;
    public byte[] h;
    public int i;
    public int j;
    public int k;
    public int l;
    public q99 m;

    public o99(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = i2;
        this.l = g(i);
        MediaCodecInfo h = h("audio/mp4a-latm");
        if (h == null) {
            q99 q99Var = this.m;
            if (q99Var != null) {
                q99Var.onExceptionThrown("not suport aac encoder");
                return;
            }
            return;
        }
        this.a = MediaCodec.createByCodecName(h.getName());
        MediaFormat mediaFormat = new MediaFormat();
        this.b = mediaFormat;
        mediaFormat.setString("mime", "audio/mp4a-latm");
        this.b.setInteger("aac-profile", 2);
        this.b.setInteger("sample-rate", i);
        this.b.setInteger("channel-count", i2);
        this.b.setInteger("bitrate", EncoderParams.AUDIO_BIT_RATE);
        this.b.setInteger("max-input-size", 8192);
        this.b.setInteger(HardwareVideoEncoder.KEY_BITRATE_MODE, 16);
        this.a.configure(this.b, (Surface) null, (MediaCrypto) null, 1);
        this.a.start();
        this.c = this.a.getInputBuffers();
        this.d = this.a.getOutputBuffers();
        this.g = ByteBuffer.allocateDirect(8192);
        this.h = new byte[4096];
    }

    @Override // com.repackage.i99
    public void a() throws IOException {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            va9.j("VideoMuxer: ", "----set BUFFER_FLAG_END_OF_STREAM to encoder-----");
            do {
                dequeueInputBuffer = this.a.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    va9.j("VideoMuxer: ", "----MediaCodec.BUFFER_FLAG_END_OF_STREAM-----");
                    this.a.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                }
                i();
            } while (dequeueInputBuffer < 0);
            while (!this.f) {
                i();
            }
        }
    }

    @Override // com.repackage.i99
    public void b(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e = new BufferedOutputStream(new FileOutputStream(str));
        }
    }

    @Override // com.repackage.i99
    public int c(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2)) == null) {
            if (this.g.capacity() < i2) {
                this.g = ByteBuffer.allocateDirect(i2);
            }
            this.g.clear();
            this.g.put(bArr, i, i2);
            this.g.flip();
            while (this.g.hasRemaining()) {
                int dequeueInputBuffer = this.a.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer = this.c[dequeueInputBuffer];
                    int min = Math.min(byteBuffer.capacity(), this.g.remaining());
                    if (min != this.h.length) {
                        this.h = new byte[min];
                    }
                    this.g.get(this.h, 0, min);
                    byteBuffer.clear();
                    byteBuffer.put(this.h);
                    this.a.queueInputBuffer(dequeueInputBuffer, 0, min, 0L, 0);
                    this.i += min;
                }
                i();
            }
            return 0;
        }
        return invokeLII.intValue;
    }

    @Override // com.repackage.i99
    public void d(q99 q99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, q99Var) == null) {
            this.m = q99Var;
        }
    }

    public final void e(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, bArr, i) == null) {
            int i2 = this.l;
            int i3 = this.k;
            bArr[0] = -1;
            bArr[1] = -7;
            bArr[2] = (byte) (64 + (i2 << 2) + (i3 >> 2));
            bArr[3] = (byte) (((i3 & 3) << 6) + (i >> 11));
            bArr[4] = (byte) ((i & RevenueServerConst.GetUserCouponStoreResponse) >> 3);
            bArr[5] = (byte) (((i & 7) << 5) + 31);
            bArr[6] = -4;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.a.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.a.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.a = null;
            try {
                this.e.flush();
                this.e.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            switch (i) {
                case 7350:
                    return 12;
                case 8000:
                    return 11;
                case 11025:
                    return 10;
                case com.kuaishou.weapon.un.w0.X3 /* 12000 */:
                    return 9;
                case 16000:
                    return 8;
                case 22050:
                    return 7;
                case 24000:
                    return 6;
                case 32000:
                    return 5;
                case 48000:
                    return 3;
                case 64000:
                    return 2;
                case 88200:
                    return 1;
                case 96000:
                    return 0;
                default:
                    return 4;
            }
        }
        return invokeI.intValue;
    }

    public final MediaCodecInfo h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public final void i() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 10000L);
            if (dequeueOutputBuffer == -2) {
                this.b = this.a.getOutputFormat();
            } else if (dequeueOutputBuffer == -3) {
                this.d = this.a.getOutputBuffers();
            } else if (dequeueOutputBuffer == -1) {
                va9.j("VideoMuxer", "writeOutput INFO_TRY_AGAIN_LATER");
            } else if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    this.a.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return;
                }
                int i = bufferInfo.size;
                if (i > 0) {
                    int i2 = i + 7;
                    ByteBuffer byteBuffer = this.d[dequeueOutputBuffer];
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + i);
                    byte[] bArr = new byte[i2];
                    e(bArr, i2);
                    byteBuffer.get(bArr, 7, i);
                    byteBuffer.position(bufferInfo.offset);
                    this.e.write(bArr, 0, i2);
                    this.j += bufferInfo.size;
                    byteBuffer.clear();
                }
                this.a.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((bufferInfo.flags & 4) != 0) {
                    this.f = true;
                    try {
                        f();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (this.m != null) {
                        va9.j("VideoMuxer: ", "----Encode done-----,numBytesSubmitted:" + this.i + ",numBytesDequeued:" + this.j);
                        this.m.onFinishedWriting(true);
                    }
                }
            }
        }
    }
}
