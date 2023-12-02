package com.kwad.components.core.e.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class d extends b implements View.OnClickListener {
    public TextView Ll;
    public TextView Lm;
    public TextView qN;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qN = (TextView) findViewById(R.id.obfuscated_res_0x7f091499);
        this.Ll = (TextView) findViewById(R.id.obfuscated_res_0x7f09149a);
        this.Lm = (TextView) findViewById(R.id.obfuscated_res_0x7f091498);
    }

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void aj() {
        super.aj();
        if (this.Lk.Lj.nt() == 1) {
            TextView textView = this.qN;
            textView.setText("即将打开" + com.kwad.sdk.core.response.b.a.cd(this.mAdInfo));
        } else if (this.Lk.Lj.nt() == 2) {
            this.qN.setText("即将打开第三方页面");
        }
        com.kwad.sdk.d.a.a.a(this, this.Ll, this.Lm);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        this.Lk.Lj.ak(true);
        this.Lk.Lh.dismiss();
        if (view2 == this.Ll) {
            com.kwad.components.core.e.d.a.a(this.Lk.Lj);
            com.kwad.sdk.core.report.a.s(this.Lk.Lj.getAdTemplate(), 230);
        } else if (view2 == this.Lm) {
            com.kwad.sdk.core.report.a.s(this.Lk.Lj.getAdTemplate(), 231);
        }
    }
}
