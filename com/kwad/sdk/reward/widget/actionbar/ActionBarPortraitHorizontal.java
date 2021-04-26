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
    public ViewGroup f34644a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34645b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34646c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f34647d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34648e;

    /* renamed from: f  reason: collision with root package name */
    public View f34649f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f34650g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34651h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f34652i;
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
        this.f34644a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f34645b = (ViewGroup) findViewById(R.id.ksad_top_container_product);
        this.f34646c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f34647d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f34648e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f34649f = findViewById(R.id.ksad_video_place_holder);
        this.f34650g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.f34651h = (TextView) findViewById(R.id.ksad_app_name);
        this.f34652i = (TextView) findViewById(R.id.ksad_product_name);
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
            this.f34645b.setVisibility(8);
            this.f34644a.setVisibility(0);
            this.f34644a.setOnClickListener(this);
            this.f34651h.setText(com.kwad.sdk.core.response.b.a.o(this.n));
        } else {
            this.f34645b.setVisibility(0);
            this.f34644a.setVisibility(8);
            this.f34652i.setText(this.n.adBaseInfo.productName);
            this.f34645b.setOnClickListener(this);
        }
        this.k.setOnClickListener(this);
        this.o = aVar;
        this.p = bVar;
        KSImageLoader.loadAppIcon(this.f34646c, com.kwad.sdk.core.response.b.a.n(this.n), adTemplate, 16);
        float s = com.kwad.sdk.core.response.b.a.s(this.n);
        if (s >= 3.0f) {
            this.f34647d.setScore(s);
            this.f34647d.setVisibility(0);
        } else {
            this.f34647d.setVisibility(8);
        }
        String r = com.kwad.sdk.core.response.b.a.r(this.n);
        if (!TextUtils.isEmpty(r)) {
            this.f34648e.setText(r);
            this.f34648e.setVisibility(0);
        } else {
            this.f34648e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f34649f.getLayoutParams();
        layoutParams.height = i2;
        this.f34649f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.b.a.m(this.n));
        this.k.a(com.kwad.sdk.core.response.b.a.u(this.n), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        this.f34650g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.m, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                if (ActionBarPortraitHorizontal.this.o != null) {
                    ActionBarPortraitHorizontal.this.o.a();
                }
            }
        }, this.p, view == this.k);
    }
}
