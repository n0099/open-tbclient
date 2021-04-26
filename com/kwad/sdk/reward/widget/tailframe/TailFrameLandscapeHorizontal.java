package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TailFrameLandscapeHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f34655a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f34656b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f34657c;

    /* renamed from: d  reason: collision with root package name */
    public b f34658d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34659e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34660f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f34661g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34662h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f34663i;
    public KsLogoView j;

    public TailFrameLandscapeHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
        this.f34655a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f34660f)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f34657c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f34659e);
            this.f34657c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f34656b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f34659e);
        this.f34656b.setVisibility(0);
        this.f34663i = this.f34656b.getTextProgressBar();
        e();
        this.f34663i.setOnClickListener(this);
    }

    private void e() {
        this.f34662h = new com.kwad.sdk.core.download.b.b(this.f34659e, this.f34661g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                super.a(i2);
                TailFrameLandscapeHorizontal.this.f34656b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f34659e));
                TailFrameLandscapeHorizontal.this.f34663i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f34656b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f34659e));
                TailFrameLandscapeHorizontal.this.f34663i.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeHorizontal.this.f34660f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f34656b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f34659e));
                TailFrameLandscapeHorizontal.this.f34663i.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeHorizontal.this.f34659e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f34656b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f34659e));
                TailFrameLandscapeHorizontal.this.f34663i.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeHorizontal.this.f34660f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f34656b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f34659e));
                TailFrameLandscapeHorizontal.this.f34663i.a(com.kwad.sdk.core.response.b.a.j(TailFrameLandscapeHorizontal.this.f34660f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeHorizontal.this.f34656b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f34659e));
                TailFrameLandscapeHorizontal.this.f34663i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f34662h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f34659e = adTemplate;
        this.f34660f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f34661g = jSONObject;
        this.f34658d = bVar;
        this.j.a(this.f34659e);
        KSImageLoader.loadImage(this.f34655a, com.kwad.sdk.core.response.b.a.f(this.f34660f), this.f34659e);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f34656b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f34656b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f34657c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f34657c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34659e, new a.InterfaceC0376a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                if (TailFrameLandscapeHorizontal.this.f34658d != null) {
                    TailFrameLandscapeHorizontal.this.f34658d.a();
                }
            }
        }, this.f34662h, view == this.f34663i);
    }
}
