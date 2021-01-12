package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<AdTemplate> f8808a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f8809b;

    private a() {
    }

    public static a a() {
        if (f8809b == null) {
            synchronized (a.class) {
                if (f8809b == null) {
                    f8809b = new a();
                }
            }
        }
        return f8809b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f8808a == null) {
            f8808a = new ArrayList();
        }
        f8808a.clear();
        f8808a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f8808a;
    }

    public void c() {
        if (f8808a != null) {
            f8808a.clear();
        }
        f8808a = null;
    }
}
