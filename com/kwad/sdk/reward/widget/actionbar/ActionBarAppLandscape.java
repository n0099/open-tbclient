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
    public ImageView f36466a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36467b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36468c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f36469d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36470e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f36471f;

    /* renamed from: g  reason: collision with root package name */
    public View f36472g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f36473h;
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
        this.f36466a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f36467b = (TextView) findViewById(R.id.ksad_app_title);
        this.f36468c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f36469d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f36470e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f36471f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f36471f.setTextColor(-1);
        this.f36472g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        float u = com.kwad.sdk.core.response.b.a.u(this.i);
        boolean z = u >= 3.0f;
        if (z) {
            this.f36469d.setScore(u);
            this.f36469d.setVisibility(0);
        }
        String t = com.kwad.sdk.core.response.b.a.t(this.i);
        boolean isEmpty = true ^ TextUtils.isEmpty(t);
        if (isEmpty) {
            this.f36470e.setText(t);
            this.f36470e.setVisibility(0);
        }
        if (isEmpty || z) {
            this.f36468c.setVisibility(8);
            return;
        }
        this.f36468c.setText(com.kwad.sdk.core.response.b.a.n(this.i));
        this.f36469d.setVisibility(8);
        this.f36470e.setVisibility(8);
        this.f36468c.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    ActionBarAppLandscape.this.f36471f.a(com.kwad.sdk.core.response.b.a.c(i), i);
                    ActionBarAppLandscape.this.f36472g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppLandscape.this.f36471f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.i), 0);
                    ActionBarAppLandscape.this.f36472g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppLandscape.this.f36471f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppLandscape.this.f36473h), 0);
                    ActionBarAppLandscape.this.f36472g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppLandscape.this.f36471f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppLandscape.this.i), 0);
                    ActionBarAppLandscape.this.f36472g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppLandscape.this.f36471f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarAppLandscape.this.f36472g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.f36471f.a(com.kwad.sdk.core.response.b.a.a(i), i);
                    ActionBarAppLandscape.this.f36472g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f36473h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = j;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f36466a, com.kwad.sdk.core.response.b.a.o(j), adTemplate, 12);
        this.f36467b.setText(com.kwad.sdk.core.response.b.a.q(this.i));
        b();
        this.f36471f.a(com.kwad.sdk.core.response.b.a.w(this.i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f36471f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.k, view == this.f36472g);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36473h, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (ActionBarAppLandscape.this.j != null) {
                    ActionBarAppLandscape.this.j.a();
                }
            }
        }, this.k);
    }
}
