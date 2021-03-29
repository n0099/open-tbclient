package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f32477c;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f32478a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f32479b;

    public static a a() {
        if (f32477c == null) {
            synchronized (a.class) {
                if (f32477c == null) {
                    f32477c = new a();
                }
            }
        }
        return f32477c;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32478a == null) {
            this.f32478a = new ArrayList();
        }
        this.f32478a.clear();
        this.f32478a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f32478a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32479b == null) {
            this.f32479b = new ArrayList();
        }
        this.f32479b.clear();
        this.f32479b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f32478a;
        if (list != null) {
            list.clear();
        }
        this.f32478a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f32479b;
    }

    public void e() {
        List<AdTemplate> list = this.f32479b;
        if (list != null) {
            list.clear();
        }
        this.f32479b = null;
    }
}
