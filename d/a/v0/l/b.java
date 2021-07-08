package d.a.v0.l;

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
    public String f68005a;

    /* renamed from: b  reason: collision with root package name */
    public MediaExtractor f68006b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f68007c;

    /* renamed from: d  reason: collision with root package name */
    public int f68008d;

    /* renamed from: e  reason: collision with root package name */
    public a f68009e;

    /* renamed from: f  reason: collision with root package name */
    public a f68010f;

    /* renamed from: g  reason: collision with root package name */
    public a f68011g;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public MediaFormat f68012a;

        /* renamed from: b  reason: collision with root package name */
        public int f68013b;

        /* renamed from: c  reason: collision with root package name */
        public long f68014c;

        /* renamed from: d  reason: collision with root package name */
        public MediaCodec.BufferInfo f68015d;

        /* renamed from: e  reason: collision with root package name */
        public long f68016e;

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
            this.f68012a = null;
            this.f68013b = -1;
            this.f68014c = 0L;
            this.f68015d = new MediaCodec.BufferInfo();
            this.f68016e = 0L;
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
        this.f68008d = 512000;
        this.f68009e = new a();
        this.f68010f = new a();
        this.f68011g = new a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68006b.advance() : invokeV.booleanValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68009e : (a) invokeV.objValue;
    }

    public ByteBuffer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68007c : (ByteBuffer) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68006b.getSampleTrackIndex() : invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68011g.f68014c : invokeV.longValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68006b.getSampleTrackIndex() : invokeV.intValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68010f : (a) invokeV.objValue;
    }

    public MediaCodec.BufferInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i(this.f68007c, 0) : (MediaCodec.BufferInfo) invokeV.objValue;
    }

    public MediaCodec.BufferInfo i(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, i2)) == null) {
            int readSampleData = this.f68006b.readSampleData(byteBuffer, i2);
            if (readSampleData < 0) {
                return null;
            }
            a aVar = this.f68011g;
            aVar.f68015d.size = readSampleData;
            if (aVar == this.f68010f) {
                aVar.f68014c += aVar.f68016e;
            } else {
                aVar.f68014c = this.f68006b.getSampleTime();
            }
            a aVar2 = this.f68011g;
            MediaCodec.BufferInfo bufferInfo = aVar2.f68015d;
            bufferInfo.presentationTimeUs = aVar2.f68014c;
            bufferInfo.offset = 0;
            bufferInfo.flags = this.f68006b.getSampleFlags();
            return this.f68011g.f68015d;
        }
        return (MediaCodec.BufferInfo) invokeLI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ByteBuffer byteBuffer = this.f68007c;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.f68007c = null;
            }
            this.f68006b.release();
        }
    }

    public void k(a aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            a aVar2 = this.f68011g;
            if (aVar2 != null && (i3 = aVar2.f68013b) >= 0) {
                this.f68006b.unselectTrack(i3);
            }
            this.f68011g = aVar;
            if (aVar == null || (i2 = aVar.f68013b) < 0) {
                return;
            }
            this.f68006b.selectTrack(i2);
            a aVar3 = this.f68011g;
            aVar3.f68012a = this.f68006b.getTrackFormat(aVar3.f68013b);
            try {
                this.f68011g.f68012a.getLong("durationUs");
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
            this.f68005a = str;
            FileUtils.VIDEO_FILE_START.equals(str2);
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f68006b = mediaExtractor;
            mediaExtractor.setDataSource(this.f68005a);
            int trackCount = this.f68006b.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.f68006b.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                if (string.startsWith(FileUtils.VIDEO_FILE_START)) {
                    a aVar = this.f68010f;
                    aVar.f68012a = trackFormat;
                    aVar.f68013b = i2;
                    if (trackFormat.containsKey("max-input-size") && (integer = this.f68010f.f68012a.getInteger("max-input-size")) > 0) {
                        this.f68008d = integer;
                    }
                } else if (string.startsWith("audio/")) {
                    a aVar2 = this.f68009e;
                    aVar2.f68012a = trackFormat;
                    aVar2.f68013b = i2;
                }
            }
            if (this.f68007c == null) {
                this.f68007c = ByteBuffer.allocateDirect(this.f68008d);
            }
            MediaFormat mediaFormat = this.f68010f.f68012a;
            if (mediaFormat != null) {
                try {
                    this.f68010f.f68016e = 1000000 / mediaFormat.getInteger("frame-rate");
                } catch (Exception e2) {
                    Log.e("VideoExtractor", "frameRate:" + e2.getMessage());
                    e2.printStackTrace();
                }
                if (this.f68010f.f68016e <= 0) {
                    k(g());
                    this.f68006b.readSampleData(this.f68007c, 0);
                    if (this.f68006b.getSampleFlags() == 1) {
                        this.f68006b.advance();
                    }
                    this.f68006b.readSampleData(this.f68007c, 0);
                    long sampleTime = this.f68006b.getSampleTime();
                    this.f68006b.advance();
                    this.f68010f.f68016e = Math.abs(this.f68006b.getSampleTime() - sampleTime);
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
