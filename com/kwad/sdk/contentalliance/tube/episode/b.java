package com.kwad.sdk.contentalliance.tube.episode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f8953a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f8954b;

    private b() {
    }

    public static b a() {
        if (f8954b == null) {
            synchronized (b.class) {
                if (f8954b == null) {
                    f8954b = new b();
                }
            }
        }
        return f8954b;
    }

    public void a(List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList=" + list);
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "addCacheData() templateList size=" + list.size());
        if (f8953a == null) {
            f8953a = new ArrayList();
        }
        f8953a.clear();
        f8953a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f8953a;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("TubeEpisodeCacheManager", "clearCacheData()");
        if (f8953a != null) {
            f8953a.clear();
        }
        f8953a = null;
    }
}
