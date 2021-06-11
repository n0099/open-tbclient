package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f33055c;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f33056a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f33057b;

    public static a a() {
        if (f33055c == null) {
            synchronized (a.class) {
                if (f33055c == null) {
                    f33055c = new a();
                }
            }
        }
        return f33055c;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f33056a == null) {
            this.f33056a = new ArrayList();
        }
        this.f33056a.clear();
        this.f33056a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f33056a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f33057b == null) {
            this.f33057b = new ArrayList();
        }
        this.f33057b.clear();
        this.f33057b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f33056a;
        if (list != null) {
            list.clear();
        }
        this.f33056a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f33057b;
    }

    public void e() {
        List<AdTemplate> list = this.f33057b;
        if (list != null) {
            list.clear();
        }
        this.f33057b = null;
    }
}
