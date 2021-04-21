package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f32861c;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f32862a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f32863b;

    public static a a() {
        if (f32861c == null) {
            synchronized (a.class) {
                if (f32861c == null) {
                    f32861c = new a();
                }
            }
        }
        return f32861c;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32862a == null) {
            this.f32862a = new ArrayList();
        }
        this.f32862a.clear();
        this.f32862a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f32862a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32863b == null) {
            this.f32863b = new ArrayList();
        }
        this.f32863b.clear();
        this.f32863b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f32862a;
        if (list != null) {
            list.clear();
        }
        this.f32862a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f32863b;
    }

    public void e() {
        List<AdTemplate> list = this.f32863b;
        if (list != null) {
            list.clear();
        }
        this.f32863b = null;
    }
}
