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
public class ActionBarLandscapeVertical extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f10969a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f10970b;
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
    private KsLogoView m;
    private AdTemplate n;
    private AdInfo o;
    private a p;
    private b q;
    private KsAppDownloadListener r;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public ActionBarLandscapeVertical(@NonNull Context context) {
        super(context);
        a(context);
    }

    public ActionBarLandscapeVertical(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActionBarLandscapeVertical(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        inflate(context, R.layout.ksad_video_actionbar_landscape_vertical, this);
        this.f10969a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f10970b = (ViewGroup) findViewById(R.id.ksad_top_outer);
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
        this.m = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.r == null) {
            this.r = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.c(i), i);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(ActionBarLandscapeVertical.this.n), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.w(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i), i);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }
            };
        }
        return this.r;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i) {
        this.n = adTemplate;
        this.o = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.m.a(adTemplate);
        if (com.kwad.sdk.core.response.b.a.y(this.o)) {
            this.i.setVisibility(8);
            this.f10969a.setVisibility(0);
            this.f10969a.setOnClickListener(this);
            this.h.setText(com.kwad.sdk.core.response.b.a.q(this.o));
        } else {
            this.i.setVisibility(0);
            this.f10969a.setVisibility(8);
            this.f10970b.setOnClickListener(this);
            this.i.setText(this.o.adBaseInfo.productName);
        }
        this.p = aVar;
        this.q = bVar;
        KSImageLoader.loadAppIcon(this.c, com.kwad.sdk.core.response.b.a.o(this.o), adTemplate, 16);
        float u = com.kwad.sdk.core.response.b.a.u(this.o);
        if (u >= 3.0f) {
            this.d.setScore(u);
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.o);
        if (TextUtils.isEmpty(t) ? false : true) {
            this.e.setText(t);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.width = i;
        this.f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.b.a.n(this.o));
        this.k.a(com.kwad.sdk.core.response.b.a.w(this.o), this.k.getMax());
        this.l.setVisibility(8);
        if (this.q != null) {
            this.q.a(getAppDownloadListener());
        }
        this.g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.q, view == this.k);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.n, new a.InterfaceC1105a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1105a
            public void a() {
                if (ActionBarLandscapeVertical.this.p != null) {
                    ActionBarLandscapeVertical.this.p.a();
                }
            }
        }, this.q);
    }
}
