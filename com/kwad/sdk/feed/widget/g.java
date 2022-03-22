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
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f40499f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f40500g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f40501h;

    public g(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f40490c);
        this.f40501h.a(adTemplate);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f40499f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f40489b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        this.f40500g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091059)).setRatio(0.56f);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091014);
        this.f40499f = (ImageView) findViewById(R.id.obfuscated_res_0x7f09101a);
        this.f40500g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091016);
        this.f40501h = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091086);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d043c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40500g) {
            m();
        } else if (com.kwad.sdk.core.download.a.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f40489b, 1) == 1) {
            k();
        } else {
            boolean B = com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f40490c);
            k();
            if (B) {
                FeedDownloadActivityProxy.launch(((com.kwad.sdk.feed.widget.base.a) this).f40492e, ((com.kwad.sdk.feed.widget.base.a) this).f40489b, ((com.kwad.sdk.feed.widget.base.a) this).f40491d);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f40489b);
            }
        }
    }
}
