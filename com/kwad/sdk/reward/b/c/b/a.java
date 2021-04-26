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
    public TextView f34531b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34532c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f34533d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34534e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34535f;

    /* renamed from: g  reason: collision with root package name */
    public f f34536g = new f() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) a.this).f34594a.s) {
                return;
            }
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String f2 = com.kwad.sdk.core.response.b.b.f(this.f34534e);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        if (aVar.f34320e == 1 || (aVar.q && aVar.r)) {
            this.f34532c.setVisibility(8);
            this.f34531b.setText(f2);
            this.f34531b.setVisibility(0);
            textView = this.f34531b;
        } else {
            this.f34531b.setVisibility(8);
            this.f34532c.setText(f2);
            this.f34532c.setVisibility(0);
            textView = this.f34532c;
        }
        textView.setOnClickListener(this);
        m();
    }

    private void m() {
        com.kwad.sdk.core.report.b.c(this.f34534e, 17, ((d) this).f34594a.f34319d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.kwad.sdk.core.report.b.a(this.f34534e, 39, ((d) this).f34594a.f34323h.getTouchCoords(), ((d) this).f34594a.f34319d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f34533d.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f34594a;
        this.f34533d = aVar.f34317b;
        this.f34534e = aVar.f34321f;
        this.f34535f = aVar.j;
        aVar.a(this.f34536g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34531b = (TextView) a(R.id.ksad_end_left_call_btn);
        this.f34532c = (TextView) a(R.id.ksad_end_right_call_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f34594a.b(this.f34536g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34531b || view == this.f34532c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34534e, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                public void a() {
                    a.this.n();
                    a.this.o();
                }
            }, this.f34535f, false);
        }
    }
}
