package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;
    public RoundAngleImageView f;
    public ImageView g;
    public com.kwad.sdk.core.download.a.b h;
    public KsLogoView i;
    public DownloadProgressView j;

    public i(@NonNull Context context) {
        super(context);
    }

    private void d() {
        this.i.a(((com.kwad.sdk.feed.widget.base.a) this).b);
        this.j.a(((com.kwad.sdk.feed.widget.base.a) this).b);
        this.j.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).c)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).b, null, this.j.getAppDownloadListener());
            this.h = bVar;
            bVar.c(this.j.getAppDownloadListener());
            this.h.a((DialogInterface.OnShowListener) this);
            this.h.a((DialogInterface.OnDismissListener) this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        d();
        this.g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09100d);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091088)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f091013);
        this.f = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.a.kwai.a.a(getContext(), 3.0f));
        this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f09100f);
        this.j = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f09102c);
        this.i = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09107f);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0439;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C0296a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).b).a(this.h).a(view2 == this.j ? 1 : 2).a(view2 == this.j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.i.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    i.this.k();
                }
            }));
        }
    }
}
