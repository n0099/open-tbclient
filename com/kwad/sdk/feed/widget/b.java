package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedDownloadActivityProxy;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public KsLogoView j;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).c));
        this.j.a(adTemplate);
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).c);
        if (O.size() >= 3) {
            KSImageLoader.loadFeeImage(this.f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).b);
            KSImageLoader.loadFeeImage(this.g, O.get(1), ((com.kwad.sdk.feed.widget.base.a) this).b);
            KSImageLoader.loadFeeImage(this.h, O.get(2), ((com.kwad.sdk.feed.widget.base.a) this).b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        this.i.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fcf);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09104a)).setRatio(0.56f);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fd6);
        this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fd7);
        this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fd8);
        this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fd1);
        this.j = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f090fd2);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0416;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.i) {
            m();
        } else if (com.kwad.sdk.core.download.a.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).b, 1) == 1) {
            k();
        } else {
            boolean B = com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).c);
            k();
            if (B) {
                FeedDownloadActivityProxy.launch(((com.kwad.sdk.feed.widget.base.a) this).e, ((com.kwad.sdk.feed.widget.base.a) this).b, ((com.kwad.sdk.feed.widget.base.a) this).d);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).b);
            }
        }
    }
}
