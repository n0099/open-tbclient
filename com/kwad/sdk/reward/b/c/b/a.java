package com.kwad.sdk.reward.b.c.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class a extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f36409b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36410c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f36411d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36412e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36413f;

    /* renamed from: g  reason: collision with root package name */
    public e f36414g = new e() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String k = com.kwad.sdk.core.response.b.b.k(this.f36412e);
        if (TextUtils.isEmpty(k)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((d) this).f36458a;
        if (aVar.f36221e == 1 || (aVar.p && aVar.q)) {
            this.f36410c.setVisibility(8);
            this.f36409b.setText(k);
            this.f36409b.setVisibility(0);
            textView = this.f36409b;
        } else {
            this.f36409b.setVisibility(8);
            this.f36410c.setText(k);
            this.f36410c.setVisibility(0);
            textView = this.f36410c;
        }
        textView.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f36412e, 17, ((d) this).f36458a.f36220d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36412e, 39, ((d) this).f36458a.f36224h.getTouchCoords(), ((d) this).f36458a.f36220d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f36411d.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36458a;
        this.f36411d = aVar.f36218b;
        this.f36412e = aVar.f36222f;
        this.f36413f = aVar.j;
        aVar.n.add(this.f36414g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36458a.n.remove(this.f36414g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36409b = (TextView) b(R.id.ksad_end_left_call_btn);
        this.f36410c = (TextView) b(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36409b || view == this.f36410c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36412e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    a.this.g();
                    a.this.h();
                }
            }, this.f36413f);
        }
    }
}
