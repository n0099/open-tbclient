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
/* loaded from: classes7.dex */
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public RoundAngleImageView f40505f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f40506g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40507h;
    public KsLogoView i;
    public DownloadProgressView j;

    public i(@NonNull Context context) {
        super(context);
    }

    private void d() {
        this.i.a(((com.kwad.sdk.feed.widget.base.a) this).f40489b);
        this.j.a(((com.kwad.sdk.feed.widget.base.a) this).f40489b);
        this.j.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f40490c)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f40489b, null, this.j.getAppDownloadListener());
            this.f40507h = bVar;
            bVar.c(this.j.getAppDownloadListener());
            this.f40507h.a((DialogInterface.OnShowListener) this);
            this.f40507h.a((DialogInterface.OnDismissListener) this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f40490c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f40505f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f40489b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        d();
        this.f40506g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091014);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09108f)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f09101a);
        this.f40505f = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.a.kwai.a.a(getContext(), 3.0f));
        this.f40506g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091016);
        this.j = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091033);
        this.i = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091086);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d043e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40506g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f40489b).a(this.f40507h).a(view == this.j ? 1 : 2).a(view == this.j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.i.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    i.this.k();
                }
            }));
        }
    }
}
