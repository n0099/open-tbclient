package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f5867a;
    private static volatile a b;

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f5867a == null) {
            f5867a = new ArrayList();
        }
        f5867a.clear();
        f5867a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f5867a;
    }

    public void c() {
        if (f5867a != null) {
            f5867a.clear();
        }
        f5867a = null;
    }
}
