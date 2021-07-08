package d.f.b.a.a0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.r.h;
import d.f.b.a.i0.l;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public final class g extends h {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final byte[] p;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942669334, "Ld/f/b/a/a0/r/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942669334, "Ld/f/b/a/a0/r/g;");
                return;
            }
        }
        o = v.q("Opus");
        p = new byte[]{79, 112, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 115, 72, Constants.SHORT_PING_CMD_TYPE, 97, 100};
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean n(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            int a2 = lVar.a();
            byte[] bArr = p;
            if (a2 < bArr.length) {
                return false;
            }
            byte[] bArr2 = new byte[bArr.length];
            lVar.g(bArr2, 0, bArr.length);
            return Arrays.equals(bArr2, p);
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.r.h
    public long e(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) ? b(l(lVar.f70489a)) : invokeL.longValue;
    }

    @Override // d.f.b.a.a0.r.h
    public boolean h(l lVar, long j, h.b bVar) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{lVar, Long.valueOf(j), bVar})) == null) {
            if (!this.n) {
                byte[] copyOf = Arrays.copyOf(lVar.f70489a, lVar.d());
                int i2 = copyOf[9] & 255;
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(copyOf);
                m(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
                m(arrayList, 3840);
                bVar.f69467a = Format.createAudioSampleFormat(null, "audio/opus", null, -1, -1, i2, MediaEncodeParams.AUDIO_SAMPLE_RATE, arrayList, null, 0, null);
                this.n = true;
                return true;
            }
            boolean z = lVar.i() == o;
            lVar.J(0);
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.a0.r.h
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.j(z);
            if (z) {
                this.n = false;
            }
        }
    }

    public final long l(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            int i2 = bArr[0] & 255;
            int i3 = i2 & 3;
            int i4 = 2;
            if (i3 == 0) {
                i4 = 1;
            } else if (i3 != 1 && i3 != 2) {
                i4 = bArr[1] & 63;
            }
            int i5 = i2 >> 3;
            int i6 = i5 & 3;
            return i4 * (i5 >= 16 ? 2500 << i6 : i5 >= 12 ? 10000 << (i6 & 1) : i6 == 3 ? 60000 : 10000 << i6);
        }
        return invokeL.longValue;
    }

    public final void m(List<byte[]> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, list, i2) == null) {
            list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i2 * 1000000000) / 48000).array());
        }
    }
}
