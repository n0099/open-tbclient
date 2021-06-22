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
public class ActionBarAppPortrait extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37318a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37319b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37320c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f37321d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37322e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f37323f;

    /* renamed from: g  reason: collision with root package name */
    public View f37324g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f37325h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f37326i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes7.dex */
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
        this.f37318a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f37319b = (TextView) findViewById(R.id.ksad_app_title);
        this.f37320c = (TextView) findViewById(R.id.ksad_app_desc);
        this.f37321d = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f37322e = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.f37323f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f37323f.setTextColor(-1);
        this.f37324g = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b() {
        String t = com.kwad.sdk.core.response.b.a.t(this.f37326i);
        boolean z = !TextUtils.isEmpty(t);
        float u = com.kwad.sdk.core.response.b.a.u(this.f37326i);
        boolean z2 = u >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.f37319b.getLayoutParams()).bottomMargin = ao.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f37321d.getLayoutParams()).bottomMargin = ao.a(getContext(), 1.0f);
            this.f37322e.setText(t);
            this.f37322e.setVisibility(0);
            this.f37321d.setVisibility(0);
            this.f37321d.setScore(u);
        } else if (z) {
            this.f37322e.setText(t);
            this.f37322e.setVisibility(0);
            this.f37321d.setVisibility(8);
        } else if (!z2) {
            this.f37320c.setText(com.kwad.sdk.core.response.b.a.n(this.f37326i));
            this.f37322e.setVisibility(8);
            this.f37321d.setVisibility(8);
            this.f37320c.setVisibility(0);
            return;
        } else {
            this.f37322e.setVisibility(8);
            this.f37321d.setScore(u);
            this.f37321d.setVisibility(0);
        }
        this.f37320c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    ActionBarAppPortrait.this.f37323f.a(com.kwad.sdk.core.response.b.a.c(i2), i2);
                    ActionBarAppPortrait.this.f37324g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f37323f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppPortrait.this.f37326i), 0);
                    ActionBarAppPortrait.this.f37324g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f37323f.a(com.kwad.sdk.core.response.b.a.a(ActionBarAppPortrait.this.f37325h), 0);
                    ActionBarAppPortrait.this.f37324g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f37323f.a(com.kwad.sdk.core.response.b.a.w(ActionBarAppPortrait.this.f37326i), 0);
                    ActionBarAppPortrait.this.f37324g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f37323f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                    ActionBarAppPortrait.this.f37324g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    ActionBarAppPortrait.this.f37323f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                    ActionBarAppPortrait.this.f37324g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f37325h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37326i = j;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.f37318a, com.kwad.sdk.core.response.b.a.o(j), adTemplate, 12);
        this.f37319b.setText(com.kwad.sdk.core.response.b.a.q(this.f37326i));
        b();
        this.f37323f.a(com.kwad.sdk.core.response.b.a.w(this.f37326i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setOnClickListener(this);
        this.f37323f.setOnClickListener(this);
    }

    public b getApkDownloadHelper() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(this.k, view == this.f37323f);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37325h, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                if (ActionBarAppPortrait.this.j != null) {
                    ActionBarAppPortrait.this.j.a();
                }
            }
        }, this.k);
    }
}
