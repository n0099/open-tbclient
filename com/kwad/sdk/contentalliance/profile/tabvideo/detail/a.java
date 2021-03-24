package com.kwad.sdk.contentalliance.profile.tabvideo.detail;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static List<AdTemplate> f32939a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f32940b;

    public static a a() {
        if (f32940b == null) {
            synchronized (a.class) {
                if (f32940b == null) {
                    f32940b = new a();
                }
            }
        }
        return f32940b;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (f32939a == null) {
            f32939a = new ArrayList();
        }
        f32939a.clear();
        f32939a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return f32939a;
    }

    public void c() {
        List<AdTemplate> list = f32939a;
        if (list != null) {
            list.clear();
        }
        f32939a = null;
    }
}
