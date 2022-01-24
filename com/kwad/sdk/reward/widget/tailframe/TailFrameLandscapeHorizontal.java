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
    public TailFrameBarAppLandscape f57709b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f57710c;

    /* renamed from: d  reason: collision with root package name */
    public a f57711d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57712e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f57713f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f57714g;

    /* renamed from: h  reason: collision with root package name */
    public b f57715h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f57716i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f57717j;
    public com.kwad.sdk.reward.a k;

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
        if (com.kwad.sdk.core.response.a.d.v(this.f57712e)) {
            this.k.a(getContext(), i2, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2106a(view.getContext()).a(this.f57712e).a(this.f57715h).a(view == this.f57716i).a(view == this.f57716i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeHorizontal.this.f57711d != null) {
                        TailFrameLandscapeHorizontal.this.f57711d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
        this.a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.f57717j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void c() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f57713f) && !com.kwad.sdk.core.response.a.d.v(this.f57712e)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f57710c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f57712e);
            this.f57710c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f57709b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f57712e);
        this.f57709b.setVisibility(0);
        this.f57716i = this.f57709b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f57712e)) {
            d();
        }
        new f(this.f57716i, this);
    }

    private void d() {
        this.f57715h = new b(this.f57712e, this.f57714g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                super.a(i2);
                TailFrameLandscapeHorizontal.this.f57709b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f57712e));
                TailFrameLandscapeHorizontal.this.f57716i.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f57709b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f57712e));
                TailFrameLandscapeHorizontal.this.f57716i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f57713f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f57709b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f57712e));
                TailFrameLandscapeHorizontal.this.f57716i.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeHorizontal.this.f57712e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f57709b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f57712e));
                TailFrameLandscapeHorizontal.this.f57716i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f57713f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f57709b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f57712e));
                TailFrameLandscapeHorizontal.this.f57716i.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeHorizontal.this.f57713f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeHorizontal.this.f57709b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f57712e));
                TailFrameLandscapeHorizontal.this.f57716i.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
            }
        });
    }

    private void e() {
        setOnClickListener(null);
        this.f57715h = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f57709b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.f57709b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f57710c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f57710c.setVisibility(8);
        }
        e();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f57712e = adTemplate;
        this.f57713f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f57714g = jSONObject;
        this.f57711d = aVar;
        this.f57717j.a(this.f57712e);
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f57713f), this.f57712e);
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
        if (com.kwad.sdk.core.response.a.c.g(this.f57712e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
