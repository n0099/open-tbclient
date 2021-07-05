package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.SourceGenerator;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.e;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class w implements d.a<Object>, e, e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f<?> f38176a;

    /* renamed from: b  reason: collision with root package name */
    public final e.a f38177b;

    /* renamed from: c  reason: collision with root package name */
    public int f38178c;

    /* renamed from: d  reason: collision with root package name */
    public b f38179d;

    /* renamed from: e  reason: collision with root package name */
    public Object f38180e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n.a<?> f38181f;

    /* renamed from: g  reason: collision with root package name */
    public c f38182g;

    public w(f<?> fVar, e.a aVar) {
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
        this.f38176a = fVar;
        this.f38177b = aVar;
    }

    private void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, obj) == null) {
            long a2 = com.kwad.sdk.glide.g.f.a();
            try {
                com.kwad.sdk.glide.load.a<X> a3 = this.f38176a.a((f<?>) obj);
                d dVar = new d(a3, obj, this.f38176a.e());
                this.f38182g = new c(this.f38181f.f37878a, this.f38176a.f());
                this.f38176a.b().a(this.f38182g, dVar);
                if (Log.isLoggable(SourceGenerator.TAG, 2)) {
                    Log.v(SourceGenerator.TAG, "Finished encoding source to cache, key: " + this.f38182g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.kwad.sdk.glide.g.f.a(a2));
                }
                this.f38181f.f37880c.b();
                this.f38179d = new b(Collections.singletonList(this.f38181f.f37878a), this.f38176a, this);
            } catch (Throwable th) {
                this.f38181f.f37880c.b();
                throw th;
            }
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f38178c < this.f38176a.n().size() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, cVar, exc, dVar, dataSource) == null) {
            this.f38177b.a(cVar, exc, dVar, this.f38181f.f37880c.d());
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, obj, dVar, dataSource, cVar2) == null) {
            this.f38177b.a(cVar, obj, dVar, this.f38181f.f37880c.d(), cVar);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            this.f38177b.a(this.f38182g, exc, this.f38181f.f37880c, this.f38181f.f37880c.d());
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            h c2 = this.f38176a.c();
            if (obj == null || !c2.a(this.f38181f.f37880c.d())) {
                this.f38177b.a(this.f38181f.f37878a, obj, this.f38181f.f37880c, this.f38181f.f37880c.d(), this.f38182g);
                return;
            }
            this.f38180e = obj;
            this.f38177b.c();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object obj = this.f38180e;
            if (obj != null) {
                this.f38180e = null;
                b(obj);
            }
            b bVar = this.f38179d;
            if (bVar == null || !bVar.a()) {
                this.f38179d = null;
                this.f38181f = null;
                boolean z = false;
                while (!z && d()) {
                    List<n.a<?>> n = this.f38176a.n();
                    int i2 = this.f38178c;
                    this.f38178c = i2 + 1;
                    this.f38181f = n.get(i2);
                    if (this.f38181f != null && (this.f38176a.c().a(this.f38181f.f37880c.d()) || this.f38176a.a(this.f38181f.f37880c.a()))) {
                        this.f38181f.f37880c.a(this.f38176a.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f38181f) == null) {
            return;
        }
        aVar.f37880c.c();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            throw new UnsupportedOperationException();
        }
    }
}
