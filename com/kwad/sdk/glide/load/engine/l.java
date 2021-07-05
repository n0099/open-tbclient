package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.glide.load.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Object f38131b;

    /* renamed from: c  reason: collision with root package name */
    public final int f38132c;

    /* renamed from: d  reason: collision with root package name */
    public final int f38133d;

    /* renamed from: e  reason: collision with root package name */
    public final Class<?> f38134e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f38135f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.c f38136g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> f38137h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f38138i;
    public int j;

    public l(Object obj, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.kwad.sdk.glide.load.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, cVar, Integer.valueOf(i2), Integer.valueOf(i3), map, cls, cls2, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38131b = com.kwad.sdk.glide.g.j.a(obj);
        this.f38136g = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar, "Signature must not be null");
        this.f38132c = i2;
        this.f38133d = i3;
        this.f38137h = (Map) com.kwad.sdk.glide.g.j.a(map);
        this.f38134e = (Class) com.kwad.sdk.glide.g.j.a(cls, "Resource class must not be null");
        this.f38135f = (Class) com.kwad.sdk.glide.g.j.a(cls2, "Transcode class must not be null");
        this.f38138i = (com.kwad.sdk.glide.load.e) com.kwad.sdk.glide.g.j.a(eVar);
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageDigest) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof l) {
                l lVar = (l) obj;
                return this.f38131b.equals(lVar.f38131b) && this.f38136g.equals(lVar.f38136g) && this.f38133d == lVar.f38133d && this.f38132c == lVar.f38132c && this.f38137h.equals(lVar.f38137h) && this.f38134e.equals(lVar.f38134e) && this.f38135f.equals(lVar.f38135f) && this.f38138i.equals(lVar.f38138i);
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
            if (this.j == 0) {
                int hashCode = this.f38131b.hashCode();
                this.j = hashCode;
                int hashCode2 = (hashCode * 31) + this.f38136g.hashCode();
                this.j = hashCode2;
                int i2 = (hashCode2 * 31) + this.f38132c;
                this.j = i2;
                int i3 = (i2 * 31) + this.f38133d;
                this.j = i3;
                int hashCode3 = (i3 * 31) + this.f38137h.hashCode();
                this.j = hashCode3;
                int hashCode4 = (hashCode3 * 31) + this.f38134e.hashCode();
                this.j = hashCode4;
                int hashCode5 = (hashCode4 * 31) + this.f38135f.hashCode();
                this.j = hashCode5;
                this.j = (hashCode5 * 31) + this.f38138i.hashCode();
            }
            return this.j;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "EngineKey{model=" + this.f38131b + ", width=" + this.f38132c + ", height=" + this.f38133d + ", resourceClass=" + this.f38134e + ", transcodeClass=" + this.f38135f + ", signature=" + this.f38136g + ", hashCode=" + this.j + ", transformations=" + this.f38137h + ", options=" + this.f38138i + '}';
        }
        return (String) invokeV.objValue;
    }
}
