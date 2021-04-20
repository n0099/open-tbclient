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
/* loaded from: classes6.dex */
public class ActionBarLandscapeVertical extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f36780a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f36781b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36782c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f36783d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36784e;

    /* renamed from: f  reason: collision with root package name */
    public View f36785f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f36786g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36787h;
    public TextView i;
    public TextView j;
    public TextProgressBar k;
    public View l;
    public KsLogoView m;
    public AdTemplate n;
    public AdInfo o;
    public a p;
    public b q;
    public KsAppDownloadListener r;

    /* loaded from: classes6.dex */
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
        FrameLayout.inflate(context, R.layout.ksad_video_actionbar_landscape_vertical, this);
        this.f36780a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f36781b = (ViewGroup) findViewById(R.id.ksad_top_outer);
        this.f36782c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f36783d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f36784e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f36785f = findViewById(R.id.ksad_video_place_holder);
        this.f36786g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.f36787h = (TextView) findViewById(R.id.ksad_app_name);
        this.i = (TextView) findViewById(R.id.ksad_product_name);
        this.j = (TextView) findViewById(R.id.ksad_app_desc);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
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
        TextView textView;
        String str;
        this.n = adTemplate;
        this.o = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.m.a(adTemplate);
        if (com.kwad.sdk.core.response.b.a.y(this.o)) {
            this.i.setVisibility(8);
            this.f36780a.setVisibility(0);
            this.f36780a.setOnClickListener(this);
            textView = this.f36787h;
            str = com.kwad.sdk.core.response.b.a.q(this.o);
        } else {
            this.i.setVisibility(0);
            this.f36780a.setVisibility(8);
            this.f36781b.setOnClickListener(this);
            textView = this.i;
            str = this.o.adBaseInfo.productName;
        }
        textView.setText(str);
        this.p = aVar;
        this.q = bVar;
        KSImageLoader.loadAppIcon(this.f36782c, com.kwad.sdk.core.response.b.a.o(this.o), adTemplate, 16);
        float u = com.kwad.sdk.core.response.b.a.u(this.o);
        if (u >= 3.0f) {
            this.f36783d.setScore(u);
            this.f36783d.setVisibility(0);
        } else {
            this.f36783d.setVisibility(8);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.o);
        if (!TextUtils.isEmpty(t)) {
            this.f36784e.setText(t);
            this.f36784e.setVisibility(0);
        } else {
            this.f36784e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f36785f.getLayoutParams();
        layoutParams.width = i;
        this.f36785f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.b.a.n(this.o));
        this.k.a(com.kwad.sdk.core.response.b.a.w(this.o), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.q;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        this.f36786g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.q, view == this.k);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.n, new a.InterfaceC0393a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                if (ActionBarLandscapeVertical.this.p != null) {
                    ActionBarLandscapeVertical.this.p.a();
                }
            }
        }, this.q);
    }
}
