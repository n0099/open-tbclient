package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public final class e extends a {
    public LinearLayout NR;
    public TextView NS;
    public ImageView NT;

    @NonNull
    private KsAdWebView.c pq() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.c.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void pr() {
                if (e.this.Oy.oX() && e.this.NR.getVisibility() == 0) {
                    e.this.NR.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        pp();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    private void pp() {
        this.NR = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09151e);
        if (!TextUtils.isEmpty(this.Oy.mPageTitle)) {
            this.NR.setVisibility(8);
            return;
        }
        this.NS = (TextView) findViewById(R.id.obfuscated_res_0x7f09151f);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091520);
        this.NT = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.this.NR.setVisibility(8);
            }
        });
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Oy.mAdTemplate);
        boolean bw = com.kwad.sdk.core.response.b.a.bw(dP);
        String bs = com.kwad.sdk.core.response.b.a.bs(dP);
        if (bw) {
            this.NR.setVisibility(0);
            this.NS.setText(bs);
            this.NS.setSelected(true);
        } else {
            this.NR.setVisibility(8);
        }
        this.Oy.a(pq());
    }
}
