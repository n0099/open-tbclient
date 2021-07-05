package d.f.b.a.c0.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import d.f.b.a.c0.c;
import d.f.b.a.i0.k;
import d.f.b.a.i0.l;
import d.f.b.a.i0.s;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public final class a implements d.f.b.a.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final l f72618a;

    /* renamed from: b  reason: collision with root package name */
    public final k f72619b;

    /* renamed from: c  reason: collision with root package name */
    public s f72620c;

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
        this.f72618a = new l();
        this.f72619b = new k();
    }

    @Override // d.f.b.a.c0.a
    public Metadata a(c cVar) throws MetadataDecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            s sVar = this.f72620c;
            if (sVar == null || cVar.j != sVar.e()) {
                s sVar2 = new s(cVar.f73653h);
                this.f72620c = sVar2;
                sVar2.a(cVar.f73653h - cVar.j);
            }
            ByteBuffer byteBuffer = cVar.f73652g;
            byte[] array = byteBuffer.array();
            int limit = byteBuffer.limit();
            this.f72618a.H(array, limit);
            this.f72619b.k(array, limit);
            this.f72619b.n(39);
            long g2 = (this.f72619b.g(1) << 32) | this.f72619b.g(32);
            this.f72619b.n(20);
            int g3 = this.f72619b.g(12);
            int g4 = this.f72619b.g(8);
            Metadata.Entry entry = null;
            this.f72618a.K(14);
            if (g4 == 0) {
                entry = new SpliceNullCommand();
            } else if (g4 == 255) {
                entry = PrivateCommand.parseFromSection(this.f72618a, g3, g2);
            } else if (g4 == 4) {
                entry = SpliceScheduleCommand.parseFromSection(this.f72618a);
            } else if (g4 == 5) {
                entry = SpliceInsertCommand.parseFromSection(this.f72618a, g2, this.f72620c);
            } else if (g4 == 6) {
                entry = TimeSignalCommand.parseFromSection(this.f72618a, g2, this.f72620c);
            }
            return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
        }
        return (Metadata) invokeL.objValue;
    }
}
