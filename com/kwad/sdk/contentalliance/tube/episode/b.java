package com.kwad.sdk.contentalliance.tube.episode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f8951a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f8952b;

    private b() {
    }

    public static b a() {
        if (f8952b == null) {
            synchronized (b.class) {
                if (f8952b == null) {
                    f8952b = new b();
                }
            }
        }
        return f8952b;
    }

    public void a(List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList=" + list);
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList size=" + list.size());
        if (f8951a == null) {
            f8951a = new ArrayList();
        }
        f8951a.clear();
        f8951a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f8951a;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "clearCacheData()");
        if (f8951a != null) {
            f8951a.clear();
        }
        f8951a = null;
    }
}
