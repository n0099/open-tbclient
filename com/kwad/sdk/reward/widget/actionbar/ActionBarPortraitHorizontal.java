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
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f33818a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33819b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33820c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f33821d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33822e;

    /* renamed from: f  reason: collision with root package name */
    public View f33823f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f33824g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33825h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33826i;
    public TextView j;
    public TextProgressBar k;
    public View l;
    public AdTemplate m;
    public AdInfo n;
    public a o;
    public b p;
    public KsAppDownloadListener q;
    public KsLogoView r;

    /* loaded from: classes6.dex */
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
        this.f33818a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f33819b = (ViewGroup) findViewById(R.id.ksad_top_container_product);
        this.f33820c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f33821d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f33822e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f33823f = findViewById(R.id.ksad_video_place_holder);
        this.f33824g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.f33825h = (TextView) findViewById(R.id.ksad_app_name);
        this.f33826i = (TextView) findViewById(R.id.ksad_product_name);
        this.j = (TextView) findViewById(R.id.ksad_app_desc);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
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
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.u(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.a(ActionBarPortraitHorizontal.this.m), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.u(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.j(ActionBarPortraitHorizontal.this.n), 0);
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
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.m);
        this.n = g2;
        if (com.kwad.sdk.core.response.b.a.v(g2)) {
            this.f33819b.setVisibility(8);
            this.f33818a.setVisibility(0);
            this.f33818a.setOnClickListener(this);
            this.f33825h.setText(com.kwad.sdk.core.response.b.a.o(this.n));
        } else {
            this.f33819b.setVisibility(0);
            this.f33818a.setVisibility(8);
            this.f33826i.setText(this.n.adBaseInfo.productName);
            this.f33819b.setOnClickListener(this);
        }
        this.k.setOnClickListener(this);
        this.o = aVar;
        this.p = bVar;
        KSImageLoader.loadAppIcon(this.f33820c, com.kwad.sdk.core.response.b.a.n(this.n), adTemplate, 16);
        float s = com.kwad.sdk.core.response.b.a.s(this.n);
        if (s >= 3.0f) {
            this.f33821d.setScore(s);
            this.f33821d.setVisibility(0);
        } else {
            this.f33821d.setVisibility(8);
        }
        String r = com.kwad.sdk.core.response.b.a.r(this.n);
        if (!TextUtils.isEmpty(r)) {
            this.f33822e.setText(r);
            this.f33822e.setVisibility(0);
        } else {
            this.f33822e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f33823f.getLayoutParams();
        layoutParams.height = i2;
        this.f33823f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.b.a.m(this.n));
        this.k.a(com.kwad.sdk.core.response.b.a.u(this.n), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        this.f33824g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.m, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                if (ActionBarPortraitHorizontal.this.o != null) {
                    ActionBarPortraitHorizontal.this.o.a();
                }
            }
        }, this.p, view == this.k);
    }
}
