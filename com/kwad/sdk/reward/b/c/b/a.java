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
    public TextView f36408b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36409c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f36410d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36411e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36412f;

    /* renamed from: g  reason: collision with root package name */
    public e f36413g = new e() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String k = com.kwad.sdk.core.response.b.b.k(this.f36411e);
        if (TextUtils.isEmpty(k)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((d) this).f36457a;
        if (aVar.f36220e == 1 || (aVar.p && aVar.q)) {
            this.f36409c.setVisibility(8);
            this.f36408b.setText(k);
            this.f36408b.setVisibility(0);
            textView = this.f36408b;
        } else {
            this.f36408b.setVisibility(8);
            this.f36409c.setText(k);
            this.f36409c.setVisibility(0);
            textView = this.f36409c;
        }
        textView.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f36411e, 17, ((d) this).f36457a.f36219d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36411e, 39, ((d) this).f36457a.f36223h.getTouchCoords(), ((d) this).f36457a.f36219d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f36410d.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36457a;
        this.f36410d = aVar.f36217b;
        this.f36411e = aVar.f36221f;
        this.f36412f = aVar.j;
        aVar.n.add(this.f36413g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36457a.n.remove(this.f36413g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36408b = (TextView) b(R.id.ksad_end_left_call_btn);
        this.f36409c = (TextView) b(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36408b || view == this.f36409c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36411e, new a.InterfaceC0378a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
                public void a() {
                    a.this.g();
                    a.this.h();
                }
            }, this.f36412f);
        }
    }
}
