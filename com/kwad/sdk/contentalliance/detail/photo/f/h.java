package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class h extends com.kwad.sdk.contentalliance.detail.photo.f.a<i> {

    /* renamed from: d  reason: collision with root package name */
    public long f32754d;

    /* renamed from: e  reason: collision with root package name */
    public i f32755e;

    /* renamed from: f  reason: collision with root package name */
    public long f32756f = 0;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Set<Long> f32757a = new HashSet();

        public static void a(long j) {
            f32757a.add(Long.valueOf(j));
        }

        public static void b(long j) {
            f32757a.remove(Long.valueOf(j));
        }

        public static boolean c(long j) {
            return f32757a.contains(Long.valueOf(j));
        }
    }

    private long p() {
        long s = com.kwad.sdk.core.response.b.c.s(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j);
        if (s < 0) {
            s = 0;
        }
        return a.c(this.f32754d) ? s + 1 : s;
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32754d = com.kwad.sdk.core.response.b.c.z(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j);
        this.f32756f = p();
        this.f32755e.a(a.c(this.f32754d) ? 2 : 1, this.f32756f);
        this.f32755e.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32755e.setOnClickListener(null);
        this.f32755e.b();
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32755e = f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public i g() {
        return new i(o());
    }

    public void h() {
        if (this.f32755e.a()) {
            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j, 2, 1);
            return;
        }
        this.f32755e.setLikeState(2);
        i iVar = this.f32755e;
        long j = this.f32756f + 1;
        this.f32756f = j;
        iVar.setLikeCount(j);
        a.a(this.f32754d);
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j, 1, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f32755e.a()) {
            this.f32755e.setLikeState(1);
            i iVar = this.f32755e;
            long j = this.f32756f - 1;
            this.f32756f = j;
            iVar.setLikeCount(j);
            a.b(this.f32754d);
            com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j);
            return;
        }
        this.f32755e.setLikeState(2);
        i iVar2 = this.f32755e;
        long j2 = this.f32756f + 1;
        this.f32756f = j2;
        iVar2.setLikeCount(j2);
        a.a(this.f32754d);
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j, 1, 2);
    }
}
