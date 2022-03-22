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
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f40486f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f40487g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f40488h;
    public ImageView i;
    public KsLogoView j;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        this.j.a(adTemplate);
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f40490c);
        if (O.size() >= 3) {
            KSImageLoader.loadFeeImage(this.f40486f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f40489b);
            KSImageLoader.loadFeeImage(this.f40487g, O.get(1), ((com.kwad.sdk.feed.widget.base.a) this).f40489b);
            KSImageLoader.loadFeeImage(this.f40488h, O.get(2), ((com.kwad.sdk.feed.widget.base.a) this).f40489b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        this.i.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091014);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09108f)).setRatio(0.56f);
        this.f40486f = (ImageView) findViewById(R.id.obfuscated_res_0x7f09101b);
        this.f40487g = (ImageView) findViewById(R.id.obfuscated_res_0x7f09101c);
        this.f40488h = (ImageView) findViewById(R.id.obfuscated_res_0x7f09101d);
        this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f091016);
        this.j = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091017);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0437;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.i) {
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
