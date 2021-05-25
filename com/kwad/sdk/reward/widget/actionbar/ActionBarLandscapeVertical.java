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
public class ActionBarLandscapeVertical extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f33807a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33808b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33809c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f33810d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33811e;

    /* renamed from: f  reason: collision with root package name */
    public View f33812f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f33813g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33814h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f33815i;
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

    public ActionBarLandscapeVertical(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.ksad_video_actionbar_landscape_vertical, this);
        this.f33807a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f33808b = (ViewGroup) findViewById(R.id.ksad_top_outer);
        this.f33809c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f33810d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f33811e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f33812f = findViewById(R.id.ksad_video_place_holder);
        this.f33813g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.f33814h = (TextView) findViewById(R.id.ksad_app_name);
        this.f33815i = (TextView) findViewById(R.id.ksad_product_name);
        this.j = (TextView) findViewById(R.id.ksad_app_desc);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
        this.k.setTextColor(-1);
        this.l = findViewById(R.id.ksad_app_download_btn_cover);
        this.k.setOnClickListener(this);
        this.m = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.r == null) {
            this.r = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.u(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(ActionBarLandscapeVertical.this.n), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.u(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.j(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }
            };
        }
        return this.r;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i2) {
        TextView textView;
        String str;
        this.n = adTemplate;
        this.o = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.m.a(adTemplate);
        if (com.kwad.sdk.core.response.b.a.v(this.o)) {
            this.f33815i.setVisibility(8);
            this.f33807a.setVisibility(0);
            this.f33807a.setOnClickListener(this);
            textView = this.f33814h;
            str = com.kwad.sdk.core.response.b.a.o(this.o);
        } else {
            this.f33815i.setVisibility(0);
            this.f33807a.setVisibility(8);
            this.f33808b.setOnClickListener(this);
            textView = this.f33815i;
            str = this.o.adBaseInfo.productName;
        }
        textView.setText(str);
        this.p = aVar;
        this.q = bVar;
        KSImageLoader.loadAppIcon(this.f33809c, com.kwad.sdk.core.response.b.a.n(this.o), adTemplate, 16);
        float s = com.kwad.sdk.core.response.b.a.s(this.o);
        if (s >= 3.0f) {
            this.f33810d.setScore(s);
            this.f33810d.setVisibility(0);
        } else {
            this.f33810d.setVisibility(8);
        }
        String r = com.kwad.sdk.core.response.b.a.r(this.o);
        if (!TextUtils.isEmpty(r)) {
            this.f33811e.setText(r);
            this.f33811e.setVisibility(0);
        } else {
            this.f33811e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f33812f.getLayoutParams();
        layoutParams.width = i2;
        this.f33812f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.b.a.m(this.o));
        this.k.a(com.kwad.sdk.core.response.b.a.u(this.o), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.q;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        this.f33813g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.n, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                if (ActionBarLandscapeVertical.this.p != null) {
                    ActionBarLandscapeVertical.this.p.a();
                }
            }
        }, this.q, view == this.k);
    }
}
