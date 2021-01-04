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
/* loaded from: classes5.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f10972a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f10973b;
    private ImageView c;
    private AppScoreView d;
    private TextView e;
    private View f;
    private ViewGroup g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextProgressBar k;
    private View l;
    private AdTemplate m;
    private AdInfo n;
    private a o;
    private b p;
    private KsAppDownloadListener q;
    private KsLogoView r;

    /* loaded from: classes5.dex */
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

    public ActionBarPortraitHorizontal(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        inflate(context, R.layout.ksad_video_actionbar_portrait_horizontal, this);
        this.f10972a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f10973b = (ViewGroup) findViewById(R.id.ksad_top_container_product);
        this.c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f = findViewById(R.id.ksad_video_place_holder);
        this.g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.h = (TextView) findViewById(R.id.ksad_app_name);
        this.i = (TextView) findViewById(R.id.ksad_product_name);
        this.j = (TextView) findViewById(R.id.ksad_app_desc);
        this.k = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k.setTextDimen(ao.a(getContext(), 16.0f));
        this.k.setTextColor(-1);
        this.l = findViewById(R.id.ksad_app_download_btn_cover);
        this.k.setOnClickListener(this);
        this.r = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.q == null) {
            this.q = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.c(i), i);
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
                public void onProgressUpdate(int i) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.b.a.a(i), i);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }
            };
        }
        return this.q;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i) {
        this.m = adTemplate;
        this.r.a(adTemplate);
        this.n = com.kwad.sdk.core.response.b.c.j(this.m);
        if (com.kwad.sdk.core.response.b.a.y(this.n)) {
            this.f10973b.setVisibility(8);
            this.f10972a.setVisibility(0);
            this.f10972a.setOnClickListener(this);
            this.h.setText(com.kwad.sdk.core.response.b.a.q(this.n));
        } else {
            this.f10973b.setVisibility(0);
            this.f10972a.setVisibility(8);
            this.i.setText(this.n.adBaseInfo.productName);
            this.f10973b.setOnClickListener(this);
        }
        this.k.setOnClickListener(this);
        this.o = aVar;
        this.p = bVar;
        KSImageLoader.loadAppIcon(this.c, com.kwad.sdk.core.response.b.a.o(this.n), adTemplate, 16);
        float u = com.kwad.sdk.core.response.b.a.u(this.n);
        if (u >= 3.0f) {
            this.d.setScore(u);
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.n);
        if (TextUtils.isEmpty(t) ? false : true) {
            this.e.setText(t);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.height = i;
        this.f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.b.a.n(this.n));
        this.k.a(com.kwad.sdk.core.response.b.a.w(this.n), this.k.getMax());
        this.l.setVisibility(8);
        if (this.p != null) {
            this.p.a(getAppDownloadListener());
        }
        this.g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.p, view == this.k);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.m, new a.InterfaceC1064a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
            public void a() {
                if (ActionBarPortraitHorizontal.this.o != null) {
                    ActionBarPortraitHorizontal.this.o.a();
                }
            }
        }, this.p);
    }
}
