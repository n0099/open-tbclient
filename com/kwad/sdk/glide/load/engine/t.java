package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class t implements d.a<Object>, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e.a f38157a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f38158b;

    /* renamed from: c  reason: collision with root package name */
    public int f38159c;

    /* renamed from: d  reason: collision with root package name */
    public int f38160d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f38161e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f38162f;

    /* renamed from: g  reason: collision with root package name */
    public int f38163g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f38164h;

    /* renamed from: i  reason: collision with root package name */
    public File f38165i;
    public u j;

    public t(f<?> fVar, e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38160d = -1;
        this.f38158b = fVar;
        this.f38157a = aVar;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.f38163g < this.f38162f.size() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            this.f38157a.a(this.j, exc, this.f38164h.f37880c, DataSource.RESOURCE_DISK_CACHE);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.f38157a.a(this.f38161e, obj, this.f38164h.f37880c, DataSource.RESOURCE_DISK_CACHE, this.j);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return invokeV.booleanValue;
        }
        List<com.kwad.sdk.glide.load.c> o = this.f38158b.o();
        boolean z = false;
        if (o.isEmpty()) {
            return false;
        }
        List<Class<?>> l = this.f38158b.l();
        if (l.isEmpty()) {
            if (File.class.equals(this.f38158b.j())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f38158b.k() + " to " + this.f38158b.j());
        }
        while (true) {
            if (this.f38162f != null && c()) {
                this.f38164h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f38162f;
                    int i2 = this.f38163g;
                    this.f38163g = i2 + 1;
                    this.f38164h = list.get(i2).a(this.f38165i, this.f38158b.g(), this.f38158b.h(), this.f38158b.e());
                    if (this.f38164h != null && this.f38158b.a(this.f38164h.f37880c.a())) {
                        this.f38164h.f37880c.a(this.f38158b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f38160d + 1;
            this.f38160d = i3;
            if (i3 >= l.size()) {
                int i4 = this.f38159c + 1;
                this.f38159c = i4;
                if (i4 >= o.size()) {
                    return false;
                }
                this.f38160d = 0;
            }
            com.kwad.sdk.glide.load.c cVar = o.get(this.f38159c);
            Class<?> cls = l.get(this.f38160d);
            this.j = new u(this.f38158b.i(), cVar, this.f38158b.f(), this.f38158b.g(), this.f38158b.h(), this.f38158b.c(cls), cls, this.f38158b.e());
            File a2 = this.f38158b.b().a(this.j);
            this.f38165i = a2;
            if (a2 != null) {
                this.f38161e = cVar;
                this.f38162f = this.f38158b.a(a2);
                this.f38163g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f38164h) == null) {
            return;
        }
        aVar.f37880c.c();
    }
}
