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
public class TailFrameLandscapeVertical extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f33911a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33912b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33913c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f33914d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f33915e;

    /* renamed from: f  reason: collision with root package name */
    public b f33916f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f33917g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f33918h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f33919i;
    public com.kwad.sdk.core.download.b.b j;
    public TextProgressBar k;
    public KsLogoView l;

    public TailFrameLandscapeVertical(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_vertical, this);
        this.f33911a = (ImageView) findViewById(R.id.ksad_video_thumb_left);
        this.f33912b = (ImageView) findViewById(R.id.ksad_video_thumb_mid);
        this.f33913c = (ImageView) findViewById(R.id.ksad_video_thumb_right);
        this.l = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        KSImageLoader.loadImage(this.f33911a, com.kwad.sdk.core.response.b.a.f(this.f33918h), this.f33917g);
        KSImageLoader.loadImage(this.f33912b, com.kwad.sdk.core.response.b.a.f(this.f33918h), this.f33917g);
        KSImageLoader.loadImage(this.f33913c, com.kwad.sdk.core.response.b.a.f(this.f33918h), this.f33917g);
    }

    private void e() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f33918h)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f33915e = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f33917g);
            this.f33915e.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f33914d = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f33917g);
        this.f33914d.setVisibility(0);
        this.k = this.f33914d.getTextProgressBar();
        f();
        this.k.setOnClickListener(this);
    }

    private void f() {
        this.j = new com.kwad.sdk.core.download.b.b(this.f33917g, this.f33919i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                TailFrameLandscapeVertical.this.f33914d.a(TailFrameLandscapeVertical.this.f33918h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.f33914d.a(TailFrameLandscapeVertical.this.f33918h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeVertical.this.f33918h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.f33914d.a(TailFrameLandscapeVertical.this.f33918h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeVertical.this.f33917g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.f33914d.a(TailFrameLandscapeVertical.this.f33918h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeVertical.this.f33918h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.f33914d.a(TailFrameLandscapeVertical.this.f33918h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.j(TailFrameLandscapeVertical.this.f33918h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeVertical.this.f33914d.a(TailFrameLandscapeVertical.this.f33918h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void g() {
        setOnClickListener(null);
        this.j = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f33917g = adTemplate;
        this.f33918h = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33919i = jSONObject;
        this.f33916f = bVar;
        this.l.a(this.f33917g);
        d();
        e();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f33914d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f33914d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f33915e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f33915e.setVisibility(8);
        }
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33917g, new a.InterfaceC0363a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                if (TailFrameLandscapeVertical.this.f33916f != null) {
                    TailFrameLandscapeVertical.this.f33916f.a();
                }
            }
        }, this.j, view == this.k);
    }
}
