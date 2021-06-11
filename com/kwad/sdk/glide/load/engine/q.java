package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.load.engine.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class q<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<Data> f36287a;

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f36288b;

    /* renamed from: c  reason: collision with root package name */
    public final List<? extends g<Data, ResourceType, Transcode>> f36289c;

    /* renamed from: d  reason: collision with root package name */
    public final String f36290d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f36287a = cls;
        this.f36288b = pool;
        this.f36289c = (List) com.kwad.sdk.glide.g.j.a(list);
        this.f36290d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i2, int i3, g.a<ResourceType> aVar, List<Throwable> list) {
        int size = this.f36289c.size();
        s<Transcode> sVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                sVar = this.f36289c.get(i4).a(eVar, i2, i3, eVar2, aVar);
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
        throw new GlideException(this.f36290d, new ArrayList(list));
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i2, int i3, g.a<ResourceType> aVar) {
        List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.f36288b.acquire());
        try {
            return a(eVar, eVar2, i2, i3, aVar, list);
        } finally {
            this.f36288b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f36289c.toArray()) + '}';
    }
}
