package d.f.b.a.a0.n;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import d.f.b.a.a0.m;
import d.f.b.a.i0.j;
import d.f.b.a.i0.l;
/* loaded from: classes10.dex */
public final class d extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final l f72144b;

    /* renamed from: c  reason: collision with root package name */
    public final l f72145c;

    /* renamed from: d  reason: collision with root package name */
    public int f72146d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72147e;

    /* renamed from: f  reason: collision with root package name */
    public int f72148f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(m mVar) {
        super(mVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((m) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72144b = new l(j.f73366a);
        this.f72145c = new l(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(l lVar) throws TagPayloadReader.UnsupportedFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            int x = lVar.x();
            int i2 = (x >> 4) & 15;
            int i3 = x & 15;
            if (i3 == 7) {
                this.f72148f = i2;
                return i2 != 5;
            }
            throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i3);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(l lVar, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, j) == null) {
            int x = lVar.x();
            long j2 = j + (lVar.j() * 1000);
            if (x == 0 && !this.f72147e) {
                l lVar2 = new l(new byte[lVar.a()]);
                lVar.g(lVar2.f73386a, 0, lVar.a());
                d.f.b.a.j0.a b2 = d.f.b.a.j0.a.b(lVar2);
                this.f72146d = b2.f73442b;
                this.f32722a.b(Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, b2.f73443c, b2.f73444d, -1.0f, b2.f73441a, -1, b2.f73445e, null));
                this.f72147e = true;
            } else if (x == 1 && this.f72147e) {
                byte[] bArr = this.f72145c.f73386a;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i2 = 4 - this.f72146d;
                int i3 = 0;
                while (lVar.a() > 0) {
                    lVar.g(this.f72145c.f73386a, i2, this.f72146d);
                    this.f72145c.J(0);
                    int B = this.f72145c.B();
                    this.f72144b.J(0);
                    this.f32722a.a(this.f72144b, 4);
                    this.f32722a.a(lVar, B);
                    i3 = i3 + 4 + B;
                }
                this.f32722a.c(j2, this.f72148f == 1 ? 1 : 0, i3, 0, null);
            }
        }
    }
}
