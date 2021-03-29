package com.kwad.sdk.contentalliance.tube.episode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f33229a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f33230b;

    public static b a() {
        if (f33230b == null) {
            synchronized (b.class) {
                if (f33230b == null) {
                    f33230b = new b();
                }
            }
        }
        return f33230b;
    }

    public void a(List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList=" + list);
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList size=" + list.size());
        if (f33229a == null) {
            f33229a = new ArrayList();
        }
        f33229a.clear();
        f33229a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f33229a;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "clearCacheData()");
        List<AdTemplate> list = f33229a;
        if (list != null) {
            list.clear();
        }
        f33229a = null;
    }
}
