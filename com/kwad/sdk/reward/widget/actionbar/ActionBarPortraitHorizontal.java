package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f37345a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f37346b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37347c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f37348d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37349e;

    /* renamed from: f  reason: collision with root package name */
    public View f37350f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f37351g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37352h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37353i;
    public TextView j;
    public TextProgressBar k;
    public View l;
    public AdTemplate m;
    public AdInfo n;
    public a o;
    public b p;
    public KsAppDownloadListener q;
    public KsLogoView r;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public ActionBarPortraitHorizontal(@NonNull Context context) {
        super(context);
        a(context);
    }

    public ActionBarPortraitHorizontal(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActionBarPortraitHorizontal(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_video_actionbar_portrait_horizontal, this);
        this.f37345a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f37346b = (ViewGroup) findViewById(R.id.ksad_top_container_product);
        this.f37347c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f37348d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f37349e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f37350f = findViewById(R.id.ksad_video_place_holder);
        this.f37351g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.f37352h = (TextView) findViewById(R.id.ksad_app_name);
        this.f37353i = (TextView) findViewById(R.id.ksad_product_name);
        this.j = (TextView) findViewById(R.id.ksad_app_desc);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.k.setTextColor(-1);
        this.l = findViewById(R.id.ksad_app_download_btn_cover);
        this.k.setOnClickListener(this);
        this.r = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.q == null) {
            this.q = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.c(i2), i2);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.w(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.a(ActionBarPortraitHorizontal.this.m), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.w(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }
            };
        }
        return this.q;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i2) {
        this.m = adTemplate;
        this.r.a(adTemplate);
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.m);
        this.n = j;
        if (com.kwad.sdk.core.response.b.a.y(j)) {
            this.f37346b.setVisibility(8);
            this.f37345a.setVisibility(0);
            this.f37345a.setOnClickListener(this);
            this.f37352h.setText(com.kwad.sdk.core.response.b.a.q(this.n));
        } else {
            this.f37346b.setVisibility(0);
            this.f37345a.setVisibility(8);
            this.f37353i.setText(this.n.adBaseInfo.productName);
            this.f37346b.setOnClickListener(this);
        }
        this.k.setOnClickListener(this);
        this.o = aVar;
        this.p = bVar;
        KSImageLoader.loadAppIcon(this.f37347c, com.kwad.sdk.core.response.b.a.o(this.n), adTemplate, 16);
        float u = com.kwad.sdk.core.response.b.a.u(this.n);
        if (u >= 3.0f) {
            this.f37348d.setScore(u);
            this.f37348d.setVisibility(0);
        } else {
            this.f37348d.setVisibility(8);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.n);
        if (!TextUtils.isEmpty(t)) {
            this.f37349e.setText(t);
            this.f37349e.setVisibility(0);
        } else {
            this.f37349e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f37350f.getLayoutParams();
        layoutParams.height = i2;
        this.f37350f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.b.a.n(this.n));
        this.k.a(com.kwad.sdk.core.response.b.a.w(this.n), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        this.f37351g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.p, view == this.k);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.m, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                if (ActionBarPortraitHorizontal.this.o != null) {
                    ActionBarPortraitHorizontal.this.o.a();
                }
            }
        }, this.p);
    }
}
