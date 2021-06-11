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
    public TrendsPanelLayout f33639c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.a f33640d;

    /* renamed from: e  reason: collision with root package name */
    public TrendsPanelLayout.a f33641e = new TrendsPanelLayout.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.a
        public void a(int i2) {
            com.kwad.sdk.core.report.e.a(((e) b.this).f33357a.f33362e, i2);
            b.this.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public TrendsPanelLayout.b f33642f = new TrendsPanelLayout.b() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.2
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
        public void a(View view, TrendInfo trendInfo, int i2) {
            if (trendInfo == null) {
                return;
            }
            com.kwad.sdk.core.d.a.a("PhotoTrendsPanelPresenter", "onItemClick position=" + i2 + " trendInfo=" + trendInfo.toJson());
            ((e) b.this).f33357a.f33366i = trendInfo;
            b.this.a(view, trendInfo, i2);
            com.kwad.sdk.core.report.e.d(((e) b.this).f33357a.f33362e, trendInfo.trendId, trendInfo.name);
            if (b.this.f33640d != null) {
                b.this.f33640d.b(trendInfo);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public c.a f33643g = new c.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.3
        @Override // com.kwad.sdk.contentalliance.trends.a.b.c.a
        public void a(@NonNull List<TrendInfo> list) {
            b.this.a(list);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f33638b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 4 && keyEvent.getAction() == 1) {
                b.this.f33639c.a(5);
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, TrendInfo trendInfo, int i2) {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33357a.o) {
            cVar.a(view, trendInfo, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<TrendInfo> list) {
        long j;
        TrendInfo trendInfo = ((e) this).f33357a.f33366i;
        if (trendInfo != null) {
            j = trendInfo.trendId;
            String str = trendInfo.name;
        } else {
            j = 0;
        }
        this.f33639c.a(new com.kwad.sdk.contentalliance.trends.view.b(list, j, ((e) this).f33357a.f33362e));
        this.f33639c.a();
        com.kwad.sdk.core.report.e.a(((e) this).f33357a.f33362e);
        this.f33639c.setFocusableInTouchMode(true);
        this.f33639c.requestFocus();
        this.f33639c.setOnKeyListener(this.f33638b);
        ((e) this).f33357a.f33363f.l = true;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33639c.setFocusableInTouchMode(false);
        this.f33639c.setOnKeyListener(null);
        ((e) this).f33357a.f33363f.l = false;
        g();
    }

    private void f() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33357a.o) {
            cVar.a();
        }
    }

    private void g() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : ((e) this).f33357a.o) {
            cVar.b();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.a.b c2 = ((e) this).f33357a.f33359b.c();
        if (c2 instanceof com.kwad.sdk.contentalliance.trends.a) {
            this.f33640d = (com.kwad.sdk.contentalliance.trends.a) c2;
        }
        ((e) this).f33357a.n.add(this.f33643g);
        this.f33639c.setItemClickListener(this.f33642f);
        this.f33639c.setCloseListener(this.f33641e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        this.f33639c.setCloseListener(null);
        this.f33639c.setItemClickListener(null);
        this.f33639c.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33639c = (TrendsPanelLayout) b(R.id.ksad_trend_list_panel);
    }
}
