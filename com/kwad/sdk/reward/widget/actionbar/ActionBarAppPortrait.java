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
    public ImageView f34617a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34618b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34619c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f34620d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34621e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f34622f;

    /* renamed from: g  reason: collision with root package name */
    public View f34623g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f34624h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f34625i;
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
        this.f34617a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f34618b = (TextView) findViewById(R.id.ksad_app_title);
        this.f34619c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f34620d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f34621e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f34622f = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
        this.f34622f.setTextColor(-1);
        this.f34623g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        String r = com.kwad.sdk.core.response.b.a.r(this.f34625i);
        boolean z = !TextUtils.isEmpty(r);
        float s = com.kwad.sdk.core.response.b.a.s(this.f34625i);
        boolean z2 = s >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.f34618b.getLayoutParams()).bottomMargin = an.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f34620d.getLayoutParams()).bottomMargin = an.a(getContext(), 1.0f);
            this.f34621e.setText(r);
            this.f34621e.setVisibility(0);
            this.f34620d.setVisibility(0);
            this.f34620d.setScore(s);
        } else if (z) {
            this.f34621e.setText(r);
            this.f34621e.setVisibility(0);
            this.f34620d.setVisibility(8);
        } else if (!z2) {
            this.f34619c.setText(com.kwad.sdk.core.response.b.a.m(this.f34625i));
            this.f34621e.setVisibility(8);
            this.f34620d.setVisibility(8);
            this.f34619c.setVisibility(0);
            return;
        } else {
            this.f34621e.setVisibility(8);
            this.f34620d.setScore(s);
            this.f34620d.setVisibility(0);
        }
        this.f34619c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    ActionBarAppPortrait.this.f34622f.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                    ActionBarAppPortrait.this.f34623g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f34622f.a(com.kwad.sdk.core.response.b.a.u(ActionBarAppPortrait.this.f34625i), 0);
                    ActionBarAppPortrait.this.f34623g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f34622f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppPortrait.this.f34624h), 0);
                    ActionBarAppPortrait.this.f34623g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f34622f.a(com.kwad.sdk.core.response.b.a.u(ActionBarAppPortrait.this.f34625i), 0);
                    ActionBarAppPortrait.this.f34623g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f34622f.a(com.kwad.sdk.core.response.b.a.j(ActionBarAppPortrait.this.f34625i), 0);
                    ActionBarAppPortrait.this.f34623g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppPortrait.this.f34622f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    ActionBarAppPortrait.this.f34623g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f34624h = adTemplate;
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f34625i = g2;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f34617a, com.kwad.sdk.core.response.b.a.n(g2), adTemplate, 12);
        this.f34618b.setText(com.kwad.sdk.core.response.b.a.o(this.f34625i));
        b();
        this.f34622f.a(com.kwad.sdk.core.response.b.a.u(this.f34625i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f34622f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34624h, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                if (ActionBarAppPortrait.this.j != null) {
                    ActionBarAppPortrait.this.j.a();
                }
            }
        }, this.k, view == this.f34622f);
    }
}
