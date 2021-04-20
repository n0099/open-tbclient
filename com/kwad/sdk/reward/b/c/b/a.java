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
    public TextView f36698b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36699c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f36700d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36701e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36702f;

    /* renamed from: g  reason: collision with root package name */
    public e f36703g = new e() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String k = com.kwad.sdk.core.response.b.b.k(this.f36701e);
        if (TextUtils.isEmpty(k)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((d) this).f36747a;
        if (aVar.f36510e == 1 || (aVar.p && aVar.q)) {
            this.f36699c.setVisibility(8);
            this.f36698b.setText(k);
            this.f36698b.setVisibility(0);
            textView = this.f36698b;
        } else {
            this.f36698b.setVisibility(8);
            this.f36699c.setText(k);
            this.f36699c.setVisibility(0);
            textView = this.f36699c;
        }
        textView.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f36701e, 17, ((d) this).f36747a.f36509d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36701e, 39, ((d) this).f36747a.f36513h.getTouchCoords(), ((d) this).f36747a.f36509d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f36700d.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36747a;
        this.f36700d = aVar.f36507b;
        this.f36701e = aVar.f36511f;
        this.f36702f = aVar.j;
        aVar.n.add(this.f36703g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36747a.n.remove(this.f36703g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36698b = (TextView) b(R.id.ksad_end_left_call_btn);
        this.f36699c = (TextView) b(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36698b || view == this.f36699c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36701e, new a.InterfaceC0393a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    a.this.g();
                    a.this.h();
                }
            }, this.f36702f);
        }
    }
}
