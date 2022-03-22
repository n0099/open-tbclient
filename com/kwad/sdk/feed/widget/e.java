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
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f40496f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f40497g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40498h;
    public KsLogoView i;
    public DownloadProgressView j;

    public e(@NonNull Context context) {
        super(context);
    }

    private void d() {
        findViewById(R.id.obfuscated_res_0x7f091019).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f091018).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09108d);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f09108b)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        textView.setText(com.kwad.sdk.core.response.a.a.A(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        findViewById(R.id.obfuscated_res_0x7f09108e).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.obfuscated_res_0x7f091018).setVisibility(0);
        findViewById(R.id.obfuscated_res_0x7f091019).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091036);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f09103a)).setText(com.kwad.sdk.core.response.a.a.t(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f080b9a);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.a.a.au(((com.kwad.sdk.feed.widget.base.a) this).f40490c), ((com.kwad.sdk.feed.widget.base.a) this).f40489b, 8);
        ((TextView) findViewById(R.id.obfuscated_res_0x7f091031)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        this.j.a(((com.kwad.sdk.feed.widget.base.a) this).f40489b);
        this.j.setOnClickListener(this);
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f40489b, null, this.j.getAppDownloadListener());
        this.f40498h = bVar;
        bVar.c(this.j.getAppDownloadListener());
        this.f40498h.a((DialogInterface.OnShowListener) this);
        this.f40498h.a((DialogInterface.OnDismissListener) this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f40490c));
        this.i.a(adTemplate);
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f40490c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f40496f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f40489b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextBelowImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f40490c)) {
            g();
        } else {
            d();
        }
        this.f40497g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091014);
        ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09108f)).setRatio(0.56f);
        this.f40496f = (ImageView) findViewById(R.id.obfuscated_res_0x7f09101a);
        this.f40497g = (ImageView) findViewById(R.id.obfuscated_res_0x7f091016);
        this.i = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091017);
        this.j = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091033);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d043a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f40497g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f40489b).a(this.f40498h).a(view == this.j ? 1 : 2).a(view == this.j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.e.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    e.this.k();
                }
            }));
        }
    }
}
