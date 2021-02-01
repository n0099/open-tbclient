package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static volatile a c;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f8576a;

    /* renamed from: b  reason: collision with root package name */
    private List<AdTemplate> f8577b;

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f8576a == null) {
            this.f8576a = new ArrayList();
        }
        this.f8576a.clear();
        this.f8576a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f8576a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f8577b == null) {
            this.f8577b = new ArrayList();
        }
        this.f8577b.clear();
        this.f8577b.addAll(list);
    }

    public void c() {
        if (this.f8576a != null) {
            this.f8576a.clear();
        }
        this.f8576a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f8577b;
    }

    public void e() {
        if (this.f8577b != null) {
            this.f8577b.clear();
        }
        this.f8577b = null;
    }
}
