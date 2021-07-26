package d.f.b.a.d0.u;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes8.dex */
public abstract class c implements Loader.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.f.b.a.h0.g f70314a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70315b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f70316c;

    /* renamed from: d  reason: collision with root package name */
    public final int f70317d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f70318e;

    /* renamed from: f  reason: collision with root package name */
    public final long f70319f;

    /* renamed from: g  reason: collision with root package name */
    public final long f70320g;

    /* renamed from: h  reason: collision with root package name */
    public final d.f.b.a.h0.e f70321h;

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
        this.f70321h = eVar;
        d.f.b.a.i0.a.e(gVar);
        this.f70314a = gVar;
        this.f70315b = i2;
        this.f70316c = format;
        this.f70317d = i3;
        this.f70318e = obj;
        this.f70319f = j;
        this.f70320g = j2;
    }

    public abstract long c();

    public final long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70320g - this.f70319f : invokeV.longValue;
    }
}
