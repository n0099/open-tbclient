package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TailFrameLandscapeVertical extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57720b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57721c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f57722d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f57723e;

    /* renamed from: f  reason: collision with root package name */
    public a f57724f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f57725g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f57726h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f57727i;

    /* renamed from: j  reason: collision with root package name */
    public b f57728j;
    public TextProgressBar k;
    public KsLogoView l;
    public com.kwad.sdk.reward.a m;
    public View n;

    public TailFrameLandscapeVertical(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void a(View view, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.f57725g)) {
            this.m.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2106a(view.getContext()).a(this.f57725g).a(this.f57728j).a(view == this.k).a(view == this.k ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeVertical.this.f57724f != null) {
                        TailFrameLandscapeVertical.this.f57724f.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_vertical, this);
        this.a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
        this.f57720b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
        this.f57721c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
        this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
        this.n = findViewById(R.id.ksad_video_thumb_container);
    }

    private void c() {
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f57726h), this.f57725g);
        KSImageLoader.loadImage(this.f57720b, com.kwad.sdk.core.response.a.a.h(this.f57726h), this.f57725g);
        KSImageLoader.loadImage(this.f57721c, com.kwad.sdk.core.response.a.a.h(this.f57726h), this.f57725g);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f57726h) && !com.kwad.sdk.core.response.a.d.v(this.f57725g)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f57723e = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f57725g);
            this.f57723e.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f57722d = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f57725g);
        this.f57722d.setVisibility(0);
        this.k = this.f57722d.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f57725g)) {
            e();
        }
        new f(this.k, this);
    }

    private void e() {
        this.f57728j = new b(this.f57725g, this.f57727i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                TailFrameLandscapeVertical.this.f57722d.a(TailFrameLandscapeVertical.this.f57726h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.f57722d.a(TailFrameLandscapeVertical.this.f57726h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.f57726h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.f57722d.a(TailFrameLandscapeVertical.this.f57726h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeVertical.this.f57725g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.f57722d.a(TailFrameLandscapeVertical.this.f57726h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.f57726h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.f57722d.a(TailFrameLandscapeVertical.this.f57726h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeVertical.this.f57726h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeVertical.this.f57722d.a(TailFrameLandscapeVertical.this.f57726h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f57728j = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f57722d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.f57722d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f57723e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f57723e.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f57725g = adTemplate;
        this.f57726h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57727i = jSONObject;
        this.f57724f = aVar;
        this.l.a(this.f57725g);
        c();
        d();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f57725g)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.m = aVar;
    }
}
