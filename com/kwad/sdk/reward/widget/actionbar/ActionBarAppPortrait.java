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
import com.baidu.tieba.R;
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
/* loaded from: classes8.dex */
public class ActionBarAppPortrait extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f56189b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56190c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f56191d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56192e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f56193f;

    /* renamed from: g  reason: collision with root package name */
    public View f56194g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f56195h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f56196i;

    /* renamed from: j  reason: collision with root package name */
    public a f56197j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes8.dex */
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
        this.f56189b = (TextView) findViewById(R.id.ksad_app_title);
        this.f56190c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f56191d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f56192e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f56193f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f56193f.setTextColor(-1);
        this.f56194g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C2095a(view.getContext()).a(this.f56195h).a(this.k).a(view == this.f56193f).a(view == this.f56194g ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarAppPortrait.this.f56197j != null) {
                    ActionBarAppPortrait.this.f56197j.a(z);
                }
            }
        }));
    }

    private void b() {
        String w = com.kwad.sdk.core.response.a.a.w(this.f56196i);
        boolean z = !TextUtils.isEmpty(w);
        float x = com.kwad.sdk.core.response.a.a.x(this.f56196i);
        boolean z2 = x >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.f56189b.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f56191d.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            this.f56192e.setText(w);
            this.f56192e.setVisibility(0);
            this.f56191d.setVisibility(0);
            this.f56191d.setScore(x);
        } else if (z) {
            this.f56192e.setText(w);
            this.f56192e.setVisibility(0);
            this.f56191d.setVisibility(8);
        } else if (!z2) {
            this.f56190c.setText(com.kwad.sdk.core.response.a.a.s(this.f56196i));
            this.f56192e.setVisibility(8);
            this.f56191d.setVisibility(8);
            this.f56190c.setVisibility(0);
            return;
        } else {
            this.f56192e.setVisibility(8);
            this.f56191d.setScore(x);
            this.f56191d.setVisibility(0);
        }
        this.f56190c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i2) {
                    ActionBarAppPortrait.this.f56193f.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                    ActionBarAppPortrait.this.f56194g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f56193f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.f56196i), 0);
                    ActionBarAppPortrait.this.f56194g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f56193f.a(com.kwad.sdk.core.response.a.a.a(ActionBarAppPortrait.this.f56195h), 0);
                    ActionBarAppPortrait.this.f56194g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f56193f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.f56196i), 0);
                    ActionBarAppPortrait.this.f56194g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f56193f.a(com.kwad.sdk.core.response.a.a.m(ActionBarAppPortrait.this.f56196i), 0);
                    ActionBarAppPortrait.this.f56194g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppPortrait.this.f56193f.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                    ActionBarAppPortrait.this.f56194g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f56195h = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f56196i = j2;
        this.f56197j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.au(j2), adTemplate, 12);
        this.f56189b.setText(com.kwad.sdk.core.response.a.a.at(this.f56196i));
        b();
        this.f56193f.a(com.kwad.sdk.core.response.a.a.A(this.f56196i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.f56194g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f56195h)) {
            a(view, false);
        }
    }

    public b getApkDownloadHelper() {
        return this.k;
    }
}
