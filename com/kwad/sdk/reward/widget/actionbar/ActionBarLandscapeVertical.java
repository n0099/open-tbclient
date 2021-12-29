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
public class ActionBarLandscapeVertical extends FrameLayout implements d {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59909b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59910c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f59911d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59912e;

    /* renamed from: f  reason: collision with root package name */
    public View f59913f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f59914g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59915h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59916i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f59917j;

    /* renamed from: k  reason: collision with root package name */
    public TextProgressBar f59918k;
    public View l;
    public KsLogoView m;
    public AdTemplate n;
    public AdInfo o;
    public a p;
    public b q;
    public KsAppDownloadListener r;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
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
        this.a = (ViewGroup) findViewById(R.id.ksad_top_container);
        this.f59909b = (ViewGroup) findViewById(R.id.ksad_top_outer);
        this.f59910c = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f59911d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f59912e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f59913f = findViewById(R.id.ksad_video_place_holder);
        this.f59914g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
        this.f59915h = (TextView) findViewById(R.id.ksad_app_name);
        this.f59916i = (TextView) findViewById(R.id.ksad_product_name);
        this.f59917j = (TextView) findViewById(R.id.ksad_app_desc);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f59918k = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f59918k.setTextColor(-1);
        View findViewById = findViewById(R.id.ksad_app_download_btn_cover);
        this.l = findViewById;
        new f(findViewById, this);
        this.m = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.r == null) {
            this.r = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    ActionBarLandscapeVertical.this.f59918k.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarLandscapeVertical.this.f59918k.a(com.kwad.sdk.core.response.a.a.A(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarLandscapeVertical.this.f59918k.a(com.kwad.sdk.core.response.a.a.a(ActionBarLandscapeVertical.this.n), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarLandscapeVertical.this.f59918k.a(com.kwad.sdk.core.response.a.a.A(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarLandscapeVertical.this.f59918k.a(com.kwad.sdk.core.response.a.a.m(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarLandscapeVertical.this.f59918k.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }
            };
        }
        return this.r;
    }

    public void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.n).a(this.q).a(view == this.f59918k).a(view == this.l ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarLandscapeVertical.this.p != null) {
                    ActionBarLandscapeVertical.this.p.a(z);
                }
            }
        }));
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i2) {
        TextView textView;
        String str;
        this.n = adTemplate;
        this.o = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.m.a(adTemplate);
        if (com.kwad.sdk.core.response.a.a.B(this.o)) {
            this.f59916i.setVisibility(8);
            this.a.setVisibility(0);
            new f(this.a, this);
            textView = this.f59915h;
            str = com.kwad.sdk.core.response.a.a.t(this.o);
        } else {
            this.f59916i.setVisibility(0);
            this.a.setVisibility(8);
            new f(this.f59909b, this);
            textView = this.f59916i;
            str = this.o.adBaseInfo.productName;
        }
        textView.setText(str);
        this.p = aVar;
        this.q = bVar;
        KSImageLoader.loadAppIcon(this.f59910c, com.kwad.sdk.core.response.a.a.au(this.o), adTemplate, 16);
        float x = com.kwad.sdk.core.response.a.a.x(this.o);
        if (x >= 3.0f) {
            this.f59911d.setScore(x);
            this.f59911d.setVisibility(0);
        } else {
            this.f59911d.setVisibility(8);
        }
        String w = com.kwad.sdk.core.response.a.a.w(this.o);
        if (!TextUtils.isEmpty(w)) {
            this.f59912e.setText(w);
            this.f59912e.setVisibility(0);
        } else {
            this.f59912e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f59913f.getLayoutParams();
        layoutParams.width = i2;
        this.f59913f.setLayoutParams(layoutParams);
        this.f59917j.setText(com.kwad.sdk.core.response.a.a.s(this.o));
        this.f59918k.a(com.kwad.sdk.core.response.a.a.A(this.o), this.f59918k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.q;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        new f(this.f59914g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.n)) {
            a(view, false);
        }
    }
}
