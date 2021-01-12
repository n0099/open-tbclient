package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f10214a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> f10215b;
    private final com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> c;
    private final Pools.Pool<List<Throwable>> d;
    private final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a<ResourceType> {
        @NonNull
        s<ResourceType> a(@NonNull s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.kwad.sdk.glide.load.f<DataType, ResourceType>> list, com.kwad.sdk.glide.load.resource.e.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f10214a = cls;
        this.f10215b = list;
        this.c = eVar;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + PerfFrameTrackUIUtil.SEPERATOR_ARROR + cls2.getSimpleName() + PerfFrameTrackUIUtil.SEPERATOR_ARROR + cls3.getSimpleName() + "}";
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar2) {
        List<Throwable> list = (List) com.kwad.sdk.glide.g.j.a(this.d.acquire());
        try {
            return a(eVar, i, i2, eVar2, list);
        } finally {
            this.d.release(list);
        }
    }

    @NonNull
    private s<ResourceType> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar2, List<Throwable> list) {
        s<ResourceType> sVar = null;
        int size = this.f10215b.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.kwad.sdk.glide.load.f<DataType, ResourceType> fVar = this.f10215b.get(i3);
            try {
                sVar = fVar.a(eVar.a(), eVar2) ? fVar.a(eVar.a(), i, i2, eVar2) : sVar;
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + fVar, e);
                }
                list.add(e);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar == null) {
            throw new GlideException(this.e, new ArrayList(list));
        }
        return sVar;
    }

    public s<Transcode> a(com.kwad.sdk.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar2, a<ResourceType> aVar) {
        return this.c.a(aVar.a(a(eVar, i, i2, eVar2)), eVar2);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f10214a + ", decoders=" + this.f10215b + ", transcoder=" + this.c + '}';
    }
}
