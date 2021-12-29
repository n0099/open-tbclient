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
public class ActionBarAppLandscape extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59881b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59882c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f59883d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59884e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f59885f;

    /* renamed from: g  reason: collision with root package name */
    public View f59886g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f59887h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f59888i;

    /* renamed from: j  reason: collision with root package name */
    public a f59889j;

    /* renamed from: k  reason: collision with root package name */
    public b f59890k;
    public KsAppDownloadListener l;

    /* loaded from: classes3.dex */
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
        this.f59881b = (TextView) findViewById(R.id.ksad_app_title);
        this.f59882c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f59883d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f59884e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f59885f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f59885f.setTextColor(-1);
        this.f59886g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.f59887h).a(this.f59890k).a(view == this.f59885f).a(view == this.f59886g ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarAppLandscape.this.f59889j != null) {
                    ActionBarAppLandscape.this.f59889j.a(z);
                }
            }
        }));
    }

    private void b() {
        float x = com.kwad.sdk.core.response.a.a.x(this.f59888i);
        boolean z = x >= 3.0f;
        if (z) {
            this.f59883d.setScore(x);
            this.f59883d.setVisibility(0);
        }
        String w = com.kwad.sdk.core.response.a.a.w(this.f59888i);
        boolean isEmpty = true ^ TextUtils.isEmpty(w);
        if (isEmpty) {
            this.f59884e.setText(w);
            this.f59884e.setVisibility(0);
        }
        if (isEmpty || z) {
            this.f59882c.setVisibility(8);
            return;
        }
        this.f59882c.setText(com.kwad.sdk.core.response.a.a.s(this.f59888i));
        this.f59883d.setVisibility(8);
        this.f59884e.setVisibility(8);
        this.f59882c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    ActionBarAppLandscape.this.f59885f.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    ActionBarAppLandscape.this.f59886g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppLandscape.this.f59885f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppLandscape.this.f59888i), 0);
                    ActionBarAppLandscape.this.f59886g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f59885f.a(com.kwad.sdk.core.response.a.a.a(ActionBarAppLandscape.this.f59887h), 0);
                    ActionBarAppLandscape.this.f59886g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppLandscape.this.f59885f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppLandscape.this.f59888i), 0);
                    ActionBarAppLandscape.this.f59886g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppLandscape.this.f59885f.a(com.kwad.sdk.core.response.a.a.m(ActionBarAppLandscape.this.f59888i), 0);
                    ActionBarAppLandscape.this.f59886g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppLandscape.this.f59885f.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    ActionBarAppLandscape.this.f59886g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f59887h = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59888i = j2;
        this.f59889j = aVar;
        this.f59890k = bVar;
        KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.au(j2), adTemplate, 12);
        this.f59881b.setText(com.kwad.sdk.core.response.a.a.t(this.f59888i));
        b();
        this.f59885f.a(com.kwad.sdk.core.response.a.a.A(this.f59888i), 0);
        b bVar2 = this.f59890k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.f59886g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f59887h)) {
            a(view, false);
        }
    }

    public b getApkDownloadHelper() {
        return this.f59890k;
    }
}
