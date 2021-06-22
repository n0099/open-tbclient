package com.kwad.sdk.contentalliance.trends.a.b;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.trends.a.b.c;
import com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends e {

    /* renamed from: c  reason: collision with root package name */
    public TrendsPanelLayout f33737c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.a f33738d;

    /* renamed from: e  reason: collision with root package name */
    public TrendsPanelLayout.a f33739e = new TrendsPanelLayout.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.a
        public void a(int i2) {
            com.kwad.sdk.core.report.e.a(((e) b.this).f33455a.f33460e, i2);
            b.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public TrendsPanelLayout.b f33740f = new TrendsPanelLayout.b() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.2
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
        public void a(View view, TrendInfo trendInfo, int i2) {
            if (trendInfo == null) {
                return;
            }
            com.kwad.sdk.core.d.a.a("PhotoTrendsPanelPresenter", "onItemClick position=" + i2 + " trendInfo=" + trendInfo.toJson());
            ((e) b.this).f33455a.f33464i = trendInfo;
            b.this.a(view, trendInfo, i2);
            com.kwad.sdk.core.report.e.d(((e) b.this).f33455a.f33460e, trendInfo.trendId, trendInfo.name);
            if (b.this.f33738d != null) {
                b.this.f33738d.b(trendInfo);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public c.a f33741g = new c.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.3
        @Override // com.kwad.sdk.contentalliance.trends.a.b.c.a
        public void a(@NonNull List<TrendInfo> list) {
            b.this.a(list);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f33736b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 4 && keyEvent.getAction() == 1) {
                b.this.f33737c.a(5);
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, TrendInfo trendInfo, int i2) {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33455a.o) {
            cVar.a(view, trendInfo, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<TrendInfo> list) {
        long j;
        TrendInfo trendInfo = ((e) this).f33455a.f33464i;
        if (trendInfo != null) {
            j = trendInfo.trendId;
            String str = trendInfo.name;
        } else {
            j = 0;
        }
        this.f33737c.a(new com.kwad.sdk.contentalliance.trends.view.b(list, j, ((e) this).f33455a.f33460e));
        this.f33737c.a();
        com.kwad.sdk.core.report.e.a(((e) this).f33455a.f33460e);
        this.f33737c.setFocusableInTouchMode(true);
        this.f33737c.requestFocus();
        this.f33737c.setOnKeyListener(this.f33736b);
        ((e) this).f33455a.f33461f.l = true;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33737c.setFocusableInTouchMode(false);
        this.f33737c.setOnKeyListener(null);
        ((e) this).f33455a.f33461f.l = false;
        g();
    }

    private void f() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33455a.o) {
            cVar.a();
        }
    }

    private void g() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33455a.o) {
            cVar.b();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.a.b c2 = ((e) this).f33455a.f33457b.c();
        if (c2 instanceof com.kwad.sdk.contentalliance.trends.a) {
            this.f33738d = (com.kwad.sdk.contentalliance.trends.a) c2;
        }
        ((e) this).f33455a.n.add(this.f33741g);
        this.f33737c.setItemClickListener(this.f33740f);
        this.f33737c.setCloseListener(this.f33739e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        this.f33737c.setCloseListener(null);
        this.f33737c.setItemClickListener(null);
        this.f33737c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33737c = (TrendsPanelLayout) b(R.id.ksad_trend_list_panel);
    }
}
