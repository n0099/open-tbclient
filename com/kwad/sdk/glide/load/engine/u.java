package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public final class u implements com.kwad.sdk.glide.load.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.g.g<Class<?>, byte[]> f38166b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38167c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f38168d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f38169e;

    /* renamed from: f  reason: collision with root package name */
    public final int f38170f;

    /* renamed from: g  reason: collision with root package name */
    public final int f38171g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f38172h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f38173i;
    public final com.kwad.sdk.glide.load.h<?> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-469692817, "Lcom/kwad/sdk/glide/load/engine/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-469692817, "Lcom/kwad/sdk/glide/load/engine/u;");
                return;
            }
        }
        f38166b = new com.kwad.sdk.glide.g.g<>(50L);
    }

    public u(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.c cVar2, int i2, int i3, com.kwad.sdk.glide.load.h<?> hVar, Class<?> cls, com.kwad.sdk.glide.load.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar, cVar2, Integer.valueOf(i2), Integer.valueOf(i3), hVar, cls, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38167c = bVar;
        this.f38168d = cVar;
        this.f38169e = cVar2;
        this.f38170f = i2;
        this.f38171g = i3;
        this.j = hVar;
        this.f38172h = cls;
        this.f38173i = eVar;
    }

    private byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            byte[] b2 = f38166b.b(this.f38172h);
            if (b2 == null) {
                byte[] bytes = this.f38172h.getName().getBytes(com.kwad.sdk.glide.load.c.f37921a);
                f38166b.b(this.f38172h, bytes);
                return bytes;
            }
            return b2;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageDigest) == null) {
            byte[] bArr = (byte[]) this.f38167c.b(8, byte[].class);
            ByteBuffer.wrap(bArr).putInt(this.f38170f).putInt(this.f38171g).array();
            this.f38169e.a(messageDigest);
            this.f38168d.a(messageDigest);
            messageDigest.update(bArr);
            com.kwad.sdk.glide.load.h<?> hVar = this.j;
            if (hVar != null) {
                hVar.a(messageDigest);
            }
            this.f38173i.a(messageDigest);
            messageDigest.update(a());
            this.f38167c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof u) {
                u uVar = (u) obj;
                return this.f38171g == uVar.f38171g && this.f38170f == uVar.f38170f && com.kwad.sdk.glide.g.k.a(this.j, uVar.j) && this.f38172h.equals(uVar.f38172h) && this.f38168d.equals(uVar.f38168d) && this.f38169e.equals(uVar.f38169e) && this.f38173i.equals(uVar.f38173i);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int hashCode = (((((this.f38168d.hashCode() * 31) + this.f38169e.hashCode()) * 31) + this.f38170f) * 31) + this.f38171g;
            com.kwad.sdk.glide.load.h<?> hVar = this.j;
            if (hVar != null) {
                hashCode = (hashCode * 31) + hVar.hashCode();
            }
            return (((hashCode * 31) + this.f38172h.hashCode()) * 31) + this.f38173i.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "ResourceCacheKey{sourceKey=" + this.f38168d + ", signature=" + this.f38169e + ", width=" + this.f38170f + ", height=" + this.f38171g + ", decodedResourceClass=" + this.f38172h + ", transformation='" + this.j + "', options=" + this.f38173i + '}';
        }
        return (String) invokeV.objValue;
    }
}
