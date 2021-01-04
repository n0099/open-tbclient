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
/* loaded from: classes5.dex */
public class ActionBarAppLandscape extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f10957a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f10958b;
    private TextView c;
    private AppScoreView d;
    private TextView e;
    private TextProgressBar f;
    private View g;
    private AdTemplate h;
    private AdInfo i;
    private a j;
    private b k;
    private KsAppDownloadListener l;

    /* loaded from: classes5.dex */
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
        inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
        this.f10957a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f10958b = (TextView) findViewById(R.id.ksad_app_title);
        this.c = (TextView) findViewById(R.id.ksad_app_desc);
        this.d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.e = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f.setTextDimen(ao.a(getContext(), 16.0f));
        this.f.setTextColor(-1);
        this.g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        float u = com.kwad.sdk.core.response.b.a.u(this.i);
        boolean z = u >= 3.0f;
        if (z) {
            this.d.setScore(u);
            this.d.setVisibility(0);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.i);
        boolean z2 = TextUtils.isEmpty(t) ? false : true;
        if (z2) {
            this.e.setText(t);
            this.e.setVisibility(0);
        }
        if (z2 || z) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setText(com.kwad.sdk.core.response.b.a.n(this.i));
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    ActionBarAppLandscape.this.f.a(com.kwad.sdk.core.response.b.a.c(i), i);
                    ActionBarAppLandscape.this.g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppLandscape.this.f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.i), 0);
                    ActionBarAppLandscape.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppLandscape.this.h), 0);
                    ActionBarAppLandscape.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppLandscape.this.f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.i), 0);
                    ActionBarAppLandscape.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppLandscape.this.f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarAppLandscape.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.f.a(com.kwad.sdk.core.response.b.a.a(i), i);
                    ActionBarAppLandscape.this.g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.h = adTemplate;
        this.i = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f10957a, com.kwad.sdk.core.response.b.a.o(this.i), adTemplate, 12);
        this.f10958b.setText(com.kwad.sdk.core.response.b.a.q(this.i));
        b();
        this.f.a(com.kwad.sdk.core.response.b.a.w(this.i), 0);
        if (this.k != null) {
            this.k.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.k, view == this.g);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.h, new a.InterfaceC1064a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
            public void a() {
                if (ActionBarAppLandscape.this.j != null) {
                    ActionBarAppLandscape.this.j.a();
                }
            }
        }, this.k);
    }
}
