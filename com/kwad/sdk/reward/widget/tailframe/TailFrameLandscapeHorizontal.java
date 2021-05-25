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
    public ImageView f33829a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f33830b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f33831c;

    /* renamed from: d  reason: collision with root package name */
    public b f33832d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33833e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33834f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f33835g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33836h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f33837i;
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
        this.f33829a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f33834f)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f33831c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f33833e);
            this.f33831c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f33830b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f33833e);
        this.f33830b.setVisibility(0);
        this.f33837i = this.f33830b.getTextProgressBar();
        e();
        this.f33837i.setOnClickListener(this);
    }

    private void e() {
        this.f33836h = new com.kwad.sdk.core.download.b.b(this.f33833e, this.f33835g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                super.a(i2);
                TailFrameLandscapeHorizontal.this.f33830b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33833e));
                TailFrameLandscapeHorizontal.this.f33837i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f33830b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33833e));
                TailFrameLandscapeHorizontal.this.f33837i.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeHorizontal.this.f33834f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f33830b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33833e));
                TailFrameLandscapeHorizontal.this.f33837i.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeHorizontal.this.f33833e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f33830b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33833e));
                TailFrameLandscapeHorizontal.this.f33837i.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeHorizontal.this.f33834f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f33830b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33833e));
                TailFrameLandscapeHorizontal.this.f33837i.a(com.kwad.sdk.core.response.b.a.j(TailFrameLandscapeHorizontal.this.f33834f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeHorizontal.this.f33830b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33833e));
                TailFrameLandscapeHorizontal.this.f33837i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f33836h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f33833e = adTemplate;
        this.f33834f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33835g = jSONObject;
        this.f33832d = bVar;
        this.j.a(this.f33833e);
        KSImageLoader.loadImage(this.f33829a, com.kwad.sdk.core.response.b.a.f(this.f33834f), this.f33833e);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f33830b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f33830b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f33831c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f33831c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33833e, new a.InterfaceC0364a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                if (TailFrameLandscapeHorizontal.this.f33832d != null) {
                    TailFrameLandscapeHorizontal.this.f33832d.a();
                }
            }
        }, this.f33836h, view == this.f33837i);
    }
}
