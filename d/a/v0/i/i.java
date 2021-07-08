package d.a.v0.i;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class i implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f67926a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f67927b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f67928c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f67929d;

    /* renamed from: e  reason: collision with root package name */
    public MediaExtractor f67930e;

    /* renamed from: f  reason: collision with root package name */
    public MediaFormat f67931f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer[] f67932g;

    /* renamed from: h  reason: collision with root package name */
    public ByteBuffer[] f67933h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f67934i;
    public volatile boolean j;
    public long k;
    public volatile boolean l;
    public j m;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073 A[EDGE_INSN: B:46:0x0073->B:28:0x0073 ?: BREAK  , SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i(String str) throws Exception {
        int i2;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = -1L;
        this.f67930e = new MediaExtractor();
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f67930e = mediaExtractor;
            mediaExtractor.setDataSource(str);
        } catch (IOException unused) {
            try {
                Thread.sleep(25L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    MediaExtractor mediaExtractor2 = new MediaExtractor();
                    this.f67930e = mediaExtractor2;
                    mediaExtractor2.setDataSource(str);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                    MediaExtractor mediaExtractor3 = new MediaExtractor();
                    this.f67930e = mediaExtractor3;
                    mediaExtractor3.setDataSource(str);
                    i2 = 0;
                    while (true) {
                        if (i2 >= this.f67930e.getTrackCount()) {
                        }
                        i2++;
                    }
                    mediaFormat = this.f67931f;
                    if (mediaFormat == null) {
                    }
                }
            } catch (IOException unused2) {
                Thread.sleep(25L);
                MediaExtractor mediaExtractor32 = new MediaExtractor();
                this.f67930e = mediaExtractor32;
                mediaExtractor32.setDataSource(str);
                i2 = 0;
                while (true) {
                    if (i2 >= this.f67930e.getTrackCount()) {
                    }
                    i2++;
                }
                mediaFormat = this.f67931f;
                if (mediaFormat == null) {
                }
            }
        }
        i2 = 0;
        while (true) {
            if (i2 >= this.f67930e.getTrackCount()) {
                break;
            }
            MediaFormat trackFormat = this.f67930e.getTrackFormat(i2);
            String string = trackFormat.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith("audio/")) {
                this.f67930e.selectTrack(i2);
                this.f67931f = trackFormat;
                break;
            }
            i2++;
        }
        mediaFormat = this.f67931f;
        if (mediaFormat == null) {
            throw new NullPointerException("format is null");
        }
        String string2 = mediaFormat.getString("mime");
        this.f67926a = this.f67931f.getLong("durationUs");
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string2);
        this.f67929d = createDecoderByType;
        createDecoderByType.configure(this.f67931f, (Surface) null, (MediaCrypto) null, 0);
        this.f67929d.start();
        this.f67932g = this.f67929d.getInputBuffers();
        this.f67933h = this.f67929d.getOutputBuffers();
        this.f67928c = new MediaCodec.BufferInfo();
    }

    @Override // d.a.v0.i.a
    public int a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (this.f67931f.containsKey("bit-width") ? this.f67931f.getInteger("bit-width") : 16) / 8;
        }
        return invokeV.intValue;
    }

    @Override // d.a.v0.i.a
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f67931f.containsKey("sample-rate")) {
                return this.f67931f.getInteger("sample-rate");
            }
            throw new IOException("Not a valid audio file");
        }
        return invokeV.intValue;
    }

    @Override // d.a.v0.i.a
    public boolean c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            i();
            int dequeueOutputBuffer = this.f67929d.dequeueOutputBuffer(this.f67928c, 10000L);
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.f67929d.getOutputFormat();
                        this.f67931f = outputFormat;
                        j jVar = this.m;
                        if (jVar != null) {
                            jVar.a(outputFormat);
                        }
                    } else if (dequeueOutputBuffer == -3) {
                        this.f67933h = this.f67929d.getOutputBuffers();
                    } else {
                        str = "decodeChunk,res=" + dequeueOutputBuffer;
                    }
                    return false;
                }
                str = "decodeChunk:INFO_TRY_AGAIN_LATER";
                d.a.v0.t.c.j("VideoMuxer", str);
                return false;
            }
            MediaCodec.BufferInfo bufferInfo = this.f67928c;
            if ((bufferInfo.flags & 2) != 0) {
                this.f67929d.releaseOutputBuffer(dequeueOutputBuffer, false);
                return false;
            }
            int i2 = bufferInfo.size;
            if (i2 - bufferInfo.offset < 0) {
                ByteBuffer byteBuffer = this.f67933h[dequeueOutputBuffer];
                byte[] bArr = this.f67934i;
                if (bArr == null || bArr.length != i2) {
                    this.f67934i = new byte[this.f67928c.size];
                }
                byteBuffer.get(this.f67934i);
                byteBuffer.clear();
                this.f67929d.releaseOutputBuffer(dequeueOutputBuffer, false);
            } else {
                j(dequeueOutputBuffer);
            }
            if ((this.f67928c.flags & 4) != 0) {
                long j = this.k;
                if (j <= 0) {
                    j = this.f67926a;
                }
                this.f67927b = j;
                this.j = true;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.v0.i.a
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.f67929d.stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                this.f67929d.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f67929d = null;
            try {
                this.f67930e.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.f67930e = null;
        }
    }

    @Override // d.a.v0.i.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = false;
            this.j = false;
            this.f67928c.flags = 0;
        }
    }

    @Override // d.a.v0.i.a
    public int e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f67931f.containsKey("channel-count")) {
                return this.f67931f.getInteger("channel-count");
            }
            throw new IOException("Not a valid audio file");
        }
        return invokeV.intValue;
    }

    @Override // d.a.v0.i.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // d.a.v0.i.a
    public byte[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67934i : (byte[]) invokeV.objValue;
    }

    @Override // d.a.v0.i.a
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67927b : invokeV.longValue;
    }

    @Override // d.a.v0.i.a
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f67926a : invokeV.longValue;
    }

    @Override // d.a.v0.i.a
    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.k = j;
        }
    }

    public final void i() {
        int dequeueInputBuffer;
        long sampleTime;
        int sampleFlags;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.l || (dequeueInputBuffer = this.f67929d.dequeueInputBuffer(10000L)) < 0) {
            return;
        }
        int readSampleData = this.f67930e.readSampleData(this.f67932g[dequeueInputBuffer], 0);
        if (readSampleData < 0) {
            this.l = true;
            d.a.v0.t.c.j("VideoMuxer", "extractor to end, audioEndTimeUs" + this.k);
            sampleTime = 0L;
            readSampleData = 0;
        } else {
            sampleTime = this.f67930e.getSampleTime();
        }
        long j = this.k;
        if (j > 0 && sampleTime > j) {
            d.a.v0.t.c.j("VideoMuxer", "extractor audioEndTimeUs:" + this.k + ",presentationTimeUs:" + sampleTime);
            this.l = true;
        }
        boolean z = this.l;
        MediaCodec mediaCodec = this.f67929d;
        if (z) {
            i2 = 0;
            sampleTime = 0;
            sampleFlags = 4;
        } else {
            sampleFlags = this.f67930e.getSampleFlags();
            i2 = readSampleData;
        }
        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i2, sampleTime, sampleFlags);
        if (this.l) {
            return;
        }
        this.f67930e.advance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r1 != (r2.size - r2.offset)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            ByteBuffer byteBuffer = this.f67933h[i2];
            byte[] bArr = this.f67934i;
            if (bArr != null) {
                int length = bArr.length;
                MediaCodec.BufferInfo bufferInfo = this.f67928c;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f67928c;
            this.f67934i = new byte[bufferInfo2.size - bufferInfo2.offset];
            MediaCodec.BufferInfo bufferInfo3 = this.f67928c;
            if (bufferInfo3.size > 0) {
                this.f67927b = bufferInfo3.presentationTimeUs;
            }
            byteBuffer.position(this.f67928c.offset);
            byteBuffer.get(this.f67934i);
            byteBuffer.clear();
            this.f67929d.releaseOutputBuffer(i2, false);
        }
    }

    public void k(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jVar) == null) {
            this.m = jVar;
        }
    }

    @Override // d.a.v0.i.a
    public void seek(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            d();
            this.f67930e.seekTo(j, 2);
            this.f67927b = j;
            this.f67928c = new MediaCodec.BufferInfo();
            this.f67929d.flush();
        }
    }
}
