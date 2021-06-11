package com.kwad.sdk.contentalliance.tube.episode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f33842a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f33843b;

    public static b a() {
        if (f33843b == null) {
            synchronized (b.class) {
                if (f33843b == null) {
                    f33843b = new b();
                }
            }
        }
        return f33843b;
    }

    public void a(List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList=" + list);
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList size=" + list.size());
        if (f33842a == null) {
            f33842a = new ArrayList();
        }
        f33842a.clear();
        f33842a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f33842a;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "clearCacheData()");
        List<AdTemplate> list = f33842a;
        if (list != null) {
            list.clear();
        }
        f33842a = null;
    }
}
