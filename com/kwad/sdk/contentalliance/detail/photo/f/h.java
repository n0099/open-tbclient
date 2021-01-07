package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class h extends com.kwad.sdk.contentalliance.detail.photo.f.a<i> {
    private long d;
    private i e;
    private long f = 0;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Set<Long> f8821a = new HashSet();

        public static void a(long j) {
            f8821a.add(Long.valueOf(j));
        }

        public static void b(long j) {
            f8821a.remove(Long.valueOf(j));
        }

        public static boolean c(long j) {
            return f8821a.contains(Long.valueOf(j));
        }
    }

    private long p() {
        long s = com.kwad.sdk.core.response.b.c.s(this.f8693a.j);
        long j = s >= 0 ? s : 0L;
        return a.c(this.d) ? j + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = com.kwad.sdk.core.response.b.c.z(this.f8693a.j);
        this.f = p();
        this.e.a(a.c(this.d) ? 2 : 1, this.f);
        this.e.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.e.setOnClickListener(null);
        this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.e = f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    /* renamed from: e */
    public i g() {
        return new i(o());
    }

    public void h() {
        if (this.e.a()) {
            com.kwad.sdk.core.report.e.a(this.f8693a.j, 2, 1);
            return;
        }
        this.e.setLikeState(2);
        i iVar = this.e;
        long j = this.f + 1;
        this.f = j;
        iVar.setLikeCount(j);
        a.a(this.d);
        com.kwad.sdk.core.report.e.a(this.f8693a.j, 1, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.e.a()) {
            this.e.setLikeState(1);
            i iVar = this.e;
            long j = this.f - 1;
            this.f = j;
            iVar.setLikeCount(j);
            a.b(this.d);
            com.kwad.sdk.core.report.e.d(this.f8693a.j);
            return;
        }
        this.e.setLikeState(2);
        i iVar2 = this.e;
        long j2 = this.f + 1;
        this.f = j2;
        iVar2.setLikeCount(j2);
        a.a(this.d);
        com.kwad.sdk.core.report.e.a(this.f8693a.j, 1, 2);
    }
}
