package d.f.b.a.d0.u;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes10.dex */
public abstract class l extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final int f72788i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(d.f.b.a.h0.e eVar, d.f.b.a.h0.g gVar, Format format, int i2, Object obj, long j, long j2, int i3) {
        super(eVar, gVar, 1, format, i2, obj, j, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.f.b.a.h0.e) objArr2[0], (d.f.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], ((Long) objArr2[6]).longValue(), ((Long) objArr2[7]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.f.b.a.i0.a.e(format);
        this.f72788i = i3;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72788i + 1 : invokeV.intValue;
    }

    public abstract boolean g();
}
