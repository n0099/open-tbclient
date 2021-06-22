package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f33153c;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f33154a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f33155b;

    public static a a() {
        if (f33153c == null) {
            synchronized (a.class) {
                if (f33153c == null) {
                    f33153c = new a();
                }
            }
        }
        return f33153c;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f33154a == null) {
            this.f33154a = new ArrayList();
        }
        this.f33154a.clear();
        this.f33154a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f33154a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f33155b == null) {
            this.f33155b = new ArrayList();
        }
        this.f33155b.clear();
        this.f33155b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f33154a;
        if (list != null) {
            list.clear();
        }
        this.f33154a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f33155b;
    }

    public void e() {
        List<AdTemplate> list = this.f33155b;
        if (list != null) {
            list.clear();
        }
        this.f33155b = null;
    }
}
