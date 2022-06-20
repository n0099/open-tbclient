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
/* loaded from: classes5.dex */
public class a extends g implements View.OnClickListener {
    public TextView b;
    public TextView c;
    @NonNull
    public com.kwad.sdk.reward.a.b d;
    @NonNull
    public AdTemplate e;
    @Nullable
    public com.kwad.sdk.core.download.a.b f;
    public f g = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.a.1
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
        String f = com.kwad.sdk.core.response.a.c.f(this.e);
        if (TextUtils.isEmpty(f)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f == 1 || (aVar.r && aVar.s)) {
            this.c.setVisibility(8);
            this.b.setText(f);
            this.b.setVisibility(0);
            textView = this.b;
        } else {
            this.b.setVisibility(8);
            this.c.setText(f);
            this.c.setVisibility(0);
            textView = this.c;
        }
        textView.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.e, 17, ((g) this).a.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.e, 39, ((g) this).a.j.getTouchCoords(), ((g) this).a.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.d.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.d = aVar.b;
        this.e = aVar.g;
        this.f = aVar.l;
        aVar.a(this.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.g);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (TextView) a(R.id.obfuscated_res_0x7f091037);
        this.c = (TextView) a(R.id.obfuscated_res_0x7f09103c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.b || view2 == this.c) {
            com.kwad.sdk.core.download.a.a.a(new a.C0304a(view2.getContext()).a(this.e).a(this.f).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.a.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.r();
                    a.this.s();
                }
            }));
        }
    }
}
