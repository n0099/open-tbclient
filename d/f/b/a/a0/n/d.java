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
/* loaded from: classes8.dex */
public final class d extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final l f69247b;

    /* renamed from: c  reason: collision with root package name */
    public final l f69248c;

    /* renamed from: d  reason: collision with root package name */
    public int f69249d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69250e;

    /* renamed from: f  reason: collision with root package name */
    public int f69251f;

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
        this.f69247b = new l(j.f70469a);
        this.f69248c = new l(4);
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
                this.f69251f = i2;
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
            if (x == 0 && !this.f69250e) {
                l lVar2 = new l(new byte[lVar.a()]);
                lVar.g(lVar2.f70489a, 0, lVar.a());
                d.f.b.a.j0.a b2 = d.f.b.a.j0.a.b(lVar2);
                this.f69249d = b2.f70545b;
                this.f32832a.b(Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, b2.f70546c, b2.f70547d, -1.0f, b2.f70544a, -1, b2.f70548e, null));
                this.f69250e = true;
            } else if (x == 1 && this.f69250e) {
                byte[] bArr = this.f69248c.f70489a;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i2 = 4 - this.f69249d;
                int i3 = 0;
                while (lVar.a() > 0) {
                    lVar.g(this.f69248c.f70489a, i2, this.f69249d);
                    this.f69248c.J(0);
                    int B = this.f69248c.B();
                    this.f69247b.J(0);
                    this.f32832a.a(this.f69247b, 4);
                    this.f32832a.a(lVar, B);
                    i3 = i3 + 4 + B;
                }
                this.f32832a.c(j2, this.f69251f == 1 ? 1 : 0, i3, 0, null);
            }
        }
    }
}
