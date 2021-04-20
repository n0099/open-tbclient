package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class h extends com.kwad.sdk.contentalliance.detail.photo.f.a<i> {

    /* renamed from: d  reason: collision with root package name */
    public long f32659d;

    /* renamed from: e  reason: collision with root package name */
    public i f32660e;

    /* renamed from: f  reason: collision with root package name */
    public long f32661f = 0;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Set<Long> f32662a = new HashSet();

        public static void a(long j) {
            f32662a.add(Long.valueOf(j));
        }

        public static void b(long j) {
            f32662a.remove(Long.valueOf(j));
        }

        public static boolean c(long j) {
            return f32662a.contains(Long.valueOf(j));
        }
    }

    private long p() {
        long s = com.kwad.sdk.core.response.b.c.s(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j);
        if (s < 0) {
            s = 0;
        }
        return a.c(this.f32659d) ? s + 1 : s;
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32659d = com.kwad.sdk.core.response.b.c.z(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j);
        this.f32661f = p();
        this.f32660e.a(a.c(this.f32659d) ? 2 : 1, this.f32661f);
        this.f32660e.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32660e.setOnClickListener(null);
        this.f32660e.b();
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32660e = f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public i g() {
        return new i(o());
    }

    public void h() {
        if (this.f32660e.a()) {
            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j, 2, 1);
            return;
        }
        this.f32660e.setLikeState(2);
        i iVar = this.f32660e;
        long j = this.f32661f + 1;
        this.f32661f = j;
        iVar.setLikeCount(j);
        a.a(this.f32659d);
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j, 1, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f32660e.a()) {
            this.f32660e.setLikeState(1);
            i iVar = this.f32660e;
            long j = this.f32661f - 1;
            this.f32661f = j;
            iVar.setLikeCount(j);
            a.b(this.f32659d);
            com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j);
            return;
        }
        this.f32660e.setLikeState(2);
        i iVar2 = this.f32660e;
        long j2 = this.f32661f + 1;
        this.f32661f = j2;
        iVar2.setLikeCount(j2);
        a.a(this.f32659d);
        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j, 1, 2);
    }
}
