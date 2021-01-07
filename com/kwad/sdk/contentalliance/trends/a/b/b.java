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
/* loaded from: classes5.dex */
public class b extends e {
    private TrendsPanelLayout c;
    private com.kwad.sdk.contentalliance.trends.a d;
    private TrendsPanelLayout.a e = new TrendsPanelLayout.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.1
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.a
        public void a(int i) {
            com.kwad.sdk.core.report.e.a(b.this.f9034a.e, i);
            b.this.e();
        }
    };
    private TrendsPanelLayout.b f = new TrendsPanelLayout.b() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.2
        @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
        public void a(View view, TrendInfo trendInfo, int i) {
            if (trendInfo == null) {
                return;
            }
            com.kwad.sdk.core.d.a.a("PhotoTrendsPanelPresenter", "onItemClick position=" + i + " trendInfo=" + trendInfo.toJson());
            b.this.f9034a.i = trendInfo;
            b.this.a(view, trendInfo, i);
            com.kwad.sdk.core.report.e.d(b.this.f9034a.e, trendInfo.trendId, trendInfo.name);
            if (b.this.d != null) {
                b.this.d.b(trendInfo);
            }
        }
    };
    private c.a g = new c.a() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.3
        @Override // com.kwad.sdk.contentalliance.trends.a.b.c.a
        public void a(@NonNull List<TrendInfo> list) {
            b.this.a(list);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    View.OnKeyListener f9160b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.b.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                b.this.c.a(5);
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, TrendInfo trendInfo, int i) {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : this.f9034a.o) {
            cVar.a(view, trendInfo, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull List<TrendInfo> list) {
        long j = 0;
        if (this.f9034a.i != null) {
            j = this.f9034a.i.trendId;
            String str = this.f9034a.i.name;
        }
        this.c.a(new com.kwad.sdk.contentalliance.trends.view.b(list, j, this.f9034a.e));
        this.c.a();
        com.kwad.sdk.core.report.e.a(this.f9034a.e);
        this.c.setFocusableInTouchMode(true);
        this.c.requestFocus();
        this.c.setOnKeyListener(this.f9160b);
        this.f9034a.f.l = true;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c.setFocusableInTouchMode(false);
        this.c.setOnKeyListener(null);
        this.f9034a.f.l = false;
        g();
    }

    private void f() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : this.f9034a.o) {
            cVar.a();
        }
    }

    private void g() {
        for (com.kwad.sdk.contentalliance.trends.view.c cVar : this.f9034a.o) {
            cVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.a.b c = this.f9034a.f9036b.c();
        if (c instanceof com.kwad.sdk.contentalliance.trends.a) {
            this.d = (com.kwad.sdk.contentalliance.trends.a) c;
        }
        this.f9034a.n.add(this.g);
        this.c.setItemClickListener(this.f);
        this.c.setCloseListener(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        e();
        this.c.setCloseListener(null);
        this.c.setItemClickListener(null);
        this.c.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (TrendsPanelLayout) b(R.id.ksad_trend_list_panel);
    }
}
