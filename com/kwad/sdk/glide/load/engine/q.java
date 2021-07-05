package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class q<Data, ResourceType, Transcode> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Class<Data> f38148a;

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f38149b;

    /* renamed from: c  reason: collision with root package name */
    public final List<? extends g<Data, ResourceType, Transcode>> f38150c;

    /* renamed from: d  reason: collision with root package name */
    public final String f38151d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, cls3, list, pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38148a = cls;
        this.f38149b = pool;
        this.f38150c = (List) com.kwad.sdk.glide.g.j.a(list);
        this.f38151d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i2, int i3, g.a<ResourceType> aVar, List<Throwable> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{eVar, eVar2, Integer.valueOf(i2), Integer.valueOf(i3), aVar, list})) == null) {
            int size = this.f38150c.size();
            s<Transcode> sVar = null;
            for (int i4 = 0; i4 < size; i4++) {
                try {
                    sVar = this.f38150c.get(i4).a(eVar, i2, i3, eVar2, aVar);
                } catch (GlideException e2) {
                    list.add(e2);
                }
                if (sVar != null) {
                    break;
                }
            }
            if (sVar != null) {
                return sVar;
            }
            throw new GlideException(this.f38151d, new ArrayList(list));
        }
        return (s) invokeCommon.objValue;
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i2, int i3, g.a<ResourceType> aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{eVar, eVar2, Integer.valueOf(i2), Integer.valueOf(i3), aVar})) == null) {
            List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.f38149b.acquire());
            try {
                return a(eVar, eVar2, i2, i3, aVar, list);
            } finally {
                this.f38149b.release(list);
            }
        }
        return (s) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "LoadPath{decodePaths=" + Arrays.toString(this.f38150c.toArray()) + '}';
        }
        return (String) invokeV.objValue;
    }
}
