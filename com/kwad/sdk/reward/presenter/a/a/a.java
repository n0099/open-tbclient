package com.kwad.sdk.reward.presenter.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes7.dex */
public class a extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f40881b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40882c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f40883d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f40884e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40885f;

    /* renamed from: g  reason: collision with root package name */
    public f f40886g = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) a.this).a.x) {
                return;
            }
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String f2 = com.kwad.sdk.core.response.a.c.f(this.f40884e);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f40746f == 1 || (aVar.r && aVar.s)) {
            this.f40882c.setVisibility(8);
            this.f40881b.setText(f2);
            this.f40881b.setVisibility(0);
            textView = this.f40881b;
        } else {
            this.f40881b.setVisibility(8);
            this.f40882c.setText(f2);
            this.f40882c.setVisibility(0);
            textView = this.f40882c;
        }
        textView.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f40884e, 17, ((g) this).a.f40745e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f40884e, 39, ((g) this).a.j.getTouchCoords(), ((g) this).a.f40745e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f40883d.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f40883d = aVar.f40742b;
        this.f40884e = aVar.f40747g;
        this.f40885f = aVar.l;
        aVar.a(this.f40886g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f40886g);
        this.f40881b.setVisibility(8);
        this.f40882c.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40881b = (TextView) a(R.id.obfuscated_res_0x7f09107c);
        this.f40882c = (TextView) a(R.id.obfuscated_res_0x7f091081);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40881b || view == this.f40882c) {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f40884e).a(this.f40885f).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.a.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.r();
                    a.this.s();
                }
            }));
        }
    }
}
