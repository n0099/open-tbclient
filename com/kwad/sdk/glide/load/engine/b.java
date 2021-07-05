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
public class b implements d.a<Object>, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.load.c> f37997a;

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f37998b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f37999c;

    /* renamed from: d  reason: collision with root package name */
    public int f38000d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f38001e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.kwad.sdk.glide.load.b.n<File, ?>> f38002f;

    /* renamed from: g  reason: collision with root package name */
    public int f38003g;

    /* renamed from: h  reason: collision with root package name */
    public volatile n.a<?> f38004h;

    /* renamed from: i  reason: collision with root package name */
    public File f38005i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(f<?> fVar, e.a aVar) {
        this(fVar.o(), fVar, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (f) objArr2[1], (e.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b(List<com.kwad.sdk.glide.load.c> list, f<?> fVar, e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, fVar, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38000d = -1;
        this.f37997a = list;
        this.f37998b = fVar;
        this.f37999c = aVar;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f38003g < this.f38002f.size() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(@NonNull Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            this.f37999c.a(this.f38001e, exc, this.f38004h.f37880c, DataSource.DATA_DISK_CACHE);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.f37999c.a(this.f38001e, obj, this.f38004h.f37880c, DataSource.DATA_DISK_CACHE, this.f38001e);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return invokeV.booleanValue;
        }
        while (true) {
            boolean z = false;
            if (this.f38002f != null && c()) {
                this.f38004h = null;
                while (!z && c()) {
                    List<com.kwad.sdk.glide.load.b.n<File, ?>> list = this.f38002f;
                    int i2 = this.f38003g;
                    this.f38003g = i2 + 1;
                    this.f38004h = list.get(i2).a(this.f38005i, this.f37998b.g(), this.f37998b.h(), this.f37998b.e());
                    if (this.f38004h != null && this.f37998b.a(this.f38004h.f37880c.a())) {
                        this.f38004h.f37880c.a(this.f37998b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f38000d + 1;
            this.f38000d = i3;
            if (i3 >= this.f37997a.size()) {
                return false;
            }
            com.kwad.sdk.glide.load.c cVar = this.f37997a.get(this.f38000d);
            File a2 = this.f37998b.b().a(new c(cVar, this.f37998b.f()));
            this.f38005i = a2;
            if (a2 != null) {
                this.f38001e = cVar;
                this.f38002f = this.f37998b.a(a2);
                this.f38003g = 0;
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public void b() {
        n.a<?> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f38004h) == null) {
            return;
        }
        aVar.f37880c.c();
    }
}
