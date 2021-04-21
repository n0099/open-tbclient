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
    public TrendsPanelLayout f33418c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.a f33419d;

    /* renamed from: e  reason: collision with root package name */
    public TrendsPanelLayout.a f33420e = new TrendsPanelLayout.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.a
        public void a(int i) {
            com.kwad.sdk.core.report.e.a(((e) b.this).f33153a.f33158e, i);
            b.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public TrendsPanelLayout.b f33421f = new TrendsPanelLayout.b() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.2
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
        public void a(View view, TrendInfo trendInfo, int i) {
            if (trendInfo == null) {
                return;
            }
            com.kwad.sdk.core.d.a.a("PhotoTrendsPanelPresenter", "onItemClick position=" + i + " trendInfo=" + trendInfo.toJson());
            ((e) b.this).f33153a.i = trendInfo;
            b.this.a(view, trendInfo, i);
            com.kwad.sdk.core.report.e.d(((e) b.this).f33153a.f33158e, trendInfo.trendId, trendInfo.name);
            if (b.this.f33419d != null) {
                b.this.f33419d.b(trendInfo);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public c.a f33422g = new c.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.3
        @Override // com.kwad.sdk.contentalliance.trends.a.b.c.a
        public void a(@NonNull List<TrendInfo> list) {
            b.this.a(list);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f33417b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                b.this.f33418c.a(5);
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, TrendInfo trendInfo, int i) {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33153a.o) {
            cVar.a(view, trendInfo, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<TrendInfo> list) {
        long j;
        TrendInfo trendInfo = ((e) this).f33153a.i;
        if (trendInfo != null) {
            j = trendInfo.trendId;
            String str = trendInfo.name;
        } else {
            j = 0;
        }
        this.f33418c.a(new com.kwad.sdk.contentalliance.trends.view.b(list, j, ((e) this).f33153a.f33158e));
        this.f33418c.a();
        com.kwad.sdk.core.report.e.a(((e) this).f33153a.f33158e);
        this.f33418c.setFocusableInTouchMode(true);
        this.f33418c.requestFocus();
        this.f33418c.setOnKeyListener(this.f33417b);
        ((e) this).f33153a.f33159f.l = true;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33418c.setFocusableInTouchMode(false);
        this.f33418c.setOnKeyListener(null);
        ((e) this).f33153a.f33159f.l = false;
        g();
    }

    private void f() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33153a.o) {
            cVar.a();
        }
    }

    private void g() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33153a.o) {
            cVar.b();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.a.b c2 = ((e) this).f33153a.f33155b.c();
        if (c2 instanceof com.kwad.sdk.contentalliance.trends.a) {
            this.f33419d = (com.kwad.sdk.contentalliance.trends.a) c2;
        }
        ((e) this).f33153a.n.add(this.f33422g);
        this.f33418c.setItemClickListener(this.f33421f);
        this.f33418c.setCloseListener(this.f33420e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        this.f33418c.setCloseListener(null);
        this.f33418c.setItemClickListener(null);
        this.f33418c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33418c = (TrendsPanelLayout) b(R.id.ksad_trend_list_panel);
    }
}
