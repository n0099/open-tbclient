package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f33538a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f33539b;

    public static a a() {
        if (f33539b == null) {
            synchronized (a.class) {
                if (f33539b == null) {
                    f33539b = new a();
                }
            }
        }
        return f33539b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f33538a == null) {
            f33538a = new ArrayList();
        }
        f33538a.clear();
        f33538a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f33538a;
    }

    public void c() {
        List<AdTemplate> list = f33538a;
        if (list != null) {
            list.clear();
        }
        f33538a = null;
    }
}
