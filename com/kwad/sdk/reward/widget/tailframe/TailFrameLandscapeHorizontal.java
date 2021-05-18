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
    public ImageView f33900a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f33901b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f33902c;

    /* renamed from: d  reason: collision with root package name */
    public b f33903d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33904e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33905f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f33906g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33907h;

    /* renamed from: i  reason: collision with root package name */
    public TextProgressBar f33908i;
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
        this.f33900a = (ImageView) findViewById(R.id.ksad_video_thumb_img);
        this.j = (KsLogoView) findViewById(R.id.ksad_video_tf_logo);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.b.a.v(this.f33905f)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.ksad_video_h5_tail_frame);
            this.f33902c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f33904e);
            this.f33902c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.ksad_video_app_tail_frame);
        this.f33901b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f33904e);
        this.f33901b.setVisibility(0);
        this.f33908i = this.f33901b.getTextProgressBar();
        e();
        this.f33908i.setOnClickListener(this);
    }

    private void e() {
        this.f33907h = new com.kwad.sdk.core.download.b.b(this.f33904e, this.f33906g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                super.a(i2);
                TailFrameLandscapeHorizontal.this.f33901b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33904e));
                TailFrameLandscapeHorizontal.this.f33908i.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f33901b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33904e));
                TailFrameLandscapeHorizontal.this.f33908i.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeHorizontal.this.f33905f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f33901b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33904e));
                TailFrameLandscapeHorizontal.this.f33908i.a(com.kwad.sdk.core.response.b.a.a(TailFrameLandscapeHorizontal.this.f33904e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f33901b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33904e));
                TailFrameLandscapeHorizontal.this.f33908i.a(com.kwad.sdk.core.response.b.a.u(TailFrameLandscapeHorizontal.this.f33905f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f33901b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33904e));
                TailFrameLandscapeHorizontal.this.f33908i.a(com.kwad.sdk.core.response.b.a.j(TailFrameLandscapeHorizontal.this.f33905f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                TailFrameLandscapeHorizontal.this.f33901b.a(com.kwad.sdk.core.response.b.c.g(TailFrameLandscapeHorizontal.this.f33904e));
                TailFrameLandscapeHorizontal.this.f33908i.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.f33907h = null;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public View a() {
        return this;
    }

    @Override // com.kwad.sdk.reward.widget.tailframe.a
    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.f33904e = adTemplate;
        this.f33905f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33906g = jSONObject;
        this.f33903d = bVar;
        this.j.a(this.f33904e);
        KSImageLoader.loadImage(this.f33900a, com.kwad.sdk.core.response.b.a.f(this.f33905f), this.f33904e);
        d();
        setOnClickListener(this);
    }

    public void b() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f33901b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.a();
            this.f33901b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f33902c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f33902c.setVisibility(8);
        }
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f33904e, new a.InterfaceC0363a() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                if (TailFrameLandscapeHorizontal.this.f33903d != null) {
                    TailFrameLandscapeHorizontal.this.f33903d.a();
                }
            }
        }, this.f33907h, view == this.f33908i);
    }
}
