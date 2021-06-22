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
/* loaded from: classes7.dex */
public class ActionBarAppLandscape extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37307a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37308b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37309c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f37310d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37311e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f37312f;

    /* renamed from: g  reason: collision with root package name */
    public View f37313g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f37314h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f37315i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes7.dex */
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
        this.f37307a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f37308b = (TextView) findViewById(R.id.ksad_app_title);
        this.f37309c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f37310d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f37311e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f37312f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f37312f.setTextColor(-1);
        this.f37313g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        float u = com.kwad.sdk.core.response.b.a.u(this.f37315i);
        boolean z = u >= 3.0f;
        if (z) {
            this.f37310d.setScore(u);
            this.f37310d.setVisibility(0);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.f37315i);
        boolean isEmpty = true ^ TextUtils.isEmpty(t);
        if (isEmpty) {
            this.f37311e.setText(t);
            this.f37311e.setVisibility(0);
        }
        if (isEmpty || z) {
            this.f37309c.setVisibility(8);
            return;
        }
        this.f37309c.setText(com.kwad.sdk.core.response.b.a.n(this.f37315i));
        this.f37310d.setVisibility(8);
        this.f37311e.setVisibility(8);
        this.f37309c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    ActionBarAppLandscape.this.f37312f.a(com.kwad.sdk.core.response.b.a.c(i2), i2);
                    ActionBarAppLandscape.this.f37313g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppLandscape.this.f37312f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.f37315i), 0);
                    ActionBarAppLandscape.this.f37313g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f37312f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppLandscape.this.f37314h), 0);
                    ActionBarAppLandscape.this.f37313g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppLandscape.this.f37312f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.f37315i), 0);
                    ActionBarAppLandscape.this.f37313g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppLandscape.this.f37312f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarAppLandscape.this.f37313g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppLandscape.this.f37312f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    ActionBarAppLandscape.this.f37313g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f37314h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37315i = j;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f37307a, com.kwad.sdk.core.response.b.a.o(j), adTemplate, 12);
        this.f37308b.setText(com.kwad.sdk.core.response.b.a.q(this.f37315i));
        b();
        this.f37312f.a(com.kwad.sdk.core.response.b.a.w(this.f37315i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f37312f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.k, view == this.f37313g);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37314h, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                if (ActionBarAppLandscape.this.j != null) {
                    ActionBarAppLandscape.this.j.a();
                }
            }
        }, this.k);
    }
}
