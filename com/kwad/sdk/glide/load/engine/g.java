package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.DecodePath;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<DataType> f36219a;

    /* renamed from: b  reason: collision with root package name */
    public final List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> f36220b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> f36221c;

    /* renamed from: d  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f36222d;

    /* renamed from: e  reason: collision with root package name */
    public final String f36223e;

    /* loaded from: classes7.dex */
    public interface a<ResourceType> {
        @NonNull
        s<ResourceType> a(@NonNull s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> list, com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f36219a = cls;
        this.f36220b = list;
        this.f36221c = eVar;
        this.f36222d = pool;
        this.f36223e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar2) {
        List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.f36222d.acquire());
        try {
            return a(eVar, i2, i3, eVar2, list);
        } finally {
            this.f36222d.release(list);
        }
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar2, List<Throwable> list) {
        int size = this.f36220b.size();
        s<ResourceType> sVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            com.kwad.sdk.glide.load.f<DataType, ResourceType> fVar = this.f36220b.get(i4);
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
        throw new GlideException(this.f36223e, new ArrayList(list));
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar2, a<ResourceType> aVar) {
        return this.f36221c.a(aVar.a(a(eVar, i2, i3, eVar2)), eVar2);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f36219a + ", decoders=" + this.f36220b + ", transcoder=" + this.f36221c + '}';
    }
}
