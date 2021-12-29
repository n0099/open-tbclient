package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes3.dex */
public class ActionBarAppPortrait extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59893b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59894c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f59895d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59896e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f59897f;

    /* renamed from: g  reason: collision with root package name */
    public View f59898g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f59899h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f59900i;

    /* renamed from: j  reason: collision with root package name */
    public a f59901j;

    /* renamed from: k  reason: collision with root package name */
    public b f59902k;
    public KsAppDownloadListener l;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f59893b = (TextView) findViewById(R.id.ksad_app_title);
        this.f59894c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f59895d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f59896e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f59897f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f59897f.setTextColor(-1);
        this.f59898g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.f59899h).a(this.f59902k).a(view == this.f59897f).a(view == this.f59898g ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarAppPortrait.this.f59901j != null) {
                    ActionBarAppPortrait.this.f59901j.a(z);
                }
            }
        }));
    }

    private void b() {
        String w = com.kwad.sdk.core.response.a.a.w(this.f59900i);
        boolean z = !TextUtils.isEmpty(w);
        float x = com.kwad.sdk.core.response.a.a.x(this.f59900i);
        boolean z2 = x >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.f59893b.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f59895d.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            this.f59896e.setText(w);
            this.f59896e.setVisibility(0);
            this.f59895d.setVisibility(0);
            this.f59895d.setScore(x);
        } else if (z) {
            this.f59896e.setText(w);
            this.f59896e.setVisibility(0);
            this.f59895d.setVisibility(8);
        } else if (!z2) {
            this.f59894c.setText(com.kwad.sdk.core.response.a.a.s(this.f59900i));
            this.f59896e.setVisibility(8);
            this.f59895d.setVisibility(8);
            this.f59894c.setVisibility(0);
            return;
        } else {
            this.f59896e.setVisibility(8);
            this.f59895d.setScore(x);
            this.f59895d.setVisibility(0);
        }
        this.f59894c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    ActionBarAppPortrait.this.f59897f.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    ActionBarAppPortrait.this.f59898g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f59897f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.f59900i), 0);
                    ActionBarAppPortrait.this.f59898g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f59897f.a(com.kwad.sdk.core.response.a.a.a(ActionBarAppPortrait.this.f59899h), 0);
                    ActionBarAppPortrait.this.f59898g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f59897f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.f59900i), 0);
                    ActionBarAppPortrait.this.f59898g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f59897f.a(com.kwad.sdk.core.response.a.a.m(ActionBarAppPortrait.this.f59900i), 0);
                    ActionBarAppPortrait.this.f59898g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppPortrait.this.f59897f.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    ActionBarAppPortrait.this.f59898g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f59899h = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59900i = j2;
        this.f59901j = aVar;
        this.f59902k = bVar;
        KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.au(j2), adTemplate, 12);
        this.f59893b.setText(com.kwad.sdk.core.response.a.a.at(this.f59900i));
        b();
        this.f59897f.a(com.kwad.sdk.core.response.a.a.A(this.f59900i), 0);
        b bVar2 = this.f59902k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.f59898g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f59899h)) {
            a(view, false);
        }
    }

    public b getApkDownloadHelper() {
        return this.f59902k;
    }
}
