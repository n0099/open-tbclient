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
    public TrendsPanelLayout f33033c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.a f33034d;

    /* renamed from: e  reason: collision with root package name */
    public TrendsPanelLayout.a f33035e = new TrendsPanelLayout.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.a
        public void a(int i) {
            com.kwad.sdk.core.report.e.a(((e) b.this).f32768a.f32773e, i);
            b.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public TrendsPanelLayout.b f33036f = new TrendsPanelLayout.b() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.2
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
        public void a(View view, TrendInfo trendInfo, int i) {
            if (trendInfo == null) {
                return;
            }
            com.kwad.sdk.core.d.a.a("PhotoTrendsPanelPresenter", "onItemClick position=" + i + " trendInfo=" + trendInfo.toJson());
            ((e) b.this).f32768a.i = trendInfo;
            b.this.a(view, trendInfo, i);
            com.kwad.sdk.core.report.e.d(((e) b.this).f32768a.f32773e, trendInfo.trendId, trendInfo.name);
            if (b.this.f33034d != null) {
                b.this.f33034d.b(trendInfo);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public c.a f33037g = new c.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.3
        @Override // com.kwad.sdk.contentalliance.trends.a.b.c.a
        public void a(@NonNull List<TrendInfo> list) {
            b.this.a(list);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f33032b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                b.this.f33033c.a(5);
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, TrendInfo trendInfo, int i) {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f32768a.o) {
            cVar.a(view, trendInfo, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<TrendInfo> list) {
        long j;
        TrendInfo trendInfo = ((e) this).f32768a.i;
        if (trendInfo != null) {
            j = trendInfo.trendId;
            String str = trendInfo.name;
        } else {
            j = 0;
        }
        this.f33033c.a(new com.kwad.sdk.contentalliance.trends.view.b(list, j, ((e) this).f32768a.f32773e));
        this.f33033c.a();
        com.kwad.sdk.core.report.e.a(((e) this).f32768a.f32773e);
        this.f33033c.setFocusableInTouchMode(true);
        this.f33033c.requestFocus();
        this.f33033c.setOnKeyListener(this.f33032b);
        ((e) this).f32768a.f32774f.l = true;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33033c.setFocusableInTouchMode(false);
        this.f33033c.setOnKeyListener(null);
        ((e) this).f32768a.f32774f.l = false;
        g();
    }

    private void f() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f32768a.o) {
            cVar.a();
        }
    }

    private void g() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f32768a.o) {
            cVar.b();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.a.b c2 = ((e) this).f32768a.f32770b.c();
        if (c2 instanceof com.kwad.sdk.contentalliance.trends.a) {
            this.f33034d = (com.kwad.sdk.contentalliance.trends.a) c2;
        }
        ((e) this).f32768a.n.add(this.f33037g);
        this.f33033c.setItemClickListener(this.f33036f);
        this.f33033c.setCloseListener(this.f33035e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        this.f33033c.setCloseListener(null);
        this.f33033c.setItemClickListener(null);
        this.f33033c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33033c = (TrendsPanelLayout) b(R.id.ksad_trend_list_panel);
    }
}
