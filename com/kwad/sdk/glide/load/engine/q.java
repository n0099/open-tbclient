package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.kwad.sdk.glide.load.engine.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class q<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f10246a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f10247b;
    private final List<? extends g<Data, ResourceType, Transcode>> c;
    private final String d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f10246a = cls;
        this.f10247b = pool;
        this.c = (List) com.kwad.sdk.glide.g.j.a(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + PerfFrameTrackUIUtil.SEPERATOR_ARROR + cls2.getSimpleName() + PerfFrameTrackUIUtil.SEPERATOR_ARROR + cls3.getSimpleName() + "}";
    }

    private s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i, int i2, g.a<ResourceType> aVar, List<Throwable> list) {
        s<Transcode> sVar;
        s<Transcode> sVar2 = null;
        int size = this.c.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                sVar = sVar2;
                break;
            }
            try {
                sVar = this.c.get(i3).a(eVar, i, i2, eVar2, aVar);
            } catch (GlideException e) {
                list.add(e);
                sVar = sVar2;
            }
            if (sVar != null) {
                break;
            }
            i3++;
            sVar2 = sVar;
        }
        if (sVar == null) {
            throw new GlideException(this.d, new ArrayList(list));
        }
        return sVar;
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<Data> eVar, @NonNull com.kwad.sdk.glide.load.e eVar2, int i, int i2, g.a<ResourceType> aVar) {
        List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.f10247b.acquire());
        try {
            return a(eVar, eVar2, i, i2, aVar, list);
        } finally {
            this.f10247b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }
}
