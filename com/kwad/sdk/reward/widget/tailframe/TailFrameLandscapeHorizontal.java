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
/* loaded from: classes7.dex */
public class TailFrameLandscapeHorizontal extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37356a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f37357b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f37358c;

    /* renamed from: d  reason: collision with root package name */
    public b f37359d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37360e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f37361f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f37362g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37363h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f37364i;
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
        this.f37356a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f37361f)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f37358c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f37360e);
            this.f37358c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f37357b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f37360e);
        this.f37357b.setVisibility(0);
        this.f37364i = this.f37357b.getTextProgressBar();
        e();
        this.f37364i.setOnClickListener(this);
    }

    private void e() {
        this.f37363h = new com.kwad.sdk.core.download.b.b(this.f37360e, this.f37362g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f37357b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37360e));
                TailFrameLandscapeHorizontal.this.f37364i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f37361f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f37357b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37360e));
                TailFrameLandscapeHorizontal.this.f37364i.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeHorizontal.this.f37360e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f37357b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37360e));
                TailFrameLandscapeHorizontal.this.f37364i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f37361f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f37357b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37360e));
                TailFrameLandscapeHorizontal.this.f37364i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeHorizontal.this.f37357b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f37360e));
                TailFrameLandscapeHorizontal.this.f37364i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f37363h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f37360e = adTemplate;
        this.f37361f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37362g = jSONObject;
        this.f37359d = bVar;
        this.j.a(this.f37360e);
        KSImageLoader.loadImage(this.f37356a, com.kwad.sdk.core.response.b.a.f(this.f37361f), this.f37360e);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f37357b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f37357b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f37358c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f37358c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.f37363h, view == this.f37364i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37360e, new a.InterfaceC0382a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                if (TailFrameLandscapeHorizontal.this.f37359d != null) {
                    TailFrameLandscapeHorizontal.this.f37359d.a();
                }
            }
        }, this.f37363h);
    }
}
