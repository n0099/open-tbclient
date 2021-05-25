package com.kwad.sdk.reward.b.c.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class a extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f33705b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33706c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f33707d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33708e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33709f;

    /* renamed from: g  reason: collision with root package name */
    public f f33710g = new f() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) a.this).f33768a.s) {
                return;
            }
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String f2 = com.kwad.sdk.core.response.b.b.f(this.f33708e);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        if (aVar.f33494e == 1 || (aVar.q && aVar.r)) {
            this.f33706c.setVisibility(8);
            this.f33705b.setText(f2);
            this.f33705b.setVisibility(0);
            textView = this.f33705b;
        } else {
            this.f33705b.setVisibility(8);
            this.f33706c.setText(f2);
            this.f33706c.setVisibility(0);
            textView = this.f33706c;
        }
        textView.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f33708e, 17, ((d) this).f33768a.f33493d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f33708e, 39, ((d) this).f33768a.f33497h.getTouchCoords(), ((d) this).f33768a.f33493d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f33707d.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f33768a;
        this.f33707d = aVar.f33491b;
        this.f33708e = aVar.f33495f;
        this.f33709f = aVar.j;
        aVar.a(this.f33710g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33705b = (TextView) a(R.id.ksad_end_left_call_btn);
        this.f33706c = (TextView) a(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f33768a.b(this.f33710g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33705b || view == this.f33706c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33708e, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    a.this.n();
                    a.this.o();
                }
            }, this.f33709f, false);
        }
    }
}
