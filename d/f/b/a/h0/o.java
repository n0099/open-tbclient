package d.f.b.a.h0;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.Loader;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class o<T> implements Loader.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final g f70437a;

    /* renamed from: b  reason: collision with root package name */
    public final int f70438b;

    /* renamed from: c  reason: collision with root package name */
    public final e f70439c;

    /* renamed from: d  reason: collision with root package name */
    public final a<? extends T> f70440d;

    /* renamed from: e  reason: collision with root package name */
    public volatile T f70441e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f70442f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f70443g;

    /* loaded from: classes8.dex */
    public interface a<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(e eVar, Uri uri, int i2, a<? extends T> aVar) {
        this(eVar, new g(uri, 1), i2, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, uri, Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((e) objArr2[0], (g) objArr2[1], ((Integer) objArr2[2]).intValue(), (a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f fVar = new f(this.f70439c, this.f70437a);
            try {
                fVar.o();
                this.f70441e = this.f70440d.a(this.f70439c.getUri(), fVar);
            } finally {
                this.f70443g = fVar.g();
                v.i(fVar);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70442f : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f70442f = true;
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70443g : invokeV.longValue;
    }

    public final T e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70441e : (T) invokeV.objValue;
    }

    public o(e eVar, g gVar, int i2, a<? extends T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, gVar, Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70439c = eVar;
        this.f70437a = gVar;
        this.f70438b = i2;
        this.f70440d = aVar;
    }
}
