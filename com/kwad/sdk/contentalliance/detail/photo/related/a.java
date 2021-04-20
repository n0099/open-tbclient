package com.kwad.sdk.contentalliance.detail.photo.related;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f32766c;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f32767a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f32768b;

    public static a a() {
        if (f32766c == null) {
            synchronized (a.class) {
                if (f32766c == null) {
                    f32766c = new a();
                }
            }
        }
        return f32766c;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32767a == null) {
            this.f32767a = new ArrayList();
        }
        this.f32767a.clear();
        this.f32767a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f32767a;
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f32768b == null) {
            this.f32768b = new ArrayList();
        }
        this.f32768b.clear();
        this.f32768b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f32767a;
        if (list != null) {
            list.clear();
        }
        this.f32767a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f32768b;
    }

    public void e() {
        List<AdTemplate> list = this.f32768b;
        if (list != null) {
            list.clear();
        }
        this.f32768b = null;
    }
}
