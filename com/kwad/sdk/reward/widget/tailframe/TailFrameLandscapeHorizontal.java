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
    public ImageView f36895a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f36896b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f36897c;

    /* renamed from: d  reason: collision with root package name */
    public b f36898d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36899e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f36900f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f36901g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36902h;
    public TextProgressBar i;
    public KsLogoView j;

    public TailFrameLandscapeHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_view_landscape_horizontal, this);
        this.f36895a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.y(this.f36900f)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f36897c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f36899e);
            this.f36897c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f36896b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f36899e);
        this.f36896b.setVisibility(0);
        this.i = this.f36896b.getTextProgressBar();
        e();
        this.i.setOnClickListener(this);
    }

    private void e() {
        this.f36902h = new com.kwad.sdk.core.download.b.b(this.f36899e, this.f36901g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f36896b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f36899e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f36900f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f36896b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f36899e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeHorizontal.this.f36899e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f36896b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f36899e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.w(TailFrameLandscapeHorizontal.this.f36900f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f36896b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f36899e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.b(), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeHorizontal.this.f36896b.a(com.kwad.sdk.core.response.b.c.j(TailFrameLandscapeHorizontal.this.f36899e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f36902h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f36899e = adTemplate;
        this.f36900f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36901g = jSONObject;
        this.f36898d = bVar;
        this.j.a(this.f36899e);
        KSImageLoader.loadImage(this.f36895a, com.kwad.sdk.core.response.b.a.f(this.f36900f), this.f36899e);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f36896b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f36896b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f36897c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f36897c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.b.a(this.f36902h, view == this.i);
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f36899e, new a.InterfaceC0396a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
            public void a() {
                if (TailFrameLandscapeHorizontal.this.f36898d != null) {
                    TailFrameLandscapeHorizontal.this.f36898d.a();
                }
            }
        }, this.f36902h);
    }
}
