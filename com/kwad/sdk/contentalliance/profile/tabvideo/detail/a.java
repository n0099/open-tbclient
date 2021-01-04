package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f9107a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f9108b;

    private a() {
    }

    public static a a() {
        if (f9108b == null) {
            synchronized (a.class) {
                if (f9108b == null) {
                    f9108b = new a();
                }
            }
        }
        return f9108b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f9107a == null) {
            f9107a = new ArrayList();
        }
        f9107a.clear();
        f9107a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f9107a;
    }

    public void c() {
        if (f9107a != null) {
            f9107a.clear();
        }
        f9107a = null;
    }
}
