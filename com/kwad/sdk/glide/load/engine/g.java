package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.DecodePath;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<DataType> f35915a;

    /* renamed from: b  reason: collision with root package name */
    public final List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> f35916b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> f35917c;

    /* renamed from: d  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f35918d;

    /* renamed from: e  reason: collision with root package name */
    public final String f35919e;

    /* loaded from: classes6.dex */
    public interface a<ResourceType> {
        @NonNull
        s<ResourceType> a(@NonNull s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> list, com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f35915a = cls;
        this.f35916b = list;
        this.f35917c = eVar;
        this.f35918d = pool;
        this.f35919e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar2) {
        List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.f35918d.acquire());
        try {
            return a(eVar, i, i2, eVar2, list);
        } finally {
            this.f35918d.release(list);
        }
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar2, List<Throwable> list) {
        int size = this.f35916b.size();
        s<ResourceType> sVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.kwad.sdk.glide.load.f<DataType, ResourceType> fVar = this.f35916b.get(i3);
            try {
                if (fVar.a(eVar.a(), eVar2)) {
                    sVar = fVar.a(eVar.a(), i, i2, eVar2);
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
        throw new GlideException(this.f35919e, new ArrayList(list));
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar2, a<ResourceType> aVar) {
        return this.f35917c.a(aVar.a(a(eVar, i, i2, eVar2)), eVar2);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f35915a + ", decoders=" + this.f35916b + ", transcoder=" + this.f35917c + '}';
    }
}
