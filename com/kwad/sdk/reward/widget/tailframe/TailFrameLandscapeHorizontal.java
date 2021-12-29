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
public class TailFrameLandscapeHorizontal extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f59933b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f59934c;

    /* renamed from: d  reason: collision with root package name */
    public a f59935d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59936e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f59937f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f59938g;

    /* renamed from: h  reason: collision with root package name */
    public b f59939h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f59940i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f59941j;

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.reward.a f59942k;

    public TailFrameLandscapeHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void a(View view, final boolean z) {
        int i2 = z ? 1 : 153;
        if (com.kwad.sdk.core.response.a.d.v(this.f59936e)) {
            this.f59942k.a(getContext(), i2, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.f59936e).a(this.f59939h).a(view == this.f59940i).a(view == this.f59940i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeHorizontal.this.f59935d != null) {
                        TailFrameLandscapeHorizontal.this.f59935d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
        this.a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.f59941j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void c() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f59937f) && !com.kwad.sdk.core.response.a.d.v(this.f59936e)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f59934c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f59936e);
            this.f59934c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f59933b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f59936e);
        this.f59933b.setVisibility(0);
        this.f59940i = this.f59933b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f59936e)) {
            d();
        }
        new f(this.f59940i, this);
    }

    private void d() {
        this.f59939h = new b(this.f59936e, this.f59938g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                super.a(i2);
                TailFrameLandscapeHorizontal.this.f59933b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f59936e));
                TailFrameLandscapeHorizontal.this.f59940i.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f59933b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f59936e));
                TailFrameLandscapeHorizontal.this.f59940i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f59937f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f59933b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f59936e));
                TailFrameLandscapeHorizontal.this.f59940i.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeHorizontal.this.f59936e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f59933b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f59936e));
                TailFrameLandscapeHorizontal.this.f59940i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f59937f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f59933b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f59936e));
                TailFrameLandscapeHorizontal.this.f59940i.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeHorizontal.this.f59937f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeHorizontal.this.f59933b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f59936e));
                TailFrameLandscapeHorizontal.this.f59940i.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    private void e() {
        setOnClickListener(null);
        this.f59939h = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f59933b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.f59933b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f59934c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f59934c.setVisibility(8);
        }
        e();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f59936e = adTemplate;
        this.f59937f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f59938g = jSONObject;
        this.f59935d = aVar;
        this.f59941j.a(this.f59936e);
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f59937f), this.f59936e);
        c();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f59936e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.f59942k = aVar;
    }
}
