package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.DecodePath;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g<DataType, ResourceType, Transcode> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Class<DataType> f38080a;

    /* renamed from: b  reason: collision with root package name */
    public final List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> f38081b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> f38082c;

    /* renamed from: d  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f38083d;

    /* renamed from: e  reason: collision with root package name */
    public final String f38084e;

    /* loaded from: classes7.dex */
    public interface a<ResourceType> {
        @NonNull
        s<ResourceType> a(@NonNull s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> list, com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, cls3, list, eVar, pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38080a = cls;
        this.f38081b = list;
        this.f38082c = eVar;
        this.f38083d = pool;
        this.f38084e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), eVar2})) == null) {
            List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.f38083d.acquire());
            try {
                return a(eVar, i2, i3, eVar2, list);
            } finally {
                this.f38083d.release(list);
            }
        }
        return (s) invokeCommon.objValue;
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar2, List<Throwable> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), eVar2, list})) == null) {
            int size = this.f38081b.size();
            s<ResourceType> sVar = null;
            for (int i4 = 0; i4 < size; i4++) {
                com.kwad.sdk.glide.load.f<DataType, ResourceType> fVar = this.f38081b.get(i4);
                try {
                    if (fVar.a(eVar.a(), eVar2)) {
                        sVar = fVar.a(eVar.a(), i2, i3, eVar2);
                    }
                } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                    if (Log.isLoggable(DecodePath.TAG, 2)) {
                        Log.v(DecodePath.TAG, "Failed to decode data for " + fVar, e2);
                    }
                    list.add(e2);
                }
                if (sVar != null) {
                    break;
                }
            }
            if (sVar != null) {
                return sVar;
            }
            throw new GlideException(this.f38084e, new ArrayList(list));
        }
        return (s) invokeCommon.objValue;
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar2, a<ResourceType> aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{eVar, Integer.valueOf(i2), Integer.valueOf(i3), eVar2, aVar})) == null) ? this.f38082c.a(aVar.a(a(eVar, i2, i3, eVar2)), eVar2) : (s) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "DecodePath{ dataClass=" + this.f38080a + ", decoders=" + this.f38081b + ", transcoder=" + this.f38082c + '}';
        }
        return (String) invokeV.objValue;
    }
}
