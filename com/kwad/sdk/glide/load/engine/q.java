package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.load.engine.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class q<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<Data> f35596a;

    /* renamed from: b  reason: collision with root package name */
    public final Pools.Pool<List<Throwable>> f35597b;

    /* renamed from: c  reason: collision with root package name */
    public final List<? extends g<Data, ResourceType, Transcode>> f35598c;

    /* renamed from: d  reason: collision with root package name */
    public final String f35599d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f35596a = cls;
        this.f35597b = pool;
        this.f35598c = (List) com.kwad.sdk.glide.g.j.a(list);
        this.f35599d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i, int i2, g.a<ResourceType> aVar, List<Throwable> list) {
        int size = this.f35598c.size();
        s<Transcode> sVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                sVar = this.f35598c.get(i3).a(eVar, i, i2, eVar2, aVar);
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
        throw new GlideException(this.f35599d, new ArrayList(list));
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i, int i2, g.a<ResourceType> aVar) {
        List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.f35597b.acquire());
        try {
            return a(eVar, eVar2, i, i2, aVar, list);
        } finally {
            this.f35597b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f35598c.toArray()) + '}';
    }
}
