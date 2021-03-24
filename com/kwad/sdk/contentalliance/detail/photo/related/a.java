package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f32476c;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f32477a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f32478b;

    public static a a() {
        if (f32476c == null) {
            synchronized (a.class) {
                if (f32476c == null) {
                    f32476c = new a();
                }
            }
        }
        return f32476c;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32477a == null) {
            this.f32477a = new ArrayList();
        }
        this.f32477a.clear();
        this.f32477a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f32477a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32478b == null) {
            this.f32478b = new ArrayList();
        }
        this.f32478b.clear();
        this.f32478b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f32477a;
        if (list != null) {
            list.clear();
        }
        this.f32477a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f32478b;
    }

    public void e() {
        List<AdTemplate> list = this.f32478b;
        if (list != null) {
            list.clear();
        }
        this.f32478b = null;
    }
}
