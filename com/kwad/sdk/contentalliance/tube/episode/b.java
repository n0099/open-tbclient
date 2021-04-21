package com.kwad.sdk.contentalliance.tube.episode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f33613a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f33614b;

    public static b a() {
        if (f33614b == null) {
            synchronized (b.class) {
                if (f33614b == null) {
                    f33614b = new b();
                }
            }
        }
        return f33614b;
    }

    public void a(List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList=" + list);
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList size=" + list.size());
        if (f33613a == null) {
            f33613a = new ArrayList();
        }
        f33613a.clear();
        f33613a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f33613a;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "clearCacheData()");
        List<AdTemplate> list = f33613a;
        if (list != null) {
            list.clear();
        }
        f33613a = null;
    }
}
