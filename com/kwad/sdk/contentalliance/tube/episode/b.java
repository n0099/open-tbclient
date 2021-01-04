package com.kwad.sdk.contentalliance.tube.episode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f9250a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f9251b;

    private b() {
    }

    public static b a() {
        if (f9251b == null) {
            synchronized (b.class) {
                if (f9251b == null) {
                    f9251b = new b();
                }
            }
        }
        return f9251b;
    }

    public void a(List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList=" + list);
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList size=" + list.size());
        if (f9250a == null) {
            f9250a = new ArrayList();
        }
        f9250a.clear();
        f9250a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f9250a;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "clearCacheData()");
        if (f9250a != null) {
            f9250a.clear();
        }
        f9250a = null;
    }
}
