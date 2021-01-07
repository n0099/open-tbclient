package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private static volatile a c;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f8874a;

    /* renamed from: b  reason: collision with root package name */
    private List<AdTemplate> f8875b;

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
        if (this.f8874a == null) {
            this.f8874a = new ArrayList();
        }
        this.f8874a.clear();
        this.f8874a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f8874a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f8875b == null) {
            this.f8875b = new ArrayList();
        }
        this.f8875b.clear();
        this.f8875b.addAll(list);
    }

    public void c() {
        if (this.f8874a != null) {
            this.f8874a.clear();
        }
        this.f8874a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f8875b;
    }

    public void e() {
        if (this.f8875b != null) {
            this.f8875b.clear();
        }
        this.f8875b = null;
    }
}
