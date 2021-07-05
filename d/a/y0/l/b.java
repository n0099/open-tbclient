package d.a.y0.l;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.misc.IMediaFormat;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
@RequiresApi(api = 16)
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71202a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f71203b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f71204c;

    /* renamed from: d  reason: collision with root package name */
    public int f71205d;

    /* renamed from: e  reason: collision with root package name */
    public a f71206e;

    /* renamed from: f  reason: collision with root package name */
    public a f71207f;

    /* renamed from: g  reason: collision with root package name */
    public a f71208g;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f71209a;

        /* renamed from: b  reason: collision with root package name */
        public int f71210b;

        /* renamed from: c  reason: collision with root package name */
        public long f71211c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f71212d;

        /* renamed from: e  reason: collision with root package name */
        public long f71213e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71209a = null;
            this.f71210b = -1;
            this.f71211c = 0L;
            this.f71212d = new MediaCodec.BufferInfo();
            this.f71213e = 0L;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71205d = 512000;
        this.f71206e = new a();
        this.f71207f = new a();
        this.f71208g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71203b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71206e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71204c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71203b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f71208g.f71211c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f71203b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f71207f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f71204c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f71203b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f71208g;
            aVar.f71212d.size = readSampleData;
            if (aVar == this.f71207f) {
                aVar.f71211c += aVar.f71213e;
            } else {
                aVar.f71211c = this.f71203b.getSampleTime();
            }
            a aVar2 = this.f71208g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f71212d;
            bufferInfo.presentationTimeUs = aVar2.f71211c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f71203b.getSampleFlags();
            return this.f71208g.f71212d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f71204c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f71204c = null;
            }
            this.f71203b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f71208g;
            if (aVar2 != null && (i3 = aVar2.f71210b) >= 0) {
                this.f71203b.unselectTrack(i3);
            }
            this.f71208g = aVar;
            if (aVar == null || (i2 = aVar.f71210b) < 0) {
                return;
            }
            this.f71203b.selectTrack(i2);
            a aVar3 = this.f71208g;
            aVar3.f71209a = this.f71203b.getTrackFormat(aVar3.f71210b);
            try {
                this.f71208g.f71209a.getLong("durationUs");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    public void m(String str, String str2) throws IOException {
        int integer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.f71202a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f71203b = mediaExtractor;
            mediaExtractor.setDataSource(this.f71202a);
            int trackCount = this.f71203b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f71203b.getTrackFormat(i2);
                String string = trackFormat.getString(IMediaFormat.KEY_MIME);
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f71207f;
                    aVar.f71209a = trackFormat;
                    aVar.f71210b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f71207f.f71209a.getInteger("max-input-size")) > 0) {
                        this.f71205d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f71206e;
                    aVar2.f71209a = trackFormat;
                    aVar2.f71210b = i2;
                }
            }
            if (this.f71204c == null) {
                this.f71204c = ByteBuffer.allocateDirect(this.f71205d);
            }
            MediaFormat mediaFormat = this.f71207f.f71209a;
            if (mediaFormat != null) {
                try {
                    this.f71207f.f71213e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    Log.e("VideoExtractor", "frameRate:" + e2.getMessage());
                    e2.printStackTrace();
                }
                if (this.f71207f.f71213e <= 0) {
                    k(g());
                    this.f71203b.readSampleData(this.f71204c, 0);
                    if (this.f71203b.getSampleFlags() == 1) {
                        this.f71203b.advance();
                    }
                    this.f71203b.readSampleData(this.f71204c, 0);
                    long sampleTime = this.f71203b.getSampleTime();
                    this.f71203b.advance();
                    this.f71207f.f71213e = Math.abs(this.f71203b.getSampleTime() - sampleTime);
                }
            }
            if (FileUtils.VIDEO_FILE_START.equals(str2)) {
                k(g());
            } else if ("audio/".equals(str2)) {
                k(b());
            }
        }
    }
}
