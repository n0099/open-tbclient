package d.f.b.a.d0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes10.dex */
public abstract class c implements Loader.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.h0.g f72757a;

    /* renamed from: b  reason: collision with root package name */
    public final int f72758b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f72759c;

    /* renamed from: d  reason: collision with root package name */
    public final int f72760d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f72761e;

    /* renamed from: f  reason: collision with root package name */
    public final long f72762f;

    /* renamed from: g  reason: collision with root package name */
    public final long f72763g;

    /* renamed from: h  reason: collision with root package name */
    public final d.f.b.a.h0.e f72764h;

    public c(d.f.b.a.h0.e eVar, d.f.b.a.h0.g gVar, int i2, Format format, int i3, Object obj, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar, Integer.valueOf(i2), format, Integer.valueOf(i3), obj, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.f.b.a.i0.a.e(eVar);
        this.f72764h = eVar;
        d.f.b.a.i0.a.e(gVar);
        this.f72757a = gVar;
        this.f72758b = i2;
        this.f72759c = format;
        this.f72760d = i3;
        this.f72761e = obj;
        this.f72762f = j;
        this.f72763g = j2;
    }

    public abstract long d();

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72763g - this.f72762f : invokeV.longValue;
    }
}
