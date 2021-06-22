package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f33636a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f33637b;

    public static a a() {
        if (f33637b == null) {
            synchronized (a.class) {
                if (f33637b == null) {
                    f33637b = new a();
                }
            }
        }
        return f33637b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f33636a == null) {
            f33636a = new ArrayList();
        }
        f33636a.clear();
        f33636a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f33636a;
    }

    public void c() {
        List<AdTemplate> list = f33636a;
        if (list != null) {
            list.clear();
        }
        f33636a = null;
    }
}
