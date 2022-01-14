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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes3.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements d {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57653b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57654c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f57655d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57656e;

    /* renamed from: f  reason: collision with root package name */
    public View f57657f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f57658g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57659h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57660i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f57661j;
    public TextProgressBar k;
    public View l;
    public AdTemplate m;
    public AdInfo n;
    public a o;
    public b p;
    public KsAppDownloadListener q;
    public KsLogoView r;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
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
        this.a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f57653b = (ViewGroup) findViewById(R.id.ksad_top_container_product);
        this.f57654c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f57655d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f57656e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f57657f = findViewById(R.id.ksad_video_place_holder);
        this.f57658g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.f57659h = (TextView) findViewById(R.id.ksad_app_name);
        this.f57660i = (TextView) findViewById(R.id.ksad_product_name);
        this.f57661j = (TextView) findViewById(R.id.ksad_app_desc);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.k.setTextColor(-1);
        View findViewById = findViewById(R.id.ksad_app_download_btn_cover);
        this.l = findViewById;
        new f(findViewById, this);
        this.r = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.q == null) {
            this.q = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.A(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.a(ActionBarPortraitHorizontal.this.m), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.A(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.m(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }
            };
        }
        return this.q;
    }

    public void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2100a(view.getContext()).a(this.m).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarPortraitHorizontal.this.o != null) {
                    ActionBarPortraitHorizontal.this.o.a(z);
                }
            }
        }).a(this.p).a(view == this.k).a(view == this.l ? 1 : 2));
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i2) {
        this.m = adTemplate;
        this.r.a(adTemplate);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.m);
        this.n = j2;
        if (com.kwad.sdk.core.response.a.a.B(j2)) {
            this.f57653b.setVisibility(8);
            this.a.setVisibility(0);
            new f(this.a, this);
            this.f57659h.setText(com.kwad.sdk.core.response.a.a.t(this.n));
        } else {
            this.f57653b.setVisibility(0);
            this.a.setVisibility(8);
            this.f57660i.setText(this.n.adBaseInfo.productName);
            new f(this.f57653b, this);
        }
        new f(this.k, this);
        this.o = aVar;
        this.p = bVar;
        KSImageLoader.loadAppIcon(this.f57654c, com.kwad.sdk.core.response.a.a.au(this.n), adTemplate, 16);
        float x = com.kwad.sdk.core.response.a.a.x(this.n);
        if (x >= 3.0f) {
            this.f57655d.setScore(x);
            this.f57655d.setVisibility(0);
        } else {
            this.f57655d.setVisibility(8);
        }
        String w = com.kwad.sdk.core.response.a.a.w(this.n);
        if (!TextUtils.isEmpty(w)) {
            this.f57656e.setText(w);
            this.f57656e.setVisibility(0);
        } else {
            this.f57656e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f57657f.getLayoutParams();
        layoutParams.height = i2;
        this.f57657f.setLayoutParams(layoutParams);
        this.f57661j.setText(com.kwad.sdk.core.response.a.a.s(this.n));
        this.k.a(com.kwad.sdk.core.response.a.a.A(this.n), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        new f(this.f57658g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.m)) {
            a(view, false);
        }
    }
}
