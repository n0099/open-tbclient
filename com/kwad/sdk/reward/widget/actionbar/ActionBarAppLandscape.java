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
/* loaded from: classes4.dex */
public class ActionBarAppLandscape extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57828b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57829c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f57830d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57831e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f57832f;

    /* renamed from: g  reason: collision with root package name */
    public View f57833g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f57834h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f57835i;

    /* renamed from: j  reason: collision with root package name */
    public a f57836j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z);
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
        this.a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f57828b = (TextView) findViewById(R.id.ksad_app_title);
        this.f57829c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f57830d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f57831e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f57832f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f57832f.setTextColor(-1);
        this.f57833g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2116a(view.getContext()).a(this.f57834h).a(this.k).a(view == this.f57832f).a(view == this.f57833g ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarAppLandscape.this.f57836j != null) {
                    ActionBarAppLandscape.this.f57836j.a(z);
                }
            }
        }));
    }

    private void b() {
        float x = com.kwad.sdk.core.response.a.a.x(this.f57835i);
        boolean z = x >= 3.0f;
        if (z) {
            this.f57830d.setScore(x);
            this.f57830d.setVisibility(0);
        }
        String w = com.kwad.sdk.core.response.a.a.w(this.f57835i);
        boolean isEmpty = true ^ TextUtils.isEmpty(w);
        if (isEmpty) {
            this.f57831e.setText(w);
            this.f57831e.setVisibility(0);
        }
        if (isEmpty || z) {
            this.f57829c.setVisibility(8);
            return;
        }
        this.f57829c.setText(com.kwad.sdk.core.response.a.a.s(this.f57835i));
        this.f57830d.setVisibility(8);
        this.f57831e.setVisibility(8);
        this.f57829c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    ActionBarAppLandscape.this.f57832f.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    ActionBarAppLandscape.this.f57833g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppLandscape.this.f57832f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppLandscape.this.f57835i), 0);
                    ActionBarAppLandscape.this.f57833g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f57832f.a(com.kwad.sdk.core.response.a.a.a(ActionBarAppLandscape.this.f57834h), 0);
                    ActionBarAppLandscape.this.f57833g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppLandscape.this.f57832f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppLandscape.this.f57835i), 0);
                    ActionBarAppLandscape.this.f57833g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppLandscape.this.f57832f.a(com.kwad.sdk.core.response.a.a.m(ActionBarAppLandscape.this.f57835i), 0);
                    ActionBarAppLandscape.this.f57833g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppLandscape.this.f57832f.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    ActionBarAppLandscape.this.f57833g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f57834h = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57835i = j2;
        this.f57836j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.au(j2), adTemplate, 12);
        this.f57828b.setText(com.kwad.sdk.core.response.a.a.t(this.f57835i));
        b();
        this.f57832f.a(com.kwad.sdk.core.response.a.a.A(this.f57835i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.f57833g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f57834h)) {
            a(view, false);
        }
    }

    public b getApkDownloadHelper() {
        return this.k;
    }
}
