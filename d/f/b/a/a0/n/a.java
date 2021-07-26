package d.f.b.a.a0.n;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import d.f.b.a.a0.m;
import d.f.b.a.i0.l;
import java.util.Collections;
/* loaded from: classes8.dex */
public final class a extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f69687e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69688b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69689c;

    /* renamed from: d  reason: collision with root package name */
    public int f69690d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942549984, "Ld/f/b/a/a0/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942549984, "Ld/f/b/a/a0/n/a;");
                return;
            }
        }
        f69687e = new int[]{5512, 11025, 22050, 44100};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(m mVar) {
        super(mVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((m) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            if (!this.f69688b) {
                int x = lVar.x();
                int i2 = (x >> 4) & 15;
                this.f69690d = i2;
                if (i2 == 2) {
                    this.f33021a.b(Format.createAudioSampleFormat(null, "audio/mpeg", null, -1, -1, 1, f69687e[(x >> 2) & 3], null, null, 0, null));
                    this.f69689c = true;
                } else if (i2 == 7 || i2 == 8) {
                    this.f33021a.b(Format.createAudioSampleFormat(null, this.f69690d == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", null, -1, -1, 1, 8000, (x & 1) == 1 ? 2 : 3, null, null, 0, null));
                    this.f69689c = true;
                } else if (i2 != 10) {
                    throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f69690d);
                }
                this.f69688b = true;
            } else {
                lVar.K(1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(l lVar, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, j) == null) {
            if (this.f69690d == 2) {
                int a2 = lVar.a();
                this.f33021a.a(lVar, a2);
                this.f33021a.c(j, 1, a2, 0, null);
                return;
            }
            int x = lVar.x();
            if (x == 0 && !this.f69689c) {
                int a3 = lVar.a();
                byte[] bArr = new byte[a3];
                lVar.g(bArr, 0, a3);
                Pair<Integer, Integer> i2 = d.f.b.a.i0.c.i(bArr);
                this.f33021a.b(Format.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((Integer) i2.second).intValue(), ((Integer) i2.first).intValue(), Collections.singletonList(bArr), null, 0, null));
                this.f69689c = true;
            } else if (this.f69690d != 10 || x == 1) {
                int a4 = lVar.a();
                this.f33021a.a(lVar, a4);
                this.f33021a.c(j, 1, a4, 0, null);
            }
        }
    }
}
