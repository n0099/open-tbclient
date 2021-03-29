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
public class ActionBarAppPortrait extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36476a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36477b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36478c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f36479d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36480e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f36481f;

    /* renamed from: g  reason: collision with root package name */
    public View f36482g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f36483h;
    public AdInfo i;
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

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.f36476a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f36477b = (TextView) findViewById(R.id.ksad_app_title);
        this.f36478c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f36479d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f36480e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f36481f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f36481f.setTextColor(-1);
        this.f36482g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        String t = com.kwad.sdk.core.response.b.a.t(this.i);
        boolean z = !TextUtils.isEmpty(t);
        float u = com.kwad.sdk.core.response.b.a.u(this.i);
        boolean z2 = u >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.f36477b.getLayoutParams()).bottomMargin = ao.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f36479d.getLayoutParams()).bottomMargin = ao.a(getContext(), 1.0f);
            this.f36480e.setText(t);
            this.f36480e.setVisibility(0);
            this.f36479d.setVisibility(0);
            this.f36479d.setScore(u);
        } else if (z) {
            this.f36480e.setText(t);
            this.f36480e.setVisibility(0);
            this.f36479d.setVisibility(8);
        } else if (!z2) {
            this.f36478c.setText(com.kwad.sdk.core.response.b.a.n(this.i));
            this.f36480e.setVisibility(8);
            this.f36479d.setVisibility(8);
            this.f36478c.setVisibility(0);
            return;
        } else {
            this.f36480e.setVisibility(8);
            this.f36479d.setScore(u);
            this.f36479d.setVisibility(0);
        }
        this.f36478c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i) {
                    ActionBarAppPortrait.this.f36481f.a(com.kwad.sdk.core.response.b.a.c(i), i);
                    ActionBarAppPortrait.this.f36482g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f36481f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.f36482g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f36481f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppPortrait.this.f36483h), 0);
                    ActionBarAppPortrait.this.f36482g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f36481f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.f36482g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f36481f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarAppPortrait.this.f36482g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.f36481f.a(com.kwad.sdk.core.response.b.a.a(i), i);
                    ActionBarAppPortrait.this.f36482g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f36483h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.i = j;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f36476a, com.kwad.sdk.core.response.b.a.o(j), adTemplate, 12);
        this.f36477b.setText(com.kwad.sdk.core.response.b.a.q(this.i));
        b();
        this.f36481f.a(com.kwad.sdk.core.response.b.a.w(this.i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f36481f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.k, view == this.f36481f);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36483h, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                if (ActionBarAppPortrait.this.j != null) {
                    ActionBarAppPortrait.this.j.a();
                }
            }
        }, this.k);
    }
}
