package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f32940a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f32941b;

    public static a a() {
        if (f32941b == null) {
            synchronized (a.class) {
                if (f32941b == null) {
                    f32941b = new a();
                }
            }
        }
        return f32941b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f32940a == null) {
            f32940a = new ArrayList();
        }
        f32940a.clear();
        f32940a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f32940a;
    }

    public void c() {
        List<AdTemplate> list = f32940a;
        if (list != null) {
            list.clear();
        }
        f32940a = null;
    }
}
