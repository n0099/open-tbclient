package d.a.w0.l;

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
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
@RequiresApi(api = 16)
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f68683a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f68684b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f68685c;

    /* renamed from: d  reason: collision with root package name */
    public int f68686d;

    /* renamed from: e  reason: collision with root package name */
    public a f68687e;

    /* renamed from: f  reason: collision with root package name */
    public a f68688f;

    /* renamed from: g  reason: collision with root package name */
    public a f68689g;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f68690a;

        /* renamed from: b  reason: collision with root package name */
        public int f68691b;

        /* renamed from: c  reason: collision with root package name */
        public long f68692c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f68693d;

        /* renamed from: e  reason: collision with root package name */
        public long f68694e;

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
            this.f68690a = null;
            this.f68691b = -1;
            this.f68692c = 0L;
            this.f68693d = new MediaCodec.BufferInfo();
            this.f68694e = 0L;
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
        this.f68686d = 512000;
        this.f68687e = new a();
        this.f68688f = new a();
        this.f68689g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68684b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68687e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68685c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68684b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68689g.f68692c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68684b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68688f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f68685c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f68684b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f68689g;
            aVar.f68693d.size = readSampleData;
            if (aVar == this.f68688f) {
                aVar.f68692c += aVar.f68694e;
            } else {
                aVar.f68692c = this.f68684b.getSampleTime();
            }
            a aVar2 = this.f68689g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f68693d;
            bufferInfo.presentationTimeUs = aVar2.f68692c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f68684b.getSampleFlags();
            return this.f68689g.f68693d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f68685c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f68685c = null;
            }
            this.f68684b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f68689g;
            if (aVar2 != null && (i3 = aVar2.f68691b) >= 0) {
                this.f68684b.unselectTrack(i3);
            }
            this.f68689g = aVar;
            if (aVar == null || (i2 = aVar.f68691b) < 0) {
                return;
            }
            this.f68684b.selectTrack(i2);
            a aVar3 = this.f68689g;
            aVar3.f68690a = this.f68684b.getTrackFormat(aVar3.f68691b);
            try {
                this.f68689g.f68690a.getLong("durationUs");
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
            this.f68683a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f68684b = mediaExtractor;
            mediaExtractor.setDataSource(this.f68683a);
            int trackCount = this.f68684b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f68684b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f68688f;
                    aVar.f68690a = trackFormat;
                    aVar.f68691b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f68688f.f68690a.getInteger("max-input-size")) > 0) {
                        this.f68686d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f68687e;
                    aVar2.f68690a = trackFormat;
                    aVar2.f68691b = i2;
                }
            }
            if (this.f68685c == null) {
                this.f68685c = ByteBuffer.allocateDirect(this.f68686d);
            }
            MediaFormat mediaFormat = this.f68688f.f68690a;
            if (mediaFormat != null) {
                try {
                    this.f68688f.f68694e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    Log.e("VideoExtractor", "frameRate:" + e2.getMessage());
                    e2.printStackTrace();
                }
                if (this.f68688f.f68694e <= 0) {
                    k(g());
                    this.f68684b.readSampleData(this.f68685c, 0);
                    if (this.f68684b.getSampleFlags() == 1) {
                        this.f68684b.advance();
                    }
                    this.f68684b.readSampleData(this.f68685c, 0);
                    long sampleTime = this.f68684b.getSampleTime();
                    this.f68684b.advance();
                    this.f68688f.f68694e = Math.abs(this.f68684b.getSampleTime() - sampleTime);
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
