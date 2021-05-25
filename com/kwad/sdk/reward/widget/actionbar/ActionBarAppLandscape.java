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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class ActionBarAppLandscape extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f33780a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33781b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33782c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f33783d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33784e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f33785f;

    /* renamed from: g  reason: collision with root package name */
    public View f33786g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f33787h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f33788i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
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
        this.f33780a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f33781b = (TextView) findViewById(R.id.ksad_app_title);
        this.f33782c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f33783d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f33784e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f33785f = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
        this.f33785f.setTextColor(-1);
        this.f33786g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        float s = com.kwad.sdk.core.response.b.a.s(this.f33788i);
        boolean z = s >= 3.0f;
        if (z) {
            this.f33783d.setScore(s);
            this.f33783d.setVisibility(0);
        }
        String r = com.kwad.sdk.core.response.b.a.r(this.f33788i);
        boolean isEmpty = true ^ TextUtils.isEmpty(r);
        if (isEmpty) {
            this.f33784e.setText(r);
            this.f33784e.setVisibility(0);
        }
        if (isEmpty || z) {
            this.f33782c.setVisibility(8);
            return;
        }
        this.f33782c.setText(com.kwad.sdk.core.response.b.a.m(this.f33788i));
        this.f33783d.setVisibility(8);
        this.f33784e.setVisibility(8);
        this.f33782c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    ActionBarAppLandscape.this.f33785f.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    ActionBarAppLandscape.this.f33786g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppLandscape.this.f33785f.a(com.kwad.sdk.core.response.b.a.u(ActionBarAppLandscape.this.f33788i), 0);
                    ActionBarAppLandscape.this.f33786g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f33785f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppLandscape.this.f33787h), 0);
                    ActionBarAppLandscape.this.f33786g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppLandscape.this.f33785f.a(com.kwad.sdk.core.response.b.a.u(ActionBarAppLandscape.this.f33788i), 0);
                    ActionBarAppLandscape.this.f33786g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppLandscape.this.f33785f.a(com.kwad.sdk.core.response.b.a.j(ActionBarAppLandscape.this.f33788i), 0);
                    ActionBarAppLandscape.this.f33786g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppLandscape.this.f33785f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    ActionBarAppLandscape.this.f33786g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f33787h = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33788i = g2;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f33780a, com.kwad.sdk.core.response.b.a.n(g2), adTemplate, 12);
        this.f33781b.setText(com.kwad.sdk.core.response.b.a.o(this.f33788i));
        b();
        this.f33785f.a(com.kwad.sdk.core.response.b.a.u(this.f33788i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f33785f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33787h, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                if (ActionBarAppLandscape.this.j != null) {
                    ActionBarAppLandscape.this.j.a();
                }
            }
        }, this.k, view == this.f33785f);
    }
}
