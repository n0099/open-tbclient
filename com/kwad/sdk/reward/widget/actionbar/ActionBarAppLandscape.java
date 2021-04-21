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
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class ActionBarAppLandscape extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36850a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36851b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36852c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f36853d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36854e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f36855f;

    /* renamed from: g  reason: collision with root package name */
    public View f36856g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f36857h;
    public AdInfo i;
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

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
        this.f36850a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f36851b = (TextView) findViewById(R.id.ksad_app_title);
        this.f36852c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f36853d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f36854e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f36855f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f36855f.setTextColor(-1);
        this.f36856g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        float u = com.kwad.sdk.core.response.b.a.u(this.i);
        boolean z = u >= 3.0f;
        if (z) {
            this.f36853d.setScore(u);
            this.f36853d.setVisibility(0);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.i);
        boolean isEmpty = true ^ TextUtils.isEmpty(t);
        if (isEmpty) {
            this.f36854e.setText(t);
            this.f36854e.setVisibility(0);
        }
        if (isEmpty || z) {
            this.f36852c.setVisibility(8);
            return;
        }
        this.f36852c.setText(com.kwad.sdk.core.response.b.a.n(this.i));
        this.f36853d.setVisibility(8);
        this.f36854e.setVisibility(8);
        this.f36852c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    ActionBarAppLandscape.this.f36855f.a(com.kwad.sdk.core.response.b.a.c(i), i);
                    ActionBarAppLandscape.this.f36856g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppLandscape.this.f36855f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.i), 0);
                    ActionBarAppLandscape.this.f36856g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f36855f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppLandscape.this.f36857h), 0);
                    ActionBarAppLandscape.this.f36856g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppLandscape.this.f36855f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.i), 0);
                    ActionBarAppLandscape.this.f36856g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppLandscape.this.f36855f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarAppLandscape.this.f36856g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.f36855f.a(com.kwad.sdk.core.response.b.a.a(i), i);
                    ActionBarAppLandscape.this.f36856g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f36857h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = j;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f36850a, com.kwad.sdk.core.response.b.a.o(j), adTemplate, 12);
        this.f36851b.setText(com.kwad.sdk.core.response.b.a.q(this.i));
        b();
        this.f36855f.a(com.kwad.sdk.core.response.b.a.w(this.i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f36855f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.k, view == this.f36856g);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36857h, new a.InterfaceC0396a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
            public void a() {
                if (ActionBarAppLandscape.this.j != null) {
                    ActionBarAppLandscape.this.j.a();
                }
            }
        }, this.k);
    }
}
