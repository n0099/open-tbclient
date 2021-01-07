package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f9108a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f9109b;

    private a() {
    }

    public static a a() {
        if (f9109b == null) {
            synchronized (a.class) {
                if (f9109b == null) {
                    f9109b = new a();
                }
            }
        }
        return f9109b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f9108a == null) {
            f9108a = new ArrayList();
        }
        f9108a.clear();
        f9108a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f9108a;
    }

    public void c() {
        if (f9108a != null) {
            f9108a.clear();
        }
        f9108a = null;
    }
}
