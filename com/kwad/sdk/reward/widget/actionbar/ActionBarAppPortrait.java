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
public class ActionBarAppPortrait extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f33791a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33792b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33793c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f33794d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33795e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f33796f;

    /* renamed from: g  reason: collision with root package name */
    public View f33797g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f33798h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f33799i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
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
        this.f33791a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f33792b = (TextView) findViewById(R.id.ksad_app_title);
        this.f33793c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f33794d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f33795e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f33796f = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
        this.f33796f.setTextColor(-1);
        this.f33797g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        String r = com.kwad.sdk.core.response.b.a.r(this.f33799i);
        boolean z = !TextUtils.isEmpty(r);
        float s = com.kwad.sdk.core.response.b.a.s(this.f33799i);
        boolean z2 = s >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.f33792b.getLayoutParams()).bottomMargin = an.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f33794d.getLayoutParams()).bottomMargin = an.a(getContext(), 1.0f);
            this.f33795e.setText(r);
            this.f33795e.setVisibility(0);
            this.f33794d.setVisibility(0);
            this.f33794d.setScore(s);
        } else if (z) {
            this.f33795e.setText(r);
            this.f33795e.setVisibility(0);
            this.f33794d.setVisibility(8);
        } else if (!z2) {
            this.f33793c.setText(com.kwad.sdk.core.response.b.a.m(this.f33799i));
            this.f33795e.setVisibility(8);
            this.f33794d.setVisibility(8);
            this.f33793c.setVisibility(0);
            return;
        } else {
            this.f33795e.setVisibility(8);
            this.f33794d.setScore(s);
            this.f33794d.setVisibility(0);
        }
        this.f33793c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    ActionBarAppPortrait.this.f33796f.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    ActionBarAppPortrait.this.f33797g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f33796f.a(com.kwad.sdk.core.response.b.a.u(ActionBarAppPortrait.this.f33799i), 0);
                    ActionBarAppPortrait.this.f33797g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f33796f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppPortrait.this.f33798h), 0);
                    ActionBarAppPortrait.this.f33797g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f33796f.a(com.kwad.sdk.core.response.b.a.u(ActionBarAppPortrait.this.f33799i), 0);
                    ActionBarAppPortrait.this.f33797g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f33796f.a(com.kwad.sdk.core.response.b.a.j(ActionBarAppPortrait.this.f33799i), 0);
                    ActionBarAppPortrait.this.f33797g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppPortrait.this.f33796f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    ActionBarAppPortrait.this.f33797g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f33798h = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33799i = g2;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f33791a, com.kwad.sdk.core.response.b.a.n(g2), adTemplate, 12);
        this.f33792b.setText(com.kwad.sdk.core.response.b.a.o(this.f33799i));
        b();
        this.f33796f.a(com.kwad.sdk.core.response.b.a.u(this.f33799i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f33796f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33798h, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                if (ActionBarAppPortrait.this.j != null) {
                    ActionBarAppPortrait.this.j.a();
                }
            }
        }, this.k, view == this.f33796f);
    }
}
