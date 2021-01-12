package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static volatile a c;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f8574a;

    /* renamed from: b  reason: collision with root package name */
    private List<AdTemplate> f8575b;

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
        if (this.f8574a == null) {
            this.f8574a = new ArrayList();
        }
        this.f8574a.clear();
        this.f8574a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f8574a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f8575b == null) {
            this.f8575b = new ArrayList();
        }
        this.f8575b.clear();
        this.f8575b.addAll(list);
    }

    public void c() {
        if (this.f8574a != null) {
            this.f8574a.clear();
        }
        this.f8574a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f8575b;
    }

    public void e() {
        if (this.f8575b != null) {
            this.f8575b.clear();
        }
        this.f8575b = null;
    }
}
