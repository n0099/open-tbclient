package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f8810a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f8811b;

    private a() {
    }

    public static a a() {
        if (f8811b == null) {
            synchronized (a.class) {
                if (f8811b == null) {
                    f8811b = new a();
                }
            }
        }
        return f8811b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f8810a == null) {
            f8810a = new ArrayList();
        }
        f8810a.clear();
        f8810a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f8810a;
    }

    public void c() {
        if (f8810a != null) {
            f8810a.clear();
        }
        f8810a = null;
    }
}
