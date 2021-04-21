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
    public TextView f36793b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36794c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f36795d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36796e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36797f;

    /* renamed from: g  reason: collision with root package name */
    public e f36798g = new e() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String k = com.kwad.sdk.core.response.b.b.k(this.f36796e);
        if (TextUtils.isEmpty(k)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((d) this).f36842a;
        if (aVar.f36605e == 1 || (aVar.p && aVar.q)) {
            this.f36794c.setVisibility(8);
            this.f36793b.setText(k);
            this.f36793b.setVisibility(0);
            textView = this.f36793b;
        } else {
            this.f36793b.setVisibility(8);
            this.f36794c.setText(k);
            this.f36794c.setVisibility(0);
            textView = this.f36794c;
        }
        textView.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f36796e, 17, ((d) this).f36842a.f36604d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f36796e, 39, ((d) this).f36842a.f36608h.getTouchCoords(), ((d) this).f36842a.f36604d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f36795d.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36842a;
        this.f36795d = aVar.f36602b;
        this.f36796e = aVar.f36606f;
        this.f36797f = aVar.j;
        aVar.n.add(this.f36798g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36842a.n.remove(this.f36798g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36793b = (TextView) b(R.id.ksad_end_left_call_btn);
        this.f36794c = (TextView) b(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36793b || view == this.f36794c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36796e, new a.InterfaceC0396a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                    a.this.g();
                    a.this.h();
                }
            }, this.f36797f);
        }
    }
}
