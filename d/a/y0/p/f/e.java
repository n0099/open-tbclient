package d.a.y0.p.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.VideoEncoderCore;
import com.kwai.video.player.KsMediaMeta;
import d.a.y0.t.m;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Surface f71408a;

    /* renamed from: b  reason: collision with root package name */
    public d f71409b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec f71410c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec.BufferInfo f71411d;

    /* renamed from: e  reason: collision with root package name */
    public int f71412e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71413f;

    /* renamed from: g  reason: collision with root package name */
    public Bundle f71414g;

    /* renamed from: h  reason: collision with root package name */
    public long f71415h;

    /* renamed from: i  reason: collision with root package name */
    public int f71416i;

    @TargetApi(18)
    public e(int i2, int i3, int i4, boolean z, d dVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71414g = new Bundle();
        this.f71415h = 0L;
        this.f71416i = 10000;
        String str = "video/hevc";
        str = (!z || m.m("video/hevc") == null) ? "video/avc" : "video/avc";
        this.f71411d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i4);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 5);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        this.f71410c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f71408a = this.f71410c.createInputSurface();
        this.f71410c.start();
        this.f71414g.putInt("request-sync", 0);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f71410c.setParameters(this.f71414g);
        }
        this.f71412e = -1;
        this.f71413f = false;
        this.f71409b = dVar;
    }

    public Surface a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71408a : (Surface) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f71416i = i2;
        }
    }

    @RequiresApi(api = 18)
    public void c(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        if (z) {
            this.f71410c.signalEndOfInputStream();
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f71410c.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f71410c.dequeueOutputBuffer(this.f71411d, this.f71416i);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f71413f) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f71410c.getOutputFormat();
                    d.a.y0.t.c.c(VideoEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f71412e = this.f71409b.a(outputFormat);
                    if (!this.f71409b.c()) {
                        synchronized (this.f71409b) {
                            while (!this.f71409b.e()) {
                                try {
                                    this.f71409b.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f71413f = true;
                } else if (dequeueOutputBuffer < 0) {
                    d.a.y0.t.c.l(VideoEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f71411d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f71411d;
                    if (bufferInfo2.size != 0) {
                        if (!this.f71413f) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(bufferInfo2.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f71411d;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f71409b.b(this.f71412e, byteBuffer, this.f71411d);
                    }
                    this.f71410c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.f71415h >= 500) {
                        this.f71410c.setParameters(this.f71414g);
                        this.f71415h = System.currentTimeMillis();
                    }
                    if ((this.f71411d.flags & 4) != 0) {
                        if (z) {
                            return;
                        }
                        d.a.y0.t.c.l(VideoEncoderCore.TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec mediaCodec = this.f71410c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f71410c.release();
                this.f71410c = null;
            }
            d dVar = this.f71409b;
            if (dVar != null) {
                try {
                    dVar.d();
                } catch (IllegalStateException e2) {
                    d.a.y0.t.c.g(e2);
                }
                this.f71409b = null;
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
            }
        }
    }
}
