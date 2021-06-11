package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class h extends com.kwad.sdk.contentalliance.detail.photo.f.a<i> {

    /* renamed from: d  reason: collision with root package name */
    public long f32942d;

    /* renamed from: e  reason: collision with root package name */
    public i f32943e;

    /* renamed from: f  reason: collision with root package name */
    public long f32944f = 0;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Set<Long> f32945a = new HashSet();

        public static void a(long j) {
            f32945a.add(Long.valueOf(j));
        }

        public static void b(long j) {
            f32945a.remove(Long.valueOf(j));
        }

        public static boolean c(long j) {
            return f32945a.contains(Long.valueOf(j));
        }
    }

    private long p() {
        long s = com.kwad.sdk.core.response.b.c.s(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j);
        if (s < 0) {
            s = 0;
        }
        return a.c(this.f32942d) ? s + 1 : s;
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32942d = com.kwad.sdk.core.response.b.c.z(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j);
        this.f32944f = p();
        this.f32943e.a(a.c(this.f32942d) ? 2 : 1, this.f32944f);
        this.f32943e.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32943e.setOnClickListener(null);
        this.f32943e.b();
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32943e = f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public i g() {
        return new i(o());
    }

    public void h() {
        if (this.f32943e.a()) {
            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j, 2, 1);
            return;
        }
        this.f32943e.setLikeState(2);
        i iVar = this.f32943e;
        long j = this.f32944f + 1;
        this.f32944f = j;
        iVar.setLikeCount(j);
        a.a(this.f32942d);
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j, 1, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f32943e.a()) {
            this.f32943e.setLikeState(1);
            i iVar = this.f32943e;
            long j = this.f32944f - 1;
            this.f32944f = j;
            iVar.setLikeCount(j);
            a.b(this.f32942d);
            com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j);
            return;
        }
        this.f32943e.setLikeState(2);
        i iVar2 = this.f32943e;
        long j2 = this.f32944f + 1;
        this.f32944f = j2;
        iVar2.setLikeCount(j2);
        a.a(this.f32942d);
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j, 1, 2);
    }
}
