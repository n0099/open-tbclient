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
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;
    public ImageView f;
    public ImageView g;
    public com.kwad.sdk.core.download.a.b h;
    public KsLogoView i;
    public DownloadProgressView j;

    public e(@NonNull Context context) {
        super(context);
    }

    private void d() {
        findViewById(R.id.obfuscated_res_0x7f090fe4).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090fe3).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091058);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091056)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        textView.setText(com.kwad.sdk.core.response.a.a.A(((com.kwad.sdk.feed.widget.base.a) this).c));
        findViewById(R.id.obfuscated_res_0x7f091059).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.obfuscated_res_0x7f090fe3).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f090fe4).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091001);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091005)).setText(com.kwad.sdk.core.response.a.a.t(((com.kwad.sdk.feed.widget.base.a) this).c));
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f080bcb);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.a.a.au(((com.kwad.sdk.feed.widget.base.a) this).c), ((com.kwad.sdk.feed.widget.base.a) this).b, 8);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f090ffc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        this.j.a(((com.kwad.sdk.feed.widget.base.a) this).b);
        this.j.setOnClickListener(this);
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).b, null, this.j.getAppDownloadListener());
        this.h = bVar;
        bVar.c(this.j.getAppDownloadListener());
        this.h.a((DialogInterface.OnShowListener) this);
        this.h.a((DialogInterface.OnDismissListener) this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        this.i.a(adTemplate);
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextBelowImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).c)) {
            g();
        } else {
            d();
        }
        this.g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fdf);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09105a)).setRatio(0.56f);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe5);
        this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe1);
        this.i = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f090fe2);
        this.j = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f090ffe);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d041f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C0296a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).b).a(this.h).a(view2 == this.j ? 1 : 2).a(view2 == this.j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.e.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    e.this.k();
                }
            }));
        }
    }
}
