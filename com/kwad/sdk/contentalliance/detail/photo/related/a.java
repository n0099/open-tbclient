package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static volatile a c;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f5724a;
    private List<AdTemplate> b;

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
        if (this.f5724a == null) {
            this.f5724a = new ArrayList();
        }
        this.f5724a.clear();
        this.f5724a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f5724a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
        this.b.addAll(list);
    }

    public void c() {
        if (this.f5724a != null) {
            this.f5724a.clear();
        }
        this.f5724a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.b;
    }

    public void e() {
        if (this.b != null) {
            this.b.clear();
        }
        this.b = null;
    }
}
